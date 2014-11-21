// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, StatCollector, RenderEngine, 
//            FontRenderer, GameSettings, KeyBinding

public class GuiScreenDemo extends GuiScreen
{

    public GuiScreenDemo()
    {
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
        byte byte0 = -16;
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 116, field_73881_g / 4 + 132 + byte0, 114, 20, StatCollector.func_74838_a("demo.help.buy")));
        field_73887_h.add(new GuiButton(2, field_73880_f / 2 + 2, field_73881_g / 4 + 132 + byte0, 114, 20, StatCollector.func_74838_a("demo.help.later")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        switch(p_73875_1_.field_73741_f)
        {
        default:
            break;

        case 2: // '\002'
            field_73882_e.func_71373_a(null);
            field_73882_e.func_71381_h();
            break;

        case 1: // '\001'
            p_73875_1_.field_73742_g = false;
            try
            {
                Class class1 = Class.forName("java.awt.Desktop");
                Object obj = class1.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                class1.getMethod("browse", new Class[] {
                    java.net.URI.class
                }).invoke(obj, new Object[] {
                    new URI("http://www.minecraft.net/")
                });
            }
            catch(Throwable throwable)
            {
                throwable.printStackTrace();
            }
            break;
        }
    }

    public void func_73876_c()
    {
        super.func_73876_c();
    }

    public void func_73873_v_()
    {
        super.func_73873_v_();
        int i = field_73882_e.field_71446_o.func_78341_b("/gui/demo_bg.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        field_73882_e.field_71446_o.func_78342_b(i);
        int j = (field_73880_f - 248) / 2;
        int k = (field_73881_g - 166) / 2;
        func_73729_b(j, k, 0, 0, 248, 166);
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        int i = (field_73880_f - 248) / 2 + 10;
        field_73886_k.func_78276_b(StatCollector.func_74838_a("demo.help.title"), i, 44, 0x1f1f1f);
        GameSettings gamesettings = field_73882_e.field_71474_y;
        byte byte0 = 60;
        String s = StatCollector.func_74838_a("demo.help.movementShort");
        s = String.format(s, new Object[] {
            Keyboard.getKeyName(gamesettings.field_74351_w.field_74512_d), Keyboard.getKeyName(gamesettings.field_74370_x.field_74512_d), Keyboard.getKeyName(gamesettings.field_74368_y.field_74512_d), Keyboard.getKeyName(gamesettings.field_74366_z.field_74512_d)
        });
        field_73886_k.func_78276_b(s, i, byte0, 0x4f4f4f);
        s = StatCollector.func_74838_a("demo.help.movementMouse");
        field_73886_k.func_78276_b(s, i, byte0 + 12, 0x4f4f4f);
        s = StatCollector.func_74838_a("demo.help.jump");
        s = String.format(s, new Object[] {
            Keyboard.getKeyName(gamesettings.field_74314_A.field_74512_d)
        });
        field_73886_k.func_78276_b(s, i, byte0 + 24, 0x4f4f4f);
        s = StatCollector.func_74838_a("demo.help.inventory");
        s = String.format(s, new Object[] {
            Keyboard.getKeyName(gamesettings.field_74315_B.field_74512_d)
        });
        field_73886_k.func_78276_b(s, i, byte0 + 36, 0x4f4f4f);
        field_73886_k.func_78279_b(StatCollector.func_74838_a("demo.help.fullWrapped"), i, byte0 + 68, 218, 0x1f1f1f);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
