// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, ModelSign, TileEntitySign, Block, 
//            ModelRenderer, FontRenderer, TileEntity

public class TileEntitySignRenderer extends TileEntitySpecialRenderer
{

    private ModelSign field_76910_a;

    public TileEntitySignRenderer()
    {
        field_76910_a = new ModelSign();
    }

    public void func_76909_a(TileEntitySign p_76909_1_, double p_76909_2_, double p_76909_4_, double p_76909_6_, 
            float p_76909_8_)
    {
        Block block = p_76909_1_.func_70311_o();
        GL11.glPushMatrix();
        float f = 0.6666667F;
        if(block == Block.field_72053_aD)
        {
            GL11.glTranslatef((float)p_76909_2_ + 0.5F, (float)p_76909_4_ + 0.75F * f, (float)p_76909_6_ + 0.5F);
            float f1 = (float)(p_76909_1_.func_70322_n() * 360) / 16F;
            GL11.glRotatef(-f1, 0.0F, 1.0F, 0.0F);
            field_76910_a.field_78165_b.field_78806_j = true;
        } else
        {
            int i = p_76909_1_.func_70322_n();
            float f2 = 0.0F;
            if(i == 2)
            {
                f2 = 180F;
            }
            if(i == 4)
            {
                f2 = 90F;
            }
            if(i == 5)
            {
                f2 = -90F;
            }
            GL11.glTranslatef((float)p_76909_2_ + 0.5F, (float)p_76909_4_ + 0.75F * f, (float)p_76909_6_ + 0.5F);
            GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
            field_76910_a.field_78165_b.field_78806_j = false;
        }
        func_76897_a("/item/sign.png");
        GL11.glPushMatrix();
        GL11.glScalef(f, -f, -f);
        field_76910_a.func_78164_a();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = func_76895_b();
        float f3 = 0.01666667F * f;
        GL11.glTranslatef(0.0F, 0.5F * f, 0.07F * f);
        GL11.glScalef(f3, -f3, f3);
        GL11.glNormal3f(0.0F, 0.0F, -1F * f3);
        GL11.glDepthMask(false);
        int j = 0;
        for(int k = 0; k < p_76909_1_.field_70412_a.length; k++)
        {
            String s = p_76909_1_.field_70412_a[k];
            if(k == p_76909_1_.field_70410_b)
            {
                s = (new StringBuilder()).append("> ").append(s).append(" <").toString();
                fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, k * 10 - p_76909_1_.field_70412_a.length * 5, j);
            } else
            {
                fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, k * 10 - p_76909_1_.field_70412_a.length * 5, j);
            }
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76909_a((TileEntitySign)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
