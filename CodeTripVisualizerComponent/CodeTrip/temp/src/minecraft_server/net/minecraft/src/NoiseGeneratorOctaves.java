// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            NoiseGenerator, NoiseGeneratorPerlin, MathHelper

public class NoiseGeneratorOctaves extends NoiseGenerator
{

    private NoiseGeneratorPerlin field_76307_a[];
    private int field_76306_b;

    public NoiseGeneratorOctaves(Random p_i3877_1_, int p_i3877_2_)
    {
        field_76306_b = p_i3877_2_;
        field_76307_a = new NoiseGeneratorPerlin[p_i3877_2_];
        for(int i = 0; i < p_i3877_2_; i++)
        {
            field_76307_a[i] = new NoiseGeneratorPerlin(p_i3877_1_);
        }

    }

    public double[] func_76304_a(double p_76304_1_[], int p_76304_2_, int p_76304_3_, int p_76304_4_, int p_76304_5_, int p_76304_6_, int p_76304_7_, 
            double p_76304_8_, double p_76304_10_, double p_76304_12_)
    {
        if(p_76304_1_ == null)
        {
            p_76304_1_ = new double[p_76304_5_ * p_76304_6_ * p_76304_7_];
        } else
        {
            for(int i = 0; i < p_76304_1_.length; i++)
            {
                p_76304_1_[i] = 0.0D;
            }

        }
        double d = 1.0D;
        for(int j = 0; j < field_76306_b; j++)
        {
            double d1 = (double)p_76304_2_ * d * p_76304_8_;
            double d2 = (double)p_76304_3_ * d * p_76304_10_;
            double d3 = (double)p_76304_4_ * d * p_76304_12_;
            long l = MathHelper.func_76124_d(d1);
            long l1 = MathHelper.func_76124_d(d3);
            d1 -= l;
            d3 -= l1;
            l %= 0x1000000L;
            l1 %= 0x1000000L;
            d1 += l;
            d3 += l1;
            field_76307_a[j].func_76308_a(p_76304_1_, d1, d2, d3, p_76304_5_, p_76304_6_, p_76304_7_, p_76304_8_ * d, p_76304_10_ * d, p_76304_12_ * d, d);
            d /= 2D;
        }

        return p_76304_1_;
    }

    public double[] func_76305_a(double p_76305_1_[], int p_76305_2_, int p_76305_3_, int p_76305_4_, int p_76305_5_, double p_76305_6_, 
            double p_76305_8_, double p_76305_10_)
    {
        return func_76304_a(p_76305_1_, p_76305_2_, 10, p_76305_3_, p_76305_4_, 1, p_76305_5_, p_76305_6_, 1.0D, p_76305_8_);
    }
}
