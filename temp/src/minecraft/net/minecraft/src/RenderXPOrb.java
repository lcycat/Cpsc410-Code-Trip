// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, EntityXPOrb, Tessellator, 
//            OpenGlHelper, MathHelper, RenderManager, Entity

public class RenderXPOrb extends Render
{

    private RenderBlocks field_77006_b;
    public boolean field_77007_a;

    public RenderXPOrb()
    {
        field_77006_b = new RenderBlocks();
        field_77007_a = true;
        field_76989_e = 0.15F;
        field_76987_f = 0.75F;
    }

    public void func_77005_a(EntityXPOrb p_77005_1_, double p_77005_2_, double p_77005_4_, double p_77005_6_, 
            float p_77005_8_, float p_77005_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77005_2_, (float)p_77005_4_, (float)p_77005_6_);
        int i = p_77005_1_.func_70528_g();
        func_76985_a("/item/xporb.png");
        Tessellator tessellator = Tessellator.field_78398_a;
        float f = (float)((i % 4) * 16 + 0) / 64F;
        float f1 = (float)((i % 4) * 16 + 16) / 64F;
        float f2 = (float)((i / 4) * 16 + 0) / 64F;
        float f3 = (float)((i / 4) * 16 + 16) / 64F;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        float f7 = p_77005_1_.func_70070_b(p_77005_9_);
        float f8 = f7 % 0x10000;
        int j = f7 / 0x10000;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)f8 / 1.0F, (float)j / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        f7 = 255F;
        f8 = ((float)p_77005_1_.field_70533_a + p_77005_9_) / 2.0F;
        j = (int)((MathHelper.func_76126_a(f8 + 0.0F) + 1.0F) * 0.5F * f7);
        int k = (int)f7;
        int l = (int)((MathHelper.func_76126_a(f8 + 4.18879F) + 1.0F) * 0.1F * f7);
        int i1 = j << 16 | k << 8 | l;
        GL11.glRotatef(180F - field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        float f9 = 0.3F;
        GL11.glScalef(f9, f9, f9);
        tessellator.func_78382_b();
        tessellator.func_78384_a(i1, 128);
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
        tessellator.func_78374_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
        tessellator.func_78374_a(f4 - f5, 1.0F - f6, 0.0D, f1, f2);
        tessellator.func_78374_a(0.0F - f5, 1.0F - f6, 0.0D, f, f2);
        tessellator.func_78381_a();
        GL11.glDisable(3042);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77005_a((EntityXPOrb)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
