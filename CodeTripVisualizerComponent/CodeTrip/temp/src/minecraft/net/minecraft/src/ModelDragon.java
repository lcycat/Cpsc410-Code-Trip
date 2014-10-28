// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityDragon, EntityLiving, 
//            Entity

public class ModelDragon extends ModelBase
{

    private ModelRenderer field_78221_a;
    private ModelRenderer field_78219_b;
    private ModelRenderer field_78220_c;
    private ModelRenderer field_78217_d;
    private ModelRenderer field_78218_e;
    private ModelRenderer field_78215_f;
    private ModelRenderer field_78216_g;
    private ModelRenderer field_78226_h;
    private ModelRenderer field_78227_i;
    private ModelRenderer field_78224_j;
    private ModelRenderer field_78225_k;
    private ModelRenderer field_78222_l;
    private float field_78223_m;

    public ModelDragon(float p_i3143_1_)
    {
        field_78090_t = 256;
        field_78089_u = 256;
        func_78085_a("body.body", 0, 0);
        func_78085_a("wing.skin", -56, 88);
        func_78085_a("wingtip.skin", -56, 144);
        func_78085_a("rearleg.main", 0, 0);
        func_78085_a("rearfoot.main", 112, 0);
        func_78085_a("rearlegtip.main", 196, 0);
        func_78085_a("head.upperhead", 112, 30);
        func_78085_a("wing.bone", 112, 88);
        func_78085_a("head.upperlip", 176, 44);
        func_78085_a("jaw.jaw", 176, 65);
        func_78085_a("frontleg.main", 112, 104);
        func_78085_a("wingtip.bone", 112, 136);
        func_78085_a("frontfoot.main", 144, 104);
        func_78085_a("neck.box", 192, 104);
        func_78085_a("frontlegtip.main", 226, 138);
        func_78085_a("body.scale", 220, 53);
        func_78085_a("head.scale", 0, 0);
        func_78085_a("neck.scale", 48, 0);
        func_78085_a("head.nostril", 112, 0);
        float f = -16F;
        field_78221_a = new ModelRenderer(this, "head");
        field_78221_a.func_78786_a("upperlip", -6F, -1F, -8F + f, 12, 5, 16);
        field_78221_a.func_78786_a("upperhead", -8F, -8F, 6F + f, 16, 16, 16);
        field_78221_a.field_78809_i = true;
        field_78221_a.func_78786_a("scale", -5F, -12F, 12F + f, 2, 4, 6);
        field_78221_a.func_78786_a("nostril", -5F, -3F, -6F + f, 2, 2, 4);
        field_78221_a.field_78809_i = false;
        field_78221_a.func_78786_a("scale", 3F, -12F, 12F + f, 2, 4, 6);
        field_78221_a.func_78786_a("nostril", 3F, -3F, -6F + f, 2, 2, 4);
        field_78220_c = new ModelRenderer(this, "jaw");
        field_78220_c.func_78793_a(0.0F, 4F, 8F + f);
        field_78220_c.func_78786_a("jaw", -6F, 0.0F, -16F, 12, 4, 16);
        field_78221_a.func_78792_a(field_78220_c);
        field_78219_b = new ModelRenderer(this, "neck");
        field_78219_b.func_78786_a("box", -5F, -5F, -5F, 10, 10, 10);
        field_78219_b.func_78786_a("scale", -1F, -9F, -3F, 2, 4, 6);
        field_78217_d = new ModelRenderer(this, "body");
        field_78217_d.func_78793_a(0.0F, 4F, 8F);
        field_78217_d.func_78786_a("body", -12F, 0.0F, -16F, 24, 24, 64);
        field_78217_d.func_78786_a("scale", -1F, -6F, -10F, 2, 6, 12);
        field_78217_d.func_78786_a("scale", -1F, -6F, 10F, 2, 6, 12);
        field_78217_d.func_78786_a("scale", -1F, -6F, 30F, 2, 6, 12);
        field_78225_k = new ModelRenderer(this, "wing");
        field_78225_k.func_78793_a(-12F, 5F, 2.0F);
        field_78225_k.func_78786_a("bone", -56F, -4F, -4F, 56, 8, 8);
        field_78225_k.func_78786_a("skin", -56F, 0.0F, 2.0F, 56, 0, 56);
        field_78222_l = new ModelRenderer(this, "wingtip");
        field_78222_l.func_78793_a(-56F, 0.0F, 0.0F);
        field_78222_l.func_78786_a("bone", -56F, -2F, -2F, 56, 4, 4);
        field_78222_l.func_78786_a("skin", -56F, 0.0F, 2.0F, 56, 0, 56);
        field_78225_k.func_78792_a(field_78222_l);
        field_78215_f = new ModelRenderer(this, "frontleg");
        field_78215_f.func_78793_a(-12F, 20F, 2.0F);
        field_78215_f.func_78786_a("main", -4F, -4F, -4F, 8, 24, 8);
        field_78226_h = new ModelRenderer(this, "frontlegtip");
        field_78226_h.func_78793_a(0.0F, 20F, -1F);
        field_78226_h.func_78786_a("main", -3F, -1F, -3F, 6, 24, 6);
        field_78215_f.func_78792_a(field_78226_h);
        field_78224_j = new ModelRenderer(this, "frontfoot");
        field_78224_j.func_78793_a(0.0F, 23F, 0.0F);
        field_78224_j.func_78786_a("main", -4F, 0.0F, -12F, 8, 4, 16);
        field_78226_h.func_78792_a(field_78224_j);
        field_78218_e = new ModelRenderer(this, "rearleg");
        field_78218_e.func_78793_a(-16F, 16F, 42F);
        field_78218_e.func_78786_a("main", -8F, -4F, -8F, 16, 32, 16);
        field_78216_g = new ModelRenderer(this, "rearlegtip");
        field_78216_g.func_78793_a(0.0F, 32F, -4F);
        field_78216_g.func_78786_a("main", -6F, -2F, 0.0F, 12, 32, 12);
        field_78218_e.func_78792_a(field_78216_g);
        field_78227_i = new ModelRenderer(this, "rearfoot");
        field_78227_i.func_78793_a(0.0F, 31F, 4F);
        field_78227_i.func_78786_a("main", -9F, 0.0F, -20F, 18, 6, 24);
        field_78216_g.func_78792_a(field_78227_i);
    }

