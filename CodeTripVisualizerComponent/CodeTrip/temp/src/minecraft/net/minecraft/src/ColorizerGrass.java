// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class ColorizerGrass
{

    private static int field_77481_a[] = new int[0x10000];

    public static void func_77479_a(int p_77479_0_[])
    {
        field_77481_a = p_77479_0_;
    }

    public static int func_77480_a(double p_77480_0_, double p_77480_2_)
    {
        p_77480_2_ *= p_77480_0_;
        int i = (int)((1.0D - p_77480_0_) * 255D);
        int j = (int)((1.0D - p_77480_2_) * 255D);
        return field_77481_a[j << 8 | i];
    }

}
