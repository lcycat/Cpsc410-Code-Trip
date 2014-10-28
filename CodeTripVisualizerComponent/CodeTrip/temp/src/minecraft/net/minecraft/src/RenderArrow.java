// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, EntityArrow, Tessellator, MathHelper, 
//            Entity

public class RenderArrow extends Render
{

    public RenderArrow()
    {
    }

    public void func_76999_a(EntityArrow p_76999_1_, double p_76999_2_, double p_76999_4_, double p_76999_6_, 
            float p_76999_8_, float p_76999_9_)
    {
        func_76985_a("/item/arrows.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76999_2_, (float)p_76999_4_, (float)p_76999_6_);
        GL11.glRotatef((p_76999_1_.field_70126_B + (p_76999_1_.field_70177_z - p_76999_1_.field_70126_B) * p_76999_9_) - 90F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(p_76999_1_.field_70127_C + (p_76999_1_.field_70125_A - p_76999_1_.field_70127_C) * p_76999_9_, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = 0;
        float f = 0.0F;
        float f1 = 0.5F;
        float f2 = (float)(0 + i * 10) / 32F;
        float f3 = (float)(5 + i * 10) / 32F;
        float f4 = 0.0F;
        float f5 = 0.15625F;
        float f6 = (float)(5 + i * 10) / 32F;
        float f7 = (float)(10 + i * 10) / 32F;
        float f8 = 0.05625F;
        GL11.glEnable(32826);
        float f9 = (float)p_76999_1_.field_70249_b - p_76999_9_;
        if(f9 > 0.0F)
        {
            float f10 = -MathHelper.func_76126_a(f9 * 3F) * f9;
            GL11.glRotatef(f10, 0.0F, 0.0F, 1.0F);
        }
        GL11.glRotatef(45F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f8, f8, f8);
        GL11.glTranslatef(-4F, 0.0F, 0.0F);
        GL11.glNormal3f(f8, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78374_a(-7D, -2D, -2D, f4, f6);
        tessellator.func_78374_a(-7D, -2D, 2D, f5, f6);
        tessellator.func_78374_a(-7D, 2D, 2D, f5, f7);
        tessellator.func_78374_a(-7D, 2D, -2D, f4, f7);
        tessellator.func_78381_a();
        GL11.glNormal3f(-f8, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78374_a(-7D, 2D, -2D, f4, f6);
        tessellator.func_78374_a(-7D, 2D, 2D, f5, f6);
        tessellator.func_78374_a(-7D, -2D, 2D, f5, f7);
        tessellator.func_78374_a(-7D, -2D, -2D, f4, f7);
        tessellator.func_78381_a();
        for(int j = 0; j < 4; j++)
        {
            GL11.glRotatef(90F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f8);
            tessellator.func_78382_b();
            tessellator.func_78374_a(-8D, -2D, 0.0D, f, f2);
            tessellator.func_78374_a(8D, -2D, 0.0D, f1, f2);
            tessellator.func_78374_a(8D, 2D, 0.0D, f1, f3);
            tessellator.func_78374_a(-8D, 2D, 0.0D, f, f3);
            tessellator.func_78381_a();
        }

        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_76999_a((EntityArrow)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
