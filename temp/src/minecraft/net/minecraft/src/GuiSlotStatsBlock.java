// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            GuiSlotStats, StatList, StatCrafting, GuiStats, 
//            StatFileWriter, SorterStatsBlock, Tessellator

class GuiSlotStatsBlock extends GuiSlotStats
{

    final GuiStats field_77268_a; /* synthetic field */

    public GuiSlotStatsBlock(GuiStats p_i3074_1_)
    {
        field_77268_a = p_i3074_1_;
        super(p_i3074_1_);
        field_77266_h = new ArrayList();
        Iterator iterator = StatList.field_75939_e.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StatCrafting statcrafting = (StatCrafting)iterator.next();
            boolean flag = false;
            int i = statcrafting.func_75982_a();
            if(GuiStats.func_74127_c(p_i3074_1_).func_77444_a(statcrafting) > 0)
            {
                flag = true;
            } else
            if(StatList.field_75929_E[i] != null && GuiStats.func_74127_c(p_i3074_1_).func_77444_a(StatList.field_75929_E[i]) > 0)
            {
                flag = true;
            } else
            if(StatList.field_75928_D[i] != null && GuiStats.func_74127_c(p_i3074_1_).func_77444_a(StatList.field_75928_D[i]) > 0)
            {
                flag = true;
            }
            if(flag)
            {
                field_77266_h.add(statcrafting);
            }
        } while(true);
        field_77267_i = new SorterStatsBlock(this, p_i3074_1_);
    }

    protected void func_77222_a(int p_77222_1_, int p_77222_2_, Tessellator p_77222_3_)
    {
        super.func_77222_a(p_77222_1_, p_77222_2_, p_77222_3_);
        if(field_77262_g == 0)
        {
            GuiStats.func_74134_a(field_77268_a, ((p_77222_1_ + 115) - 18) + 1, p_77222_2_ + 1 + 1, 18, 18);
        } else
        {
            GuiStats.func_74134_a(field_77268_a, (p_77222_1_ + 115) - 18, p_77222_2_ + 1, 18, 18);
        }
        if(field_77262_g == 1)
        {
            GuiStats.func_74134_a(field_77268_a, ((p_77222_1_ + 165) - 18) + 1, p_77222_2_ + 1 + 1, 36, 18);
        } else
        {
            GuiStats.func_74134_a(field_77268_a, (p_77222_1_ + 165) - 18, p_77222_2_ + 1, 36, 18);
        }
        if(field_77262_g == 2)
        {
            GuiStats.func_74134_a(field_77268_a, ((p_77222_1_ + 215) - 18) + 1, p_77222_2_ + 1 + 1, 54, 18);
        } else
        {
            GuiStats.func_74134_a(field_77268_a, (p_77222_1_ + 215) - 18, p_77222_2_ + 1, 54, 18);
        }
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        StatCrafting statcrafting = func_77257_d(p_77214_1_);
        int i = statcrafting.func_75982_a();
        GuiStats.func_74131_a(field_77268_a, p_77214_2_ + 40, p_77214_3_, i);
        func_77260_a((StatCrafting)StatList.field_75928_D[i], p_77214_2_ + 115, p_77214_3_, p_77214_1_ % 2 == 0);
        func_77260_a((StatCrafting)StatList.field_75929_E[i], p_77214_2_ + 165, p_77214_3_, p_77214_1_ % 2 == 0);
        func_77260_a(statcrafting, p_77214_2_ + 215, p_77214_3_, p_77214_1_ % 2 == 0);
    }

    protected String func_77258_c(int p_77258_1_)
    {
        if(p_77258_1_ == 0)
        {
            return "stat.crafted";
        }
        if(p_77258_1_ == 1)
        {
            return "stat.used";
        } else
        {
            return "stat.mined";
        }
    }
}
