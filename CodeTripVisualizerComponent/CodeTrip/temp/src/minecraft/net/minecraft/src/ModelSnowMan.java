// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelSnowMan extends ModelBase
{

    public ModelRenderer field_78196_a;
    public ModelRenderer field_78194_b;
    public ModelRenderer field_78195_c;
    public ModelRenderer field_78192_d;
    public ModelRenderer field_78193_e;

    public ModelSnowMan()
    {
        float f = 4F;
        float f1 = 0.0F;
        field_78195_c = (new ModelRenderer(this, 0, 0)).func_78787_b(64, 64);
        field_78195_c.func_78790_a(-4F, -8F, -4F, 8, 8, 8, f1 - 0.5F);
        field_78195_c.func_78793_a(0.0F, 0.0F + f, 0.0F);
        field_78192_d = (new ModelRenderer(this, 32, 0)).func_78787_b(64, 64);
        field_78192_d.func_78790_a(-1F, 0.0F, -1F, 12, 2, 2, f1 - 0.5F);
        field_78192_d.func_78793_a(0.0F, (0.0F + f + 9F) - 7F, 0.0F);
        field_78193_e = (new ModelRenderer(this, 32, 0)).func_78787_b(64, 64);
        field_78193_e.func_78790_a(-1F, 0.0F, -1F, 12, 2, 2, f1 - 0.5F);
        field_78193_e.func_78793_a(0.0F, (0.0F + f + 9F) - 7F, 0.0F);
        field_78196_a = (new ModelRenderer(this, 0, 16)).func_78787_b(64, 64);
        field_78196_a.func_78790_a(-5F, -10F, -5F, 10, 10, 10, f1 - 0.5F);
        field_78196_a.func_78793_a(0.0F, 0.0F + f + 9F, 0.0F);
        field_78194_b = (new ModelRenderer(this, 0, 36)).func_78787_b(64, 64);
        field_78194_b.func_78790_a(-6F, -12F, -6F, 12, 12, 12, f1 - 0.5F);
        field_78194_b.func_78793_a(0.0F, 0.0F + f + 20F, 0.0F);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
        field_78195_c.field_78796_g = p_78087_4_ / 57.29578F;
        field_78195_c.field_78795_f = p_78087_5_ / 57.29578F;
        field_78196_a.field_78796_g = (p_78087_4_ / 57.29578F) * 0.25F;
        float f = MathHelper.func_76126_a(field_78196_a.field_78796_g);
        float f1 = MathHelper.func_76134_b(field_78196_a.field_78796_g);
        field_78192_d.field_78808_h = 1.0F;
        field_78193_e.field_78808_h = -1F;
        field_78192_d.field_78796_g = 0.0F + field_78196_a.field_78796_g;
        field_78193_e.field_78796_g = 3.141593F + field_78196_a.field_78796_g;
        field_78192_d.field_78800_c = f1 * 5F;
        field_78192_d.field_78798_e = -f * 5F;
        field_78193_e.field_78800_c = -f1 * 5F;
        field_78193_e.field_78798_e = f * 5F;
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78196_a.func_78785_a(p_78088_7_);
        field_78194_b.func_78785_a(p_78088_7_);
        field_78195_c.func_78785_a(p_78088_7_);
        field_78192_d.func_78785_a(p_78088_7_);
        field_78193_e.func_78785_a(p_78088_7_);
    }
}
