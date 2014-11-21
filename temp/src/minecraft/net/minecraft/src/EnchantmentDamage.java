// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType, EntityLiving, EnumCreatureAttribute

public class EnchantmentDamage extends Enchantment
{

    private static final String field_77359_A[] = {
        "all", "undead", "arthropods"
    };
    private static final int field_77360_B[] = {
        1, 5, 5
    };
    private static final int field_77362_C[] = {
        11, 8, 8
    };
    private static final int field_77358_D[] = {
        20, 20, 20
    };
    public final int field_77361_a;

    public EnchantmentDamage(int p_i3706_1_, int p_i3706_2_, int p_i3706_3_)
    {
        super(p_i3706_1_, p_i3706_2_, EnumEnchantmentType.weapon);
        field_77361_a = p_i3706_3_;
    }

    public int func_77321_a(int p_77321_1_)
    {
        return field_77360_B[field_77361_a] + (p_77321_1_ - 1) * field_77362_C[field_77361_a];
    }

    public int func_77317_b(int p_77317_1_)
    {
        return func_77321_a(p_77317_1_) + field_77358_D[field_77361_a];
    }

    public int func_77325_b()
    {
        return 5;
    }

    public int func_77323_a(int p_77323_1_, EntityLiving p_77323_2_)
    {
        if(field_77361_a == 0)
        {
            return p_77323_1_ * 3;
        }
        if(field_77361_a == 1 && p_77323_2_.func_70668_bt() == EnumCreatureAttribute.UNDEAD)
        {
            return p_77323_1_ * 4;
        }
        if(field_77361_a == 2 && p_77323_2_.func_70668_bt() == EnumCreatureAttribute.ARTHROPOD)
        {
            return p_77323_1_ * 4;
        } else
        {
            return 0;
        }
    }

    public String func_77320_a()
    {
        return (new StringBuilder()).append("enchantment.damage.").append(field_77359_A[field_77361_a]).toString();
    }

    public boolean func_77326_a(Enchantment p_77326_1_)
    {
        return !(p_77326_1_ instanceof EnchantmentDamage);
    }

}
