// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiSelectWorld, GuiButton, SaveFormatComparator, 
//            MathHelper, EnumGameType, StatCollector, Tessellator

class GuiWorldSlot extends GuiSlot
{

    final GuiSelectWorld field_77254_a; /* synthetic field */

    public GuiWorldSlot(GuiSelectWorld p_i3062_1_)
    {
        field_77254_a = p_i3062_1_;
        super(p_i3062_1_.field_73882_e, p_i3062_1_.field_73880_f, p_i3062_1_.field_73881_g, 32, p_i3062_1_.field_73881_g - 64, 36);
    }

    protected int func_77217_a()
    {
        return GuiSelectWorld.func_74068_a(field_77254_a).size();
    }

    protected void func_77213_a(int p_77213_1_, boolean p_77213_2_)
    {
        GuiSelectWorld.func_74072_a(field_77254_a, p_77213_1_);
        boolean flag = GuiSelectWorld.func_74062_b(field_77254_a) >= 0 && GuiSelectWorld.func_74062_b(field_77254_a) < func_77217_a();
        GuiSelectWorld.func_74070_c(field_77254_a).field_73742_g = flag;
        GuiSelectWorld.func_74059_d(field_77254_a).field_73742_g = flag;
        GuiSelectWorld.func_74071_e(field_77254_a).field_73742_g = flag;
        if(p_77213_2_ && flag)
        {
            field_77254_a.func_74064_e(p_77213_1_);
        }
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return p_77218_1_ == GuiSelectWorld.func_74062_b(field_77254_a);
    }

    protected int func_77212_b()
    {
        return GuiSelectWorld.func_74068_a(field_77254_a).size() * 36;
    }

    protected void func_77221_c()
    {
        field_77254_a.func_73873_v_();
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        SaveFormatComparator saveformatcomparator = (SaveFormatComparator)GuiSelectWorld.func_74068_a(field_77254_a).get(p_77214_1_);
        String s = saveformatcomparator.func_75788_b();
        if(s == null || MathHelper.func_76139_a(s))
        {
            s = (new StringBuilder()).append(GuiSelectWorld.func_74058_f(field_77254_a)).append(" ").append(p_77214_1_ + 1).toString();
        }
        String s1 = saveformatcomparator.func_75786_a();
        s1 = (new StringBuilder()).append(s1).append(" (").append(GuiSelectWorld.func_74060_g(field_77254_a).format(new Date(saveformatcomparator.func_75784_e()))).toString();
        s1 = (new StringBuilder()).append(s1).append(")").toString();
        String s2 = "";
        if(saveformatcomparator.func_75785_d())
        {
            s2 = (new StringBuilder()).append(GuiSelectWorld.func_74066_h(field_77254_a)).append(" ").append(s2).toString();
        } else
        {
            s2 = GuiSelectWorld.func_74067_i(field_77254_a)[saveformatcomparator.func_75790_f().func_77148_a()];
            if(saveformatcomparator.func_75789_g())
            {
                s2 = (new StringBuilder()).append("\2474").append(StatCollector.func_74838_a("gameMode.hardcore")).append("\247r").toString();
            }
            if(saveformatcomparator.func_75783_h())
            {
                s2 = (new StringBuilder()).append(s2).append(", ").append(StatCollector.func_74838_a("selectWorld.cheats")).toString();
            }
        }
        field_77254_a.func_73731_b(field_77254_a.field_73886_k, s, p_77214_2_ + 2, p_77214_3_ + 1, 0xffffff);
        field_77254_a.func_73731_b(field_77254_a.field_73886_k, s1, p_77214_2_ + 2, p_77214_3_ + 12, 0x808080);
        field_77254_a.func_73731_b(field_77254_a.field_73886_k, s2, p_77214_2_ + 2, p_77214_3_ + 12 + 10, 0x808080);
    }
}
