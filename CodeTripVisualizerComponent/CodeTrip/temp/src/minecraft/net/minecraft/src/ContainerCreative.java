// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Container, EntityPlayer, Slot, GuiContainerCreative, 
//            ItemStack, InventoryBasic

class ContainerCreative extends Container
{

    public List field_75185_e;

    public ContainerCreative(EntityPlayer p_i3082_1_)
    {
        field_75185_e = new ArrayList();
        InventoryPlayer inventoryplayer = p_i3082_1_.field_71071_by;
        for(int i = 0; i < 5; i++)
        {
            for(int k = 0; k < 9; k++)
            {
                func_75146_a(new Slot(GuiContainerCreative.func_74229_i(), i * 9 + k, 9 + k * 18, 18 + i * 18));
            }

        }

        for(int j = 0; j < 9; j++)
        {
            func_75146_a(new Slot(inventoryplayer, j, 9 + j * 18, 112));
        }

        func_75183_a(0.0F);
    }

    public boolean func_75145_c(EntityPlayer p_75145_1_)
    {
        return true;
    }

    public void func_75183_a(float p_75183_1_)
    {
        int i = (field_75185_e.size() / 9 - 5) + 1;
        int j = (int)((double)(p_75183_1_ * (float)i) + 0.5D);
        if(j < 0)
        {
            j = 0;
        }
        for(int k = 0; k < 5; k++)
        {
            for(int l = 0; l < 9; l++)
            {
                int i1 = l + (k + j) * 9;
                if(i1 >= 0 && i1 < field_75185_e.size())
                {
                    GuiContainerCreative.func_74229_i().func_70299_a(l + k * 9, (ItemStack)field_75185_e.get(i1));
                } else
                {
                    GuiContainerCreative.func_74229_i().func_70299_a(l + k * 9, null);
                }
            }

        }

    }

    public boolean func_75184_d()
    {
        return field_75185_e.size() > 45;
    }

    protected void func_75133_b(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
    }

    public ItemStack func_75143_b(int p_75143_1_)
    {
        if(p_75143_1_ >= field_75151_b.size() - 9 && p_75143_1_ < field_75151_b.size())
        {
            Slot slot = (Slot)field_75151_b.get(p_75143_1_);
            if(slot != null && slot.func_75216_d())
            {
                slot.func_75215_d(null);
            }
        }
        return null;
    }
}
