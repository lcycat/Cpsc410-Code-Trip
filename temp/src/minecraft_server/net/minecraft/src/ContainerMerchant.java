// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryMerchant, InventoryPlayer, Slot, 
//            SlotMerchantResult, IMerchant, ItemStack, World, 
//            EntityPlayer, ICrafting, IInventory

public class ContainerMerchant extends Container
{

    private IMerchant field_75178_e;
    private InventoryMerchant field_75176_f;
    private final World field_75177_g;

    public ContainerMerchant(InventoryPlayer p_i3613_1_, IMerchant p_i3613_2_, World p_i3613_3_)
    {
        field_75178_e = p_i3613_2_;
        field_75177_g = p_i3613_3_;
        field_75176_f = new InventoryMerchant(p_i3613_1_.field_70458_d, p_i3613_2_);
        func_75146_a(new Slot(field_75176_f, 0, 36, 53));
        func_75146_a(new Slot(field_75176_f, 1, 62, 53));
        func_75146_a(new SlotMerchantResult(p_i3613_1_.field_70458_d, p_i3613_2_, field_75176_f, 2, 120, 53));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                func_75146_a(new Slot(p_i3613_1_, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            func_75146_a(new Slot(p_i3613_1_, j, 8 + j * 18, 142));
        }

    }

    public InventoryMerchant func_75174_d()
    {
        return field_75176_f;
    }

    public void func_75132_a(ICrafting p_75132_1_)
    {
        super.func_75132_a(p_75132_1_);
    }

    public void func_75142_b()
    {
        super.func_75142_b();
    }

    public void func_75130_a(IInventory p_75130_1_)
    {
        field_75176_f.func_70470_g();
        super.func_75130_a(p_75130_1_);
    }

    public void func_75175_c(int p_75175_1_)
    {
        field_75176_f.func_70471_c(p_75175_1_);
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return field_75178_e.func_70931_l_() == p_75145_1_;
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if(p_75143_1_ == 2)
            {
                if(!func_75135_a(itemstack1, 3, 39, true))
                {
                    return null;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else
            if(p_75143_1_ == 0 || p_75143_1_ == 1)
            {
                if(!func_75135_a(itemstack1, 3, 39, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 3 && p_75143_1_ < 30)
            {
                if(!func_75135_a(itemstack1, 30, 39, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 30 && p_75143_1_ < 39 && !func_75135_a(itemstack1, 3, 30, false))
            {
                return null;
            }
            if(itemstack1.field_77994_a == 0)
            {
                slot.func_75215_d(null);
            } else
            {
                slot.func_75218_e();
            }
            if(itemstack1.field_77994_a == itemstack.field_77994_a)
            {
                return null;
            }
            slot.func_75213_b(itemstack1);
        }
        return itemstack;
    }

    public void func_75134_a(EntityPlayer p_75134_1_)
    {
        super.func_75134_a(p_75134_1_);
        field_75178_e.func_70932_a_(null);
        super.func_75134_a(p_75134_1_);
        if(field_75177_g.field_72995_K)
        {
            return;
        }
        ItemStack itemstack = field_75176_f.func_70304_b(0);
        if(itemstack != null)
        {
            p_75134_1_.func_71021_b(itemstack);
        }
        itemstack = field_75176_f.func_70304_b(1);
        if(itemstack != null)
        {
            p_75134_1_.func_71021_b(itemstack);
        }
    }
}
