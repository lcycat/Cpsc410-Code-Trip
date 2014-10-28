// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, EntityMagmaCube, EntityLiving, 
//            Entity

public class ModelMagmaCube extends ModelBase
{

    ModelRenderer field_78109_a[];
    ModelRenderer field_78108_b;

    public ModelMagmaCube()
    {
        field_78109_a = new ModelRenderer[8];
        for(int i = 0; i < field_78109_a.length; i++)
        {
            byte byte0 = 0;
            int j = i;
            if(i == 2)
            {
                byte0 = 24;
                j = 10;
            } else
            if(i == 3)
            {
                byte0 = 24;
                j = 19;
            }
            field_78109_a[i] = new ModelRenderer(this, byte0, j);
            field_78109_a[i].func_78789_a(-4F, 16 + i, -4F, 8, 1, 8);
        }

        field_78108_b = new ModelRenderer(this, 0, 16);
        field_78108_b.func_78789_a(-2F, 18F, -2F, 4, 4, 4);
    }

    public int func_78107_a()
    {
        return 5;
    }

    public void func_78086_a(EntityLiving p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityMagmaCube entitymagmacube = (EntityMagmaCube)p_78086_1_;
        float f = entitymagmacube.field_70812_c + (entitymagmacube.field_70811_b - entitymagmacube.field_70812_c) * p_78086_4_;
        if(f < 0.0F)
        {
            f = 0.0F;
        }
        for(int i = 0; i < field_78109_a.length; i++)
        {
            field_78109_a[i].field_78797_d = (float)(-(4 - i)) * f * 1.7F;
        }

    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        field_78108_b.func_78785_a(p_78088_7_);
        ModelRenderer amodelrenderer[] = field_78109_a;
        int i = amodelrenderer.length;
        for(int j = 0; j < i; j++)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.func_78785_a(p_78088_7_);
        }

    }
}
