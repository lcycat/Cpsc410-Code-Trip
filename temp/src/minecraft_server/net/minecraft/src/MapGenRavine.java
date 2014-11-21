// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            MapGenBase, MathHelper, Block, BlockGrass, 
//            World, BiomeGenBase

public class MapGenRavine extends MapGenBase
{

    private float field_75046_d[];

    public MapGenRavine()
    {
        field_75046_d = new float[1024];
    }

    protected void func_75045_a(long p_75045_1_, int p_75045_3_, int p_75045_4_, byte p_75045_5_[], double p_75045_6_, 
            double p_75045_8_, double p_75045_10_, float p_75045_12_, float p_75045_13_, float p_75045_14_, 
            int p_75045_15_, int p_75045_16_, double p_75045_17_)
    {
        Random random = new Random(p_75045_1_);
        double d = p_75045_3_ * 16 + 8;
        double d1 = p_75045_4_ * 16 + 8;
        float f = 0.0F;
        float f1 = 0.0F;
        if(p_75045_16_ <= 0)
        {
            int i = field_75040_a * 16 - 16;
            p_75045_16_ = i - random.nextInt(i / 4);
        }
        boolean flag = false;
        if(p_75045_15_ == -1)
        {
            p_75045_15_ = p_75045_16_ / 2;
            flag = true;
        }
        float f2 = 1.0F;
        for(int j = 0; j < 128; j++)
        {
            if(j == 0 || random.nextInt(3) == 0)
            {
                f2 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
            }
            field_75046_d[j] = f2 * f2;
        }

        for(; p_75045_15_ < p_75045_16_; p_75045_15_++)
        {
            double d2 = 1.5D + (double)(MathHelper.func_76126_a(((float)p_75045_15_ * 3.141593F) / (float)p_75045_16_) * p_75045_12_ * 1.0F);
            double d3 = d2 * p_75045_17_;
            d2 *= (double)random.nextFloat() * 0.25D + 0.75D;
            d3 *= (double)random.nextFloat() * 0.25D + 0.75D;
            float f3 = MathHelper.func_76134_b(p_75045_14_);
            float f4 = MathHelper.func_76126_a(p_75045_14_);
            p_75045_6_ += MathHelper.func_76134_b(p_75045_13_) * f3;
            p_75045_8_ += f4;
            p_75045_10_ += MathHelper.func_76126_a(p_75045_13_) * f3;
            p_75045_14_ *= 0.7F;
            p_75045_14_ += f1 * 0.05F;
            p_75045_13_ += f * 0.05F;
            f1 *= 0.8F;
            f *= 0.5F;
            f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
            f += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4F;
            if(!flag && random.nextInt(4) == 0)
            {
                continue;
            }
            double d4 = p_75045_6_ - d;
            double d5 = p_75045_10_ - d1;
            double d6 = p_75045_16_ - p_75045_15_;
            double d7 = p_75045_12_ + 2.0F + 16F;
            if((d4 * d4 + d5 * d5) - d6 * d6 > d7 * d7)
            {
                return;
            }
            if(p_75045_6_ < d - 16D - d2 * 2D || p_75045_10_ < d1 - 16D - d2 * 2D || p_75045_6_ > d + 16D + d2 * 2D || p_75045_10_ > d1 + 16D + d2 * 2D)
            {
                continue;
            }
            d4 = MathHelper.func_76128_c(p_75045_6_ - d2) - p_75045_3_ * 16 - 1;
            int k = (MathHelper.func_76128_c(p_75045_6_ + d2) - p_75045_3_ * 16) + 1;
            d5 = MathHelper.func_76128_c(p_75045_8_ - d3) - 1;
            int l = MathHelper.func_76128_c(p_75045_8_ + d3) + 1;
            d6 = MathHelper.func_76128_c(p_75045_10_ - d2) - p_75045_4_ * 16 - 1;
            int i1 = (MathHelper.func_76128_c(p_75045_10_ + d2) - p_75045_4_ * 16) + 1;
            if(d4 < 0)
            {
                d4 = 0;
            }
            if(k > 16)
            {
                k = 16;
            }
            if(d5 < 1)
            {
                d5 = 1;
            }
            if(l > 120)
            {
                l = 120;
            }
            if(d6 < 0)
            {
                d6 = 0;
            }
            if(i1 > 16)
            {
                i1 = 16;
            }
            boolean flag1 = false;
            for(int j1 = d4; !flag1 && j1 < k; j1++)
            {
                for(int l1 = d6; !flag1 && l1 < i1; l1++)
                {
                    for(int i2 = l + 1; !flag1 && i2 >= d5 - 1; i2--)
                    {
                        int j2 = (j1 * 16 + l1) * 128 + i2;
                        if(i2 < 0 || i2 >= 128)
                        {
                            continue;
                        }
                        if(p_75045_5_[j2] == Block.field_71942_A.field_71990_ca || p_75045_5_[j2] == Block.field_71943_B.field_71990_ca)
                        {
                            flag1 = true;
                        }
                        if(i2 != d5 - 1 && j1 != d4 && j1 != k - 1 && l1 != d6 && l1 != i1 - 1)
                        {
                            i2 = d5;
                        }
                    }

                }

            }

            if(flag1)
            {
                continue;
            }
            for(int k1 = d4; k1 < k; k1++)
            {
                double d8 = (((double)(k1 + p_75045_3_ * 16) + 0.5D) - p_75045_6_) / d2;
label0:
                for(int k2 = d6; k2 < i1; k2++)
                {
                    double d9 = (((double)(k2 + p_75045_4_ * 16) + 0.5D) - p_75045_10_) / d2;
                    int l2 = (k1 * 16 + k2) * 128 + l;
                    boolean flag2 = false;
                    if(d8 * d8 + d9 * d9 >= 1.0D)
                    {
                        continue;
                    }
                    int i3 = l - 1;
                    do
                    {
                        if(i3 < d5)
                        {
                            continue label0;
                        }
                        double d10 = (((double)i3 + 0.5D) - p_75045_8_) / d3;
                        if((d8 * d8 + d9 * d9) * (double)field_75046_d[i3] + (d10 * d10) / 6D < 1.0D)
                        {
                            byte byte0 = p_75045_5_[l2];
                            if(byte0 == Block.field_71980_u.field_71990_ca)
                            {
                                flag2 = true;
                            }
                            if(byte0 == Block.field_71981_t.field_71990_ca || byte0 == Block.field_71979_v.field_71990_ca || byte0 == Block.field_71980_u.field_71990_ca)
                            {
                                if(i3 < 10)
                                {
                                    p_75045_5_[l2] = (byte)Block.field_71944_C.field_71990_ca;
                                } else
                                {
                                    p_75045_5_[l2] = 0;
                                    if(flag2 && p_75045_5_[l2 - 1] == Block.field_71979_v.field_71990_ca)
                                    {
                                        p_75045_5_[l2 - 1] = field_75039_c.func_72807_a(k1 + p_75045_3_ * 16, k2 + p_75045_4_ * 16).field_76752_A;
                                    }
                                }
                            }
                        }
                        l2--;
                        i3--;
                    } while(true);
                }

            }

            if(flag)
            {
                break;
            }
        }

    }

    protected void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte p_75037_6_[])
    {
        if(field_75038_b.nextInt(50) != 0)
        {
            return;
        }
        double d = p_75037_2_ * 16 + field_75038_b.nextInt(16);
        double d1 = field_75038_b.nextInt(field_75038_b.nextInt(40) + 8) + 20;
        double d2 = p_75037_3_ * 16 + field_75038_b.nextInt(16);
        int i = 1;
        for(int j = 0; j < i; j++)
        {
            float f = field_75038_b.nextFloat() * 3.141593F * 2.0F;
            float f1 = ((field_75038_b.nextFloat() - 0.5F) * 2.0F) / 8F;
            float f2 = (field_75038_b.nextFloat() * 2.0F + field_75038_b.nextFloat()) * 2.0F;
            func_75045_a(field_75038_b.nextLong(), p_75037_4_, p_75037_5_, p_75037_6_, d, d1, d2, f2, f, f1, 0, 0, 3D);
        }

    }
}
