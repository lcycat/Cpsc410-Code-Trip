// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            IChunkProvider, MapGenCaves, MapGenStronghold, MapGenVillage, 
//            MapGenMineshaft, MapGenScatteredFeature, MapGenRavine, NoiseGeneratorOctaves, 
//            World, WorldChunkManager, Block, BiomeGenBase, 
//            MapGenBase, Chunk, MathHelper, BlockSand, 
//            WorldGenLakes, WorldGenDungeons, SpawnerAnimals, IProgressUpdate, 
//            EnumCreatureType, ChunkPosition

public class ChunkProviderGenerate
    implements IChunkProvider
{

    private Random field_73220_k;
    private NoiseGeneratorOctaves field_73217_l;
    private NoiseGeneratorOctaves field_73218_m;
    private NoiseGeneratorOctaves field_73215_n;
    private NoiseGeneratorOctaves field_73216_o;
    public NoiseGeneratorOctaves field_73214_a;
    public NoiseGeneratorOctaves field_73212_b;
    public NoiseGeneratorOctaves field_73213_c;
    private World field_73230_p;
    private final boolean field_73229_q;
    private double field_73228_r[];
    private double field_73227_s[];
    private MapGenBase field_73226_t;
    private MapGenStronghold field_73225_u;
    private MapGenVillage field_73224_v;
    private MapGenMineshaft field_73223_w;
    private MapGenScatteredFeature field_73233_x;
    private MapGenBase field_73232_y;
    private BiomeGenBase field_73231_z[];
    double field_73210_d[];
    double field_73211_e[];
    double field_73208_f[];
    double field_73209_g[];
    double field_73221_h[];
    float field_73222_i[];
    int field_73219_j[][];

    public ChunkProviderGenerate(World p_i3782_1_, long p_i3782_2_, boolean p_i3782_4_)
    {
        field_73227_s = new double[256];
        field_73226_t = new MapGenCaves();
        field_73225_u = new MapGenStronghold();
        field_73224_v = new MapGenVillage(0);
        field_73223_w = new MapGenMineshaft();
        field_73233_x = new MapGenScatteredFeature();
        field_73232_y = new MapGenRavine();
        field_73219_j = new int[32][32];
        field_73230_p = p_i3782_1_;
        field_73229_q = p_i3782_4_;
        field_73220_k = new Random(p_i3782_2_);
        field_73217_l = new NoiseGeneratorOctaves(field_73220_k, 16);
        field_73218_m = new NoiseGeneratorOctaves(field_73220_k, 16);
        field_73215_n = new NoiseGeneratorOctaves(field_73220_k, 8);
        field_73216_o = new NoiseGeneratorOctaves(field_73220_k, 4);
        field_73214_a = new NoiseGeneratorOctaves(field_73220_k, 10);
        field_73212_b = new NoiseGeneratorOctaves(field_73220_k, 16);
        field_73213_c = new NoiseGeneratorOctaves(field_73220_k, 8);
    }

    public void func_73206_a(int p_73206_1_, int p_73206_2_, byte p_73206_3_[])
    {
        byte byte0 = 4;
        byte byte1 = 16;
        byte byte2 = 63;
        int i = byte0 + 1;
        byte byte3 = 17;
        int j = byte0 + 1;
        field_73231_z = field_73230_p.func_72959_q().func_76937_a(field_73231_z, p_73206_1_ * 4 - 2, p_73206_2_ * 4 - 2, i + 5, j + 5);
        field_73228_r = func_73205_a(field_73228_r, p_73206_1_ * byte0, 0, p_73206_2_ * byte0, i, byte3, j);
        for(int k = 0; k < byte0; k++)
        {
            for(int l = 0; l < byte0; l++)
            {
                for(int i1 = 0; i1 < byte1; i1++)
                {
                    double d = 0.125D;
                    double d1 = field_73228_r[((k + 0) * j + (l + 0)) * byte3 + (i1 + 0)];
                    double d2 = field_73228_r[((k + 0) * j + (l + 1)) * byte3 + (i1 + 0)];
                    double d3 = field_73228_r[((k + 1) * j + (l + 0)) * byte3 + (i1 + 0)];
                    double d4 = field_73228_r[((k + 1) * j + (l + 1)) * byte3 + (i1 + 0)];
                    double d5 = (field_73228_r[((k + 0) * j + (l + 0)) * byte3 + (i1 + 1)] - d1) * d;
                    double d6 = (field_73228_r[((k + 0) * j + (l + 1)) * byte3 + (i1 + 1)] - d2) * d;
                    double d7 = (field_73228_r[((k + 1) * j + (l + 0)) * byte3 + (i1 + 1)] - d3) * d;
                    double d8 = (field_73228_r[((k + 1) * j + (l + 1)) * byte3 + (i1 + 1)] - d4) * d;
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
                            l1 -= c;
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            d15 -= d16;
                            for(int i2 = 0; i2 < 4; i2++)
                            {
                                if((d15 += d16) > 0.0D)
                                {
                                    p_73206_3_[l1 += c] = (byte)Block.field_71981_t.field_71990_ca;
                                    continue;
                                }
                                if(i1 * 8 + j1 < byte2)
                                {
                                    p_73206_3_[l1 += c] = (byte)Block.field_71943_B.field_71990_ca;
                                } else
                                {
                                    p_73206_3_[l1 += c] = 0;
                                }
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

    public void func_73207_a(int p_73207_1_, int p_73207_2_, byte p_73207_3_[], BiomeGenBase p_73207_4_[])
    {
        byte byte0 = 63;
        double d = 0.03125D;
        field_73227_s = field_73216_o.func_76304_a(field_73227_s, p_73207_1_ * 16, p_73207_2_ * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
        for(int i = 0; i < 16; i++)
        {
            for(int j = 0; j < 16; j++)
            {
                BiomeGenBase biomegenbase = p_73207_4_[j + i * 16];
                float f = biomegenbase.func_76743_j();
                int k = (int)(field_73227_s[i + j * 16] / 3D + 3D + field_73220_k.nextDouble() * 0.25D);
                int l = -1;
                byte byte1 = biomegenbase.field_76752_A;
                byte byte2 = biomegenbase.field_76753_B;
                for(int i1 = 127; i1 >= 0; i1--)
                {
                    int j1 = (j * 16 + i) * 128 + i1;
                    if(i1 <= 0 + field_73220_k.nextInt(5))
                    {
                        p_73207_3_[j1] = (byte)Block.field_71986_z.field_71990_ca;
                        continue;
                    }
                    byte byte3 = p_73207_3_[j1];
                    if(byte3 == 0)
                    {
                        l = -1;
                        continue;
                    }
                    if(byte3 != Block.field_71981_t.field_71990_ca)
                    {
                        continue;
                    }
                    if(l == -1)
                    {
                        if(k <= 0)
                        {
                            byte1 = 0;
                            byte2 = (byte)Block.field_71981_t.field_71990_ca;
                        } else
                        if(i1 >= byte0 - 4 && i1 <= byte0 + 1)
                        {
                            byte1 = biomegenbase.field_76752_A;
                            byte2 = biomegenbase.field_76753_B;
                        }
                        if(i1 < byte0 && byte1 == 0)
                        {
                            if(f < 0.15F)
                            {
                                byte1 = (byte)Block.field_72036_aT.field_71990_ca;
                            } else
                            {
                                byte1 = (byte)Block.field_71943_B.field_71990_ca;
                            }
                        }
                        l = k;
                        if(i1 >= byte0 - 1)
                        {
                            p_73207_3_[j1] = byte1;
                        } else
                        {
                            p_73207_3_[j1] = byte2;
                        }
                        continue;
                    }
                    if(l <= 0)
                    {
                        continue;
                    }
                    l--;
                    p_73207_3_[j1] = byte2;
                    if(l == 0 && byte2 == Block.field_71939_E.field_71990_ca)
                    {
                        l = field_73220_k.nextInt(4);
                        byte2 = (byte)Block.field_71957_Q.field_71990_ca;
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
        field_73220_k.setSeed((long)p_73154_1_ * 0x4f9939f508L + (long)p_73154_2_ * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        func_73206_a(p_73154_1_, p_73154_2_, abyte0);
        field_73231_z = field_73230_p.func_72959_q().func_76933_b(field_73231_z, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
        func_73207_a(p_73154_1_, p_73154_2_, abyte0, field_73231_z);
        field_73226_t.func_75036_a(this, field_73230_p, p_73154_1_, p_73154_2_, abyte0);
        field_73232_y.func_75036_a(this, field_73230_p, p_73154_1_, p_73154_2_, abyte0);
        if(field_73229_q)
        {
            field_73223_w.func_75036_a(this, field_73230_p, p_73154_1_, p_73154_2_, abyte0);
            field_73224_v.func_75036_a(this, field_73230_p, p_73154_1_, p_73154_2_, abyte0);
            field_73225_u.func_75036_a(this, field_73230_p, p_73154_1_, p_73154_2_, abyte0);
            field_73233_x.func_75036_a(this, field_73230_p, p_73154_1_, p_73154_2_, abyte0);
        }
        Chunk chunk = new Chunk(field_73230_p, abyte0, p_73154_1_, p_73154_2_);
        byte abyte1[] = chunk.func_76605_m();
        for(int i = 0; i < abyte1.length; i++)
        {
            abyte1[i] = (byte)field_73231_z[i].field_76756_M;
        }

        chunk.func_76603_b();
        return chunk;
    }

    private double[] func_73205_a(double p_73205_1_[], int p_73205_2_, int p_73205_3_, int p_73205_4_, int p_73205_5_, int p_73205_6_, int p_73205_7_)
    {
        if(p_73205_1_ == null)
        {
            p_73205_1_ = new double[p_73205_5_ * p_73205_6_ * p_73205_7_];
        }
        if(field_73222_i == null)
        {
            field_73222_i = new float[25];
            for(int i = -2; i <= 2; i++)
            {
                for(int j = -2; j <= 2; j++)
                {
                    float f = 10F / MathHelper.func_76129_c((float)(i * i + j * j) + 0.2F);
                    field_73222_i[i + 2 + (j + 2) * 5] = f;
                }

            }

        }
        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        field_73209_g = field_73214_a.func_76305_a(field_73209_g, p_73205_2_, p_73205_4_, p_73205_5_, p_73205_7_, 1.121D, 1.121D, 0.5D);
        field_73221_h = field_73212_b.func_76305_a(field_73221_h, p_73205_2_, p_73205_4_, p_73205_5_, p_73205_7_, 200D, 200D, 0.5D);
        field_73210_d = field_73215_n.func_76304_a(field_73210_d, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, d / 80D, d1 / 160D, d / 80D);
        field_73211_e = field_73217_l.func_76304_a(field_73211_e, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, d, d1, d);
        field_73208_f = field_73218_m.func_76304_a(field_73208_f, p_73205_2_, p_73205_3_, p_73205_4_, p_73205_5_, p_73205_6_, p_73205_7_, d, d1, d);
        p_73205_2_ = p_73205_4_ = 0;
        int k = 0;
        int l = 0;
        for(int i1 = 0; i1 < p_73205_5_; i1++)
        {
            for(int j1 = 0; j1 < p_73205_7_; j1++)
            {
                float f1 = 0.0F;
                float f2 = 0.0F;
                float f3 = 0.0F;
                byte byte0 = 2;
                BiomeGenBase biomegenbase = field_73231_z[i1 + 2 + (j1 + 2) * (p_73205_5_ + 5)];
                for(int k1 = -byte0; k1 <= byte0; k1++)
                {
                    for(int l1 = -byte0; l1 <= byte0; l1++)
                    {
                        BiomeGenBase biomegenbase1 = field_73231_z[i1 + k1 + 2 + (j1 + l1 + 2) * (p_73205_5_ + 5)];
                        float f4 = field_73222_i[k1 + 2 + (l1 + 2) * 5] / (biomegenbase1.field_76748_D + 2.0F);
                        if(biomegenbase1.field_76748_D > biomegenbase.field_76748_D)
                        {
                            f4 /= 2.0F;
                        }
                        f1 += biomegenbase1.field_76749_E * f4;
                        f2 += biomegenbase1.field_76748_D * f4;
                        f3 += f4;
                    }

                }

                f1 /= f3;
                f2 /= f3;
                f1 = f1 * 0.9F + 0.1F;
                f2 = (f2 * 4F - 1.0F) / 8F;
                double d2 = field_73221_h[l] / 8000D;
                if(d2 < 0.0D)
                {
                    d2 = -d2 * 0.29999999999999999D;
                }
                d2 = d2 * 3D - 2D;
                if(d2 < 0.0D)
                {
                    d2 /= 2D;
                    if(d2 < -1D)
                    {
                        d2 = -1D;
                    }
                    d2 /= 1.3999999999999999D;
                    d2 /= 2D;
                } else
                {
                    if(d2 > 1.0D)
                    {
                        d2 = 1.0D;
                    }
                    d2 /= 8D;
                }
                l++;
                for(int i2 = 0; i2 < p_73205_6_; i2++)
                {
                    double d3 = f2;
                    double d4 = f1;
                    d3 += d2 * 0.20000000000000001D;
                    d3 = (d3 * (double)p_73205_6_) / 16D;
                    double d5 = (double)p_73205_6_ / 2D + d3 * 4D;
                    double d6 = 0.0D;
                    double d7 = (((double)i2 - d5) * 12D * 128D) / 128D / d4;
                    if(d7 < 0.0D)
                    {
                        d7 *= 4D;
                    }
                    double d8 = field_73211_e[k] / 512D;
                    double d9 = field_73208_f[k] / 512D;
                    double d10 = (field_73210_d[k] / 10D + 1.0D) / 2D;
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
                    if(i2 > p_73205_6_ - 4)
                    {
                        double d11 = (float)(i2 - (p_73205_6_ - 4)) / 3F;
                        d6 = d6 * (1.0D - d11) + -10D * d11;
                    }
                    p_73205_1_[k] = d6;
                    k++;
                }

            }

        }

        return p_73205_1_;
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
        BiomeGenBase biomegenbase = field_73230_p.func_72807_a(i + 16, j + 16);
        field_73220_k.setSeed(field_73230_p.func_72905_C());
        long l = (field_73220_k.nextLong() / 2L) * 2L + 1L;
        long l1 = (field_73220_k.nextLong() / 2L) * 2L + 1L;
        field_73220_k.setSeed((long)p_73153_2_ * l + (long)p_73153_3_ * l1 ^ field_73230_p.func_72905_C());
        boolean flag = false;
        if(field_73229_q)
        {
            field_73223_w.func_75051_a(field_73230_p, field_73220_k, p_73153_2_, p_73153_3_);
            flag = field_73224_v.func_75051_a(field_73230_p, field_73220_k, p_73153_2_, p_73153_3_);
            field_73225_u.func_75051_a(field_73230_p, field_73220_k, p_73153_2_, p_73153_3_);
            field_73233_x.func_75051_a(field_73230_p, field_73220_k, p_73153_2_, p_73153_3_);
        }
        if(!flag && field_73220_k.nextInt(4) == 0)
        {
            int k = i + field_73220_k.nextInt(16) + 8;
            int i2 = field_73220_k.nextInt(128);
            int i3 = j + field_73220_k.nextInt(16) + 8;
            (new WorldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(field_73230_p, field_73220_k, k, i2, i3);
        }
        if(!flag && field_73220_k.nextInt(8) == 0)
        {
            int i1 = i + field_73220_k.nextInt(16) + 8;
            int j2 = field_73220_k.nextInt(field_73220_k.nextInt(120) + 8);
            int j3 = j + field_73220_k.nextInt(16) + 8;
            if(j2 < 63 || field_73220_k.nextInt(10) == 0)
            {
                (new WorldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(field_73230_p, field_73220_k, i1, j2, j3);
            }
        }
        for(int j1 = 0; j1 < 8; j1++)
        {
            int k2 = i + field_73220_k.nextInt(16) + 8;
            int k3 = field_73220_k.nextInt(128);
            int i4 = j + field_73220_k.nextInt(16) + 8;
            if(!(new WorldGenDungeons()).func_76484_a(field_73230_p, field_73220_k, k2, k3, i4));
        }

        biomegenbase.func_76728_a(field_73230_p, field_73220_k, i, j);
        SpawnerAnimals.func_77191_a(field_73230_p, biomegenbase, i + 8, j + 8, 16, 16, field_73220_k);
        i += 8;
        j += 8;
        for(int k1 = 0; k1 < 16; k1++)
        {
            for(int l2 = 0; l2 < 16; l2++)
            {
                int l3 = field_73230_p.func_72874_g(i + k1, j + l2);
                if(field_73230_p.func_72884_u(k1 + i, l3 - 1, l2 + j))
                {
                    field_73230_p.func_72859_e(k1 + i, l3 - 1, l2 + j, Block.field_72036_aT.field_71990_ca);
                }
                if(field_73230_p.func_72858_w(k1 + i, l3, l2 + j))
                {
                    field_73230_p.func_72859_e(k1 + i, l3, l2 + j, Block.field_72037_aS.field_71990_ca);
                }
            }

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
        return "RandomLevelSource";
    }

    public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
    {
        BiomeGenBase biomegenbase = field_73230_p.func_72807_a(p_73155_2_, p_73155_4_);
        if(biomegenbase == null)
        {
            return null;
        } else
        {
            return biomegenbase.func_76747_a(p_73155_1_);
        }
    }

    public ChunkPosition func_73150_a(World p_73150_1_, String p_73150_2_, int p_73150_3_, int p_73150_4_, int p_73150_5_)
    {
        if("Stronghold".equals(p_73150_2_) && field_73225_u != null)
        {
            return field_73225_u.func_75050_a(p_73150_1_, p_73150_3_, p_73150_4_, p_73150_5_);
        } else
        {
            return null;
        }
    }

    public int func_73152_e()
    {
        return 0;
    }
}
