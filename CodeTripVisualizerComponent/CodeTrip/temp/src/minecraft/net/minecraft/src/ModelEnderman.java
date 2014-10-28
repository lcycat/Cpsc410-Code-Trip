// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBiped, ModelRenderer

public class ModelEnderman extends ModelBiped
{

    public boolean field_78126_a;
    public boolean field_78125_b;

    public ModelEnderman()
    {
        super(0.0F, -14F);
        field_78126_a = false;
        field_78125_b = false;
        float f = -14F;
        float f1 = 0.0F;
        field_78114_d = new ModelRenderer(this, 0, 16);
        field_78114_d.func_78790_a(-4F, -8F, -4F, 8, 8, 8, f1 - 0.5F);
        field_78114_d.func_78793_a(0.0F, 0.0F + f, 0.0F);
        field_78115_e = new ModelRenderer(this, 32, 16);
        field_78115_e.func_78790_a(-4F, 0.0F, -2F, 8, 12, 4, f1);
        field_78115_e.func_78793_a(0.0F, 0.0F + f, 0.0F);
        field_78112_f = new ModelRenderer(this, 56, 0);
        field_78112_f.func_78790_a(-1F, -2F, -1F, 2, 30, 2, f1);
        field_78112_f.func_78793_a(-3F, 2.0F + f, 0.0F);
        field_78113_g = new ModelRenderer(this, 56, 0);
        field_78113_g.field_78809_i = true;
        field_78113_g.func_78790_a(-1F, -2F, -1F, 2, 30, 2, f1);
        field_78113_g.func_78793_a(5F, 2.0F + f, 0.0F);
        field_78123_h = new ModelRenderer(this, 56, 0);
        field_78123_h.func_78790_a(-1F, 0.0F, -1F, 2, 30, 2, f1);
        field_78123_h.func_78793_a(-2F, 12F + f, 0.0F);
        field_78124_i = new ModelRenderer(this, 56, 0);
        field_78124_i.field_78809_i = true;
        field_78124_i.func_78790_a(-1F, 0.0F, -1F, 2, 30, 2, f1);
        field_78124_i.func_78793_a(2.0F, 12F + f, 0.0F);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
        field_78116_c.field_78806_j = true;
        float f = -14F;
        field_78115_e.field_78795_f = 0.0F;
        field_78115_e.field_78797_d = f;
        field_78115_e.field_78798_e = -0F;
        field_78123_h.field_78795_f -= 0.0F;
        field_78124_i.field_78795_f -= 0.0F;
        field_78112_f.field_78795_f *= 0.5D;
        field_78113_g.field_78795_f *= 0.5D;
        field_78123_h.field_78795_f *= 0.5D;
        field_78124_i.field_78795_f *= 0.5D;
        float f1 = 0.4F;
        if(field_78112_f.field_78795_f > f1)
        {
            field_78112_f.field_78795_f = f1;
        }
        if(field_78113_g.field_78795_f > f1)
        {
            field_78113_g.field_78795_f = f1;
        }
        if(field_78112_f.field_78795_f < -f1)
        {
            field_78112_f.field_78795_f = -f1;
        }
        if(field_78113_g.field_78795_f < -f1)
        {
            field_78113_g.field_78795_f = -f1;
        }
        if(field_78123_h.field_78795_f > f1)
        {
            field_78123_h.field_78795_f = f1;
        }
        if(field_78124_i.field_78795_f > f1)
        {
            field_78124_i.field_78795_f = f1;
        }
        if(field_78123_h.field_78795_f < -f1)
        {
            field_78123_h.field_78795_f = -f1;
        }
        if(field_78124_i.field_78795_f < -f1)
        {
            field_78124_i.field_78795_f = -f1;
        }
        if(field_78126_a)
        {
            field_78112_f.field_78795_f = -0.5F;
            field_78113_g.field_78795_f = -0.5F;
            field_78112_f.field_78808_h = 0.05F;
            field_78113_g.field_78808_h = -0.05F;
        }
        field_78112_f.field_78798_e = 0.0F;
        field_78113_g.field_78798_e = 0.0F;
        field_78123_h.field_78798_e = 0.0F;
        field_78124_i.field_78798_e = 0.0F;
        field_78123_h.field_78797_d = 9F + f;
        field_78124_i.field_78797_d = 9F + f;
        field_78116_c.field_78798_e = -0F;
        field_78116_c.field_78797_d = f + 1.0F;
        field_78114_d.field_78800_c = field_78116_c.field_78800_c;
        field_78114_d.field_78797_d = field_78116_c.field_78797_d;
        field_78114_d.field_78798_e = field_78116_c.field_78798_e;
        field_78114_d.field_78795_f = field_78116_c.field_78795_f;
        field_78114_d.field_78796_g = field_78116_c.field_78796_g;
        field_78114_d.field_78808_h = field_78116_c.field_78808_h;
        if(field_78125_b)
        {
            float f2 = 1.0F;
            field_78116_c.field_78797_d -= f2 * 5F;
        }
    }
}
