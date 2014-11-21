// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, EntityPlayer, PlayerCapabilities, 
//            ItemStack, World, EntityEnderPearl

public class ItemEnderPearl extends Item
{

    public ItemEnderPearl(int p_i3648_1_)
    {
        super(p_i3648_1_);
        field_77777_bU = 16;
        func_77637_a(CreativeTabs.field_78026_f);
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if(p_77659_3_.field_71075_bZ.field_75098_d)
        {
            return p_77659_1_;
        }
        if(p_77659_3_.field_70154_o != null)
        {
            return p_77659_1_;
        }
        p_77659_1_.field_77994_a--;
        p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
        if(!p_77659_2_.field_72995_K)
        {
            p_77659_2_.func_72838_d(new EntityEnderPearl(p_77659_2_, p_77659_3_));
        }
        return p_77659_1_;
    }
}
