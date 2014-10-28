// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            IInventory, ItemStack, IInvBasic, EntityPlayer

public class InventoryBasic
    implements IInventory
{

    private String field_70483_a;
    private int field_70481_b;
    private ItemStack field_70482_c[];
    private List field_70480_d;

    public InventoryBasic(String p_i3426_1_, int p_i3426_2_)
    {
        field_70483_a = p_i3426_1_;
        field_70481_b = p_i3426_2_;
        field_70482_c = new ItemStack[p_i3426_2_];
    }

    public ItemStack func_70301_a(int p_70301_1_)
    {
        return field_70482_c[p_70301_1_];
    }

    public ItemStack func_70298_a(int p_70298_1_, int p_70298_2_)
    {
        if(field_70482_c[p_70298_1_] != null)
        {
            if(field_70482_c[p_70298_1_].field_77994_a <= p_70298_2_)
            {
                ItemStack itemstack = field_70482_c[p_70298_1_];
                field_70482_c[p_70298_1_] = null;
                func_70296_d();
                return itemstack;
            }
            ItemStack itemstack1 = field_70482_c[p_70298_1_].func_77979_a(p_70298_2_);
            if(field_70482_c[p_70298_1_].field_77994_a == 0)
            {
                field_70482_c[p_70298_1_] = null;
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
        if(field_70482_c[p_70304_1_] != null)
        {
            ItemStack itemstack = field_70482_c[p_70304_1_];
            field_70482_c[p_70304_1_] = null;
            return itemstack;
        } else
        {
            return null;
        }
    }

    public void func_70299_a(int p_70299_1_, ItemStack p_70299_2_)
    {
        field_70482_c[p_70299_1_] = p_70299_2_;
        if(p_70299_2_ != null && p_70299_2_.field_77994_a > func_70297_j_())
        {
            p_70299_2_.field_77994_a = func_70297_j_();
        }
        func_70296_d();
    }

    public int func_70302_i_()
    {
        return field_70481_b;
    }

    public String func_70303_b()
    {
        return field_70483_a;
    }

    public int func_70297_j_()
    {
        return 64;
    }

    public void func_70296_d()
    {
        if(field_70480_d != null)
        {
            IInvBasic iinvbasic;
            for(Iterator iterator = field_70480_d.iterator(); iterator.hasNext(); iinvbasic.func_76316_a(this))
            {
                iinvbasic = (IInvBasic)iterator.next();
            }

        }
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
