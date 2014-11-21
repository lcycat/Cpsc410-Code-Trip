// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelChicken extends ModelBase
{

    public ModelRenderer field_78142_a;
    public ModelRenderer field_78140_b;
    public ModelRenderer field_78141_c;
    public ModelRenderer field_78138_d;
    public ModelRenderer field_78139_e;
    public ModelRenderer field_78136_f;
    public ModelRenderer field_78137_g;
    public ModelRenderer field_78143_h;

    public ModelChicken()
    {
        int i = 16;
        field_78142_a = new ModelRenderer(this, 0, 0);
        field_78142_a.func_78790_a(-2F, -6F, -2F, 4, 6, 3, 0.0F);
        field_78142_a.func_78793_a(0.0F, -1 + i, -4F);
        field_78137_g = new ModelRenderer(this, 14, 0);
        field_78137_g.func_78790_a(-2F, -4F, -4F, 4, 2, 2, 0.0F);
        field_78137_g.func_78793_a(0.0F, -1 + i, -4F);
        field_78143_h = new ModelRenderer(this, 14, 4);
        field_78143_h.func_78790_a(-1F, -2F, -3F, 2, 2, 2, 0.0F);
        field_78143_h.func_78793_a(0.0F, -1 + i, -4F);
        field_78140_b = new ModelRenderer(this, 0, 9);
        field_78140_b.func_78790_a(-3F, -4F, -3F, 6, 8, 6, 0.0F);
        field_78140_b.func_78793_a(0.0F, i, 0.0F);
        field_78141_c = new ModelRenderer(this, 26, 0);
        field_78141_c.func_78789_a(-1F, 0.0F, -3F, 3, 5, 3);
        field_78141_c.func_78793_a(-2F, 3 + i, 1.0F);
        field_78138_d = new ModelRenderer(this, 26, 0);
        field_78138_d.func_78789_a(-1F, 0.0F, -3F, 3, 5, 3);
        field_78138_d.func_78793_a(1.0F, 3 + i, 1.0F);
        field_78139_e = new ModelRenderer(this, 24, 13);
        field_78139_e.func_78789_a(0.0F, 0.0F, -3F, 1, 4, 6);
        field_78139_e.func_78793_a(-4F, -3 + i, 0.0F);
        field_78136_f = new ModelRenderer(this, 24, 13);
        field_78136_f.func_78789_a(-1F, 0.0F, -3F, 1, 4, 6);
        field_78136_f.func_78793_a(4F, -3 + i, 0.0F);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        if(field_78091_s)
        {
            float f = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5F * p_78088_7_, 2.0F * p_78088_7_);
            field_78142_a.func_78785_a(p_78088_7_);
            field_78137_g.func_78785_a(p_78088_7_);
            field_78143_h.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
            GL11.glTranslatef(0.0F, 24F * p_78088_7_, 0.0F);
            field_78140_b.func_78785_a(p_78088_7_);
            field_78141_c.func_78785_a(p_78088_7_);
            field_78138_d.func_78785_a(p_78088_7_);
            field_78139_e.func_78785_a(p_78088_7_);
            field_78136_f.func_78785_a(p_78088_7_);
            GL11.glPopMatrix();
        } else
        {
            field_78142_a.func_78785_a(p_78088_7_);
            field_78137_g.func_78785_a(p_78088_7_);
            field_78143_h.func_78785_a(p_78088_7_);
            field_78140_b.func_78785_a(p_78088_7_);
            field_78141_c.func_78785_a(p_78088_7_);
            field_78138_d.func_78785_a(p_78088_7_);
            field_78139_e.func_78785_a(p_78088_7_);
            field_78136_f.func_78785_a(p_78088_7_);
        }
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78142_a.field_78795_f = -(p_78087_5_ / 57.29578F);
        field_78142_a.field_78796_g = p_78087_4_ / 57.29578F;
        field_78137_g.field_78795_f = field_78142_a.field_78795_f;
        field_78137_g.field_78796_g = field_78142_a.field_78796_g;
        field_78143_h.field_78795_f = field_78142_a.field_78795_f;
        field_78143_h.field_78796_g = field_78142_a.field_78796_g;
        field_78140_b.field_78795_f = 1.570796F;
        field_78141_c.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        field_78138_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_;
        field_78139_e.field_78808_h = p_78087_3_;
        field_78136_f.field_78808_h = -p_78087_3_;
    }
}
