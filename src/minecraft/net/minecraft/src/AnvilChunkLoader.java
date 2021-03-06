package net.minecraft.src;

import java.io.*;
import java.util.*;

public class AnvilChunkLoader implements IThreadedFileIO, IChunkLoader
{
    private List chunksToRemove;
    private Set pendingAnvilChunksCoordinates;
    private Object syncLockObject;

    /** Save directory for chunks using the Anvil format */
    private final File chunkSaveLocation;

    public AnvilChunkLoader(File par1File)
    {
        chunksToRemove = new ArrayList();
        pendingAnvilChunksCoordinates = new HashSet();
        syncLockObject = new Object();
        chunkSaveLocation = par1File;
    }

    /**
     * Loads the specified(XZ) chunk into the specified world.
     */
    public Chunk loadChunk(World par1World, int par2, int par3) throws IOException
    {
        NBTTagCompound nbttagcompound;
        nbttagcompound = null;
        ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(par2, par3);

        synchronized (syncLockObject)
        {
            label0:
            {
                if (!pendingAnvilChunksCoordinates.contains(chunkcoordintpair))
                {
                    break label0;
                }

                Iterator iterator = chunksToRemove.iterator();
                AnvilChunkLoaderPending anvilchunkloaderpending;

                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }

                    anvilchunkloaderpending = (AnvilChunkLoaderPending)iterator.next();
                }
                while (!anvilchunkloaderpending.chunkCoordinate.equals(chunkcoordintpair));

                nbttagcompound = anvilchunkloaderpending.nbtTags;
            }
        }

        if (nbttagcompound == null)
        {
            java.io.DataInputStream datainputstream = RegionFileCache.getChunkInputStream(chunkSaveLocation, par2, par3);

            if (datainputstream != null)
            {
                nbttagcompound = CompressedStreamTools.read(datainputstream);
            }
            else
            {
                return null;
            }
        }

        return checkedReadChunkFromNBT(par1World, par2, par3, nbttagcompound);
    }

    /**
     * wraps readChunkFromNBT. checks the coordinates, and several NBT tags
     */
    protected Chunk checkedReadChunkFromNBT(World par1World, int par2, int par3, NBTTagCompound par4NBTTagCompound)
    {
        if (!par4NBTTagCompound.hasKey("Level"))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(par2).append(",").append(par3).append(" is missing level data, skipping").toString());
            return null;
        }

        if (!par4NBTTagCompound.getCompoundTag("Level").hasKey("Sections"))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(par2).append(",").append(par3).append(" is missing block data, skipping").toString());
            return null;
        }

        Chunk chunk = readChunkFromNBT(par1World, par4NBTTagCompound.getCompoundTag("Level"));

        if (!chunk.isAtLocation(par2, par3))
        {
            System.out.println((new StringBuilder()).append("Chunk file at ").append(par2).append(",").append(par3).append(" is in the wrong location; relocating. (Expected ").append(par2).append(", ").append(par3).append(", got ").append(chunk.xPosition).append(", ").append(chunk.zPosition).append(")").toString());
            par4NBTTagCompound.setInteger("xPos", par2);
            par4NBTTagCompound.setInteger("zPos", par3);
            chunk = readChunkFromNBT(par1World, par4NBTTagCompound.getCompoundTag("Level"));
        }

        return chunk;
    }

    public void saveChunk(World par1World, Chunk par2Chunk) throws MinecraftException, IOException
    {
        par1World.checkSessionLock();

        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound.setTag("Level", nbttagcompound1);
            writeChunkToNBT(par2Chunk, par1World, nbttagcompound1);
            func_75824_a(par2Chunk.getChunkCoordIntPair(), nbttagcompound);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    protected void func_75824_a(ChunkCoordIntPair par1ChunkCoordIntPair, NBTTagCompound par2NBTTagCompound)
    {
        synchronized (syncLockObject)
        {
            if (pendingAnvilChunksCoordinates.contains(par1ChunkCoordIntPair))
            {
                for (int i = 0; i < chunksToRemove.size(); i++)
                {
                    if (((AnvilChunkLoaderPending)chunksToRemove.get(i)).chunkCoordinate.equals(par1ChunkCoordIntPair))
                    {
                        chunksToRemove.set(i, new AnvilChunkLoaderPending(par1ChunkCoordIntPair, par2NBTTagCompound));
                        return;
                    }
                }
            }

            chunksToRemove.add(new AnvilChunkLoaderPending(par1ChunkCoordIntPair, par2NBTTagCompound));
            pendingAnvilChunksCoordinates.add(par1ChunkCoordIntPair);
            ThreadedFileIOBase.threadedIOInstance.queueIO(this);
        }
    }

    /**
     * Returns a boolean stating if the write was unsuccessful.
     */
    public boolean writeNextIO()
    {
        AnvilChunkLoaderPending anvilchunkloaderpending = null;

        synchronized (syncLockObject)
        {
            if (!chunksToRemove.isEmpty())
            {
                anvilchunkloaderpending = (AnvilChunkLoaderPending)chunksToRemove.remove(0);
                pendingAnvilChunksCoordinates.remove(anvilchunkloaderpending.chunkCoordinate);
            }
            else
            {
                return false;
            }
        }

        if (anvilchunkloaderpending != null)
        {
            try
            {
                writeChunkNBTTags(anvilchunkloaderpending);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        return true;
    }

    private void writeChunkNBTTags(AnvilChunkLoaderPending par1AnvilChunkLoaderPending) throws IOException
    {
        DataOutputStream dataoutputstream = RegionFileCache.getChunkOutputStream(chunkSaveLocation, par1AnvilChunkLoaderPending.chunkCoordinate.chunkXPos, par1AnvilChunkLoaderPending.chunkCoordinate.chunkZPos);
        CompressedStreamTools.write(par1AnvilChunkLoaderPending.nbtTags, dataoutputstream);
        dataoutputstream.close();
    }

    /**
     * Save extra data associated with this Chunk not normally saved during autosave, only during chunk unload.
     * Currently unused.
     */
    public void saveExtraChunkData(World world, Chunk chunk)
    {
    }

    /**
     * Called every World.tick()
     */
    public void chunkTick()
    {
    }

    /**
     * Save extra data not associated with any Chunk.  Not saved during autosave, only during world unload.  Currently
     * unused.
     */
    public void saveExtraData()
    {
    }

    /**
     * Writes the Chunk passed as an argument to the NBTTagCompound also passed, using the World argument to retrieve
     * the Chunk's last update time.
     */
    private void writeChunkToNBT(Chunk par1Chunk, World par2World, NBTTagCompound par3NBTTagCompound)
    {
        par3NBTTagCompound.setInteger("xPos", par1Chunk.xPosition);
        par3NBTTagCompound.setInteger("zPos", par1Chunk.zPosition);
        par3NBTTagCompound.setLong("LastUpdate", par2World.getWorldTime());
        par3NBTTagCompound.setIntArray("HeightMap", par1Chunk.heightMap);
        par3NBTTagCompound.setBoolean("TerrainPopulated", par1Chunk.isTerrainPopulated);
        ExtendedBlockStorage aextendedblockstorage[] = par1Chunk.getBlockStorageArray();
        NBTTagList nbttaglist = new NBTTagList("Sections");
        ExtendedBlockStorage aextendedblockstorage1[] = aextendedblockstorage;
        int i = aextendedblockstorage1.length;

        for (int k = 0; k < i; k++)
        {
            ExtendedBlockStorage extendedblockstorage = aextendedblockstorage1[k];

            if (extendedblockstorage == null)
            {
                continue;
            }

            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.setByte("Y", (byte)(extendedblockstorage.getYLocation() >> 4 & 0xff));
            nbttagcompound.setByteArray("Blocks", extendedblockstorage.getBlockLSBArray());

            if (extendedblockstorage.getBlockMSBArray() != null)
            {
                nbttagcompound.setByteArray("Add", extendedblockstorage.getBlockMSBArray().data);
            }

            nbttagcompound.setByteArray("Data", extendedblockstorage.getMetadataArray().data);
            nbttagcompound.setByteArray("SkyLight", extendedblockstorage.getSkylightArray().data);
            nbttagcompound.setByteArray("BlockLight", extendedblockstorage.getBlocklightArray().data);
            nbttaglist.appendTag(nbttagcompound);
        }

        par3NBTTagCompound.setTag("Sections", nbttaglist);
        par3NBTTagCompound.setByteArray("Biomes", par1Chunk.getBiomeArray());
        par1Chunk.hasEntities = false;
        NBTTagList nbttaglist1 = new NBTTagList();
        label0:

        for (int j = 0; j < par1Chunk.entityLists.length; j++)
        {
            Iterator iterator = par1Chunk.entityLists[j].iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    continue label0;
                }

                Entity entity = (Entity)iterator.next();
                par1Chunk.hasEntities = true;
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();

                if (entity.addEntityID(nbttagcompound1))
                {
                    nbttaglist1.appendTag(nbttagcompound1);
                }
            }
            while (true);
        }

        par3NBTTagCompound.setTag("Entities", nbttaglist1);
        NBTTagList nbttaglist2 = new NBTTagList();
        NBTTagCompound nbttagcompound2;

        for (Iterator iterator1 = par1Chunk.chunkTileEntityMap.values().iterator(); iterator1.hasNext(); nbttaglist2.appendTag(nbttagcompound2))
        {
            TileEntity tileentity = (TileEntity)iterator1.next();
            nbttagcompound2 = new NBTTagCompound();
            tileentity.writeToNBT(nbttagcompound2);
        }

        par3NBTTagCompound.setTag("TileEntities", nbttaglist2);
        List list = par2World.getPendingBlockUpdates(par1Chunk, false);

        if (list != null)
        {
            long l = par2World.getWorldTime();
            NBTTagList nbttaglist3 = new NBTTagList();
            NBTTagCompound nbttagcompound3;

            for (Iterator iterator2 = list.iterator(); iterator2.hasNext(); nbttaglist3.appendTag(nbttagcompound3))
            {
                NextTickListEntry nextticklistentry = (NextTickListEntry)iterator2.next();
                nbttagcompound3 = new NBTTagCompound();
                nbttagcompound3.setInteger("i", nextticklistentry.blockID);
                nbttagcompound3.setInteger("x", nextticklistentry.xCoord);
                nbttagcompound3.setInteger("y", nextticklistentry.yCoord);
                nbttagcompound3.setInteger("z", nextticklistentry.zCoord);
                nbttagcompound3.setInteger("t", (int)(nextticklistentry.scheduledTime - l));
            }

            par3NBTTagCompound.setTag("TileTicks", nbttaglist3);
        }
    }

    /**
     * Reads the data stored in the passed NBTTagCompound and creates a Chunk with that data in the passed World.
     * Returns the created Chunk.
     */
    private Chunk readChunkFromNBT(World par1World, NBTTagCompound par2NBTTagCompound)
    {
        int i = par2NBTTagCompound.getInteger("xPos");
        int j = par2NBTTagCompound.getInteger("zPos");
        Chunk chunk = new Chunk(par1World, i, j);
        chunk.heightMap = par2NBTTagCompound.getIntArray("HeightMap");
        chunk.isTerrainPopulated = par2NBTTagCompound.getBoolean("TerrainPopulated");
        NBTTagList nbttaglist = par2NBTTagCompound.getTagList("Sections");
        byte byte0 = 16;
        ExtendedBlockStorage aextendedblockstorage[] = new ExtendedBlockStorage[byte0];

        for (int k = 0; k < nbttaglist.tagCount(); k++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(k);
            byte byte1 = nbttagcompound.getByte("Y");
            ExtendedBlockStorage extendedblockstorage = new ExtendedBlockStorage(byte1 << 4);
            extendedblockstorage.setBlockLSBArray(nbttagcompound.getByteArray("Blocks"));

            if (nbttagcompound.hasKey("Add"))
            {
                extendedblockstorage.setBlockMSBArray(new NibbleArray(nbttagcompound.getByteArray("Add"), 4));
            }

            extendedblockstorage.setBlockMetadataArray(new NibbleArray(nbttagcompound.getByteArray("Data"), 4));
            extendedblockstorage.setSkylightArray(new NibbleArray(nbttagcompound.getByteArray("SkyLight"), 4));
            extendedblockstorage.setBlocklightArray(new NibbleArray(nbttagcompound.getByteArray("BlockLight"), 4));
            extendedblockstorage.removeInvalidBlocks();
            aextendedblockstorage[byte1] = extendedblockstorage;
        }

        chunk.setStorageArrays(aextendedblockstorage);

        if (par2NBTTagCompound.hasKey("Biomes"))
        {
            chunk.setBiomeArray(par2NBTTagCompound.getByteArray("Biomes"));
        }

        NBTTagList nbttaglist1 = par2NBTTagCompound.getTagList("Entities");

        if (nbttaglist1 != null)
        {
            for (int l = 0; l < nbttaglist1.tagCount(); l++)
            {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist1.tagAt(l);
                Entity entity = EntityList.createEntityFromNBT(nbttagcompound1, par1World);
                chunk.hasEntities = true;

                if (entity != null)
                {
                    chunk.addEntity(entity);
                }
            }
        }

        NBTTagList nbttaglist2 = par2NBTTagCompound.getTagList("TileEntities");

        if (nbttaglist2 != null)
        {
            for (int i1 = 0; i1 < nbttaglist2.tagCount(); i1++)
            {
                NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist2.tagAt(i1);
                TileEntity tileentity = TileEntity.createAndLoadEntity(nbttagcompound2);

                if (tileentity != null)
                {
                    chunk.addTileEntity(tileentity);
                }
            }
        }

        if (par2NBTTagCompound.hasKey("TileTicks"))
        {
            NBTTagList nbttaglist3 = par2NBTTagCompound.getTagList("TileTicks");

            if (nbttaglist3 != null)
            {
                for (int j1 = 0; j1 < nbttaglist3.tagCount(); j1++)
                {
                    NBTTagCompound nbttagcompound3 = (NBTTagCompound)nbttaglist3.tagAt(j1);
                    par1World.scheduleBlockUpdateFromLoad(nbttagcompound3.getInteger("x"), nbttagcompound3.getInteger("y"), nbttagcompound3.getInteger("z"), nbttagcompound3.getInteger("i"), nbttagcompound3.getInteger("t"));
                }
            }
        }

        return chunk;
    }
}
