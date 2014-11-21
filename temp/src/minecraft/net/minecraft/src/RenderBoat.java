// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, ModelBoat, EntityBoat, MathHelper, 
//            ModelBase, Entity

public class RenderBoat extends Render
{

    protected ModelBase field_76998_a;

    public RenderBoat()
    {
        field_76989_e = 0.5F;
        field_76998_a = new ModelBoat();
    }

    public void func_76997_a(EntityBoat p_76997_1_, double p_76997_2_, double p_76997_4_, double p_76997_6_, 
            float p_76997_8_, float p_76997_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76997_2_, (float)p_76997_4_, (float)p_76997_6_);
        GL11.glRotatef(180F - p_76997_8_, 0.0F, 1.0F, 0.0F);
        float f = (float)p_76997_1_.func_70268_h() - p_76997_9_;
        float f1 = (float)p_76997_1_.func_70271_g() - p_76997_9_;
        if(f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        if(f > 0.0F)
        {
            GL11.glRotatef(((MathHelper.func_76126_a(f) * f * f1) / 10F) * (float)p_76997_1_.func_70267_i(), 1.0F, 0.0F, 0.0F);
        }
        func_76985_a("/terrain.png");
        float f2 = 0.75F;
        GL11.glScalef(f2, f2, f2);
        GL11.glScalef(1.0F / f2, 1.0F / f2, 1.0F / f2);
        func_76985_a("/item/boat.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        field_76998_a.func_78088_a(p_76997_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_76997_a((EntityBoat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
