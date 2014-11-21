// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelSquid extends ModelBase
{

    ModelRenderer field_78202_a;
    ModelRenderer field_78201_b[];

    public ModelSquid()
    {
        field_78201_b = new ModelRenderer[8];
        byte byte0 = -16;
        field_78202_a = new ModelRenderer(this, 0, 0);
        field_78202_a.func_78789_a(-6F, -8F, -6F, 12, 16, 12);
        field_78202_a.field_78797_d += 24 + byte0;
        for(int i = 0; i < field_78201_b.length; i++)
        {
            field_78201_b[i] = new ModelRenderer(this, 48, 0);
            double d = ((double)i * 3.1415926535897931D * 2D) / (double)field_78201_b.length;
            float f = (float)Math.cos(d) * 5F;
            float f1 = (float)Math.sin(d) * 5F;
            field_78201_b[i].func_78789_a(-1F, 0.0F, -1F, 2, 18, 2);
            field_78201_b[i].field_78800_c = f;
            field_78201_b[i].field_78798_e = f1;
            field_78201_b[i].field_78797_d = 31 + byte0;
            d = ((double)i * 3.1415926535897931D * -2D) / (double)field_78201_b.length + 1.5707963267948966D;
            field_78201_b[i].field_78796_g = (float)d;
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        ModelRenderer amodelrenderer[] = field_78201_b;
        int i = amodelrenderer.length;
        for(int j = 0; j < i; j++)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.field_78795_f = p_78087_3_;
        }

    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78202_a.func_78785_a(p_78088_7_);
        ModelRenderer amodelrenderer[] = field_78201_b;
        int i = amodelrenderer.length;
        for(int j = 0; j < i; j++)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.func_78785_a(p_78088_7_);
        }

    }
}
