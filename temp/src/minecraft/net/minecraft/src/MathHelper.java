// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

public class MathHelper
{

    private static float field_76144_a[];

    public static final float func_76126_a(float p_76126_0_)
    {
        return field_76144_a[(int)(p_76126_0_ * 10430.38F) & 0xffff];
    }

    public static final float func_76134_b(float p_76134_0_)
    {
        return field_76144_a[(int)(p_76134_0_ * 10430.38F + 16384F) & 0xffff];
    }

    public static final float func_76129_c(float p_76129_0_)
    {
        return (float)Math.sqrt(p_76129_0_);
    }

    public static final float func_76133_a(double p_76133_0_)
    {
        return (float)Math.sqrt(p_76133_0_);
    }

    public static int func_76141_d(float p_76141_0_)
    {
        int i = (int)p_76141_0_;
        return p_76141_0_ >= (float)i ? i : i - 1;
    }

    public static int func_76140_b(double p_76140_0_)
    {
        return (int)(p_76140_0_ + 1024D) - 1024;
    }

    public static int func_76128_c(double p_76128_0_)
    {
        int i = (int)p_76128_0_;
        return p_76128_0_ >= (double)i ? i : i - 1;
    }

    public static long func_76124_d(double p_76124_0_)
    {
        long l = (long)p_76124_0_;
        return p_76124_0_ >= (double)l ? l : l - 1L;
    }

    public static float func_76135_e(float p_76135_0_)
    {
        return p_76135_0_ < 0.0F ? -p_76135_0_ : p_76135_0_;
    }

    public static int func_76130_a(int p_76130_0_)
    {
        return p_76130_0_ < 0 ? -p_76130_0_ : p_76130_0_;
    }

    public static int func_76123_f(float p_76123_0_)
    {
        int i = (int)p_76123_0_;
        return p_76123_0_ <= (float)i ? i : i + 1;
    }

    public static int func_76143_f(double p_76143_0_)
    {
        int i = (int)p_76143_0_;
        return p_76143_0_ <= (double)i ? i : i + 1;
    }

    public static int func_76125_a(int p_76125_0_, int p_76125_1_, int p_76125_2_)
    {
        if(p_76125_0_ < p_76125_1_)
        {
            return p_76125_1_;
        }
        if(p_76125_0_ > p_76125_2_)
        {
            return p_76125_2_;
        } else
        {
            return p_76125_0_;
        }
    }

    public static float func_76131_a(float p_76131_0_, float p_76131_1_, float p_76131_2_)
    {
        if(p_76131_0_ < p_76131_1_)
        {
            return p_76131_1_;
        }
        if(p_76131_0_ > p_76131_2_)
        {
            return p_76131_2_;
        } else
        {
            return p_76131_0_;
        }
    }

    public static double func_76132_a(double p_76132_0_, double p_76132_2_)
    {
        if(p_76132_0_ < 0.0D)
        {
            p_76132_0_ = -p_76132_0_;
        }
        if(p_76132_2_ < 0.0D)
        {
            p_76132_2_ = -p_76132_2_;
        }
        return p_76132_0_ <= p_76132_2_ ? p_76132_2_ : p_76132_0_;
    }

    public static int func_76137_a(int p_76137_0_, int p_76137_1_)
    {
        if(p_76137_0_ < 0)
        {
            return -((-p_76137_0_ - 1) / p_76137_1_) - 1;
        } else
        {
            return p_76137_0_ / p_76137_1_;
        }
    }

    public static boolean func_76139_a(String p_76139_0_)
    {
        return p_76139_0_ == null || p_76139_0_.length() == 0;
    }

    public static int func_76136_a(Random p_76136_0_, int p_76136_1_, int p_76136_2_)
    {
        if(p_76136_1_ >= p_76136_2_)
        {
            return p_76136_1_;
        } else
        {
            return p_76136_0_.nextInt((p_76136_2_ - p_76136_1_) + 1) + p_76136_1_;
        }
    }

    public static double func_76127_a(long p_76127_0_[])
    {
        long l = 0L;
        long al[] = p_76127_0_;
        int i = al.length;
        for(int j = 0; j < i; j++)
        {
            long l1 = al[j];
            l += l1;
        }

        return (double)l / (double)p_76127_0_.length;
    }

    public static float func_76142_g(float p_76142_0_)
    {
        p_76142_0_ %= 360F;
        if(p_76142_0_ >= 180F)
        {
            p_76142_0_ -= 360F;
        }
        if(p_76142_0_ < -180F)
        {
            p_76142_0_ += 360F;
        }
        return p_76142_0_;
    }

    public static double func_76138_g(double p_76138_0_)
    {
        p_76138_0_ %= 360D;
        if(p_76138_0_ >= 180D)
        {
            p_76138_0_ -= 360D;
        }
        if(p_76138_0_ < -180D)
        {
            p_76138_0_ += 360D;
        }
        return p_76138_0_;
    }

    static 
    {
        field_76144_a = new float[0x10000];
        for(int i = 0; i < 0x10000; i++)
        {
            field_76144_a[i] = (float)Math.sin(((double)i * 3.1415926535897931D * 2D) / 65536D);
        }

    }
}
