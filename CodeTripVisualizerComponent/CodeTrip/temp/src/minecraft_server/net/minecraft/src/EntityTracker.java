// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            IntHashMap, WorldServer, ServerConfigurationManager, EntityPlayerMP, 
//            EntityTrackerEntry, EntityFishHook, EntityArrow, EntitySmallFireball, 
//            EntityFireball, EntitySnowball, EntityEnderPearl, EntityEnderEye, 
//            EntityEgg, EntityPotion, EntityExpBottle, EntityItem, 
//            EntityMinecart, EntityBoat, EntitySquid, IAnimals, 
//            EntityDragon, EntityTNTPrimed, EntityFallingSand, EntityPainting, 
//            EntityXPOrb, EntityEnderCrystal, ModLoaderMp, Entity, 
//            Packet

public class EntityTracker
{

    private final WorldServer field_72795_a;
    private Set field_72793_b;
    private IntHashMap field_72794_c;
    private int field_72792_d;

    public EntityTracker(WorldServer p_i3389_1_)
    {
        field_72793_b = new HashSet();
        field_72794_c = new IntHashMap();
        field_72795_a = p_i3389_1_;
        field_72792_d = p_i3389_1_.func_73046_m().func_71203_ab().func_72372_a();
    }

    public void func_72786_a(Entity p_72786_1_)
    {
        if(p_72786_1_ instanceof EntityPlayerMP)
        {
            func_72791_a(p_72786_1_, 512, 2);
            EntityPlayerMP entityplayermp = (EntityPlayerMP)p_72786_1_;
            Iterator iterator = field_72793_b.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();
                if(entitytrackerentry.field_73132_a != entityplayermp)
                {
                    entitytrackerentry.func_73117_b(entityplayermp);
                }
            } while(true);
        } else
        if(p_72786_1_ instanceof EntityFishHook)
        {
            func_72785_a(p_72786_1_, 64, 5, true);
        } else
        if(p_72786_1_ instanceof EntityArrow)
        {
            func_72785_a(p_72786_1_, 64, 20, false);
        } else
        if(p_72786_1_ instanceof EntitySmallFireball)
        {
            func_72785_a(p_72786_1_, 64, 10, false);
        } else
        if(p_72786_1_ instanceof EntityFireball)
        {
            func_72785_a(p_72786_1_, 64, 10, false);
        } else
        if(p_72786_1_ instanceof EntitySnowball)
        {
            func_72785_a(p_72786_1_, 64, 10, true);
        } else
        if(p_72786_1_ instanceof EntityEnderPearl)
        {
            func_72785_a(p_72786_1_, 64, 10, true);
        } else
        if(p_72786_1_ instanceof EntityEnderEye)
        {
            func_72785_a(p_72786_1_, 64, 4, true);
        } else
        if(p_72786_1_ instanceof EntityEgg)
        {
            func_72785_a(p_72786_1_, 64, 10, true);
        } else
        if(p_72786_1_ instanceof EntityPotion)
        {
            func_72785_a(p_72786_1_, 64, 10, true);
        } else
        if(p_72786_1_ instanceof EntityExpBottle)
        {
            func_72785_a(p_72786_1_, 64, 10, true);
        } else
        if(p_72786_1_ instanceof EntityItem)
        {
            func_72785_a(p_72786_1_, 64, 20, true);
        } else
        if(p_72786_1_ instanceof EntityMinecart)
        {
            func_72785_a(p_72786_1_, 80, 3, true);
        } else
        if(p_72786_1_ instanceof EntityBoat)
        {
            func_72785_a(p_72786_1_, 80, 3, true);
        } else
        if(p_72786_1_ instanceof EntitySquid)
        {
            func_72785_a(p_72786_1_, 64, 3, true);
        } else
        if(p_72786_1_ instanceof IAnimals)
        {
            func_72785_a(p_72786_1_, 80, 3, true);
        } else
        if(p_72786_1_ instanceof EntityDragon)
        {
            func_72785_a(p_72786_1_, 160, 3, true);
        } else
        if(p_72786_1_ instanceof EntityTNTPrimed)
        {
            func_72785_a(p_72786_1_, 160, 10, true);
        } else
        if(p_72786_1_ instanceof EntityFallingSand)
        {
            func_72785_a(p_72786_1_, 160, 20, true);
        } else
        if(p_72786_1_ instanceof EntityPainting)
        {
            func_72785_a(p_72786_1_, 160, 0x7fffffff, false);
        } else
        if(p_72786_1_ instanceof EntityXPOrb)
        {
            func_72785_a(p_72786_1_, 160, 20, true);
        } else
        if(p_72786_1_ instanceof EntityEnderCrystal)
        {
            func_72785_a(p_72786_1_, 256, 0x7fffffff, false);
        }
        ModLoaderMp.handleEntityTrackers(this, p_72786_1_);
    }

    public void func_72791_a(Entity p_72791_1_, int p_72791_2_, int p_72791_3_)
    {
        func_72785_a(p_72791_1_, p_72791_2_, p_72791_3_, false);
    }

    public void func_72785_a(Entity p_72785_1_, int p_72785_2_, int p_72785_3_, boolean p_72785_4_)
    {
        if(p_72785_2_ > field_72792_d)
        {
            p_72785_2_ = field_72792_d;
        }
        if(field_72794_c.func_76037_b(p_72785_1_.field_70157_k))
        {
            throw new IllegalStateException("Entity is already tracked!");
        } else
        {
            EntityTrackerEntry entitytrackerentry = new EntityTrackerEntry(p_72785_1_, p_72785_2_, p_72785_3_, p_72785_4_);
            field_72793_b.add(entitytrackerentry);
            field_72794_c.func_76038_a(p_72785_1_.field_70157_k, entitytrackerentry);
            entitytrackerentry.func_73125_b(field_72795_a.field_73010_i);
            return;
        }
    }

    public void func_72790_b(Entity p_72790_1_)
    {
        if(p_72790_1_ instanceof EntityPlayerMP)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)p_72790_1_;
            EntityTrackerEntry entitytrackerentry1;
            for(Iterator iterator = field_72793_b.iterator(); iterator.hasNext(); entitytrackerentry1.func_73118_a(entityplayermp))
            {
                entitytrackerentry1 = (EntityTrackerEntry)iterator.next();
            }

        }
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)field_72794_c.func_76049_d(p_72790_1_.field_70157_k);
        if(entitytrackerentry != null)
        {
            field_72793_b.remove(entitytrackerentry);
            entitytrackerentry.func_73119_a();
        }
    }

    public void func_72788_a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = field_72793_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)iterator.next();
            entitytrackerentry.func_73122_a(field_72795_a.field_73010_i);
            if(entitytrackerentry.field_73133_n && (entitytrackerentry.field_73132_a instanceof EntityPlayerMP))
            {
                arraylist.add((EntityPlayerMP)entitytrackerentry.field_73132_a);
            }
        } while(true);
        for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext();)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator1.next();
            EntityPlayerMP entityplayermp1 = entityplayermp;
            Iterator iterator2 = field_72793_b.iterator();
            while(iterator2.hasNext()) 
            {
                EntityTrackerEntry entitytrackerentry1 = (EntityTrackerEntry)iterator2.next();
                if(entitytrackerentry1.field_73132_a != entityplayermp1)
                {
                    entitytrackerentry1.func_73117_b(entityplayermp1);
                }
            }
        }

    }

    public void func_72784_a(Entity p_72784_1_, Packet p_72784_2_)
    {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)field_72794_c.func_76041_a(p_72784_1_.field_70157_k);
        if(entitytrackerentry != null)
        {
            entitytrackerentry.func_73120_a(p_72784_2_);
        }
    }

    public void func_72789_b(Entity p_72789_1_, Packet p_72789_2_)
    {
        EntityTrackerEntry entitytrackerentry = (EntityTrackerEntry)field_72794_c.func_76041_a(p_72789_1_.field_70157_k);
        if(entitytrackerentry != null)
        {
            entitytrackerentry.func_73116_b(p_72789_2_);
        }
    }

    public void func_72787_a(EntityPlayerMP p_72787_1_)
    {
        EntityTrackerEntry entitytrackerentry;
        for(Iterator iterator = field_72793_b.iterator(); iterator.hasNext(); entitytrackerentry.func_73123_c(p_72787_1_))
        {
            entitytrackerentry = (EntityTrackerEntry)iterator.next();
        }

    }
}
