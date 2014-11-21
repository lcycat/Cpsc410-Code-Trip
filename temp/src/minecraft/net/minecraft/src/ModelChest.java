// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer

public class ModelChest extends ModelBase
{

    public ModelRenderer field_78234_a;
    public ModelRenderer field_78232_b;
    public ModelRenderer field_78233_c;

    public ModelChest()
    {
        field_78234_a = (new ModelRenderer(this, 0, 0)).func_78787_b(64, 64);
        field_78234_a.func_78790_a(0.0F, -5F, -14F, 14, 5, 14, 0.0F);
        field_78234_a.field_78800_c = 1.0F;
        field_78234_a.field_78797_d = 7F;
        field_78234_a.field_78798_e = 15F;
        field_78233_c = (new ModelRenderer(this, 0, 0)).func_78787_b(64, 64);
        field_78233_c.func_78790_a(-1F, -2F, -15F, 2, 4, 1, 0.0F);
        field_78233_c.field_78800_c = 8F;
        field_78233_c.field_78797_d = 7F;
        field_78233_c.field_78798_e = 15F;
        field_78232_b = (new ModelRenderer(this, 0, 19)).func_78787_b(64, 64);
        field_78232_b.func_78790_a(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
        field_78232_b.field_78800_c = 1.0F;
        field_78232_b.field_78797_d = 6F;
        field_78232_b.field_78798_e = 1.0F;
    }

    public void func_78231_a()
    {
        field_78233_c.field_78795_f = field_78234_a.field_78795_f;
        field_78234_a.func_78785_a(0.0625F);
        field_78233_c.func_78785_a(0.0625F);
        field_78232_b.func_78785_a(0.0625F);
    }
}
