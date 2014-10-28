// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class WorldGenFlowers extends WorldGenerator
{

    private int field_76528_a;

    public WorldGenFlowers(int p_i3790_1_)
    {
        field_76528_a = p_i3790_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for(int i = 0; i < 64; i++)
        {
            int j = (p_76484_3_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            int k = (p_76484_4_ + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
            int l = (p_76484_5_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            if(p_76484_1_.func_72799_c(j, k, l) && Block.field_71973_m[field_76528_a].func_71854_d(p_76484_1_, j, k, l))
            {
                p_76484_1_.func_72822_b(j, k, l, field_76528_a);
            }
        }

        return true;
    }
}
