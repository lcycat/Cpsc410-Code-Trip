// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelMagmaCube, EntityMagmaCube, EntityLiving, 
//            Entity

public class RenderMagmaCube extends RenderLiving
{

    private int field_77120_a;

    public RenderMagmaCube()
    {
        super(new ModelMagmaCube(), 0.25F);
        field_77120_a = ((ModelMagmaCube)field_77045_g).func_78107_a();
    }

    public void func_77119_a(EntityMagmaCube p_77119_1_, double p_77119_2_, double p_77119_4_, double p_77119_6_, 
            float p_77119_8_, float p_77119_9_)
    {
        int i = ((ModelMagmaCube)field_77045_g).func_78107_a();
        if(i != field_77120_a)
        {
            field_77120_a = i;
            field_77045_g = new ModelMagmaCube();
            System.out.println("new lava slime model");
        }
        super.func_77031_a(p_77119_1_, p_77119_2_, p_77119_4_, p_77119_6_, p_77119_8_, p_77119_9_);
    }

    protected void func_77118_a(EntityMagmaCube p_77118_1_, float p_77118_2_)
    {
        int i = p_77118_1_.func_70809_q();
        float f = (p_77118_1_.field_70812_c + (p_77118_1_.field_70811_b - p_77118_1_.field_70812_c) * p_77118_2_) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        float f2 = i;
        GL11.glScalef(f1 * f2, (1.0F / f1) * f2, f1 * f2);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77118_a((EntityMagmaCube)p_77041_1_, p_77041_2_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77119_a((EntityMagmaCube)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77119_a((EntityMagmaCube)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
