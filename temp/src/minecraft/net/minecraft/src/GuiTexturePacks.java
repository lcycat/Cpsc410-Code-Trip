// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiSmallButton, TexturePackList, 
//            GuiTexturePackSlot, GuiButton, EnumOS, RenderEngine, 
//            FontRenderer

public class GuiTexturePacks extends GuiScreen
{

    protected GuiScreen field_73967_a;
    private int field_73965_b;
    private String field_73966_c;
    private GuiTexturePackSlot field_73964_d;

    public GuiTexturePacks(GuiScreen p_i3030_1_)
    {
        field_73965_b = -1;
        field_73966_c = "";
        field_73967_a = p_i3030_1_;
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.add(new GuiSmallButton(5, field_73880_f / 2 - 154, field_73881_g - 48, stringtranslate.func_74805_b("texturePack.openFolder")));
        field_73887_h.add(new GuiSmallButton(6, field_73880_f / 2 + 4, field_73881_g - 48, stringtranslate.func_74805_b("gui.done")));
        field_73882_e.field_71418_C.func_77305_c();
        field_73966_c = (new File(Minecraft.func_71380_b(), "texturepacks")).getAbsolutePath();
        field_73964_d = new GuiTexturePackSlot(this);
        field_73964_d.func_77220_a(field_73887_h, 7, 8);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 5)
        {
            if(Minecraft.func_71376_c() == EnumOS.MACOS)
            {
                try
                {
                    System.out.println(field_73966_c);
                    Runtime.getRuntime().exec(new String[] {
                        "/usr/bin/open", field_73966_c
                    });
                    return;
                }
                catch(IOException ioexception)
                {
                    ioexception.printStackTrace();
                }
            } else
            if(Minecraft.func_71376_c() == EnumOS.WINDOWS)
            {
                String s = String.format("cmd.exe /C start \"Open file\" \"%s\"", new Object[] {
                    field_73966_c
                });
                try
                {
                    Runtime.getRuntime().exec(s);
                    return;
                }
                catch(IOException ioexception1)
                {
                    ioexception1.printStackTrace();
                }
            }
            boolean flag = false;
            try
            {
                Class class1 = Class.forName("java.awt.Desktop");
                Object obj = class1.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                class1.getMethod("browse", new Class[] {
                    java.net.URI.class
                }).invoke(obj, new Object[] {
                    (new File(Minecraft.func_71380_b(), "texturepacks")).toURI()
                });
            }
            catch(Throwable throwable)
            {
                throwable.printStackTrace();
                flag = true;
            }
            if(flag)
            {
                System.out.println("Opening via system class!");
                Sys.openURL((new StringBuilder()).append("file://").append(field_73966_c).toString());
            }
        } else
        if(p_73875_1_.field_73741_f == 6)
        {
            field_73882_e.field_71446_o.func_78352_b();
            field_73882_e.func_71373_a(field_73967_a);
        } else
        {
            field_73964_d.func_77219_a(p_73875_1_);
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    protected void func_73879_b(int p_73879_1_, int p_73879_2_, int p_73879_3_)
    {
        super.func_73879_b(p_73879_1_, p_73879_2_, p_73879_3_);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        field_73964_d.func_77211_a(p_73863_1_, p_73863_2_, p_73863_3_);
        if(field_73965_b <= 0)
        {
            field_73882_e.field_71418_C.func_77305_c();
            field_73965_b += 20;
        }
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("texturePack.title"), field_73880_f / 2, 16, 0xffffff);
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("texturePack.folderInfo"), field_73880_f / 2 - 77, field_73881_g - 26, 0x808080);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        field_73965_b--;
    }

    static Minecraft func_73950_a(GuiTexturePacks p_73950_0_)
    {
        return p_73950_0_.field_73882_e;
    }

    static Minecraft func_73955_b(GuiTexturePacks p_73955_0_)
    {
        return p_73955_0_.field_73882_e;
    }

    static Minecraft func_73958_c(GuiTexturePacks p_73958_0_)
    {
        return p_73958_0_.field_73882_e;
    }

    static Minecraft func_73951_d(GuiTexturePacks p_73951_0_)
    {
        return p_73951_0_.field_73882_e;
    }

    static Minecraft func_73952_e(GuiTexturePacks p_73952_0_)
    {
        return p_73952_0_.field_73882_e;
    }

    static Minecraft func_73962_f(GuiTexturePacks p_73962_0_)
    {
        return p_73962_0_.field_73882_e;
    }

    static Minecraft func_73959_g(GuiTexturePacks p_73959_0_)
    {
        return p_73959_0_.field_73882_e;
    }

    static Minecraft func_73957_h(GuiTexturePacks p_73957_0_)
    {
        return p_73957_0_.field_73882_e;
    }

    static Minecraft func_73956_i(GuiTexturePacks p_73956_0_)
    {
        return p_73956_0_.field_73882_e;
    }

    static Minecraft func_73953_j(GuiTexturePacks p_73953_0_)
    {
        return p_73953_0_.field_73882_e;
    }

    static Minecraft func_73961_k(GuiTexturePacks p_73961_0_)
    {
        return p_73961_0_.field_73882_e;
    }

    static FontRenderer func_73960_l(GuiTexturePacks p_73960_0_)
    {
        return p_73960_0_.field_73886_k;
    }

    static FontRenderer func_73963_m(GuiTexturePacks p_73963_0_)
    {
        return p_73963_0_.field_73886_k;
    }

    static FontRenderer func_73954_n(GuiTexturePacks p_73954_0_)
    {
        return p_73954_0_.field_73886_k;
    }
}
