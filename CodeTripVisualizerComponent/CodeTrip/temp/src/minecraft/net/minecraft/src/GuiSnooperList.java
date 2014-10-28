// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            GuiSlot, GuiSnooper, FontRenderer, Tessellator

class GuiSnooperList extends GuiSlot
{

    final GuiSnooper field_77255_a; /* synthetic field */

    public GuiSnooperList(GuiSnooper p_i3068_1_)
    {
        field_77255_a = p_i3068_1_;
        super(p_i3068_1_.field_73882_e, p_i3068_1_.field_73880_f, p_i3068_1_.field_73881_g, 80, p_i3068_1_.field_73881_g - 40, p_i3068_1_.field_73886_k.field_78288_b + 1);
    }

    protected int func_77217_a()
    {
        return GuiSnooper.func_74095_a(field_77255_a).size();
    }

    protected void func_77213_a(int i, boolean flag)
    {
    }

    protected boolean func_77218_a(int p_77218_1_)
    {
        return false;
    }

    protected void func_77221_c()
    {
    }

    protected void func_77214_a(int p_77214_1_, int p_77214_2_, int p_77214_3_, int p_77214_4_, Tessellator p_77214_5_)
    {
        field_77255_a.field_73886_k.func_78276_b((String)GuiSnooper.func_74095_a(field_77255_a).get(p_77214_1_), 10, p_77214_3_, 0xffffff);
        field_77255_a.field_73886_k.func_78276_b((String)GuiSnooper.func_74094_b(field_77255_a).get(p_77214_1_), 220, p_77214_3_, 0xffffff);
    }

    protected int func_77225_g()
    {
        return field_77255_a.field_73880_f - 10;
    }
}
