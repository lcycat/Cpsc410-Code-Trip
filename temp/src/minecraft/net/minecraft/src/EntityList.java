// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityEggInfo, World, Entity, NBTTagCompound, 
//            EntityItem, EntityXPOrb, EntityPainting, EntityArrow, 
//            EntitySnowball, EntityFireball, EntitySmallFireball, EntityEnderPearl, 
//            EntityEnderEye, EntityPotion, EntityExpBottle, EntityTNTPrimed, 
//            EntityFallingSand, EntityMinecart, EntityBoat, EntityLiving, 
//            EntityMob, EntityCreeper, EntitySkeleton, EntitySpider, 
//            EntityGiantZombie, EntityZombie, EntitySlime, EntityGhast, 
//            EntityPigZombie, EntityEnderman, EntityCaveSpider, EntitySilverfish, 
//            EntityBlaze, EntityMagmaCube, EntityDragon, EntityPig, 
//            EntitySheep, EntityCow, EntityChicken, EntitySquid, 
//            EntityWolf, EntityMooshroom, EntitySnowman, EntityOcelot, 
//            EntityIronGolem, EntityVillager, EntityEnderCrystal

public class EntityList
{

    private static Map field_75625_b = new HashMap();
    private static Map field_75626_c = new HashMap();
    private static Map field_75623_d = new HashMap();
    private static Map field_75624_e = new HashMap();
    private static Map field_75622_f = new HashMap();
    public static HashMap field_75627_a = new LinkedHashMap();

    private static void func_75618_a(Class p_75618_0_, String p_75618_1_, int p_75618_2_)
    {
        field_75625_b.put(p_75618_1_, p_75618_0_);
        field_75626_c.put(p_75618_0_, p_75618_1_);
        field_75623_d.put(Integer.valueOf(p_75618_2_), p_75618_0_);
        field_75624_e.put(p_75618_0_, Integer.valueOf(p_75618_2_));
        field_75622_f.put(p_75618_1_, Integer.valueOf(p_75618_2_));
    }

    private static void func_75614_a(Class p_75614_0_, String p_75614_1_, int p_75614_2_, int p_75614_3_, int p_75614_4_)
    {
        func_75618_a(p_75614_0_, p_75614_1_, p_75614_2_);
        field_75627_a.put(Integer.valueOf(p_75614_2_), new EntityEggInfo(p_75614_2_, p_75614_3_, p_75614_4_));
    }

