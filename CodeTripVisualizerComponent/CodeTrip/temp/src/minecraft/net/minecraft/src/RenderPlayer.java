// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, ModelBiped, EntityPlayer, InventoryPlayer, 
//            ItemStack, ItemArmor, ModelRenderer, EnumAction, 
//            EntityPlayerSP, RenderManager, Tessellator, FontRenderer, 
//            Item, Block, RenderBlocks, ItemRenderer, 
//            MathHelper, EntityLiving, Entity

public class RenderPlayer extends RenderLiving
{

    private ModelBiped field_77109_a;
    private ModelBiped field_77108_b;
    private ModelBiped field_77111_i;
    private static final String field_77110_j[] = {
        "cloth", "chain", "iron", "diamond", "gold"
    };

    public RenderPlayer()
    {
        super(new ModelBiped(0.0F), 0.5F);
        field_77109_a = (ModelBiped)field_77045_g;
        field_77108_b = new ModelBiped(1.0F);
        field_77111_i = new ModelBiped(0.5F);
    }

    protected int func_77107_a(EntityPlayer p_77107_1_, int p_77107_2_, float p_77107_3_)
    {
        ItemStack itemstack = p_77107_1_.field_71071_by.func_70440_f(3 - p_77107_2_);
        if(itemstack != null)
        {
            Item item = itemstack.func_77973_b();
            if(item instanceof ItemArmor)
            {
                ItemArmor itemarmor = (ItemArmor)item;
                func_76985_a((new StringBuilder()).append("/armor/").append(field_77110_j[itemarmor.field_77880_c]).append("_").append(p_77107_2_ != 2 ? 1 : 2).append(".png").toString());
                ModelBiped modelbiped = p_77107_2_ != 2 ? field_77108_b : field_77111_i;
                modelbiped.field_78116_c.field_78806_j = p_77107_2_ == 0;
                modelbiped.field_78114_d.field_78806_j = p_77107_2_ == 0;
                modelbiped.field_78115_e.field_78806_j = p_77107_2_ == 1 || p_77107_2_ == 2;
                modelbiped.field_78112_f.field_78806_j = p_77107_2_ == 1;
                modelbiped.field_78113_g.field_78806_j = p_77107_2_ == 1;
                modelbiped.field_78123_h.field_78806_j = p_77107_2_ == 2 || p_77107_2_ == 3;
                modelbiped.field_78124_i.field_78806_j = p_77107_2_ == 2 || p_77107_2_ == 3;
                func_77042_a(modelbiped);
                return !itemstack.func_77948_v() ? 1 : 15;
            }
        }
        return -1;
    }

    public void func_77101_a(EntityPlayer p_77101_1_, double p_77101_2_, double p_77101_4_, double p_77101_6_, 
            float p_77101_8_, float p_77101_9_)
    {
        ItemStack itemstack = p_77101_1_.field_71071_by.func_70448_g();
        field_77108_b.field_78120_m = field_77111_i.field_78120_m = field_77109_a.field_78120_m = itemstack == null ? 0 : 1;
        if(itemstack != null && p_77101_1_.func_71052_bv() > 0)
        {
            EnumAction enumaction = itemstack.func_77975_n();
            if(enumaction == EnumAction.block)
            {
                field_77108_b.field_78120_m = field_77111_i.field_78120_m = field_77109_a.field_78120_m = 3;
            } else
            if(enumaction == EnumAction.bow)
            {
                field_77108_b.field_78118_o = field_77111_i.field_78118_o = field_77109_a.field_78118_o = true;
            }
        }
        field_77108_b.field_78117_n = field_77111_i.field_78117_n = field_77109_a.field_78117_n = p_77101_1_.func_70093_af();
        double d = p_77101_4_ - (double)p_77101_1_.field_70129_M;
        if(p_77101_1_.func_70093_af() && !(p_77101_1_ instanceof EntityPlayerSP))
        {
            d -= 0.125D;
        }
        super.func_77031_a(p_77101_1_, p_77101_2_, d, p_77101_6_, p_77101_8_, p_77101_9_);
        field_77108_b.field_78118_o = field_77111_i.field_78118_o = field_77109_a.field_78118_o = false;
        field_77108_b.field_78117_n = field_77111_i.field_78117_n = field_77109_a.field_78117_n = false;
        field_77108_b.field_78120_m = field_77111_i.field_78120_m = field_77109_a.field_78120_m = 0;
    }

