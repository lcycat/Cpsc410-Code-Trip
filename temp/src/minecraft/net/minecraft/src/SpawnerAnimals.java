// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.reflect.Constructor;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            World, Chunk, ChunkPosition, WorldServer, 
//            EntityPlayer, MathHelper, ChunkCoordIntPair, EnumCreatureType, 
//            ChunkCoordinates, SpawnListEntry, EntityLiving, Material, 
//            Block, EntitySpider, EntitySkeleton, EntitySheep, 
//            EntityOcelot, BiomeGenBase, WeightedRandom, EntityZombie

public final class SpawnerAnimals
{

    private static HashMap field_77193_b = new HashMap();
    protected static final Class field_77194_a[];

    protected static ChunkPosition func_77189_a(World p_77189_0_, int p_77189_1_, int p_77189_2_)
    {
        Chunk chunk = p_77189_0_.func_72964_e(p_77189_1_, p_77189_2_);
        int i = p_77189_1_ * 16 + p_77189_0_.field_73012_v.nextInt(16);
        int j = p_77189_2_ * 16 + p_77189_0_.field_73012_v.nextInt(16);
        int k = p_77189_0_.field_73012_v.nextInt(chunk != null ? (chunk.func_76625_h() + 16) - 1 : p_77189_0_.func_72940_L());
        return new ChunkPosition(i, k, j);
    }

    public static final int func_77192_a(WorldServer p_77192_0_, boolean p_77192_1_, boolean p_77192_2_)
    {
        int j;
        ChunkCoordinates chunkcoordinates;
        EnumCreatureType aenumcreaturetype[];
        int i1;
        int j1;
        if(!p_77192_1_ && !p_77192_2_)
        {
            return 0;
        }
        field_77193_b.clear();
        for(int i = 0; i < p_77192_0_.field_73010_i.size(); i++)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_77192_0_.field_73010_i.get(i);
            int k = MathHelper.func_76128_c(entityplayer.field_70165_t / 16D);
            int l = MathHelper.func_76128_c(entityplayer.field_70161_v / 16D);
            byte byte0 = 8;
            for(int k1 = -byte0; k1 <= byte0; k1++)
            {
                for(int l1 = -byte0; l1 <= byte0; l1++)
                {
                    boolean flag = k1 == -byte0 || k1 == byte0 || l1 == -byte0 || l1 == byte0;
                    ChunkCoordIntPair chunkcoordintpair1 = new ChunkCoordIntPair(k1 + k, l1 + l);
                    if(!flag)
                    {
                        field_77193_b.put(chunkcoordintpair1, Boolean.valueOf(false));
                        continue;
                    }
                    if(!field_77193_b.containsKey(chunkcoordintpair1))
                    {
                        field_77193_b.put(chunkcoordintpair1, Boolean.valueOf(true));
                    }
                }

            }

        }

