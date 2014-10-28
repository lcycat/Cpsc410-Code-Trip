// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelBase, EntityLiving, OpenGlHelper, 
//            MathHelper, RenderManager, Tessellator, FontRenderer, 
//            Entity

public class RenderLiving extends Render
{

    protected ModelBase field_77045_g;
    protected ModelBase field_77046_h;

    public RenderLiving(ModelBase p_i3199_1_, float p_i3199_2_)
    {
        field_77045_g = p_i3199_1_;
        field_76989_e = p_i3199_2_;
    }

    public void func_77042_a(ModelBase p_77042_1_)
    {
        field_77046_h = p_77042_1_;
    }

    private float func_77034_a(float p_77034_1_, float p_77034_2_, float p_77034_3_)
    {
        float f;
        for(f = p_77034_2_ - p_77034_1_; f < -180F; f += 360F) { }
        for(; f >= 180F; f -= 360F) { }
        return p_77034_1_ + p_77034_3_ * f;
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        field_77045_g.field_78095_p = func_77040_d(p_77031_1_, p_77031_9_);
        if(field_77046_h != null)
        {
            field_77046_h.field_78095_p = field_77045_g.field_78095_p;
        }
        field_77045_g.field_78093_q = p_77031_1_.func_70115_ae();
        if(field_77046_h != null)
        {
            field_77046_h.field_78093_q = field_77045_g.field_78093_q;
        }
        field_77045_g.field_78091_s = p_77031_1_.func_70631_g_();
        if(field_77046_h != null)
        {
            field_77046_h.field_78091_s = field_77045_g.field_78091_s;
        }
        try
        {
            float f = func_77034_a(p_77031_1_.field_70760_ar, p_77031_1_.field_70761_aq, p_77031_9_);
            float f1 = func_77034_a(p_77031_1_.field_70758_at, p_77031_1_.field_70759_as, p_77031_9_);
            float f2 = p_77031_1_.field_70127_C + (p_77031_1_.field_70125_A - p_77031_1_.field_70127_C) * p_77031_9_;
            func_77039_a(p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_);
            float f3 = func_77044_a(p_77031_1_, p_77031_9_);
            func_77043_a(p_77031_1_, f3, f, p_77031_9_);
            float f4 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(-1F, -1F, 1.0F);
            func_77041_b(p_77031_1_, p_77031_9_);
            GL11.glTranslatef(0.0F, -24F * f4 - 0.0078125F, 0.0F);
            float f5 = p_77031_1_.field_70722_aY + (p_77031_1_.field_70721_aZ - p_77031_1_.field_70722_aY) * p_77031_9_;
            float f6 = p_77031_1_.field_70754_ba - p_77031_1_.field_70721_aZ * (1.0F - p_77031_9_);
            if(p_77031_1_.func_70631_g_())
            {
                f6 *= 3F;
            }
            if(f5 > 1.0F)
            {
                f5 = 1.0F;
            }
            GL11.glEnable(3008);
            field_77045_g.func_78086_a(p_77031_1_, f6, f5, p_77031_9_);
            func_77036_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
            for(int i = 0; i < 4; i++)
            {
                int j = func_77032_a(p_77031_1_, i, p_77031_9_);
                if(j <= 0)
                {
                    continue;
                }
                field_77046_h.func_78086_a(p_77031_1_, f6, f5, p_77031_9_);
                field_77046_h.func_78088_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
                if(j == 15)
                {
                    float f8 = (float)p_77031_1_.field_70173_aa + p_77031_9_;
                    func_76985_a("%blur%/misc/glint.png");
                    GL11.glEnable(3042);
                    float f10 = 0.5F;
                    GL11.glColor4f(f10, f10, f10, 1.0F);
                    GL11.glDepthFunc(514);
                    GL11.glDepthMask(false);
                    for(int i1 = 0; i1 < 2; i1++)
                    {
                        GL11.glDisable(2896);
                        float f13 = 0.76F;
                        GL11.glColor4f(0.5F * f13, 0.25F * f13, 0.8F * f13, 1.0F);
                        GL11.glBlendFunc(768, 1);
                        GL11.glMatrixMode(5890);
                        GL11.glLoadIdentity();
                        float f15 = f8 * (0.001F + (float)i1 * 0.003F) * 20F;
                        float f16 = 0.3333333F;
                        GL11.glScalef(f16, f16, f16);
                        GL11.glRotatef(30F - (float)i1 * 60F, 0.0F, 0.0F, 1.0F);
                        GL11.glTranslatef(0.0F, f15, 0.0F);
                        GL11.glMatrixMode(5888);
                        field_77046_h.func_78088_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
                    }

                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glMatrixMode(5890);
                    GL11.glDepthMask(true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode(5888);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glDepthFunc(515);
                }
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }

            func_77029_c(p_77031_1_, p_77031_9_);
            float f7 = p_77031_1_.func_70013_c(p_77031_9_);
            int k = func_77030_a(p_77031_1_, f7, p_77031_9_);
            OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
            GL11.glDisable(3553);
            OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
            if((k >> 24 & 0xff) > 0 || p_77031_1_.field_70737_aN > 0 || p_77031_1_.field_70725_aQ > 0)
            {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if(p_77031_1_.field_70737_aN > 0 || p_77031_1_.field_70725_aQ > 0)
                {
                    GL11.glColor4f(f7, 0.0F, 0.0F, 0.4F);
                    field_77045_g.func_78088_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
                    for(int l = 0; l < 4; l++)
                    {
                        if(func_77035_b(p_77031_1_, l, p_77031_9_) >= 0)
                        {
                            GL11.glColor4f(f7, 0.0F, 0.0F, 0.4F);
                            field_77046_h.func_78088_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
                        }
                    }

                }
                if((k >> 24 & 0xff) > 0)
                {
                    float f9 = (float)(k >> 16 & 0xff) / 255F;
                    float f11 = (float)(k >> 8 & 0xff) / 255F;
                    float f12 = (float)(k & 0xff) / 255F;
                    float f14 = (float)(k >> 24 & 0xff) / 255F;
                    GL11.glColor4f(f9, f11, f12, f14);
                    field_77045_g.func_78088_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
                    for(int j1 = 0; j1 < 4; j1++)
                    {
                        if(func_77035_b(p_77031_1_, j1, p_77031_9_) >= 0)
                        {
                            GL11.glColor4f(f9, f11, f12, f14);
                            field_77046_h.func_78088_a(p_77031_1_, f6, f5, f3, f1 - f, f2, f4);
                        }
                    }

                }
                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }
            GL11.glDisable(32826);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77476_b);
        GL11.glEnable(3553);
        OpenGlHelper.func_77473_a(OpenGlHelper.field_77478_a);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        func_77033_b(p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_);
    }

    protected void func_77036_a(EntityLiving p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_)
    {
        func_76984_a(p_77036_1_.field_70120_cr, p_77036_1_.func_70073_O());
        field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
    }

    protected void func_77039_a(EntityLiving p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_)
    {
        GL11.glTranslatef((float)p_77039_2_, (float)p_77039_4_, (float)p_77039_6_);
    }

    protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        GL11.glRotatef(180F - p_77043_3_, 0.0F, 1.0F, 0.0F);
        if(p_77043_1_.field_70725_aQ > 0)
        {
            float f = ((((float)p_77043_1_.field_70725_aQ + p_77043_4_) - 1.0F) / 20F) * 1.6F;
            f = MathHelper.func_76129_c(f);
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            GL11.glRotatef(f * func_77037_a(p_77043_1_), 0.0F, 0.0F, 1.0F);
        }
    }

