// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            TileEntity, World, EntityList, AxisAlignedBB, 
//            AABBPool, EntityLiving, Entity, NBTTagCompound, 
//            NBTBase, Packet132TileEntityData, Packet

public class TileEntityMobSpawner extends TileEntity
{

    public int field_70394_a;
    private String field_70390_d;
    private NBTTagCompound field_70391_e;
    public double field_70392_b;
    public double field_70393_c;
    private int field_70388_f;
    private int field_70389_g;
    private int field_70395_h;

    public TileEntityMobSpawner()
    {
        field_70394_a = -1;
        field_70391_e = null;
        field_70393_c = 0.0D;
        field_70388_f = 200;
        field_70389_g = 800;
        field_70395_h = 4;
        field_70390_d = "Pig";
        field_70394_a = 20;
    }

    public void func_70385_a(String p_70385_1_)
    {
        field_70390_d = p_70385_1_;
    }

    public boolean func_70386_b()
    {
        return field_70331_k.func_72977_a((double)field_70329_l + 0.5D, (double)field_70330_m + 0.5D, (double)field_70327_n + 0.5D, 16D) != null;
    }

    public void func_70316_g()
    {
        if(!func_70386_b())
        {
            return;
        }
        if(field_70331_k.field_72995_K)
        {
            double d = (float)field_70329_l + field_70331_k.field_73012_v.nextFloat();
            double d1 = (float)field_70330_m + field_70331_k.field_73012_v.nextFloat();
            double d3 = (float)field_70327_n + field_70331_k.field_73012_v.nextFloat();
            field_70331_k.func_72869_a("smoke", d, d1, d3, 0.0D, 0.0D, 0.0D);
            field_70331_k.func_72869_a("flame", d, d1, d3, 0.0D, 0.0D, 0.0D);
            field_70393_c = field_70392_b % 360D;
            field_70392_b += 4.5454545021057129D;
        } else
        {
            if(field_70394_a == -1)
            {
                func_70387_f();
            }
            if(field_70394_a > 0)
            {
                field_70394_a--;
                return;
            }
            for(int i = 0; i < field_70395_h; i++)
            {
                Entity entity = EntityList.func_75620_a(field_70390_d, field_70331_k);
                if(entity == null)
                {
                    return;
                }
                int j = field_70331_k.func_72872_a(entity.getClass(), AxisAlignedBB.func_72332_a().func_72299_a(field_70329_l, field_70330_m, field_70327_n, field_70329_l + 1, field_70330_m + 1, field_70327_n + 1).func_72314_b(8D, 4D, 8D)).size();
                if(j >= 6)
                {
                    func_70387_f();
                    return;
                }
                if(entity == null)
                {
                    continue;
                }
                double d2 = (double)field_70329_l + (field_70331_k.field_73012_v.nextDouble() - field_70331_k.field_73012_v.nextDouble()) * 4D;
                double d4 = (field_70330_m + field_70331_k.field_73012_v.nextInt(3)) - 1;
                double d5 = (double)field_70327_n + (field_70331_k.field_73012_v.nextDouble() - field_70331_k.field_73012_v.nextDouble()) * 4D;
                EntityLiving entityliving = (entity instanceof EntityLiving) ? (EntityLiving)entity : null;
                entity.func_70012_b(d2, d4, d5, field_70331_k.field_73012_v.nextFloat() * 360F, 0.0F);
                if(entityliving != null && !entityliving.func_70601_bi())
                {
                    continue;
                }
                func_70383_a(entity);
                field_70331_k.func_72838_d(entity);
                field_70331_k.func_72926_e(2004, field_70329_l, field_70330_m, field_70327_n, 0);
                if(entityliving != null)
                {
                    entityliving.func_70656_aK();
                }
                func_70387_f();
            }

        }
        super.func_70316_g();
    }

    public void func_70383_a(Entity p_70383_1_)
    {
        if(field_70391_e != null)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            p_70383_1_.func_70039_c(nbttagcompound);
            NBTBase nbtbase;
            for(Iterator iterator = field_70391_e.func_74758_c().iterator(); iterator.hasNext(); nbttagcompound.func_74782_a(nbtbase.func_74740_e(), nbtbase.func_74737_b()))
            {
                nbtbase = (NBTBase)iterator.next();
            }

            p_70383_1_.func_70020_e(nbttagcompound);
        }
    }

    private void func_70387_f()
    {
        field_70394_a = field_70388_f + field_70331_k.field_73012_v.nextInt(field_70389_g - field_70388_f);
    }

    public void func_70307_a(NBTTagCompound p_70307_1_)
    {
        super.func_70307_a(p_70307_1_);
        field_70390_d = p_70307_1_.func_74779_i("EntityId");
        field_70394_a = p_70307_1_.func_74765_d("Delay");
        if(p_70307_1_.func_74764_b("SpawnData"))
        {
            field_70391_e = p_70307_1_.func_74775_l("SpawnData");
        } else
        {
            field_70391_e = null;
        }
        if(p_70307_1_.func_74764_b("MinSpawnDelay"))
        {
            field_70388_f = p_70307_1_.func_74765_d("MinSpawnDelay");
            field_70389_g = p_70307_1_.func_74765_d("MaxSpawnDelay");
            field_70395_h = p_70307_1_.func_74765_d("SpawnCount");
        }
    }

    public void func_70310_b(NBTTagCompound p_70310_1_)
    {
        super.func_70310_b(p_70310_1_);
        p_70310_1_.func_74778_a("EntityId", field_70390_d);
        p_70310_1_.func_74777_a("Delay", (short)field_70394_a);
        p_70310_1_.func_74777_a("MinSpawnDelay", (short)field_70388_f);
        p_70310_1_.func_74777_a("MaxSpawnDelay", (short)field_70389_g);
        p_70310_1_.func_74777_a("SpawnCount", (short)field_70395_h);
        if(field_70391_e != null)
        {
            p_70310_1_.func_74766_a("SpawnData", field_70391_e);
        }
    }

    public Packet func_70319_e()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        func_70310_b(nbttagcompound);
        return new Packet132TileEntityData(field_70329_l, field_70330_m, field_70327_n, 1, nbttagcompound);
    }
}
