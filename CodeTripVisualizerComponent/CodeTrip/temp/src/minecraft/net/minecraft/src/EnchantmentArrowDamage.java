// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentArrowDamage extends Enchantment
{

    public EnchantmentArrowDamage(int p_i3702_1_, int p_i3702_2_)
    {
        super(p_i3702_1_, p_i3702_2_, EnumEnchantmentType.bow);
        func_77322_b("arrowDamage");
    }

    public int func_77321_a(int p_77321_1_)
    {
        return 1 + (p_77321_1_ - 1) * 10;
    }

    public int func_77317_b(int p_77317_1_)
    {
        return func_77321_a(p_77317_1_) + 15;
    }

    public int func_77325_b()
    {
        return 5;
    }
}
