// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Tessellator, RenderManager, EntityFishHook, 
//            EntityPlayer, MathHelper, Vec3, Vec3Pool, 
//            GameSettings, Entity

public class RenderFish extends Render
{

    public RenderFish()
    {
    }

    public void func_77000_a(EntityFishHook p_77000_1_, double p_77000_2_, double p_77000_4_, double p_77000_6_, 
            float p_77000_8_, float p_77000_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77000_2_, (float)p_77000_4_, (float)p_77000_6_);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        int i = 1;
        byte byte0 = 2;
        func_76985_a("/particles.png");
        Tessellator tessellator = Tessellator.field_78398_a;
        float f = (float)(i * 8 + 0) / 128F;
        float f1 = (float)(i * 8 + 8) / 128F;
        float f2 = (float)(byte0 * 8 + 0) / 128F;
        float f3 = (float)(byte0 * 8 + 8) / 128F;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.5F;
        GL11.glRotatef(180F - field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
        tessellator.func_78374_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
        tessellator.func_78374_a(f4 - f5, 1.0F - f6, 0.0D, f1, f2);
        tessellator.func_78374_a(0.0F - f5, 1.0F - f6, 0.0D, f, f2);
        tessellator.func_78381_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        if(p_77000_1_.field_70204_b != null)
        {
            float f7 = p_77000_1_.field_70204_b.func_70678_g(p_77000_9_);
            float f8 = MathHelper.func_76126_a(MathHelper.func_76129_c(f7) * 3.141593F);
            Vec3 vec3 = Vec3.func_72437_a().func_72345_a(-0.5D, 0.029999999999999999D, 0.80000000000000004D);
            vec3.func_72440_a((-(p_77000_1_.field_70204_b.field_70127_C + (p_77000_1_.field_70204_b.field_70125_A - p_77000_1_.field_70204_b.field_70127_C) * p_77000_9_) * 3.141593F) / 180F);
            vec3.func_72442_b((-(p_77000_1_.field_70204_b.field_70126_B + (p_77000_1_.field_70204_b.field_70177_z - p_77000_1_.field_70204_b.field_70126_B) * p_77000_9_) * 3.141593F) / 180F);
            vec3.func_72442_b(f8 * 0.5F);
            vec3.func_72440_a(-f8 * 0.7F);
            double d = p_77000_1_.field_70204_b.field_70169_q + (p_77000_1_.field_70204_b.field_70165_t - p_77000_1_.field_70204_b.field_70169_q) * (double)p_77000_9_ + vec3.field_72450_a;
            double d1 = p_77000_1_.field_70204_b.field_70167_r + (p_77000_1_.field_70204_b.field_70163_u - p_77000_1_.field_70204_b.field_70167_r) * (double)p_77000_9_ + vec3.field_72448_b;
            double d2 = p_77000_1_.field_70204_b.field_70166_s + (p_77000_1_.field_70204_b.field_70161_v - p_77000_1_.field_70204_b.field_70166_s) * (double)p_77000_9_ + vec3.field_72449_c;
            double d3 = p_77000_1_.field_70204_b == Minecraft.func_71410_x().field_71439_g ? 0.0D : p_77000_1_.field_70204_b.func_70047_e();
            if(field_76990_c.field_78733_k.field_74320_O > 0 || p_77000_1_.field_70204_b != Minecraft.func_71410_x().field_71439_g)
            {
                float f9 = ((p_77000_1_.field_70204_b.field_70760_ar + (p_77000_1_.field_70204_b.field_70761_aq - p_77000_1_.field_70204_b.field_70760_ar) * p_77000_9_) * 3.141593F) / 180F;
                double d5 = MathHelper.func_76126_a(f9);
                double d7 = MathHelper.func_76134_b(f9);
                d = (p_77000_1_.field_70204_b.field_70169_q + (p_77000_1_.field_70204_b.field_70165_t - p_77000_1_.field_70204_b.field_70169_q) * (double)p_77000_9_) - d7 * 0.34999999999999998D - d5 * 0.84999999999999998D;
                d1 = (p_77000_1_.field_70204_b.field_70167_r + d3 + (p_77000_1_.field_70204_b.field_70163_u - p_77000_1_.field_70204_b.field_70167_r) * (double)p_77000_9_) - 0.45000000000000001D;
                d2 = ((p_77000_1_.field_70204_b.field_70166_s + (p_77000_1_.field_70204_b.field_70161_v - p_77000_1_.field_70204_b.field_70166_s) * (double)p_77000_9_) - d5 * 0.34999999999999998D) + d7 * 0.84999999999999998D;
            }
            double d4 = p_77000_1_.field_70169_q + (p_77000_1_.field_70165_t - p_77000_1_.field_70169_q) * (double)p_77000_9_;
            double d6 = p_77000_1_.field_70167_r + (p_77000_1_.field_70163_u - p_77000_1_.field_70167_r) * (double)p_77000_9_ + 0.25D;
            double d8 = p_77000_1_.field_70166_s + (p_77000_1_.field_70161_v - p_77000_1_.field_70166_s) * (double)p_77000_9_;
            double d9 = (float)(d - d4);
            double d10 = (float)(d1 - d6);
            double d11 = (float)(d2 - d8);
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            tessellator.func_78371_b(3);
            tessellator.func_78378_d(0);
            int j = 16;
            for(int k = 0; k <= j; k++)
            {
                float f10 = (float)k / (float)j;
                tessellator.func_78377_a(p_77000_2_ + d9 * (double)f10, p_77000_4_ + d10 * (double)(f10 * f10 + f10) * 0.5D + 0.25D, p_77000_6_ + d11 * (double)f10);
            }

            tessellator.func_78381_a();
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77000_a((EntityFishHook)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
