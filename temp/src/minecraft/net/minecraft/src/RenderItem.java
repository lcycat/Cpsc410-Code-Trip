// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            Render, RenderBlocks, EntityItem, MathHelper, 
//            ItemStack, Block, Item, Tessellator, 
//            RenderManager, RenderEngine, FontRenderer, Entity

public class RenderItem extends Render
{

    private RenderBlocks field_77022_g;
    private Random field_77025_h;
    public boolean field_77024_a;
    public float field_77023_b;

    public RenderItem()
    {
        field_77022_g = new RenderBlocks();
        field_77025_h = new Random();
        field_77024_a = true;
        field_77023_b = 0.0F;
        field_76989_e = 0.15F;
        field_76987_f = 0.75F;
    }

    public void func_77014_a(EntityItem p_77014_1_, double p_77014_2_, double p_77014_4_, double p_77014_6_, 
            float p_77014_8_, float p_77014_9_)
    {
        field_77025_h.setSeed(187L);
        ItemStack itemstack = p_77014_1_.field_70294_a;
        GL11.glPushMatrix();
        float f = MathHelper.func_76126_a(((float)p_77014_1_.field_70292_b + p_77014_9_) / 10F + p_77014_1_.field_70290_d) * 0.1F + 0.1F;
        float f1 = (((float)p_77014_1_.field_70292_b + p_77014_9_) / 20F + p_77014_1_.field_70290_d) * 57.29578F;
        byte byte0 = 1;
        if(p_77014_1_.field_70294_a.field_77994_a > 1)
        {
            byte0 = 2;
        }
        if(p_77014_1_.field_70294_a.field_77994_a > 5)
        {
            byte0 = 3;
        }
        if(p_77014_1_.field_70294_a.field_77994_a > 20)
        {
            byte0 = 4;
        }
        GL11.glTranslatef((float)p_77014_2_, (float)p_77014_4_ + f, (float)p_77014_6_);
        GL11.glEnable(32826);
        Block block = null;
        if(itemstack.field_77993_c < Block.field_71973_m.length)
        {
            block = Block.field_71973_m[itemstack.field_77993_c];
        }
        if(block != null && RenderBlocks.func_78597_b(block.func_71857_b()))
        {
            GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
            func_76985_a("/terrain.png");
            float f2 = 0.25F;
            int k = block.func_71857_b();
            if(k == 1 || k == 19 || k == 12 || k == 2)
            {
                f2 = 0.5F;
            }
            GL11.glScalef(f2, f2, f2);
            for(int j1 = 0; j1 < byte0; j1++)
            {
                GL11.glPushMatrix();
                if(j1 > 0)
                {
                    float f5 = ((field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F) / f2;
                    float f8 = ((field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F) / f2;
                    float f11 = ((field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.2F) / f2;
                    GL11.glTranslatef(f5, f8, f11);
                }
                float f6 = 1.0F;
                field_77022_g.func_78600_a(block, itemstack.func_77960_j(), f6);
                GL11.glPopMatrix();
            }

        } else
        if(itemstack.func_77973_b().func_77623_v())
        {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            func_76985_a("/gui/items.png");
            for(int i = 0; i <= 1; i++)
            {
                int l = itemstack.func_77973_b().func_77618_c(itemstack.func_77960_j(), i);
                float f3 = 1.0F;
                if(field_77024_a)
                {
                    int k1 = Item.field_77698_e[itemstack.field_77993_c].func_77620_a(itemstack.func_77960_j(), i);
                    float f9 = (float)(k1 >> 16 & 0xff) / 255F;
                    float f12 = (float)(k1 >> 8 & 0xff) / 255F;
                    float f14 = (float)(k1 & 0xff) / 255F;
                    GL11.glColor4f(f9 * f3, f12 * f3, f14 * f3, 1.0F);
                }
                func_77020_a(l, byte0);
            }

        } else
        {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            int j = itemstack.func_77954_c();
            if(block != null)
            {
                func_76985_a("/terrain.png");
            } else
            {
                func_76985_a("/gui/items.png");
            }
            if(field_77024_a)
            {
                int i1 = Item.field_77698_e[itemstack.field_77993_c].func_77620_a(itemstack.func_77960_j(), 0);
                float f4 = (float)(i1 >> 16 & 0xff) / 255F;
                float f7 = (float)(i1 >> 8 & 0xff) / 255F;
                float f10 = (float)(i1 & 0xff) / 255F;
                float f13 = 1.0F;
                GL11.glColor4f(f4 * f13, f7 * f13, f10 * f13, 1.0F);
            }
            func_77020_a(j, byte0);
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_77020_a(int p_77020_1_, int p_77020_2_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        float f = (float)((p_77020_1_ % 16) * 16 + 0) / 256F;
        float f1 = (float)((p_77020_1_ % 16) * 16 + 16) / 256F;
        float f2 = (float)((p_77020_1_ / 16) * 16 + 0) / 256F;
        float f3 = (float)((p_77020_1_ / 16) * 16 + 16) / 256F;
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        for(int i = 0; i < p_77020_2_; i++)
        {
            GL11.glPushMatrix();
            if(i > 0)
            {
                float f7 = (field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
                float f8 = (field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
                float f9 = (field_77025_h.nextFloat() * 2.0F - 1.0F) * 0.3F;
                GL11.glTranslatef(f7, f8, f9);
            }
            GL11.glRotatef(180F - field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
            tessellator.func_78382_b();
            tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
            tessellator.func_78374_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
            tessellator.func_78374_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
            tessellator.func_78374_a(f4 - f5, 1.0F - f6, 0.0D, f1, f2);
            tessellator.func_78374_a(0.0F - f5, 1.0F - f6, 0.0D, f, f2);
            tessellator.func_78381_a();
            GL11.glPopMatrix();
        }

    }

    public void func_77019_a(FontRenderer p_77019_1_, RenderEngine p_77019_2_, int p_77019_3_, int p_77019_4_, int p_77019_5_, int p_77019_6_, int p_77019_7_)
    {
        if(p_77019_3_ < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[p_77019_3_].func_71857_b()))
        {
            p_77019_2_.func_78342_b(p_77019_2_.func_78341_b("/terrain.png"));
            Block block = Block.field_71973_m[p_77019_3_];
            GL11.glPushMatrix();
            GL11.glTranslatef(p_77019_6_ - 2, p_77019_7_ + 3, -3F + field_77023_b);
            GL11.glScalef(10F, 10F, 10F);
            GL11.glTranslatef(1.0F, 0.5F, 1.0F);
            GL11.glScalef(1.0F, 1.0F, -1F);
            GL11.glRotatef(210F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            int k = Item.field_77698_e[p_77019_3_].func_77620_a(p_77019_4_, 0);
            float f1 = (float)(k >> 16 & 0xff) / 255F;
            float f3 = (float)(k >> 8 & 0xff) / 255F;
            float f6 = (float)(k & 0xff) / 255F;
            if(field_77024_a)
            {
                GL11.glColor4f(f1, f3, f6, 1.0F);
            }
            GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
            field_77022_g.field_78668_c = field_77024_a;
            field_77022_g.func_78600_a(block, p_77019_4_, 1.0F);
            field_77022_g.field_78668_c = true;
            GL11.glPopMatrix();
        } else
        if(Item.field_77698_e[p_77019_3_].func_77623_v())
        {
            GL11.glDisable(2896);
            p_77019_2_.func_78342_b(p_77019_2_.func_78341_b("/gui/items.png"));
            for(int i = 0; i <= 1; i++)
            {
                int l = Item.field_77698_e[p_77019_3_].func_77618_c(p_77019_4_, i);
                int i1 = Item.field_77698_e[p_77019_3_].func_77620_a(p_77019_4_, i);
                float f4 = (float)(i1 >> 16 & 0xff) / 255F;
                float f7 = (float)(i1 >> 8 & 0xff) / 255F;
                float f8 = (float)(i1 & 0xff) / 255F;
                if(field_77024_a)
                {
                    GL11.glColor4f(f4, f7, f8, 1.0F);
                }
                func_77016_a(p_77019_6_, p_77019_7_, (l % 16) * 16, (l / 16) * 16, 16, 16);
            }

            GL11.glEnable(2896);
        } else
        if(p_77019_5_ >= 0)
        {
            GL11.glDisable(2896);
            if(p_77019_3_ < 256)
            {
                p_77019_2_.func_78342_b(p_77019_2_.func_78341_b("/terrain.png"));
            } else
            {
                p_77019_2_.func_78342_b(p_77019_2_.func_78341_b("/gui/items.png"));
            }
            int j = Item.field_77698_e[p_77019_3_].func_77620_a(p_77019_4_, 0);
            float f = (float)(j >> 16 & 0xff) / 255F;
            float f2 = (float)(j >> 8 & 0xff) / 255F;
            float f5 = (float)(j & 0xff) / 255F;
            if(field_77024_a)
            {
                GL11.glColor4f(f, f2, f5, 1.0F);
            }
            func_77016_a(p_77019_6_, p_77019_7_, (p_77019_5_ % 16) * 16, (p_77019_5_ / 16) * 16, 16, 16);
            GL11.glEnable(2896);
        }
        GL11.glEnable(2884);
    }

    public void func_77015_a(FontRenderer p_77015_1_, RenderEngine p_77015_2_, ItemStack p_77015_3_, int p_77015_4_, int p_77015_5_)
    {
        if(p_77015_3_ == null)
        {
            return;
        }
        func_77019_a(p_77015_1_, p_77015_2_, p_77015_3_.field_77993_c, p_77015_3_.func_77960_j(), p_77015_3_.func_77954_c(), p_77015_4_, p_77015_5_);
        if(p_77015_3_ != null && p_77015_3_.func_77962_s())
        {
            GL11.glDepthFunc(516);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            p_77015_2_.func_78342_b(p_77015_2_.func_78341_b("%blur%/misc/glint.png"));
            field_77023_b -= 50F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(774, 774);
            GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
            func_77018_a(p_77015_4_ * 0x19b4ca14 + p_77015_5_ * 0x1eafff1, p_77015_4_ - 2, p_77015_5_ - 2, 20, 20);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            field_77023_b += 50F;
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
        }
    }

    private void func_77018_a(int p_77018_1_, int p_77018_2_, int p_77018_3_, int p_77018_4_, int p_77018_5_)
    {
        for(int i = 0; i < 2; i++)
        {
            if(i == 0)
            {
                GL11.glBlendFunc(768, 1);
            }
            if(i == 1)
            {
                GL11.glBlendFunc(768, 1);
            }
            float f = 0.00390625F;
            float f1 = 0.00390625F;
            float f2 = ((float)(Minecraft.func_71386_F() % (long)(3000 + i * 1873)) / (3000F + (float)(i * 1873))) * 256F;
            float f3 = 0.0F;
            Tessellator tessellator = Tessellator.field_78398_a;
            float f4 = 4F;
            if(i == 1)
            {
                f4 = -1F;
            }
            tessellator.func_78382_b();
            tessellator.func_78374_a(p_77018_2_ + 0, p_77018_3_ + p_77018_5_, field_77023_b, (f2 + (float)p_77018_5_ * f4) * f, (f3 + (float)p_77018_5_) * f1);
            tessellator.func_78374_a(p_77018_2_ + p_77018_4_, p_77018_3_ + p_77018_5_, field_77023_b, (f2 + (float)p_77018_4_ + (float)p_77018_5_ * f4) * f, (f3 + (float)p_77018_5_) * f1);
            tessellator.func_78374_a(p_77018_2_ + p_77018_4_, p_77018_3_ + 0, field_77023_b, (f2 + (float)p_77018_4_) * f, (f3 + 0.0F) * f1);
            tessellator.func_78374_a(p_77018_2_ + 0, p_77018_3_ + 0, field_77023_b, (f2 + 0.0F) * f, (f3 + 0.0F) * f1);
            tessellator.func_78381_a();
        }

    }

    public void func_77021_b(FontRenderer p_77021_1_, RenderEngine p_77021_2_, ItemStack p_77021_3_, int p_77021_4_, int p_77021_5_)
    {
        if(p_77021_3_ == null)
        {
            return;
        }
        if(p_77021_3_.field_77994_a > 1)
        {
            String s = (new StringBuilder()).append("").append(p_77021_3_.field_77994_a).toString();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            p_77021_1_.func_78261_a(s, (p_77021_4_ + 19) - 2 - p_77021_1_.func_78256_a(s), p_77021_5_ + 6 + 3, 0xffffff);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
        }
        if(p_77021_3_.func_77951_h())
        {
            int i = (int)Math.round(13D - ((double)p_77021_3_.func_77952_i() * 13D) / (double)p_77021_3_.func_77958_k());
            int j = (int)Math.round(255D - ((double)p_77021_3_.func_77952_i() * 255D) / (double)p_77021_3_.func_77958_k());
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            Tessellator tessellator = Tessellator.field_78398_a;
            int k = 255 - j << 16 | j << 8;
            int l = (255 - j) / 4 << 16 | 0x3f00;
            func_77017_a(tessellator, p_77021_4_ + 2, p_77021_5_ + 13, 13, 2, 0);
            func_77017_a(tessellator, p_77021_4_ + 2, p_77021_5_ + 13, 12, 1, l);
            func_77017_a(tessellator, p_77021_4_ + 2, p_77021_5_ + 13, i, 1, k);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    private void func_77017_a(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_)
    {
        p_77017_1_.func_78382_b();
        p_77017_1_.func_78378_d(p_77017_6_);
        p_77017_1_.func_78377_a(p_77017_2_ + 0, p_77017_3_ + 0, 0.0D);
        p_77017_1_.func_78377_a(p_77017_2_ + 0, p_77017_3_ + p_77017_5_, 0.0D);
        p_77017_1_.func_78377_a(p_77017_2_ + p_77017_4_, p_77017_3_ + p_77017_5_, 0.0D);
        p_77017_1_.func_78377_a(p_77017_2_ + p_77017_4_, p_77017_3_ + 0, 0.0D);
        p_77017_1_.func_78381_a();
    }

    public void func_77016_a(int p_77016_1_, int p_77016_2_, int p_77016_3_, int p_77016_4_, int p_77016_5_, int p_77016_6_)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(p_77016_1_ + 0, p_77016_2_ + p_77016_6_, field_77023_b, (float)(p_77016_3_ + 0) * f, (float)(p_77016_4_ + p_77016_6_) * f1);
        tessellator.func_78374_a(p_77016_1_ + p_77016_5_, p_77016_2_ + p_77016_6_, field_77023_b, (float)(p_77016_3_ + p_77016_5_) * f, (float)(p_77016_4_ + p_77016_6_) * f1);
        tessellator.func_78374_a(p_77016_1_ + p_77016_5_, p_77016_2_ + 0, field_77023_b, (float)(p_77016_3_ + p_77016_5_) * f, (float)(p_77016_4_ + 0) * f1);
        tessellator.func_78374_a(p_77016_1_ + 0, p_77016_2_ + 0, field_77023_b, (float)(p_77016_3_ + 0) * f, (float)(p_77016_4_ + 0) * f1);
        tessellator.func_78381_a();
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77014_a((EntityItem)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}
