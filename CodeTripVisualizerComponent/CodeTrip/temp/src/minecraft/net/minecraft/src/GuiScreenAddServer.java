// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiTextField, StringTranslate, GuiButton, 
//            ServerData

public class GuiScreenAddServer extends GuiScreen
{

    private GuiScreen field_73999_a;
    private GuiTextField field_73997_b;
    private GuiTextField field_73998_c;
    private ServerData field_73996_d;

    public GuiScreenAddServer(GuiScreen p_i3049_1_, ServerData p_i3049_2_)
    {
        field_73999_a = p_i3049_1_;
        field_73996_d = p_i3049_2_;
    }

    public void func_73876_c()
    {
        field_73998_c.func_73780_a();
        field_73997_b.func_73780_a();
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        Keyboard.enableRepeatEvents(true);
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 96 + 12, stringtranslate.func_74805_b("addServer.add")));
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("gui.cancel")));
        field_73998_c = new GuiTextField(field_73886_k, field_73880_f / 2 - 100, 76, 200, 20);
        field_73998_c.func_73796_b(true);
        field_73998_c.func_73782_a(field_73996_d.field_78847_a);
        field_73997_b = new GuiTextField(field_73886_k, field_73880_f / 2 - 100, 116, 200, 20);
        field_73997_b.func_73804_f(128);
        field_73997_b.func_73782_a(field_73996_d.field_78845_b);
        ((GuiButton)field_73887_h.get(0)).field_73742_g = field_73997_b.func_73781_b().length() > 0 && field_73997_b.func_73781_b().split(":").length > 0 && field_73998_c.func_73781_b().length() > 0;
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
            field_73999_a.func_73878_a(false, 0);
        } else
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73996_d.field_78847_a = field_73998_c.func_73781_b();
            field_73996_d.field_78845_b = field_73997_b.func_73781_b();
            field_73999_a.func_73878_a(true, 0);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        field_73998_c.func_73802_a(p_73869_1_, p_73869_2_);
        field_73997_b.func_73802_a(p_73869_1_, p_73869_2_);
        if(p_73869_1_ == '\t')
        {
            if(field_73998_c.func_73806_l())
            {
                field_73998_c.func_73796_b(false);
                field_73997_b.func_73796_b(true);
            } else
            {
                field_73998_c.func_73796_b(true);
                field_73997_b.func_73796_b(false);
            }
        }
        if(p_73869_1_ == '\r')
        {
            func_73875_a((GuiButton)field_73887_h.get(0));
        }
        ((GuiButton)field_73887_h.get(0)).field_73742_g = field_73997_b.func_73781_b().length() > 0 && field_73997_b.func_73781_b().split(":").length > 0 && field_73998_c.func_73781_b().length() > 0;
        if(((GuiButton)field_73887_h.get(0)).field_73742_g)
        {
            String s = field_73997_b.func_73781_b().trim();
            String as[] = s.split(":");
            if(as.length > 2)
            {
                ((GuiButton)field_73887_h.get(0)).field_73742_g = false;
            }
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        field_73997_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
        field_73998_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73873_v_();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("addServer.title"), field_73880_f / 2, (field_73881_g / 4 - 60) + 20, 0xffffff);
        func_73731_b(field_73886_k, stringtranslate.func_74805_b("addServer.enterName"), field_73880_f / 2 - 100, 63, 0xa0a0a0);
        func_73731_b(field_73886_k, stringtranslate.func_74805_b("addServer.enterIp"), field_73880_f / 2 - 100, 104, 0xa0a0a0);
        field_73998_c.func_73795_f();
        field_73997_b.func_73795_f();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
