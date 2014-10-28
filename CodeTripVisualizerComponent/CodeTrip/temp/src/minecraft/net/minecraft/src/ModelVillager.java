// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelVillager extends ModelBase
{

    public ModelRenderer field_78191_a;
    public ModelRenderer field_78189_b;
    public ModelRenderer field_78190_c;
    public ModelRenderer field_78187_d;
    public ModelRenderer field_78188_e;

    public ModelVillager(float p_i3138_1_)
    {
        this(p_i3138_1_, 0.0F);
    }

    public ModelVillager(float p_i3139_1_, float p_i3139_2_)
    {
        byte byte0 = 64;
        byte byte1 = 64;
        field_78191_a = (new ModelRenderer(this)).func_78787_b(byte0, byte1);
        field_78191_a.func_78793_a(0.0F, 0.0F + p_i3139_2_, 0.0F);
        field_78191_a.func_78784_a(0, 0).func_78790_a(-4F, -10F, -4F, 8, 10, 8, p_i3139_1_);
        field_78191_a.func_78784_a(24, 0).func_78790_a(-1F, -3F, -6F, 2, 4, 2, p_i3139_1_);
        field_78189_b = (new ModelRenderer(this)).func_78787_b(byte0, byte1);
        field_78189_b.func_78793_a(0.0F, 0.0F + p_i3139_2_, 0.0F);
        field_78189_b.func_78784_a(16, 20).func_78790_a(-4F, 0.0F, -3F, 8, 12, 6, p_i3139_1_);
        field_78189_b.func_78784_a(0, 38).func_78790_a(-4F, 0.0F, -3F, 8, 18, 6, p_i3139_1_ + 0.5F);
        field_78190_c = (new ModelRenderer(this)).func_78787_b(byte0, byte1);
        field_78190_c.func_78793_a(0.0F, 0.0F + p_i3139_2_ + 2.0F, 0.0F);
        field_78190_c.func_78784_a(44, 22).func_78790_a(-8F, -2F, -2F, 4, 8, 4, p_i3139_1_);
        field_78190_c.func_78784_a(44, 22).func_78790_a(4F, -2F, -2F, 4, 8, 4, p_i3139_1_);
        field_78190_c.func_78784_a(40, 38).func_78790_a(-4F, 2.0F, -2F, 8, 4, 4, p_i3139_1_);
        field_78187_d = (new ModelRenderer(this, 0, 22)).func_78787_b(byte0, byte1);
        field_78187_d.func_78793_a(-2F, 12F + p_i3139_2_, 0.0F);
        field_78187_d.func_78790_a(-2F, 0.0F, -2F, 4, 12, 4, p_i3139_1_);
        field_78188_e = (new ModelRenderer(this, 0, 22)).func_78787_b(byte0, byte1);
        field_78188_e.field_78809_i = true;
        field_78188_e.func_78793_a(2.0F, 12F + p_i3139_2_, 0.0F);
        field_78188_e.func_78790_a(-2F, 0.0F, -2F, 4, 12, 4, p_i3139_1_);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78191_a.func_78785_a(p_78088_7_);
        field_78189_b.func_78785_a(p_78088_7_);
        field_78187_d.func_78785_a(p_78088_7_);
        field_78188_e.func_78785_a(p_78088_7_);
        field_78190_c.func_78785_a(p_78088_7_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78191_a.field_78796_g = p_78087_4_ / 57.29578F;
        field_78191_a.field_78795_f = p_78087_5_ / 57.29578F;
        field_78190_c.field_78797_d = 3F;
        field_78190_c.field_78798_e = -1F;
        field_78190_c.field_78795_f = -0.75F;
        field_78187_d.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_ * 0.5F;
        field_78188_e.field_78795_f = MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.141593F) * 1.4F * p_78087_2_ * 0.5F;
        field_78187_d.field_78796_g = 0.0F;
        field_78188_e.field_78796_g = 0.0F;
    }
}
