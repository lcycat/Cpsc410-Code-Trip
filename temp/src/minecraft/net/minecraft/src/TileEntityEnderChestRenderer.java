// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, ModelChest, TileEntityEnderChest, ModelRenderer, 
//            TileEntity

public class TileEntityEnderChestRenderer extends TileEntitySpecialRenderer
{

    private ModelChest field_76900_a;

    public TileEntityEnderChestRenderer()
    {
        field_76900_a = new ModelChest();
    }

    public void func_76899_a(TileEntityEnderChest p_76899_1_, double p_76899_2_, double p_76899_4_, double p_76899_6_, 
            float p_76899_8_)
    {
        int i = 0;
        if(p_76899_1_.func_70309_m())
        {
            i = p_76899_1_.func_70322_n();
        }
        func_76897_a("/item/enderchest.png");
        GL11.glPushMatrix();
        GL11.glEnable(32826);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)p_76899_2_, (float)p_76899_4_ + 1.0F, (float)p_76899_6_ + 1.0F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        int j = 0;
        if(i == 2)
        {
            j = 180;
        }
        if(i == 3)
        {
            j = 0;
        }
        if(i == 4)
        {
            j = 90;
        }
        if(i == 5)
        {
            j = -90;
        }
        GL11.glRotatef(j, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f = p_76899_1_.field_70368_b + (p_76899_1_.field_70370_a - p_76899_1_.field_70368_b) * p_76899_8_;
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        field_76900_a.field_78234_a.field_78795_f = -((f * 3.141593F) / 2.0F);
        field_76900_a.func_78231_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76899_a((TileEntityEnderChest)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
