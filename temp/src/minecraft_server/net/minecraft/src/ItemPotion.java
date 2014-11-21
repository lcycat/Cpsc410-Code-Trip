// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Item, CreativeTabs, ItemStack, PotionHelper, 
//            EntityPlayer, PlayerCapabilities, World, PotionEffect, 
//            InventoryPlayer, EnumAction, EntityPotion

public class ItemPotion extends Item
{

    private HashMap field_77836_a;
    private static final Map field_77835_b = new LinkedHashMap();

    public ItemPotion(int p_i3675_1_)
    {
        super(p_i3675_1_);
        field_77836_a = new HashMap();
        func_77625_d(1);
        func_77627_a(true);
        func_77656_e(0);
        func_77637_a(CreativeTabs.field_78038_k);
    }

    public List func_77832_l(ItemStack p_77832_1_)
    {
        return func_77834_f(p_77832_1_.func_77960_j());
    }

    public List func_77834_f(int p_77834_1_)
    {
        List list = (List)field_77836_a.get(Integer.valueOf(p_77834_1_));
        if(list == null)
        {
            list = PotionHelper.func_77917_b(p_77834_1_, false);
            field_77836_a.put(Integer.valueOf(p_77834_1_), list);
        }
        return list;
    }

    public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
    {
        if(!p_77654_3_.field_71075_bZ.field_75098_d)
        {
            p_77654_1_.field_77994_a--;
        }
        if(!p_77654_2_.field_72995_K)
        {
            List list = func_77832_l(p_77654_1_);
            if(list != null)
            {
                PotionEffect potioneffect;
                for(Iterator iterator = list.iterator(); iterator.hasNext(); p_77654_3_.func_70690_d(new PotionEffect(potioneffect)))
                {
                    potioneffect = (PotionEffect)iterator.next();
                }

            }
        }
        if(!p_77654_3_.field_71075_bZ.field_75098_d)
        {
            if(p_77654_1_.field_77994_a <= 0)
            {
                return new ItemStack(Item.field_77729_bt);
            }
            p_77654_3_.field_71071_by.func_70441_a(new ItemStack(Item.field_77729_bt));
        }
        return p_77654_1_;
    }

    public int func_77626_a(ItemStack p_77626_1_)
    {
        return 32;
    }

    public EnumAction func_77661_b(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }

    public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        if(func_77831_g(p_77659_1_.func_77960_j()))
        {
            if(!p_77659_3_.field_71075_bZ.field_75098_d)
            {
                p_77659_1_.field_77994_a--;
            }
            p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));
            if(!p_77659_2_.field_72995_K)
            {
                p_77659_2_.func_72838_d(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_.func_77960_j()));
            }
            return p_77659_1_;
        } else
        {
            p_77659_3_.func_71008_a(p_77659_1_, func_77626_a(p_77659_1_));
            return p_77659_1_;
        }
    }

    public boolean func_77648_a(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int i, int j, int k, int l, 
            float f, float f1, float f2)
    {
        return false;
    }

    public static boolean func_77831_g(int p_77831_0_)
    {
        return (p_77831_0_ & 0x4000) != 0;
    }

}
