// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ContainerEnchantment, IInventory, ItemStack

class SlotEnchantment extends Slot
{

    final ContainerEnchantment field_75227_a; /* synthetic field */

    SlotEnchantment(ContainerEnchantment p_i3605_1_, IInventory p_i3605_2_, int p_i3605_3_, int p_i3605_4_, int p_i3605_5_)
    {
        field_75227_a = p_i3605_1_;
        super(p_i3605_2_, p_i3605_3_, p_i3605_4_, p_i3605_5_);
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        return true;
    }
}
