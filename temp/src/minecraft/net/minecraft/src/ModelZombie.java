// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBiped, MathHelper, ModelRenderer

public class ModelZombie extends ModelBiped
{

    public ModelZombie()
    {
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
        float f = MathHelper.func_76126_a(field_78095_p * 3.141593F);
        float f1 = MathHelper.func_76126_a((1.0F - (1.0F - field_78095_p) * (1.0F - field_78095_p)) * 3.141593F);
        field_78112_f.field_78808_h = 0.0F;
        field_78113_g.field_78808_h = 0.0F;
        field_78112_f.field_78796_g = -(0.1F - f * 0.6F);
        field_78113_g.field_78796_g = 0.1F - f * 0.6F;
        field_78112_f.field_78795_f = -1.570796F;
        field_78113_g.field_78795_f = -1.570796F;
        field_78112_f.field_78795_f -= f * 1.2F - f1 * 0.4F;
        field_78113_g.field_78795_f -= f * 1.2F - f1 * 0.4F;
        field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
        field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
    }
}
