// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EnchantmentProtection, EnchantmentOxygen, EnchantmentWaterWorker, EnchantmentDamage, 
//            EnchantmentKnockback, EnchantmentFireAspect, EnchantmentLootBonus, EnumEnchantmentType, 
//            EnchantmentDigging, EnchantmentUntouching, EnchantmentDurability, EnchantmentArrowDamage, 
//            EnchantmentArrowKnockback, EnchantmentArrowFire, EnchantmentArrowInfinite, DamageSource, 
//            EntityLiving

public abstract class Enchantment
{

    public static final Enchantment field_77331_b[] = new Enchantment[256];
    public static final Enchantment field_77332_c = new EnchantmentProtection(0, 10, 0);
    public static final Enchantment field_77329_d = new EnchantmentProtection(1, 5, 1);
    public static final Enchantment field_77330_e = new EnchantmentProtection(2, 5, 2);
    public static final Enchantment field_77327_f = new EnchantmentProtection(3, 2, 3);
    public static final Enchantment field_77328_g = new EnchantmentProtection(4, 5, 4);
    public static final Enchantment field_77340_h = new EnchantmentOxygen(5, 2);
    public static final Enchantment field_77341_i = new EnchantmentWaterWorker(6, 2);
    public static final Enchantment field_77338_j = new EnchantmentDamage(16, 10, 0);
    public static final Enchantment field_77339_k = new EnchantmentDamage(17, 5, 1);
    public static final Enchantment field_77336_l = new EnchantmentDamage(18, 5, 2);
    public static final Enchantment field_77337_m = new EnchantmentKnockback(19, 5);
    public static final Enchantment field_77334_n = new EnchantmentFireAspect(20, 2);
    public static final Enchantment field_77335_o;
    public static final Enchantment field_77349_p = new EnchantmentDigging(32, 10);
    public static final Enchantment field_77348_q = new EnchantmentUntouching(33, 1);
    public static final Enchantment field_77347_r = new EnchantmentDurability(34, 5);
    public static final Enchantment field_77346_s;
    public static final Enchantment field_77345_t = new EnchantmentArrowDamage(48, 10);
    public static final Enchantment field_77344_u = new EnchantmentArrowKnockback(49, 2);
    public static final Enchantment field_77343_v = new EnchantmentArrowFire(50, 2);
    public static final Enchantment field_77342_w = new EnchantmentArrowInfinite(51, 1);
    public final int field_77352_x;
    private final int field_77333_a;
    public EnumEnchantmentType field_77351_y;
    protected String field_77350_z;

    protected Enchantment(int p_i3709_1_, int p_i3709_2_, EnumEnchantmentType p_i3709_3_)
    {
        field_77352_x = p_i3709_1_;
        field_77333_a = p_i3709_2_;
        field_77351_y = p_i3709_3_;
        if(field_77331_b[p_i3709_1_] != null)
        {
            throw new IllegalArgumentException("Duplicate enchantment id!");
        } else
        {
            field_77331_b[p_i3709_1_] = this;
            return;
        }
    }

    public int func_77324_c()
    {
        return field_77333_a;
    }

    public int func_77319_d()
    {
        return 1;
    }

    public int func_77325_b()
    {
        return 1;
    }

    public int func_77321_a(int p_77321_1_)
    {
        return 1 + p_77321_1_ * 10;
    }

    public int func_77317_b(int p_77317_1_)
    {
        return func_77321_a(p_77317_1_) + 5;
    }

    public int func_77318_a(int p_77318_1_, DamageSource p_77318_2_)
    {
        return 0;
    }

    public int func_77323_a(int p_77323_1_, EntityLiving p_77323_2_)
    {
        return 0;
    }

    public boolean func_77326_a(Enchantment p_77326_1_)
    {
        return this != p_77326_1_;
    }

    public Enchantment func_77322_b(String p_77322_1_)
    {
        field_77350_z = p_77322_1_;
        return this;
    }

    static 
    {
        field_77335_o = new EnchantmentLootBonus(21, 2, EnumEnchantmentType.weapon);
        field_77346_s = new EnchantmentLootBonus(35, 2, EnumEnchantmentType.digger);
    }
}
