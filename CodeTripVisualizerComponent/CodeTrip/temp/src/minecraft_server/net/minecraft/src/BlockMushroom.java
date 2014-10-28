// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, World, Block, BlockMycelium, 
//            WorldGenBigMushroom, WorldGenerator

public class BlockMushroom extends BlockFlower
{

    protected BlockMushroom(int p_i3971_1_, int p_i3971_2_)
    {
        super(p_i3971_1_, p_i3971_2_);
        float f = 0.2F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        func_71907_b(true);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_5_.nextInt(25) == 0)
        {
            byte byte0 = 4;
            int i = 5;
            for(int j = p_71847_2_ - byte0; j <= p_71847_2_ + byte0; j++)
            {
                for(int l = p_71847_4_ - byte0; l <= p_71847_4_ + byte0; l++)
                {
                    for(int j1 = p_71847_3_ - 1; j1 <= p_71847_3_ + 1; j1++)
                    {
                        if(p_71847_1_.func_72798_a(j, j1, l) == field_71990_ca && --i <= 0)
                        {
                            return;
                        }
                    }

                }

            }

            int k = (p_71847_2_ + p_71847_5_.nextInt(3)) - 1;
            int i1 = (p_71847_3_ + p_71847_5_.nextInt(2)) - p_71847_5_.nextInt(2);
            int k1 = (p_71847_4_ + p_71847_5_.nextInt(3)) - 1;
            for(int l1 = 0; l1 < 4; l1++)
            {
                if(p_71847_1_.func_72799_c(k, i1, k1) && func_71854_d(p_71847_1_, k, i1, k1))
                {
                    p_71847_2_ = k;
                    p_71847_3_ = i1;
                    p_71847_4_ = k1;
                }
                k = (p_71847_2_ + p_71847_5_.nextInt(3)) - 1;
                i1 = (p_71847_3_ + p_71847_5_.nextInt(2)) - p_71847_5_.nextInt(2);
                k1 = (p_71847_4_ + p_71847_5_.nextInt(3)) - 1;
            }

            if(p_71847_1_.func_72799_c(k, i1, k1) && func_71854_d(p_71847_1_, k, i1, k1))
            {
                p_71847_1_.func_72859_e(k, i1, k1, field_71990_ca);
            }
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        return super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_) && func_71854_d(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
    }

    protected boolean func_72263_d_(int p_72263_1_)
    {
        return Block.field_71970_n[p_72263_1_];
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        if(p_71854_3_ < 0 || p_71854_3_ >= 256)
        {
            return false;
        } else
        {
            int i = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_);
            return i == Block.field_71994_by.field_71990_ca || p_71854_1_.func_72883_k(p_71854_2_, p_71854_3_, p_71854_4_) < 13 && func_72263_d_(i);
        }
    }

    public boolean func_72271_c(World p_72271_1_, int p_72271_2_, int p_72271_3_, int p_72271_4_, Random p_72271_5_)
    {
        int i = p_72271_1_.func_72805_g(p_72271_2_, p_72271_3_, p_72271_4_);
        p_72271_1_.func_72822_b(p_72271_2_, p_72271_3_, p_72271_4_, 0);
        WorldGenBigMushroom worldgenbigmushroom = null;
        if(field_71990_ca == Block.field_72109_af.field_71990_ca)
        {
            worldgenbigmushroom = new WorldGenBigMushroom(0);
        } else
        if(field_71990_ca == Block.field_72103_ag.field_71990_ca)
        {
            worldgenbigmushroom = new WorldGenBigMushroom(1);
        }
        if(worldgenbigmushroom == null || !worldgenbigmushroom.func_76484_a(p_72271_1_, p_72271_5_, p_72271_2_, p_72271_3_, p_72271_4_))
        {
            p_72271_1_.func_72961_c(p_72271_2_, p_72271_3_, p_72271_4_, field_71990_ca, i);
            return false;
        } else
        {
            return true;
        }
    }
}