    protected float func_77040_d(EntityLiving p_77040_1_, float p_77040_2_)
    {
        return p_77040_1_.func_70678_g(p_77040_2_);
    }

    protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_)
    {
        return (float)p_77044_1_.field_70173_aa + p_77044_2_;
    }

    protected void func_77029_c(EntityLiving entityliving, float f)
    {
    }

    protected int func_77035_b(EntityLiving p_77035_1_, int p_77035_2_, float p_77035_3_)
    {
        return func_77032_a(p_77035_1_, p_77035_2_, p_77035_3_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return -1;
    }

    protected float func_77037_a(EntityLiving p_77037_1_)
    {
        return 90F;
    }

    protected int func_77030_a(EntityLiving p_77030_1_, float p_77030_2_, float p_77030_3_)
    {
        return 0;
    }

    protected void func_77041_b(EntityLiving entityliving, float f)
    {
    }

    protected void func_77033_b(EntityLiving p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_)
    {
        if(!Minecraft.func_71368_v());
    }

    protected void func_77038_a(EntityLiving p_77038_1_, String p_77038_2_, double p_77038_3_, double p_77038_5_, double p_77038_7_, int p_77038_9_)
    {
        double d = p_77038_1_.func_70068_e(field_76990_c.field_78734_h);
        if(d > (double)(p_77038_9_ * p_77038_9_))
        {
            return;
        }
        FontRenderer fontrenderer = func_76983_a();
        float f = 1.6F;
        float f1 = 0.01666667F * f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77038_3_ + 0.0F, (float)p_77038_5_ + 2.3F, (float)p_77038_7_);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-f1, -f1, f1);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Tessellator tessellator = Tessellator.field_78398_a;
        byte byte0 = 0;
        if(p_77038_2_.equals("deadmau5"))
        {
            byte0 = -10;
        }
        GL11.glDisable(3553);
        tessellator.func_78382_b();
        int i = fontrenderer.func_78256_a(p_77038_2_) / 2;
        tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
        tessellator.func_78377_a(-i - 1, -1 + byte0, 0.0D);
        tessellator.func_78377_a(-i - 1, 8 + byte0, 0.0D);
        tessellator.func_78377_a(i + 1, 8 + byte0, 0.0D);
        tessellator.func_78377_a(i + 1, -1 + byte0, 0.0D);
        tessellator.func_78381_a();
        GL11.glEnable(3553);
        fontrenderer.func_78276_b(p_77038_2_, -fontrenderer.func_78256_a(p_77038_2_) / 2, byte0, 0x20ffffff);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        fontrenderer.func_78276_b(p_77038_2_, -fontrenderer.func_78256_a(p_77038_2_) / 2, byte0, -1);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77031_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
