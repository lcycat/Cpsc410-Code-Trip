// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


class StructureNetherBridgePieceWeight
{

    public Class field_78828_a;
    public final int field_78826_b;
    public int field_78827_c;
    public int field_78824_d;
    public boolean field_78825_e;

    public StructureNetherBridgePieceWeight(Class p_i3827_1_, int p_i3827_2_, int p_i3827_3_, boolean p_i3827_4_)
    {
        field_78828_a = p_i3827_1_;
        field_78826_b = p_i3827_2_;
        field_78824_d = p_i3827_3_;
        field_78825_e = p_i3827_4_;
    }

    public StructureNetherBridgePieceWeight(Class p_i3828_1_, int p_i3828_2_, int p_i3828_3_)
    {
        this(p_i3828_1_, p_i3828_2_, p_i3828_3_, false);
    }

    public boolean func_78822_a(int p_78822_1_)
    {
        return field_78824_d == 0 || field_78827_c < field_78824_d;
    }

    public boolean func_78823_a()
    {
        return field_78824_d == 0 || field_78827_c < field_78824_d;
    }
}
