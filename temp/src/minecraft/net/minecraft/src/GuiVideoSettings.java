// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, EnumOptions, GuiSlider, 
//            GameSettings, GuiSmallButton, GuiButton, ScaledResolution, 
//            StatCollector

public class GuiVideoSettings extends GuiScreen
{

    private GuiScreen field_74105_b;
    protected String field_74107_a;
    private GameSettings field_74106_c;
    private boolean field_74104_d;
    private static EnumOptions field_74108_m[];

    public GuiVideoSettings(GuiScreen p_i3034_1_, GameSettings p_i3034_2_)
    {
        field_74107_a = "Video Settings";
        field_74104_d = false;
        field_74105_b = p_i3034_1_;
        field_74106_c = p_i3034_2_;
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_74107_a = stringtranslate.func_74805_b("options.videoTitle");
        int i = 0;
        Object aobj[] = field_74108_m;
        int j = aobj.length;
        for(int k = 0; k < j; k++)
        {
            EnumOptions enumoptions = aobj[k];
            if(enumoptions.func_74380_a())
            {
                field_73887_h.add(new GuiSlider(enumoptions.func_74381_c(), (field_73880_f / 2 - 155) + (i % 2) * 160, field_73881_g / 6 + 24 * (i >> 1), enumoptions, field_74106_c.func_74297_c(enumoptions), field_74106_c.func_74296_a(enumoptions)));
            } else
            {
                field_73887_h.add(new GuiSmallButton(enumoptions.func_74381_c(), (field_73880_f / 2 - 155) + (i % 2) * 160, field_73881_g / 6 + 24 * (i >> 1), enumoptions, field_74106_c.func_74297_c(enumoptions)));
            }
            i++;
        }

        field_73887_h.add(new GuiButton(200, field_73880_f / 2 - 100, field_73881_g / 6 + 168, stringtranslate.func_74805_b("gui.done")));
        field_74104_d = false;
        aobj = (new String[] {
            "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"
        });
        String as[] = ((String []) (aobj));
        int l = as.length;
        int i1 = 0;
        do
        {
            if(i1 >= l)
            {
                break;
            }
            String s = as[i1];
            String s1 = System.getProperty(s);
            if(s1 != null && s1.contains("64"))
            {
                field_74104_d = true;
                break;
            }
            i1++;
        } while(true);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        int i = field_74106_c.field_74335_Z;
        if(p_73875_1_.field_73741_f < 100 && (p_73875_1_ instanceof GuiSmallButton))
        {
            field_74106_c.func_74306_a(((GuiSmallButton)p_73875_1_).func_73753_a(), 1);
            p_73875_1_.field_73744_e = field_74106_c.func_74297_c(EnumOptions.func_74379_a(p_73875_1_.field_73741_f));
        }
        if(p_73875_1_.field_73741_f == 200)
        {
            field_73882_e.field_71474_y.func_74303_b();
            field_73882_e.func_71373_a(field_74105_b);
        }
        if(field_74106_c.field_74335_Z != i)
        {
            ScaledResolution scaledresolution = new ScaledResolution(field_73882_e.field_71474_y, field_73882_e.field_71443_c, field_73882_e.field_71440_d);
            int j = scaledresolution.func_78326_a();
            int k = scaledresolution.func_78328_b();
            func_73872_a(field_73882_e, j, k);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_74107_a, field_73880_f / 2, 20, 0xffffff);
        if(!field_74104_d && field_74106_c.field_74339_e == 0)
        {
            func_73732_a(field_73886_k, StatCollector.func_74838_a("options.farWarning1"), field_73880_f / 2, field_73881_g / 6 + 144, 0xaf0000);
            func_73732_a(field_73886_k, StatCollector.func_74838_a("options.farWarning2"), field_73880_f / 2, field_73881_g / 6 + 144 + 12, 0xaf0000);
        }
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static 
    {
        field_74108_m = (new EnumOptions[] {
            EnumOptions.GRAPHICS, EnumOptions.RENDER_DISTANCE, EnumOptions.AMBIENT_OCCLUSION, EnumOptions.FRAMERATE_LIMIT, EnumOptions.ANAGLYPH, EnumOptions.VIEW_BOBBING, EnumOptions.GUI_SCALE, EnumOptions.ADVANCED_OPENGL, EnumOptions.GAMMA, EnumOptions.RENDER_CLOUDS, 
            EnumOptions.PARTICLES, EnumOptions.USE_SERVER_TEXTURES
        });
    }
}
