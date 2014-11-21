// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, ModelChest, ModelLargeChest, TileEntityChest, 
//            BlockChest, ModelRenderer, TileEntity

public class TileEntityChestRenderer extends TileEntitySpecialRenderer
{

    private ModelChest field_76913_a;
    private ModelChest field_76912_c;

    public TileEntityChestRenderer()
    {
        field_76913_a = new ModelChest();
        field_76912_c = new ModelLargeChest();
    }

    public void func_76911_a(TileEntityChest p_76911_1_, double p_76911_2_, double p_76911_4_, double p_76911_6_, 
            float p_76911_8_)
    {
        int i;
        if(!p_76911_1_.func_70309_m())
        {
            i = 0;
        } else
        {
            Block block = p_76911_1_.func_70311_o();
            i = p_76911_1_.func_70322_n();
            if(block != null && i == 0)
            {
                ((BlockChest)block).func_72290_b_(p_76911_1_.func_70314_l(), p_76911_1_.field_70329_l, p_76911_1_.field_70330_m, p_76911_1_.field_70327_n);
                i = p_76911_1_.func_70322_n();
            }
            p_76911_1_.func_70418_i();
        }
        if(p_76911_1_.field_70423_b != null || p_76911_1_.field_70421_d != null)
        {
            return;
        }
        ModelChest modelchest;
        if(p_76911_1_.field_70424_c != null || p_76911_1_.field_70422_e != null)
        {
            modelchest = field_76912_c;
            func_76897_a("/item/largechest.png");
        } else
        {
            modelchest = field_76913_a;
            func_76897_a("/item/chest.png");
        }
        GL11.glPushMatrix();
        GL11.glEnable(32826);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)p_76911_2_, (float)p_76911_4_ + 1.0F, (float)p_76911_6_ + 1.0F);
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
        if(i == 2 && p_76911_1_.field_70424_c != null)
        {
            GL11.glTranslatef(1.0F, 0.0F, 0.0F);
        }
        if(i == 5 && p_76911_1_.field_70422_e != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, -1F);
        }
        GL11.glRotatef(j, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f = p_76911_1_.field_70420_g + (p_76911_1_.field_70419_f - p_76911_1_.field_70420_g) * p_76911_8_;
        if(p_76911_1_.field_70423_b != null)
        {
            float f1 = p_76911_1_.field_70423_b.field_70420_g + (p_76911_1_.field_70423_b.field_70419_f - p_76911_1_.field_70423_b.field_70420_g) * p_76911_8_;
            if(f1 > f)
            {
                f = f1;
            }
        }
        if(p_76911_1_.field_70421_d != null)
        {
            float f2 = p_76911_1_.field_70421_d.field_70420_g + (p_76911_1_.field_70421_d.field_70419_f - p_76911_1_.field_70421_d.field_70420_g) * p_76911_8_;
            if(f2 > f)
            {
                f = f2;
            }
        }
        f = 1.0F - f;
        f = 1.0F - f * f * f;
        modelchest.field_78234_a.field_78795_f = -((f * 3.141593F) / 2.0F);
        modelchest.func_78231_a();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76911_a((TileEntityChest)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
