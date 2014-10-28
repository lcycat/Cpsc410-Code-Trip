// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            BiomeCache, BiomeGenBase, GenLayer, World, 
//            WorldInfo, IntCache, ChunkPosition, WorldType

public class WorldChunkManager
{

    private GenLayer field_76944_d;
    private GenLayer field_76945_e;
    private BiomeCache field_76942_f;
    private List field_76943_g;

    protected WorldChunkManager()
    {
        field_76942_f = new BiomeCache(this);
        field_76943_g = new ArrayList();
        field_76943_g.add(BiomeGenBase.field_76767_f);
        field_76943_g.add(BiomeGenBase.field_76772_c);
        field_76943_g.add(BiomeGenBase.field_76768_g);
        field_76943_g.add(BiomeGenBase.field_76784_u);
        field_76943_g.add(BiomeGenBase.field_76785_t);
        field_76943_g.add(BiomeGenBase.field_76782_w);
        field_76943_g.add(BiomeGenBase.field_76792_x);
    }

    public WorldChunkManager(long p_i3751_1_, WorldType p_i3751_3_)
    {
        this();
        GenLayer agenlayer[] = GenLayer.func_75901_a(p_i3751_1_, p_i3751_3_);
        field_76944_d = agenlayer[0];
        field_76945_e = agenlayer[1];
    }

    public WorldChunkManager(World p_i3752_1_)
    {
        this(p_i3752_1_.func_72905_C(), p_i3752_1_.func_72912_H().func_76067_t());
    }

    public List func_76932_a()
    {
        return field_76943_g;
    }

    public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_)
    {
        return field_76942_f.func_76837_b(p_76935_1_, p_76935_2_);
    }

    public float[] func_76936_a(float p_76936_1_[], int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_)
    {
        IntCache.func_76446_a();
        if(p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_)
        {
            p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
        }
        int ai[] = field_76945_e.func_75904_a(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);
        for(int i = 0; i < p_76936_4_ * p_76936_5_; i++)
        {
            float f = (float)BiomeGenBase.field_76773_a[ai[i]].func_76744_g() / 65536F;
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            p_76936_1_[i] = f;
        }

        return p_76936_1_;
    }

    public float func_76939_a(float p_76939_1_, int p_76939_2_)
    {
        return p_76939_1_;
    }

    public float[] func_76934_b(float p_76934_1_[], int p_76934_2_, int p_76934_3_, int p_76934_4_, int p_76934_5_)
    {
        IntCache.func_76446_a();
        if(p_76934_1_ == null || p_76934_1_.length < p_76934_4_ * p_76934_5_)
        {
            p_76934_1_ = new float[p_76934_4_ * p_76934_5_];
        }
        int ai[] = field_76945_e.func_75904_a(p_76934_2_, p_76934_3_, p_76934_4_, p_76934_5_);
        for(int i = 0; i < p_76934_4_ * p_76934_5_; i++)
        {
            float f = (float)BiomeGenBase.field_76773_a[ai[i]].func_76734_h() / 65536F;
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            p_76934_1_[i] = f;
        }

        return p_76934_1_;
    }

    public BiomeGenBase[] func_76937_a(BiomeGenBase p_76937_1_[], int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_)
    {
        IntCache.func_76446_a();
        if(p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_)
        {
            p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
        }
        int ai[] = field_76944_d.func_75904_a(p_76937_2_, p_76937_3_, p_76937_4_, p_76937_5_);
        for(int i = 0; i < p_76937_4_ * p_76937_5_; i++)
        {
            p_76937_1_[i] = BiomeGenBase.field_76773_a[ai[i]];
        }

        return p_76937_1_;
    }

    public BiomeGenBase[] func_76933_b(BiomeGenBase p_76933_1_[], int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_)
    {
        return func_76931_a(p_76933_1_, p_76933_2_, p_76933_3_, p_76933_4_, p_76933_5_, true);
    }

    public BiomeGenBase[] func_76931_a(BiomeGenBase p_76931_1_[], int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_)
    {
        IntCache.func_76446_a();
        if(p_76931_1_ == null || p_76931_1_.length < p_76931_4_ * p_76931_5_)
        {
            p_76931_1_ = new BiomeGenBase[p_76931_4_ * p_76931_5_];
        }
        if(p_76931_6_ && p_76931_4_ == 16 && p_76931_5_ == 16 && (p_76931_2_ & 0xf) == 0 && (p_76931_3_ & 0xf) == 0)
        {
            BiomeGenBase abiomegenbase[] = field_76942_f.func_76839_e(p_76931_2_, p_76931_3_);
            System.arraycopy(abiomegenbase, 0, p_76931_1_, 0, p_76931_4_ * p_76931_5_);
            return p_76931_1_;
        }
        int ai[] = field_76945_e.func_75904_a(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
        for(int i = 0; i < p_76931_4_ * p_76931_5_; i++)
        {
            p_76931_1_[i] = BiomeGenBase.field_76773_a[ai[i]];
        }

        return p_76931_1_;
    }

    public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_)
    {
        int i = p_76940_1_ - p_76940_3_ >> 2;
        int j = p_76940_2_ - p_76940_3_ >> 2;
        int k = p_76940_1_ + p_76940_3_ >> 2;
        int l = p_76940_2_ + p_76940_3_ >> 2;
        int i1 = (k - i) + 1;
        int j1 = (l - j) + 1;
        int ai[] = field_76944_d.func_75904_a(i, j, i1, j1);
        for(int k1 = 0; k1 < i1 * j1; k1++)
        {
            BiomeGenBase biomegenbase = BiomeGenBase.field_76773_a[ai[k1]];
            if(!p_76940_4_.contains(biomegenbase))
            {
                return false;
            }
        }

        return true;
    }

    public ChunkPosition func_76941_a(int p_76941_1_, int p_76941_2_, int p_76941_3_, List p_76941_4_, Random p_76941_5_)
    {
        int i = p_76941_1_ - p_76941_3_ >> 2;
        int j = p_76941_2_ - p_76941_3_ >> 2;
        int k = p_76941_1_ + p_76941_3_ >> 2;
        int l = p_76941_2_ + p_76941_3_ >> 2;
        int i1 = (k - i) + 1;
        int j1 = (l - j) + 1;
        int ai[] = field_76944_d.func_75904_a(i, j, i1, j1);
        ChunkPosition chunkposition = null;
        int k1 = 0;
        for(int l1 = 0; l1 < ai.length; l1++)
        {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            BiomeGenBase biomegenbase = BiomeGenBase.field_76773_a[ai[l1]];
            if(p_76941_4_.contains(biomegenbase) && (chunkposition == null || p_76941_5_.nextInt(k1 + 1) == 0))
            {
                chunkposition = new ChunkPosition(i2, 0, j2);
                k1++;
            }
        }

        return chunkposition;
    }

    public void func_76938_b()
    {
        field_76942_f.func_76838_a();
    }
}
