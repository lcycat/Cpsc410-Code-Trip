// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerShore extends GenLayer
{

    public GenLayerShore(long p_i3896_1_, GenLayer p_i3896_3_)
    {
        super(p_i3896_1_);
        field_75909_a = p_i3896_3_;
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
                if(k == BiomeGenBase.field_76789_p.field_76756_M)
                {
                    int l = ai[j + 1 + ((i + 1) - 1) * (p_75904_3_ + 2)];
                    int k1 = ai[j + 1 + 1 + (i + 1) * (p_75904_3_ + 2)];
                    int j2 = ai[((j + 1) - 1) + (i + 1) * (p_75904_3_ + 2)];
                    int i3 = ai[j + 1 + (i + 1 + 1) * (p_75904_3_ + 2)];
                    if(l == BiomeGenBase.field_76771_b.field_76756_M || k1 == BiomeGenBase.field_76771_b.field_76756_M || j2 == BiomeGenBase.field_76771_b.field_76756_M || i3 == BiomeGenBase.field_76771_b.field_76756_M)
                    {
                        ai1[j + i * p_75904_3_] = BiomeGenBase.field_76788_q.field_76756_M;
                    } else
                    {
                        ai1[j + i * p_75904_3_] = k;
                    }
                    continue;
                }
                if(k != BiomeGenBase.field_76771_b.field_76756_M && k != BiomeGenBase.field_76781_i.field_76756_M && k != BiomeGenBase.field_76780_h.field_76756_M && k != BiomeGenBase.field_76770_e.field_76756_M)
                {
                    int i1 = ai[j + 1 + ((i + 1) - 1) * (p_75904_3_ + 2)];
                    int l1 = ai[j + 1 + 1 + (i + 1) * (p_75904_3_ + 2)];
                    int k2 = ai[((j + 1) - 1) + (i + 1) * (p_75904_3_ + 2)];
                    int j3 = ai[j + 1 + (i + 1 + 1) * (p_75904_3_ + 2)];
                    if(i1 == BiomeGenBase.field_76771_b.field_76756_M || l1 == BiomeGenBase.field_76771_b.field_76756_M || k2 == BiomeGenBase.field_76771_b.field_76756_M || j3 == BiomeGenBase.field_76771_b.field_76756_M)
                    {
                        ai1[j + i * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
                    } else
                    {
                        ai1[j + i * p_75904_3_] = k;
                    }
                    continue;
                }
                if(k == BiomeGenBase.field_76770_e.field_76756_M)
                {
                    int j1 = ai[j + 1 + ((i + 1) - 1) * (p_75904_3_ + 2)];
                    int i2 = ai[j + 1 + 1 + (i + 1) * (p_75904_3_ + 2)];
                    int l2 = ai[((j + 1) - 1) + (i + 1) * (p_75904_3_ + 2)];
                    int k3 = ai[j + 1 + (i + 1 + 1) * (p_75904_3_ + 2)];
                    if(j1 != BiomeGenBase.field_76770_e.field_76756_M || i2 != BiomeGenBase.field_76770_e.field_76756_M || l2 != BiomeGenBase.field_76770_e.field_76756_M || k3 != BiomeGenBase.field_76770_e.field_76756_M)
                    {
                        ai1[j + i * p_75904_3_] = BiomeGenBase.field_76783_v.field_76756_M;
                    } else
                    {
                        ai1[j + i * p_75904_3_] = k;
                    }
                } else
                {
                    ai1[j + i * p_75904_3_] = k;
                }
            }

        }

        return ai1;
    }
}
