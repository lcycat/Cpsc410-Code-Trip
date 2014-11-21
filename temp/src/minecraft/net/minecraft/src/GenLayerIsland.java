// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            GenLayer, IntCache

public class GenLayerIsland extends GenLayer
{

    public GenLayerIsland(long p_i3890_1_)
    {
        super(p_i3890_1_);
    }

    public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int ai[] = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
        for(int i = 0; i < p_75904_4_; i++)
        {
            for(int j = 0; j < p_75904_3_; j++)
            {
                func_75903_a(p_75904_1_ + j, p_75904_2_ + i);
                ai[j + i * p_75904_3_] = func_75902_a(10) != 0 ? 0 : 1;
            }

        }

        if(p_75904_1_ > -p_75904_3_ && p_75904_1_ <= 0 && p_75904_2_ > -p_75904_4_ && p_75904_2_ <= 0)
        {
            ai[-p_75904_1_ + -p_75904_2_ * p_75904_3_] = 1;
        }
        return ai;
    }
}
