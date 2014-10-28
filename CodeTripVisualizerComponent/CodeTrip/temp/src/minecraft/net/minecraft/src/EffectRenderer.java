// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntityFX, ActiveRenderInfo, Entity, RenderEngine, 
//            Tessellator, MathHelper, Block, EntityDiggingFX, 
//            World

public class EffectRenderer
{

    protected World field_78878_a;
    private List field_78876_b[];
    private RenderEngine field_78877_c;
    private Random field_78875_d;

    public EffectRenderer(World p_i3170_1_, RenderEngine p_i3170_2_)
    {
        field_78876_b = new List[4];
        field_78875_d = new Random();
        if(p_i3170_1_ != null)
        {
            field_78878_a = p_i3170_1_;
        }
        field_78877_c = p_i3170_2_;
        for(int i = 0; i < 4; i++)
        {
            field_78876_b[i] = new ArrayList();
        }

    }

    public void func_78873_a(EntityFX p_78873_1_)
    {
        int i = p_78873_1_.func_70537_b();
        if(field_78876_b[i].size() >= 4000)
        {
            field_78876_b[i].remove(0);
        }
        field_78876_b[i].add(p_78873_1_);
    }

    public void func_78868_a()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < field_78876_b[i].size(); j++)
            {
                EntityFX entityfx = (EntityFX)field_78876_b[i].get(j);
                entityfx.func_70071_h_();
                if(entityfx.field_70128_L)
                {
                    field_78876_b[i].remove(j--);
                }
            }

        }

    }

    public void func_78874_a(Entity p_78874_1_, float p_78874_2_)
    {
        float f = ActiveRenderInfo.field_74588_d;
        float f1 = ActiveRenderInfo.field_74586_f;
        float f2 = ActiveRenderInfo.field_74587_g;
        float f3 = ActiveRenderInfo.field_74596_h;
        float f4 = ActiveRenderInfo.field_74589_e;
        EntityFX.field_70556_an = p_78874_1_.field_70142_S + (p_78874_1_.field_70165_t - p_78874_1_.field_70142_S) * (double)p_78874_2_;
        EntityFX.field_70554_ao = p_78874_1_.field_70137_T + (p_78874_1_.field_70163_u - p_78874_1_.field_70137_T) * (double)p_78874_2_;
        EntityFX.field_70555_ap = p_78874_1_.field_70136_U + (p_78874_1_.field_70161_v - p_78874_1_.field_70136_U) * (double)p_78874_2_;
        for(int i = 0; i < 3; i++)
        {
            if(field_78876_b[i].isEmpty())
            {
                continue;
            }
            int j = 0;
            if(i == 0)
            {
                j = field_78877_c.func_78341_b("/particles.png");
            }
            if(i == 1)
            {
                j = field_78877_c.func_78341_b("/terrain.png");
            }
            if(i == 2)
            {
                j = field_78877_c.func_78341_b("/gui/items.png");
            }
            GL11.glBindTexture(3553, j);
            Tessellator tessellator = Tessellator.field_78398_a;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            tessellator.func_78382_b();
            for(int k = 0; k < field_78876_b[i].size(); k++)
            {
                EntityFX entityfx = (EntityFX)field_78876_b[i].get(k);
                tessellator.func_78380_c(entityfx.func_70070_b(p_78874_2_));
                entityfx.func_70539_a(tessellator, p_78874_2_, f, f4, f1, f2, f3);
            }

            tessellator.func_78381_a();
        }

    }

    public void func_78872_b(Entity p_78872_1_, float p_78872_2_)
    {
        float f = MathHelper.func_76134_b(p_78872_1_.field_70177_z * 0.01745329F);
        float f1 = MathHelper.func_76126_a(p_78872_1_.field_70177_z * 0.01745329F);
        float f2 = -f1 * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.01745329F);
        float f3 = f * MathHelper.func_76126_a(p_78872_1_.field_70125_A * 0.01745329F);
        float f4 = MathHelper.func_76134_b(p_78872_1_.field_70125_A * 0.01745329F);
        byte byte0 = 3;
        if(field_78876_b[byte0].isEmpty())
        {
            return;
        }
        Tessellator tessellator = Tessellator.field_78398_a;
        for(int i = 0; i < field_78876_b[byte0].size(); i++)
        {
            EntityFX entityfx = (EntityFX)field_78876_b[byte0].get(i);
            tessellator.func_78380_c(entityfx.func_70070_b(p_78872_2_));
            entityfx.func_70539_a(tessellator, p_78872_2_, f, f4, f1, f2, f3);
        }

    }

    public void func_78870_a(World p_78870_1_)
    {
        field_78878_a = p_78870_1_;
        for(int i = 0; i < 4; i++)
        {
            field_78876_b[i].clear();
        }

    }

    public void func_78871_a(int p_78871_1_, int p_78871_2_, int p_78871_3_, int p_78871_4_, int p_78871_5_)
    {
        if(p_78871_4_ == 0)
        {
            return;
        }
        Block block = Block.field_71973_m[p_78871_4_];
        int i = 4;
        for(int j = 0; j < i; j++)
        {
            for(int k = 0; k < i; k++)
            {
                for(int l = 0; l < i; l++)
                {
                    double d = (double)p_78871_1_ + ((double)j + 0.5D) / (double)i;
                    double d1 = (double)p_78871_2_ + ((double)k + 0.5D) / (double)i;
                    double d2 = (double)p_78871_3_ + ((double)l + 0.5D) / (double)i;
                    int i1 = field_78875_d.nextInt(6);
                    func_78873_a((new EntityDiggingFX(field_78878_a, d, d1, d2, d - (double)p_78871_1_ - 0.5D, d1 - (double)p_78871_2_ - 0.5D, d2 - (double)p_78871_3_ - 0.5D, block, i1, p_78871_5_)).func_70596_a(p_78871_1_, p_78871_2_, p_78871_3_));
                }

            }

        }

    }

    public void func_78867_a(int p_78867_1_, int p_78867_2_, int p_78867_3_, int p_78867_4_)
    {
        int i = field_78878_a.func_72798_a(p_78867_1_, p_78867_2_, p_78867_3_);
        if(i == 0)
        {
            return;
        }
        Block block = Block.field_71973_m[i];
        float f = 0.1F;
        double d = (double)p_78867_1_ + field_78875_d.nextDouble() * (block.field_72021_ck - block.field_72026_ch - (double)(f * 2.0F)) + (double)f + block.field_72026_ch;
        double d1 = (double)p_78867_2_ + field_78875_d.nextDouble() * (block.field_72022_cl - block.field_72023_ci - (double)(f * 2.0F)) + (double)f + block.field_72023_ci;
        double d2 = (double)p_78867_3_ + field_78875_d.nextDouble() * (block.field_72019_cm - block.field_72024_cj - (double)(f * 2.0F)) + (double)f + block.field_72024_cj;
        if(p_78867_4_ == 0)
        {
            d1 = ((double)p_78867_2_ + block.field_72023_ci) - (double)f;
        }
        if(p_78867_4_ == 1)
        {
            d1 = (double)p_78867_2_ + block.field_72022_cl + (double)f;
        }
        if(p_78867_4_ == 2)
        {
            d2 = ((double)p_78867_3_ + block.field_72024_cj) - (double)f;
        }
        if(p_78867_4_ == 3)
        {
            d2 = (double)p_78867_3_ + block.field_72019_cm + (double)f;
        }
        if(p_78867_4_ == 4)
        {
            d = ((double)p_78867_1_ + block.field_72026_ch) - (double)f;
        }
        if(p_78867_4_ == 5)
        {
            d = (double)p_78867_1_ + block.field_72021_ck + (double)f;
        }
        func_78873_a((new EntityDiggingFX(field_78878_a, d, d1, d2, 0.0D, 0.0D, 0.0D, block, p_78867_4_, field_78878_a.func_72805_g(p_78867_1_, p_78867_2_, p_78867_3_))).func_70596_a(p_78867_1_, p_78867_2_, p_78867_3_).func_70543_e(0.2F).func_70541_f(0.6F));
    }

    public String func_78869_b()
    {
        return (new StringBuilder()).append("").append(field_78876_b[0].size() + field_78876_b[1].size() + field_78876_b[2].size()).toString();
    }
}
