// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelVillager, EntityVillager, EntityLiving, 
//            Entity

public class RenderVillager extends RenderLiving
{

    protected ModelVillager field_77056_a;

    public RenderVillager()
    {
        super(new ModelVillager(0.0F), 0.5F);
        field_77056_a = (ModelVillager)field_77045_g;
    }

    protected int func_77053_a(EntityVillager p_77053_1_, int p_77053_2_, float p_77053_3_)
    {
        return -1;
    }

    public void func_77054_a(EntityVillager p_77054_1_, double p_77054_2_, double p_77054_4_, double p_77054_6_, 
            float p_77054_8_, float p_77054_9_)
    {
        super.func_77031_a(p_77054_1_, p_77054_2_, p_77054_4_, p_77054_6_, p_77054_8_, p_77054_9_);
    }

    protected void func_77055_a(EntityVillager entityvillager, double d, double d1, double d2)
    {
    }

    protected void func_77051_a(EntityVillager p_77051_1_, float p_77051_2_)
    {
        super.func_77029_c(p_77051_1_, p_77051_2_);
    }

    protected void func_77052_b(EntityVillager p_77052_1_, float p_77052_2_)
    {
        float f = 0.9375F;
        if(p_77052_1_.func_70874_b() < 0)
        {
            f = (float)((double)f * 0.5D);
            field_76989_e = 0.25F;
        } else
        {
            field_76989_e = 0.5F;
        }
        GL11.glScalef(f, f, f);
    }

    protected void func_77033_b(EntityLiving p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_)
    {
        func_77055_a((EntityVillager)p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77052_b((EntityVillager)p_77041_1_, p_77041_2_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77053_a((EntityVillager)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        func_77051_a((EntityVillager)p_77029_1_, p_77029_2_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77054_a((EntityVillager)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77054_a((EntityVillager)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
