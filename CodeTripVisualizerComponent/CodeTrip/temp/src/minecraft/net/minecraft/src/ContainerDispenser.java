// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, TileEntityDispenser, ItemStack, 
//            IInventory, EntityPlayer

public class ContainerDispenser extends Container
{

    private TileEntityDispenser field_75182_e;

    public ContainerDispenser(IInventory p_i3617_1_, TileEntityDispenser p_i3617_2_)
    {
        field_75182_e = p_i3617_2_;
        for(int i = 0; i < 3; i++)
        {
            for(int l = 0; l < 3; l++)
            {
                func_75146_a(new Slot(p_i3617_2_, l + i * 3, 62 + l * 18, 17 + i * 18));
            }

        }

        for(int j = 0; j < 3; j++)
        {
            for(int i1 = 0; i1 < 9; i1++)
            {
                func_75146_a(new Slot(p_i3617_1_, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));
            }

        }

        for(int k = 0; k < 9; k++)
        {
            func_75146_a(new Slot(p_i3617_1_, k, 8 + k * 18, 142));
        }

    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return field_75182_e.func_70300_a(p_75145_1_);
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if(p_75143_1_ < 9)
            {
                if(!func_75135_a(itemstack1, 9, 45, true))
                {
                    return null;
                }
            } else
            if(!func_75135_a(itemstack1, 0, 9, false))
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
}
