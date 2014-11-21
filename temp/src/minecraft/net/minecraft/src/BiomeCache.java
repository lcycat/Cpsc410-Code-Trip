// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            LongHashMap, BiomeCacheBlock, WorldChunkManager, BiomeGenBase

public class BiomeCache
{

    private final WorldChunkManager field_76844_a;
    private long field_76842_b;
    private LongHashMap field_76843_c;
    private List field_76841_d;

    public BiomeCache(WorldChunkManager p_i3749_1_)
    {
        field_76842_b = 0L;
        field_76843_c = new LongHashMap();
        field_76841_d = new ArrayList();
        field_76844_a = p_i3749_1_;
    }

    public BiomeCacheBlock func_76840_a(int p_76840_1_, int p_76840_2_)
    {
        p_76840_1_ >>= 4;
        p_76840_2_ >>= 4;
        long l = (long)p_76840_1_ & 0xffffffffL | ((long)p_76840_2_ & 0xffffffffL) << 32;
        BiomeCacheBlock biomecacheblock = (BiomeCacheBlock)field_76843_c.func_76164_a(l);
        if(biomecacheblock == null)
        {
            biomecacheblock = new BiomeCacheBlock(this, p_76840_1_, p_76840_2_);
            field_76843_c.func_76163_a(l, biomecacheblock);
            field_76841_d.add(biomecacheblock);
        }
        biomecacheblock.field_76886_f = System.currentTimeMillis();
        return biomecacheblock;
    }

    public BiomeGenBase func_76837_b(int p_76837_1_, int p_76837_2_)
    {
        return func_76840_a(p_76837_1_, p_76837_2_).func_76885_a(p_76837_1_, p_76837_2_);
    }

    public void func_76838_a()
    {
        long l = System.currentTimeMillis();
        long l1 = l - field_76842_b;
        if(l1 > 7500L || l1 < 0L)
        {
            field_76842_b = l;
            for(int i = 0; i < field_76841_d.size(); i++)
            {
                BiomeCacheBlock biomecacheblock = (BiomeCacheBlock)field_76841_d.get(i);
                long l2 = l - biomecacheblock.field_76886_f;
                if(l2 > 30000L || l2 < 0L)
                {
                    field_76841_d.remove(i--);
                    long l3 = (long)biomecacheblock.field_76888_d & 0xffffffffL | ((long)biomecacheblock.field_76889_e & 0xffffffffL) << 32;
                    field_76843_c.func_76159_d(l3);
                }
            }

        }
    }

    public BiomeGenBase[] func_76839_e(int p_76839_1_, int p_76839_2_)
    {
        return func_76840_a(p_76839_1_, p_76839_2_).field_76891_c;
    }

    static WorldChunkManager func_76836_a(BiomeCache p_76836_0_)
    {
        return p_76836_0_.field_76844_a;
    }
}
