// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiButton, FontRenderer, 
//            GuiMainMenu

public class GuiDisconnected extends GuiScreen
{

    private String field_74248_a;
    private String field_74246_b;
    private Object field_74247_c[];
    private List field_74245_d;

    public GuiDisconnected(String p_i3114_1_, String p_i3114_2_, Object p_i3114_3_[])
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_74248_a = stringtranslate.func_74805_b(p_i3114_1_);
        field_74246_b = p_i3114_2_;
        field_74247_c = p_i3114_3_;
    }

    protected void func_73869_a(char c, int i)
    {
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("gui.toMenu")));
        if(field_74247_c != null)
        {
            field_74245_d = field_73886_k.func_78271_c(stringtranslate.func_74803_a(field_74246_b, field_74247_c), field_73880_f - 50);
        } else
        {
            field_74245_d = field_73886_k.func_78271_c(stringtranslate.func_74805_b(field_74246_b), field_73880_f - 50);
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(new GuiMainMenu());
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_74248_a, field_73880_f / 2, field_73881_g / 2 - 50, 0xaaaaaa);
        int i = field_73881_g / 2 - 30;
        if(field_74245_d == null)
        {
            func_73866_w_();
        }
        for(Iterator iterator = field_74245_d.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            func_73732_a(field_73886_k, s, field_73880_f / 2, i, 0xffffff);
            i += 5;
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
