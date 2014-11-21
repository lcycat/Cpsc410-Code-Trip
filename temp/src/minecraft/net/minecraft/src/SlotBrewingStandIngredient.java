// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Slot, Item, ItemStack, ContainerBrewingStand, 
//            IInventory

class SlotBrewingStandIngredient extends Slot
{

    final ContainerBrewingStand field_75226_a; /* synthetic field */

    public SlotBrewingStandIngredient(ContainerBrewingStand p_i3598_1_, IInventory p_i3598_2_, int p_i3598_3_, int p_i3598_4_, int p_i3598_5_)
    {
        field_75226_a = p_i3598_1_;
        super(p_i3598_2_, p_i3598_3_, p_i3598_4_, p_i3598_5_);
    }

    public boolean func_75214_a(ItemStack p_75214_1_)
    {
        if(p_75214_1_ != null)
        {
            return Item.field_77698_e[p_75214_1_.field_77993_c].func_77632_u();
        } else
        {
            return false;
        }
    }

    public int func_75219_a()
    {
        return 64;
    }
}
