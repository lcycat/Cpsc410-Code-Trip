// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemFood, ItemStack, Item, World, 
//            EntityPlayer

public class ItemSoup extends ItemFood
{

    public ItemSoup(int p_i3624_1_, int p_i3624_2_)
    {
        super(p_i3624_1_, p_i3624_2_, false);
        func_77625_d(1);
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        super.func_77654_b(p_77654_1_, p_77654_2_, p_77654_3_);
        return new ItemStack(Item.field_77670_E);
    }
}