    public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        field_78223_m = p_78086_4_;
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        GL11.glPushMatrix();
        EntityDragon entitydragon = (EntityDragon)p_78088_1_;
        float f = entitydragon.field_70991_bC + (entitydragon.field_70988_bD - entitydragon.field_70991_bC) * field_78223_m;
        field_78220_c.field_78795_f = (float)(Math.sin(f * 3.141593F * 2.0F) + 1.0D) * 0.2F;
        float f1 = (float)(Math.sin(f * 3.141593F * 2.0F - 1.0F) + 1.0D);
        f1 = (f1 * f1 * 1.0F + f1 * 2.0F) * 0.05F;
        GL11.glTranslatef(0.0F, f1 - 2.0F, -3F);
        GL11.glRotatef(f1 * 2.0F, 1.0F, 0.0F, 0.0F);
        float f2 = -30F;
        float f4 = 0.0F;
        float f5 = 1.5F;
        double ad[] = entitydragon.func_70974_a(6, field_78223_m);
        float f6 = func_78214_a(entitydragon.func_70974_a(5, field_78223_m)[0] - entitydragon.func_70974_a(10, field_78223_m)[0]);
        float f7 = func_78214_a(entitydragon.func_70974_a(5, field_78223_m)[0] + (double)(f6 / 2.0F));
        f2 += 2.0F;
        float f8 = f * 3.141593F * 2.0F;
        f2 = 20F;
        float f3 = -12F;
        for(int i = 0; i < 5; i++)
        {
            double ad3[] = entitydragon.func_70974_a(5 - i, field_78223_m);
            float f10 = (float)Math.cos((float)i * 0.45F + f8) * 0.15F;
            field_78219_b.field_78796_g = ((func_78214_a(ad3[0] - ad[0]) * 3.141593F) / 180F) * f5;
            field_78219_b.field_78795_f = f10 + (((float)(ad3[1] - ad[1]) * 3.141593F) / 180F) * f5 * 5F;
            field_78219_b.field_78808_h = ((-func_78214_a(ad3[0] - (double)f7) * 3.141593F) / 180F) * f5;
            field_78219_b.field_78797_d = f2;
            field_78219_b.field_78798_e = f3;
            field_78219_b.field_78800_c = f4;
            f2 = (float)((double)f2 + Math.sin(field_78219_b.field_78795_f) * 10D);
            f3 = (float)((double)f3 - Math.cos(field_78219_b.field_78796_g) * Math.cos(field_78219_b.field_78795_f) * 10D);
            f4 = (float)((double)f4 - Math.sin(field_78219_b.field_78796_g) * Math.cos(field_78219_b.field_78795_f) * 10D);
            field_78219_b.func_78785_a(p_78088_7_);
        }

