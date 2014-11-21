// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IRecipe, InventoryCrafting, ItemStack

public class ShapelessRecipes
    implements IRecipe
{

    private final ItemStack field_77580_a;
    private final List field_77579_b;

    public ShapelessRecipes(ItemStack p_i3701_1_, List p_i3701_2_)
    {
        field_77580_a = p_i3701_1_;
        field_77579_b = p_i3701_2_;
    }

    public ItemStack func_77571_b()
    {
        return field_77580_a;
    }

    public boolean func_77569_a(InventoryCrafting p_77569_1_)
    {
        ArrayList arraylist = new ArrayList(field_77579_b);
        int i = 0;
        do
        {
            if(i >= 3)
            {
                break;
            }
            for(int j = 0; j < 3; j++)
            {
                ItemStack itemstack = p_77569_1_.func_70463_b(j, i);
                if(itemstack == null)
                {
                    continue;
                }
                boolean flag = false;
                Iterator iterator = arraylist.iterator();
                do
                {
                    if(!iterator.hasNext())
                    {
                        break;
                    }
                    ItemStack itemstack1 = (ItemStack)iterator.next();
                    if(itemstack.field_77993_c != itemstack1.field_77993_c || itemstack1.func_77960_j() != -1 && itemstack.func_77960_j() != itemstack1.func_77960_j())
                    {
                        continue;
                    }
                    flag = true;
                    arraylist.remove(itemstack1);
                    break;
                } while(true);
                if(!flag)
                {
                    return false;
                }
            }

            i++;
        } while(true);
        return arraylist.isEmpty();
    }

    public ItemStack func_77572_b(InventoryCrafting p_77572_1_)
    {
        return field_77580_a.func_77946_l();
    }

    public int func_77570_a()
    {
        return field_77579_b.size();
    }
}
