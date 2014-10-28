// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            MathHelper

public class PathPoint
{

    public final int field_75839_a;
    public final int field_75837_b;
    public final int field_75838_c;
    private final int field_75840_j;
    int field_75835_d;
    float field_75836_e;
    float field_75833_f;
    float field_75834_g;
    PathPoint field_75841_h;
    public boolean field_75842_i;

    public PathPoint(int p_i3901_1_, int p_i3901_2_, int p_i3901_3_)
    {
        field_75835_d = -1;
        field_75842_i = false;
        field_75839_a = p_i3901_1_;
        field_75837_b = p_i3901_2_;
        field_75838_c = p_i3901_3_;
        field_75840_j = func_75830_a(p_i3901_1_, p_i3901_2_, p_i3901_3_);
    }

    public static int func_75830_a(int p_75830_0_, int p_75830_1_, int p_75830_2_)
    {
        return p_75830_1_ & 0xff | (p_75830_0_ & 0x7fff) << 8 | (p_75830_2_ & 0x7fff) << 24 | (p_75830_0_ >= 0 ? 0 : 0x80000000) | (p_75830_2_ >= 0 ? 0 : 0x8000);
    }

    public float func_75829_a(PathPoint p_75829_1_)
    {
        float f = p_75829_1_.field_75839_a - field_75839_a;
        float f1 = p_75829_1_.field_75837_b - field_75837_b;
        float f2 = p_75829_1_.field_75838_c - field_75838_c;
        return MathHelper.func_76129_c(f * f + f1 * f1 + f2 * f2);
    }

    public float func_75832_b(PathPoint p_75832_1_)
    {
        float f = p_75832_1_.field_75839_a - field_75839_a;
        float f1 = p_75832_1_.field_75837_b - field_75837_b;
        float f2 = p_75832_1_.field_75838_c - field_75838_c;
        return f * f + f1 * f1 + f2 * f2;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ instanceof PathPoint)
        {
            PathPoint pathpoint = (PathPoint)p_equals_1_;
            return field_75840_j == pathpoint.field_75840_j && field_75839_a == pathpoint.field_75839_a && field_75837_b == pathpoint.field_75837_b && field_75838_c == pathpoint.field_75838_c;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return field_75840_j;
    }

    public boolean func_75831_a()
    {
        return field_75835_d >= 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append(field_75839_a).append(", ").append(field_75837_b).append(", ").append(field_75838_c).toString();
    }
}
