// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache, BiomeGenBase

public class GenLayerRiverMix extends GenLayer
{

    private GenLayer field_75910_b;
    private GenLayer field_75911_c;

    public GenLayerRiverMix(long p_i3895_1_, GenLayer p_i3895_3_, GenLayer p_i3895_4_)
    {
        super(p_i3895_1_);
        field_75910_b = p_i3895_3_;
        field_75911_c = p_i3895_4_;
    }

    public void func_75905_a(long p_75905_1_)
    {
        field_75910_b.func_75905_a(p_75905_1_);
        field_75911_c.func_75905_a(p_75905_1_);
        super.func_75905_a(p_75905_1_);
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int ai[] = field_75910_b.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int ai1[] = field_75911_c.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int ai2[] = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
        for(int i = 0; i < p_75904_3_ * p_75904_4_; i++)
        {
            if(ai[i] == BiomeGenBase.field_76771_b.field_76756_M)
            {
                ai2[i] = ai[i];
                continue;
            }
            if(ai1[i] >= 0)
            {
                if(ai[i] == BiomeGenBase.field_76774_n.field_76756_M)
                {
                    ai2[i] = BiomeGenBase.field_76777_m.field_76756_M;
                    continue;
                }
                if(ai[i] == BiomeGenBase.field_76789_p.field_76756_M || ai[i] == BiomeGenBase.field_76788_q.field_76756_M)
                {
                    ai2[i] = BiomeGenBase.field_76788_q.field_76756_M;
                } else
                {
                    ai2[i] = ai1[i];
                }
            } else
            {
                ai2[i] = ai[i];
            }
        }

        return ai2;
    }
}
