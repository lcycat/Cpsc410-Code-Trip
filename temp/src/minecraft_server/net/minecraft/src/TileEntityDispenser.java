// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, EntityPlayer

public class TileEntityDispenser extends TileEntity
    implements IInventory
{

    private ItemStack field_70363_a[];
    private Random field_70362_b;

    public TileEntityDispenser()
    {
        field_70363_a = new ItemStack[9];
        field_70362_b = new Random();
    }

    public int func_70302_i_()
    {
        return 9;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return field_70363_a[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70363_a[p_70298_1_] != null)
        {
            if(field_70363_a[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = field_70363_a[p_70298_1_];
                field_70363_a[p_70298_1_] = null;
                func_70296_d();
                return itemstack;
            }
            ItemStack itemstack1 = field_70363_a[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70363_a[p_70298_1_].field_77994_a == 0)
            {
                field_70363_a[p_70298_1_] = null;
            }
            func_70296_d();
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(field_70363_a[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70363_a[p_70304_1_];
            field_70363_a[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public int func_70361_i()
    {
        int i = -1;
        int j = 1;
        for(int k = 0; k < field_70363_a.length; k++)
        {
            if(field_70363_a[k] != null && field_70362_b.nextInt(j++) == 0)
            {
                i = k;
            }
        }

        return i;
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70363_a[p_70299_1_] = p_70299_2_;
        if(p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
        {
            p_70299_2_.field_77994_a = func_70297_j_();
        }
        func_70296_d();
    }

    public int func_70360_a(ItemStack p_70360_1_)
    {
        for(int i = 0; i < field_70363_a.length; i++)
        {
            if(field_70363_a[i] == null || field_70363_a[i].field_77993_c == 0)
            {
                field_70363_a[i] = p_70360_1_;
                return i;
            }
        }

        return -1;
    }

    public String func_70303_b()
    {
        return "container.dispenser";
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        NBTTagList nbttaglist = p_70307_1_.func_74761_m("Items");
        field_70363_a = new ItemStack[func_70302_i_()];
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
            int j = nbttagcompound.func_74771_c("Slot") & 0xff;
            if(j >= 0 && j < field_70363_a.length)
            {
                field_70363_a[j] = ItemStack.func_77949_a(nbttagcompound);
            }
        }

    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_70363_a.length; i++)
        {
            if(field_70363_a[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                field_70363_a[i].func_77955_b(nbttagcompound);
                nbttaglist.func_74742_a(nbttagcompound);
            }
        }

        p_70310_1_.func_74782_a("Items", nbttaglist);
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public boolean func_70300_a(EntityPlayer p_70300_1_)
    {
        if(field_70331_k.func_72796_p(field_70329_l, field_70330_m, field_70327_n) != this)
        {
            return false;
        }
        return p_70300_1_.func_70092_e((double)field_70329_l + 0.5D, (double)field_70330_m + 0.5D, (double)field_70327_n + 0.5D) <= 64D;
    }

    public void func_70295_k_()
    {
    }

    public void func_70305_f()
    {
    }
}