        field_78221_a.field_78797_d = f2;
        field_78221_a.field_78798_e = f3;
        field_78221_a.field_78800_c = f4;
        double ad1[] = entitydragon.func_70974_a(0, field_78223_m);
        field_78221_a.field_78796_g = ((func_78214_a(ad1[0] - ad[0]) * 3.141593F) / 180F) * 1.0F;
        field_78221_a.field_78808_h = ((-func_78214_a(ad1[0] - (double)f7) * 3.141593F) / 180F) * 1.0F;
        field_78221_a.func_78785_a(p_78088_7_);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-f6 * f5 * 1.0F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(0.0F, -1F, 0.0F);
        field_78217_d.field_78808_h = 0.0F;
        field_78217_d.func_78785_a(p_78088_7_);
        for(int j = 0; j < 2; j++)
        {
            GL11.glEnable(2884);
            float f11 = f * 3.141593F * 2.0F;
            field_78225_k.field_78795_f = 0.125F - (float)Math.cos(f11) * 0.2F;
            field_78225_k.field_78796_g = 0.25F;
            field_78225_k.field_78808_h = (float)(Math.sin(f11) + 0.125D) * 0.8F;
            field_78222_l.field_78808_h = -(float)(Math.sin(f11 + 2.0F) + 0.5D) * 0.75F;
            field_78218_e.field_78795_f = 1.0F + f1 * 0.1F;
            field_78216_g.field_78795_f = 0.5F + f1 * 0.1F;
            field_78227_i.field_78795_f = 0.75F + f1 * 0.1F;
            field_78215_f.field_78795_f = 1.3F + f1 * 0.1F;
            field_78226_h.field_78795_f = -0.5F - f1 * 0.1F;
            field_78224_j.field_78795_f = 0.75F + f1 * 0.1F;
            field_78225_k.func_78785_a(p_78088_7_);
            field_78215_f.func_78785_a(p_78088_7_);
            field_78218_e.func_78785_a(p_78088_7_);
            GL11.glScalef(-1F, 1.0F, 1.0F);
            if(j == 0)
            {
                GL11.glCullFace(1028);
            }
        }

        GL11.glPopMatrix();
        GL11.glCullFace(1029);
        GL11.glDisable(2884);
        float f9 = -(float)Math.sin(f * 3.141593F * 2.0F) * 0.0F;
        f8 = f * 3.141593F * 2.0F;
        f2 = 10F;
        f3 = 60F;
        f4 = 0.0F;
        ad = entitydragon.func_70974_a(11, field_78223_m);
        for(int k = 0; k < 12; k++)
        {
            double ad2[] = entitydragon.func_70974_a(12 + k, field_78223_m);
            f9 = (float)((double)f9 + Math.sin((float)k * 0.45F + f8) * 0.05000000074505806D);
            field_78219_b.field_78796_g = ((func_78214_a(ad2[0] - ad[0]) * f5 + 180F) * 3.141593F) / 180F;
            field_78219_b.field_78795_f = f9 + (((float)(ad2[1] - ad[1]) * 3.141593F) / 180F) * f5 * 5F;
            field_78219_b.field_78808_h = ((func_78214_a(ad2[0] - (double)f7) * 3.141593F) / 180F) * f5;
            field_78219_b.field_78797_d = f2;
            field_78219_b.field_78798_e = f3;
            field_78219_b.field_78800_c = f4;
            f2 = (float)((double)f2 + Math.sin(field_78219_b.field_78795_f) * 10D);
            f3 = (float)((double)f3 - Math.cos(field_78219_b.field_78796_g) * Math.cos(field_78219_b.field_78795_f) * 10D);
            f4 = (float)((double)f4 - Math.sin(field_78219_b.field_78796_g) * Math.cos(field_78219_b.field_78795_f) * 10D);
            field_78219_b.func_78785_a(p_78088_7_);
        }

        GL11.glPopMatrix();
    }

    private float func_78214_a(double p_78214_1_)
    {
        for(; p_78214_1_ >= 180D; p_78214_1_ -= 360D) { }
        for(; p_78214_1_ < -180D; p_78214_1_ += 360D) { }
        return (float)p_78214_1_;
    }
}
