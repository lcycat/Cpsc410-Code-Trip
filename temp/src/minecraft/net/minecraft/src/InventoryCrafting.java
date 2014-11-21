// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, Container, EntityPlayer

public class InventoryCrafting
    implements IInventory
{

    private ItemStack field_70466_a[];
    private int field_70464_b;
    private Container field_70465_c;

    public InventoryCrafting(Container p_i3602_1_, int p_i3602_2_, int p_i3602_3_)
    {
        int i = p_i3602_2_ * p_i3602_3_;
        field_70466_a = new ItemStack[i];
        field_70465_c = p_i3602_1_;
        field_70464_b = p_i3602_2_;
    }

    public int func_70302_i_()
    {
        return field_70466_a.length;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        if(p_70301_1_ >= func_70302_i_())
        {
            return null;
        } else
        {
            return field_70466_a[p_70301_1_];
        }
    }

    public ItemStack func_70463_b(int p_70463_1_, int p_70463_2_)
    {
        if(p_70463_1_ < 0 || p_70463_1_ >= field_70464_b)
        {
            return null;
        } else
        {
            int i = p_70463_1_ + p_70463_2_ * field_70464_b;
            return func_70301_a(i);
        }
    }

    public String func_70303_b()
    {
        return "container.crafting";
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(field_70466_a[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70466_a[p_70304_1_];
            field_70466_a[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70466_a[p_70298_1_] != null)
        {
            if(field_70466_a[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = field_70466_a[p_70298_1_];
                field_70466_a[p_70298_1_] = null;
                field_70465_c.func_75130_a(this);
                return itemstack;
            }
            ItemStack itemstack1 = field_70466_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70466_a[p_70298_1_].field_77994_a == 0)
            {
                field_70466_a[p_70298_1_] = null;
            }
            field_70465_c.func_75130_a(this);
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70466_a[p_70299_1_] = p_70299_2_;
        field_70465_c.func_75130_a(this);
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public void func_70296_d()
    {
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        return true;
    }

    public void func_70295_k_()
    {
    }

    public void func_70305_f()
    {
    }
}
