// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelZombie, ModelRenderer

public class ModelSkeleton extends ModelZombie
{

    public ModelSkeleton()
    {
        float f = 0.0F;
        field_78112_f = new ModelRenderer(this, 40, 16);
        field_78112_f.func_78790_a(-1F, -2F, -1F, 2, 12, 2, f);
        field_78112_f.func_78793_a(-5F, 2.0F, 0.0F);
        field_78113_g = new ModelRenderer(this, 40, 16);
        field_78113_g.field_78809_i = true;
        field_78113_g.func_78790_a(-1F, -2F, -1F, 2, 12, 2, f);
        field_78113_g.func_78793_a(5F, 2.0F, 0.0F);
        field_78123_h = new ModelRenderer(this, 0, 16);
        field_78123_h.func_78790_a(-1F, 0.0F, -1F, 2, 12, 2, f);
        field_78123_h.func_78793_a(-2F, 12F, 0.0F);
        field_78124_i = new ModelRenderer(this, 0, 16);
        field_78124_i.field_78809_i = true;
        field_78124_i.func_78790_a(-1F, 0.0F, -1F, 2, 12, 2, f);
        field_78124_i.func_78793_a(2.0F, 12F, 0.0F);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        field_78118_o = true;
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
    }
}
