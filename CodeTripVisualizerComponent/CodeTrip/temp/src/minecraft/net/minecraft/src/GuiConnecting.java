// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, ServerData, ServerAddress, ThreadConnectToServer, 
//            NetClientHandler, StringTranslate, GuiButton, GuiMainMenu

public class GuiConnecting extends GuiScreen
{

    private NetClientHandler field_74259_a;
    private boolean field_74258_b;

    public GuiConnecting(Minecraft p_i3105_1_, ServerData p_i3105_2_)
    {
        field_74258_b = false;
        field_73882_e = p_i3105_1_;
        ServerAddress serveraddress = ServerAddress.func_78860_a(p_i3105_2_.field_78845_b);
        p_i3105_1_.func_71403_a(null);
        p_i3105_1_.func_71351_a(p_i3105_2_);
        func_74255_a(serveraddress.func_78861_a(), serveraddress.func_78864_b());
    }

    public GuiConnecting(Minecraft p_i3106_1_, String p_i3106_2_, int p_i3106_3_)
    {
        field_74258_b = false;
        field_73882_e = p_i3106_1_;
        p_i3106_1_.func_71403_a(null);
        func_74255_a(p_i3106_2_, p_i3106_3_);
    }

    private void func_74255_a(String p_74255_1_, int p_74255_2_)
    {
        System.out.println((new StringBuilder()).append("Connecting to ").append(p_74255_1_).append(", ").append(p_74255_2_).toString());
        (new ThreadConnectToServer(this, p_74255_1_, p_74255_2_)).start();
    }

    public void func_73876_c()
    {
        if(field_74259_a != null)
        {
            field_74259_a.func_72551_d();
        }
    }

    protected void func_73869_a(char c, int i)
    {
    }

    public void func_73866_w_()
    {
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.clear();
        field_73887_h.add(new GuiButton(0, field_73880_f / 2 - 100, field_73881_g / 4 + 120 + 12, stringtranslate.func_74805_b("gui.cancel")));
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 0)
        {
            field_74258_b = true;
            if(field_74259_a != null)
            {
                field_74259_a.func_72553_e();
            }
            field_73882_e.func_71373_a(new GuiMainMenu());
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73873_v_();
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        if(field_74259_a == null)
        {
            func_73732_a(field_73886_k, stringtranslate.func_74805_b("connect.connecting"), field_73880_f / 2, field_73881_g / 2 - 50, 0xffffff);
            func_73732_a(field_73886_k, "", field_73880_f / 2, field_73881_g / 2 - 10, 0xffffff);
        } else
        {
            func_73732_a(field_73886_k, stringtranslate.func_74805_b("connect.authorizing"), field_73880_f / 2, field_73881_g / 2 - 50, 0xffffff);
            func_73732_a(field_73886_k, field_74259_a.field_72560_a, field_73880_f / 2, field_73881_g / 2 - 10, 0xffffff);
        }
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    static NetClientHandler func_74252_a(GuiConnecting p_74252_0_, NetClientHandler p_74252_1_)
    {
        return p_74252_0_.field_74259_a = p_74252_1_;
    }

    static Minecraft func_74256_a(GuiConnecting p_74256_0_)
    {
        return p_74256_0_.field_73882_e;
    }

    static boolean func_74257_b(GuiConnecting p_74257_0_)
    {
        return p_74257_0_.field_74258_b;
    }

    static Minecraft func_74254_c(GuiConnecting p_74254_0_)
    {
        return p_74254_0_.field_73882_e;
    }

    static NetClientHandler func_74253_d(GuiConnecting p_74253_0_)
    {
        return p_74253_0_.field_74259_a;
    }

    static Minecraft func_74249_e(GuiConnecting p_74249_0_)
    {
        return p_74249_0_.field_73882_e;
    }

    static Minecraft func_74250_f(GuiConnecting p_74250_0_)
    {
        return p_74250_0_.field_73882_e;
    }

    static Minecraft func_74251_g(GuiConnecting p_74251_0_)
    {
        return p_74251_0_.field_73882_e;
    }
}
