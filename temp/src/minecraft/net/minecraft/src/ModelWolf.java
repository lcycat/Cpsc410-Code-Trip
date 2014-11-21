// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityWolf, MathHelper, 
//            Entity, EntityLiving

public class ModelWolf extends ModelBase
{

    public ModelRenderer field_78185_a;
    public ModelRenderer field_78183_b;
    public ModelRenderer field_78184_c;
    public ModelRenderer field_78181_d;
    public ModelRenderer field_78182_e;
    public ModelRenderer field_78179_f;
    ModelRenderer field_78180_g;
    ModelRenderer field_78186_h;

    public ModelWolf()
    {
        float f = 0.0F;
        float f1 = 13.5F;
        field_78185_a = new ModelRenderer(this, 0, 0);
        field_78185_a.func_78790_a(-3F, -3F, -2F, 6, 6, 4, f);
        field_78185_a.func_78793_a(-1F, f1, -7F);
        field_78183_b = new ModelRenderer(this, 18, 14);
        field_78183_b.func_78790_a(-4F, -2F, -3F, 6, 9, 6, f);
        field_78183_b.func_78793_a(0.0F, 14F, 2.0F);
        field_78186_h = new ModelRenderer(this, 21, 0);
        field_78186_h.func_78790_a(-4F, -3F, -3F, 8, 6, 7, f);
        field_78186_h.func_78793_a(-1F, 14F, 2.0F);
        field_78184_c = new ModelRenderer(this, 0, 18);
        field_78184_c.func_78790_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_78184_c.func_78793_a(-2.5F, 16F, 7F);
        field_78181_d = new ModelRenderer(this, 0, 18);
        field_78181_d.func_78790_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_78181_d.func_78793_a(0.5F, 16F, 7F);
        field_78182_e = new ModelRenderer(this, 0, 18);
        field_78182_e.func_78790_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_78182_e.func_78793_a(-2.5F, 16F, -4F);
        field_78179_f = new ModelRenderer(this, 0, 18);
        field_78179_f.func_78790_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_78179_f.func_78793_a(0.5F, 16F, -4F);
        field_78180_g = new ModelRenderer(this, 9, 18);
        field_78180_g.func_78790_a(-1F, 0.0F, -1F, 2, 8, 2, f);
        field_78180_g.func_78793_a(-1F, 12F, 8F);
        field_78185_a.func_78784_a(16, 14).func_78790_a(-3F, -5F, 0.0F, 2, 2, 1, f);
        field_78185_a.func_78784_a(16, 14).func_78790_a(1.0F, -5F, 0.0F, 2, 2, 1, f);
        field_78185_a.func_78784_a(0, 10).func_78790_a(-1.5F, 0.0F, -5F, 3, 3, 4, f);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        super.func_78088_a(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        if(field_78091_s)
        {
            float f = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5F * p_78088_7_, 2.0F * p_78088_7_);
            field_78185_a.func_78791_b(p_78088_7_);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
            GL11.glTranslatef(0.0F, 24F * p_78088_7_, 0.0F);
            field_78183_b.func_78785_a(p_78088_7_);
            field_78184_c.func_78785_a(p_78088_7_);
            field_78181_d.func_78785_a(p_78088_7_);
            field_78182_e.func_78785_a(p_78088_7_);
            field_78179_f.func_78785_a(p_78088_7_);
            field_78180_g.func_78791_b(p_78088_7_);
            field_78186_h.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
        } else
        {
            field_78185_a.func_78791_b(p_78088_7_);
            field_78183_b.func_78785_a(p_78088_7_);
            field_78184_c.func_78785_a(p_78088_7_);
            field_78181_d.func_78785_a(p_78088_7_);
            field_78182_e.func_78785_a(p_78088_7_);
            field_78179_f.func_78785_a(p_78088_7_);
            field_78180_g.func_78791_b(p_78088_7_);
            field_78186_h.func_78785_a(p_78088_7_);
        }
    }

    public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityWolf entitywolf = (EntityWolf)p_78086_1_;
        if(entitywolf.func_70919_bu())
        {
            field_78180_g.field_78796_g = 0.0F;
        } else
        {
            field_78180_g.field_78796_g = MathHelper.func_76134_b(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }
        if(entitywolf.func_70906_o())
        {
            field_78186_h.func_78793_a(-1F, 16F, -3F);
            field_78186_h.field_78795_f = 1.256637F;
            field_78186_h.field_78796_g = 0.0F;
            field_78183_b.func_78793_a(0.0F, 18F, 0.0F);
            field_78183_b.field_78795_f = 0.7853982F;
            field_78180_g.func_78793_a(-1F, 21F, 6F);
            field_78184_c.func_78793_a(-2.5F, 22F, 2.0F);
            field_78184_c.field_78795_f = 4.712389F;
            field_78181_d.func_78793_a(0.5F, 22F, 2.0F);
            field_78181_d.field_78795_f = 4.712389F;
            field_78182_e.field_78795_f = 5.811947F;
            field_78182_e.func_78793_a(-2.49F, 17F, -4F);
            field_78179_f.field_78795_f = 5.811947F;
            field_78179_f.func_78793_a(0.51F, 17F, -4F);
        } else
        {
            field_78183_b.func_78793_a(0.0F, 14F, 2.0F);
            field_78183_b.field_78795_f = 1.570796F;
            field_78186_h.func_78793_a(-1F, 14F, -3F);
            field_78186_h.field_78795_f = field_78183_b.field_78795_f;
            field_78180_g.func_78793_a(-1F, 12F, 8F);
            field_78184_c.func_78793_a(-2.5F, 16F, 7F);
            field_78181_d.func_78793_a(0.5F, 16F, 7F);
            field_78182_e.func_78793_a(-2.5F, 16F, -4F);
            field_78179_f.func_78793_a(0.5F, 16F, -4F);
            field_78184_c.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
            field_78181_d.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F + 3.141593F) * 1.4F * p_78086_3_;
            field_78182_e.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F + 3.141593F) * 1.4F * p_78086_3_;
            field_78179_f.field_78795_f = MathHelper.func_76134_b(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }
        field_78185_a.field_78808_h = entitywolf.func_70917_k(p_78086_4_) + entitywolf.func_70923_f(p_78086_4_, 0.0F);
        field_78186_h.field_78808_h = entitywolf.func_70923_f(p_78086_4_, -0.08F);
        field_78183_b.field_78808_h = entitywolf.func_70923_f(p_78086_4_, -0.16F);
        field_78180_g.field_78808_h = entitywolf.func_70923_f(p_78086_4_, -0.2F);
        if(entitywolf.func_70921_u())
        {
            float f = entitywolf.func_70013_c(p_78086_4_) * entitywolf.func_70915_j(p_78086_4_);
            GL11.glColor3f(f, f, f);
        }
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
        field_78185_a.field_78795_f = p_78087_5_ / 57.29578F;
        field_78185_a.field_78796_g = p_78087_4_ / 57.29578F;
        field_78180_g.field_78795_f = p_78087_3_;
    }
}