        j = 0;
        chunkcoordinates = p_77192_0_.func_72861_E();
        aenumcreaturetype = EnumCreatureType.values();
        i1 = aenumcreaturetype.length;
        j1 = 0;
_L10:
        if(j1 >= i1) goto _L2; else goto _L1
_L1:
        EnumCreatureType enumcreaturetype;
        Iterator iterator;
        enumcreaturetype = aenumcreaturetype[j1];
        if(enumcreaturetype.func_75599_d() && !p_77192_2_ || !enumcreaturetype.func_75599_d() && !p_77192_1_ || p_77192_0_.func_72907_a(enumcreaturetype.func_75598_a()) > (enumcreaturetype.func_75601_b() * field_77193_b.size()) / 256)
        {
            continue; /* Loop/switch isn't completed */
        }
        iterator = field_77193_b.keySet().iterator();
_L4:
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        do
        {
            ChunkCoordIntPair chunkcoordintpair;
            do
            {
                if(!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
            } while(((Boolean)field_77193_b.get(chunkcoordintpair)).booleanValue());
            ChunkPosition chunkposition = func_77189_a(p_77192_0_, chunkcoordintpair.field_77276_a, chunkcoordintpair.field_77275_b);
            i2 = chunkposition.field_76930_a;
            j2 = chunkposition.field_76928_b;
            k2 = chunkposition.field_76929_c;
        } while(p_77192_0_.func_72809_s(i2, j2, k2) || p_77192_0_.func_72803_f(i2, j2, k2) != enumcreaturetype.func_75600_c());
        l2 = 0;
        i3 = 0;
_L9:
        if(i3 >= 3) goto _L4; else goto _L3
_L3:
        int j3;
        int k3;
        int l3;
        byte byte1;
        SpawnListEntry spawnlistentry;
        int i4;
        j3 = i2;
        k3 = j2;
        l3 = k2;
        byte1 = 6;
        spawnlistentry = null;
        i4 = 0;
_L8:
        if(i4 >= 4) goto _L6; else goto _L5
_L5:
        EntityLiving entityliving;
        j3 += p_77192_0_.field_73012_v.nextInt(byte1) - p_77192_0_.field_73012_v.nextInt(byte1);
        k3 += p_77192_0_.field_73012_v.nextInt(1) - p_77192_0_.field_73012_v.nextInt(1);
        l3 += p_77192_0_.field_73012_v.nextInt(byte1) - p_77192_0_.field_73012_v.nextInt(byte1);
        if(!func_77190_a(enumcreaturetype, p_77192_0_, j3, k3, l3))
        {
            continue; /* Loop/switch isn't completed */
        }
        float f = (float)j3 + 0.5F;
        float f1 = k3;
        float f2 = (float)l3 + 0.5F;
        if(p_77192_0_.func_72977_a(f, f1, f2, 24D) != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f3 = f - (float)chunkcoordinates.field_71574_a;
        float f4 = f1 - (float)chunkcoordinates.field_71572_b;
        float f5 = f2 - (float)chunkcoordinates.field_71573_c;
        float f6 = f3 * f3 + f4 * f4 + f5 * f5;
        if(f6 < 576F)
        {
            continue; /* Loop/switch isn't completed */
        }
        if(spawnlistentry == null)
        {
            spawnlistentry = p_77192_0_.func_73057_a(enumcreaturetype, j3, k3, l3);
            if(spawnlistentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        try
        {
            entityliving = (EntityLiving)spawnlistentry.field_76300_b.getConstructor(new Class[] {
                net.minecraft.src.World.class
            }).newInstance(new Object[] {
                p_77192_0_
            });
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return j;
        }
        entityliving.func_70012_b(f, f1, f2, p_77192_0_.field_73012_v.nextFloat() * 360F, 0.0F);
        if(!entityliving.func_70601_bi())
        {
            break; /* Loop/switch isn't completed */
        }
        l2++;
        p_77192_0_.func_72838_d(entityliving);
        func_77188_a(entityliving, p_77192_0_, f, f1, f2);
        if(l2 < entityliving.func_70641_bl()) goto _L7; else goto _L4
_L7:
        j += l2;
        i4++;
          goto _L8
_L6:
        i3++;
          goto _L9
        j1++;
          goto _L10
_L2:
        return j;
    }

    public static boolean func_77190_a(EnumCreatureType p_77190_0_, World p_77190_1_, int p_77190_2_, int p_77190_3_, int p_77190_4_)
    {
        if(p_77190_0_.func_75600_c() == Material.field_76244_g)
        {
            return p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_, p_77190_4_).func_76224_d() && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_ + 1, p_77190_4_);
        }
        if(!p_77190_1_.func_72797_t(p_77190_2_, p_77190_3_ - 1, p_77190_4_))
        {
            return false;
        } else
        {
            int i = p_77190_1_.func_72798_a(p_77190_2_, p_77190_3_ - 1, p_77190_4_);
            return i != Block.field_71986_z.field_71990_ca && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_, p_77190_4_) && !p_77190_1_.func_72803_f(p_77190_2_, p_77190_3_, p_77190_4_).func_76224_d() && !p_77190_1_.func_72809_s(p_77190_2_, p_77190_3_ + 1, p_77190_4_);
        }
    }

