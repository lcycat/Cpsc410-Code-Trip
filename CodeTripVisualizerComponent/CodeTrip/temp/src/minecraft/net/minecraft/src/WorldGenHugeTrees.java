// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            BlockGrass, MathHelper

public class WorldGenHugeTrees extends WorldGenerator
{

    private final int field_76522_a;
    private final int field_76520_b;
    private final int field_76521_c;

    public WorldGenHugeTrees(boolean p_i3795_1_, int p_i3795_2_, int p_i3795_3_, int p_i3795_4_)
    {
        super(p_i3795_1_);
        field_76522_a = p_i3795_2_;
        field_76520_b = p_i3795_3_;
        field_76521_c = p_i3795_4_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int i = p_76484_2_.nextInt(3) + field_76522_a;
        boolean flag = true;
        if(p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256)
        {
            return false;
        }
        for(int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++)
        {
            byte byte0 = 2;
            if(j == p_76484_4_)
            {
                byte0 = 1;
            }
            if(j >= (p_76484_4_ + 1 + i) - 2)
            {
                byte0 = 2;
            }
            for(int i1 = p_76484_3_ - byte0; i1 <= p_76484_3_ + byte0 && flag; i1++)
            {
                for(int k1 = p_76484_5_ - byte0; k1 <= p_76484_5_ + byte0 && flag; k1++)
                {
                    if(j >= 0 && j < 256)
                    {
                        int k2 = p_76484_1_.func_72798_a(i1, j, k1);
                        if(k2 != 0 && k2 != Block.field_71952_K.field_71990_ca && k2 != Block.field_71980_u.field_71990_ca && k2 != Block.field_71979_v.field_71990_ca && k2 != Block.field_71951_J.field_71990_ca && k2 != Block.field_71987_y.field_71990_ca)
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
        p_76484_1_.func_72822_b(p_76484_3_, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_, Block.field_71979_v.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_, p_76484_4_ - 1, p_76484_5_ + 1, Block.field_71979_v.field_71990_ca);
        p_76484_1_.func_72822_b(p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_ + 1, Block.field_71979_v.field_71990_ca);
        func_76519_a(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + i, 2, p_76484_2_);
        for(int l = (p_76484_4_ + i) - 2 - p_76484_2_.nextInt(4); l > p_76484_4_ + i / 2; l -= 2 + p_76484_2_.nextInt(4))
        {
            float f = p_76484_2_.nextFloat() * 3.141593F * 2.0F;
            int l1 = p_76484_3_ + (int)(0.5F + MathHelper.func_76134_b(f) * 4F);
            int l2 = p_76484_5_ + (int)(0.5F + MathHelper.func_76126_a(f) * 4F);
            func_76519_a(p_76484_1_, l1, l2, l, 0, p_76484_2_);
            for(int j3 = 0; j3 < 5; j3++)
            {
                int i2 = p_76484_3_ + (int)(1.5F + MathHelper.func_76134_b(f) * (float)j3);
                int i3 = p_76484_5_ + (int)(1.5F + MathHelper.func_76126_a(f) * (float)j3);
                func_76485_a(p_76484_1_, i2, (l - 3) + j3 / 2, i3, Block.field_71951_J.field_71990_ca, field_76520_b);
            }

        }

        for(int j1 = 0; j1 < i; j1++)
        {
            int j2 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + j1, p_76484_5_);
            if(j2 == 0 || j2 == Block.field_71952_K.field_71990_ca)
            {
                func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_, Block.field_71951_J.field_71990_ca, field_76520_b);
                if(j1 > 0)
                {
                    if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_))
                    {
                        func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_, Block.field_71998_bu.field_71990_ca, 8);
                    }
                    if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + j1, p_76484_5_ - 1))
                    {
                        func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                    }
                }
            }
            if(j1 >= i - 1)
            {
                continue;
            }
            j2 = p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_);
            if(j2 == 0 || j2 == Block.field_71952_K.field_71990_ca)
            {
                func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_, Block.field_71951_J.field_71990_ca, field_76520_b);
                if(j1 > 0)
                {
                    if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_))
                    {
                        func_76485_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_, Block.field_71998_bu.field_71990_ca, 2);
                    }
                    if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ - 1))
                    {
                        func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ - 1, Block.field_71998_bu.field_71990_ca, 1);
                    }
                }
            }
            j2 = p_76484_1_.func_72798_a(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 1);
            if(j2 == 0 || j2 == Block.field_71952_K.field_71990_ca)
            {
                func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71951_J.field_71990_ca, field_76520_b);
                if(j1 > 0)
                {
                    if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_ + 1))
                    {
                        func_76485_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 2);
                    }
                    if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 2))
                    {
                        func_76485_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + j1, p_76484_5_ + 2, Block.field_71998_bu.field_71990_ca, 4);
                    }
                }
            }
            j2 = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 1);
            if(j2 != 0 && j2 != Block.field_71952_K.field_71990_ca)
            {
                continue;
            }
            func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71951_J.field_71990_ca, field_76520_b);
            if(j1 <= 0)
            {
                continue;
            }
            if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_ + 1))
            {
                func_76485_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + j1, p_76484_5_ + 1, Block.field_71998_bu.field_71990_ca, 8);
            }
            if(p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 2))
            {
                func_76485_a(p_76484_1_, p_76484_3_, p_76484_4_ + j1, p_76484_5_ + 2, Block.field_71998_bu.field_71990_ca, 4);
            }
        }

        return true;
    }

    private void func_76519_a(World p_76519_1_, int p_76519_2_, int p_76519_3_, int p_76519_4_, int p_76519_5_, Random p_76519_6_)
    {
        byte byte0 = 2;
        for(int i = p_76519_4_ - byte0; i <= p_76519_4_; i++)
        {
            int j = i - p_76519_4_;
            int k = (p_76519_5_ + 1) - j;
            for(int l = p_76519_2_ - k; l <= p_76519_2_ + k + 1; l++)
            {
                int i1 = l - p_76519_2_;
                for(int j1 = p_76519_3_ - k; j1 <= p_76519_3_ + k + 1; j1++)
                {
                    int k1 = j1 - p_76519_3_;
                    if((i1 >= 0 || k1 >= 0 || i1 * i1 + k1 * k1 <= k * k) && (i1 <= 0 && k1 <= 0 || i1 * i1 + k1 * k1 <= (k + 1) * (k + 1)) && (p_76519_6_.nextInt(4) != 0 || i1 * i1 + k1 * k1 <= (k - 1) * (k - 1)) && !Block.field_71970_n[p_76519_1_.func_72798_a(l, i, j1)])
                    {
                        func_76485_a(p_76519_1_, l, i, j1, Block.field_71952_K.field_71990_ca, field_76521_c);
                    }
                }

            }

        }

    }
}
