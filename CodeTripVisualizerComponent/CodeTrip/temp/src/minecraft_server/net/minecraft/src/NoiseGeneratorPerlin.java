// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            NoiseGenerator

public class NoiseGeneratorPerlin extends NoiseGenerator
{

    private int field_76312_d[];
    public double field_76315_a;
    public double field_76313_b;
    public double field_76314_c;

    public NoiseGeneratorPerlin()
    {
        this(new Random());
    }

    public NoiseGeneratorPerlin(Random p_i3876_1_)
    {
        field_76312_d = new int[512];
        field_76315_a = p_i3876_1_.nextDouble() * 256D;
        field_76313_b = p_i3876_1_.nextDouble() * 256D;
        field_76314_c = p_i3876_1_.nextDouble() * 256D;
        for(int i = 0; i < 256; i++)
        {
            field_76312_d[i] = i;
        }

        for(int j = 0; j < 256; j++)
        {
            int k = p_i3876_1_.nextInt(256 - j) + j;
            int l = field_76312_d[j];
            field_76312_d[j] = field_76312_d[k];
            field_76312_d[k] = l;
            field_76312_d[j + 256] = field_76312_d[j];
        }

    }

    public final double func_76311_b(double p_76311_1_, double p_76311_3_, double p_76311_5_)
    {
        return p_76311_3_ + p_76311_1_ * (p_76311_5_ - p_76311_3_);
    }

    public final double func_76309_a(int p_76309_1_, double p_76309_2_, double p_76309_4_)
    {
        int i = p_76309_1_ & 0xf;
        double d = (double)(1 - ((i & 8) >> 3)) * p_76309_2_;
        double d1 = i >= 4 ? i != 12 && i != 14 ? p_76309_4_ : p_76309_2_ : 0.0D;
        return ((i & 1) != 0 ? -d : d) + ((i & 2) != 0 ? -d1 : d1);
    }

    public final double func_76310_a(int p_76310_1_, double p_76310_2_, double p_76310_4_, double p_76310_6_)
    {
        int i = p_76310_1_ & 0xf;
        double d = i >= 8 ? p_76310_4_ : p_76310_2_;
        double d1 = i >= 4 ? i != 12 && i != 14 ? p_76310_6_ : p_76310_2_ : p_76310_4_;
        return ((i & 1) != 0 ? -d : d) + ((i & 2) != 0 ? -d1 : d1);
    }

