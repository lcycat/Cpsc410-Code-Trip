// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelGhast extends ModelBase
{

    ModelRenderer field_78128_a;
    ModelRenderer field_78127_b[];

    public ModelGhast()
    {
        field_78127_b = new ModelRenderer[9];
        byte byte0 = -16;
        field_78128_a = new ModelRenderer(this, 0, 0);
        field_78128_a.func_78789_a(-8F, -8F, -8F, 16, 16, 16);
        field_78128_a.field_78797_d += 24 + byte0;
        Random random = new Random(1660L);
        for(int i = 0; i < field_78127_b.length; i++)
        {
            field_78127_b[i] = new ModelRenderer(this, 0, 0);
            float f = (((((float)(i % 3) - (float)((i / 3) % 2) * 0.5F) + 0.25F) / 2.0F) * 2.0F - 1.0F) * 5F;
            float f1 = (((float)(i / 3) / 2.0F) * 2.0F - 1.0F) * 5F;
            int j = random.nextInt(7) + 8;
            field_78127_b[i].func_78789_a(-1F, 0.0F, -1F, 2, j, 2);
            field_78127_b[i].field_78800_c = f;
            field_78127_b[i].field_78798_e = f1;
            field_78127_b[i].field_78797_d = 31 + byte0;
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        for(int i = 0; i < field_78127_b.length; i++)
        {
            field_78127_b[i].field_78795_f = 0.2F * MathHelper.func_76126_a(p_78087_3_ * 0.3F + (float)i) + 0.4F;
        }

    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.6F, 0.0F);
        field_78128_a.func_78785_a(p_78088_7_);
        ModelRenderer amodelrenderer[] = field_78127_b;
        int i = amodelrenderer.length;
        for(int j = 0; j < i; j++)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.func_78785_a(p_78088_7_);
        }

        GL11.glPopMatrix();
    }
}
