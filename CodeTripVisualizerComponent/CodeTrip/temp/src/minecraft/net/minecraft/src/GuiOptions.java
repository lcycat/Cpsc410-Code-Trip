// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, EnumOptions, GuiSlider, 
//            GameSettings, GuiSmallButton, WorldClient, WorldInfo, 
//            StatCollector, GuiButton, GuiVideoSettings, GuiControls, 
//            GuiLanguage, ScreenChatOptions, GuiSnooper

public class GuiOptions extends GuiScreen
{

    private static final EnumOptions field_74052_b[];
    private final GuiScreen field_74053_c;
    private final GameSettings field_74051_d;
    protected String field_74054_a;

    public GuiOptions(GuiScreen p_i3042_1_, GameSettings p_i3042_2_)
    {
        field_74054_a = "Options";
        field_74053_c = p_i3042_1_;
        field_74051_d = p_i3042_2_;
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        int i = 0;
        field_74054_a = stringtranslate.func_74805_b("options.title");
        EnumOptions aenumoptions[] = field_74052_b;
        int j = aenumoptions.length;
        for(int k = 0; k < j; k++)
        {
            EnumOptions enumoptions = aenumoptions[k];
            if(enumoptions.func_74380_a())
            {
                field_73887_h.add(new GuiSlider(enumoptions.func_74381_c(), (field_73880_f / 2 - 155) + (i % 2) * 160, field_73881_g / 6 + 24 * (i >> 1), enumoptions, field_74051_d.func_74297_c(enumoptions), field_74051_d.func_74296_a(enumoptions)));
            } else
            {
                GuiSmallButton guismallbutton = new GuiSmallButton(enumoptions.func_74381_c(), (field_73880_f / 2 - 155) + (i % 2) * 160, field_73881_g / 6 + 24 * (i >> 1), enumoptions, field_74051_d.func_74297_c(enumoptions));
                if(enumoptions == EnumOptions.DIFFICULTY && field_73882_e.field_71441_e != null && field_73882_e.field_71441_e.func_72912_H().func_76093_s())
                {
                    guismallbutton.field_73742_g = false;
                    guismallbutton.field_73744_e = (new StringBuilder()).append(StatCollector.func_74838_a("options.difficulty")).append(": ").append(StatCollector.func_74838_a("options.difficulty.hardcore")).toString();
                }
                field_73887_h.add(guismallbutton);
            }
            i++;
        }

        field_73887_h.add(new GuiButton(101, field_73880_f / 2 - 152, (field_73881_g / 6 + 96) - 6, 150, 20, stringtranslate.func_74805_b("options.video")));
        field_73887_h.add(new GuiButton(100, field_73880_f / 2 + 2, (field_73881_g / 6 + 96) - 6, 150, 20, stringtranslate.func_74805_b("options.controls")));
        field_73887_h.add(new GuiButton(102, field_73880_f / 2 - 152, (field_73881_g / 6 + 120) - 6, 150, 20, stringtranslate.func_74805_b("options.language")));
        field_73887_h.add(new GuiButton(103, field_73880_f / 2 + 2, (field_73881_g / 6 + 120) - 6, 150, 20, stringtranslate.func_74805_b("options.chat.title")));
        field_73887_h.add(new GuiButton(104, field_73880_f / 2 + 2, (field_73881_g / 6 + 144) - 6, 150, 20, stringtranslate.func_74805_b("options.snooper.view")));
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
            field_74051_d.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
            p_73875_1_.field_73744_e = field_74051_d.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
        }
        if(p_73875_1_.field_73741_f == 101)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(new GuiVideoSettings(this, field_74051_d));
        }
        if(p_73875_1_.field_73741_f == 100)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(new GuiControls(this, field_74051_d));
        }
        if(p_73875_1_.field_73741_f == 102)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(new GuiLanguage(this, field_74051_d));
        }
        if(p_73875_1_.field_73741_f == 103)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(new ScreenChatOptions(this, field_74051_d));
        }
        if(p_73875_1_.field_73741_f == 104)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(new GuiSnooper(this, field_74051_d));
        }
        if(p_73875_1_.field_73741_f == 200)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(field_74053_c);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_74054_a, field_73880_f / 2, 20, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static 
    {
        field_74052_b = (new EnumOptions[] {
            EnumOptions.MUSIC, EnumOptions.SOUND, EnumOptions.INVERT_MOUSE, EnumOptions.SENSITIVITY, EnumOptions.FOV, EnumOptions.DIFFICULTY
        });
    }
}
