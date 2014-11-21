// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiSmallButton, GuiButton

public class GuiYesNo extends GuiScreen
{

    private GuiScreen field_73942_a;
    private String field_73940_b;
    private String field_73944_m;
    protected String field_73941_c;
    protected String field_73939_d;
    private int field_73943_n;

    public GuiYesNo(GuiScreen p_i3047_1_, String p_i3047_2_, String p_i3047_3_, int p_i3047_4_)
    {
        field_73942_a = p_i3047_1_;
        field_73940_b = p_i3047_2_;
        field_73944_m = p_i3047_3_;
        field_73943_n = p_i3047_4_;
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73941_c = stringtranslate.func_74805_b("gui.yes");
        field_73939_d = stringtranslate.func_74805_b("gui.no");
    }

    public GuiYesNo(GuiScreen p_i3048_1_, String p_i3048_2_, String p_i3048_3_, String p_i3048_4_, String p_i3048_5_, int p_i3048_6_)
    {
        field_73942_a = p_i3048_1_;
        field_73940_b = p_i3048_2_;
        field_73944_m = p_i3048_3_;
        field_73941_c = p_i3048_4_;
        field_73939_d = p_i3048_5_;
        field_73943_n = p_i3048_6_;
    }

    public void func_73866_w_()
    {
        field_73887_h.add(new GuiSmallButton(0, field_73880_f / 2 - 155, field_73881_g / 6 + 96, field_73941_c));
        field_73887_h.add(new GuiSmallButton(1, (field_73880_f / 2 - 155) + 160, field_73881_g / 6 + 96, field_73939_d));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        field_73942_a.func_73878_a(p_73875_1_.field_73741_f == 0, field_73943_n);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_73940_b, field_73880_f / 2, 70, 0xffffff);
        func_73732_a(field_73886_k, field_73944_m, field_73880_f / 2, 90, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
