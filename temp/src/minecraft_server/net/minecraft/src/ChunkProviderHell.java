// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenNetherBridge, MapGenCavesHell, NoiseGeneratorOctaves, 
//            Block, MapGenBase, Chunk, World, 
//            WorldChunkManager, BiomeGenBase, BlockSand, WorldGenHellLava, 
//            WorldGenFire, WorldGenGlowStone1, WorldGenGlowStone2, WorldGenFlowers, 
//            BlockFlower, EnumCreatureType, IProgressUpdate, ChunkPosition

public class ChunkProviderHell
    implements IChunkProvider
{

    private Random field_73181_i;
    private NoiseGeneratorOctaves field_73178_j;
    private NoiseGeneratorOctaves field_73179_k;
    private NoiseGeneratorOctaves field_73176_l;
    private NoiseGeneratorOctaves field_73177_m;
    private NoiseGeneratorOctaves field_73174_n;
    public NoiseGeneratorOctaves field_73173_a;
    public NoiseGeneratorOctaves field_73171_b;
    private World field_73175_o;
    private double field_73186_p[];
    public MapGenNetherBridge field_73172_c;
    private double field_73185_q[];
    private double field_73184_r[];
    private double field_73183_s[];
    private MapGenBase field_73182_t;
    double field_73169_d[];
    double field_73170_e[];
    double field_73167_f[];
    double field_73168_g[];
    double field_73180_h[];

    public ChunkProviderHell(World p_i3781_1_, long p_i3781_2_)
    {
        field_73172_c = new MapGenNetherBridge();
        field_73185_q = new double[256];
        field_73184_r = new double[256];
        field_73183_s = new double[256];
        field_73182_t = new MapGenCavesHell();
        field_73175_o = p_i3781_1_;
        field_73181_i = new Random(p_i3781_2_);
        field_73178_j = new NoiseGeneratorOctaves(field_73181_i, 16);
        field_73179_k = new NoiseGeneratorOctaves(field_73181_i, 16);
        field_73176_l = new NoiseGeneratorOctaves(field_73181_i, 8);
        field_73177_m = new NoiseGeneratorOctaves(field_73181_i, 4);
        field_73174_n = new NoiseGeneratorOctaves(field_73181_i, 4);
        field_73173_a = new NoiseGeneratorOctaves(field_73181_i, 10);
        field_73171_b = new NoiseGeneratorOctaves(field_73181_i, 16);
    }

    public void func_73165_a(int p_73165_1_, int p_73165_2_, byte p_73165_3_[])
    {
        byte byte0 = 4;
        byte byte1 = 32;
        int i = byte0 + 1;
        byte byte2 = 17;
        int j = byte0 + 1;
        field_73186_p = func_73164_a(field_73186_p, p_73165_1_ * byte0, 0, p_73165_2_ * byte0, i, byte2, j);
        for(int k = 0; k < byte0; k++)
        {
            for(int l = 0; l < byte0; l++)
            {
                for(int i1 = 0; i1 < 16; i1++)
                {
                    double d = 0.125D;
                    double d1 = field_73186_p[((k + 0) * j + (l + 0)) * byte2 + (i1 + 0)];
                    double d2 = field_73186_p[((k + 0) * j + (l + 1)) * byte2 + (i1 + 0)];
                    double d3 = field_73186_p[((k + 1) * j + (l + 0)) * byte2 + (i1 + 0)];
                    double d4 = field_73186_p[((k + 1) * j + (l + 1)) * byte2 + (i1 + 0)];
                    double d5 = (field_73186_p[((k + 0) * j + (l + 0)) * byte2 + (i1 + 1)] - d1) * d;
                    double d6 = (field_73186_p[((k + 0) * j + (l + 1)) * byte2 + (i1 + 1)] - d2) * d;
                    double d7 = (field_73186_p[((k + 1) * j + (l + 0)) * byte2 + (i1 + 1)] - d3) * d;
                    double d8 = (field_73186_p[((k + 1) * j + (l + 1)) * byte2 + (i1 + 1)] - d4) * d;
                    for(int j1 = 0; j1 < 8; j1++)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int k1 = 0; k1 < 4; k1++)
                        {
                            int l1 = k1 + k * 4 << 11 | 0 + l * 4 << 7 | i1 * 8 + j1;
                            char c = '\200';
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for(int i2 = 0; i2 < 4; i2++)
                            {
                                int j2 = 0;
                                if(i1 * 8 + j1 < byte1)
                                {
                                    j2 = Block.field_71938_D.field_71990_ca;
                                }
                                if(d15 > 0.0D)
                                {
                                    j2 = Block.field_72012_bb.field_71990_ca;
                                }
                                p_73165_3_[l1] = (byte)j2;
                                l1 += c;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }

                }

            }

        }

    }

    public void func_73166_b(int p_73166_1_, int p_73166_2_, byte p_73166_3_[])
    {
        byte byte0 = 64;
        double d = 0.03125D;
        field_73185_q = field_73177_m.func_76304_a(field_73185_q, p_73166_1_ * 16, p_73166_2_ * 16, 0, 16, 16, 1, d, d, 1.0D);
        field_73184_r = field_73177_m.func_76304_a(field_73184_r, p_73166_1_ * 16, 109, p_73166_2_ * 16, 16, 1, 16, d, 1.0D, d);
        field_73183_s = field_73174_n.func_76304_a(field_73183_s, p_73166_1_ * 16, p_73166_2_ * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                boolean flag = field_73185_q[i + j * 16] + field_73181_i.nextDouble() * 0.20000000000000001D > 0.0D;
                boolean flag1 = field_73184_r[i + j * 16] + field_73181_i.nextDouble() * 0.20000000000000001D > 0.0D;
                int k = (int)(field_73183_s[i + j * 16] / 3D + 3D + field_73181_i.nextDouble() * 0.25D);
                int l = -1;
                byte byte1 = (byte)Block.field_72012_bb.field_71990_ca;
                byte byte2 = (byte)Block.field_72012_bb.field_71990_ca;
                for(int i1 = 127; i1 >= 0; i1--)
                {
                    int j1 = (j * 16 + i) * 128 + i1;
                    if(i1 >= 127 - field_73181_i.nextInt(5) || i1 <= 0 + field_73181_i.nextInt(5))
                    {
                        p_73166_3_[j1] = (byte)Block.field_71986_z.field_71990_ca;
                        continue;
                    }
                    byte byte3 = p_73166_3_[j1];
                    if(byte3 == 0)
                    {
                        l = -1;
                        continue;
                    }
                    if(byte3 != Block.field_72012_bb.field_71990_ca)
                    {
                        continue;
                    }
                    if(l == -1)
                    {
                        if(k <= 0)
                        {
                            byte1 = 0;
                            byte2 = (byte)Block.field_72012_bb.field_71990_ca;
                        } else
                        if(i1 >= byte0 - 4 && i1 <= byte0 + 1)
                        {
                            byte1 = (byte)Block.field_72012_bb.field_71990_ca;
                            byte2 = (byte)Block.field_72012_bb.field_71990_ca;
                            if(flag1)
                            {
                                byte1 = (byte)Block.field_71940_F.field_71990_ca;
                            }
                            if(flag1)
                            {
                                byte2 = (byte)Block.field_72012_bb.field_71990_ca;
                            }
                            if(flag)
                            {
                                byte1 = (byte)Block.field_72013_bc.field_71990_ca;
                            }
                            if(flag)
                            {
                                byte2 = (byte)Block.field_72013_bc.field_71990_ca;
                            }
                        }
                        if(i1 < byte0 && byte1 == 0)
                        {
                            byte1 = (byte)Block.field_71938_D.field_71990_ca;
                        }
                        l = k;
                        if(i1 >= byte0 - 1)
                        {
                            p_73166_3_[j1] = byte1;
                        } else
                        {
                            p_73166_3_[j1] = byte2;
                        }
                        continue;
                    }
                    if(l > 0)
                    {
                        l--;
                        p_73166_3_[j1] = byte2;
                    }
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
        field_73181_i.setSeed((long)p_73154_1_ * 0x4f9939f508L + (long)p_73154_2_ * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        func_73165_a(p_73154_1_, p_73154_2_, abyte0);
        func_73166_b(p_73154_1_, p_73154_2_, abyte0);
        field_73182_t.func_75036_a(this, field_73175_o, p_73154_1_, p_73154_2_, abyte0);
        field_73172_c.func_75036_a(this, field_73175_o, p_73154_1_, p_73154_2_, abyte0);
        Chunk chunk = new Chunk(field_73175_o, abyte0, p_73154_1_, p_73154_2_);
        BiomeGenBase abiomegenbase[] = field_73175_o.func_72959_q().func_76933_b(null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        byte abyte1[] = chunk.func_76605_m();
        for(int i = 0; i < abyte1.length; i++)
        {
            abyte1[i] = (byte)abiomegenbase[i].field_76756_M;
        }

        chunk.func_76613_n();
        return chunk;
    }

    private double[] func_73164_a(double p_73164_1_[], int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_)
    {
        if(p_73164_1_ == null)
        {
            p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
        }
        double d = 684.41200000000003D;
        double d1 = 2053.2359999999999D;
        field_73168_g = field_73173_a.func_76304_a(field_73168_g, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
        field_73180_h = field_73171_b.func_76304_a(field_73180_h, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100D, 0.0D, 100D);
        field_73169_d = field_73176_l.func_76304_a(field_73169_d, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d / 80D, d1 / 60D, d / 80D);
        field_73170_e = field_73178_j.func_76304_a(field_73170_e, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d, d1, d);
        field_73167_f = field_73179_k.func_76304_a(field_73167_f, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d, d1, d);
        int i = 0;
        int j = 0;
        double ad[] = new double[p_73164_6_];
        for(int k = 0; k < p_73164_6_; k++)
        {
            ad[k] = Math.cos(((double)k * 3.1415926535897931D * 6D) / (double)p_73164_6_) * 2D;
            double d2 = k;
            if(k > p_73164_6_ / 2)
            {
                d2 = p_73164_6_ - 1 - k;
            }
            if(d2 < 4D)
            {
                d2 = 4D - d2;
                ad[k] -= d2 * d2 * d2 * 10D;
            }
        }

        for(int l = 0; l < p_73164_5_; l++)
        {
            for(int i1 = 0; i1 < p_73164_7_; i1++)
            {
                double d3 = (field_73168_g[j] + 256D) / 512D;
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                double d4 = 0.0D;
                double d5 = field_73180_h[j] / 8000D;
                if(d5 < 0.0D)
                {
                    d5 = -d5;
                }
                d5 = d5 * 3D - 3D;
                if(d5 < 0.0D)
                {
                    d5 /= 2D;
                    if(d5 < -1D)
                    {
                        d5 = -1D;
                    }
                    d5 /= 1.3999999999999999D;
                    d5 /= 2D;
                    d3 = 0.0D;
                } else
                {
                    if(d5 > 1.0D)
                    {
                        d5 = 1.0D;
                    }
                    d5 /= 6D;
                }
                d3 += 0.5D;
                d5 = (d5 * (double)p_73164_6_) / 16D;
                j++;
                for(int j1 = 0; j1 < p_73164_6_; j1++)
                {
                    double d6 = 0.0D;
                    double d7 = ad[j1];
                    double d8 = field_73170_e[i] / 512D;
                    double d9 = field_73167_f[i] / 512D;
                    double d10 = (field_73169_d[i] / 10D + 1.0D) / 2D;
                    if(d10 < 0.0D)
                    {
                        d6 = d8;
                    } else
                    if(d10 > 1.0D)
                    {
                        d6 = d9;
                    } else
                    {
                        d6 = d8 + (d9 - d8) * d10;
                    }
                    d6 -= d7;
                    if(j1 > p_73164_6_ - 4)
                    {
                        double d11 = (float)(j1 - (p_73164_6_ - 4)) / 3F;
                        d6 = d6 * (1.0D - d11) + -10D * d11;
                    }
                    if((double)j1 < d4)
                    {
                        double d12 = (d4 - (double)j1) / 4D;
                        if(d12 < 0.0D)
                        {
                            d12 = 0.0D;
                        }
                        if(d12 > 1.0D)
                        {
                            d12 = 1.0D;
                        }
                        d6 = d6 * (1.0D - d12) + -10D * d12;
                    }
                    p_73164_1_[i] = d6;
                    i++;
                }

            }

        }

        return p_73164_1_;
    }

    public boolean func_73149_a(int p_73149_1_, int p_73149_2_)
    {
        return true;
    }

    public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_)
    {
        BlockSand.field_72192_a = true;
        int i = p_73153_2_ * 16;
        int j = p_73153_3_ * 16;
        field_73172_c.func_75051_a(field_73175_o, field_73181_i, p_73153_2_, p_73153_3_);
        for(int k = 0; k < 8; k++)
        {
            int i1 = i + field_73181_i.nextInt(16) + 8;
            int k2 = field_73181_i.nextInt(120) + 4;
            int i4 = j + field_73181_i.nextInt(16) + 8;
            (new WorldGenHellLava(Block.field_71944_C.field_71990_ca)).func_76484_a(field_73175_o, field_73181_i, i1, k2, i4);
        }

        int l = field_73181_i.nextInt(field_73181_i.nextInt(10) + 1) + 1;
        for(int j1 = 0; j1 < l; j1++)
        {
            int l2 = i + field_73181_i.nextInt(16) + 8;
            int j4 = field_73181_i.nextInt(120) + 4;
            int k5 = j + field_73181_i.nextInt(16) + 8;
            (new WorldGenFire()).func_76484_a(field_73175_o, field_73181_i, l2, j4, k5);
        }

        l = field_73181_i.nextInt(field_73181_i.nextInt(10) + 1);
        for(int k1 = 0; k1 < l; k1++)
        {
            int i3 = i + field_73181_i.nextInt(16) + 8;
            int k4 = field_73181_i.nextInt(120) + 4;
            int l5 = j + field_73181_i.nextInt(16) + 8;
            (new WorldGenGlowStone1()).func_76484_a(field_73175_o, field_73181_i, i3, k4, l5);
        }

        for(int l1 = 0; l1 < 10; l1++)
        {
            int j3 = i + field_73181_i.nextInt(16) + 8;
            int l4 = field_73181_i.nextInt(128);
            int i6 = j + field_73181_i.nextInt(16) + 8;
            (new WorldGenGlowStone2()).func_76484_a(field_73175_o, field_73181_i, j3, l4, i6);
        }

        if(field_73181_i.nextInt(1) == 0)
        {
            int i2 = i + field_73181_i.nextInt(16) + 8;
            int k3 = field_73181_i.nextInt(128);
            int i5 = j + field_73181_i.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(field_73175_o, field_73181_i, i2, k3, i5);
        }
        if(field_73181_i.nextInt(1) == 0)
        {
            int j2 = i + field_73181_i.nextInt(16) + 8;
            int l3 = field_73181_i.nextInt(128);
            int j5 = j + field_73181_i.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(field_73175_o, field_73181_i, j2, l3, j5);
        }
        BlockSand.field_72192_a = false;
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
        return "HellRandomLevelSource";
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
    {
        if(p_73155_1_ == EnumCreatureType.monster && field_73172_c.func_75048_a(p_73155_2_, p_73155_3_, p_73155_4_))
        {
            return field_73172_c.func_75059_a();
        }
        BiomeGenBase biomegenbase = field_73175_o.func_72807_a(p_73155_2_, p_73155_4_);
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
