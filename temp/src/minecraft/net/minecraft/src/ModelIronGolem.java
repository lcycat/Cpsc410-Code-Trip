// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityIronGolem, Entity, 
//            EntityLiving

public class ModelIronGolem extends ModelBase
{

    public ModelRenderer field_78178_a;
    public ModelRenderer field_78176_b;
    public ModelRenderer field_78177_c;
    public ModelRenderer field_78174_d;
    public ModelRenderer field_78175_e;
    public ModelRenderer field_78173_f;

    public ModelIronGolem()
    {
        this(0.0F);
    }

    public ModelIronGolem(float p_i3130_1_)
    {
        this(p_i3130_1_, -7F);
    }

    public ModelIronGolem(float p_i3131_1_, float p_i3131_2_)
    {
        char c = '\200';
        char c1 = '\200';
        field_78178_a = (new ModelRenderer(this)).func_78787_b(c, c1);
        field_78178_a.func_78793_a(0.0F, 0.0F + p_i3131_2_, -2F);
        field_78178_a.func_78784_a(0, 0).func_78790_a(-4F, -12F, -5.5F, 8, 10, 8, p_i3131_1_);
        field_78178_a.func_78784_a(24, 0).func_78790_a(-1F, -5F, -7.5F, 2, 4, 2, p_i3131_1_);
        field_78176_b = (new ModelRenderer(this)).func_78787_b(c, c1);
        field_78176_b.func_78793_a(0.0F, 0.0F + p_i3131_2_, 0.0F);
        field_78176_b.func_78784_a(0, 40).func_78790_a(-9F, -2F, -6F, 18, 12, 11, p_i3131_1_);
        field_78176_b.func_78784_a(0, 70).func_78790_a(-4.5F, 10F, -3F, 9, 5, 6, p_i3131_1_ + 0.5F);
        field_78177_c = (new ModelRenderer(this)).func_78787_b(c, c1);
        field_78177_c.func_78793_a(0.0F, -7F, 0.0F);
        field_78177_c.func_78784_a(60, 21).func_78790_a(-13F, -2.5F, -3F, 4, 30, 6, p_i3131_1_);
        field_78174_d = (new ModelRenderer(this)).func_78787_b(c, c1);
        field_78174_d.func_78793_a(0.0F, -7F, 0.0F);
        field_78174_d.func_78784_a(60, 58).func_78790_a(9F, -2.5F, -3F, 4, 30, 6, p_i3131_1_);
        field_78175_e = (new ModelRenderer(this, 0, 22)).func_78787_b(c, c1);
        field_78175_e.func_78793_a(-4F, 18F + p_i3131_2_, 0.0F);
        field_78175_e.func_78784_a(37, 0).func_78790_a(-3.5F, -3F, -3F, 6, 16, 5, p_i3131_1_);
        field_78173_f = (new ModelRenderer(this, 0, 22)).func_78787_b(c, c1);
        field_78173_f.field_78809_i = true;
        field_78173_f.func_78784_a(60, 0).func_78793_a(5F, 18F + p_i3131_2_, 0.0F);
        field_78173_f.func_78790_a(-3.5F, -3F, -3F, 6, 16, 5, p_i3131_1_);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78178_a.func_78785_a(p_78088_7_);
        field_78176_b.func_78785_a(p_78088_7_);
        field_78175_e.func_78785_a(p_78088_7_);
        field_78173_f.func_78785_a(p_78088_7_);
        field_78177_c.func_78785_a(p_78088_7_);
        field_78174_d.func_78785_a(p_78088_7_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78178_a.field_78796_g = p_78087_4_ / 57.29578F;
        field_78178_a.field_78795_f = p_78087_5_ / 57.29578F;
        field_78175_e.field_78795_f = -1.5F * func_78172_a(p_78087_1_, 13F) * p_78087_2_;
        field_78173_f.field_78795_f = 1.5F * func_78172_a(p_78087_1_, 13F) * p_78087_2_;
        field_78175_e.field_78796_g = 0.0F;
        field_78173_f.field_78796_g = 0.0F;
    }

    public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityIronGolem entityirongolem = (EntityIronGolem)p_78086_1_;
        int i = entityirongolem.func_70854_o();
        if(i > 0)
        {
            field_78177_c.field_78795_f = -2F + 1.5F * func_78172_a((float)i - p_78086_4_, 10F);
            field_78174_d.field_78795_f = -2F + 1.5F * func_78172_a((float)i - p_78086_4_, 10F);
        } else
        {
            int j = entityirongolem.func_70853_p();
            if(j > 0)
            {
                field_78177_c.field_78795_f = -0.8F + 0.025F * func_78172_a(j, 70F);
                field_78174_d.field_78795_f = 0.0F;
            } else
            {
                field_78177_c.field_78795_f = (-0.2F + 1.5F * func_78172_a(p_78086_2_, 13F)) * p_78086_3_;
                field_78174_d.field_78795_f = (-0.2F - 1.5F * func_78172_a(p_78086_2_, 13F)) * p_78086_3_;
            }
        }
    }

    private float func_78172_a(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
