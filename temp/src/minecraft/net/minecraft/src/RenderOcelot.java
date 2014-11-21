// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityOcelot, ModelBase, EntityLiving, 
//            Entity

public class RenderOcelot extends RenderLiving
{

    public RenderOcelot(ModelBase p_i3206_1_, float p_i3206_2_)
    {
        super(p_i3206_1_, p_i3206_2_);
    }

    public void func_77117_a(EntityOcelot p_77117_1_, double p_77117_2_, double p_77117_4_, double p_77117_6_, 
            float p_77117_8_, float p_77117_9_)
    {
        super.func_77031_a(p_77117_1_, p_77117_2_, p_77117_4_, p_77117_6_, p_77117_8_, p_77117_9_);
    }

    protected void func_77116_a(EntityOcelot p_77116_1_, float p_77116_2_)
    {
        super.func_77041_b(p_77116_1_, p_77116_2_);
        if(p_77116_1_.func_70909_n())
        {
            GL11.glScalef(0.8F, 0.8F, 0.8F);
        }
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77116_a((EntityOcelot)p_77041_1_, p_77041_2_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77117_a((EntityOcelot)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77117_a((EntityOcelot)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
