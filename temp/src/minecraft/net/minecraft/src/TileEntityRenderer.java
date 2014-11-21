// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySign, TileEntitySignRenderer, TileEntityMobSpawner, TileEntityMobSpawnerRenderer, 
//            TileEntityPiston, TileEntityRendererPiston, TileEntityChest, TileEntityChestRenderer, 
//            TileEntityEnderChest, TileEntityEnderChestRenderer, TileEntityEnchantmentTable, RenderEnchantmentTable, 
//            TileEntityEndPortal, RenderEndPortal, TileEntitySpecialRenderer, TileEntity, 
//            EntityLiving, World, OpenGlHelper, FontRenderer, 
//            RenderEngine

public class TileEntityRenderer
{

    private Map field_76966_m;
    public static TileEntityRenderer field_76963_a = new TileEntityRenderer();
    private FontRenderer field_76964_n;
    public static double field_76961_b;
    public static double field_76962_c;
    public static double field_76959_d;
    public RenderEngine field_76960_e;
    public World field_76957_f;
    public EntityLiving field_76958_g;
    public float field_76969_h;
    public float field_76970_i;
    public double field_76967_j;
    public double field_76968_k;
    public double field_76965_l;

    private TileEntityRenderer()
    {
        field_76966_m = new HashMap();
        field_76966_m.put(net.minecraft.src.TileEntitySign.class, new TileEntitySignRenderer());
        field_76966_m.put(net.minecraft.src.TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        field_76966_m.put(net.minecraft.src.TileEntityPiston.class, new TileEntityRendererPiston());
        field_76966_m.put(net.minecraft.src.TileEntityChest.class, new TileEntityChestRenderer());
        field_76966_m.put(net.minecraft.src.TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
        field_76966_m.put(net.minecraft.src.TileEntityEnchantmentTable.class, new RenderEnchantmentTable());
        field_76966_m.put(net.minecraft.src.TileEntityEndPortal.class, new RenderEndPortal());
        TileEntitySpecialRenderer tileentityspecialrenderer;
        for(Iterator iterator = field_76966_m.values().iterator(); iterator.hasNext(); tileentityspecialrenderer.func_76893_a(this))
        {
            tileentityspecialrenderer = (TileEntitySpecialRenderer)iterator.next();
        }

    }

    public TileEntitySpecialRenderer func_76951_a(Class p_76951_1_)
    {
        TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer)field_76966_m.get(p_76951_1_);
        if(tileentityspecialrenderer == null && p_76951_1_ != (net.minecraft.src.TileEntity.class))
        {
            tileentityspecialrenderer = func_76951_a(p_76951_1_.getSuperclass());
            field_76966_m.put(p_76951_1_, tileentityspecialrenderer);
        }
        return tileentityspecialrenderer;
    }

    public boolean func_76952_a(TileEntity p_76952_1_)
    {
        return func_76956_b(p_76952_1_) != null;
    }

    public TileEntitySpecialRenderer func_76956_b(TileEntity p_76956_1_)
    {
        if(p_76956_1_ == null)
        {
            return null;
        } else
        {
            return func_76951_a(p_76956_1_.getClass());
        }
    }

    public void func_76953_a(World p_76953_1_, RenderEngine p_76953_2_, FontRenderer p_76953_3_, EntityLiving p_76953_4_, float p_76953_5_)
    {
        if(field_76957_f != p_76953_1_)
        {
            func_76955_a(p_76953_1_);
        }
        field_76960_e = p_76953_2_;
        field_76958_g = p_76953_4_;
        field_76964_n = p_76953_3_;
        field_76969_h = p_76953_4_.field_70126_B + (p_76953_4_.field_70177_z - p_76953_4_.field_70126_B) * p_76953_5_;
        field_76970_i = p_76953_4_.field_70127_C + (p_76953_4_.field_70125_A - p_76953_4_.field_70127_C) * p_76953_5_;
        field_76967_j = p_76953_4_.field_70142_S + (p_76953_4_.field_70165_t - p_76953_4_.field_70142_S) * (double)p_76953_5_;
        field_76968_k = p_76953_4_.field_70137_T + (p_76953_4_.field_70163_u - p_76953_4_.field_70137_T) * (double)p_76953_5_;
        field_76965_l = p_76953_4_.field_70136_U + (p_76953_4_.field_70161_v - p_76953_4_.field_70136_U) * (double)p_76953_5_;
    }

    public void func_76950_a(TileEntity p_76950_1_, float p_76950_2_)
    {
        if(p_76950_1_.func_70318_a(field_76967_j, field_76968_k, field_76965_l) < 4096D)
        {
            int i = field_76957_f.func_72802_i(p_76950_1_.field_70329_l, p_76950_1_.field_70330_m, p_76950_1_.field_70327_n, 0);
            int j = i % 0x10000;
            int k = i / 0x10000;
            OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            func_76949_a(p_76950_1_, (double)p_76950_1_.field_70329_l - field_76961_b, (double)p_76950_1_.field_70330_m - field_76962_c, (double)p_76950_1_.field_70327_n - field_76959_d, p_76950_2_);
        }
    }

    public void func_76949_a(TileEntity p_76949_1_, double p_76949_2_, double p_76949_4_, double p_76949_6_, 
            float p_76949_8_)
    {
        TileEntitySpecialRenderer tileentityspecialrenderer = func_76956_b(p_76949_1_);
        if(tileentityspecialrenderer != null)
        {
            tileentityspecialrenderer.func_76894_a(p_76949_1_, p_76949_2_, p_76949_4_, p_76949_6_, p_76949_8_);
        }
    }

    public void func_76955_a(World p_76955_1_)
    {
        field_76957_f = p_76955_1_;
        Iterator iterator = field_76966_m.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            TileEntitySpecialRenderer tileentityspecialrenderer = (TileEntitySpecialRenderer)iterator.next();
            if(tileentityspecialrenderer != null)
            {
                tileentityspecialrenderer.func_76896_a(p_76955_1_);
            }
        } while(true);
    }

    public FontRenderer func_76954_a()
    {
        return field_76964_n;
    }

}
