// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, ItemStack, ItemArmor, Item, 
//            Block, ContainerPlayer, IInventory

class SlotArmor extends Slot
{

    final int field_75236_a; /* synthetic field */
    final ContainerPlayer field_75235_b; /* synthetic field */

    SlotArmor(ContainerPlayer p_i3609_1_, IInventory p_i3609_2_, int p_i3609_3_, int p_i3609_4_, int p_i3609_5_, int p_i3609_6_)
    {
        field_75235_b = p_i3609_1_;
        field_75236_a = p_i3609_6_;
        super(p_i3609_2_, p_i3609_3_, p_i3609_4_, p_i3609_5_);
    }

    public int func_75219_a()
    {
        return 1;
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        if(p_75214_1_.func_77973_b() instanceof ItemArmor)
        {
            return ((ItemArmor)p_75214_1_.func_77973_b()).field_77881_a == field_75236_a;
        }
        if(p_75214_1_.func_77973_b().field_77779_bT == Block.field_72061_ba.field_71990_ca)
        {
            return field_75236_a == 0;
        } else
        {
            return false;
        }
    }
}
