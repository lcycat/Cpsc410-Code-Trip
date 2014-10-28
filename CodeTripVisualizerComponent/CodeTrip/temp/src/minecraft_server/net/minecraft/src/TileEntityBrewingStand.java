// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, World, 
//            Item, ItemPotion, PotionHelper, NBTTagCompound, 
//            NBTTagList, EntityPlayer

public class TileEntityBrewingStand extends TileEntity
    implements IInventory
{

    private ItemStack field_70359_a[];
    private int field_70357_b;
    private int field_70358_c;
    private int field_70356_d;

    public TileEntityBrewingStand()
    {
        field_70359_a = new ItemStack[4];
    }

    public String func_70303_b()
    {
        return "container.brewing";
    }

    public int func_70302_i_()
    {
        return field_70359_a.length;
    }

    public void func_70316_g()
    {
        if(field_70357_b > 0)
        {
            field_70357_b--;
            if(field_70357_b == 0)
            {
                func_70353_r();
                func_70296_d();
            } else
            if(!func_70350_k())
            {
                field_70357_b = 0;
                func_70296_d();
            } else
            if(field_70356_d != field_70359_a[3].field_77993_c)
            {
                field_70357_b = 0;
                func_70296_d();
            }
        } else
        if(func_70350_k())
        {
            field_70357_b = 400;
            field_70356_d = field_70359_a[3].field_77993_c;
        }
        int i = func_70351_i();
        if(i != field_70358_c)
        {
            field_70358_c = i;
            field_70331_k.func_72921_c(field_70329_l, field_70330_m, field_70327_n, i);
        }
        super.func_70316_g();
    }

    public int func_70355_t_()
    {
        return field_70357_b;
    }

    private boolean func_70350_k()
    {
        if(field_70359_a[3] == null || field_70359_a[3].field_77994_a <= 0)
        {
            return false;
        }
        ItemStack itemstack = field_70359_a[3];
        if(!Item.field_77698_e[itemstack.field_77993_c].func_77632_u())
        {
            return false;
        }
        boolean flag = false;
        for(int i = 0; i < 3; i++)
        {
            if(field_70359_a[i] == null || field_70359_a[i].field_77993_c != Item.field_77726_bs.field_77779_bT)
            {
                continue;
            }
            int j = field_70359_a[i].func_77960_j();
            int k = func_70352_b(j, itemstack);
            if(!ItemPotion.func_77831_g(j) && ItemPotion.func_77831_g(k))
            {
                flag = true;
                break;
            }
            java.util.List list = Item.field_77726_bs.func_77834_f(j);
            java.util.List list1 = Item.field_77726_bs.func_77834_f(k);
            if(j > 0 && list == list1 || list != null && (list.equals(list1) || list1 == null) || j == k)
            {
                continue;
            }
            flag = true;
            break;
        }

        return flag;
    }

    private void func_70353_r()
    {
        if(!func_70350_k())
        {
            return;
        }
        ItemStack itemstack = field_70359_a[3];
        for(int i = 0; i < 3; i++)
        {
            if(field_70359_a[i] == null || field_70359_a[i].field_77993_c != Item.field_77726_bs.field_77779_bT)
            {
                continue;
            }
            int j = field_70359_a[i].func_77960_j();
            int k = func_70352_b(j, itemstack);
            java.util.List list = Item.field_77726_bs.func_77834_f(j);
            java.util.List list1 = Item.field_77726_bs.func_77834_f(k);
            if(j > 0 && list == list1 || list != null && (list.equals(list1) || list1 == null))
            {
                if(!ItemPotion.func_77831_g(j) && ItemPotion.func_77831_g(k))
                {
                    field_70359_a[i].func_77964_b(k);
                }
                continue;
            }
            if(j != k)
            {
                field_70359_a[i].func_77964_b(k);
            }
        }

        if(Item.field_77698_e[itemstack.field_77993_c].func_77634_r())
        {
            field_70359_a[3] = new ItemStack(Item.field_77698_e[itemstack.field_77993_c].func_77668_q());
        } else
        {
            field_70359_a[3].field_77994_a--;
            if(field_70359_a[3].field_77994_a <= 0)
            {
                field_70359_a[3] = null;
            }
        }
    }

    private int func_70352_b(int p_70352_1_, ItemStack p_70352_2_)
    {
        if(p_70352_2_ == null)
        {
            return p_70352_1_;
        }
        if(Item.field_77698_e[p_70352_2_.field_77993_c].func_77632_u())
        {
            return PotionHelper.func_77913_a(p_70352_1_, Item.field_77698_e[p_70352_2_.field_77993_c].func_77666_t());
        } else
        {
            return p_70352_1_;
        }
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        NBTTagList nbttaglist = p_70307_1_.func_74761_m("Items");
        field_70359_a = new ItemStack[func_70302_i_()];
        for(int i = 0; i < nbttaglist.func_74745_c(); i++)
        {
            NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.func_74743_b(i);
            byte byte0 = nbttagcompound.func_74771_c("Slot");
            if(byte0 >= 0 && byte0 < field_70359_a.length)
            {
                field_70359_a[byte0] = ItemStack.func_77949_a(nbttagcompound);
            }
        }

        field_70357_b = p_70307_1_.func_74765_d("BrewTime");
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74777_a("BrewTime", (short)field_70357_b);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < field_70359_a.length; i++)
        {
            if(field_70359_a[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.func_74774_a("Slot", (byte)i);
                field_70359_a[i].func_77955_b(nbttagcompound);
                nbttaglist.func_74742_a(nbttagcompound);
            }
        }

        p_70310_1_.func_74782_a("Items", nbttaglist);
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        if(p_70301_1_ >= 0 && p_70301_1_ < field_70359_a.length)
        {
            return field_70359_a[p_70301_1_];
        } else
        {
            return null;
        }
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(p_70298_1_ >= 0 && p_70298_1_ < field_70359_a.length)
        {
            ItemStack itemstack = field_70359_a[p_70298_1_];
            field_70359_a[p_70298_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public ItemStack func_70304_b(int p_70304_1_)
    {
        if(p_70304_1_ >= 0 && p_70304_1_ < field_70359_a.length)
        {
            ItemStack itemstack = field_70359_a[p_70304_1_];
            field_70359_a[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        if(p_70299_1_ >= 0 && p_70299_1_ < field_70359_a.length)
        {
            field_70359_a[p_70299_1_] = p_70299_2_;
        }
    }

    public int func_70297_j_()
    {
        return 1;
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

    public int func_70351_i()
    {
        int i = 0;
        for(int j = 0; j < 3; j++)
        {
            if(field_70359_a[j] != null)
            {
                i |= 1 << j;
            }
        }

        return i;
    }
}