    protected void func_77103_a(EntityPlayer p_77103_1_, double p_77103_2_, double p_77103_4_, double p_77103_6_)
    {
        if(Minecraft.func_71382_s() && p_77103_1_ != field_76990_c.field_78734_h)
        {
            float f = 1.6F;
            float f1 = 0.01666667F * f;
            double d = p_77103_1_.func_70068_e(field_76990_c.field_78734_h);
            float f2 = p_77103_1_.func_70093_af() ? 32F : 64F;
            if(d < (double)(f2 * f2))
            {
                String s = p_77103_1_.field_71092_bJ;
                if(p_77103_1_.func_70093_af())
                {
                    FontRenderer fontrenderer = func_76983_a();
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)p_77103_2_ + 0.0F, (float)p_77103_4_ + 2.3F, (float)p_77103_6_);
                    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
                    GL11.glScalef(-f1, -f1, f1);
                    GL11.glDisable(2896);
                    GL11.glTranslatef(0.0F, 0.25F / f1, 0.0F);
                    GL11.glDepthMask(false);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    Tessellator tessellator = Tessellator.field_78398_a;
                    GL11.glDisable(3553);
                    tessellator.func_78382_b();
                    int i = fontrenderer.func_78256_a(s) / 2;
                    tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.25F);
                    tessellator.func_78377_a(-i - 1, -1D, 0.0D);
                    tessellator.func_78377_a(-i - 1, 8D, 0.0D);
                    tessellator.func_78377_a(i + 1, 8D, 0.0D);
                    tessellator.func_78377_a(i + 1, -1D, 0.0D);
                    tessellator.func_78381_a();
                    GL11.glEnable(3553);
                    GL11.glDepthMask(true);
                    fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 0x20ffffff);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glPopMatrix();
                } else
                if(p_77103_1_.func_70608_bn())
                {
                    func_77038_a(p_77103_1_, s, p_77103_2_, p_77103_4_ - 1.5D, p_77103_6_, 64);
                } else
                {
                    func_77038_a(p_77103_1_, s, p_77103_2_, p_77103_4_, p_77103_6_, 64);
                }
            }
        }
    }

    protected void func_77100_a(EntityPlayer p_77100_1_, float p_77100_2_)
    {
        super.func_77029_c(p_77100_1_, p_77100_2_);
        ItemStack itemstack = p_77100_1_.field_71071_by.func_70440_f(3);
        if(itemstack != null && itemstack.func_77973_b().field_77779_bT < 256)
        {
            GL11.glPushMatrix();
            field_77109_a.field_78116_c.func_78794_c(0.0625F);
            if(RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b()))
            {
                float f = 0.625F;
                GL11.glTranslatef(0.0F, -0.25F, 0.0F);
                GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f, -f, f);
            }
            field_76990_c.field_78721_f.func_78443_a(p_77100_1_, itemstack, 0);
            GL11.glPopMatrix();
        }
        if(p_77100_1_.field_71092_bJ.equals("deadmau5") && func_76984_a(p_77100_1_.field_70120_cr, null))
        {
            for(int i = 0; i < 2; i++)
            {
                float f1 = (p_77100_1_.field_70126_B + (p_77100_1_.field_70177_z - p_77100_1_.field_70126_B) * p_77100_2_) - (p_77100_1_.field_70760_ar + (p_77100_1_.field_70761_aq - p_77100_1_.field_70760_ar) * p_77100_2_);
                float f2 = p_77100_1_.field_70127_C + (p_77100_1_.field_70125_A - p_77100_1_.field_70127_C) * p_77100_2_;
                GL11.glPushMatrix();
                GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(f2, 1.0F, 0.0F, 0.0F);
                GL11.glTranslatef(0.375F * (float)(i * 2 - 1), 0.0F, 0.0F);
                GL11.glTranslatef(0.0F, -0.375F, 0.0F);
                GL11.glRotatef(-f2, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-f1, 0.0F, 1.0F, 0.0F);
                float f7 = 1.333333F;
                GL11.glScalef(f7, f7, f7);
                field_77109_a.func_78110_b(0.0625F);
                GL11.glPopMatrix();
            }

        }
        if(func_76984_a(p_77100_1_.field_71084_cw, null))
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.125F);
            double d = (p_77100_1_.field_71091_bM + (p_77100_1_.field_71094_bP - p_77100_1_.field_71091_bM) * (double)p_77100_2_) - (p_77100_1_.field_70169_q + (p_77100_1_.field_70165_t - p_77100_1_.field_70169_q) * (double)p_77100_2_);
            double d1 = (p_77100_1_.field_71096_bN + (p_77100_1_.field_71095_bQ - p_77100_1_.field_71096_bN) * (double)p_77100_2_) - (p_77100_1_.field_70167_r + (p_77100_1_.field_70163_u - p_77100_1_.field_70167_r) * (double)p_77100_2_);
            double d2 = (p_77100_1_.field_71097_bO + (p_77100_1_.field_71085_bR - p_77100_1_.field_71097_bO) * (double)p_77100_2_) - (p_77100_1_.field_70166_s + (p_77100_1_.field_70161_v - p_77100_1_.field_70166_s) * (double)p_77100_2_);
            float f10 = p_77100_1_.field_70760_ar + (p_77100_1_.field_70761_aq - p_77100_1_.field_70760_ar) * p_77100_2_;
            double d3 = MathHelper.func_76126_a((f10 * 3.141593F) / 180F);
            double d4 = -MathHelper.func_76134_b((f10 * 3.141593F) / 180F);
            float f12 = (float)d1 * 10F;
            if(f12 < -6F)
            {
                f12 = -6F;
            }
            if(f12 > 32F)
            {
                f12 = 32F;
            }
            float f13 = (float)(d * d3 + d2 * d4) * 100F;
            float f14 = (float)(d * d4 - d2 * d3) * 100F;
            if(f13 < 0.0F)
            {
                f13 = 0.0F;
            }
            float f15 = p_77100_1_.field_71107_bF + (p_77100_1_.field_71109_bG - p_77100_1_.field_71107_bF) * p_77100_2_;
            f12 += MathHelper.func_76126_a((p_77100_1_.field_70141_P + (p_77100_1_.field_70140_Q - p_77100_1_.field_70141_P) * p_77100_2_) * 6F) * 32F * f15;
            if(p_77100_1_.func_70093_af())
            {
                f12 += 25F;
            }
            GL11.glRotatef(6F + f13 / 2.0F + f12, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f14 / 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f14 / 2.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            field_77109_a.func_78111_c(0.0625F);
            GL11.glPopMatrix();
        }
        ItemStack itemstack1 = p_77100_1_.field_71071_by.func_70448_g();
        if(itemstack1 != null)
        {
            GL11.glPushMatrix();
            field_77109_a.field_78112_f.func_78794_c(0.0625F);
            GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
            if(p_77100_1_.field_71104_cf != null)
            {
                itemstack1 = new ItemStack(Item.field_77669_D);
            }
            EnumAction enumaction = null;
            if(p_77100_1_.func_71052_bv() > 0)
            {
                enumaction = itemstack1.func_77975_n();
            }
            if(itemstack1.field_77993_c < 256 && RenderBlocks.func_78597_b(Block.field_71973_m[itemstack1.field_77993_c].func_71857_b()))
            {
                float f3 = 0.5F;
                GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
                f3 *= 0.75F;
                GL11.glRotatef(20F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f3, -f3, f3);
            } else
            if(itemstack1.field_77993_c == Item.field_77707_k.field_77779_bT)
            {
                float f4 = 0.625F;
                GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
                GL11.glRotatef(-20F, 0.0F, 1.0F, 0.0F);
                GL11.glScalef(f4, -f4, f4);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            if(Item.field_77698_e[itemstack1.field_77993_c].func_77662_d())
            {
                float f5 = 0.625F;
                if(Item.field_77698_e[itemstack1.field_77993_c].func_77629_n_())
                {
                    GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
                    GL11.glTranslatef(0.0F, -0.125F, 0.0F);
                }
                if(p_77100_1_.func_71052_bv() > 0 && enumaction == EnumAction.block)
                {
                    GL11.glTranslatef(0.05F, 0.0F, -0.1F);
                    GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-10F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(-60F, 0.0F, 0.0F, 1.0F);
                }
                GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
                GL11.glScalef(f5, -f5, f5);
                GL11.glRotatef(-100F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            } else
            {
                float f6 = 0.375F;
                GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
                GL11.glScalef(f6, f6, f6);
                GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);
            }
            if(itemstack1.func_77973_b().func_77623_v())
            {
                for(int j = 0; j <= 1; j++)
                {
                    int k = itemstack1.func_77973_b().func_77620_a(itemstack1.func_77960_j(), j);
                    float f8 = (float)(k >> 16 & 0xff) / 255F;
                    float f9 = (float)(k >> 8 & 0xff) / 255F;
                    float f11 = (float)(k & 0xff) / 255F;
                    GL11.glColor4f(f8, f9, f11, 1.0F);
                    field_76990_c.field_78721_f.func_78443_a(p_77100_1_, itemstack1, j);
                }

            } else
            {
                field_76990_c.field_78721_f.func_78443_a(p_77100_1_, itemstack1, 0);
            }
            GL11.glPopMatrix();
        }
    }

    protected void func_77104_b(EntityPlayer p_77104_1_, float p_77104_2_)
    {
        float f = 0.9375F;
        GL11.glScalef(f, f, f);
    }

    public void func_77106_b()
    {
        field_77109_a.field_78095_p = 0.0F;
        field_77109_a.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        field_77109_a.field_78112_f.func_78785_a(0.0625F);
    }

    protected void func_77105_b(EntityPlayer p_77105_1_, double p_77105_2_, double p_77105_4_, double p_77105_6_)
    {
        if(p_77105_1_.func_70089_S() && p_77105_1_.func_70608_bn())
        {
            super.func_77039_a(p_77105_1_, p_77105_2_ + (double)p_77105_1_.field_71079_bU, p_77105_4_ + (double)p_77105_1_.field_71082_cx, p_77105_6_ + (double)p_77105_1_.field_71089_bV);
        } else
        {
            super.func_77039_a(p_77105_1_, p_77105_2_, p_77105_4_, p_77105_6_);
        }
    }

    protected void func_77102_a(EntityPlayer p_77102_1_, float p_77102_2_, float p_77102_3_, float p_77102_4_)
    {
        if(p_77102_1_.func_70089_S() && p_77102_1_.func_70608_bn())
        {
            GL11.glRotatef(p_77102_1_.func_71051_bG(), 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(func_77037_a(p_77102_1_), 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
        } else
        {
            super.func_77043_a(p_77102_1_, p_77102_2_, p_77102_3_, p_77102_4_);
        }
    }

    protected void func_77033_b(EntityLiving p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_)
    {
        func_77103_a((EntityPlayer)p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_);
    }

    protected void func_77041_b(EntityLiving p_77041_1_, float p_77041_2_)
    {
        func_77104_b((EntityPlayer)p_77041_1_, p_77041_2_);
    }

    protected int func_77032_a(EntityLiving p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return func_77107_a((EntityPlayer)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    protected void func_77029_c(EntityLiving p_77029_1_, float p_77029_2_)
    {
        func_77100_a((EntityPlayer)p_77029_1_, p_77029_2_);
    }

    protected void func_77043_a(EntityLiving p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_)
    {
        func_77102_a((EntityPlayer)p_77043_1_, p_77043_2_, p_77043_3_, p_77043_4_);
    }

    protected void func_77039_a(EntityLiving p_77039_1_, double p_77039_2_, double p_77039_4_, double p_77039_6_)
    {
        func_77105_b((EntityPlayer)p_77039_1_, p_77039_2_, p_77039_4_, p_77039_6_);
    }

    public void func_77031_a(EntityLiving p_77031_1_, double p_77031_2_, double p_77031_4_, double p_77031_6_, 
            float p_77031_8_, float p_77031_9_)
    {
        func_77101_a((EntityPlayer)p_77031_1_, p_77031_2_, p_77031_4_, p_77031_6_, p_77031_8_, p_77031_9_);
    }

    public void func_76986_a(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, 
            float p_76986_8_, float p_76986_9_)
    {
        func_77101_a((EntityPlayer)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }

}
