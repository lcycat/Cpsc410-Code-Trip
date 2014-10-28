package net.minecraft.src;

import java.io.IOException;
import java.util.*;

public class ChunkProviderServer implements IChunkProvider
{
    /**
     * used by unload100OldestChunks to iterate the loadedChunkHashMap for unload (underlying assumption, first in,
     * first out)
     */
    private Set chunksToUnload;
    private Chunk defaultEmptyChunk;
    private IChunkProvider currentChunkProvider;
    private IChunkLoader currentChunkLoader;

    /**
     * if this is false, the defaultEmptyChunk will be returned by the provider
     */
    public boolean loadChunkOnProvideRequest;
    private LongHashMap loadedChunkHashMap;
    private List loadedChunks;
    private WorldServer currentServer;

    public ChunkProviderServer(WorldServer par1WorldServer, IChunkLoader par2IChunkLoader, IChunkProvider par3IChunkProvider)
    {
        chunksToUnload = new HashSet();
        loadChunkOnProvideRequest = true;
        loadedChunkHashMap = new LongHashMap();
        loadedChunks = new ArrayList();
        defaultEmptyChunk = new EmptyChunk(par1WorldServer, 0, 0);
        currentServer = par1WorldServer;
        currentChunkLoader = par2IChunkLoader;
        currentChunkProvider = par3IChunkProvider;
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int par1, int par2)
    {
        return loadedChunkHashMap.containsItem(ChunkCoordIntPair.chunkXZ2Int(par1, par2));
    }

    /**
     * marks chunk for unload by "unload100OldestChunks"  if there is no spawn point, or if the center of the chunk is
     * outside 200 blocks (x or z) of the spawn
     */
    public void unloadChunksIfNotNearSpawn(int par1, int par2)
    {
        if (currentServer.provider.canRespawnHere())
        {
            ChunkCoordinates chunkcoordinates = currentServer.getSpawnPoint();
            int i = (par1 * 16 + 8) - chunkcoordinates.posX;
            int j = (par2 * 16 + 8) - chunkcoordinates.posZ;
            char c = '\200';

            if (i < -c || i > c || j < -c || j > c)
            {
                chunksToUnload.add(Long.valueOf(ChunkCoordIntPair.chunkXZ2Int(par1, par2)));
            }
        }
        else
        {
            chunksToUnload.add(Long.valueOf(ChunkCoordIntPair.chunkXZ2Int(par1, par2)));
        }
    }

    /**
     * marks all chunks for unload, ignoring those near the spawn
     */
    public void unloadAllChunks()
    {
        Chunk chunk;

        for (Iterator iterator = loadedChunks.iterator(); iterator.hasNext(); unloadChunksIfNotNearSpawn(chunk.xPosition, chunk.zPosition))
        {
            chunk = (Chunk)iterator.next();
        }
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int par1, int par2)
    {
        long l = ChunkCoordIntPair.chunkXZ2Int(par1, par2);
        chunksToUnload.remove(Long.valueOf(l));
        Chunk chunk = (Chunk)loadedChunkHashMap.getValueByKey(l);

        if (chunk == null)
        {
            chunk = safeLoadChunk(par1, par2);

            if (chunk == null)
            {
                if (currentChunkProvider == null)
                {
                    chunk = defaultEmptyChunk;
                }
                else
                {
                    chunk = currentChunkProvider.provideChunk(par1, par2);
                }
            }

            loadedChunkHashMap.add(l, chunk);
            loadedChunks.add(chunk);

            if (chunk != null)
            {
                chunk.onChunkLoad();
            }

            chunk.populateChunk(this, this, par1, par2);
        }

        return chunk;
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int par1, int par2)
    {
        Chunk chunk = (Chunk)loadedChunkHashMap.getValueByKey(ChunkCoordIntPair.chunkXZ2Int(par1, par2));

        if (chunk == null)
        {
            if (currentServer.findingSpawnPoint || loadChunkOnProvideRequest)
            {
                return loadChunk(par1, par2);
            }
            else
            {
                return defaultEmptyChunk;
            }
        }
        else
        {
            return chunk;
        }
    }

