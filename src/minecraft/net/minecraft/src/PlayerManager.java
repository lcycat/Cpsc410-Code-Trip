package net.minecraft.src;

import java.util.*;

public class PlayerManager
{
    private final WorldServer theWorldServer;
    private final List field_72699_b = new ArrayList();
    private final LongHashMap allChunkWathers = new LongHashMap();

    /**
     * contains a PlayerInstance for every chunk they can see. the "player instance" cotains a list of all players who
     * can also that chunk
     */
    private final List chunkWathcherWithPlayers = new ArrayList();
    private final int playerViewDistance;
    private final int field_72696_f[][] =
    {
        {
            1, 0
        }, {
            0, 1
        }, {
            -1, 0
        }, {
            0, -1
        }
    };

    public PlayerManager(WorldServer par1WorldServer, int par2)
    {
        if (par2 > 15)
        {
            throw new IllegalArgumentException("Too big view radius!");
        }

        if (par2 < 3)
        {
            throw new IllegalArgumentException("Too small view radius!");
        }
        else
        {
            playerViewDistance = par2;
            theWorldServer = par1WorldServer;
            return;
        }
    }

    public WorldServer getWorldServer()
    {
        return theWorldServer;
    }

    public void func_72693_b()
    {
        PlayerInstance playerinstance;

        for (Iterator iterator = chunkWathcherWithPlayers.iterator(); iterator.hasNext(); playerinstance.sendChunkUpdate())
        {
            playerinstance = (PlayerInstance)iterator.next();
        }

        chunkWathcherWithPlayers.clear();

        if (field_72699_b.isEmpty())
        {
            WorldProvider worldprovider = theWorldServer.provider;

            if (!worldprovider.canRespawnHere())
            {
                theWorldServer.theChunkProviderServer.unloadAllChunks();
            }
        }
    }

    private PlayerInstance getOrCreateChunkWatcher(int par1, int par2, boolean par3)
    {
        long l = (long)par1 + 0x7fffffffL | (long)par2 + 0x7fffffffL << 32;
        PlayerInstance playerinstance = (PlayerInstance)allChunkWathers.getValueByKey(l);

        if (playerinstance == null && par3)
        {
            playerinstance = new PlayerInstance(this, par1, par2);
            allChunkWathers.add(l, playerinstance);
        }

        return playerinstance;
    }

    /**
     * the "PlayerInstance"/ chunkWatcher will send this chunk to all players who are in line of sight
     */
    public void flagChunkForUpdate(int par1, int par2, int par3)
    {
        int i = par1 >> 4;
        int j = par3 >> 4;
        PlayerInstance playerinstance = getOrCreateChunkWatcher(i, j, false);

        if (playerinstance != null)
        {
            playerinstance.flagChunkForUpdate(par1 & 0xf, par2, par3 & 0xf);
        }
    }

    public void func_72683_a(EntityPlayerMP par1EntityPlayerMP)
    {
        int i = (int)par1EntityPlayerMP.posX >> 4;
        int j = (int)par1EntityPlayerMP.posZ >> 4;
        par1EntityPlayerMP.field_71131_d = par1EntityPlayerMP.posX;
        par1EntityPlayerMP.field_71132_e = par1EntityPlayerMP.posZ;

        for (int k = i - playerViewDistance; k <= i + playerViewDistance; k++)
        {
            for (int l = j - playerViewDistance; l <= j + playerViewDistance; l++)
            {
                getOrCreateChunkWatcher(k, l, true).addPlayerToChunkWatchingList(par1EntityPlayerMP);
            }
        }

        field_72699_b.add(par1EntityPlayerMP);
        func_72691_b(par1EntityPlayerMP);
    }

    public void func_72691_b(EntityPlayerMP par1EntityPlayerMP)
    {
        ArrayList arraylist = new ArrayList(par1EntityPlayerMP.chunksToLoad);
        int i = 0;
        int j = playerViewDistance;
        int k = (int)par1EntityPlayerMP.posX >> 4;
        int l = (int)par1EntityPlayerMP.posZ >> 4;
        int i1 = 0;
        int j1 = 0;
        ChunkCoordIntPair chunkcoordintpair = PlayerInstance.getChunkLocation(getOrCreateChunkWatcher(k, l, true));
        par1EntityPlayerMP.chunksToLoad.clear();

        if (arraylist.contains(chunkcoordintpair))
        {
            par1EntityPlayerMP.chunksToLoad.add(chunkcoordintpair);
        }

        for (int k1 = 1; k1 <= j * 2; k1++)
        {
            for (int i2 = 0; i2 < 2; i2++)
            {
                int ai[] = field_72696_f[i++ % 4];

                for (int j2 = 0; j2 < k1; j2++)
                {
                    i1 += ai[0];
                    j1 += ai[1];
                    ChunkCoordIntPair chunkcoordintpair1 = PlayerInstance.getChunkLocation(getOrCreateChunkWatcher(k + i1, l + j1, true));

                    if (arraylist.contains(chunkcoordintpair1))
                    {
                        par1EntityPlayerMP.chunksToLoad.add(chunkcoordintpair1);
                    }
                }
            }
        }

        i %= 4;

        for (int l1 = 0; l1 < j * 2; l1++)
        {
            i1 += field_72696_f[i][0];
            j1 += field_72696_f[i][1];
            ChunkCoordIntPair chunkcoordintpair2 = PlayerInstance.getChunkLocation(getOrCreateChunkWatcher(k + i1, l + j1, true));

            if (arraylist.contains(chunkcoordintpair2))
            {
                par1EntityPlayerMP.chunksToLoad.add(chunkcoordintpair2);
            }
        }
    }

