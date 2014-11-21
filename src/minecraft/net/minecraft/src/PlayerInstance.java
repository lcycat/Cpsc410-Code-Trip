package net.minecraft.src;

import java.util.*;

class PlayerInstance
{
    private final List playersInChunk = new ArrayList();

    /** note: this is final */
    private final ChunkCoordIntPair chunkLocation;
    private short locationOfBlockChange[];
    private int numberOfTilesToUpdate;
    private int field_73260_f;
    final PlayerManager myManager;

    public PlayerInstance(PlayerManager par1PlayerManager, int par2, int par3)
    {
        myManager = par1PlayerManager;
        locationOfBlockChange = new short[64];
        numberOfTilesToUpdate = 0;
        chunkLocation = new ChunkCoordIntPair(par2, par3);
        par1PlayerManager.getWorldServer().theChunkProviderServer.loadChunk(par2, par3);
    }

    /**
     * called for all chunks within the visible radius of the player
     */
    public void addPlayerToChunkWatchingList(EntityPlayerMP par1EntityPlayerMP)
    {
        if (playersInChunk.contains(par1EntityPlayerMP))
        {
            throw new IllegalStateException((new StringBuilder()).append("Failed to add player. ").append(par1EntityPlayerMP).append(" already is in chunk ").append(chunkLocation.chunkXPos).append(", ").append(chunkLocation.chunkZPos).toString());
        }
        else
        {
            playersInChunk.add(par1EntityPlayerMP);
            par1EntityPlayerMP.chunksToLoad.add(chunkLocation);
            return;
        }
    }

    public void sendThisChunkToPlayer(EntityPlayerMP par1EntityPlayerMP)
    {
        if (!playersInChunk.contains(par1EntityPlayerMP))
        {
            return;
        }

        par1EntityPlayerMP.serverForThisPlayer.sendPacketToPlayer(new Packet51MapChunk(PlayerManager.getWorldServer(myManager).getChunkFromChunkCoords(chunkLocation.chunkXPos, chunkLocation.chunkZPos), true, 0));
        playersInChunk.remove(par1EntityPlayerMP);
        par1EntityPlayerMP.chunksToLoad.remove(chunkLocation);

        if (playersInChunk.isEmpty())
        {
            long l = (long)chunkLocation.chunkXPos + 0x7fffffffL | (long)chunkLocation.chunkZPos + 0x7fffffffL << 32;
            PlayerManager.getChunkWatchers(myManager).remove(l);

            if (numberOfTilesToUpdate > 0)
            {
                PlayerManager.getChunkWatchersWithPlayers(myManager).remove(this);
            }

            myManager.getWorldServer().theChunkProviderServer.unloadChunksIfNotNearSpawn(chunkLocation.chunkXPos, chunkLocation.chunkZPos);
        }
    }

    public void flagChunkForUpdate(int par1, int par2, int par3)
    {
        if (numberOfTilesToUpdate == 0)
        {
            PlayerManager.getChunkWatchersWithPlayers(myManager).add(this);
        }

        field_73260_f |= 1 << (par2 >> 4);

        if (numberOfTilesToUpdate < 64)
        {
            short word0 = (short)(par1 << 12 | par3 << 8 | par2);

            for (int i = 0; i < numberOfTilesToUpdate; i++)
            {
                if (locationOfBlockChange[i] == word0)
                {
                    return;
                }
            }

            locationOfBlockChange[numberOfTilesToUpdate++] = word0;
        }
    }

    public void sendToAllPlayersWatchingChunk(Packet par1Packet)
    {
        Iterator iterator = playersInChunk.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (!entityplayermp.chunksToLoad.contains(chunkLocation))
            {
                entityplayermp.serverForThisPlayer.sendPacketToPlayer(par1Packet);
            }
        }
        while (true);
    }

    public void sendChunkUpdate()
    {
        if (numberOfTilesToUpdate == 0)
        {
            return;
        }

        if (numberOfTilesToUpdate == 1)
        {
            int i = chunkLocation.chunkXPos * 16 + (locationOfBlockChange[0] >> 12 & 0xf);
            int l = locationOfBlockChange[0] & 0xff;
            int k1 = chunkLocation.chunkZPos * 16 + (locationOfBlockChange[0] >> 8 & 0xf);
            sendToAllPlayersWatchingChunk(new Packet53BlockChange(i, l, k1, PlayerManager.getWorldServer(myManager)));

            if (PlayerManager.getWorldServer(myManager).blockHasTileEntity(i, l, k1))
            {
                sendTileToAllPlayersWatchingChunk(PlayerManager.getWorldServer(myManager).getBlockTileEntity(i, l, k1));
            }
        }
        else if (numberOfTilesToUpdate == 64)
        {
            int j = chunkLocation.chunkXPos * 16;
            int i1 = chunkLocation.chunkZPos * 16;
            sendToAllPlayersWatchingChunk(new Packet51MapChunk(PlayerManager.getWorldServer(myManager).getChunkFromChunkCoords(chunkLocation.chunkXPos, chunkLocation.chunkZPos), false, field_73260_f));

            for (int l1 = 0; l1 < 16; l1++)
            {
                if ((field_73260_f & 1 << l1) != 0)
                {
                    int j2 = l1 << 4;
                    List list = PlayerManager.getWorldServer(myManager).getAllTileEntityInBox(j, j2, i1, j + 16, j2 + 16, i1 + 16);
                    TileEntity tileentity;

                    for (Iterator iterator = list.iterator(); iterator.hasNext(); sendTileToAllPlayersWatchingChunk(tileentity))
                    {
                        tileentity = (TileEntity)iterator.next();
                    }
                }
            }
        }
        else
        {
            sendToAllPlayersWatchingChunk(new Packet52MultiBlockChange(chunkLocation.chunkXPos, chunkLocation.chunkZPos, locationOfBlockChange, numberOfTilesToUpdate, PlayerManager.getWorldServer(myManager)));

            for (int k = 0; k < numberOfTilesToUpdate; k++)
            {
                int j1 = chunkLocation.chunkXPos * 16 + (locationOfBlockChange[k] >> 12 & 0xf);
                int i2 = locationOfBlockChange[k] & 0xff;
                int k2 = chunkLocation.chunkZPos * 16 + (locationOfBlockChange[k] >> 8 & 0xf);

                if (PlayerManager.getWorldServer(myManager).blockHasTileEntity(j1, i2, k2))
                {
                    sendTileToAllPlayersWatchingChunk(PlayerManager.getWorldServer(myManager).getBlockTileEntity(j1, i2, k2));
                }
            }
        }

        numberOfTilesToUpdate = 0;
        field_73260_f = 0;
    }

    private void sendTileToAllPlayersWatchingChunk(TileEntity par1TileEntity)
    {
        if (par1TileEntity != null)
        {
            Packet packet = par1TileEntity.getAuxillaryInfoPacket();

            if (packet != null)
            {
                sendToAllPlayersWatchingChunk(packet);
            }
        }
    }

    static ChunkCoordIntPair getChunkLocation(PlayerInstance par0PlayerInstance)
    {
        return par0PlayerInstance.chunkLocation;
    }

    static List getPlayersInChunk(PlayerInstance par0PlayerInstance)
    {
        return par0PlayerInstance.playersInChunk;
    }
}
