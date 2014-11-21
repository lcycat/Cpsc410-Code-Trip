// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerHills extends GenLayer
{

    public GenLayerHills(long p_i3892_1_, GenLayer p_i3892_3_)
    {
        super(p_i3892_1_);
        field_75909_a = p_i3892_3_;
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
                if(func_75902_a(3) == 0)
                {
                    int l = k;
                    if(k == BiomeGenBase.field_76769_d.field_76756_M)
                    {
                        l = BiomeGenBase.field_76786_s.field_76756_M;
                    } else
                    if(k == BiomeGenBase.field_76767_f.field_76756_M)
                    {
                        l = BiomeGenBase.field_76785_t.field_76756_M;
                    } else
                    if(k == BiomeGenBase.field_76768_g.field_76756_M)
                    {
                        l = BiomeGenBase.field_76784_u.field_76756_M;
                    } else
                    if(k == BiomeGenBase.field_76772_c.field_76756_M)
                    {
                        l = BiomeGenBase.field_76767_f.field_76756_M;
                    } else
                    if(k == BiomeGenBase.field_76774_n.field_76756_M)
                    {
                        l = BiomeGenBase.field_76775_o.field_76756_M;
                    } else
                    if(k == BiomeGenBase.field_76782_w.field_76756_M)
                    {
                        l = BiomeGenBase.field_76792_x.field_76756_M;
                    }
                    if(l == k)
                    {
                        ai1[j + i * p_75904_3_] = k;
                        continue;
                    }
                    int i1 = ai[j + 1 + ((i + 1) - 1) * (p_75904_3_ + 2)];
                    int j1 = ai[j + 1 + 1 + (i + 1) * (p_75904_3_ + 2)];
                    int k1 = ai[((j + 1) - 1) + (i + 1) * (p_75904_3_ + 2)];
                    int l1 = ai[j + 1 + (i + 1 + 1) * (p_75904_3_ + 2)];
                    if(i1 == k && j1 == k && k1 == k && l1 == k)
                    {
                        ai1[j + i * p_75904_3_] = l;
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
