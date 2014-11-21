// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            MapGenBase, ChunkCoordIntPair, StructureStart, StructureBoundingBox, 
//            StructureComponent, World, ChunkPosition

public abstract class MapGenStructure extends MapGenBase
{

    protected Map field_75053_d;

    public MapGenStructure()
    {
        field_75053_d = new HashMap();
    }

    protected void func_75037_a(World p_75037_1_, int p_75037_2_, int p_75037_3_, int p_75037_4_, int p_75037_5_, byte p_75037_6_[])
    {
        if(field_75053_d.containsKey(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_75037_2_, p_75037_3_))))
        {
            return;
        }
        field_75038_b.nextInt();
        if(func_75047_a(p_75037_2_, p_75037_3_))
        {
            StructureStart structurestart = func_75049_b(p_75037_2_, p_75037_3_);
            field_75053_d.put(Long.valueOf(ChunkCoordIntPair.func_77272_a(p_75037_2_, p_75037_3_)), structurestart);
        }
    }

    public boolean func_75051_a(World p_75051_1_, Random p_75051_2_, int p_75051_3_, int p_75051_4_)
    {
        int i = (p_75051_3_ << 4) + 8;
        int j = (p_75051_4_ << 4) + 8;
        boolean flag = false;
        Iterator iterator = field_75053_d.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureStart structurestart = (StructureStart)iterator.next();
            if(structurestart.func_75069_d() && structurestart.func_75071_a().func_78885_a(i, j, i + 15, j + 15))
            {
                structurestart.func_75068_a(p_75051_1_, p_75051_2_, new StructureBoundingBox(i, j, i + 15, j + 15));
                flag = true;
            }
        } while(true);
        return flag;
    }

    public boolean func_75048_a(int p_75048_1_, int p_75048_2_, int p_75048_3_)
    {
        Iterator iterator = field_75053_d.values().iterator();
label0:
        do
        {
            if(iterator.hasNext())
            {
                StructureStart structurestart = (StructureStart)iterator.next();
                if(!structurestart.func_75069_d() || !structurestart.func_75071_a().func_78885_a(p_75048_1_, p_75048_3_, p_75048_1_, p_75048_3_))
                {
                    continue;
                }
                Iterator iterator1 = structurestart.func_75073_b().iterator();
                StructureComponent structurecomponent;
                do
                {
                    if(!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    structurecomponent = (StructureComponent)iterator1.next();
                } while(!structurecomponent.func_74874_b().func_78890_b(p_75048_1_, p_75048_2_, p_75048_3_));
                break;
            } else
            {
                return false;
            }
        } while(true);
        return true;
    }

    public ChunkPosition func_75050_a(World p_75050_1_, int p_75050_2_, int p_75050_3_, int p_75050_4_)
    {
        field_75039_c = p_75050_1_;
        field_75038_b.setSeed(p_75050_1_.func_72905_C());
        long l = field_75038_b.nextLong();
        long l1 = field_75038_b.nextLong();
        long l2 = (long)(p_75050_2_ >> 4) * l;
        long l3 = (long)(p_75050_4_ >> 4) * l1;
        field_75038_b.setSeed(l2 ^ l3 ^ p_75050_1_.func_72905_C());
        func_75037_a(p_75050_1_, p_75050_2_ >> 4, p_75050_4_ >> 4, 0, 0, null);
        double d = 1.7976931348623157E+308D;
        ChunkPosition chunkposition = null;
        Object obj = field_75053_d.values().iterator();
        do
        {
            if(!((Iterator) (obj)).hasNext())
            {
                break;
            }
            StructureStart structurestart = (StructureStart)((Iterator) (obj)).next();
            if(structurestart.func_75069_d())
            {
                StructureComponent structurecomponent = (StructureComponent)structurestart.func_75073_b().get(0);
                ChunkPosition chunkposition2 = structurecomponent.func_74868_a();
                int i = chunkposition2.field_76930_a - p_75050_2_;
                int k = chunkposition2.field_76928_b - p_75050_3_;
                int j1 = chunkposition2.field_76929_c - p_75050_4_;
                double d1 = i + i * k * k + j1 * j1;
                if(d1 < d)
                {
                    d = d1;
                    chunkposition = chunkposition2;
                }
            }
        } while(true);
        if(chunkposition != null)
        {
            return chunkposition;
        }
        obj = func_75052_o_();
        if(obj != null)
        {
            ChunkPosition chunkposition1 = null;
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                ChunkPosition chunkposition3 = (ChunkPosition)iterator.next();
                int j = chunkposition3.field_76930_a - p_75050_2_;
                int i1 = chunkposition3.field_76928_b - p_75050_3_;
                int k1 = chunkposition3.field_76929_c - p_75050_4_;
                double d2 = j + j * i1 * i1 + k1 * k1;
                if(d2 < d)
                {
                    d = d2;
                    chunkposition1 = chunkposition3;
                }
            } while(true);
            return chunkposition1;
        } else
        {
            return null;
        }
    }

    protected List func_75052_o_()
    {
        return null;
    }

    protected abstract boolean func_75047_a(int i, int j);

    protected abstract StructureStart func_75049_b(int i, int j);
}
