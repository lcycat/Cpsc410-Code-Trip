// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentOxygen extends Enchantment
{

    public EnchantmentOxygen(int p_i3717_1_, int p_i3717_2_)
    {
        super(p_i3717_1_, p_i3717_2_, EnumEnchantmentType.armor_head);
        func_77322_b("oxygen");
    }

    public int func_77321_a(int p_77321_1_)
    {
        return 10 * p_77321_1_;
    }

    public int func_77317_b(int p_77317_1_)
    {
        return func_77321_a(p_77317_1_) + 30;
    }

    public int func_77325_b()
    {
        return 3;
    }
}