    public static Entity func_75620_a(String p_75620_0_, World p_75620_1_)
    {
        Entity entity = null;
        try
        {
            Class class1 = (Class)field_75625_b.get(p_75620_0_);
            if(class1 != null)
            {
                entity = (Entity)class1.getConstructor(new Class[] {
                    net.minecraft.src.World.class
                }).newInstance(new Object[] {
                    p_75620_1_
                });
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return entity;
    }

    public static Entity func_75615_a(NBTTagCompound p_75615_0_, World p_75615_1_)
    {
        Entity entity = null;
        try
        {
            Class class1 = (Class)field_75625_b.get(p_75615_0_.func_74779_i("id"));
            if(class1 != null)
            {
                entity = (Entity)class1.getConstructor(new Class[] {
                    net.minecraft.src.World.class
                }).newInstance(new Object[] {
                    p_75615_1_
                });
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(entity != null)
        {
            entity.func_70020_e(p_75615_0_);
        } else
        {
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(p_75615_0_.func_74779_i("id")).toString());
        }
        return entity;
    }

    public static Entity func_75616_a(int p_75616_0_, World p_75616_1_)
    {
        Entity entity = null;
        try
        {
            Class class1 = (Class)field_75623_d.get(Integer.valueOf(p_75616_0_));
            if(class1 != null)
            {
                entity = (Entity)class1.getConstructor(new Class[] {
                    net.minecraft.src.World.class
                }).newInstance(new Object[] {
                    p_75616_1_
                });
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        if(entity == null)
        {
            System.out.println((new StringBuilder()).append("Skipping Entity with id ").append(p_75616_0_).toString());
        }
        return entity;
    }

    public static int func_75619_a(Entity p_75619_0_)
    {
        Class class1 = p_75619_0_.getClass();
        return field_75624_e.containsKey(class1) ? ((Integer)field_75624_e.get(class1)).intValue() : 0;
    }

    public static String func_75621_b(Entity p_75621_0_)
    {
        return (String)field_75626_c.get(p_75621_0_.getClass());
    }

    public static String func_75617_a(int p_75617_0_)
    {
        Class class1 = (Class)field_75623_d.get(Integer.valueOf(p_75617_0_));
        if(class1 != null)
        {
            return (String)field_75626_c.get(class1);
        } else
        {
            return null;
        }
    }

    static 
    {
        func_75618_a(net.minecraft.src.EntityItem.class, "Item", 1);
        func_75618_a(net.minecraft.src.EntityXPOrb.class, "XPOrb", 2);
        func_75618_a(net.minecraft.src.EntityPainting.class, "Painting", 9);
        func_75618_a(net.minecraft.src.EntityArrow.class, "Arrow", 10);
        func_75618_a(net.minecraft.src.EntitySnowball.class, "Snowball", 11);
        func_75618_a(net.minecraft.src.EntityFireball.class, "Fireball", 12);
        func_75618_a(net.minecraft.src.EntitySmallFireball.class, "SmallFireball", 13);
        func_75618_a(net.minecraft.src.EntityEnderPearl.class, "ThrownEnderpearl", 14);
        func_75618_a(net.minecraft.src.EntityEnderEye.class, "EyeOfEnderSignal", 15);
        func_75618_a(net.minecraft.src.EntityPotion.class, "ThrownPotion", 16);
        func_75618_a(net.minecraft.src.EntityExpBottle.class, "ThrownExpBottle", 17);
        func_75618_a(net.minecraft.src.EntityTNTPrimed.class, "PrimedTnt", 20);
        func_75618_a(net.minecraft.src.EntityFallingSand.class, "FallingSand", 21);
        func_75618_a(net.minecraft.src.EntityMinecart.class, "Minecart", 40);
        func_75618_a(net.minecraft.src.EntityBoat.class, "Boat", 41);
        func_75618_a(net.minecraft.src.EntityLiving.class, "Mob", 48);
        func_75618_a(net.minecraft.src.EntityMob.class, "Monster", 49);
        func_75614_a(net.minecraft.src.EntityCreeper.class, "Creeper", 50, 0xda70b, 0);
        func_75614_a(net.minecraft.src.EntitySkeleton.class, "Skeleton", 51, 0xc1c1c1, 0x494949);
        func_75614_a(net.minecraft.src.EntitySpider.class, "Spider", 52, 0x342d27, 0xa80e0e);
        func_75618_a(net.minecraft.src.EntityGiantZombie.class, "Giant", 53);
        func_75614_a(net.minecraft.src.EntityZombie.class, "Zombie", 54, 44975, 0x799c65);
        func_75614_a(net.minecraft.src.EntitySlime.class, "Slime", 55, 0x51a03e, 0x7ebf6e);
        func_75614_a(net.minecraft.src.EntityGhast.class, "Ghast", 56, 0xf9f9f9, 0xbcbcbc);
        func_75614_a(net.minecraft.src.EntityPigZombie.class, "PigZombie", 57, 0xea9393, 0x4c7129);
        func_75614_a(net.minecraft.src.EntityEnderman.class, "Enderman", 58, 0x161616, 0);
        func_75614_a(net.minecraft.src.EntityCaveSpider.class, "CaveSpider", 59, 0xc424e, 0xa80e0e);
        func_75614_a(net.minecraft.src.EntitySilverfish.class, "Silverfish", 60, 0x6e6e6e, 0x303030);
        func_75614_a(net.minecraft.src.EntityBlaze.class, "Blaze", 61, 0xf6b201, 0xfff87e);
        func_75614_a(net.minecraft.src.EntityMagmaCube.class, "LavaSlime", 62, 0x340000, 0xfcfc00);
        func_75618_a(net.minecraft.src.EntityDragon.class, "EnderDragon", 63);
        func_75614_a(net.minecraft.src.EntityPig.class, "Pig", 90, 0xf0a5a2, 0xdb635f);
        func_75614_a(net.minecraft.src.EntitySheep.class, "Sheep", 91, 0xe7e7e7, 0xffb5b5);
        func_75614_a(net.minecraft.src.EntityCow.class, "Cow", 92, 0x443626, 0xa1a1a1);
        func_75614_a(net.minecraft.src.EntityChicken.class, "Chicken", 93, 0xa1a1a1, 0xff0000);
        func_75614_a(net.minecraft.src.EntitySquid.class, "Squid", 94, 0x223b4d, 0x708899);
        func_75614_a(net.minecraft.src.EntityWolf.class, "Wolf", 95, 0xd7d3d3, 0xceaf96);
        func_75614_a(net.minecraft.src.EntityMooshroom.class, "MushroomCow", 96, 0xa00f10, 0xb7b7b7);
        func_75618_a(net.minecraft.src.EntitySnowman.class, "SnowMan", 97);
        func_75614_a(net.minecraft.src.EntityOcelot.class, "Ozelot", 98, 0xefde7d, 0x564434);
        func_75618_a(net.minecraft.src.EntityIronGolem.class, "VillagerGolem", 99);
        func_75614_a(net.minecraft.src.EntityVillager.class, "Villager", 120, 0x563c33, 0xbd8b72);
        func_75618_a(net.minecraft.src.EntityEnderCrystal.class, "EnderCrystal", 200);
    }
}
