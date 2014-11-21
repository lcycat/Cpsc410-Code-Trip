// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, StringTranslate, GuiSmallButton, GuiButton, 
//            GuiMainMenu

public class GuiMemoryErrorScreen extends GuiScreen
{

    public GuiMemoryErrorScreen()
    {
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.clear();
        field_73887_h.add(new GuiSmallButton(0, field_73880_f / 2 - 155, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("gui.toMenu")));
        field_73887_h.add(new GuiSmallButton(1, (field_73880_f / 2 - 155) + 160, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("menu.quit")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 0)
        {
            field_73882_e.func_71373_a(new GuiMainMenu());
        } else
        if(p_73875_1_.field_73741_f == 1)
        {
            field_73882_e.func_71400_g();
        }
    }

    protected void func_73869_a(char c, int i)
    {
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        func_73732_a(field_73886_k, "Out of memory!", field_73880_f / 2, (field_73881_g / 4 - 60) + 20, 0xffffff);
        func_73731_b(field_73886_k, "Minecraft has run out of memory.", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 0, 0xa0a0a0);
        func_73731_b(field_73886_k, "This could be caused by a bug in the game or by the", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 18, 0xa0a0a0);
        func_73731_b(field_73886_k, "Java Virtual Machine not being allocated enough", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 27, 0xa0a0a0);
        func_73731_b(field_73886_k, "memory. If you are playing in a web browser, try", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 36, 0xa0a0a0);
        func_73731_b(field_73886_k, "downloading the game and playing it offline.", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 45, 0xa0a0a0);
        func_73731_b(field_73886_k, "To prevent level corruption, the current game has quit.", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 63, 0xa0a0a0);
        func_73731_b(field_73886_k, "We've tried to free up enough memory to let you go back to", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 81, 0xa0a0a0);
        func_73731_b(field_73886_k, "the main menu and back to playing, but this may not have worked.", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 90, 0xa0a0a0);
        func_73731_b(field_73886_k, "Please restart the game if you see this message again.", field_73880_f / 2 - 140, (field_73881_g / 4 - 60) + 60 + 99, 0xa0a0a0);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
