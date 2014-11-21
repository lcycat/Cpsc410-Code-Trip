// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiSmallButton, GuiSlotLanguage, 
//            GuiButton, TexturePackList, GameSettings

public class GuiLanguage extends GuiScreen
{

    protected GuiScreen field_74047_a;
    private int field_74045_b;
    private GuiSlotLanguage field_74046_c;
    private final GameSettings field_74044_d;
    private GuiSmallButton field_74048_m;

    public GuiLanguage(GuiScreen p_i3033_1_, GameSettings p_i3033_2_)
    {
        field_74045_b = -1;
        field_74047_a = p_i3033_1_;
        field_74044_d = p_i3033_2_;
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.add(field_74048_m = new GuiSmallButton(6, field_73880_f / 2 - 75, field_73881_g - 38, stringtranslate.func_74805_b("gui.done")));
        field_74046_c = new GuiSlotLanguage(this);
        field_74046_c.func_77220_a(field_73887_h, 7, 8);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        switch(p_73875_1_.field_73741_f)
        {
        case 6: // '\006'
            field_73882_e.func_71373_a(field_74047_a);
            break;

        default:
            field_74046_c.func_77219_a(p_73875_1_);
            break;

        case 5: // '\005'
            break;
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        field_74046_c.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        if(field_74045_b <= 0)
        {
            field_73882_e.field_71418_C.func_77305_c();
            field_74045_b += 20;
        }
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("options.language"), field_73880_f / 2, 16, 0xffffff);
        func_73732_a(field_73886_k, (new StringBuilder()).append("(").append(stringtranslate.func_74805_b("options.languageWarning")).append(")").toString(), field_73880_f / 2, field_73881_g - 56, 0x808080);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        field_74045_b--;
    }

    static GameSettings func_74043_a(GuiLanguage p_74043_0_)
    {
        return p_74043_0_.field_74044_d;
    }

    static GuiSmallButton func_74042_b(GuiLanguage p_74042_0_)
    {
        return p_74042_0_.field_74048_m;
    }
}
