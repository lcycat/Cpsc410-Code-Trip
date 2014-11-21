// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            EntitySpider, RenderSpider, EntityCaveSpider, EntityPig, 
//            RenderPig, ModelPig, EntitySheep, RenderSheep, 
//            ModelSheep2, ModelSheep1, EntityCow, RenderCow, 
//            ModelCow, EntityMooshroom, RenderMooshroom, EntityWolf, 
//            RenderWolf, ModelWolf, EntityChicken, RenderChicken, 
//            ModelChicken, EntityOcelot, RenderOcelot, ModelOcelot, 
//            EntitySilverfish, RenderSilverfish, EntityCreeper, RenderCreeper, 
//            EntityEnderman, RenderEnderman, EntitySnowman, RenderSnowMan, 
//            EntitySkeleton, RenderBiped, ModelSkeleton, EntityBlaze, 
//            RenderBlaze, EntityZombie, ModelZombie, EntitySlime, 
//            RenderSlime, ModelSlime, EntityMagmaCube, RenderMagmaCube, 
//            EntityPlayer, RenderPlayer, EntityGiantZombie, RenderGiantZombie, 
//            EntityGhast, RenderGhast, EntitySquid, RenderSquid, 
//            ModelSquid, EntityVillager, RenderVillager, EntityIronGolem, 
//            RenderIronGolem, EntityLiving, RenderLiving, ModelBiped, 
//            EntityDragon, RenderDragon, EntityEnderCrystal, RenderEnderCrystal, 
//            Entity, RenderEntity, EntityPainting, RenderPainting, 
//            EntityArrow, RenderArrow, EntitySnowball, RenderSnowball, 
//            Item, EntityEnderPearl, EntityEnderEye, EntityEgg, 
//            EntityPotion, EntityExpBottle, EntityFireball, RenderFireball, 
//            EntitySmallFireball, EntityItem, RenderItem, EntityXPOrb, 
//            RenderXPOrb, EntityTNTPrimed, RenderTNTPrimed, EntityFallingSand, 
//            RenderFallingSand, EntityMinecart, RenderMinecart, EntityBoat, 
//            RenderBoat, EntityFishHook, RenderFish, EntityLightningBolt, 
//            RenderLightningBolt, ModLoader, Render, MathHelper, 
//            World, Block, GameSettings, OpenGlHelper, 
//            FontRenderer, RenderEngine, ItemRenderer

public class RenderManager
{

    private Map field_78729_o;
    public static RenderManager field_78727_a = new RenderManager();
    private FontRenderer field_78736_p;
    public static double field_78725_b;
    public static double field_78726_c;
    public static double field_78723_d;
    public RenderEngine field_78724_e;
    public ItemRenderer field_78721_f;
    public World field_78722_g;
    public EntityLiving field_78734_h;
    public float field_78735_i;
    public float field_78732_j;
    public GameSettings field_78733_k;
    public double field_78730_l;
    public double field_78731_m;
    public double field_78728_n;

