// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, Tessellator, RenderManager, EntityFireball, 
//            Entity

public class RenderFireball extends Render
{

    private float field_77002_a;

    public RenderFireball(float p_i3204_1_)
    {
        field_77002_a = p_i3204_1_;
    }

    public void func_77001_a(EntityFireball p_77001_1_, double p_77001_2_, double p_77001_4_, double p_77001_6_, 
            float p_77001_8_, float p_77001_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77001_2_, (float)p_77001_4_, (float)p_77001_6_);
        GL11.glEnable(32826);
        float f = field_77002_a;
        GL11.glScalef(f / 1.0F, f / 1.0F, f / 1.0F);
        byte byte0 = 46;
        func_76985_a("/gui/items.png");
        Tessellator tessellator = Tessellator.field_78398_a;
        float f1 = (float)((byte0 % 16) * 16 + 0) / 256F;
        float f2 = (float)((byte0 % 16) * 16 + 16) / 256F;
        float f3 = (float)((byte0 / 16) * 16 + 0) / 256F;
        float f4 = (float)((byte0 / 16) * 16 + 16) / 256F;
        float f5 = 1.0F;
        float f6 = 0.5F;
        float f7 = 0.25F;
        GL11.glRotatef(180F - field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
        tessellator.func_78382_b();
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78374_a(0.0F - f6, 0.0F - f7, 0.0D, f1, f4);
        tessellator.func_78374_a(f5 - f6, 0.0F - f7, 0.0D, f2, f4);
        tessellator.func_78374_a(f5 - f6, 1.0F - f7, 0.0D, f2, f3);
        tessellator.func_78374_a(0.0F - f6, 1.0F - f7, 0.0D, f1, f3);
        tessellator.func_78381_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77001_a((EntityFireball)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
