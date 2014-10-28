// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType, DamageSource

public class EnchantmentProtection extends Enchantment
{

    private static final String field_77354_A[] = {
        "all", "fire", "fall", "explosion", "projectile"
    };
    private static final int field_77355_B[] = {
        1, 10, 5, 5, 3
    };
    private static final int field_77357_C[] = {
        11, 8, 6, 8, 6
    };
    private static final int field_77353_D[] = {
        20, 12, 10, 12, 15
    };
    public final int field_77356_a;

    public EnchantmentProtection(int p_i3718_1_, int p_i3718_2_, int p_i3718_3_)
    {
        super(p_i3718_1_, p_i3718_2_, EnumEnchantmentType.armor);
        field_77356_a = p_i3718_3_;
        if(p_i3718_3_ == 2)
        {
            field_77351_y = EnumEnchantmentType.armor_feet;
        }
    }

    public int func_77321_a(int p_77321_1_)
    {
        return field_77355_B[field_77356_a] + (p_77321_1_ - 1) * field_77357_C[field_77356_a];
    }

    public int func_77317_b(int p_77317_1_)
    {
        return func_77321_a(p_77317_1_) + field_77353_D[field_77356_a];
    }

    public int func_77325_b()
    {
        return 4;
    }

    public int func_77318_a(int p_77318_1_, DamageSource p_77318_2_)
    {
        if(p_77318_2_.func_76357_e())
        {
            return 0;
        }
        int i = (6 + p_77318_1_ * p_77318_1_) / 2;
        if(field_77356_a == 0)
        {
            return i;
        }
        if(field_77356_a == 1 && p_77318_2_.func_76347_k())
        {
            return i;
        }
        if(field_77356_a == 2 && p_77318_2_ == DamageSource.field_76379_h)
        {
            return i * 2;
        }
        if(field_77356_a == 3 && p_77318_2_ == DamageSource.field_76378_k || p_77318_2_ == DamageSource.field_76375_l)
        {
            return i;
        }
        if(field_77356_a == 4 && p_77318_2_.func_76352_a())
        {
            return i;
        } else
        {
            return 0;
        }
    }

    public String func_77320_a()
    {
        return (new StringBuilder()).append("enchantment.protect.").append(field_77354_A[field_77356_a]).toString();
    }

    public boolean func_77326_a(Enchantment p_77326_1_)
    {
        if(p_77326_1_ instanceof EnchantmentProtection)
        {
            EnchantmentProtection enchantmentprotection = (EnchantmentProtection)p_77326_1_;
            if(enchantmentprotection.field_77356_a == field_77356_a)
            {
                return false;
            }
            return field_77356_a == 2 || enchantmentprotection.field_77356_a == 2;
        } else
        {
            return super.func_77326_a(p_77326_1_);
        }
    }

}
