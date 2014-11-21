// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, EntityOcelot, 
//            Entity, EntityLiving

public class ModelOcelot extends ModelBase
{

    ModelRenderer field_78161_a;
    ModelRenderer field_78159_b;
    ModelRenderer field_78160_c;
    ModelRenderer field_78157_d;
    ModelRenderer field_78158_e;
    ModelRenderer field_78155_f;
    ModelRenderer field_78156_g;
    ModelRenderer field_78162_h;
    int field_78163_i;

    public ModelOcelot()
    {
        field_78163_i = 1;
        func_78085_a("head.main", 0, 0);
        func_78085_a("head.nose", 0, 24);
        func_78085_a("head.ear1", 0, 10);
        func_78085_a("head.ear2", 6, 10);
        field_78156_g = new ModelRenderer(this, "head");
        field_78156_g.func_78786_a("main", -2.5F, -2F, -3F, 5, 4, 5);
        field_78156_g.func_78786_a("nose", -1.5F, 0.0F, -4F, 3, 2, 2);
        field_78156_g.func_78786_a("ear1", -2F, -3F, 0.0F, 1, 1, 2);
        field_78156_g.func_78786_a("ear2", 1.0F, -3F, 0.0F, 1, 1, 2);
        field_78156_g.func_78793_a(0.0F, 15F, -9F);
        field_78162_h = new ModelRenderer(this, 20, 0);
        field_78162_h.func_78790_a(-2F, 3F, -8F, 4, 16, 6, 0.0F);
        field_78162_h.func_78793_a(0.0F, 12F, -10F);
        field_78158_e = new ModelRenderer(this, 0, 15);
        field_78158_e.func_78789_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
        field_78158_e.field_78795_f = 0.9F;
        field_78158_e.func_78793_a(0.0F, 15F, 8F);
        field_78155_f = new ModelRenderer(this, 4, 15);
        field_78155_f.func_78789_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
        field_78155_f.func_78793_a(0.0F, 20F, 14F);
        field_78161_a = new ModelRenderer(this, 8, 13);
        field_78161_a.func_78789_a(-1F, 0.0F, 1.0F, 2, 6, 2);
        field_78161_a.func_78793_a(1.1F, 18F, 5F);
        field_78159_b = new ModelRenderer(this, 8, 13);
        field_78159_b.func_78789_a(-1F, 0.0F, 1.0F, 2, 6, 2);
        field_78159_b.func_78793_a(-1.1F, 18F, 5F);
        field_78160_c = new ModelRenderer(this, 40, 0);
        field_78160_c.func_78789_a(-1F, 0.0F, 0.0F, 2, 10, 2);
        field_78160_c.func_78793_a(1.2F, 13.8F, -5F);
        field_78157_d = new ModelRenderer(this, 40, 0);
        field_78157_d.func_78789_a(-1F, 0.0F, 0.0F, 2, 10, 2);
        field_78157_d.func_78793_a(-1.2F, 13.8F, -5F);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        if(field_78091_s)
        {
            float f = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / f, 1.5F / f, 1.5F / f);
            GL11.glTranslatef(0.0F, 10F * p_78088_7_, 4F * p_78088_7_);
            field_78156_g.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
            GL11.glTranslatef(0.0F, 24F * p_78088_7_, 0.0F);
            field_78162_h.func_78785_a(p_78088_7_);
            field_78161_a.func_78785_a(p_78088_7_);
            field_78159_b.func_78785_a(p_78088_7_);
            field_78160_c.func_78785_a(p_78088_7_);
            field_78157_d.func_78785_a(p_78088_7_);
            field_78158_e.func_78785_a(p_78088_7_);
            field_78155_f.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
        } else
        {
            field_78156_g.func_78785_a(p_78088_7_);
            field_78162_h.func_78785_a(p_78088_7_);
            field_78158_e.func_78785_a(p_78088_7_);
            field_78155_f.func_78785_a(p_78088_7_);
            field_78161_a.func_78785_a(p_78088_7_);
            field_78159_b.func_78785_a(p_78088_7_);
            field_78160_c.func_78785_a(p_78088_7_);
            field_78157_d.func_78785_a(p_78088_7_);
        }
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78156_g.field_78795_f = p_78087_5_ / 57.29578F;
        field_78156_g.field_78796_g = p_78087_4_ / 57.29578F;
        if(field_78163_i != 3)
        {
            field_78162_h.field_78795_f = 1.570796F;
            if(field_78163_i == 2)
            {
                field_78161_a.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
                field_78159_b.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 0.3F) * 1.0F * p_78087_2_;
                field_78160_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F + 0.3F) * 1.0F * p_78087_2_;
                field_78157_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.0F * p_78087_2_;
                field_78155_f.field_78795_f = 1.727876F + 0.3141593F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
            } else
            {
                field_78161_a.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
                field_78159_b.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.0F * p_78087_2_;
                field_78160_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.0F * p_78087_2_;
                field_78157_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.0F * p_78087_2_;
                if(field_78163_i == 1)
                {
                    field_78155_f.field_78795_f = 1.727876F + 0.7853982F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
                } else
                {
                    field_78155_f.field_78795_f = 1.727876F + 0.4712389F * MathHelper.func_76134_b(p_78087_1_) * p_78087_2_;
                }
            }
        }
    }

    public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityOcelot entityocelot = (EntityOcelot)p_78086_1_;
        field_78162_h.field_78797_d = 12F;
        field_78162_h.field_78798_e = -10F;
        field_78156_g.field_78797_d = 15F;
        field_78156_g.field_78798_e = -9F;
        field_78158_e.field_78797_d = 15F;
        field_78158_e.field_78798_e = 8F;
        field_78155_f.field_78797_d = 20F;
        field_78155_f.field_78798_e = 14F;
        field_78160_c.field_78797_d = field_78157_d.field_78797_d = 13.8F;
        field_78160_c.field_78798_e = field_78157_d.field_78798_e = -5F;
        field_78161_a.field_78797_d = field_78159_b.field_78797_d = 18F;
        field_78161_a.field_78798_e = field_78159_b.field_78798_e = 5F;
        field_78158_e.field_78795_f = 0.9F;
        if(entityocelot.func_70093_af())
        {
            field_78162_h.field_78797_d++;
            field_78156_g.field_78797_d += 2.0F;
            field_78158_e.field_78797_d++;
            field_78155_f.field_78797_d += -4F;
            field_78155_f.field_78798_e += 2.0F;
            field_78158_e.field_78795_f = 1.570796F;
            field_78155_f.field_78795_f = 1.570796F;
            field_78163_i = 0;
        } else
        if(entityocelot.func_70051_ag())
        {
            field_78155_f.field_78797_d = field_78158_e.field_78797_d;
            field_78155_f.field_78798_e += 2.0F;
            field_78158_e.field_78795_f = 1.570796F;
            field_78155_f.field_78795_f = 1.570796F;
            field_78163_i = 2;
        } else
        if(entityocelot.func_70906_o())
        {
            field_78162_h.field_78795_f = 0.7853982F;
            field_78162_h.field_78797_d += -4F;
            field_78162_h.field_78798_e += 5F;
            field_78156_g.field_78797_d += -3.3F;
            field_78156_g.field_78798_e++;
            field_78158_e.field_78797_d += 8F;
            field_78158_e.field_78798_e += -2F;
            field_78155_f.field_78797_d += 2.0F;
            field_78155_f.field_78798_e += -0.8F;
            field_78158_e.field_78795_f = 1.727876F;
            field_78155_f.field_78795_f = 2.670354F;
            field_78160_c.field_78795_f = field_78157_d.field_78795_f = -0.1570796F;
            field_78160_c.field_78797_d = field_78157_d.field_78797_d = 15.8F;
            field_78160_c.field_78798_e = field_78157_d.field_78798_e = -7F;
            field_78161_a.field_78795_f = field_78159_b.field_78795_f = -1.570796F;
            field_78161_a.field_78797_d = field_78159_b.field_78797_d = 21F;
            field_78161_a.field_78798_e = field_78159_b.field_78798_e = 1.0F;
            field_78163_i = 3;
        } else
        {
            field_78163_i = 1;
        }
    }
}
