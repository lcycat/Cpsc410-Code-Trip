// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelIronGolem, EntityIronGolem, ModelRenderer, 
//            OpenGlHelper, Block, RenderBlocks, EntityLiving, 
//            Entity

public class RenderIronGolem extends RenderLiving
{

    private ModelIronGolem field_77050_a;

    public RenderIronGolem()
    {
        super(new ModelIronGolem(), 0.5F);
        field_77050_a = (ModelIronGolem)field_77045_g;
    }

    public void func_77049_a(EntityIronGolem p_77049_1_, double p_77049_2_, double p_77049_4_, double p_77049_6_, 
            float p_77049_8_, float p_77049_9_)
    {
        super.func_77031_a(p_77049_1_, p_77049_2_, p_77049_4_, p_77049_6_, p_77049_8_, p_77049_9_);
    }

    protected void func_77048_a(EntityIronGolem p_77048_1_, float p_77048_2_, float p_77048_3_, float p_77048_4_)
    {
        super.func_77043_a(p_77048_1_, p_77048_2_, p_77048_3_, p_77048_4_);
        if((double)p_77048_1_.field_70721_aZ < 0.01D)
        {
            return;
        } else
        {
            float f = 13F;
            float f1 = (p_77048_1_.field_70754_ba - p_77048_1_.field_70721_aZ * (1.0F - p_77048_4_)) + 6F;
            float f2 = (Math.abs(f1 % f - f * 0.5F) - f * 0.25F) / (f * 0.25F);
            GL11.glRotatef(6.5F * f2, 0.0F, 0.0F, 1.0F);
            return;
        }
    }

    protected void func_77047_a(EntityIronGolem p_77047_1_, float p_77047_2_)
    {
        super.func_77029_c(p_77047_1_, p_77047_2_);
        if(p_77047_1_.func_70853_p() == 0)
        {
            return;
        } else
        {
            GL11.glEnable(32826);
            GL11.glPushMatrix();
            GL11.glRotatef(5F + (180F * field_77050_a.field_78177_c.field_78795_f) / 3.141593F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            float f = 0.8F;
            GL11.glScalef(f, -f, f);
            int i = p_77047_1_.func_70070_b(p_77047_2_);
            int j = i % 0x10000;
            int k = i / 0x10000;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            func_76985_a("/terrain.png");
            field_76988_d.func_78600_a(Block.field_72107_ae, 0, 1.0F);
            GL11.glPopMatrix();
            GL11.glDisable(32826);
            return;
        }
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        func_77047_a((EntityIronGolem)p_77029_1_, p_77029_2_);
    }

    protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        func_77048_a((EntityIronGolem)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77049_a((EntityIronGolem)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77049_a((EntityIronGolem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
