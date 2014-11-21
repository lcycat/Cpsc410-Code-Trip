// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, EntityPlayer, Block

public class TileEntityChest extends TileEntity
    implements IInventory
{

    private ItemStack field_70428_i[];
    public boolean field_70425_a;
    public TileEntityChest field_70423_b;
    public TileEntityChest field_70424_c;
    public TileEntityChest field_70421_d;
    public TileEntityChest field_70422_e;
    public float field_70419_f;
    public float field_70420_g;
    public int field_70427_h;
    private int field_70426_j;

    public TileEntityChest()
    {
        field_70428_i = new ItemStack[36];
        field_70425_a = false;
    }

    public int func_70302_i_()
    {
        return 27;
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return field_70428_i[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70428_i[p_70298_1_] != null)
        {
            if(field_70428_i[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = field_70428_i[p_70298_1_];
                field_70428_i[p_70298_1_] = null;
                func_70296_d();
                return itemstack;
            }
            ItemStack itemstack1 = field_70428_i[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70428_i[p_70298_1_].field_77994_a == 0)
            {
                field_70428_i[p_70298_1_] = null;
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
        if(field_70428_i[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70428_i[p_70304_1_];
            field_70428_i[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70428_i[p_70299_1_] = p_70299_2_;
        if(p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
        {
            p_70299_2_.field_77994_a = func_70297_j_();
        }
        func_70296_d();
    }

    public String func_70303_b()
    {
        return "container.chest";
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        NBTTagList nbttaglist = p_70307_1_.func_74761_m("Items");
        field_70428_i = new ItemStack[func_70302_i_()];
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
            int j = nbttagcompound.func_74771_c("Slot") & 0xff;
            if(j >= 0 && j < field_70428_i.length)
            {
                field_70428_i[j] = ItemStack.func_77949_a(nbttagcompound);
            }
        }

    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_70428_i.length; i++)
        {
            if(field_70428_i[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                field_70428_i[i].func_77955_b(nbttagcompound);
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

    public void func_70321_h()
    {
        super.func_70321_h();
        field_70425_a = false;
    }

    public void func_70418_i()
    {
        if(field_70425_a)
        {
            return;
        }
        field_70425_a = true;
        field_70423_b = null;
        field_70424_c = null;
        field_70421_d = null;
        field_70422_e = null;
        if(field_70331_k.func_72798_a(field_70329_l - 1, field_70330_m, field_70327_n) == Block.field_72077_au.field_71990_ca)
        {
            field_70421_d = (TileEntityChest)field_70331_k.func_72796_p(field_70329_l - 1, field_70330_m, field_70327_n);
        }
        if(field_70331_k.func_72798_a(field_70329_l + 1, field_70330_m, field_70327_n) == Block.field_72077_au.field_71990_ca)
        {
            field_70424_c = (TileEntityChest)field_70331_k.func_72796_p(field_70329_l + 1, field_70330_m, field_70327_n);
        }
        if(field_70331_k.func_72798_a(field_70329_l, field_70330_m, field_70327_n - 1) == Block.field_72077_au.field_71990_ca)
        {
            field_70423_b = (TileEntityChest)field_70331_k.func_72796_p(field_70329_l, field_70330_m, field_70327_n - 1);
        }
        if(field_70331_k.func_72798_a(field_70329_l, field_70330_m, field_70327_n + 1) == Block.field_72077_au.field_71990_ca)
        {
            field_70422_e = (TileEntityChest)field_70331_k.func_72796_p(field_70329_l, field_70330_m, field_70327_n + 1);
        }
        if(field_70423_b != null)
        {
            field_70423_b.func_70321_h();
        }
        if(field_70422_e != null)
        {
            field_70422_e.func_70321_h();
        }
        if(field_70424_c != null)
        {
            field_70424_c.func_70321_h();
        }
        if(field_70421_d != null)
        {
            field_70421_d.func_70321_h();
        }
    }

    public void func_70316_g()
    {
        super.func_70316_g();
        func_70418_i();
        if((++field_70426_j % 20) * 4 != 0);
        field_70420_g = field_70419_f;
        float f = 0.1F;
        if(field_70427_h > 0 && field_70419_f == 0.0F && field_70423_b == null && field_70421_d == null)
        {
            double d = (double)field_70329_l + 0.5D;
            double d1 = (double)field_70327_n + 0.5D;
            if(field_70422_e != null)
            {
                d1 += 0.5D;
            }
            if(field_70424_c != null)
            {
                d += 0.5D;
            }
            field_70331_k.func_72908_a(d, (double)field_70330_m + 0.5D, d1, "random.chestopen", 0.5F, field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
        }
        if(field_70427_h == 0 && field_70419_f > 0.0F || field_70427_h > 0 && field_70419_f < 1.0F)
        {
            float f1 = field_70419_f;
            if(field_70427_h > 0)
            {
                field_70419_f += f;
            } else
            {
                field_70419_f -= f;
            }
            if(field_70419_f > 1.0F)
            {
                field_70419_f = 1.0F;
            }
            float f2 = 0.5F;
            if(field_70419_f < f2 && f1 >= f2 && field_70423_b == null && field_70421_d == null)
            {
                double d2 = (double)field_70329_l + 0.5D;
                double d3 = (double)field_70327_n + 0.5D;
                if(field_70422_e != null)
                {
                    d3 += 0.5D;
                }
                if(field_70424_c != null)
                {
                    d2 += 0.5D;
                }
                field_70331_k.func_72908_a(d2, (double)field_70330_m + 0.5D, d3, "random.chestclosed", 0.5F, field_70331_k.field_73012_v.nextFloat() * 0.1F + 0.9F);
            }
            if(field_70419_f < 0.0F)
            {
                field_70419_f = 0.0F;
            }
        }
    }

    public void func_70315_b(int p_70315_1_, int p_70315_2_)
    {
        if(p_70315_1_ == 1)
        {
            field_70427_h = p_70315_2_;
        }
    }

    public void func_70295_k_()
    {
        field_70427_h++;
        field_70331_k.func_72965_b(field_70329_l, field_70330_m, field_70327_n, Block.field_72077_au.field_71990_ca, 1, field_70427_h);
    }

    public void func_70305_f()
    {
        field_70427_h--;
        field_70331_k.func_72965_b(field_70329_l, field_70330_m, field_70327_n, Block.field_72077_au.field_71990_ca, 1, field_70427_h);
    }

    public void func_70313_j()
    {
        func_70321_h();
        func_70418_i();
        super.func_70313_j();
    }
}
