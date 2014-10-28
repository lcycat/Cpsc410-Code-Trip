// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass

public class WorldGenShrub extends WorldGenerator
{

    private int field_76527_a;
    private int field_76526_b;

    public WorldGenShrub(int p_i3791_1_, int p_i3791_2_)
    {
        field_76526_b = p_i3791_1_;
        field_76527_a = p_i3791_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for(int i = 0; ((i = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || i == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 0; p_76484_4_--) { }
        int j = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_);
        if(j == Block.field_71979_v.field_71990_ca || j == Block.field_71980_u.field_71990_ca)
        {
            p_76484_4_++;
            func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, Block.field_71951_J.field_71990_ca, field_76526_b);
            for(int k = p_76484_4_; k <= p_76484_4_ + 2; k++)
            {
                int l = k - p_76484_4_;
                int i1 = 2 - l;
                for(int j1 = p_76484_3_ - i1; j1 <= p_76484_3_ + i1; j1++)
                {
                    int k1 = j1 - p_76484_3_;
                    for(int l1 = p_76484_5_ - i1; l1 <= p_76484_5_ + i1; l1++)
                    {
                        int i2 = l1 - p_76484_5_;
                        if((Math.abs(k1) != i1 || Math.abs(i2) != i1 || p_76484_2_.nextInt(2) != 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(j1, k, l1)])
                        {
                            func_76485_a(p_76484_1_, j1, k, l1, Block.field_71952_K.field_71990_ca, field_76527_a);
                        }
                    }

                }

            }

        }
        return true;
    }
}