    private RenderManager()
    {
        field_78729_o = new HashMap();
        field_78729_o.put(net.minecraft.src.EntitySpider.class, new RenderSpider());
        field_78729_o.put(net.minecraft.src.EntityCaveSpider.class, new RenderSpider());
        field_78729_o.put(net.minecraft.src.EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5F), 0.7F));
        field_78729_o.put(net.minecraft.src.EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
        field_78729_o.put(net.minecraft.src.EntityCow.class, new RenderCow(new ModelCow(), 0.7F));
        field_78729_o.put(net.minecraft.src.EntityMooshroom.class, new RenderMooshroom(new ModelCow(), 0.7F));
        field_78729_o.put(net.minecraft.src.EntityWolf.class, new RenderWolf(new ModelWolf(), 0.5F));
        field_78729_o.put(net.minecraft.src.EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3F));
        field_78729_o.put(net.minecraft.src.EntityOcelot.class, new RenderOcelot(new ModelOcelot(), 0.4F));
        field_78729_o.put(net.minecraft.src.EntitySilverfish.class, new RenderSilverfish());
        field_78729_o.put(net.minecraft.src.EntityCreeper.class, new RenderCreeper());
        field_78729_o.put(net.minecraft.src.EntityEnderman.class, new RenderEnderman());
        field_78729_o.put(net.minecraft.src.EntitySnowman.class, new RenderSnowMan());
        field_78729_o.put(net.minecraft.src.EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5F));
        field_78729_o.put(net.minecraft.src.EntityBlaze.class, new RenderBlaze());
        field_78729_o.put(net.minecraft.src.EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
        field_78729_o.put(net.minecraft.src.EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
        field_78729_o.put(net.minecraft.src.EntityMagmaCube.class, new RenderMagmaCube());
        field_78729_o.put(net.minecraft.src.EntityPlayer.class, new RenderPlayer());
        field_78729_o.put(net.minecraft.src.EntityGiantZombie.class, new RenderGiantZombie(new ModelZombie(), 0.5F, 6F));
        field_78729_o.put(net.minecraft.src.EntityGhast.class, new RenderGhast());
        field_78729_o.put(net.minecraft.src.EntitySquid.class, new RenderSquid(new ModelSquid(), 0.7F));
        field_78729_o.put(net.minecraft.src.EntityVillager.class, new RenderVillager());
        field_78729_o.put(net.minecraft.src.EntityIronGolem.class, new RenderIronGolem());
        field_78729_o.put(net.minecraft.src.EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5F));
        field_78729_o.put(net.minecraft.src.EntityDragon.class, new RenderDragon());
        field_78729_o.put(net.minecraft.src.EntityEnderCrystal.class, new RenderEnderCrystal());
        field_78729_o.put(net.minecraft.src.Entity.class, new RenderEntity());
        field_78729_o.put(net.minecraft.src.EntityPainting.class, new RenderPainting());
        field_78729_o.put(net.minecraft.src.EntityArrow.class, new RenderArrow());
        field_78729_o.put(net.minecraft.src.EntitySnowball.class, new RenderSnowball(Item.field_77768_aD.func_77617_a(0)));
        field_78729_o.put(net.minecraft.src.EntityEnderPearl.class, new RenderSnowball(Item.field_77730_bn.func_77617_a(0)));
        field_78729_o.put(net.minecraft.src.EntityEnderEye.class, new RenderSnowball(Item.field_77748_bA.func_77617_a(0)));
        field_78729_o.put(net.minecraft.src.EntityEgg.class, new RenderSnowball(Item.field_77764_aP.func_77617_a(0)));
        field_78729_o.put(net.minecraft.src.EntityPotion.class, new RenderSnowball(154));
        field_78729_o.put(net.minecraft.src.EntityExpBottle.class, new RenderSnowball(Item.field_77809_bD.func_77617_a(0)));
        field_78729_o.put(net.minecraft.src.EntityFireball.class, new RenderFireball(2.0F));
        field_78729_o.put(net.minecraft.src.EntitySmallFireball.class, new RenderFireball(0.5F));
        field_78729_o.put(net.minecraft.src.EntityItem.class, new RenderItem());
        field_78729_o.put(net.minecraft.src.EntityXPOrb.class, new RenderXPOrb());
        field_78729_o.put(net.minecraft.src.EntityTNTPrimed.class, new RenderTNTPrimed());
        field_78729_o.put(net.minecraft.src.EntityFallingSand.class, new RenderFallingSand());
        field_78729_o.put(net.minecraft.src.EntityMinecart.class, new RenderMinecart());
        field_78729_o.put(net.minecraft.src.EntityBoat.class, new RenderBoat());
        field_78729_o.put(net.minecraft.src.EntityFishHook.class, new RenderFish());
        field_78729_o.put(net.minecraft.src.EntityLightningBolt.class, new RenderLightningBolt());
        ModLoader.addAllRenderers(field_78729_o);
        Render render;
        for(Iterator iterator = field_78729_o.values().iterator(); iterator.hasNext(); render.func_76976_a(this))
        {
            render = (Render)iterator.next();
        }

    }

    public Render func_78715_a(Class p_78715_1_)
    {
        Render render = (Render)field_78729_o.get(p_78715_1_);
        if(render == null && p_78715_1_ != (net.minecraft.src.Entity.class))
        {
            render = func_78715_a(p_78715_1_.getSuperclass());
            field_78729_o.put(p_78715_1_, render);
        }
        return render;
    }

    public Render func_78713_a(Entity p_78713_1_)
    {
        return func_78715_a(p_78713_1_.getClass());
    }

    public void func_78718_a(World p_78718_1_, RenderEngine p_78718_2_, FontRenderer p_78718_3_, EntityLiving p_78718_4_, GameSettings p_78718_5_, float p_78718_6_)
    {
        field_78722_g = p_78718_1_;
        field_78724_e = p_78718_2_;
        field_78733_k = p_78718_5_;
        field_78734_h = p_78718_4_;
        field_78736_p = p_78718_3_;
        if(p_78718_4_.func_70608_bn())
        {
            int i = p_78718_1_.func_72798_a(MathHelper.func_76128_c(p_78718_4_.field_70165_t), MathHelper.func_76128_c(p_78718_4_.field_70163_u), MathHelper.func_76128_c(p_78718_4_.field_70161_v));
            if(i == Block.field_71959_S.field_71990_ca)
            {
                int j = p_78718_1_.func_72805_g(MathHelper.func_76128_c(p_78718_4_.field_70165_t), MathHelper.func_76128_c(p_78718_4_.field_70163_u), MathHelper.func_76128_c(p_78718_4_.field_70161_v));
                int k = j & 3;
                field_78735_i = k * 90 + 180;
                field_78732_j = 0.0F;
            }
        } else
        {
            field_78735_i = p_78718_4_.field_70126_B + (p_78718_4_.field_70177_z - p_78718_4_.field_70126_B) * p_78718_6_;
            field_78732_j = p_78718_4_.field_70127_C + (p_78718_4_.field_70125_A - p_78718_4_.field_70127_C) * p_78718_6_;
        }
        if(p_78718_5_.field_74320_O == 2)
        {
            field_78735_i += 180F;
        }
        field_78730_l = p_78718_4_.field_70142_S + (p_78718_4_.field_70165_t - p_78718_4_.field_70142_S) * (double)p_78718_6_;
        field_78731_m = p_78718_4_.field_70137_T + (p_78718_4_.field_70163_u - p_78718_4_.field_70137_T) * (double)p_78718_6_;
        field_78728_n = p_78718_4_.field_70136_U + (p_78718_4_.field_70161_v - p_78718_4_.field_70136_U) * (double)p_78718_6_;
    }

    public void func_78720_a(Entity p_78720_1_, float p_78720_2_)
    {
        double d = p_78720_1_.field_70142_S + (p_78720_1_.field_70165_t - p_78720_1_.field_70142_S) * (double)p_78720_2_;
        double d1 = p_78720_1_.field_70137_T + (p_78720_1_.field_70163_u - p_78720_1_.field_70137_T) * (double)p_78720_2_;
        double d2 = p_78720_1_.field_70136_U + (p_78720_1_.field_70161_v - p_78720_1_.field_70136_U) * (double)p_78720_2_;
        float f = p_78720_1_.field_70126_B + (p_78720_1_.field_70177_z - p_78720_1_.field_70126_B) * p_78720_2_;
        int i = p_78720_1_.func_70070_b(p_78720_2_);
        if(p_78720_1_.func_70027_ad())
        {
            i = 0xf000f0;
        }
        int j = i % 0x10000;
        int k = i / 0x10000;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        func_78719_a(p_78720_1_, d - field_78725_b, d1 - field_78726_c, d2 - field_78723_d, f, p_78720_2_);
    }

    public void func_78719_a(Entity p_78719_1_, double p_78719_2_, double p_78719_4_, double p_78719_6_, 
            float p_78719_8_, float p_78719_9_)
    {
        Render render = func_78713_a(p_78719_1_);
        if(render != null)
        {
            render.func_76986_a(p_78719_1_, p_78719_2_, p_78719_4_, p_78719_6_, p_78719_8_, p_78719_9_);
            render.func_76979_b(p_78719_1_, p_78719_2_, p_78719_4_, p_78719_6_, p_78719_8_, p_78719_9_);
        }
    }

    public void func_78717_a(World p_78717_1_)
    {
        field_78722_g = p_78717_1_;
    }

    public double func_78714_a(double p_78714_1_, double p_78714_3_, double p_78714_5_)
    {
        double d = p_78714_1_ - field_78730_l;
        double d1 = p_78714_3_ - field_78731_m;
        double d2 = p_78714_5_ - field_78728_n;
        return d * d + d1 * d1 + d2 * d2;
    }

    public FontRenderer func_78716_a()
    {
        return field_78736_p;
    }

}
