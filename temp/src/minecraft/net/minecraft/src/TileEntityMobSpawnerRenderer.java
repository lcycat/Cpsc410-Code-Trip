// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, TileEntityMobSpawner, Entity, RenderManager, 
//            TileEntityRenderer, TileEntity

public class TileEntityMobSpawnerRenderer extends TileEntitySpecialRenderer
{

    public TileEntityMobSpawnerRenderer()
    {
    }

    public void func_76893_a(TileEntityRenderer p_76893_1_)
    {
        super.func_76893_a(p_76893_1_);
    }

    public void func_76905_a(TileEntityMobSpawner p_76905_1_, double p_76905_2_, double p_76905_4_, double p_76905_6_, 
            float p_76905_8_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76905_2_ + 0.5F, (float)p_76905_4_, (float)p_76905_6_ + 0.5F);
        Entity entity = p_76905_1_.func_70382_c();
        if(entity != null)
        {
            entity.func_70029_a(p_76905_1_.func_70314_l());
            float f = 0.4375F;
            GL11.glTranslatef(0.0F, 0.4F, 0.0F);
            GL11.glRotatef((float)(p_76905_1_.field_70393_c + (p_76905_1_.field_70392_b - p_76905_1_.field_70393_c) * (double)p_76905_8_) * 10F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-30F, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.4F, 0.0F);
            GL11.glScalef(f, f, f);
            entity.func_70012_b(p_76905_2_, p_76905_4_, p_76905_6_, 0.0F, 0.0F);
            RenderManager.field_78727_a.func_78719_a(entity, 0.0D, 0.0D, 0.0D, 0.0F, p_76905_8_);
        }
        GL11.glPopMatrix();
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76905_a((TileEntityMobSpawner)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
