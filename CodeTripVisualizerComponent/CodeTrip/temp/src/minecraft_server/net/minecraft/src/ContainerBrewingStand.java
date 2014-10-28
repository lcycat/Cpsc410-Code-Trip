// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, SlotBrewingStandPotion, InventoryPlayer, SlotBrewingStandIngredient, 
//            Slot, TileEntityBrewingStand, ICrafting, ItemStack, 
//            EntityPlayer

public class ContainerBrewingStand extends Container
{

    private TileEntityBrewingStand field_75188_e;
    private final Slot field_75186_f;
    private int field_75187_g;

    public ContainerBrewingStand(InventoryPlayer p_i3600_1_, TileEntityBrewingStand p_i3600_2_)
    {
        field_75187_g = 0;
        field_75188_e = p_i3600_2_;
        func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 0, 56, 46));
        func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 1, 79, 53));
        func_75146_a(new SlotBrewingStandPotion(p_i3600_1_.field_70458_d, p_i3600_2_, 2, 102, 46));
        field_75186_f = func_75146_a(new SlotBrewingStandIngredient(this, p_i3600_2_, 3, 79, 17));
        for(int i = 0; i < 3; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                func_75146_a(new Slot(p_i3600_1_, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            func_75146_a(new Slot(p_i3600_1_, j, 8 + j * 18, 142));
        }

    }

    public void func_75132_a(ICrafting p_75132_1_)
    {
        super.func_75132_a(p_75132_1_);
        p_75132_1_.func_71112_a(this, 0, field_75188_e.func_70355_t_());
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
            if(field_75187_g != field_75188_e.func_70355_t_())
            {
                icrafting.func_71112_a(this, 0, field_75188_e.func_70355_t_());
            }
        } while(true);
        field_75187_g = field_75188_e.func_70355_t_();
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return field_75188_e.func_70300_a(p_75145_1_);
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)field_75151_b.get(p_75143_1_);
        if(slot != null && slot.func_75216_d())
        {
            ItemStack itemstack1 = slot.func_75211_c();
            itemstack = itemstack1.func_77946_l();
            if(p_75143_1_ >= 0 && p_75143_1_ <= 2 || p_75143_1_ == 3)
            {
                if(!func_75135_a(itemstack1, 4, 40, true))
                {
                    return null;
                }
                slot.func_75220_a(itemstack1, itemstack);
            } else
            if(!field_75186_f.func_75216_d() && field_75186_f.func_75214_a(itemstack1))
            {
                if(!func_75135_a(itemstack1, 3, 4, false))
                {
                    return null;
                }
            } else
            if(SlotBrewingStandPotion.func_75243_a_(itemstack))
            {
                if(!func_75135_a(itemstack1, 0, 3, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 4 && p_75143_1_ < 31)
            {
                if(!func_75135_a(itemstack1, 31, 40, false))
                {
                    return null;
                }
            } else
            if(p_75143_1_ >= 31 && p_75143_1_ < 40)
            {
                if(!func_75135_a(itemstack1, 4, 31, false))
                {
                    return null;
                }
            } else
            if(!func_75135_a(itemstack1, 4, 40, false))
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
