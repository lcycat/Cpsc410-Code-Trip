// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public final class EnumRarity extends Enum
{

    public static final EnumRarity common;
    public static final EnumRarity uncommon;
    public static final EnumRarity rare;
    public static final EnumRarity epic;
    public final int field_77937_e;
    public final String field_77934_f;
    private static final EnumRarity $VALUES[]; /* synthetic field */

    public static EnumRarity[] values()
    {
        return (EnumRarity[])$VALUES.clone();
    }

    public static EnumRarity valueOf(String p_valueOf_0_)
    {
        return (EnumRarity)Enum.valueOf(net.minecraft.src.EnumRarity.class, p_valueOf_0_);
    }

    private EnumRarity(String p_i3676_1_, int p_i3676_2_, int p_i3676_3_, String p_i3676_4_)
    {
        super(p_i3676_1_, p_i3676_2_);
        field_77937_e = p_i3676_3_;
        field_77934_f = p_i3676_4_;
    }

    static 
    {
        common = new EnumRarity("common", 0, 15, "Common");
        uncommon = new EnumRarity("uncommon", 1, 14, "Uncommon");
        rare = new EnumRarity("rare", 2, 11, "Rare");
        epic = new EnumRarity("epic", 3, 13, "Epic");
        $VALUES = (new EnumRarity[] {
            common, uncommon, rare, epic
        });
    }
}
