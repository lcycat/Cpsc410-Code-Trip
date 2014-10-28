// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, EnumOptions, GuiSlider, 
//            GameSettings, GuiSmallButton, GuiButton

public class ScreenChatOptions extends GuiScreen
{

    private static final EnumOptions field_73891_a[];
    private final GuiScreen field_73889_b;
    private final GameSettings field_73890_c;
    private String field_73888_d;

    public ScreenChatOptions(GuiScreen p_i3044_1_, GameSettings p_i3044_2_)
    {
        field_73889_b = p_i3044_1_;
        field_73890_c = p_i3044_2_;
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        int i = 0;
        field_73888_d = stringtranslate.func_74805_b("options.chat.title");
        EnumOptions aenumoptions[] = field_73891_a;
        int j = aenumoptions.length;
        for(int k = 0; k < j; k++)
        {
            EnumOptions enumoptions = aenumoptions[k];
            if(enumoptions.func_74380_a())
            {
                field_73887_h.add(new GuiSlider(enumoptions.func_74381_c(), (field_73880_f / 2 - 155) + (i % 2) * 160, field_73881_g / 6 + 24 * (i >> 1), enumoptions, field_73890_c.func_74297_c(enumoptions), field_73890_c.func_74296_a(enumoptions)));
            } else
            {
                field_73887_h.add(new GuiSmallButton(enumoptions.func_74381_c(), (field_73880_f / 2 - 155) + (i % 2) * 160, field_73881_g / 6 + 24 * (i >> 1), enumoptions, field_73890_c.func_74297_c(enumoptions)));
            }
            i++;
        }

        field_73887_h.add(new GuiButton(200, field_73880_f / 2 - 100, field_73881_g / 6 + 168, stringtranslate.func_74805_b("gui.done")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f < 100 && (p_73875_1_ instanceof GuiSmallButton))
        {
            field_73890_c.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
            p_73875_1_.field_73744_e = field_73890_c.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
        }
        if(p_73875_1_.field_73741_f == 200)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(field_73889_b);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_73888_d, field_73880_f / 2, 20, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static 
    {
        field_73891_a = (new EnumOptions[] {
            EnumOptions.CHAT_VISIBILITY, EnumOptions.CHAT_COLOR, EnumOptions.CHAT_LINKS, EnumOptions.CHAT_OPACITY, EnumOptions.CHAT_LINKS_PROMPT
        });
    }
}
