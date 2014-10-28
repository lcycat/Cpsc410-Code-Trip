// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelEnderCrystal, EntityEnderCrystal, MathHelper, 
//            ModelBase, Entity

public class RenderEnderCrystal extends Render
{

    private int field_76996_a;
    private ModelBase field_76995_b;

    public RenderEnderCrystal()
    {
        field_76996_a = -1;
        field_76989_e = 0.5F;
    }

    public void func_76994_a(EntityEnderCrystal p_76994_1_, double p_76994_2_, double p_76994_4_, double p_76994_6_, 
            float p_76994_8_, float p_76994_9_)
    {
        if(field_76996_a != 1)
        {
            field_76995_b = new ModelEnderCrystal(0.0F);
            field_76996_a = 1;
        }
        float f = (float)p_76994_1_.field_70261_a + p_76994_9_;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76994_2_, (float)p_76994_4_, (float)p_76994_6_);
        func_76985_a("/mob/enderdragon/crystal.png");
        float f1 = MathHelper.func_76126_a(f * 0.2F) / 2.0F + 0.5F;
        f1 = f1 * f1 + f1;
        field_76995_b.func_78088_a(p_76994_1_, 0.0F, f * 3F, f1 * 0.2F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_76994_a((EntityEnderCrystal)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
