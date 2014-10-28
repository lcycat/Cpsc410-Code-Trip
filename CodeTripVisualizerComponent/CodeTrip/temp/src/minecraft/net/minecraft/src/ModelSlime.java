// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelSlime extends ModelBase
{

    ModelRenderer field_78200_a;
    ModelRenderer field_78198_b;
    ModelRenderer field_78199_c;
    ModelRenderer field_78197_d;

    public ModelSlime(int p_i3128_1_)
    {
        field_78200_a = new ModelRenderer(this, 0, p_i3128_1_);
        field_78200_a.func_78789_a(-4F, 16F, -4F, 8, 8, 8);
        if(p_i3128_1_ > 0)
        {
            field_78200_a = new ModelRenderer(this, 0, p_i3128_1_);
            field_78200_a.func_78789_a(-3F, 17F, -3F, 6, 6, 6);
            field_78198_b = new ModelRenderer(this, 32, 0);
            field_78198_b.func_78789_a(-3.25F, 18F, -3.5F, 2, 2, 2);
            field_78199_c = new ModelRenderer(this, 32, 4);
            field_78199_c.func_78789_a(1.25F, 18F, -3.5F, 2, 2, 2);
            field_78197_d = new ModelRenderer(this, 32, 8);
            field_78197_d.func_78789_a(0.0F, 21F, -3.5F, 1, 1, 1);
        }
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78200_a.func_78785_a(p_78088_7_);
        if(field_78198_b != null)
        {
            field_78198_b.func_78785_a(p_78088_7_);
            field_78199_c.func_78785_a(p_78088_7_);
            field_78197_d.func_78785_a(p_78088_7_);
        }
    }
}
