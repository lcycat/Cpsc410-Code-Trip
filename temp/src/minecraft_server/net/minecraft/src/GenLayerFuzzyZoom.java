// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache

public class GenLayerFuzzyZoom extends GenLayer
{

    public GenLayerFuzzyZoom(long p_i3889_1_, GenLayer p_i3889_3_)
    {
        super(p_i3889_1_);
        super.field_75909_a = p_i3889_3_;
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int i = p_75904_1_ >> 1;
        int j = p_75904_2_ >> 1;
        int k = (p_75904_3_ >> 1) + 3;
        int l = (p_75904_4_ >> 1) + 3;
        int ai[] = field_75909_a.func_75904_a(i, j, k, l);
        int ai1[] = IntCache.func_76445_a(k * 2 * (l * 2));
        int i1 = k << 1;
        for(int j1 = 0; j1 < l - 1; j1++)
        {
            int k1 = j1 << 1;
            int i2 = k1 * i1;
            int j2 = ai[0 + (j1 + 0) * k];
            int k2 = ai[0 + (j1 + 1) * k];
            for(int l2 = 0; l2 < k - 1; l2++)
            {
                func_75903_a(l2 + i << 1, j1 + j << 1);
                int i3 = ai[l2 + 1 + (j1 + 0) * k];
                int j3 = ai[l2 + 1 + (j1 + 1) * k];
                ai1[i2] = j2;
                ai1[i2++ + i1] = func_75913_a(j2, k2);
                ai1[i2] = func_75913_a(j2, i3);
                ai1[i2++ + i1] = func_75912_b(j2, i3, k2, j3);
                j2 = i3;
                k2 = j3;
            }

        }

        int ai2[] = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
        for(int l1 = 0; l1 < p_75904_4_; l1++)
        {
            System.arraycopy(ai1, (l1 + (p_75904_2_ & 1)) * (k << 1) + (p_75904_1_ & 1), ai2, l1 * p_75904_3_, p_75904_3_);
        }

        return ai2;
    }

    protected int func_75913_a(int p_75913_1_, int p_75913_2_)
    {
        return func_75902_a(2) != 0 ? p_75913_2_ : p_75913_1_;
    }

    protected int func_75912_b(int p_75912_1_, int p_75912_2_, int p_75912_3_, int p_75912_4_)
    {
        int i = func_75902_a(4);
        if(i == 0)
        {
            return p_75912_1_;
        }
        if(i == 1)
        {
            return p_75912_2_;
        }
        if(i == 2)
        {
            return p_75912_3_;
        } else
        {
            return p_75912_4_;
        }
    }
}
