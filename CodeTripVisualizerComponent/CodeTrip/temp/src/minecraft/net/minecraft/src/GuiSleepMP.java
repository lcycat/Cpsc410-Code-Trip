// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiChat, StringTranslate, GuiButton, GuiTextField, 
//            EntityClientPlayerMP, GuiIngame, GuiNewChat, Packet19EntityAction, 
//            NetClientHandler

public class GuiSleepMP extends GuiChat
{

    public GuiSleepMP()
    {
    }

    public void func_73866_w_()
    {
        super.func_73866_w_();
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        field_73887_h.add(new GuiButton(1, field_73880_f / 2 - 100, field_73881_g - 40, stringtranslate.func_74805_b("multiplayer.stopSleeping")));
    }

    protected void func_73869_a(char p_73869_1_, int p_73869_2_)
    {
        if(p_73869_2_ == 1)
        {
            func_73906_g();
        } else
        if(p_73869_2_ == 28)
        {
            String s = field_73901_a.func_73781_b().trim();
            if(s.length() > 0)
            {
                field_73882_e.field_71439_g.func_71165_d(s);
            }
            field_73901_a.func_73782_a("");
            field_73882_e.field_71456_v.func_73827_b().func_73764_c();
        } else
        {
            super.func_73869_a(p_73869_1_, p_73869_2_);
        }
    }

    protected void func_73875_a(GuiButton p_73875_1_)
    {
        if(p_73875_1_.field_73741_f == 1)
        {
            func_73906_g();
        } else
        {
            super.func_73875_a(p_73875_1_);
        }
    }

    private void func_73906_g()
    {
        NetClientHandler netclienthandler = field_73882_e.field_71439_g.field_71174_a;
        netclienthandler.func_72552_c(new Packet19EntityAction(field_73882_e.field_71439_g, 3));
    }
}
