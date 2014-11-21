// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, EntityTNTPrimed, Block, 
//            Entity

public class RenderTNTPrimed extends Render
{

    private RenderBlocks field_76993_a;

    public RenderTNTPrimed()
    {
        field_76993_a = new RenderBlocks();
        field_76989_e = 0.5F;
    }

    public void func_76992_a(EntityTNTPrimed p_76992_1_, double p_76992_2_, double p_76992_4_, double p_76992_6_, 
            float p_76992_8_, float p_76992_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76992_2_, (float)p_76992_4_, (float)p_76992_6_);
        if(((float)p_76992_1_.field_70516_a - p_76992_9_) + 1.0F < 10F)
        {
            float f = 1.0F - (((float)p_76992_1_.field_70516_a - p_76992_9_) + 1.0F) / 10F;
            if(f < 0.0F)
            {
                f = 0.0F;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            f *= f;
            f *= f;
            float f2 = 1.0F + f * 0.3F;
            GL11.glScalef(f2, f2, f2);
        }
        float f1 = (1.0F - (((float)p_76992_1_.field_70516_a - p_76992_9_) + 1.0F) / 100F) * 0.8F;
        func_76985_a("/terrain.png");
        field_76993_a.func_78600_a(Block.field_72091_am, 0, p_76992_1_.func_70013_c(p_76992_9_));
        if((p_76992_1_.field_70516_a / 5) % 2 == 0)
        {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
            field_76993_a.func_78600_a(Block.field_72091_am, 0, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_76992_a((EntityTNTPrimed)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
