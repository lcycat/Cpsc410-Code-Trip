// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Comparator;

// Referenced classes of package net.minecraft.src:
//            StatCrafting, GuiSlotStatsBlock, StatList, GuiStats, 
//            StatFileWriter

class SorterStatsBlock
    implements Comparator
{

    final GuiStats field_78336_a; /* synthetic field */
    final GuiSlotStatsBlock field_78335_b; /* synthetic field */

    SorterStatsBlock(GuiSlotStatsBlock p_i3075_1_, GuiStats p_i3075_2_)
    {
        field_78335_b = p_i3075_1_;
        field_78336_a = p_i3075_2_;
        super();
    }

    public int func_78334_a(StatCrafting p_78334_1_, StatCrafting p_78334_2_)
    {
        int i = p_78334_1_.func_75982_a();
        int j = p_78334_2_.func_75982_a();
        StatBase statbase = null;
        StatBase statbase1 = null;
        if(field_78335_b.field_77264_j == 2)
        {
            statbase = StatList.field_75934_C[i];
            statbase1 = StatList.field_75934_C[j];
        } else
        if(field_78335_b.field_77264_j == 0)
        {
            statbase = StatList.field_75928_D[i];
            statbase1 = StatList.field_75928_D[j];
        } else
        if(field_78335_b.field_77264_j == 1)
        {
            statbase = StatList.field_75929_E[i];
            statbase1 = StatList.field_75929_E[j];
        }
        if(statbase != null || statbase1 != null)
        {
            if(statbase == null)
            {
                return 1;
            }
            if(statbase1 == null)
            {
                return -1;
            }
            int k = GuiStats.func_74127_c(field_78335_b.field_77268_a).func_77444_a(statbase);
            int l = GuiStats.func_74127_c(field_78335_b.field_77268_a).func_77444_a(statbase1);
            if(k != l)
            {
                return (k - l) * field_78335_b.field_77265_k;
            }
        }
        return i - j;
    }

    public int compare(Object p_compare_1_, Object p_compare_2_)
    {
        return func_78334_a((StatCrafting)p_compare_1_, (StatCrafting)p_compare_2_);
    }
}
