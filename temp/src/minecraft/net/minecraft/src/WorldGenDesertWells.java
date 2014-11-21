// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockHalfSlab

public class WorldGenDesertWells extends WorldGenerator
{

    public WorldGenDesertWells()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for(; p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2; p_76484_4_--) { }
        int i = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_);
        if(i != Block.field_71939_E.field_71990_ca)
        {
            return false;
        }
        for(int j = -2; j <= 2; j++)
        {
            for(int k1 = -2; k1 <= 2; k1++)
            {
                if(p_76484_1_.func_72799_c(p_76484_3_ + j, p_76484_4_ - 1, p_76484_5_ + k1) && p_76484_1_.func_72799_c(p_76484_3_ + j, p_76484_4_ - 2, p_76484_5_ + k1))
                {
                    return false;
                }
            }

        }

        for(int k = -1; k <= 0; k++)
        {
            for(int l1 = -2; l1 <= 2; l1++)
            {
                for(int k2 = -2; k2 <= 2; k2++)
                {
                    p_76484_1_.func_72822_b(p_76484_3_ + l1, p_76484_4_ + k, p_76484_5_ + k2, Block.field_71957_Q.field_71990_ca);
                }

            }

        }

        p_76484_1_.func_72822_b(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_71942_A.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_ - 1, p_76484_4_, p_76484_5_, Block.field_71942_A.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_ + 1, p_76484_4_, p_76484_5_, Block.field_71942_A.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_, p_76484_4_, p_76484_5_ - 1, Block.field_71942_A.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_, p_76484_4_, p_76484_5_ + 1, Block.field_71942_A.field_71990_ca);
        for(int l = -2; l <= 2; l++)
        {
            for(int i2 = -2; i2 <= 2; i2++)
            {
                if(l == -2 || l == 2 || i2 == -2 || i2 == 2)
                {
                    p_76484_1_.func_72822_b(p_76484_3_ + l, p_76484_4_ + 1, p_76484_5_ + i2, Block.field_71957_Q.field_71990_ca);
                }
            }

        }

        p_76484_1_.func_72961_c(p_76484_3_ + 2, p_76484_4_ + 1, p_76484_5_, Block.field_72079_ak.field_71990_ca, 1);
        p_76484_1_.func_72961_c(p_76484_3_ - 2, p_76484_4_ + 1, p_76484_5_, Block.field_72079_ak.field_71990_ca, 1);
        p_76484_1_.func_72961_c(p_76484_3_, p_76484_4_ + 1, p_76484_5_ + 2, Block.field_72079_ak.field_71990_ca, 1);
        p_76484_1_.func_72961_c(p_76484_3_, p_76484_4_ + 1, p_76484_5_ - 2, Block.field_72079_ak.field_71990_ca, 1);
        for(int i1 = -1; i1 <= 1; i1++)
        {
            for(int j2 = -1; j2 <= 1; j2++)
            {
                if(i1 == 0 && j2 == 0)
                {
                    p_76484_1_.func_72822_b(p_76484_3_ + i1, p_76484_4_ + 4, p_76484_5_ + j2, Block.field_71957_Q.field_71990_ca);
                } else
                {
                    p_76484_1_.func_72961_c(p_76484_3_ + i1, p_76484_4_ + 4, p_76484_5_ + j2, Block.field_72079_ak.field_71990_ca, 1);
                }
            }

        }

        for(int j1 = 1; j1 <= 3; j1++)
        {
            p_76484_1_.func_72822_b(p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_ - 1, Block.field_71957_Q.field_71990_ca);
            p_76484_1_.func_72822_b(p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71957_Q.field_71990_ca);
            p_76484_1_.func_72822_b(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ - 1, Block.field_71957_Q.field_71990_ca);
            p_76484_1_.func_72822_b(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71957_Q.field_71990_ca);
        }

        return true;
    }
}
