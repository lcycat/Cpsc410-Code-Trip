// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IMob, Material, EntityAnimal, EntityWaterMob

public final class EnumCreatureType extends Enum
{

    public static final EnumCreatureType monster;
    public static final EnumCreatureType creature;
    public static final EnumCreatureType waterCreature;
    private final Class field_75605_d;
    private final int field_75606_e;
    private final Material field_75603_f;
    private final boolean field_75604_g;
    private static final EnumCreatureType $VALUES[]; /* synthetic field */

    public static EnumCreatureType[] values()
    {
        return (EnumCreatureType[])$VALUES.clone();
    }

    public static EnumCreatureType valueOf(String p_valueOf_0_)
    {
        return (EnumCreatureType)Enum.valueOf(net.minecraft.src.EnumCreatureType.class, p_valueOf_0_);
    }

    private EnumCreatureType(String p_i3444_1_, int p_i3444_2_, Class p_i3444_3_, int p_i3444_4_, Material p_i3444_5_, boolean p_i3444_6_)
    {
        super(p_i3444_1_, p_i3444_2_);
        field_75605_d = p_i3444_3_;
        field_75606_e = p_i3444_4_;
        field_75603_f = p_i3444_5_;
        field_75604_g = p_i3444_6_;
    }

    public Class func_75598_a()
    {
        return field_75605_d;
    }

    public int func_75601_b()
    {
        return field_75606_e;
    }

    public Material func_75600_c()
    {
        return field_75603_f;
    }

    public boolean func_75599_d()
    {
        return field_75604_g;
    }

    static 
    {
        monster = new EnumCreatureType("monster", 0, net.minecraft.src.IMob.class, 70, Material.field_76249_a, false);
        creature = new EnumCreatureType("creature", 1, net.minecraft.src.EntityAnimal.class, 15, Material.field_76249_a, true);
        waterCreature = new EnumCreatureType("waterCreature", 2, net.minecraft.src.EntityWaterMob.class, 5, Material.field_76244_g, true);
        $VALUES = (new EnumCreatureType[] {
            monster, creature, waterCreature
        });
    }
}
