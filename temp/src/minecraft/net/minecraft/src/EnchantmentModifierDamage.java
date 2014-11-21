// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IEnchantmentModifier, Enchantment, DamageSource, Empty3

final class EnchantmentModifierDamage
    implements IEnchantmentModifier
{

    public int field_77497_a;
    public DamageSource field_77496_b;

    private EnchantmentModifierDamage()
    {
    }

    public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_)
    {
        field_77497_a += p_77493_1_.func_77318_a(p_77493_2_, field_77496_b);
    }

    EnchantmentModifierDamage(Empty3 p_i3712_1_)
    {
        this();
    }
}
