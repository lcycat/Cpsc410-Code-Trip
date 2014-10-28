// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class StructureVillagePieceWeight
{

    public Class field_75090_a;
    public final int field_75088_b;
    public int field_75089_c;
    public int field_75087_d;

    public StructureVillagePieceWeight(Class p_i3864_1_, int p_i3864_2_, int p_i3864_3_)
    {
        field_75090_a = p_i3864_1_;
        field_75088_b = p_i3864_2_;
        field_75087_d = p_i3864_3_;
    }

    public boolean func_75085_a(int p_75085_1_)
    {
        return field_75087_d == 0 || field_75089_c < field_75087_d;
    }

    public boolean func_75086_a()
    {
        return field_75087_d == 0 || field_75089_c < field_75087_d;
    }
}
