// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, RenderEngine

class GuiButtonMerchant extends GuiButton
{

    private final boolean field_73749_j;

    public GuiButtonMerchant(int p_i3086_1_, int p_i3086_2_, int p_i3086_3_, boolean p_i3086_4_)
    {
        super(p_i3086_1_, p_i3086_2_, p_i3086_3_, 12, 19, "");
        field_73749_j = p_i3086_4_;
    }

    public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_)
    {
        if(!field_73748_h)
        {
            return;
        }
        GL11.glBindTexture(3553, p_73737_1_.field_71446_o.func_78341_b("/gui/trading.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = p_73737_2_ >= field_73746_c && p_73737_3_ >= field_73743_d && p_73737_2_ < field_73746_c + field_73747_a && p_73737_3_ < field_73743_d + field_73745_b;
        int i = 0;
        int j = 176;
        if(!field_73742_g)
        {
            j += field_73747_a * 2;
        } else
        if(flag)
        {
            j += field_73747_a;
        }
        if(!field_73749_j)
        {
            i += field_73745_b;
        }
        func_73729_b(field_73746_c, field_73743_d, j, i, field_73747_a, field_73745_b);
    }
}
