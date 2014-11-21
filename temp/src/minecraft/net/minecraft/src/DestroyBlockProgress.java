// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class DestroyBlockProgress
{

    private final int field_73115_a;
    private final int field_73113_b;
    private final int field_73114_c;
    private final int field_73111_d;
    private int field_73112_e;

    public DestroyBlockProgress(int p_i3385_1_, int p_i3385_2_, int p_i3385_3_, int p_i3385_4_)
    {
        field_73115_a = p_i3385_1_;
        field_73113_b = p_i3385_2_;
        field_73114_c = p_i3385_3_;
        field_73111_d = p_i3385_4_;
    }

    public int func_73110_b()
    {
        return field_73113_b;
    }

    public int func_73109_c()
    {
        return field_73114_c;
    }

    public int func_73108_d()
    {
        return field_73111_d;
    }

    public void func_73107_a(int p_73107_1_)
    {
        if(p_73107_1_ > 10)
        {
            p_73107_1_ = 10;
        }
        field_73112_e = p_73107_1_;
    }

    public int func_73106_e()
    {
        return field_73112_e;
    }
}
