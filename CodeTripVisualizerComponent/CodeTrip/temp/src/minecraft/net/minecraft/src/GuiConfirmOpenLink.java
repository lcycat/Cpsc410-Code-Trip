// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiYesNo, StringTranslate, GuiButton, GuiScreen

public abstract class GuiConfirmOpenLink extends GuiYesNo
{

    private String field_73947_a;
    private String field_73946_b;

    public GuiConfirmOpenLink(GuiScreen p_i3102_1_, String p_i3102_2_, int p_i3102_3_)
    {
        super(p_i3102_1_, StringTranslate.func_74808_a().func_74805_b("chat.link.confirm"), p_i3102_2_, p_i3102_3_);
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73941_c = stringtranslate.func_74805_b("gui.yes");
        field_73939_d = stringtranslate.func_74805_b("gui.no");
        field_73946_b = stringtranslate.func_74805_b("chat.copy");
        field_73947_a = stringtranslate.func_74805_b("chat.link.warning");
    }

    public void func_73866_w_()
    {
        field_73887_h.add(new GuiButton(0, (field_73880_f / 3 - 83) + 0, field_73881_g / 6 + 96, 100, 20, field_73941_c));
        field_73887_h.add(new GuiButton(2, (field_73880_f / 3 - 83) + 105, field_73881_g / 6 + 96, 100, 20, field_73946_b));
        field_73887_h.add(new GuiButton(1, (field_73880_f / 3 - 83) + 210, field_73881_g / 6 + 96, 100, 20, field_73939_d));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 2)
        {
            func_73945_e();
            super.func_73875_a((GuiButton)field_73887_h.get(1));
        } else
        {
            super.func_73875_a(p_73875_1_);
        }
    }

    public abstract void func_73945_e();

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
        func_73732_a(field_73886_k, field_73947_a, field_73880_f / 2, 110, 0xffcccc);
    }
}
