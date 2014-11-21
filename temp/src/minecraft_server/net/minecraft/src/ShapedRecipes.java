// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IRecipe, ItemStack, InventoryCrafting

public class ShapedRecipes
    implements IRecipe
{

    private int field_77576_b;
    private int field_77577_c;
    private ItemStack field_77574_d[];
    private ItemStack field_77575_e;
    public final int field_77578_a;

    public ShapedRecipes(int p_i3700_1_, int p_i3700_2_, ItemStack p_i3700_3_[], ItemStack p_i3700_4_)
    {
        field_77578_a = p_i3700_4_.field_77993_c;
        field_77576_b = p_i3700_1_;
        field_77577_c = p_i3700_2_;
        field_77574_d = p_i3700_3_;
        field_77575_e = p_i3700_4_;
    }

    public ItemStack func_77571_b()
    {
        return field_77575_e;
    }

    public boolean func_77569_a(InventoryCrafting p_77569_1_)
    {
        for(int i = 0; i <= 3 - field_77576_b; i++)
        {
            for(int j = 0; j <= 3 - field_77577_c; j++)
            {
                if(func_77573_a(p_77569_1_, i, j, true))
                {
                    return true;
                }
                if(func_77573_a(p_77569_1_, i, j, false))
                {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean func_77573_a(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                int k = i - p_77573_2_;
                int l = j - p_77573_3_;
                ItemStack itemstack = null;
                if(k >= 0 && l >= 0 && k < field_77576_b && l < field_77577_c)
                {
                    if(p_77573_4_)
                    {
                        itemstack = field_77574_d[(field_77576_b - k - 1) + l * field_77576_b];
                    } else
                    {
                        itemstack = field_77574_d[k + l * field_77576_b];
                    }
                }
                ItemStack itemstack1 = p_77573_1_.func_70463_b(i, j);
                if(itemstack1 == null && itemstack == null)
                {
                    continue;
                }
                if(itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                {
                    return false;
                }
                if(itemstack.field_77993_c != itemstack1.field_77993_c)
                {
                    return false;
                }
                if(itemstack.func_77960_j() != -1 && itemstack.func_77960_j() != itemstack1.func_77960_j())
                {
                    return false;
                }
            }

        }

        return true;
    }

    public ItemStack func_77572_b(InventoryCrafting p_77572_1_)
    {
        return new ItemStack(field_77575_e.field_77993_c, field_77575_e.field_77994_a, field_77575_e.func_77960_j());
    }

    public int func_77570_a()
    {
        return field_77576_b * field_77577_c;
    }
}
