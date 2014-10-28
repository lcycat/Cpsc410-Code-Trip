// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelMinecart extends ModelBase
{

    public ModelRenderer field_78154_a[];

    public ModelMinecart()
    {
        field_78154_a = new ModelRenderer[7];
        field_78154_a[0] = new ModelRenderer(this, 0, 10);
        field_78154_a[1] = new ModelRenderer(this, 0, 0);
        field_78154_a[2] = new ModelRenderer(this, 0, 0);
        field_78154_a[3] = new ModelRenderer(this, 0, 0);
        field_78154_a[4] = new ModelRenderer(this, 0, 0);
        field_78154_a[5] = new ModelRenderer(this, 44, 10);
        byte byte0 = 20;
        byte byte1 = 8;
        byte byte2 = 16;
        int i = 4;
        field_78154_a[0].func_78790_a(-byte0 / 2, -byte2 / 2, -1F, byte0, byte2, 2, 0.0F);
        field_78154_a[0].func_78793_a(0.0F, i, 0.0F);
        field_78154_a[5].func_78790_a(-byte0 / 2 + 1, -byte2 / 2 + 1, -1F, byte0 - 2, byte2 - 2, 1, 0.0F);
        field_78154_a[5].func_78793_a(0.0F, i, 0.0F);
        field_78154_a[1].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78154_a[1].func_78793_a(-byte0 / 2 + 1, i, 0.0F);
        field_78154_a[2].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78154_a[2].func_78793_a(byte0 / 2 - 1, i, 0.0F);
        field_78154_a[3].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78154_a[3].func_78793_a(0.0F, i, -byte2 / 2 + 1);
        field_78154_a[4].func_78790_a(-byte0 / 2 + 2, -byte1 - 1, -1F, byte0 - 4, byte1, 2, 0.0F);
        field_78154_a[4].func_78793_a(0.0F, i, byte2 / 2 - 1);
        field_78154_a[0].field_78795_f = 1.570796F;
        field_78154_a[1].field_78796_g = 4.712389F;
        field_78154_a[2].field_78796_g = 1.570796F;
        field_78154_a[3].field_78796_g = 3.141593F;
        field_78154_a[5].field_78795_f = -1.570796F;
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        field_78154_a[5].field_78797_d = 4F - p_78088_4_;
        for(int i = 0; i < 6; i++)
        {
            field_78154_a[i].func_78785_a(p_78088_7_);
        }

    }
}
