// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, BiomeGenBase, WorldType, IntCache

public class GenLayerBiome extends GenLayer
{

    private BiomeGenBase field_75914_b[];

    public GenLayerBiome(long p_i3888_1_, GenLayer p_i3888_3_, WorldType p_i3888_4_)
    {
        super(p_i3888_1_);
        field_75914_b = (new BiomeGenBase[] {
            BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g, BiomeGenBase.field_76782_w
        });
        field_75909_a = p_i3888_3_;
        if(p_i3888_4_ == WorldType.field_77136_e)
        {
            field_75914_b = (new BiomeGenBase[] {
                BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g
            });
        }
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int ai[] = field_75909_a.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int ai1[] = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
        for(int i = 0; i < p_75904_4_; i++)
        {
            for(int j = 0; j < p_75904_3_; j++)
            {
                func_75903_a(j + p_75904_1_, i + p_75904_2_);
                int k = ai[j + i * p_75904_3_];
                if(k == 0)
                {
                    ai1[j + i * p_75904_3_] = 0;
                    continue;
                }
                if(k == BiomeGenBase.field_76789_p.field_76756_M)
                {
                    ai1[j + i * p_75904_3_] = k;
                    continue;
                }
                if(k == 1)
                {
                    ai1[j + i * p_75904_3_] = field_75914_b[func_75902_a(field_75914_b.length)].field_76756_M;
                    continue;
                }
                int l = field_75914_b[func_75902_a(field_75914_b.length)].field_76756_M;
                if(l == BiomeGenBase.field_76768_g.field_76756_M)
                {
                    ai1[j + i * p_75904_3_] = l;
                } else
                {
                    ai1[j + i * p_75904_3_] = BiomeGenBase.field_76774_n.field_76756_M;
                }
            }

        }

        return ai1;
    }
}
