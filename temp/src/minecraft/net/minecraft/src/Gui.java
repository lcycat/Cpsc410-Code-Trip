// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Tessellator, FontRenderer

public class Gui
{

    protected float field_73735_i;

    public Gui()
    {
        field_73735_i = 0.0F;
    }

    protected void func_73730_a(int p_73730_1_, int p_73730_2_, int p_73730_3_, int p_73730_4_)
    {
        if(p_73730_2_ < p_73730_1_)
        {
            int i = p_73730_1_;
            p_73730_1_ = p_73730_2_;
            p_73730_2_ = i;
        }
        func_73734_a(p_73730_1_, p_73730_3_, p_73730_2_ + 1, p_73730_3_ + 1, p_73730_4_);
    }

    protected void func_73728_b(int p_73728_1_, int p_73728_2_, int p_73728_3_, int p_73728_4_)
    {
        if(p_73728_3_ < p_73728_2_)
        {
            int i = p_73728_2_;
            p_73728_2_ = p_73728_3_;
            p_73728_3_ = i;
        }
        func_73734_a(p_73728_1_, p_73728_2_ + 1, p_73728_1_ + 1, p_73728_3_, p_73728_4_);
    }

    public static void func_73734_a(int p_73734_0_, int p_73734_1_, int p_73734_2_, int p_73734_3_, int p_73734_4_)
    {
        if(p_73734_0_ < p_73734_2_)
        {
            int i = p_73734_0_;
            p_73734_0_ = p_73734_2_;
            p_73734_2_ = i;
        }
        if(p_73734_1_ < p_73734_3_)
        {
            int j = p_73734_1_;
            p_73734_1_ = p_73734_3_;
            p_73734_3_ = j;
        }
        float f = (float)(p_73734_4_ >> 24 & 0xff) / 255F;
        float f1 = (float)(p_73734_4_ >> 16 & 0xff) / 255F;
        float f2 = (float)(p_73734_4_ >> 8 & 0xff) / 255F;
        float f3 = (float)(p_73734_4_ & 0xff) / 255F;
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(f1, f2, f3, f);
        tessellator.func_78382_b();
        tessellator.func_78377_a(p_73734_0_, p_73734_3_, 0.0D);
        tessellator.func_78377_a(p_73734_2_, p_73734_3_, 0.0D);
        tessellator.func_78377_a(p_73734_2_, p_73734_1_, 0.0D);
        tessellator.func_78377_a(p_73734_0_, p_73734_1_, 0.0D);
        tessellator.func_78381_a();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }

    protected void func_73733_a(int p_73733_1_, int p_73733_2_, int p_73733_3_, int p_73733_4_, int p_73733_5_, int p_73733_6_)
    {
        float f = (float)(p_73733_5_ >> 24 & 0xff) / 255F;
        float f1 = (float)(p_73733_5_ >> 16 & 0xff) / 255F;
        float f2 = (float)(p_73733_5_ >> 8 & 0xff) / 255F;
        float f3 = (float)(p_73733_5_ & 0xff) / 255F;
        float f4 = (float)(p_73733_6_ >> 24 & 0xff) / 255F;
        float f5 = (float)(p_73733_6_ >> 16 & 0xff) / 255F;
        float f6 = (float)(p_73733_6_ >> 8 & 0xff) / 255F;
        float f7 = (float)(p_73733_6_ & 0xff) / 255F;
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        GL11.glShadeModel(7425);
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78369_a(f1, f2, f3, f);
        tessellator.func_78377_a(p_73733_3_, p_73733_2_, field_73735_i);
        tessellator.func_78377_a(p_73733_1_, p_73733_2_, field_73735_i);
        tessellator.func_78369_a(f5, f6, f7, f4);
        tessellator.func_78377_a(p_73733_1_, p_73733_4_, field_73735_i);
        tessellator.func_78377_a(p_73733_3_, p_73733_4_, field_73735_i);
        tessellator.func_78381_a();
        GL11.glShadeModel(7424);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
    }

    public void func_73732_a(FontRenderer p_73732_1_, String p_73732_2_, int p_73732_3_, int p_73732_4_, int p_73732_5_)
    {
        p_73732_1_.func_78261_a(p_73732_2_, p_73732_3_ - p_73732_1_.func_78256_a(p_73732_2_) / 2, p_73732_4_, p_73732_5_);
    }

    public void func_73731_b(FontRenderer p_73731_1_, String p_73731_2_, int p_73731_3_, int p_73731_4_, int p_73731_5_)
    {
        p_73731_1_.func_78261_a(p_73731_2_, p_73731_3_, p_73731_4_, p_73731_5_);
    }

    public void func_73729_b(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(p_73729_1_ + 0, p_73729_2_ + p_73729_6_, field_73735_i, (float)(p_73729_3_ + 0) * f, (float)(p_73729_4_ + p_73729_6_) * f1);
        tessellator.func_78374_a(p_73729_1_ + p_73729_5_, p_73729_2_ + p_73729_6_, field_73735_i, (float)(p_73729_3_ + p_73729_5_) * f, (float)(p_73729_4_ + p_73729_6_) * f1);
        tessellator.func_78374_a(p_73729_1_ + p_73729_5_, p_73729_2_ + 0, field_73735_i, (float)(p_73729_3_ + p_73729_5_) * f, (float)(p_73729_4_ + 0) * f1);
        tessellator.func_78374_a(p_73729_1_ + 0, p_73729_2_ + 0, field_73735_i, (float)(p_73729_3_ + 0) * f, (float)(p_73729_4_ + 0) * f1);
        tessellator.func_78381_a();
    }
}
