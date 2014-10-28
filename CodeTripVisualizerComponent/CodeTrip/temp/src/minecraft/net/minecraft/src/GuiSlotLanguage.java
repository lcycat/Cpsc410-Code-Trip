// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiLanguage, StringTranslate, FontRenderer, 
//            GameSettings, GuiSmallButton, Tessellator

class GuiSlotLanguage extends GuiSlot
{

    private ArrayList field_77251_g;
    private TreeMap field_77253_h;
    final GuiLanguage field_77252_a; /* synthetic field */

    public GuiSlotLanguage(GuiLanguage p_i3061_1_)
    {
        field_77252_a = p_i3061_1_;
        super(p_i3061_1_.field_73882_e, p_i3061_1_.field_73880_f, p_i3061_1_.field_73881_g, 32, (p_i3061_1_.field_73881_g - 65) + 4, 18);
        field_77253_h = StringTranslate.func_74808_a().func_74806_b();
        field_77251_g = new ArrayList();
        String s;
        for(Iterator iterator = field_77253_h.keySet().iterator(); iterator.hasNext(); field_77251_g.add(s))
        {
            s = (String)iterator.next();
        }

    }

    protected int func_77217_a()
    {
        return field_77251_g.size();
    }

    protected void func_77213_a(int p_77213_1_, boolean p_77213_2_)
    {
        StringTranslate.func_74808_a().func_74810_a((String)field_77251_g.get(p_77213_1_));
        field_77252_a.field_73882_e.field_71466_p.func_78264_a(StringTranslate.func_74808_a().func_74804_d());
        GuiLanguage.func_74043_a(field_77252_a).field_74363_ab = (String)field_77251_g.get(p_77213_1_);
        field_77252_a.field_73886_k.func_78275_b(StringTranslate.func_74802_e(GuiLanguage.func_74043_a(field_77252_a).field_74363_ab));
        GuiLanguage.func_74042_b(field_77252_a).field_73744_e = StringTranslate.func_74808_a().func_74805_b("gui.done");
        GuiLanguage.func_74043_a(field_77252_a).func_74303_b();
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return ((String)field_77251_g.get(p_77218_1_)).equals(StringTranslate.func_74808_a().func_74811_c());
    }

    protected int func_77212_b()
    {
        return func_77217_a() * 18;
    }

    protected void func_77221_c()
    {
        field_77252_a.func_73873_v_();
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        field_77252_a.field_73886_k.func_78275_b(true);
        field_77252_a.func_73732_a(field_77252_a.field_73886_k, (String)field_77253_h.get(field_77251_g.get(p_77214_1_)), field_77252_a.field_73880_f / 2, p_77214_3_ + 1, 0xffffff);
        field_77252_a.field_73886_k.func_78275_b(StringTranslate.func_74802_e(GuiLanguage.func_74043_a(field_77252_a).field_74363_ab));
    }
}
