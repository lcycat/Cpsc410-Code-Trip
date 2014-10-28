// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Material, Block, 
//            BlockLeaves, BlockGrass

public class WorldGenSwamp extends WorldGenerator
{

    public WorldGenSwamp()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int i = p_76484_2_.nextInt(4) + 5;
        for(; p_76484_1_.func_72803_f(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == Material.field_76244_g; p_76484_4_--) { }
        boolean flag = true;
        if(p_76484_4_ < 1 || p_76484_4_ + i + 1 > 128)
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
                byte0 = 3;
            }
            for(int k1 = p_76484_3_ - byte0; k1 <= p_76484_3_ + byte0 && flag; k1++)
            {
                for(int k2 = p_76484_5_ - byte0; k2 <= p_76484_5_ + byte0 && flag; k2++)
                {
                    if(j >= 0 && j < 128)
                    {
                        int j3 = p_76484_1_.func_72798_a(k1, j, k2);
                        if(j3 == 0 || j3 == Block.field_71952_K.field_71990_ca)
                        {
                            continue;
                        }
                        if(j3 == Block.field_71943_B.field_71990_ca || j3 == Block.field_71942_A.field_71990_ca)
                        {
                            if(j > p_76484_4_)
                            {
                                flag = false;
                            }
                        } else
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
        if(k != Block.field_71980_u.field_71990_ca && k != Block.field_71979_v.field_71990_ca || p_76484_4_ >= 128 - i - 1)
        {
            return false;
        }
        func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
        for(int l = (p_76484_4_ - 3) + i; l <= p_76484_4_ + i; l++)
        {
            int l1 = l - (p_76484_4_ + i);
            int l2 = 2 - l1 / 2;
            for(int k3 = p_76484_3_ - l2; k3 <= p_76484_3_ + l2; k3++)
            {
                int i4 = k3 - p_76484_3_;
                for(int k4 = p_76484_5_ - l2; k4 <= p_76484_5_ + l2; k4++)
                {
                    int l4 = k4 - p_76484_5_;
                    if((Math.abs(i4) != l2 || Math.abs(l4) != l2 || p_76484_2_.nextInt(2) != 0 && l1 != 0) && !Block.field_71970_n[p_76484_1_.func_72798_a(k3, l, k4)])
                    {
                        func_76486_a(p_76484_1_, k3, l, k4, Block.field_71952_K.field_71990_ca);
                    }
                }

            }

        }

        for(int i1 = 0; i1 < i; i1++)
        {
            int i2 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + i1, p_76484_5_);
            if(i2 == 0 || i2 == Block.field_71952_K.field_71990_ca || i2 == Block.field_71942_A.field_71990_ca || i2 == Block.field_71943_B.field_71990_ca)
            {
                func_76486_a(p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_, Block.field_71951_J.field_71990_ca);
            }
        }

        for(int j1 = (p_76484_4_ - 3) + i; j1 <= p_76484_4_ + i; j1++)
        {
            int j2 = j1 - (p_76484_4_ + i);
            int i3 = 2 - j2 / 2;
            for(int l3 = p_76484_3_ - i3; l3 <= p_76484_3_ + i3; l3++)
            {
                for(int j4 = p_76484_5_ - i3; j4 <= p_76484_5_ + i3; j4++)
                {
                    if(p_76484_1_.func_72798_a(l3, j1, j4) != Block.field_71952_K.field_71990_ca)
                    {
                        continue;
                    }
                    if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l3 - 1, j1, j4) == 0)
                    {
                        func_76536_b(p_76484_1_, l3 - 1, j1, j4, 8);
                    }
                    if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l3 + 1, j1, j4) == 0)
                    {
                        func_76536_b(p_76484_1_, l3 + 1, j1, j4, 2);
                    }
                    if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l3, j1, j4 - 1) == 0)
                    {
                        func_76536_b(p_76484_1_, l3, j1, j4 - 1, 1);
                    }
                    if(p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_72798_a(l3, j1, j4 + 1) == 0)
                    {
                        func_76536_b(p_76484_1_, l3, j1, j4 + 1, 4);
                    }
                }

            }

        }

        return true;
    }

    private void func_76536_b(World p_76536_1_, int p_76536_2_, int p_76536_3_, int p_76536_4_, int p_76536_5_)
    {
        func_76485_a(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Block.field_71998_bu.field_71990_ca, p_76536_5_);
        for(int i = 4; p_76536_1_.func_72798_a(p_76536_2_, --p_76536_3_, p_76536_4_) == 0 && i > 0; i--)
        {
            func_76485_a(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Block.field_71998_bu.field_71990_ca, p_76536_5_);
        }

    }
}
