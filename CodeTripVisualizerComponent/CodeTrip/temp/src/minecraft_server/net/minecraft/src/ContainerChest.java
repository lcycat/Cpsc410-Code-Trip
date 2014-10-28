// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, IInventory, Slot, ItemStack, 
//            EntityPlayer

public class ContainerChest extends Container
{

    private IInventory field_75155_e;
    private int field_75154_f;

    public ContainerChest(IInventory p_i3601_1_, IInventory p_i3601_2_)
    {
        field_75155_e = p_i3601_2_;
        field_75154_f = p_i3601_2_.func_70302_i_() / 9;
        p_i3601_2_.func_70295_k_();
        int i = (field_75154_f - 4) * 18;
        for(int j = 0; j < field_75154_f; j++)
        {
            for(int i1 = 0; i1 < 9; i1++)
            {
                func_75146_a(new Slot(p_i3601_2_, i1 + j * 9, 8 + i1 * 18, 18 + j * 18));
            }

        }

        for(int k = 0; k < 3; k++)
        {
            for(int j1 = 0; j1 < 9; j1++)
            {
                func_75146_a(new Slot(p_i3601_1_, j1 + k * 9 + 9, 8 + j1 * 18, 103 + k * 18 + i));
            }

        }

        for(int l = 0; l < 9; l++)
        {
            func_75146_a(new Slot(p_i3601_1_, l, 8 + l * 18, 161 + i));
        }

    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return field_75155_e.func_70300_a(p_75145_1_);
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if(p_75143_1_ < field_75154_f * 9)
            {
                if(!func_75135_a(itemstack1, field_75154_f * 9, field_75151_b.size(), true))
                {
                    return null;
                }
            } else
            if(!func_75135_a(itemstack1, 0, field_75154_f * 9, false))
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
        }
        return itemstack;
    }

    public void func_75134_a(EntityPlayer p_75134_1_)
    {
        super.func_75134_a(p_75134_1_);
        field_75155_e.func_70305_f();
    }
}
