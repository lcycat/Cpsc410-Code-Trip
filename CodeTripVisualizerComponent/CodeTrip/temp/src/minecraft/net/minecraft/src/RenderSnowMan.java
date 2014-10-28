// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelSnowMan, ItemStack, Block, 
//            Item, ModelRenderer, RenderBlocks, RenderManager, 
//            ItemRenderer, EntitySnowman, EntityLiving

public class RenderSnowMan extends RenderLiving
{

    private ModelSnowMan field_77094_a;

    public RenderSnowMan()
    {
        super(new ModelSnowMan(), 0.5F);
        field_77094_a = (ModelSnowMan)super.field_77045_g;
        func_77042_a(field_77094_a);
    }

    protected void func_77093_a(EntitySnowman p_77093_1_, float p_77093_2_)
    {
        super.func_77029_c(p_77093_1_, p_77093_2_);
        ItemStack itemstack = new ItemStack(Block.field_72061_ba, 1);
        if(itemstack != null && itemstack.func_77973_b().field_77779_bT < 256)
        {
            GL11.glPushMatrix();
            field_77094_a.field_78195_c.func_78794_c(0.0625F);
            if(RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b()))
            {
                float f = 0.625F;
                GL11.glTranslatef(0.0F, -0.34375F, 0.0F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f, -f, f);
            }
            field_76990_c.field_78721_f.func_78443_a(p_77093_1_, itemstack, 0);
            GL11.glPopMatrix();
        }
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        func_77093_a((EntitySnowman)p_77029_1_, p_77029_2_);
    }
}
