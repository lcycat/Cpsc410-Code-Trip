// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Entity, MathHelper, Packet39AttachEntity, EnumEntitySize, 
//            Packet34EntityTeleport, Packet33RelEntityMoveLook, Packet31RelEntityMove, Packet32EntityLook, 
//            Packet28EntityVelocity, DataWatcher, Packet40EntityMetadata, Packet35EntityHeadRotation, 
//            EntityPlayerMP, NetServerHandler, Packet24MobSpawn, Packet5PlayerInventory, 
//            EntityPlayer, Packet17Sleep, EntityLiving, PotionEffect, 
//            Packet41EntityEffect, WorldServer, PlayerManager, EntityItem, 
//            Packet21PickupSpawn, Packet20NamedEntitySpawn, EntityMinecart, Packet23VehicleSpawn, 
//            EntityBoat, IAnimals, EntityDragon, EntityFishHook, 
//            EntityArrow, EntitySnowball, EntityPotion, EntityExpBottle, 
//            EntityEnderPearl, EntityEnderEye, EntitySmallFireball, EntityFireball, 
//            EntityEgg, EntityTNTPrimed, EntityEnderCrystal, EntityFallingSand, 
//            EntityPainting, Packet25EntityPainting, EntityXPOrb, Packet26EntityExpOrb, 
//            Packet

public class EntityTrackerEntry
{

    public Entity field_73132_a;
    public int field_73130_b;
    public int field_73131_c;
    public int field_73128_d;
    public int field_73129_e;
    public int field_73126_f;
    public int field_73127_g;
    public int field_73139_h;
    public int field_73140_i;
    public double field_73137_j;
    public double field_73138_k;
    public double field_73135_l;
    public int field_73136_m;
    private double field_73147_p;
    private double field_73146_q;
    private double field_73145_r;
    private boolean field_73144_s;
    private boolean field_73143_t;
    private int field_73142_u;
    private Entity field_73141_v;
    public boolean field_73133_n;
    public Set field_73134_o;

    public EntityTrackerEntry(Entity p_i3398_1_, int p_i3398_2_, int p_i3398_3_, boolean p_i3398_4_)
    {
        field_73136_m = 0;
        field_73144_s = false;
        field_73142_u = 0;
        field_73133_n = false;
        field_73134_o = new HashSet();
        field_73132_a = p_i3398_1_;
        field_73130_b = p_i3398_2_;
        field_73131_c = p_i3398_3_;
        field_73143_t = p_i3398_4_;
        field_73128_d = MathHelper.func_76128_c(p_i3398_1_.field_70165_t * 32D);
        field_73129_e = MathHelper.func_76128_c(p_i3398_1_.field_70163_u * 32D);
        field_73126_f = MathHelper.func_76128_c(p_i3398_1_.field_70161_v * 32D);
        field_73127_g = MathHelper.func_76141_d((p_i3398_1_.field_70177_z * 256F) / 360F);
        field_73139_h = MathHelper.func_76141_d((p_i3398_1_.field_70125_A * 256F) / 360F);
        field_73140_i = MathHelper.func_76141_d((p_i3398_1_.func_70079_am() * 256F) / 360F);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ instanceof EntityTrackerEntry)
        {
            return ((EntityTrackerEntry)p_equals_1_).field_73132_a.field_70157_k == field_73132_a.field_70157_k;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return field_73132_a.field_70157_k;
    }