    public void func_72695_c(EntityPlayerMP par1EntityPlayerMP)
    {
        int i = (int)par1EntityPlayerMP.field_71131_d >> 4;
        int j = (int)par1EntityPlayerMP.field_71132_e >> 4;

        for (int k = i - playerViewDistance; k <= i + playerViewDistance; k++)
        {
            for (int l = j - playerViewDistance; l <= j + playerViewDistance; l++)
            {
                PlayerInstance playerinstance = getOrCreateChunkWatcher(k, l, false);

                if (playerinstance != null)
                {
                    playerinstance.sendThisChunkToPlayer(par1EntityPlayerMP);
                }
            }
        }

        field_72699_b.remove(par1EntityPlayerMP);
    }

    private boolean func_72684_a(int par1, int par2, int par3, int par4, int par5)
    {
        int i = par1 - par3;
        int j = par2 - par4;

        if (i < -par5 || i > par5)
        {
            return false;
        }

        return j >= -par5 && j <= par5;
    }

    public void func_72685_d(EntityPlayerMP par1EntityPlayerMP)
    {
        int i = (int)par1EntityPlayerMP.posX >> 4;
        int j = (int)par1EntityPlayerMP.posZ >> 4;
        double d = par1EntityPlayerMP.field_71131_d - par1EntityPlayerMP.posX;
        double d1 = par1EntityPlayerMP.field_71132_e - par1EntityPlayerMP.posZ;
        double d2 = d * d + d1 * d1;

        if (d2 < 64D)
        {
            return;
        }

        int k = (int)par1EntityPlayerMP.field_71131_d >> 4;
        int l = (int)par1EntityPlayerMP.field_71132_e >> 4;
        int i1 = playerViewDistance;
        int j1 = i - k;
        int k1 = j - l;

        if (j1 == 0 && k1 == 0)
        {
            return;
        }

        for (int l1 = i - i1; l1 <= i + i1; l1++)
        {
            for (int i2 = j - i1; i2 <= j + i1; i2++)
            {
                if (!func_72684_a(l1, i2, k, l, i1))
                {
                    getOrCreateChunkWatcher(l1, i2, true).addPlayerToChunkWatchingList(par1EntityPlayerMP);
                }

                if (func_72684_a(l1 - j1, i2 - k1, i, j, i1))
                {
                    continue;
                }

                PlayerInstance playerinstance = getOrCreateChunkWatcher(l1 - j1, i2 - k1, false);

                if (playerinstance != null)
                {
                    playerinstance.sendThisChunkToPlayer(par1EntityPlayerMP);
                }
            }
        }

        func_72691_b(par1EntityPlayerMP);
        par1EntityPlayerMP.field_71131_d = par1EntityPlayerMP.posX;
        par1EntityPlayerMP.field_71132_e = par1EntityPlayerMP.posZ;
    }

    public boolean isPlayerWatchingChunk(EntityPlayerMP par1EntityPlayerMP, int par2, int par3)
    {
        PlayerInstance playerinstance = getOrCreateChunkWatcher(par2, par3, false);
        return playerinstance != null ? PlayerInstance.getPlayersInChunk(playerinstance).contains(par1EntityPlayerMP) : false;
    }

    public static int func_72686_a(int par0)
    {
        return par0 * 16 - 16;
    }

    static WorldServer getWorldServer(PlayerManager par0PlayerManager)
    {
        return par0PlayerManager.theWorldServer;
    }

    static LongHashMap getChunkWatchers(PlayerManager par0PlayerManager)
    {
        return par0PlayerManager.allChunkWathers;
    }

    static List getChunkWatchersWithPlayers(PlayerManager par0PlayerManager)
    {
        return par0PlayerManager.chunkWathcherWithPlayers;
    }
}
