// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            World, SaveHandlerMP, WorldProvider, IntHashMap, 
//            NetClientHandler, Profiler, Entity, ChunkProviderClient, 
//            ChunkCoordIntPair, Packet255KickDisconnect, WorldInfo, Block, 
//            Chunk, CallableMPL1, CrashReport, CallableMPL2, 
//            EntityLiving, SoundManager, WorldSettings, IChunkProvider

public class WorldClient extends World
{

    private NetClientHandler field_73035_a;
    private ChunkProviderClient field_73033_b;
    private IntHashMap field_73034_c;
    private Set field_73032_d;
    private Set field_73036_L;
    private final Minecraft field_73037_M = Minecraft.func_71410_x();
    private final Set field_73038_N = new HashSet();

    public WorldClient(NetClientHandler p_i3108_1_, WorldSettings p_i3108_2_, int p_i3108_3_, int p_i3108_4_, Profiler p_i3108_5_)
    {
        super(new SaveHandlerMP(), "MpServer", WorldProvider.func_76570_a(p_i3108_3_), p_i3108_2_, p_i3108_5_);
        field_73034_c = new IntHashMap();
        field_73032_d = new HashSet();
        field_73036_L = new HashSet();
        field_73035_a = p_i3108_1_;
        field_73013_u = p_i3108_4_;
        func_72950_A(8, 64, 8);
        field_72988_C = p_i3108_1_.field_72558_b;
    }

    public void func_72835_b()
    {
        super.func_72835_b();
        func_72877_b(func_72820_D() + 1L);
        field_72984_F.func_76320_a("reEntryProcessing");
        for(int i = 0; i < 10 && !field_73036_L.isEmpty(); i++)
        {
            Entity entity = (Entity)field_73036_L.iterator().next();
            field_73036_L.remove(entity);
            if(!field_72996_f.contains(entity))
            {
                func_72838_d(entity);
            }
        }

        field_72984_F.func_76318_c("connection");
        field_73035_a.func_72551_d();
        field_72984_F.func_76318_c("chunkCache");
        field_73033_b.func_73156_b();
        field_72984_F.func_76318_c("tiles");
        func_72893_g();
        field_72984_F.func_76319_b();
    }

    public void func_73031_a(int i, int j, int k, int l, int i1, int j1)
    {
    }

    protected IChunkProvider func_72970_h()
    {
        field_73033_b = new ChunkProviderClient(this);
        return field_73033_b;
    }

    protected void func_72893_g()
    {
        super.func_72893_g();
        field_73038_N.retainAll(field_72993_I);
        if(field_73038_N.size() == field_72993_I.size())
        {
            field_73038_N.clear();
        }
        int i = 0;
        for(Iterator iterator = field_72993_I.iterator(); iterator.hasNext();)
        {
            ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            if(!field_73038_N.contains(chunkcoordintpair))
            {
                int j = chunkcoordintpair.field_77276_a * 16;
                int k = chunkcoordintpair.field_77275_b * 16;
                field_72984_F.func_76320_a("getChunk");
                Chunk chunk = func_72964_e(chunkcoordintpair.field_77276_a, chunkcoordintpair.field_77275_b);
                func_72941_a(j, k, chunk);
                field_72984_F.func_76319_b();
                field_73038_N.add(chunkcoordintpair);
                if(++i >= 10)
                {
                    return;
                }
            }
        }

    }

    public void func_73025_a(int p_73025_1_, int p_73025_2_, boolean p_73025_3_)
    {
        if(p_73025_3_)
        {
            field_73033_b.func_73158_c(p_73025_1_, p_73025_2_);
        } else
        {
            field_73033_b.func_73234_b(p_73025_1_, p_73025_2_);
        }
        if(!p_73025_3_)
        {
            func_72909_d(p_73025_1_ * 16, 0, p_73025_2_ * 16, p_73025_1_ * 16 + 15, 256, p_73025_2_ * 16 + 15);
        }
    }

    public boolean func_72838_d(Entity p_72838_1_)
    {
        boolean flag = super.func_72838_d(p_72838_1_);
        field_73032_d.add(p_72838_1_);
        if(!flag)
        {
            field_73036_L.add(p_72838_1_);
        }
        return flag;
    }

    public void func_72900_e(Entity p_72900_1_)
    {
        super.func_72900_e(p_72900_1_);
        field_73032_d.remove(p_72900_1_);
    }

    protected void func_72923_a(Entity p_72923_1_)
    {
        super.func_72923_a(p_72923_1_);
        if(field_73036_L.contains(p_72923_1_))
        {
            field_73036_L.remove(p_72923_1_);
        }
    }

    protected void func_72847_b(Entity p_72847_1_)
    {
        super.func_72847_b(p_72847_1_);
        if(field_73032_d.contains(p_72847_1_))
        {
            if(p_72847_1_.func_70089_S())
            {
                field_73036_L.add(p_72847_1_);
            } else
            {
                field_73032_d.remove(p_72847_1_);
            }
        }
    }

    public void func_73027_a(int p_73027_1_, Entity p_73027_2_)
    {
        Entity entity = func_73024_a(p_73027_1_);
        if(entity != null)
        {
            func_72900_e(entity);
        }
        field_73032_d.add(p_73027_2_);
        p_73027_2_.field_70157_k = p_73027_1_;
        if(!func_72838_d(p_73027_2_))
        {
            field_73036_L.add(p_73027_2_);
        }
        field_73034_c.func_76038_a(p_73027_1_, p_73027_2_);
    }

    public Entity func_73024_a(int p_73024_1_)
    {
        return (Entity)field_73034_c.func_76041_a(p_73024_1_);
    }

