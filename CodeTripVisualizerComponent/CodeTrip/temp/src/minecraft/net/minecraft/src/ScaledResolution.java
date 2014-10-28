// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GameSettings, MathHelper

public class ScaledResolution
{

    private int field_78333_a;
    private int field_78331_b;
    private double field_78332_c;
    private double field_78329_d;
    private int field_78330_e;

    public ScaledResolution(GameSettings p_i3065_1_, int p_i3065_2_, int p_i3065_3_)
    {
        field_78333_a = p_i3065_2_;
        field_78331_b = p_i3065_3_;
        field_78330_e = 1;
        int i = p_i3065_1_.field_74335_Z;
        if(i == 0)
        {
            i = 1000;
        }
        for(; field_78330_e < i && field_78333_a / (field_78330_e + 1) >= 320 && field_78331_b / (field_78330_e + 1) >= 240; field_78330_e++) { }
        field_78332_c = (double)field_78333_a / (double)field_78330_e;
        field_78329_d = (double)field_78331_b / (double)field_78330_e;
        field_78333_a = MathHelper.func_76143_f(field_78332_c);
        field_78331_b = MathHelper.func_76143_f(field_78329_d);
    }

    public int func_78326_a()
    {
        return field_78333_a;
    }

    public int func_78328_b()
    {
        return field_78331_b;
    }

    public double func_78327_c()
    {
        return field_78332_c;
    }

    public double func_78324_d()
    {
        return field_78329_d;
    }

    public int func_78325_e()
    {
        return field_78330_e;
    }
}
