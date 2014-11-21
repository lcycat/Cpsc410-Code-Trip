// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerAddSnow extends GenLayer
{

    public GenLayerAddSnow(long p_i3887_1_, GenLayer p_i3887_3_)
    {
        super(p_i3887_1_);
        field_75909_a = p_i3887_3_;
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int i = p_75904_1_ - 1;
        int j = p_75904_2_ - 1;
        int k = p_75904_3_ + 2;
        int l = p_75904_4_ + 2;
        int ai[] = field_75909_a.func_75904_a(i, j, k, l);
        int ai1[] = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
        for(int i1 = 0; i1 < p_75904_4_; i1++)
        {
            for(int j1 = 0; j1 < p_75904_3_; j1++)
            {
                int k1 = ai[j1 + 1 + (i1 + 1) * k];
                func_75903_a(j1 + p_75904_1_, i1 + p_75904_2_);
                if(k1 == 0)
                {
                    ai1[j1 + i1 * p_75904_3_] = 0;
                    continue;
                }
                int l1 = func_75902_a(5);
                if(l1 == 0)
                {
                    l1 = BiomeGenBase.field_76774_n.field_76756_M;
                } else
                {
                    l1 = 1;
                }
                ai1[j1 + i1 * p_75904_3_] = l1;
            }

        }

        return ai1;
    }
}
