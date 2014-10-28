// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Tessellator, EntityPotion, PotionHelper, 
//            RenderManager, Entity

public class RenderSnowball extends Render
{

    private int field_77027_a;

    public RenderSnowball(int p_i3208_1_)
    {
        field_77027_a = p_i3208_1_;
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        func_76985_a("/gui/items.png");
        Tessellator tessellator = Tessellator.field_78398_a;
        if(field_77027_a == 154)
        {
            int i = PotionHelper.func_77915_a(((EntityPotion)p_76986_1_).func_70196_i(), false);
            float f = (float)(i >> 16 & 0xff) / 255F;
            float f1 = (float)(i >> 8 & 0xff) / 255F;
            float f2 = (float)(i & 0xff) / 255F;
            GL11.glColor3f(f, f1, f2);
            GL11.glPushMatrix();
            func_77026_a(tessellator, 141);
            GL11.glPopMatrix();
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
        }
        func_77026_a(tessellator, field_77027_a);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_77026_a(Tessellator p_77026_1_, int p_77026_2_)
    {
        float f = (float)((p_77026_2_ % 16) * 16 + 0) / 256F;
        float f1 = (float)((p_77026_2_ % 16) * 16 + 16) / 256F;
        float f2 = (float)((p_77026_2_ / 16) * 16 + 0) / 256F;
        float f3 = (float)((p_77026_2_ / 16) * 16 + 16) / 256F;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180F - field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        p_77026_1_.func_78382_b();
        p_77026_1_.func_78375_b(0.0F, 1.0F, 0.0F);
        p_77026_1_.func_78374_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
        p_77026_1_.func_78374_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
        p_77026_1_.func_78374_a(f4 - f5, f4 - f6, 0.0D, f1, f2);
        p_77026_1_.func_78374_a(0.0F - f5, f4 - f6, 0.0D, f, f2);
        p_77026_1_.func_78381_a();
    }
}
