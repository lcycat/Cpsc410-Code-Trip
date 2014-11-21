// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, NoiseGeneratorOctaves, Block, World, 
//            WorldChunkManager, Chunk, BiomeGenBase, MathHelper, 
//            BlockSand, IProgressUpdate, EnumCreatureType, ChunkPosition

public class ChunkProviderEnd
    implements IChunkProvider
{

    private Random field_73204_i;
    private NoiseGeneratorOctaves field_73201_j;
    private NoiseGeneratorOctaves field_73202_k;
    private NoiseGeneratorOctaves field_73199_l;
    public NoiseGeneratorOctaves field_73196_a;
    public NoiseGeneratorOctaves field_73194_b;
    private World field_73200_m;
    private double field_73197_n[];
    private BiomeGenBase field_73198_o[];
    double field_73195_c[];
    double field_73192_d[];
    double field_73193_e[];
    double field_73190_f[];
    double field_73191_g[];
    int field_73203_h[][];

    public ChunkProviderEnd(World p_i3783_1_, long p_i3783_2_)
    {
        field_73203_h = new int[32][32];
        field_73200_m = p_i3783_1_;
        field_73204_i = new Random(p_i3783_2_);
        field_73201_j = new NoiseGeneratorOctaves(field_73204_i, 16);
        field_73202_k = new NoiseGeneratorOctaves(field_73204_i, 16);
        field_73199_l = new NoiseGeneratorOctaves(field_73204_i, 8);
        field_73196_a = new NoiseGeneratorOctaves(field_73204_i, 10);
        field_73194_b = new NoiseGeneratorOctaves(field_73204_i, 16);
    }

    public void func_73189_a(int p_73189_1_, int p_73189_2_, byte p_73189_3_[], BiomeGenBase p_73189_4_[])
    {
        byte byte0 = 2;
        int i = byte0 + 1;
        byte byte1 = 33;
        int j = byte0 + 1;
        field_73197_n = func_73187_a(field_73197_n, p_73189_1_ * byte0, 0, p_73189_2_ * byte0, i, byte1, j);
        for(int k = 0; k < byte0; k++)
        {
            for(int l = 0; l < byte0; l++)
            {
                for(int i1 = 0; i1 < 32; i1++)
                {
                    double d = 0.25D;
                    double d1 = field_73197_n[((k + 0) * j + (l + 0)) * byte1 + (i1 + 0)];
                    double d2 = field_73197_n[((k + 0) * j + (l + 1)) * byte1 + (i1 + 0)];
                    double d3 = field_73197_n[((k + 1) * j + (l + 0)) * byte1 + (i1 + 0)];
                    double d4 = field_73197_n[((k + 1) * j + (l + 1)) * byte1 + (i1 + 0)];
                    double d5 = (field_73197_n[((k + 0) * j + (l + 0)) * byte1 + (i1 + 1)] - d1) * d;
                    double d6 = (field_73197_n[((k + 0) * j + (l + 1)) * byte1 + (i1 + 1)] - d2) * d;
                    double d7 = (field_73197_n[((k + 1) * j + (l + 0)) * byte1 + (i1 + 1)] - d3) * d;
                    double d8 = (field_73197_n[((k + 1) * j + (l + 1)) * byte1 + (i1 + 1)] - d4) * d;
                    for(int j1 = 0; j1 < 4; j1++)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int k1 = 0; k1 < 8; k1++)
                        {
                            int l1 = k1 + k * 8 << 11 | 0 + l * 8 << 7 | i1 * 4 + j1;
                            char c = '\200';
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for(int i2 = 0; i2 < 8; i2++)
                            {
                                int j2 = 0;
                                if(d15 > 0.0D)
                                {
                                    j2 = Block.field_72082_bJ.field_71990_ca;
                                }
                                p_73189_3_[l1] = (byte)j2;
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

    public void func_73188_b(int p_73188_1_, int p_73188_2_, byte p_73188_3_[], BiomeGenBase p_73188_4_[])
    {
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                int k = 1;
                int l = -1;
                byte byte0 = (byte)Block.field_72082_bJ.field_71990_ca;
                byte byte1 = (byte)Block.field_72082_bJ.field_71990_ca;
                for(int i1 = 127; i1 >= 0; i1--)
                {
                    int j1 = (j * 16 + i) * 128 + i1;
                    byte byte2 = p_73188_3_[j1];
                    if(byte2 == 0)
                    {
                        l = -1;
                        continue;
                    }
                    if(byte2 != Block.field_71981_t.field_71990_ca)
                    {
                        continue;
                    }
                    if(l == -1)
                    {
                        if(k <= 0)
                        {
                            byte0 = 0;
                            byte1 = (byte)Block.field_72082_bJ.field_71990_ca;
                        }
                        l = k;
                        if(i1 >= 0)
                        {
                            p_73188_3_[j1] = byte0;
                        } else
                        {
                            p_73188_3_[j1] = byte1;
                        }
                        continue;
                    }
                    if(l > 0)
                    {
                        l--;
                        p_73188_3_[j1] = byte1;
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
        field_73204_i.setSeed((long)p_73154_1_ * 0x4f9939f508L + (long)p_73154_2_ * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        field_73198_o = field_73200_m.func_72959_q().func_76933_b(field_73198_o, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        func_73189_a(p_73154_1_, p_73154_2_, abyte0, field_73198_o);
        func_73188_b(p_73154_1_, p_73154_2_, abyte0, field_73198_o);
        Chunk chunk = new Chunk(field_73200_m, abyte0, p_73154_1_, p_73154_2_);
        byte abyte1[] = chunk.func_76605_m();
        for(int i = 0; i < abyte1.length; i++)
        {
            abyte1[i] = (byte)field_73198_o[i].field_76756_M;
        }

        chunk.func_76603_b();
        return chunk;
    }

    private double[] func_73187_a(double p_73187_1_[], int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_)
    {
        if(p_73187_1_ == null)
        {
            p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
        }
        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        field_73190_f = field_73196_a.func_76305_a(field_73190_f, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D);
        field_73191_g = field_73194_b.func_76305_a(field_73191_g, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200D, 200D, 0.5D);
        d *= 2D;
        field_73195_c = field_73199_l.func_76304_a(field_73195_c, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d / 80D, d1 / 160D, d / 80D);
        field_73192_d = field_73201_j.func_76304_a(field_73192_d, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d, d1, d);
        field_73193_e = field_73202_k.func_76304_a(field_73193_e, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d, d1, d);
        int i = 0;
        int j = 0;
        for(int k = 0; k < p_73187_5_; k++)
        {
            for(int l = 0; l < p_73187_7_; l++)
            {
                double d2 = (field_73190_f[j] + 256D) / 512D;
                if(d2 > 1.0D)
                {
                    d2 = 1.0D;
                }
                double d3 = field_73191_g[j] / 8000D;
                if(d3 < 0.0D)
                {
                    d3 = -d3 * 0.29999999999999999D;
                }
                d3 = d3 * 3D - 2D;
                float f = (float)((k + p_73187_2_) - 0) / 1.0F;
                float f1 = (float)((l + p_73187_4_) - 0) / 1.0F;
                float f2 = 100F - MathHelper.func_76129_c(f * f + f1 * f1) * 8F;
                if(f2 > 80F)
                {
                    f2 = 80F;
                }
                if(f2 < -100F)
                {
                    f2 = -100F;
                }
                if(d3 > 1.0D)
                {
                    d3 = 1.0D;
                }
                d3 /= 8D;
                d3 = 0.0D;
                if(d2 < 0.0D)
                {
                    d2 = 0.0D;
                }
                d2 += 0.5D;
                d3 = (d3 * (double)p_73187_6_) / 16D;
                j++;
                double d4 = (double)p_73187_6_ / 2D;
                for(int i1 = 0; i1 < p_73187_6_; i1++)
                {
                    double d5 = 0.0D;
                    double d6 = (((double)i1 - d4) * 8D) / d2;
                    if(d6 < 0.0D)
                    {
                        d6 *= -1D;
                    }
                    double d7 = field_73192_d[i] / 512D;
                    double d8 = field_73193_e[i] / 512D;
                    double d9 = (field_73195_c[i] / 10D + 1.0D) / 2D;
                    if(d9 < 0.0D)
                    {
                        d5 = d7;
                    } else
                    if(d9 > 1.0D)
                    {
                        d5 = d8;
                    } else
                    {
                        d5 = d7 + (d8 - d7) * d9;
                    }
                    d5 -= 8D;
                    d5 += f2;
                    int j1 = 2;
                    if(i1 > p_73187_6_ / 2 - j1)
                    {
                        double d10 = (float)(i1 - (p_73187_6_ / 2 - j1)) / 64F;
                        if(d10 < 0.0D)
                        {
                            d10 = 0.0D;
                        }
                        if(d10 > 1.0D)
                        {
                            d10 = 1.0D;
                        }
                        d5 = d5 * (1.0D - d10) + -3000D * d10;
                    }
                    j1 = 8;
                    if(i1 < j1)
                    {
                        double d11 = (float)(j1 - i1) / ((float)j1 - 1.0F);
                        d5 = d5 * (1.0D - d11) + -30D * d11;
                    }
                    p_73187_1_[i] = d5;
                    i++;
                }

            }

        }

        return p_73187_1_;
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
        BiomeGenBase biomegenbase = field_73200_m.func_72807_a(i + 16, j + 16);
        biomegenbase.func_76728_a(field_73200_m, field_73200_m.field_73012_v, i, j);
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
        return "RandomLevelSource";
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
    {
        BiomeGenBase biomegenbase = field_73200_m.func_72807_a(p_73155_2_, p_73155_4_);
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
