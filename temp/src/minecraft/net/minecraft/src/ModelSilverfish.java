// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, MathHelper, Entity

public class ModelSilverfish extends ModelBase
{

    private ModelRenderer field_78171_a[];
    private ModelRenderer field_78169_b[];
    private float field_78170_c[];
    private static final int field_78167_d[][] = {
        {
            3, 2, 2
        }, {
            4, 3, 2
        }, {
            6, 4, 3
        }, {
            3, 3, 3
        }, {
            2, 2, 3
        }, {
            2, 1, 2
        }, {
            1, 1, 2
        }
    };
    private static final int field_78168_e[][] = {
        {
            0, 0
        }, {
            0, 4
        }, {
            0, 9
        }, {
            0, 16
        }, {
            0, 22
        }, {
            11, 0
        }, {
            13, 4
        }
    };

    public ModelSilverfish()
    {
        field_78170_c = new float[7];
        field_78171_a = new ModelRenderer[7];
        float f = -3.5F;
        for(int i = 0; i < field_78171_a.length; i++)
        {
            field_78171_a[i] = new ModelRenderer(this, field_78168_e[i][0], field_78168_e[i][1]);
            field_78171_a[i].func_78789_a((float)field_78167_d[i][0] * -0.5F, 0.0F, (float)field_78167_d[i][2] * -0.5F, field_78167_d[i][0], field_78167_d[i][1], field_78167_d[i][2]);
            field_78171_a[i].func_78793_a(0.0F, 24 - field_78167_d[i][1], f);
            field_78170_c[i] = f;
            if(i < field_78171_a.length - 1)
            {
                f += (float)(field_78167_d[i][2] + field_78167_d[i + 1][2]) * 0.5F;
            }
        }

        field_78169_b = new ModelRenderer[3];
        field_78169_b[0] = new ModelRenderer(this, 20, 0);
        field_78169_b[0].func_78789_a(-5F, 0.0F, (float)field_78167_d[2][2] * -0.5F, 10, 8, field_78167_d[2][2]);
        field_78169_b[0].func_78793_a(0.0F, 16F, field_78170_c[2]);
        field_78169_b[1] = new ModelRenderer(this, 20, 11);
        field_78169_b[1].func_78789_a(-3F, 0.0F, (float)field_78167_d[4][2] * -0.5F, 6, 4, field_78167_d[4][2]);
        field_78169_b[1].func_78793_a(0.0F, 20F, field_78170_c[4]);
        field_78169_b[2] = new ModelRenderer(this, 20, 18);
        field_78169_b[2].func_78789_a(-3F, 0.0F, (float)field_78167_d[4][2] * -0.5F, 6, 5, field_78167_d[1][2]);
        field_78169_b[2].func_78793_a(0.0F, 19F, field_78170_c[1]);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        ModelRenderer amodelrenderer[] = field_78171_a;
        int i = amodelrenderer.length;
        for(int j = 0; j < i; j++)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.func_78785_a(p_78088_7_);
        }

        amodelrenderer = field_78169_b;
        i = amodelrenderer.length;
        for(int k = 0; k < i; k++)
        {
            ModelRenderer modelrenderer1 = amodelrenderer[k];
            modelrenderer1.func_78785_a(p_78088_7_);
        }

    }

    public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_)
    {
        for(int i = 0; i < field_78171_a.length; i++)
        {
            field_78171_a[i].field_78796_g = MathHelper.func_76134_b(p_78087_3_ * 0.9F + (float)i * 0.15F * 3.141593F) * 3.141593F * 0.05F * (float)(1 + Math.abs(i - 2));
            field_78171_a[i].field_78800_c = MathHelper.func_76126_a(p_78087_3_ * 0.9F + (float)i * 0.15F * 3.141593F) * 3.141593F * 0.2F * (float)Math.abs(i - 2);
        }

        field_78169_b[0].field_78796_g = field_78171_a[2].field_78796_g;
        field_78169_b[1].field_78796_g = field_78171_a[4].field_78796_g;
        field_78169_b[1].field_78800_c = field_78171_a[4].field_78800_c;
        field_78169_b[2].field_78796_g = field_78171_a[1].field_78796_g;
        field_78169_b[2].field_78800_c = field_78171_a[1].field_78800_c;
    }

}
