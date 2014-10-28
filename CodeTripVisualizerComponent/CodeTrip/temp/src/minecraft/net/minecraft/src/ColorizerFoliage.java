// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ColorizerFoliage
{

    private static int field_77471_a[] = new int[0x10000];

    public static void func_77467_a(int p_77467_0_[])
    {
        field_77471_a = p_77467_0_;
    }

    public static int func_77470_a(double p_77470_0_, double p_77470_2_)
    {
        p_77470_2_ *= p_77470_0_;
        int i = (int)((1.0D - p_77470_0_) * 255D);
        int j = (int)((1.0D - p_77470_2_) * 255D);
        return field_77471_a[j << 8 | i];
    }

    public static int func_77466_a()
    {
        return 0x619961;
    }

    public static int func_77469_b()
    {
        return 0x80a755;
    }

    public static int func_77468_c()
    {
        return 0x48b518;
    }

}
