// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            LongHashMap, PlayerInstance, WorldServer, WorldProvider, 
//            ChunkProviderServer, EntityPlayerMP

public class PlayerManager
{

    private final WorldServer field_72701_a;
    private final List field_72699_b = new ArrayList();
    private final LongHashMap field_72700_c = new LongHashMap();
    private final List field_72697_d = new ArrayList();
    private final int field_72698_e;
    private final int field_72696_f[][] = {
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

    public PlayerManager(WorldServer p_i3392_1_, int p_i3392_2_)
    {
        if(p_i3392_2_ > 15)
        {
            throw new IllegalArgumentException("Too big view radius!");
        }
        if(p_i3392_2_ < 3)
        {
            throw new IllegalArgumentException("Too small view radius!");
        } else
        {
            field_72698_e = p_i3392_2_;
            field_72701_a = p_i3392_1_;
            return;
        }
    }

    public WorldServer func_72688_a()
    {
        return field_72701_a;
    }

    public void func_72693_b()
    {
        PlayerInstance playerinstance;
        for(Iterator iterator = field_72697_d.iterator(); iterator.hasNext(); playerinstance.func_73254_a())
        {
            playerinstance = (PlayerInstance)iterator.next();
        }

        field_72697_d.clear();
        if(field_72699_b.isEmpty())
        {
            WorldProvider worldprovider = field_72701_a.field_73011_w;
            if(!worldprovider.func_76567_e())
            {
                field_72701_a.field_73059_b.func_73240_a();
            }
        }
    }

    private PlayerInstance func_72690_a(int p_72690_1_, int p_72690_2_, boolean p_72690_3_)
    {
        long l = (long)p_72690_1_ + 0x7fffffffL | (long)p_72690_2_ + 0x7fffffffL << 32;
        PlayerInstance playerinstance = (PlayerInstance)field_72700_c.func_76164_a(l);
        if(playerinstance == null && p_72690_3_)
        {
            playerinstance = new PlayerInstance(this, p_72690_1_, p_72690_2_);
            field_72700_c.func_76163_a(l, playerinstance);
        }
        return playerinstance;
    }

    public void func_72687_a(int p_72687_1_, int p_72687_2_, int p_72687_3_)
    {
        int i = p_72687_1_ >> 4;
        int j = p_72687_3_ >> 4;
        PlayerInstance playerinstance = func_72690_a(i, j, false);
        if(playerinstance != null)
        {
            playerinstance.func_73259_a(p_72687_1_ & 0xf, p_72687_2_, p_72687_3_ & 0xf);
        }
    }

    public void func_72683_a(EntityPlayerMP p_72683_1_)
    {
        int i = (int)p_72683_1_.field_70165_t >> 4;
        int j = (int)p_72683_1_.field_70161_v >> 4;
        p_72683_1_.field_71131_d = p_72683_1_.field_70165_t;
        p_72683_1_.field_71132_e = p_72683_1_.field_70161_v;
        for(int k = i - field_72698_e; k <= i + field_72698_e; k++)
        {
            for(int l = j - field_72698_e; l <= j + field_72698_e; l++)
            {
                func_72690_a(k, l, true).func_73255_a(p_72683_1_);
            }

        }

        field_72699_b.add(p_72683_1_);
        func_72691_b(p_72683_1_);
    }

    public void func_72691_b(EntityPlayerMP p_72691_1_)
    {
        ArrayList arraylist = new ArrayList(p_72691_1_.field_71129_f);
        int i = 0;
        int j = field_72698_e;
        int k = (int)p_72691_1_.field_70165_t >> 4;
        int l = (int)p_72691_1_.field_70161_v >> 4;
        int i1 = 0;
        int j1 = 0;
        ChunkCoordIntPair chunkcoordintpair = PlayerInstance.func_73253_a(func_72690_a(k, l, true));
        p_72691_1_.field_71129_f.clear();
        if(arraylist.contains(chunkcoordintpair))
        {
            p_72691_1_.field_71129_f.add(chunkcoordintpair);
        }
        for(int k1 = 1; k1 <= j * 2; k1++)
        {
            for(int i2 = 0; i2 < 2; i2++)
            {
                int ai[] = field_72696_f[i++ % 4];
                for(int j2 = 0; j2 < k1; j2++)
                {
                    i1 += ai[0];
                    j1 += ai[1];
                    ChunkCoordIntPair chunkcoordintpair1 = PlayerInstance.func_73253_a(func_72690_a(k + i1, l + j1, true));
                    if(arraylist.contains(chunkcoordintpair1))
                    {
                        p_72691_1_.field_71129_f.add(chunkcoordintpair1);
                    }
                }

            }

        }

        i %= 4;
        for(int l1 = 0; l1 < j * 2; l1++)
        {
            i1 += field_72696_f[i][0];
            j1 += field_72696_f[i][1];
            ChunkCoordIntPair chunkcoordintpair2 = PlayerInstance.func_73253_a(func_72690_a(k + i1, l + j1, true));
            if(arraylist.contains(chunkcoordintpair2))
            {
                p_72691_1_.field_71129_f.add(chunkcoordintpair2);
            }
        }

    }

    public void func_72695_c(EntityPlayerMP p_72695_1_)
    {
        int i = (int)p_72695_1_.field_71131_d >> 4;
        int j = (int)p_72695_1_.field_71132_e >> 4;
        for(int k = i - field_72698_e; k <= i + field_72698_e; k++)
        {
            for(int l = j - field_72698_e; l <= j + field_72698_e; l++)
            {
                PlayerInstance playerinstance = func_72690_a(k, l, false);
                if(playerinstance != null)
                {
                    playerinstance.func_73252_b(p_72695_1_);
                }
            }

        }

        field_72699_b.remove(p_72695_1_);
    }

    private boolean func_72684_a(int p_72684_1_, int p_72684_2_, int p_72684_3_, int p_72684_4_, int p_72684_5_)
    {
        int i = p_72684_1_ - p_72684_3_;
        int j = p_72684_2_ - p_72684_4_;
        if(i < -p_72684_5_ || i > p_72684_5_)
        {
            return false;
        }
        return j >= -p_72684_5_ && j <= p_72684_5_;
    }

    public void func_72685_d(EntityPlayerMP p_72685_1_)
    {
        int i = (int)p_72685_1_.field_70165_t >> 4;
        int j = (int)p_72685_1_.field_70161_v >> 4;
        double d = p_72685_1_.field_71131_d - p_72685_1_.field_70165_t;
        double d1 = p_72685_1_.field_71132_e - p_72685_1_.field_70161_v;
        double d2 = d * d + d1 * d1;
        if(d2 < 64D)
        {
            return;
        }
        int k = (int)p_72685_1_.field_71131_d >> 4;
        int l = (int)p_72685_1_.field_71132_e >> 4;
        int i1 = field_72698_e;
        int j1 = i - k;
        int k1 = j - l;
        if(j1 == 0 && k1 == 0)
        {
            return;
        }
        for(int l1 = i - i1; l1 <= i + i1; l1++)
        {
            for(int i2 = j - i1; i2 <= j + i1; i2++)
            {
                if(!func_72684_a(l1, i2, k, l, i1))
                {
                    func_72690_a(l1, i2, true).func_73255_a(p_72685_1_);
                }
                if(func_72684_a(l1 - j1, i2 - k1, i, j, i1))
                {
                    continue;
                }
                PlayerInstance playerinstance = func_72690_a(l1 - j1, i2 - k1, false);
                if(playerinstance != null)
                {
                    playerinstance.func_73252_b(p_72685_1_);
                }
            }

        }

        func_72691_b(p_72685_1_);
        p_72685_1_.field_71131_d = p_72685_1_.field_70165_t;
        p_72685_1_.field_71132_e = p_72685_1_.field_70161_v;
    }

    public boolean func_72694_a(EntityPlayerMP p_72694_1_, int p_72694_2_, int p_72694_3_)
    {
        PlayerInstance playerinstance = func_72690_a(p_72694_2_, p_72694_3_, false);
        return playerinstance != null ? PlayerInstance.func_73258_b(playerinstance).contains(p_72694_1_) : false;
    }

    public static int func_72686_a(int p_72686_0_)
    {
        return p_72686_0_ * 16 - 16;
    }

    static WorldServer func_72692_a(PlayerManager p_72692_0_)
    {
        return p_72692_0_.field_72701_a;
    }

    static LongHashMap func_72689_b(PlayerManager p_72689_0_)
    {
        return p_72689_0_.field_72700_c;
    }

    static List func_72682_c(PlayerManager p_72682_0_)
    {
        return p_72682_0_.field_72697_d;
    }
}