    public Entity func_73028_b(int p_73028_1_)
    {
        Entity entity = (Entity)field_73034_c.func_76049_d(p_73028_1_);
        if(entity != null)
        {
            field_73032_d.remove(entity);
            func_72900_e(entity);
        }
        return entity;
    }

    public boolean func_73023_g(int p_73023_1_, int p_73023_2_, int p_73023_3_, int p_73023_4_, int p_73023_5_)
    {
        func_73031_a(p_73023_1_, p_73023_2_, p_73023_3_, p_73023_1_, p_73023_2_, p_73023_3_);
        return super.func_72832_d(p_73023_1_, p_73023_2_, p_73023_3_, p_73023_4_, p_73023_5_);
    }

    public void func_72882_A()
    {
        field_73035_a.func_72546_b(new Packet255KickDisconnect("Quitting"));
    }

    protected void func_72979_l()
    {
        if(field_73011_w.field_76576_e)
        {
            return;
        }
        if(field_73016_r > 0)
        {
            field_73016_r--;
        }
        field_73003_n = field_73004_o;
        if(field_72986_A.func_76059_o())
        {
            field_73004_o += 0.01D;
        } else
        {
            field_73004_o -= 0.01D;
        }
        if(field_73004_o < 0.0F)
        {
            field_73004_o = 0.0F;
        }
        if(field_73004_o > 1.0F)
        {
            field_73004_o = 1.0F;
        }
        field_73018_p = field_73017_q;
        if(field_72986_A.func_76061_m())
        {
            field_73017_q += 0.01D;
        } else
        {
            field_73017_q -= 0.01D;
        }
        if(field_73017_q < 0.0F)
        {
            field_73017_q = 0.0F;
        }
        if(field_73017_q > 1.0F)
        {
            field_73017_q = 1.0F;
        }
    }

    public void func_73029_E(int p_73029_1_, int p_73029_2_, int p_73029_3_)
    {
        byte byte0 = 16;
        Random random = new Random();
        for(int i = 0; i < 1000; i++)
        {
            int j = (p_73029_1_ + field_73012_v.nextInt(byte0)) - field_73012_v.nextInt(byte0);
            int k = (p_73029_2_ + field_73012_v.nextInt(byte0)) - field_73012_v.nextInt(byte0);
            int l = (p_73029_3_ + field_73012_v.nextInt(byte0)) - field_73012_v.nextInt(byte0);
            int i1 = func_72798_a(j, k, l);
            if(i1 == 0 && field_73012_v.nextInt(8) > k && field_73011_w.func_76564_j())
            {
                func_72869_a("depthsuspend", (float)j + field_73012_v.nextFloat(), (float)k + field_73012_v.nextFloat(), (float)l + field_73012_v.nextFloat(), 0.0D, 0.0D, 0.0D);
                continue;
            }
            if(i1 > 0)
            {
                Block.field_71973_m[i1].func_71862_a(this, j, k, l, random);
            }
        }

    }

    public void func_73022_a()
    {
        field_72996_f.removeAll(field_72997_g);
        for(int i = 0; i < field_72997_g.size(); i++)
        {
            Entity entity = (Entity)field_72997_g.get(i);
            int l = entity.field_70176_ah;
            int j1 = entity.field_70164_aj;
            if(entity.field_70175_ag && func_72916_c(l, j1))
            {
                func_72964_e(l, j1).func_76622_b(entity);
            }
        }

        for(int j = 0; j < field_72997_g.size(); j++)
        {
            func_72847_b((Entity)field_72997_g.get(j));
        }

        field_72997_g.clear();
        for(int k = 0; k < field_72996_f.size(); k++)
        {
            Entity entity1 = (Entity)field_72996_f.get(k);
            if(entity1.field_70154_o != null)
            {
                if(!entity1.field_70154_o.field_70128_L && entity1.field_70154_o.field_70153_n == entity1)
                {
                    continue;
                }
                entity1.field_70154_o.field_70153_n = null;
                entity1.field_70154_o = null;
            }
            if(!entity1.field_70128_L)
            {
                continue;
            }
            int i1 = entity1.field_70176_ah;
            int k1 = entity1.field_70164_aj;
            if(entity1.field_70175_ag && func_72916_c(i1, k1))
            {
                func_72964_e(i1, k1).func_76622_b(entity1);
            }
            field_72996_f.remove(k--);
            func_72847_b(entity1);
        }

    }

    public CrashReport func_72914_a(CrashReport p_72914_1_)
    {
        p_72914_1_ = super.func_72914_a(p_72914_1_);
        p_72914_1_.func_71500_a("Forced Entities", new CallableMPL1(this));
        p_72914_1_.func_71500_a("Retry Entities", new CallableMPL2(this));
        return p_72914_1_;
    }

    public void func_72980_b(double p_72980_1_, double p_72980_3_, double p_72980_5_, String p_72980_7_, 
            float p_72980_8_, float p_72980_9_)
    {
        float f = 16F;
        if(p_72980_8_ > 1.0F)
        {
            f *= p_72980_8_;
        }
        if(field_73037_M.field_71451_h.func_70092_e(p_72980_1_, p_72980_3_, p_72980_5_) < (double)(f * f))
        {
            field_73037_M.field_71416_A.func_77364_b(p_72980_7_, (float)p_72980_1_, (float)p_72980_3_, (float)p_72980_5_, p_72980_8_, p_72980_9_);
        }
    }

    static Set func_73026_a(WorldClient p_73026_0_)
    {
        return p_73026_0_.field_73032_d;
    }

    static Set func_73030_b(WorldClient p_73030_0_)
    {
        return p_73030_0_.field_73036_L;
    }
}
