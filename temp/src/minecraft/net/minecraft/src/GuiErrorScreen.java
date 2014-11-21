// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GuiScreen

public class GuiErrorScreen extends GuiScreen
{

    private String field_74001_a;
    private String field_74000_b;

    public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        func_73733_a(0, 0, field_73880_f, field_73881_g, 0xff402020, 0xff501010);
        func_73732_a(field_73886_k, field_74001_a, field_73880_f / 2, 90, 0xffffff);
        func_73732_a(field_73886_k, field_74000_b, field_73880_f / 2, 110, 0xffffff);
        super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
    }

    protected void func_73869_a(char c, int i)
    {
    }
}
