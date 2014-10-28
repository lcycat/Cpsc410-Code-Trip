// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, Slot, SlotFurnace, InventoryPlayer, 
//            TileEntityFurnace, ICrafting, ItemStack, FurnaceRecipes, 
//            Item, EntityPlayer

public class ContainerFurnace extends Container
{

    private TileEntityFurnace field_75158_e;
    private int field_75156_f;
    private int field_75157_g;
    private int field_75159_h;

    public ContainerFurnace(InventoryPlayer p_i3607_1_, TileEntityFurnace p_i3607_2_)
    {
        field_75156_f = 0;
        field_75157_g = 0;
        field_75159_h = 0;
        field_75158_e = p_i3607_2_;
        func_75146_a(new Slot(p_i3607_2_, 0, 56, 17));
        func_75146_a(new Slot(p_i3607_2_, 1, 56, 53));
        func_75146_a(new SlotFurnace(p_i3607_1_.field_70458_d, p_i3607_2_, 2, 116, 35));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                func_75146_a(new Slot(p_i3607_1_, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            func_75146_a(new Slot(p_i3607_1_, j, 8 + j * 18, 142));
        }

    }

    public void func_75132_a(ICrafting p_75132_1_)
    {
        super.func_75132_a(p_75132_1_);
        p_75132_1_.func_71112_a(this, 0, field_75158_e.field_70406_c);
        p_75132_1_.func_71112_a(this, 1, field_75158_e.field_70407_a);
        p_75132_1_.func_71112_a(this, 2, field_75158_e.field_70405_b);
    }

    public void func_75142_b()
    {
        super.func_75142_b();
        Iterator iterator = field_75149_d.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            ICrafting icrafting = (ICrafting)iterator.next();
            if(field_75156_f != field_75158_e.field_70406_c)
            {
                icrafting.func_71112_a(this, 0, field_75158_e.field_70406_c);
            }
            if(field_75157_g != field_75158_e.field_70407_a)
            {
                icrafting.func_71112_a(this, 1, field_75158_e.field_70407_a);
            }
            if(field_75159_h != field_75158_e.field_70405_b)
            {
                icrafting.func_71112_a(this, 2, field_75158_e.field_70405_b);
            }
        } while(true);
        field_75156_f = field_75158_e.field_70406_c;
        field_75157_g = field_75158_e.field_70407_a;
        field_75159_h = field_75158_e.field_70405_b;
    }

    public void func_75137_b(int p_75137_1_, int p_75137_2_)
    {
        if(p_75137_1_ == 0)
        {
            field_75158_e.field_70406_c = p_75137_2_;
        }
        if(p_75137_1_ == 1)
        {
            field_75158_e.field_70407_a = p_75137_2_;
        }
        if(p_75137_1_ == 2)
        {
            field_75158_e.field_70405_b = p_75137_2_;
        }
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return field_75158_e.func_70300_a(p_75145_1_);
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
            if(p_75143_1_ == 1 || p_75143_1_ == 0)
            {
                if(!func_75135_a(itemstack1, 3, 39, false))
                {
                    return null;
                }
            } else
            if(FurnaceRecipes.func_77602_a().func_77603_b(itemstack1.func_77973_b().field_77779_bT) != null)
            {
                if(!func_75135_a(itemstack1, 0, 1, false))
                {
                    return null;
                }
            } else
            if(TileEntityFurnace.func_70401_b(itemstack1))
            {
                if(!func_75135_a(itemstack1, 1, 2, false))
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
}
