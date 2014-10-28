// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBase, ModelRenderer, Entity

public class ModelEnderCrystal extends ModelBase
{

    private ModelRenderer field_78230_a;
    private ModelRenderer field_78228_b;
    private ModelRenderer field_78229_c;

    public ModelEnderCrystal(float p_i3144_1_)
    {
        field_78228_b = new ModelRenderer(this, "glass");
        field_78228_b.func_78784_a(0, 0).func_78789_a(-4F, -4F, -4F, 8, 8, 8);
        field_78230_a = new ModelRenderer(this, "cube");
        field_78230_a.func_78784_a(32, 0).func_78789_a(-4F, -4F, -4F, 8, 8, 8);
        field_78229_c = new ModelRenderer(this, "base");
        field_78229_c.func_78784_a(0, 16).func_78789_a(-6F, 0.0F, -6F, 12, 4, 12);
    }

    public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        GL11.glTranslatef(0.0F, -0.5F, 0.0F);
        field_78229_c.func_78785_a(p_78088_7_);
        GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.8F + p_78088_4_, 0.0F);
        GL11.glRotatef(60F, 0.7071F, 0.0F, 0.7071F);
        field_78228_b.func_78785_a(p_78088_7_);
        float f = 0.875F;
        GL11.glScalef(f, f, f);
        GL11.glRotatef(60F, 0.7071F, 0.0F, 0.7071F);
        GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
        field_78228_b.func_78785_a(p_78088_7_);
        GL11.glScalef(f, f, f);
        GL11.glRotatef(60F, 0.7071F, 0.0F, 0.7071F);
        GL11.glRotatef(p_78088_3_, 0.0F, 1.0F, 0.0F);
        field_78230_a.func_78785_a(p_78088_7_);
        GL11.glPopMatrix();
    }
}
