// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GuiScreen, IProgressUpdate

public class GuiProgress extends GuiScreen
    implements IProgressUpdate
{

    private String field_74265_a;
    private String field_74263_b;
    private int field_74264_c;
    private boolean field_74262_d;

    public GuiProgress()
    {
        field_74265_a = "";
        field_74263_b = "";
        field_74264_c = 0;
    }

    public void func_73720_a(String p_73720_1_)
    {
        func_73721_b(p_73720_1_);
    }

    public void func_73721_b(String p_73721_1_)
    {
        field_74265_a = p_73721_1_;
        func_73719_c("Working...");
    }

    public void func_73719_c(String p_73719_1_)
    {
        field_74263_b = p_73719_1_;
        func_73718_a(0);
    }

    public void func_73718_a(int p_73718_1_)
    {
        field_74264_c = p_73718_1_;
    }

    public void func_73717_a()
    {
        field_74262_d = true;
    }

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        if(field_74262_d)
        {
            field_73882_e.func_71373_a(null);
            return;
        } else
        {
            func_73873_v_();
            func_73732_a(field_73886_k, field_74265_a, field_73880_f / 2, 70, 0xffffff);
            func_73732_a(field_73886_k, (new StringBuilder()).append(field_74263_b).append(" ").append(field_74264_c).append("%").toString(), field_73880_f / 2, 90, 0xffffff);
            super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
            return;
        }
    }
}
