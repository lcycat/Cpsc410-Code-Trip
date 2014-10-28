// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelEnderman, EntityEnderman, OpenGlHelper, 
//            Block, RenderBlocks, EntityLiving, Entity

public class RenderEnderman extends RenderLiving
{

    private ModelEnderman field_77078_a;
    private Random field_77077_b;

    public RenderEnderman()
    {
        super(new ModelEnderman(), 0.5F);
        field_77077_b = new Random();
        field_77078_a = (ModelEnderman)super.field_77045_g;
        func_77042_a(field_77078_a);
    }

    public void func_77075_a(EntityEnderman p_77075_1_, double p_77075_2_, double p_77075_4_, double p_77075_6_, 
            float p_77075_8_, float p_77075_9_)
    {
        field_77078_a.field_78126_a = p_77075_1_.func_70822_p() > 0;
        field_77078_a.field_78125_b = p_77075_1_.func_70823_r();
        if(p_77075_1_.func_70823_r())
        {
            double d = 0.02D;
            p_77075_2_ += field_77077_b.nextGaussian() * d;
            p_77075_6_ += field_77077_b.nextGaussian() * d;
        }
        super.func_77031_a(p_77075_1_, p_77075_2_, p_77075_4_, p_77075_6_, p_77075_8_, p_77075_9_);
    }

    protected void func_77076_a(EntityEnderman p_77076_1_, float p_77076_2_)
    {
        super.func_77029_c(p_77076_1_, p_77076_2_);
        if(p_77076_1_.func_70822_p() > 0)
        {
            GL11.glEnable(32826);
            GL11.glPushMatrix();
            float f = 0.5F;
            GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
            f *= 1.0F;
            GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(f, -f, f);
            int i = p_77076_1_.func_70070_b(p_77076_2_);
            int j = i % 0x10000;
            int k = i / 0x10000;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            func_76985_a("/terrain.png");
            field_76988_d.func_78600_a(Block.field_71973_m[p_77076_1_.func_70822_p()], p_77076_1_.func_70824_q(), 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(32826);
        }
    }

    protected int func_77074_a(EntityEnderman p_77074_1_, int p_77074_2_, float p_77074_3_)
    {
        if(p_77074_2_ != 0)
        {
            return -1;
        } else
        {
            func_76985_a("/mob/enderman_eyes.png");
            float f = 1.0F;
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glDisable(2896);
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
        return func_77074_a((EntityEnderman)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        func_77076_a((EntityEnderman)p_77029_1_, p_77029_2_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77075_a((EntityEnderman)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77075_a((EntityEnderman)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
