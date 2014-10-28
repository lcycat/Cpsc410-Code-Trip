// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, RenderEngine

public class GuiButtonLanguage extends GuiButton
{

    public GuiButtonLanguage(int p_i3038_1_, int p_i3038_2_, int p_i3038_3_)
    {
        super(p_i3038_1_, p_i3038_2_, p_i3038_3_, 20, 20, "");
    }

    public void func_73737_a(Minecraft p_73737_1_, int p_73737_2_, int p_73737_3_)
    {
        if(!field_73748_h)
        {
            return;
        }
        GL11.glBindTexture(3553, p_73737_1_.field_71446_o.func_78341_b("/gui/gui.png"));
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        boolean flag = p_73737_2_ >= field_73746_c && p_73737_3_ >= field_73743_d && p_73737_2_ < field_73746_c + field_73747_a && p_73737_3_ < field_73743_d + field_73745_b;
        int i = 106;
        if(flag)
        {
            i += field_73745_b;
        }
        func_73729_b(field_73746_c, field_73743_d, 0, i, field_73747_a, field_73745_b);
    }
}
