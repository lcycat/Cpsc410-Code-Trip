// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            GuiParticle

public class Particle
{

    private static Random field_78080_s = new Random();
    public double field_78071_a;
    public double field_78069_b;
    public double field_78070_c;
    public double field_78067_d;
    public double field_78068_e;
    public double field_78065_f;
    public double field_78066_g;
    public boolean field_78078_h;
    public int field_78079_i;
    public int field_78076_j;
    public double field_78077_k;
    public double field_78074_l;
    public double field_78075_m;
    public double field_78072_n;
    public double field_78073_o;
    public double field_78083_p;
    public double field_78082_q;
    public double field_78081_r;

    public void func_78063_a(GuiParticle p_78063_1_)
    {
        field_78071_a += field_78068_e;
        field_78069_b += field_78065_f;
        field_78068_e *= field_78066_g;
        field_78065_f *= field_78066_g;
        field_78065_f += 0.10000000000000001D;
        if(++field_78079_i > field_78076_j)
        {
            func_78064_b();
        }
        field_78072_n = 2D - ((double)field_78079_i / (double)field_78076_j) * 2D;
        if(field_78072_n > 1.0D)
        {
            field_78072_n = 1.0D;
        }
        field_78072_n *= field_78072_n;
        field_78072_n *= 0.5D;
    }

    public void func_78062_a()
    {
        field_78073_o = field_78077_k;
        field_78083_p = field_78074_l;
        field_78082_q = field_78075_m;
        field_78081_r = field_78072_n;
        field_78070_c = field_78071_a;
        field_78067_d = field_78069_b;
    }

    public void func_78064_b()
    {
        field_78078_h = true;
    }

}
