// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ChunkCoordIntPair, PlayerManager, WorldServer, ChunkProviderServer, 
//            EntityPlayerMP, Packet51MapChunk, NetServerHandler, LongHashMap, 
//            Packet53BlockChange, TileEntity, Packet52MultiBlockChange, Packet

class PlayerInstance
{

    private final List field_73263_b = new ArrayList();
    private final ChunkCoordIntPair field_73264_c;
    private short field_73261_d[];
    private int field_73262_e;
    private int field_73260_f;
    final PlayerManager field_73265_a; /* synthetic field */

    public PlayerInstance(PlayerManager p_i3391_1_, int p_i3391_2_, int p_i3391_3_)
    {
        field_73265_a = p_i3391_1_;
        super();
        field_73261_d = new short[64];
        field_73262_e = 0;
        field_73264_c = new ChunkCoordIntPair(p_i3391_2_, p_i3391_3_);
        p_i3391_1_.func_72688_a().field_73059_b.func_73158_c(p_i3391_2_, p_i3391_3_);
    }

    public void func_73255_a(EntityPlayerMP p_73255_1_)
    {
        if(field_73263_b.contains(p_73255_1_))
        {
            throw new IllegalStateException((new StringBuilder()).append("Failed to add player. ").append(p_73255_1_).append(" already is in chunk ").append(field_73264_c.field_77276_a).append(", ").append(field_73264_c.field_77275_b).toString());
        } else
        {
            field_73263_b.add(p_73255_1_);
            p_73255_1_.field_71129_f.add(field_73264_c);
            return;
        }
    }

    public void func_73252_b(EntityPlayerMP p_73252_1_)
    {
        if(!field_73263_b.contains(p_73252_1_))
        {
            return;
        }
        p_73252_1_.field_71135_a.func_72567_b(new Packet51MapChunk(PlayerManager.func_72692_a(field_73265_a).func_72964_e(field_73264_c.field_77276_a, field_73264_c.field_77275_b), true, 0));
        field_73263_b.remove(p_73252_1_);
        p_73252_1_.field_71129_f.remove(field_73264_c);
        if(field_73263_b.isEmpty())
        {
            long l = (long)field_73264_c.field_77276_a + 0x7fffffffL | (long)field_73264_c.field_77275_b + 0x7fffffffL << 32;
            PlayerManager.func_72689_b(field_73265_a).func_76159_d(l);
            if(field_73262_e > 0)
            {
                PlayerManager.func_72682_c(field_73265_a).remove(this);
            }
            field_73265_a.func_72688_a().field_73059_b.func_73241_b(field_73264_c.field_77276_a, field_73264_c.field_77275_b);
        }
    }

    public void func_73259_a(int p_73259_1_, int p_73259_2_, int p_73259_3_)
    {
        if(field_73262_e == 0)
        {
            PlayerManager.func_72682_c(field_73265_a).add(this);
        }
        field_73260_f |= 1 << (p_73259_2_ >> 4);
        if(field_73262_e < 64)
        {
            short word0 = (short)(p_73259_1_ << 12 | p_73259_3_ << 8 | p_73259_2_);
            for(int i = 0; i < field_73262_e; i++)
            {
                if(field_73261_d[i] == word0)
                {
                    return;
                }
            }

            field_73261_d[field_73262_e++] = word0;
        }
    }

    public void func_73256_a(Packet p_73256_1_)
    {
        Iterator iterator = field_73263_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(!entityplayermp.field_71129_f.contains(field_73264_c))
            {
                entityplayermp.field_71135_a.func_72567_b(p_73256_1_);
            }
        } while(true);
    }

    public void func_73254_a()
    {
        if(field_73262_e == 0)
        {
            return;
        }
        if(field_73262_e == 1)
        {
            int i = field_73264_c.field_77276_a * 16 + (field_73261_d[0] >> 12 & 0xf);
            int l = field_73261_d[0] & 0xff;
            int k1 = field_73264_c.field_77275_b * 16 + (field_73261_d[0] >> 8 & 0xf);
            func_73256_a(new Packet53BlockChange(i, l, k1, PlayerManager.func_72692_a(field_73265_a)));
            if(PlayerManager.func_72692_a(field_73265_a).func_72927_d(i, l, k1))
            {
                func_73257_a(PlayerManager.func_72692_a(field_73265_a).func_72796_p(i, l, k1));
            }
        } else
        if(field_73262_e == 64)
        {
            int j = field_73264_c.field_77276_a * 16;
            int i1 = field_73264_c.field_77275_b * 16;
            func_73256_a(new Packet51MapChunk(PlayerManager.func_72692_a(field_73265_a).func_72964_e(field_73264_c.field_77276_a, field_73264_c.field_77275_b), false, field_73260_f));
            for(int l1 = 0; l1 < 16; l1++)
            {
                if((field_73260_f & 1 << l1) != 0)
                {
                    int j2 = l1 << 4;
                    List list = PlayerManager.func_72692_a(field_73265_a).func_73049_a(j, j2, i1, j + 16, j2 + 16, i1 + 16);
                    TileEntity tileentity;
                    for(Iterator iterator = list.iterator(); iterator.hasNext(); func_73257_a(tileentity))
                    {
                        tileentity = (TileEntity)iterator.next();
                    }

                }
            }

        } else
        {
            func_73256_a(new Packet52MultiBlockChange(field_73264_c.field_77276_a, field_73264_c.field_77275_b, field_73261_d, field_73262_e, PlayerManager.func_72692_a(field_73265_a)));
            for(int k = 0; k < field_73262_e; k++)
            {
                int j1 = field_73264_c.field_77276_a * 16 + (field_73261_d[k] >> 12 & 0xf);
                int i2 = field_73261_d[k] & 0xff;
                int k2 = field_73264_c.field_77275_b * 16 + (field_73261_d[k] >> 8 & 0xf);
                if(PlayerManager.func_72692_a(field_73265_a).func_72927_d(j1, i2, k2))
                {
                    func_73257_a(PlayerManager.func_72692_a(field_73265_a).func_72796_p(j1, i2, k2));
                }
            }

        }
        field_73262_e = 0;
        field_73260_f = 0;
    }

    private void func_73257_a(TileEntity p_73257_1_)
    {
        if(p_73257_1_ != null)
        {
            Packet packet = p_73257_1_.func_70319_e();
            if(packet != null)
            {
                func_73256_a(packet);
            }
        }
    }

    static ChunkCoordIntPair func_73253_a(PlayerInstance p_73253_0_)
    {
        return p_73253_0_.field_73264_c;
    }

    static List func_73258_b(PlayerInstance p_73258_0_)
    {
        return p_73258_0_.field_73263_b;
    }
}
