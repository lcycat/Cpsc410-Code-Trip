// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, Slot, SlotArmor, CraftingManager, 
//            IInventory, EntityPlayer, ItemStack, ItemArmor

public class ContainerPlayer extends Container
{

    public InventoryCrafting field_75181_e;
    public IInventory field_75179_f;
    public boolean field_75180_g;

    public ContainerPlayer(InventoryPlayer p_i3610_1_)
    {
        this(p_i3610_1_, true);
    }

    public ContainerPlayer(InventoryPlayer p_i3611_1_, boolean p_i3611_2_)
    {
        field_75181_e = new InventoryCrafting(this, 2, 2);
        field_75179_f = new InventoryCraftResult();
        field_75180_g = false;
        field_75180_g = p_i3611_2_;
        func_75146_a(new SlotCrafting(p_i3611_1_.field_70458_d, field_75181_e, field_75179_f, 0, 144, 36));
        for(int i = 0; i < 2; i++)
        {
            for(int i1 = 0; i1 < 2; i1++)
            {
                func_75146_a(new Slot(field_75181_e, i1 + i * 2, 88 + i1 * 18, 26 + i * 18));
            }

        }

        for(int j = 0; j < 4; j++)
        {
            int j1 = j;
            func_75146_a(new SlotArmor(this, p_i3611_1_, p_i3611_1_.func_70302_i_() - 1 - j, 8, 8 + j * 18, j1));
        }

        for(int k = 0; k < 3; k++)
        {
            for(int k1 = 0; k1 < 9; k1++)
            {
                func_75146_a(new Slot(p_i3611_1_, k1 + (k + 1) * 9, 8 + k1 * 18, 84 + k * 18));
            }

        }

        for(int l = 0; l < 9; l++)
        {
            func_75146_a(new Slot(p_i3611_1_, l, 8 + l * 18, 142));
        }

        func_75130_a(field_75181_e);
    }

    public void func_75130_a(IInventory p_75130_1_)
    {
        field_75179_f.func_70299_a(0, CraftingManager.func_77594_a().func_77593_a(field_75181_e));
    }

    public void func_75134_a(EntityPlayer p_75134_1_)
    {
        super.func_75134_a(p_75134_1_);
        for(int i = 0; i < 4; i++)
        {
            ItemStack itemstack = field_75181_e.func_70304_b(i);
            if(itemstack != null)
            {
                p_75134_1_.func_71021_b(itemstack);
            }
        }

        field_75179_f.func_70299_a(0, null);
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return true;
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if(p_75143_1_ == 0)
            {
                if(!func_75135_a(itemstack1, 9, 45, true))
                {
                    return null;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else
            if(p_75143_1_ >= 1 && p_75143_1_ < 5)
            {
                if(!func_75135_a(itemstack1, 9, 45, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 5 && p_75143_1_ < 9)
            {
                if(!func_75135_a(itemstack1, 9, 45, false))
                {
                    return null;
                }
            } else
            if((itemstack.func_77973_b() instanceof ItemArmor) && !((Slot)field_75151_b.get(5 + ((ItemArmor)itemstack.func_77973_b()).field_77881_a)).func_75216_d())
            {
                int i = 5 + ((ItemArmor)itemstack.func_77973_b()).field_77881_a;
                if(!func_75135_a(itemstack1, i, i + 1, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 9 && p_75143_1_ < 36)
            {
                if(!func_75135_a(itemstack1, 36, 45, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 36 && p_75143_1_ < 45)
            {
                if(!func_75135_a(itemstack1, 9, 36, false))
                {
                    return null;
                }
            } else
            if(!func_75135_a(itemstack1, 9, 45, false))
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
