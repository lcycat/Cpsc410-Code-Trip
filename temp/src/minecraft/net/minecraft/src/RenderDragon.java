// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelDragon, EntityDragon, MathHelper, 
//            ModelBase, EntityEnderCrystal, Tessellator, RenderHelper, 
//            OpenGlHelper, EntityLiving, Entity

public class RenderDragon extends RenderLiving
{

    public static EntityDragon field_77085_a;
    private static int field_77086_i = 0;
    protected ModelDragon field_77084_b;

    public RenderDragon()
    {
        super(new ModelDragon(0.0F), 0.5F);
        field_77084_b = (ModelDragon)field_77045_g;
        func_77042_a(field_77045_g);
    }

    protected void func_77083_a(EntityDragon p_77083_1_, float p_77083_2_, float p_77083_3_, float p_77083_4_)
    {
        float f = (float)p_77083_1_.func_70974_a(7, p_77083_4_)[0];
        float f1 = (float)(p_77083_1_.func_70974_a(5, p_77083_4_)[1] - p_77083_1_.func_70974_a(10, p_77083_4_)[1]);
        GL11.glRotatef(-f, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(f1 * 10F, 1.0F, 0.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.0F, 1.0F);
        if(p_77083_1_.field_70725_aQ > 0)
        {
            float f2 = ((((float)p_77083_1_.field_70725_aQ + p_77083_4_) - 1.0F) / 20F) * 1.6F;
            f2 = MathHelper.func_76129_c(f2);
            if(f2 > 1.0F)
            {
                f2 = 1.0F;
            }
            GL11.glRotatef(f2 * func_77037_a(p_77083_1_), 0.0F, 0.0F, 1.0F);
        }
    }

    protected void func_77081_a(EntityDragon p_77081_1_, float p_77081_2_, float p_77081_3_, float p_77081_4_, float p_77081_5_, float p_77081_6_, float p_77081_7_)
    {
        if(p_77081_1_.field_70995_bG > 0)
        {
            float f = (float)p_77081_1_.field_70995_bG / 200F;
            GL11.glDepthFunc(515);
            GL11.glEnable(3008);
            GL11.glAlphaFunc(516, f);
            func_76984_a(p_77081_1_.field_70120_cr, "/mob/enderdragon/shuffle.png");
            field_77045_g.func_78088_a(p_77081_1_, p_77081_2_, p_77081_3_, p_77081_4_, p_77081_5_, p_77081_6_, p_77081_7_);
            GL11.glAlphaFunc(516, 0.1F);
            GL11.glDepthFunc(514);
        }
        func_76984_a(p_77081_1_.field_70120_cr, p_77081_1_.func_70073_O());
        field_77045_g.func_78088_a(p_77081_1_, p_77081_2_, p_77081_3_, p_77081_4_, p_77081_5_, p_77081_6_, p_77081_7_);
        if(p_77081_1_.field_70737_aN > 0)
        {
            GL11.glDepthFunc(514);
            GL11.glDisable(3553);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
            field_77045_g.func_78088_a(p_77081_1_, p_77081_2_, p_77081_3_, p_77081_4_, p_77081_5_, p_77081_6_, p_77081_7_);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDepthFunc(515);
        }
    }

    public void func_77079_a(EntityDragon p_77079_1_, double p_77079_2_, double p_77079_4_, double p_77079_6_, 
            float p_77079_8_, float p_77079_9_)
    {
        field_77085_a = p_77079_1_;
        if(field_77086_i != 4)
        {
            field_77045_g = new ModelDragon(0.0F);
            field_77086_i = 4;
        }
        super.func_77031_a(p_77079_1_, p_77079_2_, p_77079_4_, p_77079_6_, p_77079_8_, p_77079_9_);
        if(p_77079_1_.field_70992_bH != null)
        {
            float f = (float)p_77079_1_.field_70992_bH.field_70261_a + p_77079_9_;
            float f1 = MathHelper.func_76126_a(f * 0.2F) / 2.0F + 0.5F;
            f1 = (f1 * f1 + f1) * 0.2F;
            float f2 = (float)(p_77079_1_.field_70992_bH.field_70165_t - p_77079_1_.field_70165_t - (p_77079_1_.field_70169_q - p_77079_1_.field_70165_t) * (double)(1.0F - p_77079_9_));
            float f3 = (float)(((double)f1 + p_77079_1_.field_70992_bH.field_70163_u) - 1.0D - p_77079_1_.field_70163_u - (p_77079_1_.field_70167_r - p_77079_1_.field_70163_u) * (double)(1.0F - p_77079_9_));
            float f4 = (float)(p_77079_1_.field_70992_bH.field_70161_v - p_77079_1_.field_70161_v - (p_77079_1_.field_70166_s - p_77079_1_.field_70161_v) * (double)(1.0F - p_77079_9_));
            float f5 = MathHelper.func_76129_c(f2 * f2 + f4 * f4);
            float f6 = MathHelper.func_76129_c(f2 * f2 + f3 * f3 + f4 * f4);
            GL11.glPushMatrix();
            GL11.glTranslatef((float)p_77079_2_, (float)p_77079_4_ + 2.0F, (float)p_77079_6_);
            GL11.glRotatef(((float)(-Math.atan2(f4, f2)) * 180F) / 3.141593F - 90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(((float)(-Math.atan2(f5, f3)) * 180F) / 3.141593F - 90F, 1.0F, 0.0F, 0.0F);
            Tessellator tessellator = Tessellator.field_78398_a;
            RenderHelper.func_74518_a();
            GL11.glDisable(2884);
            func_76985_a("/mob/enderdragon/beam.png");
            GL11.glShadeModel(7425);
            float f7 = 0.0F - ((float)p_77079_1_.field_70173_aa + p_77079_9_) * 0.01F;
            float f8 = MathHelper.func_76129_c(f2 * f2 + f3 * f3 + f4 * f4) / 32F - ((float)p_77079_1_.field_70173_aa + p_77079_9_) * 0.01F;
            tessellator.func_78371_b(5);
            int i = 8;
            for(int j = 0; j <= i; j++)
            {
                float f9 = MathHelper.func_76126_a(((float)(j % i) * 3.141593F * 2.0F) / (float)i) * 0.75F;
                float f10 = MathHelper.func_76134_b(((float)(j % i) * 3.141593F * 2.0F) / (float)i) * 0.75F;
                float f11 = ((float)(j % i) * 1.0F) / (float)i;
                tessellator.func_78378_d(0);
                tessellator.func_78374_a(f9 * 0.2F, f10 * 0.2F, 0.0D, f11, f8);
                tessellator.func_78378_d(0xffffff);
                tessellator.func_78374_a(f9, f10, f6, f11, f7);
            }

            tessellator.func_78381_a();
            GL11.glEnable(2884);
            GL11.glShadeModel(7424);
            RenderHelper.func_74519_b();
            GL11.glPopMatrix();
        }
    }

    protected void func_77080_a(EntityDragon p_77080_1_, float p_77080_2_)
    {
        super.func_77029_c(p_77080_1_, p_77080_2_);
        Tessellator tessellator = Tessellator.field_78398_a;
        if(p_77080_1_.field_70995_bG > 0)
        {
            RenderHelper.func_74518_a();
            float f = ((float)p_77080_1_.field_70995_bG + p_77080_2_) / 200F;
            float f1 = 0.0F;
            if(f > 0.8F)
            {
                f1 = (f - 0.8F) / 0.2F;
            }
            Random random = new Random(432L);
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            GL11.glDisable(3008);
            GL11.glEnable(2884);
            GL11.glDepthMask(false);
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, -1F, -2F);
            for(int i = 0; (float)i < ((f + f * f) / 2.0F) * 60F; i++)
            {
                GL11.glRotatef(random.nextFloat() * 360F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(random.nextFloat() * 360F + f * 90F, 0.0F, 0.0F, 1.0F);
                tessellator.func_78371_b(6);
                float f2 = random.nextFloat() * 20F + 5F + f1 * 10F;
                float f3 = random.nextFloat() * 2.0F + 1.0F + f1 * 2.0F;
                tessellator.func_78384_a(0xffffff, (int)(255F * (1.0F - f1)));
                tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
                tessellator.func_78384_a(0xff00ff, 0);
                tessellator.func_78377_a(-0.86599999999999999D * (double)f3, f2, -0.5F * f3);
                tessellator.func_78377_a(0.86599999999999999D * (double)f3, f2, -0.5F * f3);
                tessellator.func_78377_a(0.0D, f2, 1.0F * f3);
                tessellator.func_78377_a(-0.86599999999999999D * (double)f3, f2, -0.5F * f3);
                tessellator.func_78381_a();
            }

            GL11.glPopMatrix();
            GL11.glDepthMask(true);
            GL11.glDisable(2884);
            GL11.glDisable(3042);
            GL11.glShadeModel(7424);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            RenderHelper.func_74519_b();
        }
    }

    protected int func_77082_a(EntityDragon p_77082_1_, int p_77082_2_, float p_77082_3_)
    {
        if(p_77082_2_ == 1)
        {
            GL11.glDepthFunc(515);
        }
        if(p_77082_2_ != 0)
        {
            return -1;
        } else
        {
            func_76985_a("/mob/enderdragon/ender_eyes.png");
            float f = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(2896);
            GL11.glDepthFunc(514);
            int i = 61680;
            int j = i % 0x10000;
            int k = i / 0x10000;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(2896);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f);
            return 1;
        }
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77082_a((EntityDragon)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        func_77080_a((EntityDragon)p_77029_1_, p_77029_2_);
    }

    protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        func_77083_a((EntityDragon)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void func_77036_a(EntityLiving p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_)
    {
        func_77081_a((EntityDragon)p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77079_a((EntityDragon)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77079_a((EntityDragon)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

}
