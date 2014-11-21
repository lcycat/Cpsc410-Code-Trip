// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderBlocks, MapItemRenderer, ItemStack, Block, 
//            RenderEngine, Tessellator, EntityLiving, EntityPlayer, 
//            RenderHelper, EntityPlayerSP, EntityClientPlayerMP, MathHelper, 
//            WorldClient, OpenGlHelper, Item, ItemMap, 
//            RenderManager, RenderPlayer, EnumAction, Material, 
//            BlockFire, InventoryPlayer

public class ItemRenderer
{

    private Minecraft field_78455_a;
    private ItemStack field_78453_b;
    private float field_78454_c;
    private float field_78451_d;
    private RenderBlocks field_78452_e;
    private MapItemRenderer field_78449_f;
    private int field_78450_g;

    public ItemRenderer(Minecraft p_i3186_1_)
    {
        field_78453_b = null;
        field_78454_c = 0.0F;
        field_78451_d = 0.0F;
        field_78452_e = new RenderBlocks();
        field_78450_g = -1;
        field_78455_a = p_i3186_1_;
        field_78449_f = new MapItemRenderer(p_i3186_1_.field_71466_p, p_i3186_1_.field_71474_y, p_i3186_1_.field_71446_o);
    }

    public void func_78443_a(EntityLiving p_78443_1_, ItemStack p_78443_2_, int p_78443_3_)
    {
        GL11.glPushMatrix();
        Block block = null;
        if(p_78443_2_.field_77993_c < Block.field_71973_m.length)
        {
            block = Block.field_71973_m[p_78443_2_.field_77993_c];
        }
        if(block != null && RenderBlocks.func_78597_b(block.func_71857_b()))
        {
            GL11.glBindTexture(3553, field_78455_a.field_71446_o.func_78341_b("/terrain.png"));
            field_78452_e.func_78600_a(block, p_78443_2_.func_77960_j(), 1.0F);
        } else
        {
            if(block != null)
            {
                GL11.glBindTexture(3553, field_78455_a.field_71446_o.func_78341_b("/terrain.png"));
            } else
            {
                GL11.glBindTexture(3553, field_78455_a.field_71446_o.func_78341_b("/gui/items.png"));
            }
            Tessellator tessellator = Tessellator.field_78398_a;
            int i = p_78443_1_.func_70620_b(p_78443_2_, p_78443_3_);
            float f = ((float)((i % 16) * 16) + 0.0F) / 256F;
            float f1 = ((float)((i % 16) * 16) + 15.99F) / 256F;
            float f2 = ((float)((i / 16) * 16) + 0.0F) / 256F;
            float f3 = ((float)((i / 16) * 16) + 15.99F) / 256F;
            float f4 = 0.0F;
            float f5 = 0.3F;
            GL11.glEnable(32826);
            GL11.glTranslatef(-f4, -f5, 0.0F);
            float f6 = 1.5F;
            GL11.glScalef(f6, f6, f6);
            GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(335F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
            func_78439_a(tessellator, f1, f2, f, f3);
            if(p_78443_2_ != null && p_78443_2_.func_77962_s() && p_78443_3_ == 0)
            {
                GL11.glDepthFunc(514);
                GL11.glDisable(2896);
                field_78455_a.field_71446_o.func_78342_b(field_78455_a.field_71446_o.func_78341_b("%blur%/misc/glint.png"));
                GL11.glEnable(3042);
                GL11.glBlendFunc(768, 1);
                float f7 = 0.76F;
                GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
                GL11.glMatrixMode(5890);
                GL11.glPushMatrix();
                float f8 = 0.125F;
                GL11.glScalef(f8, f8, f8);
                float f9 = ((float)(Minecraft.func_71386_F() % 3000L) / 3000F) * 8F;
                GL11.glTranslatef(f9, 0.0F, 0.0F);
                GL11.glRotatef(-50F, 0.0F, 0.0F, 1.0F);
                func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glScalef(f8, f8, f8);
                f9 = ((float)(Minecraft.func_71386_F() % 4873L) / 4873F) * 8F;
                GL11.glTranslatef(-f9, 0.0F, 0.0F);
                GL11.glRotatef(10F, 0.0F, 0.0F, 1.0F);
                func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
                GL11.glPopMatrix();
                GL11.glMatrixMode(5888);
                GL11.glDisable(3042);
                GL11.glEnable(2896);
                GL11.glDepthFunc(515);
            }
            GL11.glDisable(32826);
        }
        GL11.glPopMatrix();
    }

    private void func_78439_a(Tessellator p_78439_1_, float p_78439_2_, float p_78439_3_, float p_78439_4_, float p_78439_5_)
    {
        float f = 1.0F;
        float f1 = 0.0625F;
        p_78439_1_.func_78382_b();
        p_78439_1_.func_78375_b(0.0F, 0.0F, 1.0F);
        p_78439_1_.func_78374_a(0.0D, 0.0D, 0.0D, p_78439_2_, p_78439_5_);
        p_78439_1_.func_78374_a(f, 0.0D, 0.0D, p_78439_4_, p_78439_5_);
        p_78439_1_.func_78374_a(f, 1.0D, 0.0D, p_78439_4_, p_78439_3_);
        p_78439_1_.func_78374_a(0.0D, 1.0D, 0.0D, p_78439_2_, p_78439_3_);
        p_78439_1_.func_78381_a();
        p_78439_1_.func_78382_b();
        p_78439_1_.func_78375_b(0.0F, 0.0F, -1F);
        p_78439_1_.func_78374_a(0.0D, 1.0D, 0.0F - f1, p_78439_2_, p_78439_3_);
        p_78439_1_.func_78374_a(f, 1.0D, 0.0F - f1, p_78439_4_, p_78439_3_);
        p_78439_1_.func_78374_a(f, 0.0D, 0.0F - f1, p_78439_4_, p_78439_5_);
        p_78439_1_.func_78374_a(0.0D, 0.0D, 0.0F - f1, p_78439_2_, p_78439_5_);
        p_78439_1_.func_78381_a();
        p_78439_1_.func_78382_b();
        p_78439_1_.func_78375_b(-1F, 0.0F, 0.0F);
        for(int i = 0; i < 16; i++)
        {
            float f2 = (float)i / 16F;
            float f6 = (p_78439_2_ + (p_78439_4_ - p_78439_2_) * f2) - 0.001953125F;
            float f10 = f * f2;
            p_78439_1_.func_78374_a(f10, 0.0D, 0.0F - f1, f6, p_78439_5_);
            p_78439_1_.func_78374_a(f10, 0.0D, 0.0D, f6, p_78439_5_);
            p_78439_1_.func_78374_a(f10, 1.0D, 0.0D, f6, p_78439_3_);
            p_78439_1_.func_78374_a(f10, 1.0D, 0.0F - f1, f6, p_78439_3_);
        }

        p_78439_1_.func_78381_a();
        p_78439_1_.func_78382_b();
        p_78439_1_.func_78375_b(1.0F, 0.0F, 0.0F);
        for(int j = 0; j < 16; j++)
        {
            float f3 = (float)j / 16F;
            float f7 = (p_78439_2_ + (p_78439_4_ - p_78439_2_) * f3) - 0.001953125F;
            float f11 = f * f3 + 0.0625F;
            p_78439_1_.func_78374_a(f11, 1.0D, 0.0F - f1, f7, p_78439_3_);
            p_78439_1_.func_78374_a(f11, 1.0D, 0.0D, f7, p_78439_3_);
            p_78439_1_.func_78374_a(f11, 0.0D, 0.0D, f7, p_78439_5_);
            p_78439_1_.func_78374_a(f11, 0.0D, 0.0F - f1, f7, p_78439_5_);
        }

        p_78439_1_.func_78381_a();
        p_78439_1_.func_78382_b();
        p_78439_1_.func_78375_b(0.0F, 1.0F, 0.0F);
        for(int k = 0; k < 16; k++)
        {
            float f4 = (float)k / 16F;
            float f8 = (p_78439_5_ + (p_78439_3_ - p_78439_5_) * f4) - 0.001953125F;
            float f12 = f * f4 + 0.0625F;
            p_78439_1_.func_78374_a(0.0D, f12, 0.0D, p_78439_2_, f8);
            p_78439_1_.func_78374_a(f, f12, 0.0D, p_78439_4_, f8);
            p_78439_1_.func_78374_a(f, f12, 0.0F - f1, p_78439_4_, f8);
            p_78439_1_.func_78374_a(0.0D, f12, 0.0F - f1, p_78439_2_, f8);
        }

        p_78439_1_.func_78381_a();
        p_78439_1_.func_78382_b();
        p_78439_1_.func_78375_b(0.0F, -1F, 0.0F);
        for(int l = 0; l < 16; l++)
        {
            float f5 = (float)l / 16F;
            float f9 = (p_78439_5_ + (p_78439_3_ - p_78439_5_) * f5) - 0.001953125F;
            float f13 = f * f5;
            p_78439_1_.func_78374_a(f, f13, 0.0D, p_78439_4_, f9);
            p_78439_1_.func_78374_a(0.0D, f13, 0.0D, p_78439_2_, f9);
            p_78439_1_.func_78374_a(0.0D, f13, 0.0F - f1, p_78439_2_, f9);
            p_78439_1_.func_78374_a(f, f13, 0.0F - f1, p_78439_4_, f9);
        }

        p_78439_1_.func_78381_a();
    }

    public void func_78440_a(float p_78440_1_)
    {
        float f = field_78451_d + (field_78454_c - field_78451_d) * p_78440_1_;
        EntityClientPlayerMP entityclientplayermp = field_78455_a.field_71439_g;
        float f1 = ((EntityPlayer) (entityclientplayermp)).field_70127_C + (((EntityPlayer) (entityclientplayermp)).field_70125_A - ((EntityPlayer) (entityclientplayermp)).field_70127_C) * p_78440_1_;
        GL11.glPushMatrix();
        GL11.glRotatef(f1, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(((EntityPlayer) (entityclientplayermp)).field_70126_B + (((EntityPlayer) (entityclientplayermp)).field_70177_z - ((EntityPlayer) (entityclientplayermp)).field_70126_B) * p_78440_1_, 0.0F, 1.0F, 0.0F);
        RenderHelper.func_74519_b();
        GL11.glPopMatrix();
        if(entityclientplayermp instanceof EntityPlayerSP)
        {
            EntityClientPlayerMP entityclientplayermp1 = entityclientplayermp;
            float f2 = ((EntityPlayerSP) (entityclientplayermp1)).field_71164_i + (((EntityPlayerSP) (entityclientplayermp1)).field_71155_g - ((EntityPlayerSP) (entityclientplayermp1)).field_71164_i) * p_78440_1_;
            float f4 = ((EntityPlayerSP) (entityclientplayermp1)).field_71163_h + (((EntityPlayerSP) (entityclientplayermp1)).field_71154_f - ((EntityPlayerSP) (entityclientplayermp1)).field_71163_h) * p_78440_1_;
            GL11.glRotatef((((EntityPlayer) (entityclientplayermp)).field_70125_A - f2) * 0.1F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef((((EntityPlayer) (entityclientplayermp)).field_70177_z - f4) * 0.1F, 0.0F, 1.0F, 0.0F);
        }
        ItemStack itemstack = field_78453_b;
        float f3 = field_78455_a.field_71441_e.func_72801_o(MathHelper.func_76128_c(((EntityPlayer) (entityclientplayermp)).field_70165_t), MathHelper.func_76128_c(((EntityPlayer) (entityclientplayermp)).field_70163_u), MathHelper.func_76128_c(((EntityPlayer) (entityclientplayermp)).field_70161_v));
        f3 = 1.0F;
        int i = field_78455_a.field_71441_e.func_72802_i(MathHelper.func_76128_c(((EntityPlayer) (entityclientplayermp)).field_70165_t), MathHelper.func_76128_c(((EntityPlayer) (entityclientplayermp)).field_70163_u), MathHelper.func_76128_c(((EntityPlayer) (entityclientplayermp)).field_70161_v), 0);
        int j = i % 0x10000;
        int k = i / 0x10000;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if(itemstack != null)
        {
            int l = Item.field_77698_e[itemstack.field_77993_c].func_77620_a(itemstack.func_77960_j(), 0);
            float f8 = (float)(l >> 16 & 0xff) / 255F;
            float f13 = (float)(l >> 8 & 0xff) / 255F;
            float f19 = (float)(l & 0xff) / 255F;
            GL11.glColor4f(f3 * f8, f3 * f13, f3 * f19, 1.0F);
        } else
        {
            GL11.glColor4f(f3, f3, f3, 1.0F);
        }
        if(itemstack != null && itemstack.field_77993_c == Item.field_77744_bd.field_77779_bT)
        {
            GL11.glPushMatrix();
            float f5 = 0.8F;
            float f9 = entityclientplayermp.func_70678_g(p_78440_1_);
            float f14 = MathHelper.func_76126_a(f9 * 3.141593F);
            float f20 = MathHelper.func_76126_a(MathHelper.func_76129_c(f9) * 3.141593F);
            GL11.glTranslatef(-f20 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(f9) * 3.141593F * 2.0F) * 0.2F, -f14 * 0.2F);
            f9 = (1.0F - f1 / 45F) + 0.1F;
            if(f9 < 0.0F)
            {
                f9 = 0.0F;
            }
            if(f9 > 1.0F)
            {
                f9 = 1.0F;
            }
            f9 = -MathHelper.func_76134_b(f9 * 3.141593F) * 0.5F + 0.5F;
            GL11.glTranslatef(0.0F, (0.0F * f5 - (1.0F - f) * 1.2F - f9 * 0.5F) + 0.04F, -0.9F * f5);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f9 * -85F, 0.0F, 0.0F, 1.0F);
            GL11.glEnable(32826);
            GL11.glBindTexture(3553, field_78455_a.field_71446_o.func_78350_a(field_78455_a.field_71439_g.field_70120_cr, field_78455_a.field_71439_g.func_70073_O()));
            for(f14 = 0.0F; f14 < 2.0F; f14++)
            {
                f20 = f14 * 2.0F - 1.0F;
                GL11.glPushMatrix();
                GL11.glTranslatef(-0F, -0.6F, 1.1F * f20);
                GL11.glRotatef(-45F * f20, 1.0F, 0.0F, 0.0F);
                GL11.glRotatef(-90F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(59F, 0.0F, 0.0F, 1.0F);
                GL11.glRotatef(-65F * f20, 0.0F, 1.0F, 0.0F);
                Render render = RenderManager.field_78727_a.func_78713_a(field_78455_a.field_71439_g);
                RenderPlayer renderplayer = (RenderPlayer)render;
                float f30 = 1.0F;
                GL11.glScalef(f30, f30, f30);
                renderplayer.func_77106_b();
                GL11.glPopMatrix();
            }

            f14 = entityclientplayermp.func_70678_g(p_78440_1_);
            f20 = MathHelper.func_76126_a(f14 * f14 * 3.141593F);
            float f25 = MathHelper.func_76126_a(MathHelper.func_76129_c(f14) * 3.141593F);
            GL11.glRotatef(-f20 * 20F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f25 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f25 * 80F, 1.0F, 0.0F, 0.0F);
            float f28 = 0.38F;
            GL11.glScalef(f28, f28, f28);
            GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-1F, -1F, 0.0F);
            float f31 = 0.015625F;
            GL11.glScalef(f31, f31, f31);
            field_78455_a.field_71446_o.func_78342_b(field_78455_a.field_71446_o.func_78341_b("/misc/mapbg.png"));
            Tessellator tessellator = Tessellator.field_78398_a;
            GL11.glNormal3f(0.0F, 0.0F, -1F);
            tessellator.func_78382_b();
            byte byte0 = 7;
            tessellator.func_78374_a(0 - byte0, 128 + byte0, 0.0D, 0.0D, 1.0D);
            tessellator.func_78374_a(128 + byte0, 128 + byte0, 0.0D, 1.0D, 1.0D);
            tessellator.func_78374_a(128 + byte0, 0 - byte0, 0.0D, 1.0D, 0.0D);
            tessellator.func_78374_a(0 - byte0, 0 - byte0, 0.0D, 0.0D, 0.0D);
            tessellator.func_78381_a();
            MapData mapdata = Item.field_77744_bd.func_77873_a(itemstack, field_78455_a.field_71441_e);
            field_78449_f.func_78319_a(field_78455_a.field_71439_g, field_78455_a.field_71446_o, mapdata);
            GL11.glPopMatrix();
        } else
        if(itemstack != null)
        {
            GL11.glPushMatrix();
            float f6 = 0.8F;
            if(entityclientplayermp.func_71052_bv() > 0)
            {
                EnumAction enumaction = itemstack.func_77975_n();
                if(enumaction == EnumAction.eat || enumaction == EnumAction.drink)
                {
                    float f15 = ((float)entityclientplayermp.func_71052_bv() - p_78440_1_) + 1.0F;
                    float f21 = 1.0F - f15 / (float)itemstack.func_77988_m();
                    float f26 = 1.0F - f21;
                    f26 = f26 * f26 * f26;
                    f26 = f26 * f26 * f26;
                    f26 = f26 * f26 * f26;
                    float f29 = 1.0F - f26;
                    GL11.glTranslatef(0.0F, MathHelper.func_76135_e(MathHelper.func_76134_b((f15 / 4F) * 3.141593F) * 0.1F) * (float)((double)f21 > 0.20000000000000001D ? 1 : 0), 0.0F);
                    GL11.glTranslatef(f29 * 0.6F, -f29 * 0.5F, 0.0F);
                    GL11.glRotatef(f29 * 90F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(f29 * 10F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(f29 * 30F, 0.0F, 0.0F, 1.0F);
                }
            } else
            {
                float f10 = entityclientplayermp.func_70678_g(p_78440_1_);
                float f16 = MathHelper.func_76126_a(f10 * 3.141593F);
                float f22 = MathHelper.func_76126_a(MathHelper.func_76129_c(f10) * 3.141593F);
                GL11.glTranslatef(-f22 * 0.4F, MathHelper.func_76126_a(MathHelper.func_76129_c(f10) * 3.141593F * 2.0F) * 0.2F, -f16 * 0.2F);
            }
            GL11.glTranslatef(0.7F * f6, -0.65F * f6 - (1.0F - f) * 0.6F, -0.9F * f6);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826);
            float f11 = entityclientplayermp.func_70678_g(p_78440_1_);
            float f17 = MathHelper.func_76126_a(f11 * f11 * 3.141593F);
            float f23 = MathHelper.func_76126_a(MathHelper.func_76129_c(f11) * 3.141593F);
            GL11.glRotatef(-f17 * 20F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f23 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-f23 * 80F, 1.0F, 0.0F, 0.0F);
            float f27 = 0.4F;
            GL11.glScalef(f27, f27, f27);
            if(entityclientplayermp.func_71052_bv() > 0)
            {
                EnumAction enumaction1 = itemstack.func_77975_n();
                if(enumaction1 == EnumAction.block)
                {
                    GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
                    GL11.glRotatef(30F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-80F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(60F, 0.0F, 1.0F, 0.0F);
                } else
                if(enumaction1 == EnumAction.bow)
                {
                    GL11.glRotatef(-18F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-12F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(-8F, 1.0F, 0.0F, 0.0F);
                    GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
                    float f32 = (float)itemstack.func_77988_m() - (((float)entityclientplayermp.func_71052_bv() - p_78440_1_) + 1.0F);
                    float f35 = f32 / 20F;
                    f35 = (f35 * f35 + f35 * 2.0F) / 3F;
                    if(f35 > 1.0F)
                    {
                        f35 = 1.0F;
                    }
                    if(f35 > 0.1F)
                    {
                        GL11.glTranslatef(0.0F, MathHelper.func_76126_a((f32 - 0.1F) * 1.3F) * 0.01F * (f35 - 0.1F), 0.0F);
                    }
                    GL11.glTranslatef(0.0F, 0.0F, f35 * 0.1F);
                    GL11.glRotatef(-335F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(-50F, 0.0F, 1.0F, 0.0F);
                    GL11.glTranslatef(0.0F, 0.5F, 0.0F);
                    float f37 = 1.0F + f35 * 0.2F;
                    GL11.glScalef(1.0F, 1.0F, f37);
                    GL11.glTranslatef(0.0F, -0.5F, 0.0F);
                    GL11.glRotatef(50F, 0.0F, 1.0F, 0.0F);
                    GL11.glRotatef(335F, 0.0F, 0.0F, 1.0F);
                }
            }
            if(itemstack.func_77973_b().func_77629_n_())
            {
                GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
            }
            if(itemstack.func_77973_b().func_77623_v())
            {
                func_78443_a(entityclientplayermp, itemstack, 0);
                int i1 = Item.field_77698_e[itemstack.field_77993_c].func_77620_a(itemstack.func_77960_j(), 1);
                float f33 = (float)(i1 >> 16 & 0xff) / 255F;
                float f36 = (float)(i1 >> 8 & 0xff) / 255F;
                float f38 = (float)(i1 & 0xff) / 255F;
                GL11.glColor4f(f3 * f33, f3 * f36, f3 * f38, 1.0F);
                func_78443_a(entityclientplayermp, itemstack, 1);
            } else
            {
                func_78443_a(entityclientplayermp, itemstack, 0);
            }
            GL11.glPopMatrix();
        } else
        {
            GL11.glPushMatrix();
            float f7 = 0.8F;
            float f12 = entityclientplayermp.func_70678_g(p_78440_1_);
            float f18 = MathHelper.func_76126_a(f12 * 3.141593F);
            float f24 = MathHelper.func_76126_a(MathHelper.func_76129_c(f12) * 3.141593F);
            GL11.glTranslatef(-f24 * 0.3F, MathHelper.func_76126_a(MathHelper.func_76129_c(f12) * 3.141593F * 2.0F) * 0.4F, -f18 * 0.4F);
            GL11.glTranslatef(0.8F * f7, -0.75F * f7 - (1.0F - f) * 0.6F, -0.9F * f7);
            GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
            GL11.glEnable(32826);
            f12 = entityclientplayermp.func_70678_g(p_78440_1_);
            f18 = MathHelper.func_76126_a(f12 * f12 * 3.141593F);
            f24 = MathHelper.func_76126_a(MathHelper.func_76129_c(f12) * 3.141593F);
            GL11.glRotatef(f24 * 70F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-f18 * 20F, 0.0F, 0.0F, 1.0F);
            GL11.glBindTexture(3553, field_78455_a.field_71446_o.func_78350_a(field_78455_a.field_71439_g.field_70120_cr, field_78455_a.field_71439_g.func_70073_O()));
            GL11.glTranslatef(-1F, 3.6F, 3.5F);
            GL11.glRotatef(120F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(200F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-135F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glTranslatef(5.6F, 0.0F, 0.0F);
            Render render1 = RenderManager.field_78727_a.func_78713_a(field_78455_a.field_71439_g);
            RenderPlayer renderplayer1 = (RenderPlayer)render1;
            float f34 = 1.0F;
            GL11.glScalef(f34, f34, f34);
            renderplayer1.func_77106_b();
            GL11.glPopMatrix();
        }
        GL11.glDisable(32826);
        RenderHelper.func_74518_a();
    }

    public void func_78447_b(float p_78447_1_)
    {
        GL11.glDisable(3008);
        if(field_78455_a.field_71439_g.func_70027_ad())
        {
            int i = field_78455_a.field_71446_o.func_78341_b("/terrain.png");
            GL11.glBindTexture(3553, i);
            func_78442_d(p_78447_1_);
        }
        if(field_78455_a.field_71439_g.func_70094_T())
        {
            int j = MathHelper.func_76128_c(field_78455_a.field_71439_g.field_70165_t);
            int l = MathHelper.func_76128_c(field_78455_a.field_71439_g.field_70163_u);
            int i1 = MathHelper.func_76128_c(field_78455_a.field_71439_g.field_70161_v);
            int j1 = field_78455_a.field_71446_o.func_78341_b("/terrain.png");
            GL11.glBindTexture(3553, j1);
            int k1 = field_78455_a.field_71441_e.func_72798_a(j, l, i1);
            if(field_78455_a.field_71441_e.func_72809_s(j, l, i1))
            {
                func_78446_a(p_78447_1_, Block.field_71973_m[k1].func_71851_a(2));
            } else
            {
                for(int l1 = 0; l1 < 8; l1++)
                {
                    float f = ((float)((l1 >> 0) % 2) - 0.5F) * field_78455_a.field_71439_g.field_70130_N * 0.9F;
                    float f1 = ((float)((l1 >> 1) % 2) - 0.5F) * field_78455_a.field_71439_g.field_70131_O * 0.2F;
                    float f2 = ((float)((l1 >> 2) % 2) - 0.5F) * field_78455_a.field_71439_g.field_70130_N * 0.9F;
                    int i2 = MathHelper.func_76141_d((float)j + f);
                    int j2 = MathHelper.func_76141_d((float)l + f1);
                    int k2 = MathHelper.func_76141_d((float)i1 + f2);
                    if(field_78455_a.field_71441_e.func_72809_s(i2, j2, k2))
                    {
                        k1 = field_78455_a.field_71441_e.func_72798_a(i2, j2, k2);
                    }
                }

            }
            if(Block.field_71973_m[k1] != null)
            {
                func_78446_a(p_78447_1_, Block.field_71973_m[k1].func_71851_a(2));
            }
        }
        if(field_78455_a.field_71439_g.func_70055_a(Material.field_76244_g))
        {
            int k = field_78455_a.field_71446_o.func_78341_b("/misc/water.png");
            GL11.glBindTexture(3553, k);
            func_78448_c(p_78447_1_);
        }
        GL11.glEnable(3008);
    }

    private void func_78446_a(float p_78446_1_, int p_78446_2_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        float f = field_78455_a.field_71439_g.func_70013_c(p_78446_1_);
        f = 0.1F;
        GL11.glColor4f(f, f, f, 0.5F);
        GL11.glPushMatrix();
        float f1 = -1F;
        float f2 = 1.0F;
        float f3 = -1F;
        float f4 = 1.0F;
        float f5 = -0.5F;
        float f6 = 0.0078125F;
        float f7 = (float)(p_78446_2_ % 16) / 256F - f6;
        float f8 = ((float)(p_78446_2_ % 16) + 15.99F) / 256F + f6;
        float f9 = (float)(p_78446_2_ / 16) / 256F - f6;
        float f10 = ((float)(p_78446_2_ / 16) + 15.99F) / 256F + f6;
        tessellator.func_78382_b();
        tessellator.func_78374_a(f1, f3, f5, f8, f10);
        tessellator.func_78374_a(f2, f3, f5, f7, f10);
        tessellator.func_78374_a(f2, f4, f5, f7, f9);
        tessellator.func_78374_a(f1, f4, f5, f8, f9);
        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    private void func_78448_c(float p_78448_1_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        float f = field_78455_a.field_71439_g.func_70013_c(p_78448_1_);
        GL11.glColor4f(f, f, f, 0.5F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        float f1 = 4F;
        float f2 = -1F;
        float f3 = 1.0F;
        float f4 = -1F;
        float f5 = 1.0F;
        float f6 = -0.5F;
        float f7 = -field_78455_a.field_71439_g.field_70177_z / 64F;
        float f8 = field_78455_a.field_71439_g.field_70125_A / 64F;
        tessellator.func_78382_b();
        tessellator.func_78374_a(f2, f4, f6, f1 + f7, f1 + f8);
        tessellator.func_78374_a(f3, f4, f6, 0.0F + f7, f1 + f8);
        tessellator.func_78374_a(f3, f5, f6, 0.0F + f7, 0.0F + f8);
        tessellator.func_78374_a(f2, f5, f6, f1 + f7, 0.0F + f8);
        tessellator.func_78381_a();
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
    }

    private void func_78442_d(float p_78442_1_)
    {
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        float f = 1.0F;
        for(int i = 0; i < 2; i++)
        {
            GL11.glPushMatrix();
            int j = Block.field_72067_ar.field_72059_bZ + i * 16;
            int k = (j & 0xf) << 4;
            int l = j & 0xf0;
            float f1 = (float)k / 256F;
            float f2 = ((float)k + 15.99F) / 256F;
            float f3 = (float)l / 256F;
            float f4 = ((float)l + 15.99F) / 256F;
            float f5 = (0.0F - f) / 2.0F;
            float f6 = f5 + f;
            float f7 = 0.0F - f / 2.0F;
            float f8 = f7 + f;
            float f9 = -0.5F;
            GL11.glTranslatef((float)(-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            GL11.glRotatef((float)(i * 2 - 1) * 10F, 0.0F, 1.0F, 0.0F);
            tessellator.func_78382_b();
            tessellator.func_78374_a(f5, f7, f9, f2, f4);
            tessellator.func_78374_a(f6, f7, f9, f1, f4);
            tessellator.func_78374_a(f6, f8, f9, f1, f3);
            tessellator.func_78374_a(f5, f8, f9, f2, f3);
            tessellator.func_78381_a();
            GL11.glPopMatrix();
        }

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(3042);
    }

    public void func_78441_a()
    {
        field_78451_d = field_78454_c;
        EntityClientPlayerMP entityclientplayermp = field_78455_a.field_71439_g;
        ItemStack itemstack = ((EntityPlayer) (entityclientplayermp)).field_71071_by.func_70448_g();
        boolean flag = field_78450_g == ((EntityPlayer) (entityclientplayermp)).field_71071_by.field_70461_c && itemstack == field_78453_b;
        if(field_78453_b == null && itemstack == null)
        {
            flag = true;
        }
        if(itemstack != null && field_78453_b != null && itemstack != field_78453_b && itemstack.field_77993_c == field_78453_b.field_77993_c && itemstack.func_77960_j() == field_78453_b.func_77960_j())
        {
            field_78453_b = itemstack;
            flag = true;
        }
        float f = 0.4F;
        float f1 = flag ? 1.0F : 0.0F;
        float f2 = f1 - field_78454_c;
        if(f2 < -f)
        {
            f2 = -f;
        }
        if(f2 > f)
        {
            f2 = f;
        }
        field_78454_c += f2;
        if(field_78454_c < 0.1F)
        {
            field_78453_b = itemstack;
            field_78450_g = ((EntityPlayer) (entityclientplayermp)).field_71071_by.field_70461_c;
        }
    }

    public void func_78444_b()
    {
        field_78454_c = 0.0F;
    }

    public void func_78445_c()
    {
        field_78454_c = 0.0F;
    }
}
