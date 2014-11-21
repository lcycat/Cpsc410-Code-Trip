// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiTextField, StringTranslate, GuiButton, 
//            ServerData

public class GuiScreenServerList extends GuiScreen
{

    private static String field_73994_a = "";
    private final GuiScreen field_73992_b;
    private final ServerData field_73993_c;
    private GuiTextField field_73991_d;

    public GuiScreenServerList(GuiScreen p_i3066_1_, ServerData p_i3066_2_)
    {
        field_73992_b = p_i3066_1_;
        field_73993_c = p_i3066_2_;
    }

    public void func_73876_c()
    {
        field_73991_d.func_73780_a();
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        Keyboard.enableRepeatEvents(true);
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 96 + 12, stringtranslate.func_74805_b("selectServer.select")));
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("gui.cancel")));
        field_73991_d = new GuiTextField(field_73886_k, field_73880_f / 2 - 100, 116, 200, 20);
        field_73991_d.func_73804_f(128);
        field_73991_d.func_73796_b(true);
        field_73991_d.func_73782_a(field_73994_a);
        ((GuiButton)field_73887_h.get(0)).field_73742_g = field_73991_d.func_73781_b().length() > 0 && field_73991_d.func_73781_b().split(":").length > 0;
    }

    public void func_73874_b()
    {
        Keyboard.enableRepeatEvents(false);
        field_73994_a = field_73991_d.func_73781_b();
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(!p_73875_1_.field_73742_g)
        {
            return;
        }
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73992_b.func_73878_a(false, 0);
        } else
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73993_c.field_78845_b = field_73991_d.func_73781_b();
            field_73992_b.func_73878_a(true, 0);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(field_73991_d.func_73802_a(p_73869_1_, p_73869_2_))
        {
            ((GuiButton)field_73887_h.get(0)).field_73742_g = field_73991_d.func_73781_b().length() > 0 && field_73991_d.func_73781_b().split(":").length > 0;
        } else
        if(p_73869_2_ == 28)
        {
            func_73875_a((GuiButton)field_73887_h.get(0));
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        field_73991_d.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73873_v_();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("selectServer.direct"), field_73880_f / 2, (field_73881_g / 4 - 60) + 20, 0xffffff);
        func_73731_b(field_73886_k, stringtranslate.func_74805_b("addServer.enterIp"), field_73880_f / 2 - 100, 100, 0xa0a0a0);
        field_73991_d.func_73795_f();
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

}
