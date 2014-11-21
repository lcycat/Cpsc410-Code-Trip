// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Gui, RenderEngine

public class GuiButton extends Gui
{

    protected int field_73747_a;
    protected int field_73745_b;
    public int field_73746_c;
    public int field_73743_d;
    public String field_73744_e;
    public int field_73741_f;
    public boolean field_73742_g;
    public boolean field_73748_h;

    public GuiButton(int p_i3055_1_, int p_i3055_2_, int p_i3055_3_, String p_i3055_4_)
    {
        this(p_i3055_1_, p_i3055_2_, p_i3055_3_, 200, 20, p_i3055_4_);
    }

    public GuiButton(int p_i3056_1_, int p_i3056_2_, int p_i3056_3_, int p_i3056_4_, int p_i3056_5_, String p_i3056_6_)
    {
        field_73747_a = 200;
        field_73745_b = 20;
        field_73742_g = true;
        field_73748_h = true;
        field_73741_f = p_i3056_1_;
        field_73746_c = p_i3056_2_;
        field_73743_d = p_i3056_3_;
        field_73747_a = p_i3056_4_;
        field_73745_b = p_i3056_5_;
        field_73744_e = p_i3056_6_;
    }

    protected int func_73738_a(boolean p_73738_1_)
    {
        byte byte0 = 1;
        if(!field_73742_g)
        {
            byte0 = 0;
        } else
        if(p_73738_1_)
        {
            byte0 = 2;
        }
        return byte0;
    }

    public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_)
    {
        if(!field_73748_h)
        {
            return;
        }
        FontRenderer fontrenderer = p_73737_1_.field_71466_p;
        GL11.glBindTexture(3553, p_73737_1_.field_71446_o.func_78341_b("/gui/gui.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = p_73737_2_ >= field_73746_c && p_73737_3_ >= field_73743_d && p_73737_2_ < field_73746_c + field_73747_a && p_73737_3_ < field_73743_d + field_73745_b;
        int i = func_73738_a(flag);
        func_73729_b(field_73746_c, field_73743_d, 0, 46 + i * 20, field_73747_a / 2, field_73745_b);
        func_73729_b(field_73746_c + field_73747_a / 2, field_73743_d, 200 - field_73747_a / 2, 46 + i * 20, field_73747_a / 2, field_73745_b);
        func_73739_b(p_73737_1_, p_73737_2_, p_73737_3_);
        int j = 0xe0e0e0;
        if(!field_73742_g)
        {
            j = 0xffa0a0a0;
        } else
        if(flag)
        {
            j = 0xffffa0;
        }
        func_73732_a(fontrenderer, field_73744_e, field_73746_c + field_73747_a / 2, field_73743_d + (field_73745_b - 8) / 2, j);
    }

    protected void func_73739_b(Minecraft minecraft, int i, int j)
    {
    }

    public void func_73740_a(int i, int j)
    {
    }

    public boolean func_73736_c(Minecraft p_73736_1_, int p_73736_2_, int p_73736_3_)
    {
        return field_73742_g && field_73748_h && p_73736_2_ >= field_73746_c && p_73736_3_ >= field_73743_d && p_73736_2_ < field_73746_c + field_73747_a && p_73736_3_ < field_73743_d + field_73745_b;
    }
}
