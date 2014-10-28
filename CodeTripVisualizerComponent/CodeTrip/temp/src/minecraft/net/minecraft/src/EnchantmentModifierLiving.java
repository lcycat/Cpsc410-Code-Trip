// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IEnchantmentModifier, Enchantment, EntityLiving, Empty3

final class EnchantmentModifierLiving
    implements IEnchantmentModifier
{

    public int field_77495_a;
    public EntityLiving field_77494_b;

    private EnchantmentModifierLiving()
    {
    }

    public void func_77493_a(Enchantment p_77493_1_, int p_77493_2_)
    {
        field_77495_a += p_77493_1_.func_77323_a(p_77493_2_, field_77494_b);
    }

    EnchantmentModifierLiving(Empty3 p_i3711_1_)
    {
        this();
    }
}
