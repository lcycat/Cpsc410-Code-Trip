// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass, BlockMycelium

public class WorldGenBigMushroom extends WorldGenerator
{

    private int field_76523_a;

    public WorldGenBigMushroom(int p_i3793_1_)
    {
        super(true);
        field_76523_a = -1;
        field_76523_a = p_i3793_1_;
    }

    public WorldGenBigMushroom()
    {
        super(false);
        field_76523_a = -1;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int i = p_76484_2_.nextInt(2);
        if(field_76523_a >= 0)
        {
            i = field_76523_a;
        }
        int j = p_76484_2_.nextInt(3) + 4;
        boolean flag = true;
        if(p_76484_4_ < 1 || p_76484_4_ + j + 1 >= 256)
        {
            return false;
        }
        for(int k = p_76484_4_; k <= p_76484_4_ + 1 + j; k++)
        {
            byte byte0 = 3;
            if(k <= p_76484_4_ + 3)
            {
                byte0 = 0;
            }
            for(int j1 = p_76484_3_ - byte0; j1 <= p_76484_3_ + byte0 && flag; j1++)
            {
                for(int i2 = p_76484_5_ - byte0; i2 <= p_76484_5_ + byte0 && flag; i2++)
                {
                    if(k >= 0 && k < 256)
                    {
                        int l2 = p_76484_1_.func_72798_a(j1, k, i2);
                        if(l2 != 0 && l2 != Block.field_71952_K.field_71990_ca)
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
        int l = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
        if(l != Block.field_71979_v.field_71990_ca && l != Block.field_71980_u.field_71990_ca && l != Block.field_71994_by.field_71990_ca)
        {
            return false;
        }
        int i1 = p_76484_4_ + j;
        if(i == 1)
        {
            i1 = (p_76484_4_ + j) - 3;
        }
        for(int k1 = i1; k1 <= p_76484_4_ + j; k1++)
        {
            int j2 = 1;
            if(k1 < p_76484_4_ + j)
            {
                j2++;
            }
            if(i == 0)
            {
                j2 = 3;
            }
            for(int i3 = p_76484_3_ - j2; i3 <= p_76484_3_ + j2; i3++)
            {
                for(int j3 = p_76484_5_ - j2; j3 <= p_76484_5_ + j2; j3++)
                {
                    int k3 = 5;
                    if(i3 == p_76484_3_ - j2)
                    {
                        k3--;
                    }
                    if(i3 == p_76484_3_ + j2)
                    {
                        k3++;
                    }
                    if(j3 == p_76484_5_ - j2)
                    {
                        k3 -= 3;
                    }
                    if(j3 == p_76484_5_ + j2)
                    {
                        k3 += 3;
                    }
                    if(i == 0 || k1 < p_76484_4_ + j)
                    {
                        if((i3 == p_76484_3_ - j2 || i3 == p_76484_3_ + j2) && (j3 == p_76484_5_ - j2 || j3 == p_76484_5_ + j2))
                        {
                            continue;
                        }
                        if(i3 == p_76484_3_ - (j2 - 1) && j3 == p_76484_5_ - j2)
                        {
                            k3 = 1;
                        }
                        if(i3 == p_76484_3_ - j2 && j3 == p_76484_5_ - (j2 - 1))
                        {
                            k3 = 1;
                        }
                        if(i3 == p_76484_3_ + (j2 - 1) && j3 == p_76484_5_ - j2)
                        {
                            k3 = 3;
                        }
                        if(i3 == p_76484_3_ + j2 && j3 == p_76484_5_ - (j2 - 1))
                        {
                            k3 = 3;
                        }
                        if(i3 == p_76484_3_ - (j2 - 1) && j3 == p_76484_5_ + j2)
                        {
                            k3 = 7;
                        }
                        if(i3 == p_76484_3_ - j2 && j3 == p_76484_5_ + (j2 - 1))
                        {
                            k3 = 7;
                        }
                        if(i3 == p_76484_3_ + (j2 - 1) && j3 == p_76484_5_ + j2)
                        {
                            k3 = 9;
                        }
                        if(i3 == p_76484_3_ + j2 && j3 == p_76484_5_ + (j2 - 1))
                        {
                            k3 = 9;
                        }
                    }
                    if(k3 == 5 && k1 < p_76484_4_ + j)
                    {
                        k3 = 0;
                    }
                    if((k3 != 0 || p_76484_4_ >= (p_76484_4_ + j) - 1) && !Block.field_71970_n[p_76484_1_.func_72798_a(i3, k1, j3)])
                    {
                        func_76485_a(p_76484_1_, i3, k1, j3, Block.field_72000_bn.field_71990_ca + i, k3);
                    }
                }

            }

        }

        for(int l1 = 0; l1 < j; l1++)
        {
            int k2 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + l1, p_76484_5_);
            if(!Block.field_71970_n[k2])
            {
                func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + l1, p_76484_5_, Block.field_72000_bn.field_71990_ca + i, 10);
            }
        }

        return true;
    }
}
