// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, ItemStack

public class ItemCoal extends Item
{

    public ItemCoal(int p_i3627_1_)
    {
        super(p_i3627_1_);
        func_77627_a(true);
        func_77656_e(0);
        func_77637_a(CreativeTabs.field_78035_l);
    }

    public String func_77667_c(ItemStack p_77667_1_)
    {
        if(p_77667_1_.func_77960_j() == 1)
        {
            return "item.charcoal";
        } else
        {
            return "item.coal";
        }
    }

    public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_)
    {
        p_77633_3_.add(new ItemStack(p_77633_1_, 1, 0));
        p_77633_3_.add(new ItemStack(p_77633_1_, 1, 1));
    }
}
