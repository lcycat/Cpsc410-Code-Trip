// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, EntityPainting, EnumArt, Tessellator, 
//            MathHelper, RenderManager, World, OpenGlHelper, 
//            Entity

public class RenderPainting extends Render
{

    private Random field_77011_a;

    public RenderPainting()
    {
        field_77011_a = new Random();
    }

    public void func_77009_a(EntityPainting p_77009_1_, double p_77009_2_, double p_77009_4_, double p_77009_6_, 
            float p_77009_8_, float p_77009_9_)
    {
        field_77011_a.setSeed(187L);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77009_2_, (float)p_77009_4_, (float)p_77009_6_);
        GL11.glRotatef(p_77009_8_, 0.0F, 1.0F, 0.0F);
        GL11.glEnable(32826);
        func_76985_a("/art/kz.png");
        EnumArt enumart = p_77009_1_.field_70522_e;
        float f = 0.0625F;
        GL11.glScalef(f, f, f);
        func_77010_a(p_77009_1_, enumart.field_75703_B, enumart.field_75704_C, enumart.field_75699_D, enumart.field_75700_E);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_77010_a(EntityPainting p_77010_1_, int p_77010_2_, int p_77010_3_, int p_77010_4_, int p_77010_5_)
    {
        float f = (float)(-p_77010_2_) / 2.0F;
        float f1 = (float)(-p_77010_3_) / 2.0F;
        float f2 = -0.5F;
        float f3 = 0.5F;
        for(int i = 0; i < p_77010_2_ / 16; i++)
        {
            for(int j = 0; j < p_77010_3_ / 16; j++)
            {
                float f4 = f + (float)((i + 1) * 16);
                float f5 = f + (float)(i * 16);
                float f6 = f1 + (float)((j + 1) * 16);
                float f7 = f1 + (float)(j * 16);
                func_77008_a(p_77010_1_, (f4 + f5) / 2.0F, (f6 + f7) / 2.0F);
                float f8 = (float)((p_77010_4_ + p_77010_2_) - i * 16) / 256F;
                float f9 = (float)((p_77010_4_ + p_77010_2_) - (i + 1) * 16) / 256F;
                float f10 = (float)((p_77010_5_ + p_77010_3_) - j * 16) / 256F;
                float f11 = (float)((p_77010_5_ + p_77010_3_) - (j + 1) * 16) / 256F;
                float f12 = 0.75F;
                float f13 = 0.8125F;
                float f14 = 0.0F;
                float f15 = 0.0625F;
                float f16 = 0.75F;
                float f17 = 0.8125F;
                float f18 = 0.001953125F;
                float f19 = 0.001953125F;
                float f20 = 0.7519531F;
                float f21 = 0.7519531F;
                float f22 = 0.0F;
                float f23 = 0.0625F;
                Tessellator tessellator = Tessellator.field_78398_a;
                tessellator.func_78382_b();
                tessellator.func_78375_b(0.0F, 0.0F, -1F);
                tessellator.func_78374_a(f4, f7, f2, f9, f10);
                tessellator.func_78374_a(f5, f7, f2, f8, f10);
                tessellator.func_78374_a(f5, f6, f2, f8, f11);
                tessellator.func_78374_a(f4, f6, f2, f9, f11);
                tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
                tessellator.func_78374_a(f4, f6, f3, f12, f14);
                tessellator.func_78374_a(f5, f6, f3, f13, f14);
                tessellator.func_78374_a(f5, f7, f3, f13, f15);
                tessellator.func_78374_a(f4, f7, f3, f12, f15);
                tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
                tessellator.func_78374_a(f4, f6, f2, f16, f18);
                tessellator.func_78374_a(f5, f6, f2, f17, f18);
                tessellator.func_78374_a(f5, f6, f3, f17, f19);
                tessellator.func_78374_a(f4, f6, f3, f16, f19);
                tessellator.func_78375_b(0.0F, -1F, 0.0F);
                tessellator.func_78374_a(f4, f7, f3, f16, f18);
                tessellator.func_78374_a(f5, f7, f3, f17, f18);
                tessellator.func_78374_a(f5, f7, f2, f17, f19);
                tessellator.func_78374_a(f4, f7, f2, f16, f19);
                tessellator.func_78375_b(-1F, 0.0F, 0.0F);
                tessellator.func_78374_a(f4, f6, f3, f21, f22);
                tessellator.func_78374_a(f4, f7, f3, f21, f23);
                tessellator.func_78374_a(f4, f7, f2, f20, f23);
                tessellator.func_78374_a(f4, f6, f2, f20, f22);
                tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
                tessellator.func_78374_a(f5, f6, f2, f21, f22);
                tessellator.func_78374_a(f5, f7, f2, f21, f23);
                tessellator.func_78374_a(f5, f7, f3, f20, f23);
                tessellator.func_78374_a(f5, f6, f3, f20, f22);
                tessellator.func_78381_a();
            }

        }

    }

    private void func_77008_a(EntityPainting p_77008_1_, float p_77008_2_, float p_77008_3_)
    {
        int i = MathHelper.func_76128_c(p_77008_1_.field_70165_t);
        int j = MathHelper.func_76128_c(p_77008_1_.field_70163_u + (double)(p_77008_3_ / 16F));
        int k = MathHelper.func_76128_c(p_77008_1_.field_70161_v);
        if(p_77008_1_.field_70525_a == 0)
        {
            i = MathHelper.func_76128_c(p_77008_1_.field_70165_t + (double)(p_77008_2_ / 16F));
        }
        if(p_77008_1_.field_70525_a == 1)
        {
            k = MathHelper.func_76128_c(p_77008_1_.field_70161_v - (double)(p_77008_2_ / 16F));
        }
        if(p_77008_1_.field_70525_a == 2)
        {
            i = MathHelper.func_76128_c(p_77008_1_.field_70165_t - (double)(p_77008_2_ / 16F));
        }
        if(p_77008_1_.field_70525_a == 3)
        {
            k = MathHelper.func_76128_c(p_77008_1_.field_70161_v + (double)(p_77008_2_ / 16F));
        }
        int l = field_76990_c.field_78722_g.func_72802_i(i, j, k, 0);
        int i1 = l % 0x10000;
        int j1 = l / 0x10000;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, i1, j1);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77009_a((EntityPainting)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
