// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, InventoryCrafting, InventoryCraftResult, SlotCrafting, 
//            InventoryPlayer, Slot, CraftingManager, IInventory, 
//            World, EntityPlayer, Block, ItemStack

public class ContainerWorkbench extends Container
{

    public InventoryCrafting field_75162_e;
    public IInventory field_75160_f;
    private World field_75161_g;
    private int field_75164_h;
    private int field_75165_i;
    private int field_75163_j;

    public ContainerWorkbench(InventoryPlayer p_i3603_1_, World p_i3603_2_, int p_i3603_3_, int p_i3603_4_, int p_i3603_5_)
    {
        field_75162_e = new InventoryCrafting(this, 3, 3);
        field_75160_f = new InventoryCraftResult();
        field_75161_g = p_i3603_2_;
        field_75164_h = p_i3603_3_;
        field_75165_i = p_i3603_4_;
        field_75163_j = p_i3603_5_;
        func_75146_a(new SlotCrafting(p_i3603_1_.field_70458_d, field_75162_e, field_75160_f, 0, 124, 35));
        for(int i = 0; i < 3; i++)
        {
            for(int l = 0; l < 3; l++)
            {
                func_75146_a(new Slot(field_75162_e, l + i * 3, 30 + l * 18, 17 + i * 18));
            }

        }

        for(int j = 0; j < 3; j++)
        {
            for(int i1 = 0; i1 < 9; i1++)
            {
                func_75146_a(new Slot(p_i3603_1_, i1 + j * 9 + 9, 8 + i1 * 18, 84 + j * 18));
            }

        }

        for(int k = 0; k < 9; k++)
        {
            func_75146_a(new Slot(p_i3603_1_, k, 8 + k * 18, 142));
        }

        func_75130_a(field_75162_e);
    }

    public void func_75130_a(IInventory p_75130_1_)
    {
        field_75160_f.func_70299_a(0, CraftingManager.func_77594_a().func_77593_a(field_75162_e));
    }

    public void func_75134_a(EntityPlayer p_75134_1_)
    {
        super.func_75134_a(p_75134_1_);
        if(field_75161_g.field_72995_K)
        {
            return;
        }
        for(int i = 0; i < 9; i++)
        {
            ItemStack itemstack = field_75162_e.func_70304_b(i);
            if(itemstack != null)
            {
                p_75134_1_.func_71021_b(itemstack);
            }
        }

    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        if(field_75161_g.func_72798_a(field_75164_h, field_75165_i, field_75163_j) != Block.field_72060_ay.field_71990_ca)
        {
            return false;
        }
        return p_75145_1_.func_70092_e((double)field_75164_h + 0.5D, (double)field_75165_i + 0.5D, (double)field_75163_j + 0.5D) <= 64D;
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
                if(!func_75135_a(itemstack1, 10, 46, true))
                {
                    return null;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else
            if(p_75143_1_ >= 10 && p_75143_1_ < 37)
            {
                if(!func_75135_a(itemstack1, 37, 46, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 37 && p_75143_1_ < 46)
            {
                if(!func_75135_a(itemstack1, 10, 37, false))
                {
                    return null;
                }
            } else
            if(!func_75135_a(itemstack1, 10, 46, false))
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
