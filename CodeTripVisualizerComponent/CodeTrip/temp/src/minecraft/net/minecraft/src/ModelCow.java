// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ModelQuadruped, ModelRenderer

public class ModelCow extends ModelQuadruped
{

    public ModelCow()
    {
        super(12, 0.0F);
        field_78150_a = new ModelRenderer(this, 0, 0);
        field_78150_a.func_78790_a(-4F, -4F, -6F, 8, 8, 6, 0.0F);
        field_78150_a.func_78793_a(0.0F, 4F, -8F);
        field_78150_a.func_78784_a(22, 0).func_78790_a(-5F, -5F, -4F, 1, 3, 1, 0.0F);
        field_78150_a.func_78784_a(22, 0).func_78790_a(4F, -5F, -4F, 1, 3, 1, 0.0F);
        field_78148_b = new ModelRenderer(this, 18, 4);
        field_78148_b.func_78790_a(-6F, -10F, -7F, 12, 18, 10, 0.0F);
        field_78148_b.func_78793_a(0.0F, 5F, 2.0F);
        field_78148_b.func_78784_a(52, 0).func_78789_a(-2F, 2.0F, -8F, 4, 6, 1);
        field_78149_c.field_78800_c--;
        field_78146_d.field_78800_c++;
        field_78149_c.field_78798_e += 0.0F;
        field_78146_d.field_78798_e += 0.0F;
        field_78147_e.field_78800_c--;
        field_78144_f.field_78800_c++;
        field_78147_e.field_78798_e--;
        field_78144_f.field_78798_e--;
        field_78151_h += 2.0F;
    }
}
