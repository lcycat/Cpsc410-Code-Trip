// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiTextField, StringTranslate, GuiButton, 
//            ISaveFormat, WorldInfo

public class GuiRenameWorld extends GuiScreen
{

    private GuiScreen field_74057_a;
    private GuiTextField field_74055_b;
    private final String field_74056_c;

    public GuiRenameWorld(GuiScreen p_i3052_1_, String p_i3052_2_)
    {
        field_74057_a = p_i3052_1_;
        field_74056_c = p_i3052_2_;
    }

    public void func_73876_c()
    {
        field_74055_b.func_73780_a();
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        Keyboard.enableRepeatEvents(true);
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 96 + 12, stringtranslate.func_74805_b("selectWorld.renameButton")));
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("gui.cancel")));
        ISaveFormat isaveformat = field_73882_e.func_71359_d();
        WorldInfo worldinfo = isaveformat.func_75803_c(field_74056_c);
        String s = worldinfo.func_76065_j();
        field_74055_b = new GuiTextField(field_73886_k, field_73880_f / 2 - 100, 60, 200, 20);
        field_74055_b.func_73796_b(true);
        field_74055_b.func_73782_a(s);
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71373_a(field_74057_a);
        } else
        if(p_73875_1_.field_73741_f == 0)
        {
            ISaveFormat isaveformat = field_73882_e.func_71359_d();
            isaveformat.func_75806_a(field_74056_c, field_74055_b.func_73781_b().trim());
            field_73882_e.func_71373_a(field_74057_a);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        field_74055_b.func_73802_a(p_73869_1_, p_73869_2_);
        ((GuiButton)field_73887_h.get(0)).field_73742_g = field_74055_b.func_73781_b().trim().length() > 0;
        if(p_73869_1_ == '\r')
        {
            func_73875_a((GuiButton)field_73887_h.get(0));
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        field_74055_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73873_v_();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("selectWorld.renameTitle"), field_73880_f / 2, (field_73881_g / 4 - 60) + 20, 0xffffff);
        func_73731_b(field_73886_k, stringtranslate.func_74805_b("selectWorld.enterName"), field_73880_f / 2 - 100, 47, 0xa0a0a0);
        field_74055_b.func_73795_f();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