    public void func_73122_a(List p_73122_1_)
    {
        field_73133_n = false;
        if(!field_73144_s || field_73132_a.func_70092_e(field_73147_p, field_73146_q, field_73145_r) > 16D)
        {
            field_73147_p = field_73132_a.field_70165_t;
            field_73146_q = field_73132_a.field_70163_u;
            field_73145_r = field_73132_a.field_70161_v;
            field_73144_s = true;
            field_73133_n = true;
            func_73125_b(p_73122_1_);
        }
        if(field_73141_v != field_73132_a.field_70154_o)
        {
            field_73141_v = field_73132_a.field_70154_o;
            func_73120_a(new Packet39AttachEntity(field_73132_a, field_73132_a.field_70154_o));
        }
        if(field_73132_a.field_70154_o == null)
        {
            field_73142_u++;
            if(field_73136_m++ % field_73131_c == 0 || field_73132_a.field_70160_al)
            {
                int i = field_73132_a.field_70168_am.func_75630_a(field_73132_a.field_70165_t);
                int j = MathHelper.func_76128_c(field_73132_a.field_70163_u * 32D);
                int k = field_73132_a.field_70168_am.func_75630_a(field_73132_a.field_70161_v);
                int l = MathHelper.func_76141_d((field_73132_a.field_70177_z * 256F) / 360F);
                int i1 = MathHelper.func_76141_d((field_73132_a.field_70125_A * 256F) / 360F);
                int j1 = i - field_73128_d;
                int k1 = j - field_73129_e;
                int l1 = k - field_73126_f;
                Object obj = null;
                boolean flag = Math.abs(j1) >= 4 || Math.abs(k1) >= 4 || Math.abs(l1) >= 4;
                boolean flag1 = Math.abs(l - field_73127_g) >= 4 || Math.abs(i1 - field_73139_h) >= 4;
                if(j1 < -128 || j1 >= 128 || k1 < -128 || k1 >= 128 || l1 < -128 || l1 >= 128 || field_73142_u > 400)
                {
                    field_73142_u = 0;
                    obj = new Packet34EntityTeleport(field_73132_a.field_70157_k, i, j, k, (byte)l, (byte)i1);
                } else
                if(flag && flag1)
                {
                    obj = new Packet33RelEntityMoveLook(field_73132_a.field_70157_k, (byte)j1, (byte)k1, (byte)l1, (byte)l, (byte)i1);
                } else
                if(flag)
                {
                    obj = new Packet31RelEntityMove(field_73132_a.field_70157_k, (byte)j1, (byte)k1, (byte)l1);
                } else
                if(flag1)
                {
                    obj = new Packet32EntityLook(field_73132_a.field_70157_k, (byte)l, (byte)i1);
                }
                if(field_73143_t)
                {
                    double d = field_73132_a.field_70159_w - field_73137_j;
                    double d1 = field_73132_a.field_70181_x - field_73138_k;
                    double d2 = field_73132_a.field_70179_y - field_73135_l;
                    double d3 = 0.02D;
                    double d4 = d * d + d1 * d1 + d2 * d2;
                    if(d4 > d3 * d3 || d4 > 0.0D && field_73132_a.field_70159_w == 0.0D && field_73132_a.field_70181_x == 0.0D && field_73132_a.field_70179_y == 0.0D)
                    {
                        field_73137_j = field_73132_a.field_70159_w;
                        field_73138_k = field_73132_a.field_70181_x;
                        field_73135_l = field_73132_a.field_70179_y;
                        func_73120_a(new Packet28EntityVelocity(field_73132_a.field_70157_k, field_73137_j, field_73138_k, field_73135_l));
                    }
                }
                if(obj != null)
                {
                    func_73120_a(((Packet) (obj)));
                }
                DataWatcher datawatcher = field_73132_a.func_70096_w();
                if(datawatcher.func_75684_a())
                {
                    func_73116_b(new Packet40EntityMetadata(field_73132_a.field_70157_k, datawatcher));
                }
                int i2 = MathHelper.func_76141_d((field_73132_a.func_70079_am() * 256F) / 360F);
                if(Math.abs(i2 - field_73140_i) >= 4)
                {
                    func_73120_a(new Packet35EntityHeadRotation(field_73132_a.field_70157_k, (byte)i2));
                    field_73140_i = i2;
                }
                if(flag)
                {
                    field_73128_d = i;
                    field_73129_e = j;
                    field_73126_f = k;
                }
                if(flag1)
                {
                    field_73127_g = l;
                    field_73139_h = i1;
                }
            }
            field_73132_a.field_70160_al = false;
        }
        if(field_73132_a.field_70133_I)
        {
            func_73116_b(new Packet28EntityVelocity(field_73132_a));
            field_73132_a.field_70133_I = false;
        }
    }

