// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Enchantment, EnumEnchantmentType

public class EnchantmentUntouching extends Enchantment
{

    protected EnchantmentUntouching(int p_i3719_1_, int p_i3719_2_)
    {
        super(p_i3719_1_, p_i3719_2_, EnumEnchantmentType.digger);
        func_77322_b("untouching");
    }

    public int func_77321_a(int p_77321_1_)
    {
        return 15;
    }

    public int func_77317_b(int p_77317_1_)
    {
        return super.func_77321_a(p_77317_1_) + 50;
    }

    public int func_77325_b()
    {
        return 1;
    }

    public boolean func_77326_a(Enchantment p_77326_1_)
    {
        return super.func_77326_a(p_77326_1_) && p_77326_1_.field_77352_x != field_77346_s.field_77352_x;
    }
}
