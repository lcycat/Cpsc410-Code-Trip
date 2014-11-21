// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelQuadruped extends ModelBase
{

    public ModelRenderer field_78150_a;
    public ModelRenderer field_78148_b;
    public ModelRenderer field_78149_c;
    public ModelRenderer field_78146_d;
    public ModelRenderer field_78147_e;
    public ModelRenderer field_78144_f;
    protected float field_78145_g;
    protected float field_78151_h;

    public ModelQuadruped(int p_i3129_1_, float p_i3129_2_)
    {
        field_78145_g = 8F;
        field_78151_h = 4F;
        field_78150_a = new ModelRenderer(this, 0, 0);
        field_78150_a.func_78790_a(-4F, -4F, -8F, 8, 8, 8, p_i3129_2_);
        field_78150_a.func_78793_a(0.0F, 18 - p_i3129_1_, -6F);
        field_78148_b = new ModelRenderer(this, 28, 8);
        field_78148_b.func_78790_a(-5F, -10F, -7F, 10, 16, 8, p_i3129_2_);
        field_78148_b.func_78793_a(0.0F, 17 - p_i3129_1_, 2.0F);
        field_78149_c = new ModelRenderer(this, 0, 16);
        field_78149_c.func_78790_a(-2F, 0.0F, -2F, 4, p_i3129_1_, 4, p_i3129_2_);
        field_78149_c.func_78793_a(-3F, 24 - p_i3129_1_, 7F);
        field_78146_d = new ModelRenderer(this, 0, 16);
        field_78146_d.func_78790_a(-2F, 0.0F, -2F, 4, p_i3129_1_, 4, p_i3129_2_);
        field_78146_d.func_78793_a(3F, 24 - p_i3129_1_, 7F);
        field_78147_e = new ModelRenderer(this, 0, 16);
        field_78147_e.func_78790_a(-2F, 0.0F, -2F, 4, p_i3129_1_, 4, p_i3129_2_);
        field_78147_e.func_78793_a(-3F, 24 - p_i3129_1_, -5F);
        field_78144_f = new ModelRenderer(this, 0, 16);
        field_78144_f.func_78790_a(-2F, 0.0F, -2F, 4, p_i3129_1_, 4, p_i3129_2_);
        field_78144_f.func_78793_a(3F, 24 - p_i3129_1_, -5F);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        if(field_78091_s)
        {
            float f = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, field_78145_g * p_78088_7_, field_78151_h * p_78088_7_);
            field_78150_a.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
            GL11.glTranslatef(0.0F, 24F * p_78088_7_, 0.0F);
            field_78148_b.func_78785_a(p_78088_7_);
            field_78149_c.func_78785_a(p_78088_7_);
            field_78146_d.func_78785_a(p_78088_7_);
            field_78147_e.func_78785_a(p_78088_7_);
            field_78144_f.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
        } else
        {
            field_78150_a.func_78785_a(p_78088_7_);
            field_78148_b.func_78785_a(p_78088_7_);
            field_78149_c.func_78785_a(p_78088_7_);
            field_78146_d.func_78785_a(p_78088_7_);
            field_78147_e.func_78785_a(p_78088_7_);
            field_78144_f.func_78785_a(p_78088_7_);
        }
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78150_a.field_78795_f = p_78087_5_ / 57.29578F;
        field_78150_a.field_78796_g = p_78087_4_ / 57.29578F;
        field_78148_b.field_78795_f = 1.570796F;
        field_78149_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        field_78146_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_;
        field_78147_e.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_;
        field_78144_f.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
    }
}
