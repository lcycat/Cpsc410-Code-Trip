// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, ModelBook, TileEntityEnchantmentTable, MathHelper, 
//            TileEntity

public class RenderEnchantmentTable extends TileEntitySpecialRenderer
{

    private ModelBook field_76902_a;

    public RenderEnchantmentTable()
    {
        field_76902_a = new ModelBook();
    }

    public void func_76901_a(TileEntityEnchantmentTable p_76901_1_, double p_76901_2_, double p_76901_4_, double p_76901_6_, 
            float p_76901_8_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76901_2_ + 0.5F, (float)p_76901_4_ + 0.75F, (float)p_76901_6_ + 0.5F);
        float f = (float)p_76901_1_.field_70378_a + p_76901_8_;
        GL11.glTranslatef(0.0F, 0.1F + MathHelper.func_76126_a(f * 0.1F) * 0.01F, 0.0F);
        float f1;
        for(f1 = p_76901_1_.field_70380_h - p_76901_1_.field_70381_i; f1 >= 3.141593F; f1 -= 6.283185F) { }
        for(; f1 < -3.141593F; f1 += 6.283185F) { }
        float f2 = p_76901_1_.field_70381_i + f1 * p_76901_8_;
        GL11.glRotatef((-f2 * 180F) / 3.141593F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(80F, 0.0F, 0.0F, 1.0F);
        func_76897_a("/item/book.png");
        float f3 = p_76901_1_.field_70377_c + (p_76901_1_.field_70375_b - p_76901_1_.field_70377_c) * p_76901_8_ + 0.25F;
        float f4 = p_76901_1_.field_70377_c + (p_76901_1_.field_70375_b - p_76901_1_.field_70377_c) * p_76901_8_ + 0.75F;
        f3 = (f3 - (float)MathHelper.func_76140_b(f3)) * 1.6F - 0.3F;
        f4 = (f4 - (float)MathHelper.func_76140_b(f4)) * 1.6F - 0.3F;
        if(f3 < 0.0F)
        {
            f3 = 0.0F;
        }
        if(f4 < 0.0F)
        {
            f4 = 0.0F;
        }
        if(f3 > 1.0F)
        {
            f3 = 1.0F;
        }
        if(f4 > 1.0F)
        {
            f4 = 1.0F;
        }
        float f5 = p_76901_1_.field_70372_g + (p_76901_1_.field_70371_f - p_76901_1_.field_70372_g) * p_76901_8_;
        field_76902_a.func_78088_a(null, f, f3, f4, f5, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void func_76894_a(TileEntity p_76894_1_, double p_76894_2_, double p_76894_4_, double p_76894_6_, 
            float p_76894_8_)
    {
        func_76901_a((TileEntityEnchantmentTable)p_76894_1_, p_76894_2_, p_76894_4_, p_76894_6_, p_76894_8_);
    }
}
