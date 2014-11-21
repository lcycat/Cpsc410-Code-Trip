// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, GLAllocation, TileEntityRenderer, ActiveRenderInfo, 
//            Tessellator, TileEntityEndPortal, TileEntity

public class RenderEndPortal extends TileEntitySpecialRenderer
{

    FloatBuffer field_76908_a;

    public RenderEndPortal()
    {
        field_76908_a = GLAllocation.func_74529_h(16);
    }

    public void func_76906_a(TileEntityEndPortal p_76906_1_, double p_76906_2_, double p_76906_4_, double p_76906_6_, 
            float p_76906_8_)
    {
        float f = (float)field_76898_b.field_76967_j;
        float f1 = (float)field_76898_b.field_76968_k;
        float f2 = (float)field_76898_b.field_76965_l;
        GL11.glDisable(2896);
        Random random = new Random(31100L);
        float f3 = 0.75F;
        for(int i = 0; i < 16; i++)
        {
            GL11.glPushMatrix();
            float f4 = 16 - i;
            float f5 = 0.0625F;
            float f6 = 1.0F / (f4 + 1.0F);
            if(i == 0)
            {
                func_76897_a("/misc/tunnel.png");
                f6 = 0.1F;
                f4 = 65F;
                f5 = 0.125F;
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
            }
            if(i == 1)
            {
                func_76897_a("/misc/particlefield.png");
                GL11.glEnable(3042);
                GL11.glBlendFunc(1, 1);
                f5 = 0.5F;
            }
            float f7 = (float)(-(p_76906_4_ + (double)f3));
            float f8 = f7 + ActiveRenderInfo.field_74590_b;
            float f9 = f7 + f4 + ActiveRenderInfo.field_74590_b;
            float f10 = f8 / f9;
            f10 = (float)(p_76906_4_ + (double)f3) + f10;
            GL11.glTranslatef(f, f10, f2);
            GL11.glTexGeni(8192, 9472, 9217);
            GL11.glTexGeni(8193, 9472, 9217);
            GL11.glTexGeni(8194, 9472, 9217);
            GL11.glTexGeni(8195, 9472, 9216);
            GL11.glTexGen(8192, 9473, func_76907_a(1.0F, 0.0F, 0.0F, 0.0F));
            GL11.glTexGen(8193, 9473, func_76907_a(0.0F, 0.0F, 1.0F, 0.0F));
            GL11.glTexGen(8194, 9473, func_76907_a(0.0F, 0.0F, 0.0F, 1.0F));
            GL11.glTexGen(8195, 9474, func_76907_a(0.0F, 1.0F, 0.0F, 0.0F));
            GL11.glEnable(3168);
            GL11.glEnable(3169);
            GL11.glEnable(3170);
            GL11.glEnable(3171);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, (float)(Minecraft.func_71386_F() % 0xaae60L) / 700000F, 0.0F);
            GL11.glScalef(f5, f5, f5);
            GL11.glTranslatef(0.5F, 0.5F, 0.0F);
            GL11.glRotatef((float)(i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
            GL11.glTranslatef(-f, -f2, -f1);
            f8 = f7 + ActiveRenderInfo.field_74590_b;
            GL11.glTranslatef((ActiveRenderInfo.field_74592_a * f4) / f8, (ActiveRenderInfo.field_74591_c * f4) / f8, -f1);
            Tessellator tessellator = Tessellator.field_78398_a;
            tessellator.func_78382_b();
            f10 = random.nextFloat() * 0.5F + 0.1F;
            float f11 = random.nextFloat() * 0.5F + 0.4F;
            float f12 = random.nextFloat() * 0.5F + 0.5F;
            if(i == 0)
            {
                f10 = f11 = f12 = 1.0F;
            }
            tessellator.func_78369_a(f10 * f6, f11 * f6, f12 * f6, 1.0F);
            tessellator.func_78377_a(p_76906_2_, p_76906_4_ + (double)f3, p_76906_6_);
            tessellator.func_78377_a(p_76906_2_, p_76906_4_ + (double)f3, p_76906_6_ + 1.0D);
            tessellator.func_78377_a(p_76906_2_ + 1.0D, p_76906_4_ + (double)f3, p_76906_6_ + 1.0D);
            tessellator.func_78377_a(p_76906_2_ + 1.0D, p_76906_4_ + (double)f3, p_76906_6_);
            tessellator.func_78381_a();
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
        }

        GL11.glDisable(3042);
        GL11.glDisable(3168);
        GL11.glDisable(3169);
        GL11.glDisable(3170);
        GL11.glDisable(3171);
        GL11.glEnable(2896);
    }

    private FloatBuffer func_76907_a(float p_76907_1_, float p_76907_2_, float p_76907_3_, float p_76907_4_)
    {
        field_76908_a.clear();
        field_76908_a.put(p_76907_1_).put(p_76907_2_).put(p_76907_3_).put(p_76907_4_);
        field_76908_a.flip();
        return field_76908_a;
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76906_a((TileEntityEndPortal)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