    public void func_73120_a(Packet p_73120_1_)
    {
        EntityPlayerMP entityplayermp;
        for(Iterator iterator = field_73134_o.iterator(); iterator.hasNext(); entityplayermp.field_71135_a.func_72567_b(p_73120_1_))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }

    }

    public void func_73116_b(Packet p_73116_1_)
    {
        func_73120_a(p_73116_1_);
        if(field_73132_a instanceof EntityPlayerMP)
        {
            ((EntityPlayerMP)field_73132_a).field_71135_a.func_72567_b(p_73116_1_);
        }
    }

    public void func_73119_a()
    {
        EntityPlayerMP entityplayermp;
        for(Iterator iterator = field_73134_o.iterator(); iterator.hasNext(); entityplayermp.field_71130_g.add(Integer.valueOf(field_73132_a.field_70157_k)))
        {
            entityplayermp = (EntityPlayerMP)iterator.next();
        }

    }

    public void func_73118_a(EntityPlayerMP p_73118_1_)
    {
        if(field_73134_o.contains(p_73118_1_))
        {
            field_73134_o.remove(p_73118_1_);
        }
    }

    public void func_73117_b(EntityPlayerMP p_73117_1_)
    {
        if(p_73117_1_ == field_73132_a)
        {
            return;
        }
        double d = p_73117_1_.field_70165_t - (double)(field_73128_d / 32);
        double d1 = p_73117_1_.field_70161_v - (double)(field_73126_f / 32);
        if(d >= (double)(-field_73130_b) && d <= (double)field_73130_b && d1 >= (double)(-field_73130_b) && d1 <= (double)field_73130_b)
        {
            if(!field_73134_o.contains(p_73117_1_) && func_73121_d(p_73117_1_))
            {
                field_73134_o.add(p_73117_1_);
                Packet packet = func_73124_b();
                p_73117_1_.field_71135_a.func_72567_b(packet);
                field_73137_j = field_73132_a.field_70159_w;
                field_73138_k = field_73132_a.field_70181_x;
                field_73135_l = field_73132_a.field_70179_y;
                if(field_73143_t && !(packet instanceof Packet24MobSpawn))
                {
                    p_73117_1_.field_71135_a.func_72567_b(new Packet28EntityVelocity(field_73132_a.field_70157_k, field_73132_a.field_70159_w, field_73132_a.field_70181_x, field_73132_a.field_70179_y));
                }
                if(field_73132_a.field_70154_o != null)
                {
                    p_73117_1_.field_71135_a.func_72567_b(new Packet39AttachEntity(field_73132_a, field_73132_a.field_70154_o));
                }
                ItemStack aitemstack[] = field_73132_a.func_70035_c();
                if(aitemstack != null)
                {
                    for(int i = 0; i < aitemstack.length; i++)
                    {
                        p_73117_1_.field_71135_a.func_72567_b(new Packet5PlayerInventory(field_73132_a.field_70157_k, i, aitemstack[i]));
                    }

                }
                if(field_73132_a instanceof EntityPlayer)
                {
                    EntityPlayer entityplayer = (EntityPlayer)field_73132_a;
                    if(entityplayer.func_70608_bn())
                    {
                        p_73117_1_.field_71135_a.func_72567_b(new Packet17Sleep(field_73132_a, 0, MathHelper.func_76128_c(field_73132_a.field_70165_t), MathHelper.func_76128_c(field_73132_a.field_70163_u), MathHelper.func_76128_c(field_73132_a.field_70161_v)));
                    }
                }
                if(field_73132_a instanceof EntityLiving)
                {
                    EntityLiving entityliving = (EntityLiving)field_73132_a;
                    PotionEffect potioneffect;
                    for(Iterator iterator = entityliving.func_70651_bq().iterator(); iterator.hasNext(); p_73117_1_.field_71135_a.func_72567_b(new Packet41EntityEffect(field_73132_a.field_70157_k, potioneffect)))
                    {
                        potioneffect = (PotionEffect)iterator.next();
                    }

                }
            }
        } else
        if(field_73134_o.contains(p_73117_1_))
        {
            field_73134_o.remove(p_73117_1_);
            p_73117_1_.field_71130_g.add(Integer.valueOf(field_73132_a.field_70157_k));
        }
    }

    private boolean func_73121_d(EntityPlayerMP p_73121_1_)
    {
        return p_73121_1_.func_71121_q().func_73040_p().func_72694_a(p_73121_1_, field_73132_a.field_70176_ah, field_73132_a.field_70164_aj);
    }

    public void func_73125_b(List p_73125_1_)
    {
        EntityPlayer entityplayer;
        for(Iterator iterator = p_73125_1_.iterator(); iterator.hasNext(); func_73117_b((EntityPlayerMP)entityplayer))
        {
            entityplayer = (EntityPlayer)iterator.next();
        }

    }

    private Packet func_73124_b()
    {
        if(field_73132_a.field_70128_L)
        {
            System.out.println("Fetching addPacket for removed entity");
        }
        if(field_73132_a instanceof EntityItem)
        {
            EntityItem entityitem = (EntityItem)field_73132_a;
            Packet21PickupSpawn packet21pickupspawn = new Packet21PickupSpawn(entityitem);
            entityitem.field_70165_t = (double)packet21pickupspawn.field_73483_b / 32D;
            entityitem.field_70163_u = (double)packet21pickupspawn.field_73484_c / 32D;
            entityitem.field_70161_v = (double)packet21pickupspawn.field_73481_d / 32D;
            return packet21pickupspawn;
        }
        if(field_73132_a instanceof EntityPlayerMP)
        {
            return new Packet20NamedEntitySpawn((EntityPlayer)field_73132_a);
        }
        if(field_73132_a instanceof EntityMinecart)
        {
            EntityMinecart entityminecart = (EntityMinecart)field_73132_a;
            if(entityminecart.field_70505_a == 0)
            {
                return new Packet23VehicleSpawn(field_73132_a, 10);
            }
            if(entityminecart.field_70505_a == 1)
            {
                return new Packet23VehicleSpawn(field_73132_a, 11);
            }
            if(entityminecart.field_70505_a == 2)
            {
                return new Packet23VehicleSpawn(field_73132_a, 12);
            }
        }
        if(field_73132_a instanceof EntityBoat)
        {
            return new Packet23VehicleSpawn(field_73132_a, 1);
        }
        if((field_73132_a instanceof IAnimals) || (field_73132_a instanceof EntityDragon))
        {
            field_73140_i = MathHelper.func_76141_d((field_73132_a.func_70079_am() * 256F) / 360F);
            return new Packet24MobSpawn((EntityLiving)field_73132_a);
        }
        if(field_73132_a instanceof EntityFishHook)
        {
            EntityPlayer entityplayer = ((EntityFishHook)field_73132_a).field_70204_b;
            return new Packet23VehicleSpawn(field_73132_a, 90, entityplayer == null ? field_73132_a.field_70157_k : ((Entity) (entityplayer)).field_70157_k);
        }
        if(field_73132_a instanceof EntityArrow)
        {
            Entity entity = ((EntityArrow)field_73132_a).field_70250_c;
            return new Packet23VehicleSpawn(field_73132_a, 60, entity == null ? field_73132_a.field_70157_k : entity.field_70157_k);
        }
        if(field_73132_a instanceof EntitySnowball)
        {
            return new Packet23VehicleSpawn(field_73132_a, 61);
        }
        if(field_73132_a instanceof EntityPotion)
        {
            return new Packet23VehicleSpawn(field_73132_a, 73, ((EntityPotion)field_73132_a).func_70196_i());
        }
        if(field_73132_a instanceof EntityExpBottle)
        {
            return new Packet23VehicleSpawn(field_73132_a, 75);
        }
        if(field_73132_a instanceof EntityEnderPearl)
        {
            return new Packet23VehicleSpawn(field_73132_a, 65);
        }
        if(field_73132_a instanceof EntityEnderEye)
        {
            return new Packet23VehicleSpawn(field_73132_a, 72);
        }
        if(field_73132_a instanceof EntitySmallFireball)
        {
            EntitySmallFireball entitysmallfireball = (EntitySmallFireball)field_73132_a;
            Packet23VehicleSpawn packet23vehiclespawn = null;
            if(entitysmallfireball.field_70235_a != null)
            {
                packet23vehiclespawn = new Packet23VehicleSpawn(field_73132_a, 64, entitysmallfireball.field_70235_a.field_70157_k);
            } else
            {
                packet23vehiclespawn = new Packet23VehicleSpawn(field_73132_a, 64, 0);
            }
            packet23vehiclespawn.field_73523_e = (int)(entitysmallfireball.field_70232_b * 8000D);
            packet23vehiclespawn.field_73520_f = (int)(entitysmallfireball.field_70233_c * 8000D);
            packet23vehiclespawn.field_73521_g = (int)(entitysmallfireball.field_70230_d * 8000D);
            return packet23vehiclespawn;
        }
        if(field_73132_a instanceof EntityFireball)
        {
            EntityFireball entityfireball = (EntityFireball)field_73132_a;
            Packet23VehicleSpawn packet23vehiclespawn1 = null;
            if(entityfireball.field_70235_a != null)
            {
                packet23vehiclespawn1 = new Packet23VehicleSpawn(field_73132_a, 63, ((EntityFireball)field_73132_a).field_70235_a.field_70157_k);
            } else
            {
                packet23vehiclespawn1 = new Packet23VehicleSpawn(field_73132_a, 63, 0);
            }
            packet23vehiclespawn1.field_73523_e = (int)(entityfireball.field_70232_b * 8000D);
            packet23vehiclespawn1.field_73520_f = (int)(entityfireball.field_70233_c * 8000D);
            packet23vehiclespawn1.field_73521_g = (int)(entityfireball.field_70230_d * 8000D);
            return packet23vehiclespawn1;
        }
        if(field_73132_a instanceof EntityEgg)
        {
            return new Packet23VehicleSpawn(field_73132_a, 62);
        }
        if(field_73132_a instanceof EntityTNTPrimed)
        {
            return new Packet23VehicleSpawn(field_73132_a, 50);
        }
        if(field_73132_a instanceof EntityEnderCrystal)
        {
            return new Packet23VehicleSpawn(field_73132_a, 51);
        }
        if(field_73132_a instanceof EntityFallingSand)
        {
            EntityFallingSand entityfallingsand = (EntityFallingSand)field_73132_a;
            return new Packet23VehicleSpawn(field_73132_a, 70, entityfallingsand.field_70287_a | entityfallingsand.field_70285_b << 16);
        }
        if(field_73132_a instanceof EntityPainting)
        {
            return new Packet25EntityPainting((EntityPainting)field_73132_a);
        }
        if(field_73132_a instanceof EntityXPOrb)
        {
            return new Packet26EntityExpOrb((EntityXPOrb)field_73132_a);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Don't know how to add ").append(field_73132_a.getClass()).append("!").toString());
        }
    }

    public void func_73123_c(EntityPlayerMP p_73123_1_)
    {
        if(field_73134_o.contains(p_73123_1_))
        {
            field_73134_o.remove(p_73123_1_);
            p_73123_1_.field_71130_g.add(Integer.valueOf(field_73132_a.field_70157_k));
        }
    }
}
