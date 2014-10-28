// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelBoat extends ModelBase
{

    public ModelRenderer field_78103_a[];

    public ModelBoat()
    {
        field_78103_a = new ModelRenderer[5];
        field_78103_a[0] = new ModelRenderer(this, 0, 8);
        field_78103_a[1] = new ModelRenderer(this, 0, 0);
        field_78103_a[2] = new ModelRenderer(this, 0, 0);
        field_78103_a[3] = new ModelRenderer(this, 0, 0);
        field_78103_a[4] = new ModelRenderer(this, 0, 0);
        byte byte0 = 24;
        byte byte1 = 6;
        byte byte2 = 20;
        int i = 4;
        field_78103_a[0].func_78790_a(-byte0 / 2, -byte2 / 2 + 2, -3F, byte0, byte2 - 4, 4, 0.0F);
        field_78103_a[0].func_78793_a(0.0F, i, 0.0F);
        field_78103_a[1].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78103_a[1].func_78793_a(-byte0 / 2 + 1, i, 0.0F);
        field_78103_a[2].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78103_a[2].func_78793_a(byte0 / 2 - 1, i, 0.0F);
        field_78103_a[3].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78103_a[3].func_78793_a(0.0F, i, -byte2 / 2 + 1);
        field_78103_a[4].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78103_a[4].func_78793_a(0.0F, i, byte2 / 2 - 1);
        field_78103_a[0].field_78795_f = 1.570796F;
        field_78103_a[1].field_78796_g = 4.712389F;
        field_78103_a[2].field_78796_g = 1.570796F;
        field_78103_a[3].field_78796_g = 3.141593F;
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        for(int i = 0; i < 5; i++)
        {
            field_78103_a[i].func_78785_a(p_78088_7_);
        }

    }
}
