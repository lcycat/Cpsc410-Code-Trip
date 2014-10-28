// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, Packet0KeepAlive, NetClientHandler, StringTranslate

public class GuiDownloadTerrain extends GuiScreen
{

    private NetClientHandler field_74261_a;
    private int field_74260_b;

    public GuiDownloadTerrain(NetClientHandler p_i3100_1_)
    {
        field_74260_b = 0;
        field_74261_a = p_i3100_1_;
    }

    protected void func_73869_a(char c, int i)
    {
    }

    public void func_73866_w_()
    {
        field_73887_h.clear();
    }

    public void func_73876_c()
    {
        field_74260_b++;
        if(field_74260_b % 20 == 0)
        {
            field_74261_a.func_72552_c(new Packet0KeepAlive());
        }
        if(field_74261_a != null)
        {
            field_74261_a.func_72551_d();
        }
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73871_c(0);
        StringTranslate stringtranslate = StringTranslate.func_74808_a();
        func_73732_a(field_73886_k, stringtranslate.func_74805_b("multiplayer.downloadingTerrain"), field_73880_f / 2, field_73881_g / 2 - 50, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }
}
