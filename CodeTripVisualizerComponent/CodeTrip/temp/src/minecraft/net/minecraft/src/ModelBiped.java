// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelBiped extends ModelBase
{

    public ModelRenderer field_78116_c;
    public ModelRenderer field_78114_d;
    public ModelRenderer field_78115_e;
    public ModelRenderer field_78112_f;
    public ModelRenderer field_78113_g;
    public ModelRenderer field_78123_h;
    public ModelRenderer field_78124_i;
    public ModelRenderer field_78121_j;
    public ModelRenderer field_78122_k;
    public int field_78119_l;
    public int field_78120_m;
    public boolean field_78117_n;
    public boolean field_78118_o;

    public ModelBiped()
    {
        this(0.0F);
    }

    public ModelBiped(float p_i3134_1_)
    {
        this(p_i3134_1_, 0.0F);
    }

    public ModelBiped(float p_i3135_1_, float p_i3135_2_)
    {
        field_78119_l = 0;
        field_78120_m = 0;
        field_78117_n = false;
        field_78118_o = false;
        field_78122_k = new ModelRenderer(this, 0, 0);
        field_78122_k.func_78790_a(-5F, 0.0F, -1F, 10, 16, 1, p_i3135_1_);
        field_78121_j = new ModelRenderer(this, 24, 0);
        field_78121_j.func_78790_a(-3F, -6F, -1F, 6, 6, 1, p_i3135_1_);
        field_78116_c = new ModelRenderer(this, 0, 0);
        field_78116_c.func_78790_a(-4F, -8F, -4F, 8, 8, 8, p_i3135_1_);
        field_78116_c.func_78793_a(0.0F, 0.0F + p_i3135_2_, 0.0F);
        field_78114_d = new ModelRenderer(this, 32, 0);
        field_78114_d.func_78790_a(-4F, -8F, -4F, 8, 8, 8, p_i3135_1_ + 0.5F);
        field_78114_d.func_78793_a(0.0F, 0.0F + p_i3135_2_, 0.0F);
        field_78115_e = new ModelRenderer(this, 16, 16);
        field_78115_e.func_78790_a(-4F, 0.0F, -2F, 8, 12, 4, p_i3135_1_);
        field_78115_e.func_78793_a(0.0F, 0.0F + p_i3135_2_, 0.0F);
        field_78112_f = new ModelRenderer(this, 40, 16);
        field_78112_f.func_78790_a(-3F, -2F, -2F, 4, 12, 4, p_i3135_1_);
        field_78112_f.func_78793_a(-5F, 2.0F + p_i3135_2_, 0.0F);
        field_78113_g = new ModelRenderer(this, 40, 16);
        field_78113_g.field_78809_i = true;
        field_78113_g.func_78790_a(-1F, -2F, -2F, 4, 12, 4, p_i3135_1_);
        field_78113_g.func_78793_a(5F, 2.0F + p_i3135_2_, 0.0F);
        field_78123_h = new ModelRenderer(this, 0, 16);
        field_78123_h.func_78790_a(-2F, 0.0F, -2F, 4, 12, 4, p_i3135_1_);
        field_78123_h.func_78793_a(-2F, 12F + p_i3135_2_, 0.0F);
        field_78124_i = new ModelRenderer(this, 0, 16);
        field_78124_i.field_78809_i = true;
        field_78124_i.func_78790_a(-2F, 0.0F, -2F, 4, 12, 4, p_i3135_1_);
        field_78124_i.func_78793_a(2.0F, 12F + p_i3135_2_, 0.0F);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78116_c.func_78785_a(p_78088_7_);
        field_78115_e.func_78785_a(p_78088_7_);
        field_78112_f.func_78785_a(p_78088_7_);
        field_78113_g.func_78785_a(p_78088_7_);
        field_78123_h.func_78785_a(p_78088_7_);
        field_78124_i.func_78785_a(p_78088_7_);
        field_78114_d.func_78785_a(p_78088_7_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78116_c.field_78796_g = p_78087_4_ / 57.29578F;
        field_78116_c.field_78795_f = p_78087_5_ / 57.29578F;
        field_78114_d.field_78796_g = field_78116_c.field_78796_g;
        field_78114_d.field_78795_f = field_78116_c.field_78795_f;
        field_78112_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 2.0F * p_78087_2_ * 0.5F;
        field_78113_g.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F;
        field_78112_f.field_78808_h = 0.0F;
        field_78113_g.field_78808_h = 0.0F;
        field_78123_h.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        field_78124_i.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_;
        field_78123_h.field_78796_g = 0.0F;
        field_78124_i.field_78796_g = 0.0F;
        if(field_78093_q)
        {
            field_78112_f.field_78795_f += -0.6283185F;
            field_78113_g.field_78795_f += -0.6283185F;
            field_78123_h.field_78795_f = -1.256637F;
            field_78124_i.field_78795_f = -1.256637F;
            field_78123_h.field_78796_g = 0.3141593F;
            field_78124_i.field_78796_g = -0.3141593F;
        }
        if(field_78119_l != 0)
        {
            field_78113_g.field_78795_f = field_78113_g.field_78795_f * 0.5F - 0.3141593F * (float)field_78119_l;
        }
        if(field_78120_m != 0)
        {
            field_78112_f.field_78795_f = field_78112_f.field_78795_f * 0.5F - 0.3141593F * (float)field_78120_m;
        }
        field_78112_f.field_78796_g = 0.0F;
        field_78113_g.field_78796_g = 0.0F;
        if(field_78095_p > -9990F)
        {
            float f = field_78095_p;
            field_78115_e.field_78796_g = MathHelper.func_76126_a(MathHelper.func_76129_c(f) * 3.141593F * 2.0F) * 0.2F;
            field_78112_f.field_78798_e = MathHelper.func_76126_a(field_78115_e.field_78796_g) * 5F;
            field_78112_f.field_78800_c = -MathHelper.func_76134_b(field_78115_e.field_78796_g) * 5F;
            field_78113_g.field_78798_e = -MathHelper.func_76126_a(field_78115_e.field_78796_g) * 5F;
            field_78113_g.field_78800_c = MathHelper.func_76134_b(field_78115_e.field_78796_g) * 5F;
            field_78112_f.field_78796_g += field_78115_e.field_78796_g;
            field_78113_g.field_78796_g += field_78115_e.field_78796_g;
            field_78113_g.field_78795_f += field_78115_e.field_78796_g;
            f = 1.0F - field_78095_p;
            f *= f;
            f *= f;
            f = 1.0F - f;
            float f2 = MathHelper.func_76126_a(f * 3.141593F);
            float f4 = MathHelper.func_76126_a(field_78095_p * 3.141593F) * -(field_78116_c.field_78795_f - 0.7F) * 0.75F;
            field_78112_f.field_78795_f -= (double)f2 * 1.2D + (double)f4;
            field_78112_f.field_78796_g += field_78115_e.field_78796_g * 2.0F;
            field_78112_f.field_78808_h = MathHelper.func_76126_a(field_78095_p * 3.141593F) * -0.4F;
        }
        if(field_78117_n)
        {
            field_78115_e.field_78795_f = 0.5F;
            field_78112_f.field_78795_f += 0.4F;
            field_78113_g.field_78795_f += 0.4F;
            field_78123_h.field_78798_e = 4F;
            field_78124_i.field_78798_e = 4F;
            field_78123_h.field_78797_d = 9F;
            field_78124_i.field_78797_d = 9F;
            field_78116_c.field_78797_d = 1.0F;
        } else
        {
            field_78115_e.field_78795_f = 0.0F;
            field_78123_h.field_78798_e = 0.0F;
            field_78124_i.field_78798_e = 0.0F;
            field_78123_h.field_78797_d = 12F;
            field_78124_i.field_78797_d = 12F;
            field_78116_c.field_78797_d = 0.0F;
        }
        field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
        field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
        field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
        if(field_78118_o)
        {
            float f1 = 0.0F;
            float f3 = 0.0F;
            field_78112_f.field_78808_h = 0.0F;
            field_78113_g.field_78808_h = 0.0F;
            field_78112_f.field_78796_g = -(0.1F - f1 * 0.6F) + field_78116_c.field_78796_g;
            field_78113_g.field_78796_g = (0.1F - f1 * 0.6F) + field_78116_c.field_78796_g + 0.4F;
            field_78112_f.field_78795_f = -1.570796F + field_78116_c.field_78795_f;
            field_78113_g.field_78795_f = -1.570796F + field_78116_c.field_78795_f;
            field_78112_f.field_78795_f -= f1 * 1.2F - f3 * 0.4F;
            field_78113_g.field_78795_f -= f1 * 1.2F - f3 * 0.4F;
            field_78112_f.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
            field_78113_g.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
            field_78112_f.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
            field_78113_g.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
        }
    }

    public void func_78110_b(float p_78110_1_)
    {
        field_78121_j.field_78796_g = field_78116_c.field_78796_g;
        field_78121_j.field_78795_f = field_78116_c.field_78795_f;
        field_78121_j.field_78800_c = 0.0F;
        field_78121_j.field_78797_d = 0.0F;
        field_78121_j.func_78785_a(p_78110_1_);
    }

    public void func_78111_c(float p_78111_1_)
    {
        field_78122_k.func_78785_a(p_78111_1_);
    }
}
