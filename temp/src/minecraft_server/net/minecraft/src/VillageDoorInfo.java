// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class VillageDoorInfo
{

    public final int field_75481_a;
    public final int field_75479_b;
    public final int field_75480_c;
    public final int field_75477_d;
    public final int field_75478_e;
    public int field_75475_f;
    public boolean field_75476_g;
    private int field_75482_h;

    public VillageDoorInfo(int p_i3509_1_, int p_i3509_2_, int p_i3509_3_, int p_i3509_4_, int p_i3509_5_, int p_i3509_6_)
    {
        field_75476_g = false;
        field_75482_h = 0;
        field_75481_a = p_i3509_1_;
        field_75479_b = p_i3509_2_;
        field_75480_c = p_i3509_3_;
        field_75477_d = p_i3509_4_;
        field_75478_e = p_i3509_5_;
        field_75475_f = p_i3509_6_;
    }

    public int func_75474_b(int p_75474_1_, int p_75474_2_, int p_75474_3_)
    {
        int i = p_75474_1_ - field_75481_a;
        int j = p_75474_2_ - field_75479_b;
        int k = p_75474_3_ - field_75480_c;
        return i * i + j * j + k * k;
    }

    public int func_75469_c(int p_75469_1_, int p_75469_2_, int p_75469_3_)
    {
        int i = p_75469_1_ - field_75481_a - field_75477_d;
        int j = p_75469_2_ - field_75479_b;
        int k = p_75469_3_ - field_75480_c - field_75478_e;
        return i * i + j * j + k * k;
    }

    public int func_75471_a()
    {
        return field_75481_a + field_75477_d;
    }

    public int func_75473_b()
    {
        return field_75479_b;
    }

    public int func_75472_c()
    {
        return field_75480_c + field_75478_e;
    }

    public boolean func_75467_a(int p_75467_1_, int p_75467_2_)
    {
        int i = p_75467_1_ - field_75481_a;
        int j = p_75467_2_ - field_75480_c;
        return i * field_75477_d + j * field_75478_e >= 0;
    }

    public void func_75466_d()
    {
        field_75482_h = 0;
    }

    public void func_75470_e()
    {
        field_75482_h++;
    }

    public int func_75468_f()
    {
        return field_75482_h;
    }
}