    public void func_76308_a(double p_76308_1_[], double p_76308_2_, double p_76308_4_, double p_76308_6_, 
            int p_76308_8_, int p_76308_9_, int p_76308_10_, double p_76308_11_, double p_76308_13_, 
            double p_76308_15_, double p_76308_17_)
    {
        if(p_76308_9_ == 1)
        {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            double d1 = 0.0D;
            double d3 = 0.0D;
            int k2 = 0;
            double d5 = 1.0D / p_76308_17_;
            for(int j3 = 0; j3 < p_76308_8_; j3++)
            {
                double d7 = p_76308_2_ + (double)j3 * p_76308_11_ + field_76315_a;
                int k3 = (int)d7;
                if(d7 < (double)k3)
                {
                    k3--;
                }
                int l3 = k3 & 0xff;
                d7 -= k3;
                double d10 = d7 * d7 * d7 * (d7 * (d7 * 6D - 15D) + 10D);
                for(int i4 = 0; i4 < p_76308_10_; i4++)
                {
                    double d12 = p_76308_6_ + (double)i4 * p_76308_15_ + field_76314_c;
                    int k4 = (int)d12;
                    if(d12 < (double)k4)
                    {
                        k4--;
                    }
                    int i5 = k4 & 0xff;
                    d12 -= k4;
                    double d14 = d12 * d12 * d12 * (d12 * (d12 * 6D - 15D) + 10D);
                    int i = field_76312_d[l3] + 0;
                    int k = field_76312_d[i] + i5;
                    int l = field_76312_d[l3 + 1] + 0;
                    int i1 = field_76312_d[l] + i5;
                    double d2 = func_76311_b(d10, func_76309_a(field_76312_d[k], d7, d12), func_76310_a(field_76312_d[i1], d7 - 1.0D, 0.0D, d12));
                    double d4 = func_76311_b(d10, func_76310_a(field_76312_d[k + 1], d7, 0.0D, d12 - 1.0D), func_76310_a(field_76312_d[i1 + 1], d7 - 1.0D, 0.0D, d12 - 1.0D));
                    double d16 = func_76311_b(d14, d2, d4);
                    p_76308_1_[k2++] += d16 * d5;
                }

            }

            return;
        }
        int j = 0;
        double d = 1.0D / p_76308_17_;
        int j1 = -1;
        boolean flag4 = false;
        boolean flag5 = false;
        boolean flag6 = false;
        boolean flag7 = false;
        boolean flag8 = false;
        boolean flag9 = false;
        double d6 = 0.0D;
        double d8 = 0.0D;
        double d9 = 0.0D;
        double d11 = 0.0D;
        for(int j4 = 0; j4 < p_76308_8_; j4++)
        {
            double d13 = p_76308_2_ + (double)j4 * p_76308_11_ + field_76315_a;
            int l4 = (int)d13;
            if(d13 < (double)l4)
            {
                l4--;
            }
            int j5 = l4 & 0xff;
            d13 -= l4;
            double d15 = d13 * d13 * d13 * (d13 * (d13 * 6D - 15D) + 10D);
            for(int k5 = 0; k5 < p_76308_10_; k5++)
            {
                double d17 = p_76308_6_ + (double)k5 * p_76308_15_ + field_76314_c;
                int l5 = (int)d17;
                if(d17 < (double)l5)
                {
                    l5--;
                }
                int i6 = l5 & 0xff;
                d17 -= l5;
                double d18 = d17 * d17 * d17 * (d17 * (d17 * 6D - 15D) + 10D);
                for(int j6 = 0; j6 < p_76308_9_; j6++)
                {
                    double d19 = p_76308_4_ + (double)j6 * p_76308_13_ + field_76313_b;
                    int k6 = (int)d19;
                    if(d19 < (double)k6)
                    {
                        k6--;
                    }
                    int l6 = k6 & 0xff;
                    d19 -= k6;
                    double d20 = d19 * d19 * d19 * (d19 * (d19 * 6D - 15D) + 10D);
                    if(j6 == 0 || l6 != j1)
                    {
                        j1 = l6;
                        int k1 = field_76312_d[j5] + l6;
                        int l1 = field_76312_d[k1] + i6;
                        int i2 = field_76312_d[k1 + 1] + i6;
                        int j2 = field_76312_d[j5 + 1] + l6;
                        int l2 = field_76312_d[j2] + i6;
                        int i3 = field_76312_d[j2 + 1] + i6;
                        d6 = func_76311_b(d15, func_76310_a(field_76312_d[l1], d13, d19, d17), func_76310_a(field_76312_d[l2], d13 - 1.0D, d19, d17));
                        d8 = func_76311_b(d15, func_76310_a(field_76312_d[i2], d13, d19 - 1.0D, d17), func_76310_a(field_76312_d[i3], d13 - 1.0D, d19 - 1.0D, d17));
                        d9 = func_76311_b(d15, func_76310_a(field_76312_d[l1 + 1], d13, d19, d17 - 1.0D), func_76310_a(field_76312_d[l2 + 1], d13 - 1.0D, d19, d17 - 1.0D));
                        d11 = func_76311_b(d15, func_76310_a(field_76312_d[i2 + 1], d13, d19 - 1.0D, d17 - 1.0D), func_76310_a(field_76312_d[i3 + 1], d13 - 1.0D, d19 - 1.0D, d17 - 1.0D));
                    }
                    double d21 = func_76311_b(d20, d6, d8);
                    double d22 = func_76311_b(d20, d9, d11);
                    double d23 = func_76311_b(d18, d21, d22);
                    p_76308_1_[j++] += d23 * d;
                }

            }

        }

    }
}
