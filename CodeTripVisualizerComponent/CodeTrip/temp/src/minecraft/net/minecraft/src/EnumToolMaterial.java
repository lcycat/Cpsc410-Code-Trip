// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumToolMaterial extends Enum
{

    public static final EnumToolMaterial WOOD;
    public static final EnumToolMaterial STONE;
    public static final EnumToolMaterial IRON;
    public static final EnumToolMaterial EMERALD;
    public static final EnumToolMaterial GOLD;
    private final int field_78001_f;
    private final int field_78002_g;
    private final float field_78010_h;
    private final int field_78011_i;
    private final int field_78008_j;
    private static final EnumToolMaterial $VALUES[]; /* synthetic field */

    public static EnumToolMaterial[] values()
    {
        return (EnumToolMaterial[])$VALUES.clone();
    }

    public static EnumToolMaterial valueOf(String p_valueOf_0_)
    {
        return (EnumToolMaterial)Enum.valueOf(net.minecraft.src.EnumToolMaterial.class, p_valueOf_0_);
    }

    private EnumToolMaterial(String p_i3658_1_, int p_i3658_2_, int p_i3658_3_, int p_i3658_4_, float p_i3658_5_, int p_i3658_6_, int p_i3658_7_)
    {
        super(p_i3658_1_, p_i3658_2_);
        field_78001_f = p_i3658_3_;
        field_78002_g = p_i3658_4_;
        field_78010_h = p_i3658_5_;
        field_78011_i = p_i3658_6_;
        field_78008_j = p_i3658_7_;
    }

    public int func_77997_a()
    {
        return field_78002_g;
    }

    public float func_77998_b()
    {
        return field_78010_h;
    }

    public int func_78000_c()
    {
        return field_78011_i;
    }

    public int func_77996_d()
    {
        return field_78001_f;
    }

    public int func_77995_e()
    {
        return field_78008_j;
    }

    static 
    {
        WOOD = new EnumToolMaterial("WOOD", 0, 0, 59, 2.0F, 0, 15);
        STONE = new EnumToolMaterial("STONE", 1, 1, 131, 4F, 1, 5);
        IRON = new EnumToolMaterial("IRON", 2, 2, 250, 6F, 2, 14);
        EMERALD = new EnumToolMaterial("EMERALD", 3, 3, 1561, 8F, 3, 10);
        GOLD = new EnumToolMaterial("GOLD", 4, 0, 32, 12F, 0, 22);
        $VALUES = (new EnumToolMaterial[] {
            WOOD, STONE, IRON, EMERALD, GOLD
        });
    }
}
