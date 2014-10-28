// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            InventoryBasic, ContainerEnchantment

class SlotEnchantmentTable extends InventoryBasic
{

    final ContainerEnchantment field_70484_a; /* synthetic field */

    SlotEnchantmentTable(ContainerEnchantment p_i3604_1_, String p_i3604_2_, int p_i3604_3_)
    {
        field_70484_a = p_i3604_1_;
        super(p_i3604_2_, p_i3604_3_);
    }

    public int func_70297_j_()
    {
        return 1;
    }

    public void func_70296_d()
    {
        super.func_70296_d();
        field_70484_a.func_75130_a(this);
    }
}
