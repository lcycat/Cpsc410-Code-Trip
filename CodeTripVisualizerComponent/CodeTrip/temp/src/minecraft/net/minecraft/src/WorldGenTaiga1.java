// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass

public class WorldGenTaiga1 extends WorldGenerator
{

    public WorldGenTaiga1()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int i = p_76484_2_.nextInt(5) + 7;
        int j = i - p_76484_2_.nextInt(2) - 3;
        int k = i - j;
        int l = 1 + p_76484_2_.nextInt(k + 1);
        boolean flag = true;
        if(p_76484_4_ < 1 || p_76484_4_ + i + 1 > 128)
        {
            return false;
        }
        for(int i1 = p_76484_4_; i1 <= p_76484_4_ + 1 + i && flag; i1++)
        {
            int k1 = 1;
            if(i1 - p_76484_4_ < j)
            {
                k1 = 0;
            } else
            {
                k1 = l;
            }
            for(int i2 = p_76484_3_ - k1; i2 <= p_76484_3_ + k1 && flag; i2++)
            {
                for(int l2 = p_76484_5_ - k1; l2 <= p_76484_5_ + k1 && flag; l2++)
                {
                    if(i1 >= 0 && i1 < 128)
                    {
                        int k3 = p_76484_1_.func_72798_a(i2, i1, l2);
                        if(k3 != 0 && k3 != Block.field_71952_K.field_71990_ca)
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                }

            }

        }

        if(!flag)
        {
            return false;
        }
        int j1 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
        if(j1 != Block.field_71980_u.field_71990_ca && j1 != Block.field_71979_v.field_71990_ca || p_76484_4_ >= 128 - i - 1)
        {
            return false;
        }
        func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
        int l1 = 0;
        for(int j2 = p_76484_4_ + i; j2 >= p_76484_4_ + j; j2--)
        {
            for(int i3 = p_76484_3_ - l1; i3 <= p_76484_3_ + l1; i3++)
            {
                int l3 = i3 - p_76484_3_;
                for(int i4 = p_76484_5_ - l1; i4 <= p_76484_5_ + l1; i4++)
                {
                    int j4 = i4 - p_76484_5_;
                    if((Math.abs(l3) != l1 || Math.abs(j4) != l1 || l1 <= 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(i3, j2, i4)])
                    {
                        func_76485_a(p_76484_1_, i3, j2, i4, Block.field_71952_K.field_71990_ca, 1);
                    }
                }

            }

            if(l1 >= 1 && j2 == p_76484_4_ + j + 1)
            {
                l1--;
                continue;
            }
            if(l1 < l)
            {
                l1++;
            }
        }

        for(int k2 = 0; k2 < i - 1; k2++)
        {
            int j3 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + k2, p_76484_5_);
            if(j3 == 0 || j3 == Block.field_71952_K.field_71990_ca)
            {
                func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + k2, p_76484_5_, Block.field_71951_J.field_71990_ca, 1);
            }
        }

        return true;
    }
}
