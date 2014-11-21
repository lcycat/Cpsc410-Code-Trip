// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, GuiButton, StatCollector, IntegratedServer, 
//            GuiOptions, StatList, StatFileWriter, WorldClient, 
//            GuiMainMenu, GuiAchievements, GuiStats, GuiShareToLan

public class GuiIngameMenu extends GuiScreen
{

    private int field_74050_a;
    private int field_74049_b;

    public GuiIngameMenu()
    {
        field_74050_a = 0;
        field_74049_b = 0;
    }

    public void func_73866_w_()
    {
        field_74050_a = 0;
        field_73887_h.clear();
        byte byte0 = -16;
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g / 4 + 120 + byte0, StatCollector.func_74838_a("menu.returnToMenu")));
        if(!field_73882_e.func_71387_A())
        {
            ((GuiButton)field_73887_h.get(0)).field_73744_e = StatCollector.func_74838_a("menu.disconnect");
        }
        field_73887_h.add(new GuiButton(4, field_73880_f / 2 - 100, field_73881_g / 4 + 24 + byte0, StatCollector.func_74838_a("menu.returnToGame")));
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 96 + byte0, 98, 20, StatCollector.func_74838_a("menu.options")));
        GuiButton guibutton;
        field_73887_h.add(guibutton = new GuiButton(7, field_73880_f / 2 + 2, field_73881_g / 4 + 96 + byte0, 98, 20, StatCollector.func_74838_a("menu.shareToLan")));
        field_73887_h.add(new GuiButton(5, field_73880_f / 2 - 100, field_73881_g / 4 + 48 + byte0, 98, 20, StatCollector.func_74838_a("gui.achievements")));
        field_73887_h.add(new GuiButton(6, field_73880_f / 2 + 2, field_73881_g / 4 + 48 + byte0, 98, 20, StatCollector.func_74838_a("gui.stats")));
        guibutton.field_73742_g = field_73882_e.func_71356_B() && !field_73882_e.func_71401_C().func_71344_c();
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        switch(p_73875_1_.field_73741_f)
        {
        case 0: // '\0'
            field_73882_e.func_71373_a(new GuiOptions(this, field_73882_e.field_71474_y));
            break;

        case 1: // '\001'
            p_73875_1_.field_73742_g = false;
            field_73882_e.field_71413_E.func_77450_a(StatList.field_75947_j, 1);
            field_73882_e.field_71441_e.func_72882_A();
            field_73882_e.func_71403_a(null);
            field_73882_e.func_71373_a(new GuiMainMenu());
            break;

        case 4: // '\004'
            field_73882_e.func_71373_a(null);
            field_73882_e.func_71381_h();
            break;

        case 5: // '\005'
            field_73882_e.func_71373_a(new GuiAchievements(field_73882_e.field_71413_E));
            break;

        case 6: // '\006'
            field_73882_e.func_71373_a(new GuiStats(this, field_73882_e.field_71413_E));
            break;

        case 7: // '\007'
            field_73882_e.func_71373_a(new GuiShareToLan(this));
            break;
        }
    }

    public void func_73876_c()
    {
        super.func_73876_c();
        field_74049_b++;
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, "Game menu", field_73880_f / 2, 40, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
