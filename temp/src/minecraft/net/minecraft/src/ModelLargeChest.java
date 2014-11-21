// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelChest, ModelRenderer

public class ModelLargeChest extends ModelChest
{

    public ModelLargeChest()
    {
        field_78234_a = (new ModelRenderer(this, 0, 0)).func_78787_b(128, 64);
        field_78234_a.func_78790_a(0.0F, -5F, -14F, 30, 5, 14, 0.0F);
        field_78234_a.field_78800_c = 1.0F;
        field_78234_a.field_78797_d = 7F;
        field_78234_a.field_78798_e = 15F;
        field_78233_c = (new ModelRenderer(this, 0, 0)).func_78787_b(128, 64);
        field_78233_c.func_78790_a(-1F, -2F, -15F, 2, 4, 1, 0.0F);
        field_78233_c.field_78800_c = 16F;
        field_78233_c.field_78797_d = 7F;
        field_78233_c.field_78798_e = 15F;
        field_78232_b = (new ModelRenderer(this, 0, 19)).func_78787_b(128, 64);
        field_78232_b.func_78790_a(0.0F, 0.0F, 0.0F, 30, 10, 14, 0.0F);
        field_78232_b.field_78800_c = 1.0F;
        field_78232_b.field_78797_d = 6F;
        field_78232_b.field_78798_e = 1.0F;
    }
}
