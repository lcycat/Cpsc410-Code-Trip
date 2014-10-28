// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class Timer
{

    float field_74282_a;
    private double field_74276_f;
    public int field_74280_b;
    public float field_74281_c;
    public float field_74278_d;
    public float field_74279_e;
    private long field_74277_g;
    private long field_74284_h;
    private long field_74285_i;
    private double field_74283_j;

    public Timer(float p_i3005_1_)
    {
        field_74278_d = 1.0F;
        field_74279_e = 0.0F;
        field_74283_j = 1.0D;
        field_74282_a = p_i3005_1_;
        field_74277_g = Minecraft.func_71386_F();
        field_74284_h = System.nanoTime() / 0xf4240L;
    }

    public void func_74275_a()
    {
        long l = Minecraft.func_71386_F();
        long l1 = l - field_74277_g;
        long l2 = System.nanoTime() / 0xf4240L;
        double d = (double)l2 / 1000D;
        if(l1 > 1000L || l1 < 0L)
        {
            field_74276_f = d;
        } else
        {
            field_74285_i += l1;
            if(field_74285_i > 1000L)
            {
                long l3 = l2 - field_74284_h;
                double d2 = (double)field_74285_i / (double)l3;
                field_74283_j += (d2 - field_74283_j) * 0.20000000298023224D;
                field_74284_h = l2;
                field_74285_i = 0L;
            }
            if(field_74285_i < 0L)
            {
                field_74284_h = l2;
            }
        }
        field_74277_g = l;
        double d1 = (d - field_74276_f) * field_74283_j;
        field_74276_f = d;
        if(d1 < 0.0D)
        {
            d1 = 0.0D;
        }
        if(d1 > 1.0D)
        {
            d1 = 1.0D;
        }
        field_74279_e += d1 * (double)field_74278_d * (double)field_74282_a;
        field_74280_b = (int)field_74279_e;
        field_74279_e -= field_74280_b;
        if(field_74280_b > 10)
        {
            field_74280_b = 10;
        }
        field_74281_c = field_74279_e;
    }
}
