// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelBlaze extends ModelBase
{

    private ModelRenderer field_78106_a[];
    private ModelRenderer field_78105_b;

    public ModelBlaze()
    {
        field_78106_a = new ModelRenderer[12];
        for(int i = 0; i < field_78106_a.length; i++)
        {
            field_78106_a[i] = new ModelRenderer(this, 0, 16);
            field_78106_a[i].func_78789_a(0.0F, 0.0F, 0.0F, 2, 8, 2);
        }

        field_78105_b = new ModelRenderer(this, 0, 0);
        field_78105_b.func_78789_a(-4F, -4F, -4F, 8, 8, 8);
    }

    public int func_78104_a()
    {
        return 8;
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78105_b.func_78785_a(p_78088_7_);
        ModelRenderer amodelrenderer[] = field_78106_a;
        int i = amodelrenderer.length;
        for(int j = 0; j < i; j++)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.func_78785_a(p_78088_7_);
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        float f = p_78087_3_ * 3.141593F * -0.1F;
        for(int i = 0; i < 4; i++)
        {
            field_78106_a[i].field_78797_d = -2F + MathHelper.func_76134_b(((float)(i * 2) + p_78087_3_) * 0.25F);
            field_78106_a[i].field_78800_c = MathHelper.func_76134_b(f) * 9F;
            field_78106_a[i].field_78798_e = MathHelper.func_76126_a(f) * 9F;
            f += 1.570796F;
        }

        f = 0.7853982F + p_78087_3_ * 3.141593F * 0.03F;
        for(int j = 4; j < 8; j++)
        {
            field_78106_a[j].field_78797_d = 2.0F + MathHelper.func_76134_b(((float)(j * 2) + p_78087_3_) * 0.25F);
            field_78106_a[j].field_78800_c = MathHelper.func_76134_b(f) * 7F;
            field_78106_a[j].field_78798_e = MathHelper.func_76126_a(f) * 7F;
            f += 1.570796F;
        }

        f = 0.4712389F + p_78087_3_ * 3.141593F * -0.05F;
        for(int k = 8; k < 12; k++)
        {
            field_78106_a[k].field_78797_d = 11F + MathHelper.func_76134_b(((float)k * 1.5F + p_78087_3_) * 0.5F);
            field_78106_a[k].field_78800_c = MathHelper.func_76134_b(f) * 5F;
            field_78106_a[k].field_78798_e = MathHelper.func_76126_a(f) * 5F;
            f += 1.570796F;
        }

        field_78105_b.field_78796_g = p_78087_4_ / 57.29578F;
        field_78105_b.field_78795_f = p_78087_5_ / 57.29578F;
    }
}
