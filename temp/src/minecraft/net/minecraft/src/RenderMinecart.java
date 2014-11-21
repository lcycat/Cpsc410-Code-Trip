// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelMinecart, EntityMinecart, Vec3, 
//            MathHelper, RenderBlocks, Block, ModelBase, 
//            Entity

public class RenderMinecart extends Render
{

    protected ModelBase field_77013_a;

    public RenderMinecart()
    {
        field_76989_e = 0.5F;
        field_77013_a = new ModelMinecart();
    }

    public void func_77012_a(EntityMinecart p_77012_1_, double p_77012_2_, double p_77012_4_, double p_77012_6_, 
            float p_77012_8_, float p_77012_9_)
    {
        GL11.glPushMatrix();
        long l = (long)p_77012_1_.field_70157_k * 0x1d66f537L;
        l = l * l * 0x105cb26d1L + l * 0x181c9L;
        float f = (((float)(l >> 16 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        float f1 = (((float)(l >> 20 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        float f2 = (((float)(l >> 24 & 7L) + 0.5F) / 8F - 0.5F) * 0.004F;
        GL11.glTranslatef(f, f1, f2);
        double d = p_77012_1_.field_70142_S + (p_77012_1_.field_70165_t - p_77012_1_.field_70142_S) * (double)p_77012_9_;
        double d1 = p_77012_1_.field_70137_T + (p_77012_1_.field_70163_u - p_77012_1_.field_70137_T) * (double)p_77012_9_;
        double d2 = p_77012_1_.field_70136_U + (p_77012_1_.field_70161_v - p_77012_1_.field_70136_U) * (double)p_77012_9_;
        double d3 = 0.30000001192092896D;
        Vec3 vec3 = p_77012_1_.func_70489_a(d, d1, d2);
        float f3 = p_77012_1_.field_70127_C + (p_77012_1_.field_70125_A - p_77012_1_.field_70127_C) * p_77012_9_;
        if(vec3 != null)
        {
            Vec3 vec3_1 = p_77012_1_.func_70495_a(d, d1, d2, d3);
            Vec3 vec3_2 = p_77012_1_.func_70495_a(d, d1, d2, -d3);
            if(vec3_1 == null)
            {
                vec3_1 = vec3;
            }
            if(vec3_2 == null)
            {
                vec3_2 = vec3;
            }
            p_77012_2_ += vec3.field_72450_a - d;
            p_77012_4_ += (vec3_1.field_72448_b + vec3_2.field_72448_b) / 2D - d1;
            p_77012_6_ += vec3.field_72449_c - d2;
            Vec3 vec3_3 = vec3_2.func_72441_c(-vec3_1.field_72450_a, -vec3_1.field_72448_b, -vec3_1.field_72449_c);
            if(vec3_3.func_72433_c() != 0.0D)
            {
                vec3_3 = vec3_3.func_72432_b();
                p_77012_8_ = (float)((Math.atan2(vec3_3.field_72449_c, vec3_3.field_72450_a) * 180D) / 3.1415926535897931D);
                f3 = (float)(Math.atan(vec3_3.field_72448_b) * 73D);
            }
        }
        GL11.glTranslatef((float)p_77012_2_, (float)p_77012_4_, (float)p_77012_6_);
        GL11.glRotatef(180F - p_77012_8_, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f3, 0.0F, 0.0F, 1.0F);
        float f4 = (float)p_77012_1_.func_70496_j() - p_77012_9_;
        float f5 = (float)p_77012_1_.func_70491_i() - p_77012_9_;
        if(f5 < 0.0F)
        {
            f5 = 0.0F;
        }
        if(f4 > 0.0F)
        {
            GL11.glRotatef(((MathHelper.func_76126_a(f4) * f4 * f5) / 10F) * (float)p_77012_1_.func_70493_k(), 1.0F, 0.0F, 0.0F);
        }
        if(p_77012_1_.field_70505_a != 0)
        {
            func_76985_a("/terrain.png");
            float f6 = 0.75F;
            GL11.glScalef(f6, f6, f6);
            if(p_77012_1_.field_70505_a == 1)
            {
                GL11.glTranslatef(0.0F, 0.5F, 0.0F);
                (new RenderBlocks()).func_78600_a(Block.field_72077_au, 0, p_77012_1_.func_70013_c(p_77012_9_));
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.5F, 0.0F, -0.5F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            } else
            if(p_77012_1_.field_70505_a == 2)
            {
                GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
                (new RenderBlocks()).func_78600_a(Block.field_72051_aB, 0, p_77012_1_.func_70013_c(p_77012_9_));
                GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            }
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        }
        func_76985_a("/item/cart.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        field_77013_a.func_78088_a(p_77012_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77012_a((EntityMinecart)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
