// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, Block, EntityFallingSand, 
//            Tessellator, MathHelper, Entity

public class RenderFallingSand extends Render
{

    private RenderBlocks field_77004_a;

    public RenderFallingSand()
    {
        field_77004_a = new RenderBlocks();
        field_76989_e = 0.5F;
    }

    public void func_77003_a(EntityFallingSand p_77003_1_, double p_77003_2_, double p_77003_4_, double p_77003_6_, 
            float p_77003_8_, float p_77003_9_)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_77003_2_, (float)p_77003_4_, (float)p_77003_6_);
        func_76985_a("/terrain.png");
        Block block = Block.field_71973_m[p_77003_1_.field_70287_a];
        World world = p_77003_1_.func_70283_d();
        GL11.glDisable(2896);
        if(block == Block.field_72084_bK)
        {
            field_77004_a.field_78669_a = world;
            Tessellator tessellator = Tessellator.field_78398_a;
            tessellator.func_78382_b();
            tessellator.func_78373_b((float)(-MathHelper.func_76128_c(p_77003_1_.field_70165_t)) - 0.5F, (float)(-MathHelper.func_76128_c(p_77003_1_.field_70163_u)) - 0.5F, (float)(-MathHelper.func_76128_c(p_77003_1_.field_70161_v)) - 0.5F);
            field_77004_a.func_78612_b(block, MathHelper.func_76128_c(p_77003_1_.field_70165_t), MathHelper.func_76128_c(p_77003_1_.field_70163_u), MathHelper.func_76128_c(p_77003_1_.field_70161_v));
            tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
        } else
        if(block != null)
        {
            field_77004_a.func_78588_a(block, world, MathHelper.func_76128_c(p_77003_1_.field_70165_t), MathHelper.func_76128_c(p_77003_1_.field_70163_u), MathHelper.func_76128_c(p_77003_1_.field_70161_v), p_77003_1_.field_70285_b);
        }
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77003_a((EntityFallingSand)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