    private static void func_77188_a(EntityLiving p_77188_0_, World p_77188_1_, float p_77188_2_, float p_77188_3_, float p_77188_4_)
    {
        if((p_77188_0_ instanceof EntitySpider) && p_77188_1_.field_73012_v.nextInt(100) == 0)
        {
            EntitySkeleton entityskeleton = new EntitySkeleton(p_77188_1_);
            entityskeleton.func_70012_b(p_77188_2_, p_77188_3_, p_77188_4_, p_77188_0_.field_70177_z, 0.0F);
            p_77188_1_.func_72838_d(entityskeleton);
            entityskeleton.func_70078_a(p_77188_0_);
        } else
        if(p_77188_0_ instanceof EntitySheep)
        {
            ((EntitySheep)p_77188_0_).func_70891_b(EntitySheep.func_70895_a(p_77188_1_.field_73012_v));
        } else
        if((p_77188_0_ instanceof EntityOcelot) && p_77188_1_.field_73012_v.nextInt(7) == 0)
        {
            for(int i = 0; i < 2; i++)
            {
                EntityOcelot entityocelot = new EntityOcelot(p_77188_1_);
                entityocelot.func_70012_b(p_77188_2_, p_77188_3_, p_77188_4_, p_77188_0_.field_70177_z, 0.0F);
                entityocelot.func_70873_a(-24000);
                p_77188_1_.func_72838_d(entityocelot);
            }

        }
    }

    public static void func_77191_a(World p_77191_0_, BiomeGenBase p_77191_1_, int p_77191_2_, int p_77191_3_, int p_77191_4_, int p_77191_5_, Random p_77191_6_)
    {
        List list = p_77191_1_.func_76747_a(EnumCreatureType.creature);
        if(list.isEmpty())
        {
            return;
        }
        while(p_77191_6_.nextFloat() < p_77191_1_.func_76741_f()) 
        {
            SpawnListEntry spawnlistentry = (SpawnListEntry)WeightedRandom.func_76271_a(p_77191_0_.field_73012_v, list);
            int i = spawnlistentry.field_76301_c + p_77191_6_.nextInt((1 + spawnlistentry.field_76299_d) - spawnlistentry.field_76301_c);
            int j = p_77191_2_ + p_77191_6_.nextInt(p_77191_4_);
            int k = p_77191_3_ + p_77191_6_.nextInt(p_77191_5_);
            int l = j;
            int i1 = k;
            int j1 = 0;
            while(j1 < i) 
            {
                boolean flag = false;
                for(int k1 = 0; !flag && k1 < 4; k1++)
                {
                    int l1 = p_77191_0_.func_72825_h(j, k);
                    if(func_77190_a(EnumCreatureType.creature, p_77191_0_, j, l1, k))
                    {
                        float f = (float)j + 0.5F;
                        float f1 = l1;
                        float f2 = (float)k + 0.5F;
                        EntityLiving entityliving;
                        try
                        {
                            entityliving = (EntityLiving)spawnlistentry.field_76300_b.getConstructor(new Class[] {
                                net.minecraft.src.World.class
                            }).newInstance(new Object[] {
                                p_77191_0_
                            });
                        }
                        catch(Exception exception)
                        {
                            exception.printStackTrace();
                            continue;
                        }
                        entityliving.func_70012_b(f, f1, f2, p_77191_6_.nextFloat() * 360F, 0.0F);
                        p_77191_0_.func_72838_d(entityliving);
                        func_77188_a(entityliving, p_77191_0_, f, f1, f2);
                        flag = true;
                    }
                    j += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5);
                    for(k += p_77191_6_.nextInt(5) - p_77191_6_.nextInt(5); j < p_77191_2_ || j >= p_77191_2_ + p_77191_4_ || k < p_77191_3_ || k >= p_77191_3_ + p_77191_4_; k = (i1 + p_77191_6_.nextInt(5)) - p_77191_6_.nextInt(5))
                    {
                        j = (l + p_77191_6_.nextInt(5)) - p_77191_6_.nextInt(5);
                    }

                }

                j1++;
            }
        }
    }

    static 
    {
        field_77194_a = (new Class[] {
            net.minecraft.src.EntitySpider.class, net.minecraft.src.EntityZombie.class, net.minecraft.src.EntitySkeleton.class
        });
    }
}
