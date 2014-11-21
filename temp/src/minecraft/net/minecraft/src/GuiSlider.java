// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            GuiButton, GameSettings, EnumOptions

public class GuiSlider extends GuiButton
{

    public float field_73751_j;
    public boolean field_73752_k;
    private EnumOptions field_73750_l;

    public GuiSlider(int p_i3039_1_, int p_i3039_2_, int p_i3039_3_, EnumOptions p_i3039_4_, String p_i3039_5_, float p_i3039_6_)
    {
        super(p_i3039_1_, p_i3039_2_, p_i3039_3_, 150, 20, p_i3039_5_);
        field_73751_j = 1.0F;
        field_73752_k = false;
        field_73750_l = null;
        field_73750_l = p_i3039_4_;
        field_73751_j = p_i3039_6_;
    }

    protected int func_73738_a(boolean p_73738_1_)
    {
        return 0;
    }

    protected void func_73739_b(Minecraft p_73739_1_, int p_73739_2_, int p_73739_3_)
    {
        if(!field_73748_h)
        {
            return;
        }
        if(field_73752_k)
        {
            field_73751_j = (float)(p_73739_2_ - (field_73746_c + 4)) / (float)(field_73747_a - 8);
            if(field_73751_j < 0.0F)
            {
                field_73751_j = 0.0F;
            }
            if(field_73751_j > 1.0F)
            {
                field_73751_j = 1.0F;
            }
            p_73739_1_.field_71474_y.func_74304_a(field_73750_l, field_73751_j);
            field_73744_e = p_73739_1_.field_71474_y.func_74297_c(field_73750_l);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        func_73729_b(field_73746_c + (int)(field_73751_j * (float)(field_73747_a - 8)), field_73743_d, 0, 66, 4, 20);
        func_73729_b(field_73746_c + (int)(field_73751_j * (float)(field_73747_a - 8)) + 4, field_73743_d, 196, 66, 4, 20);
    }

    public boolean func_73736_c(Minecraft p_73736_1_, int p_73736_2_, int p_73736_3_)
    {
        if(super.func_73736_c(p_73736_1_, p_73736_2_, p_73736_3_))
        {
            field_73751_j = (float)(p_73736_2_ - (field_73746_c + 4)) / (float)(field_73747_a - 8);
            if(field_73751_j < 0.0F)
            {
                field_73751_j = 0.0F;
            }
            if(field_73751_j > 1.0F)
            {
                field_73751_j = 1.0F;
            }
            p_73736_1_.field_71474_y.func_74304_a(field_73750_l, field_73751_j);
            field_73744_e = p_73736_1_.field_71474_y.func_74297_c(field_73750_l);
            field_73752_k = true;
            return true;
        } else
        {
            return false;
        }
    }

    public void func_73740_a(int p_73740_1_, int p_73740_2_)
    {
        field_73752_k = false;
    }
}
