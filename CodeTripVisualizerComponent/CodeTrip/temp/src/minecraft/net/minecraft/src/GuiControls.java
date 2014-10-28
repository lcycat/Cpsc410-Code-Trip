// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GameSettings, GuiSmallButton, 
//            GuiButton, KeyBinding

public class GuiControls extends GuiScreen
{

    private GuiScreen field_73909_b;
    protected String field_73911_a;
    private GameSettings field_73910_c;
    private int field_73908_d;

    public GuiControls(GuiScreen p_i3032_1_, GameSettings p_i3032_2_)
    {
        field_73911_a = "Controls";
        field_73908_d = -1;
        field_73909_b = p_i3032_1_;
        field_73910_c = p_i3032_2_;
    }

    private int func_73907_g()
    {
        return field_73880_f / 2 - 155;
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        int i = func_73907_g();
        for(int j = 0; j < field_73910_c.field_74324_K.length; j++)
        {
            field_73887_h.add(new GuiSmallButton(j, i + (j % 2) * 160, field_73881_g / 6 + 24 * (j >> 1), 70, 20, field_73910_c.func_74301_b(j)));
        }

        field_73887_h.add(new GuiButton(200, field_73880_f / 2 - 100, field_73881_g / 6 + 168, stringtranslate.func_74805_b("gui.done")));
        field_73911_a = stringtranslate.func_74805_b("controls.title");
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        for(int i = 0; i < field_73910_c.field_74324_K.length; i++)
        {
            ((GuiButton)field_73887_h.get(i)).field_73744_e = field_73910_c.func_74301_b(i);
        }

        if(p_73875_1_.field_73741_f == 200)
        {
            field_73882_e.func_71373_a(field_73909_b);
        } else
        {
            field_73908_d = p_73875_1_.field_73741_f;
            p_73875_1_.field_73744_e = (new StringBuilder()).append("> ").append(field_73910_c.func_74301_b(p_73875_1_.field_73741_f)).append(" <").toString();
        }
    }

    protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        if(field_73908_d >= 0)
        {
            field_73910_c.func_74307_a(field_73908_d, -100 + p_73864_3_);
            ((GuiButton)field_73887_h.get(field_73908_d)).field_73744_e = field_73910_c.func_74301_b(field_73908_d);
            field_73908_d = -1;
            KeyBinding.func_74508_b();
        } else
        {
            super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
        }
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(field_73908_d >= 0)
        {
            field_73910_c.func_74307_a(field_73908_d, p_73869_2_);
            ((GuiButton)field_73887_h.get(field_73908_d)).field_73744_e = field_73910_c.func_74301_b(field_73908_d);
            field_73908_d = -1;
            KeyBinding.func_74508_b();
        } else
        {
            super.func_73869_a(p_73869_1_, p_73869_2_);
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, field_73911_a, field_73880_f / 2, 20, 0xffffff);
        int i = func_73907_g();
        for(int j = 0; j < field_73910_c.field_74324_K.length; j++)
        {
            boolean flag = false;
            int k = 0;
            do
            {
                if(k >= field_73910_c.field_74324_K.length)
                {
                    break;
                }
                if(k != j && field_73910_c.field_74324_K[j].field_74512_d == field_73910_c.field_74324_K[k].field_74512_d)
                {
                    flag = true;
                    break;
                }
                k++;
            } while(true);
            if(field_73908_d == j)
            {
                ((GuiButton)field_73887_h.get(j)).field_73744_e = "\247f> \247e??? \247f<";
            } else
            if(flag)
            {
                ((GuiButton)field_73887_h.get(j)).field_73744_e = (new StringBuilder()).append("\247c").append(field_73910_c.func_74301_b(j)).toString();
            } else
            {
                ((GuiButton)field_73887_h.get(j)).field_73744_e = field_73910_c.func_74301_b(j);
            }
            func_73731_b(field_73886_k, field_73910_c.func_74302_a(j), i + (j % 2) * 160 + 70 + 6, field_73881_g / 6 + 24 * (j >> 1) + 7, -1);
        }

        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
