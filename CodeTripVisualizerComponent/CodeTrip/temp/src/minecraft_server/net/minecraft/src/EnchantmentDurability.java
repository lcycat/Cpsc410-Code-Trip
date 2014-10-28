// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentDurability extends Enchantment
{

    protected EnchantmentDurability(int p_i3707_1_, int p_i3707_2_)
    {
        super(p_i3707_1_, p_i3707_2_, EnumEnchantmentType.digger);
        func_77322_b("durability");
    }

    public int func_77321_a(int p_77321_1_)
    {
        return 5 + (p_77321_1_ - 1) * 8;
    }

    public int func_77317_b(int p_77317_1_)
    {
        return super.func_77321_a(p_77317_1_) + 50;
    }

    public int func_77325_b()
    {
        return 3;
    }
}
