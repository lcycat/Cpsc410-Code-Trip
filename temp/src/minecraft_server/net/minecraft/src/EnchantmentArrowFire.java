// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentArrowFire extends Enchantment
{

    public EnchantmentArrowFire(int p_i3703_1_, int p_i3703_2_)
    {
        super(p_i3703_1_, p_i3703_2_, EnumEnchantmentType.bow);
        func_77322_b("arrowFire");
    }

    public int func_77321_a(int p_77321_1_)
    {
        return 20;
    }

    public int func_77317_b(int p_77317_1_)
    {
        return 50;
    }

    public int func_77325_b()
    {
        return 1;
    }
}
