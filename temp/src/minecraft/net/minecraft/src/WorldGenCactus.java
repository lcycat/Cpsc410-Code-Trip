// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class WorldGenCactus extends WorldGenerator
{

    public WorldGenCactus()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for(int i = 0; i < 10; i++)
        {
            int j = (p_76484_3_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            int k = (p_76484_4_ + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
            int l = (p_76484_5_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            if(!p_76484_1_.func_72799_c(j, k, l))
            {
                continue;
            }
            int i1 = 1 + p_76484_2_.nextInt(p_76484_2_.nextInt(3) + 1);
            for(int j1 = 0; j1 < i1; j1++)
            {
                if(Block.field_72038_aV.func_71854_d(p_76484_1_, j, k + j1, l))
                {
                    p_76484_1_.func_72822_b(j, k + j1, l, Block.field_72038_aV.field_71990_ca);
                }
            }

        }

        return true;
    }
}
