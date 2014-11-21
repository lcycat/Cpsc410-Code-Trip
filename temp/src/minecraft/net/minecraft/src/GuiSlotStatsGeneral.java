// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiStats, StatList, StatBase, 
//            StatCollector, StatFileWriter, FontRenderer, Tessellator

class GuiSlotStatsGeneral extends GuiSlot
{

    final GuiStats field_77256_a; /* synthetic field */

    public GuiSlotStatsGeneral(GuiStats p_i3076_1_)
    {
        field_77256_a = p_i3076_1_;
        super(GuiStats.func_74130_a(p_i3076_1_), p_i3076_1_.field_73880_f, p_i3076_1_.field_73881_g, 32, p_i3076_1_.field_73881_g - 64, 10);
        func_77216_a(false);
    }

    protected int func_77217_a()
    {
        return StatList.field_75941_c.size();
    }

    protected void func_77213_a(int i, boolean flag)
    {
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return false;
    }

    protected int func_77212_b()
    {
        return func_77217_a() * 10;
    }

    protected void func_77221_c()
    {
        field_77256_a.func_73873_v_();
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        StatBase statbase = (StatBase)StatList.field_75941_c.get(p_77214_1_);
        field_77256_a.func_73731_b(GuiStats.func_74145_b(field_77256_a), StatCollector.func_74838_a(statbase.func_75970_i()), p_77214_2_ + 2, p_77214_3_ + 1, p_77214_1_ % 2 != 0 ? 0x909090 : 0xffffff);
        String s = statbase.func_75968_a(GuiStats.func_74127_c(field_77256_a).func_77444_a(statbase));
        field_77256_a.func_73731_b(GuiStats.func_74132_d(field_77256_a), s, (p_77214_2_ + 2 + 213) - GuiStats.func_74128_e(field_77256_a).func_78256_a(s), p_77214_3_ + 1, p_77214_1_ % 2 != 0 ? 0x909090 : 0xffffff);
    }
}
