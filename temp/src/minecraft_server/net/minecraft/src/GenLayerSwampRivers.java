// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerSwampRivers extends GenLayer
{

    public GenLayerSwampRivers(long p_i3898_1_, GenLayer p_i3898_3_)
    {
        super(p_i3898_1_);
        field_75909_a = p_i3898_3_;
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int ai[] = field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
        int ai1[] = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
        for(int i = 0; i < p_75904_4_; i++)
        {
            for(int j = 0; j < p_75904_3_; j++)
            {
                func_75903_a(j + p_75904_1_, i + p_75904_2_);
                int k = ai[j + 1 + (i + 1) * (p_75904_3_ + 2)];
                if(k == BiomeGenBase.field_76780_h.field_76756_M && func_75902_a(6) == 0 || (k == BiomeGenBase.field_76782_w.field_76756_M || k == BiomeGenBase.field_76792_x.field_76756_M) && func_75902_a(8) == 0)
                {
                    ai1[j + i * p_75904_3_] = BiomeGenBase.field_76781_i.field_76756_M;
                } else
                {
                    ai1[j + i * p_75904_3_] = k;
                }
            }

        }

        return ai1;
    }
}
