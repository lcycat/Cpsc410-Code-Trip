// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelQuadruped, ModelRenderer, EntitySheep, EntityLiving

public class ModelSheep2 extends ModelQuadruped
{

    private float field_78153_i;

    public ModelSheep2()
    {
        super(12, 0.0F);
        field_78150_a = new ModelRenderer(this, 0, 0);
        field_78150_a.func_78790_a(-3F, -4F, -6F, 6, 6, 8, 0.0F);
        field_78150_a.func_78793_a(0.0F, 6F, -8F);
        field_78148_b = new ModelRenderer(this, 28, 8);
        field_78148_b.func_78790_a(-4F, -10F, -7F, 8, 16, 6, 0.0F);
        field_78148_b.func_78793_a(0.0F, 5F, 2.0F);
    }

    public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        super.func_78086_a(p_78086_1_, p_78086_2_, p_78086_3_, p_78086_4_);
        field_78150_a.field_78797_d = 6F + ((EntitySheep)p_78086_1_).func_70894_j(p_78086_4_) * 9F;
        field_78153_i = ((EntitySheep)p_78086_1_).func_70890_k(p_78086_4_);
    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_);
        field_78150_a.field_78795_f = field_78153_i;
    }
}
