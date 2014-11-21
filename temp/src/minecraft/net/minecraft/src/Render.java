// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            ModelBiped, RenderBlocks, RenderManager, RenderEngine, 
//            Block, BlockFire, Entity, Tessellator, 
//            AxisAlignedBB, EntityLiving, EntityAnimal, MathHelper, 
//            World, GameSettings, ModelBase, FontRenderer

public abstract class Render
{

    protected RenderManager field_76990_c;
    private ModelBase field_76991_a;
    protected RenderBlocks field_76988_d;
    protected float field_76989_e;
    protected float field_76987_f;

    public Render()
    {
        field_76991_a = new ModelBiped();
        field_76988_d = new RenderBlocks();
        field_76989_e = 0.0F;
        field_76987_f = 1.0F;
    }

    public abstract void func_76986_a(Entity entity, double d, double d1, double d2, 
            float f, float f1);

    protected void func_76985_a(String p_76985_1_)
    {
        RenderEngine renderengine = field_76990_c.field_78724_e;
        renderengine.func_78342_b(renderengine.func_78341_b(p_76985_1_));
    }

    protected boolean func_76984_a(String p_76984_1_, String p_76984_2_)
    {
        RenderEngine renderengine = field_76990_c.field_78724_e;
        int i = renderengine.func_78350_a(p_76984_1_, p_76984_2_);
        if(i >= 0)
        {
            renderengine.func_78342_b(i);
            return true;
        } else
        {
            return false;
        }
    }

    private void func_76977_a(Entity p_76977_1_, double p_76977_2_, double p_76977_4_, double p_76977_6_, 
            float p_76977_8_)
    {
        GL11.glDisable(2896);
        int i = Block.field_72067_ar.field_72059_bZ;
        int j = (i & 0xf) << 4;
        int k = i & 0xf0;
        float f = (float)j / 256F;
        float f2 = ((float)j + 15.99F) / 256F;
        float f4 = (float)k / 256F;
        float f6 = ((float)k + 15.99F) / 256F;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_76977_2_, (float)p_76977_4_, (float)p_76977_6_);
        float f8 = p_76977_1_.field_70130_N * 1.4F;
        GL11.glScalef(f8, f8, f8);
        func_76985_a("/terrain.png");
        Tessellator tessellator = Tessellator.field_78398_a;
        float f9 = 0.5F;
        float f10 = 0.0F;
        float f11 = p_76977_1_.field_70131_O / f8;
        float f12 = (float)(p_76977_1_.field_70163_u - p_76977_1_.field_70121_D.field_72338_b);
        GL11.glRotatef(-field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, 0.0F, -0.3F + (float)(int)f11 * 0.02F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        float f13 = 0.0F;
        int l = 0;
        tessellator.func_78382_b();
        while(f11 > 0.0F) 
        {
            float f1;
            float f3;
            float f5;
            float f7;
            if(l % 2 == 0)
            {
                f1 = (float)j / 256F;
                f3 = ((float)j + 15.99F) / 256F;
                f5 = (float)k / 256F;
                f7 = ((float)k + 15.99F) / 256F;
            } else
            {
                f1 = (float)j / 256F;
                f3 = ((float)j + 15.99F) / 256F;
                f5 = (float)(k + 16) / 256F;
                f7 = ((float)(k + 16) + 15.99F) / 256F;
            }
            if((l / 2) % 2 == 0)
            {
                float f14 = f3;
                f3 = f1;
                f1 = f14;
            }
            tessellator.func_78374_a(f9 - f10, 0.0F - f12, f13, f3, f7);
            tessellator.func_78374_a(-f9 - f10, 0.0F - f12, f13, f1, f7);
            tessellator.func_78374_a(-f9 - f10, 1.4F - f12, f13, f1, f5);
            tessellator.func_78374_a(f9 - f10, 1.4F - f12, f13, f3, f5);
            f11 -= 0.45F;
            f12 -= 0.45F;
            f9 *= 0.9F;
            f13 += 0.03F;
            l++;
        }
        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glEnable(2896);
    }