    /**
     * used by loadChunk, but catches any exceptions if the load fails.
     */
    private Chunk safeLoadChunk(int par1, int par2)
    {
        if (currentChunkLoader == null)
        {
            return null;
        }

        try
        {
            Chunk chunk = currentChunkLoader.loadChunk(currentServer, par1, par2);

            if (chunk != null)
            {
                chunk.lastSaveTime = currentServer.getWorldTime();
            }

            return chunk;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return null;
    }

    /**
     * used by saveChunks, but catches any exceptions if the save fails.
     */
    private void safeSaveExtraChunkData(Chunk par1Chunk)
    {
        if (currentChunkLoader == null)
        {
            return;
        }

        try
        {
            currentChunkLoader.saveExtraChunkData(currentServer, par1Chunk);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * used by saveChunks, but catches any exceptions if the save fails.
     */
    private void safeSaveChunk(Chunk par1Chunk)
    {
        if (currentChunkLoader == null)
        {
            return;
        }

        try
        {
            par1Chunk.lastSaveTime = currentServer.getWorldTime();
            currentChunkLoader.saveChunk(currentServer, par1Chunk);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        catch (MinecraftException minecraftexception)
        {
            minecraftexception.printStackTrace();
        }
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
    {
        Chunk chunk = provideChunk(par2, par3);

        if (!chunk.isTerrainPopulated)
        {
            chunk.isTerrainPopulated = true;

            if (currentChunkProvider != null)
            {
                currentChunkProvider.populate(par1IChunkProvider, par2, par3);
                ModLoader.populateChunk(currentChunkProvider, par2, par3, currentServer);
                chunk.setChunkModified();
            }
        }
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
    {
        int i = 0;

        for (Iterator iterator = loadedChunks.iterator(); iterator.hasNext();)
        {
            Chunk chunk = (Chunk)iterator.next();

            if (par1)
            {
                safeSaveExtraChunkData(chunk);
            }

            if (chunk.needsSaving(par1))
            {
                safeSaveChunk(chunk);
                chunk.isModified = false;

                if (++i == 24 && !par1)
                {
                    return false;
                }
            }
        }

        if (par1)
        {
            if (currentChunkLoader == null)
            {
                return true;
            }

            currentChunkLoader.saveExtraData();
        }

        return true;
    }

    /**
     * Unloads the 100 oldest chunks from memory, due to a bug with chunkSet.add() never being called it thinks the list
     * is always empty and will not remove any chunks.
     */
    public boolean unload100OldestChunks()
    {
        if (!currentServer.canNotSave)
        {
            for (int i = 0; i < 100; i++)
            {
                if (!chunksToUnload.isEmpty())
                {
                    Long long1 = (Long)chunksToUnload.iterator().next();
                    Chunk chunk = (Chunk)loadedChunkHashMap.getValueByKey(long1.longValue());
                    chunk.onChunkUnload();
                    safeSaveChunk(chunk);
                    safeSaveExtraChunkData(chunk);
                    chunksToUnload.remove(long1);
                    loadedChunkHashMap.remove(long1.longValue());
                    loadedChunks.remove(chunk);
                }
            }

            if (currentChunkLoader != null)
            {
                currentChunkLoader.chunkTick();
            }
        }

        return currentChunkProvider.unload100OldestChunks();
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return !currentServer.canNotSave;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return (new StringBuilder()).append("ServerChunkCache: ").append(loadedChunkHashMap.getNumHashElements()).append(" Drop: ").append(chunksToUnload.size()).toString();
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
    {
        return currentChunkProvider.getPossibleCreatures(par1EnumCreatureType, par2, par3, par4);
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5)
    {
        return currentChunkProvider.findClosestStructure(par1World, par2Str, par3, par4, par5);
    }

    public int getLoadedChunkCount()
    {
        return loadedChunkHashMap.getNumHashElements();
    }
}
