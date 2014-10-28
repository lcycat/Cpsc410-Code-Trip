// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, RenderEngine

class GuiButtonNextPage extends GuiButton
{

    private final boolean field_73755_j;

    public GuiButtonNextPage(int p_i3087_1_, int p_i3087_2_, int p_i3087_3_, boolean p_i3087_4_)
    {
        super(p_i3087_1_, p_i3087_2_, p_i3087_3_, 23, 13, "");
        field_73755_j = p_i3087_4_;
    }

    public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_)
    {
        if(!field_73748_h)
        {
            return;
        }
        boolean flag = p_73737_2_ >= field_73746_c && p_73737_3_ >= field_73743_d && p_73737_2_ < field_73746_c + field_73747_a && p_73737_3_ < field_73743_d + field_73745_b;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        p_73737_1_.field_71446_o.func_78342_b(p_73737_1_.field_71446_o.func_78341_b("/gui/book.png"));
        int i = 0;
        int j = 192;
        if(flag)
        {
            i += 23;
        }
        if(!field_73755_j)
        {
            j += 13;
        }
        func_73729_b(field_73746_c, field_73743_d, i, j, 23, 13);
    }
}