    private void func_76975_c(Entity p_76975_1_, double p_76975_2_, double p_76975_4_, double p_76975_6_, 
            float p_76975_8_, float p_76975_9_)
    {
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        RenderEngine renderengine = field_76990_c.field_78724_e;
        renderengine.func_78342_b(renderengine.func_78341_b("%clamp%/misc/shadow.png"));
        World world = func_76982_b();
        GL11.glDepthMask(false);
        float f = field_76989_e;
        if(p_76975_1_ instanceof EntityLiving)
        {
            EntityLiving entityliving = (EntityLiving)p_76975_1_;
            f *= entityliving.func_70603_bj();
            if(entityliving instanceof EntityAnimal)
            {
                EntityAnimal entityanimal = (EntityAnimal)entityliving;
                if(entityanimal.func_70631_g_())
                {
                    f *= 0.5F;
                }
            }
        }
        double d = p_76975_1_.field_70142_S + (p_76975_1_.field_70165_t - p_76975_1_.field_70142_S) * (double)p_76975_9_;
        double d1 = p_76975_1_.field_70137_T + (p_76975_1_.field_70163_u - p_76975_1_.field_70137_T) * (double)p_76975_9_ + (double)p_76975_1_.func_70053_R();
        double d2 = p_76975_1_.field_70136_U + (p_76975_1_.field_70161_v - p_76975_1_.field_70136_U) * (double)p_76975_9_;
        int i = MathHelper.func_76128_c(d - (double)f);
        int j = MathHelper.func_76128_c(d + (double)f);
        int k = MathHelper.func_76128_c(d1 - (double)f);
        int l = MathHelper.func_76128_c(d1);
        int i1 = MathHelper.func_76128_c(d2 - (double)f);
        int j1 = MathHelper.func_76128_c(d2 + (double)f);
        double d3 = p_76975_2_ - d;
        double d4 = p_76975_4_ - d1;
        double d5 = p_76975_6_ - d2;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        for(int k1 = i; k1 <= j; k1++)
        {
            for(int l1 = k; l1 <= l; l1++)
            {
                for(int i2 = i1; i2 <= j1; i2++)
                {
                    int j2 = world.func_72798_a(k1, l1 - 1, i2);
                    if(j2 > 0 && world.func_72957_l(k1, l1, i2) > 3)
                    {
                        func_76981_a(Block.field_71973_m[j2], p_76975_2_, p_76975_4_ + (double)p_76975_1_.func_70053_R(), p_76975_6_, k1, l1, i2, p_76975_8_, f, d3, d4 + (double)p_76975_1_.func_70053_R(), d5);
                    }
                }

            }

        }

        tessellator.func_78381_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    private World func_76982_b()
    {
        return field_76990_c.field_78722_g;
    }

    private void func_76981_a(Block p_76981_1_, double p_76981_2_, double p_76981_4_, double p_76981_6_, 
            int p_76981_8_, int p_76981_9_, int p_76981_10_, float p_76981_11_, float p_76981_12_, double p_76981_13_, 
            double p_76981_15_, double p_76981_17_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        if(!p_76981_1_.func_71886_c())
        {
            return;
        }
        double d = ((double)p_76981_11_ - (p_76981_4_ - ((double)p_76981_9_ + p_76981_15_)) / 2D) * 0.5D * (double)func_76982_b().func_72801_o(p_76981_8_, p_76981_9_, p_76981_10_);
        if(d < 0.0D)
        {
            return;
        }
        if(d > 1.0D)
        {
            d = 1.0D;
        }
        tessellator.func_78369_a(1.0F, 1.0F, 1.0F, (float)d);
        double d1 = (double)p_76981_8_ + p_76981_1_.field_72026_ch + p_76981_13_;
        double d2 = (double)p_76981_8_ + p_76981_1_.field_72021_ck + p_76981_13_;
        double d3 = (double)p_76981_9_ + p_76981_1_.field_72023_ci + p_76981_15_ + 0.015625D;
        double d4 = (double)p_76981_10_ + p_76981_1_.field_72024_cj + p_76981_17_;
        double d5 = (double)p_76981_10_ + p_76981_1_.field_72019_cm + p_76981_17_;
        float f = (float)((p_76981_2_ - d1) / 2D / (double)p_76981_12_ + 0.5D);
        float f1 = (float)((p_76981_2_ - d2) / 2D / (double)p_76981_12_ + 0.5D);
        float f2 = (float)((p_76981_6_ - d4) / 2D / (double)p_76981_12_ + 0.5D);
        float f3 = (float)((p_76981_6_ - d5) / 2D / (double)p_76981_12_ + 0.5D);
        tessellator.func_78374_a(d1, d3, d4, f, f2);
        tessellator.func_78374_a(d1, d3, d5, f, f3);
        tessellator.func_78374_a(d2, d3, d5, f1, f3);
        tessellator.func_78374_a(d2, d3, d4, f1, f2);
    }

    public static void func_76978_a(AxisAlignedBB p_76978_0_, double p_76978_1_, double p_76978_3_, double p_76978_5_)
    {
        GL11.glDisable(3553);
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.func_78382_b();
        tessellator.func_78373_b(p_76978_1_, p_76978_3_, p_76978_5_);
        tessellator.func_78375_b(0.0F, 0.0F, -1F);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
        tessellator.func_78375_b(0.0F, 0.0F, 1.0F);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
        tessellator.func_78375_b(0.0F, -1F, 0.0F);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
        tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
        tessellator.func_78375_b(-1F, 0.0F, 0.0F);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72340_a, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
        tessellator.func_78375_b(1.0F, 0.0F, 0.0F);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72339_c);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72337_e, p_76978_0_.field_72334_f);
        tessellator.func_78377_a(p_76978_0_.field_72336_d, p_76978_0_.field_72338_b, p_76978_0_.field_72334_f);
        tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glEnable(3553);
    }

    public static void func_76980_a(AxisAlignedBB p_76980_0_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72340_a, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72339_c);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72337_e, p_76980_0_.field_72334_f);
        tessellator.func_78377_a(p_76980_0_.field_72336_d, p_76980_0_.field_72338_b, p_76980_0_.field_72334_f);
        tessellator.func_78381_a();
    }

    public void func_76976_a(RenderManager p_76976_1_)
    {
        field_76990_c = p_76976_1_;
    }

    public void func_76979_b(Entity p_76979_1_, double p_76979_2_, double p_76979_4_, double p_76979_6_, 
            float p_76979_8_, float p_76979_9_)
    {
        if(field_76990_c.field_78733_k.field_74347_j && field_76989_e > 0.0F)
        {
            double d = field_76990_c.func_78714_a(p_76979_1_.field_70165_t, p_76979_1_.field_70163_u, p_76979_1_.field_70161_v);
            float f = (float)((1.0D - d / 256D) * (double)field_76987_f);
            if(f > 0.0F)
            {
                func_76975_c(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, f, p_76979_9_);
            }
        }
        if(p_76979_1_.func_70027_ad())
        {
            func_76977_a(p_76979_1_, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_9_);
        }
    }

    public FontRenderer func_76983_a()
    {
        return field_76990_c.func_78716_a();
    }
}
