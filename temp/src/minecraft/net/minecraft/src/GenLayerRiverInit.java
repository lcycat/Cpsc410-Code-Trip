// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache

public class GenLayerRiverInit extends GenLayer
{

    public GenLayerRiverInit(long p_i3893_1_, GenLayer p_i3893_3_)
    {
        super(p_i3893_1_);
        field_75909_a = p_i3893_3_;
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
                ai1[j + i * p_75904_3_] = ai[j + i * p_75904_3_] <= 0 ? 0 : func_75902_a(2) + 2;
            }

        }

        return ai1;
    }
}
