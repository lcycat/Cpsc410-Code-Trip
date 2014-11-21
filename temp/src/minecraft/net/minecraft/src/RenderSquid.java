// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntitySquid, ModelBase, EntityLiving, 
//            Entity

public class RenderSquid extends RenderLiving
{

    public RenderSquid(ModelBase p_i3201_1_, float p_i3201_2_)
    {
        super(p_i3201_1_, p_i3201_2_);
    }

    public void func_77123_a(EntitySquid p_77123_1_, double p_77123_2_, double p_77123_4_, double p_77123_6_, 
            float p_77123_8_, float p_77123_9_)
    {
        super.func_77031_a(p_77123_1_, p_77123_2_, p_77123_4_, p_77123_6_, p_77123_8_, p_77123_9_);
    }

    protected void func_77122_a(EntitySquid p_77122_1_, float p_77122_2_, float p_77122_3_, float p_77122_4_)
    {
        float f = p_77122_1_.field_70862_e + (p_77122_1_.field_70861_d - p_77122_1_.field_70862_e) * p_77122_4_;
        float f1 = p_77122_1_.field_70860_g + (p_77122_1_.field_70859_f - p_77122_1_.field_70860_g) * p_77122_4_;
        GL11.glTranslatef(0.0F, 0.5F, 0.0F);
        GL11.glRotatef(180F - p_77122_3_, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(f, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, -1.2F, 0.0F);
    }

    protected float func_77121_a(EntitySquid p_77121_1_, float p_77121_2_)
    {
        return p_77121_1_.field_70865_by + (p_77121_1_.field_70866_j - p_77121_1_.field_70865_by) * p_77121_2_;
    }

    protected float func_77044_a(EntityLiving p_77044_1_, float p_77044_2_)
    {
        return func_77121_a((EntitySquid)p_77044_1_, p_77044_2_);
    }

    protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        func_77122_a((EntitySquid)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77123_a((EntitySquid)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77123_a((EntitySquid)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
