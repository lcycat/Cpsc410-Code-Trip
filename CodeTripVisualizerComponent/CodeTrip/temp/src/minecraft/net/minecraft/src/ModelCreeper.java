// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelCreeper extends ModelBase
{

    public ModelRenderer field_78135_a;
    public ModelRenderer field_78133_b;
    public ModelRenderer field_78134_c;
    public ModelRenderer field_78131_d;
    public ModelRenderer field_78132_e;
    public ModelRenderer field_78129_f;
    public ModelRenderer field_78130_g;

    public ModelCreeper()
    {
        this(0.0F);
    }

    public ModelCreeper(float p_i3133_1_)
    {
        int i = 4;
        field_78135_a = new ModelRenderer(this, 0, 0);
        field_78135_a.func_78790_a(-4F, -8F, -4F, 8, 8, 8, p_i3133_1_);
        field_78135_a.func_78793_a(0.0F, i, 0.0F);
        field_78133_b = new ModelRenderer(this, 32, 0);
        field_78133_b.func_78790_a(-4F, -8F, -4F, 8, 8, 8, p_i3133_1_ + 0.5F);
        field_78133_b.func_78793_a(0.0F, i, 0.0F);
        field_78134_c = new ModelRenderer(this, 16, 16);
        field_78134_c.func_78790_a(-4F, 0.0F, -2F, 8, 12, 4, p_i3133_1_);
        field_78134_c.func_78793_a(0.0F, i, 0.0F);
        field_78131_d = new ModelRenderer(this, 0, 16);
        field_78131_d.func_78790_a(-2F, 0.0F, -2F, 4, 6, 4, p_i3133_1_);
        field_78131_d.func_78793_a(-2F, 12 + i, 4F);
        field_78132_e = new ModelRenderer(this, 0, 16);
        field_78132_e.func_78790_a(-2F, 0.0F, -2F, 4, 6, 4, p_i3133_1_);
        field_78132_e.func_78793_a(2.0F, 12 + i, 4F);
        field_78129_f = new ModelRenderer(this, 0, 16);
        field_78129_f.func_78790_a(-2F, 0.0F, -2F, 4, 6, 4, p_i3133_1_);
        field_78129_f.func_78793_a(-2F, 12 + i, -4F);
        field_78130_g = new ModelRenderer(this, 0, 16);
        field_78130_g.func_78790_a(-2F, 0.0F, -2F, 4, 6, 4, p_i3133_1_);
        field_78130_g.func_78793_a(2.0F, 12 + i, -4F);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78135_a.func_78785_a(p_78088_7_);
        field_78134_c.func_78785_a(p_78088_7_);
        field_78131_d.func_78785_a(p_78088_7_);
        field_78132_e.func_78785_a(p_78088_7_);
        field_78129_f.func_78785_a(p_78088_7_);
        field_78130_g.func_78785_a(p_78088_7_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78135_a.field_78796_g = p_78087_4_ / 57.29578F;
        field_78135_a.field_78795_f = p_78087_5_ / 57.29578F;
        field_78131_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        field_78132_e.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_;
        field_78129_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_;
        field_78130_g.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
    }
}
