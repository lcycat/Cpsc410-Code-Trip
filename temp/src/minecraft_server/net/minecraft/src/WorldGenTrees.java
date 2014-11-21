// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass, Direction

public class WorldGenTrees extends WorldGenerator
{

    private final int field_76533_a;
    private final boolean field_76531_b;
    private final int field_76532_c;
    private final int field_76530_d;

    public WorldGenTrees(boolean p_i3802_1_)
    {
        this(p_i3802_1_, 4, 0, 0, false);
    }

    public WorldGenTrees(boolean p_i3803_1_, int p_i3803_2_, int p_i3803_3_, int p_i3803_4_, boolean p_i3803_5_)
    {
        super(p_i3803_1_);
        field_76533_a = p_i3803_2_;
        field_76532_c = p_i3803_3_;
        field_76530_d = p_i3803_4_;
        field_76531_b = p_i3803_5_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int i = p_76484_2_.nextInt(3) + field_76533_a;
        boolean flag = true;
        if(p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256)
        {
            return false;
        }
        for(int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++)
        {
            byte byte0 = 1;
            if(j == p_76484_4_)
            {
                byte0 = 0;
            }
            if(j >= (p_76484_4_ + 1 + i) - 2)
            {
                byte0 = 2;
            }
            for(int l = p_76484_3_ - byte0; l <= p_76484_3_ + byte0 && flag; l++)
            {
                for(int j1 = p_76484_5_ - byte0; j1 <= p_76484_5_ + byte0 && flag; j1++)
                {
                    if(j >= 0 && j < 256)
                    {
                        int k2 = p_76484_1_.func_72798_a(l, j, j1);
                        if(k2 != 0 && k2 != Block.field_71952_K.field_71990_ca && k2 != Block.field_71980_u.field_71990_ca && k2 != Block.field_71979_v.field_71990_ca && k2 != Block.field_71951_J.field_71990_ca)
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
        int k = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
        if(k != Block.field_71980_u.field_71990_ca && k != Block.field_71979_v.field_71990_ca || p_76484_4_ >= 256 - i - 1)
        {
            return false;
        }
        func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
        byte byte1 = 3;
        int i1 = 0;
        for(int k1 = (p_76484_4_ - byte1) + i; k1 <= p_76484_4_ + i; k1++)
        {
            int l2 = k1 - (p_76484_4_ + i);
            int l3 = (i1 + 1) - l2 / 2;
            for(int k4 = p_76484_3_ - l3; k4 <= p_76484_3_ + l3; k4++)
            {
                int i5 = k4 - p_76484_3_;
                for(int k5 = p_76484_5_ - l3; k5 <= p_76484_5_ + l3; k5++)
                {
                    int l5 = k5 - p_76484_5_;
                    if((Math.abs(i5) != l3 || Math.abs(l5) != l3 || p_76484_2_.nextInt(2) != 0 && l2 != 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(k4, k1, k5)])
                    {
                        func_76485_a(p_76484_1_, k4, k1, k5, Block.field_71952_K.field_71990_ca, field_76530_d);
                    }
                }

            }

        }

        for(int l1 = 0; l1 < i; l1++)
        {
            int i3 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + l1, p_76484_5_);
            if(i3 != 0 && i3 != Block.field_71952_K.field_71990_ca)
            {
                continue;
            }
            func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + l1, p_76484_5_, Block.field_71951_J.field_71990_ca, field_76532_c);
            if(!field_76531_b || l1 <= 0)
            {
                continue;
            }
            if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + l1, p_76484_5_))
            {
                func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + l1, p_76484_5_, Block.field_71998_bu.field_71990_ca, 8);
            }
            if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + l1, p_76484_5_))
            {
                func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + l1, p_76484_5_, Block.field_71998_bu.field_71990_ca, 2);
            }
            if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + l1, p_76484_5_ - 1))
            {
                func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + l1, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
            }
            if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + l1, p_76484_5_ + 1))
            {
                func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + l1, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 4);
            }
        }

        if(field_76531_b)
        {
            for(int i2 = (p_76484_4_ - 3) + i; i2 <= p_76484_4_ + i; i2++)
            {
                int j3 = i2 - (p_76484_4_ + i);
                int i4 = 2 - j3 / 2;
                for(int l4 = p_76484_3_ - i4; l4 <= p_76484_3_ + i4; l4++)
                {
                    for(int j5 = p_76484_5_ - i4; j5 <= p_76484_5_ + i4; j5++)
                    {
                        if(p_76484_1_.func_72798_a(l4, i2, j5) != Block.field_71952_K.field_71990_ca)
                        {
                            continue;
                        }
                        if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l4 - 1, i2, j5) == 0)
                        {
                            func_76529_b(p_76484_1_, l4 - 1, i2, j5, 8);
                        }
                        if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l4 + 1, i2, j5) == 0)
                        {
                            func_76529_b(p_76484_1_, l4 + 1, i2, j5, 2);
                        }
                        if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l4, i2, j5 - 1) == 0)
                        {
                            func_76529_b(p_76484_1_, l4, i2, j5 - 1, 1);
                        }
                        if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l4, i2, j5 + 1) == 0)
                        {
                            func_76529_b(p_76484_1_, l4, i2, j5 + 1, 4);
                        }
                    }

                }

            }

            if(p_76484_2_.nextInt(5) == 0 && i > 5)
            {
                for(int j2 = 0; j2 < 2; j2++)
                {
                    for(int k3 = 0; k3 < 4; k3++)
                    {
                        if(p_76484_2_.nextInt(4 - j2) == 0)
                        {
                            int j4 = p_76484_2_.nextInt(3);
                            func_76485_a(p_76484_1_, p_76484_3_ + Direction.field_71583_a[Direction.field_71580_e[k3]], ((p_76484_4_ + i) - 5) + j2, p_76484_5_ + Direction.field_71581_b[Direction.field_71580_e[k3]], Block.field_72086_bP.field_71990_ca, j4 << 2 | k3);
                        }
                    }

                }

            }
        }
        return true;
    }

    private void func_76529_b(World p_76529_1_, int p_76529_2_, int p_76529_3_, int p_76529_4_, int p_76529_5_)
    {
        func_76485_a(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Block.field_71998_bu.field_71990_ca, p_76529_5_);
        for(int i = 4; p_76529_1_.func_72798_a(p_76529_2_, --p_76529_3_, p_76529_4_) == 0 && i > 0; i--)
        {
            func_76485_a(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Block.field_71998_bu.field_71990_ca, p_76529_5_);
        }

    }
}
