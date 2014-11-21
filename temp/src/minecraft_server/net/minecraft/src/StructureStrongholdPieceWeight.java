// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


class StructureStrongholdPieceWeight
{

    public Class field_75194_a;
    public final int field_75192_b;
    public int field_75193_c;
    public int field_75191_d;

    public StructureStrongholdPieceWeight(Class p_i3845_1_, int p_i3845_2_, int p_i3845_3_)
    {
        field_75194_a = p_i3845_1_;
        field_75192_b = p_i3845_2_;
        field_75191_d = p_i3845_3_;
    }

    public boolean func_75189_a(int p_75189_1_)
    {
        return field_75191_d == 0 || field_75193_c < field_75191_d;
    }

    public boolean func_75190_a()
    {
        return field_75191_d == 0 || field_75193_c < field_75191_d;
    }
}
