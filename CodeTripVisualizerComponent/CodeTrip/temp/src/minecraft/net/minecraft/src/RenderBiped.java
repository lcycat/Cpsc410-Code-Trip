// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityLiving, ModelBiped, ModelRenderer, 
//            ItemStack, Block, RenderBlocks, Item, 
//            RenderManager, ItemRenderer

public class RenderBiped extends RenderLiving
{

    protected ModelBiped field_77071_a;
    protected float field_77070_b;

    public RenderBiped(ModelBiped p_i3202_1_, float p_i3202_2_)
    {
        this(p_i3202_1_, p_i3202_2_, 1.0F);
        field_77071_a = p_i3202_1_;
    }

    public RenderBiped(ModelBiped p_i3203_1_, float p_i3203_2_, float p_i3203_3_)
    {
        super(p_i3203_1_, p_i3203_2_);
        field_77071_a = p_i3203_1_;
        field_77070_b = p_i3203_3_;
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        super.func_77029_c(p_77029_1_, p_77029_2_);
        ItemStack itemstack = p_77029_1_.func_70694_bm();
        if(itemstack != null)
        {
            GL11.glPushMatrix();
            field_77071_a.field_78112_f.func_78794_c(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if(itemstack.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b()))
            {
                float f = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f, -f, f);
            } else
            if(itemstack.field_77993_c == Item.field_77707_k.field_77779_bT)
            {
                float f1 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f1, -f1, f1);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            if(Item.field_77698_e[itemstack.field_77993_c].func_77662_d())
            {
                float f2 = 0.625F;
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f2, -f2, f2);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f3 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f3, f3, f3);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            field_76990_c.field_78721_f.func_78443_a(p_77029_1_, itemstack, 0);
            if(itemstack.func_77973_b().func_77623_v())
            {
                field_76990_c.field_78721_f.func_78443_a(p_77029_1_, itemstack, 1);
            }
            GL11.glPopMatrix();
        }
    }
}
