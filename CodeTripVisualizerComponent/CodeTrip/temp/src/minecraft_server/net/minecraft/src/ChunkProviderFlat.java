// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenVillage, Block, BlockGrass, 
//            Chunk, World, WorldChunkManager, BiomeGenBase, 
//            IProgressUpdate, EnumCreatureType, ChunkPosition

public class ChunkProviderFlat
    implements IChunkProvider
{

    private World field_73163_a;
    private Random field_73161_b;
    private final boolean field_73162_c;
    private MapGenVillage field_73160_d;

    public ChunkProviderFlat(World p_i3780_1_, long p_i3780_2_, boolean p_i3780_4_)
    {
        field_73160_d = new MapGenVillage(1);
        field_73163_a = p_i3780_1_;
        field_73162_c = p_i3780_4_;
        field_73161_b = new Random(p_i3780_2_);
    }

    private void func_73159_a(byte p_73159_1_[])
    {
        int i = p_73159_1_.length / 256;
        for(int j = 0; j < 16; j++)
        {
            for(int k = 0; k < 16; k++)
            {
                for(int l = 0; l < i; l++)
                {
                    int i1 = 0;
                    if(l == 0)
                    {
                        i1 = Block.field_71986_z.field_71990_ca;
                    } else
                    if(l <= 2)
                    {
                        i1 = Block.field_71979_v.field_71990_ca;
                    } else
                    if(l == 3)
                    {
                        i1 = Block.field_71980_u.field_71990_ca;
                    }
                    p_73159_1_[j << 11 | k << 7 | l] = (byte)i1;
                }

            }

        }

    }

    public Chunk func_73158_c(int p_73158_1_, int p_73158_2_)
    {
        return func_73154_d(p_73158_1_, p_73158_2_);
    }

    public Chunk func_73154_d(int p_73154_1_, int p_73154_2_)
    {
        byte abyte0[] = new byte[32768];
        func_73159_a(abyte0);
        Chunk chunk = new Chunk(field_73163_a, abyte0, p_73154_1_, p_73154_2_);
        if(field_73162_c)
        {
            field_73160_d.func_75036_a(this, field_73163_a, p_73154_1_, p_73154_2_, abyte0);
        }
        BiomeGenBase abiomegenbase[] = field_73163_a.func_72959_q().func_76933_b(null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        byte abyte1[] = chunk.func_76605_m();
        for(int i = 0; i < abyte1.length; i++)
        {
            abyte1[i] = (byte)abiomegenbase[i].field_76756_M;
        }

        chunk.func_76603_b();
        return chunk;
    }

    public boolean func_73149_a(int p_73149_1_, int p_73149_2_)
    {
        return true;
    }

    public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_)
    {
        field_73161_b.setSeed(field_73163_a.func_72905_C());
        long l = (field_73161_b.nextLong() / 2L) * 2L + 1L;
        long l1 = (field_73161_b.nextLong() / 2L) * 2L + 1L;
        field_73161_b.setSeed((long)p_73153_2_ * l + (long)p_73153_3_ * l1 ^ field_73163_a.func_72905_C());
        if(field_73162_c)
        {
            field_73160_d.func_75051_a(field_73163_a, field_73161_b, p_73153_2_, p_73153_3_);
        }
    }

    public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_)
    {
        return true;
    }

    public boolean func_73156_b()
    {
        return false;
    }

    public boolean func_73157_c()
    {
        return true;
    }

    public String func_73148_d()
    {
        return "FlatLevelSource";
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
    {
        BiomeGenBase biomegenbase = field_73163_a.func_72807_a(p_73155_2_, p_73155_4_);
        if(biomegenbase == null)
        {
            return null;
        } else
        {
            return biomegenbase.func_76747_a(p_73155_1_);
        }
    }

    public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int i, int j)
    {
        return null;
    }

    public int func_73152_e()
    {
        return 0;
    }
}
