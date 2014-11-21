// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFluid, Material, World, Block, 
//            BlockFire, IBlockAccess

public class BlockStationary extends BlockFluid
{

    protected BlockStationary(int p_i3966_1_, Material p_i3966_2_)
    {
        super(p_i3966_1_, p_i3966_2_);
        func_71907_b(false);
        if(p_i3966_2_ == Material.field_76256_h)
        {
            func_71907_b(true);
        }
    }

    public boolean func_71918_c(IBlockAccess p_71918_1_, int p_71918_2_, int p_71918_3_, int p_71918_4_)
    {
        return field_72018_cp != Material.field_76256_h;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
        if(p_71863_1_.func_72798_a(p_71863_2_, p_71863_3_, p_71863_4_) == field_71990_ca)
        {
            func_72215_l(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
        }
    }

    private void func_72215_l(World p_72215_1_, int p_72215_2_, int p_72215_3_, int p_72215_4_)
    {
        int i = p_72215_1_.func_72805_g(p_72215_2_, p_72215_3_, p_72215_4_);
        p_72215_1_.field_73014_t = true;
        p_72215_1_.func_72961_c(p_72215_2_, p_72215_3_, p_72215_4_, field_71990_ca - 1, i);
        p_72215_1_.func_72909_d(p_72215_2_, p_72215_3_, p_72215_4_, p_72215_2_, p_72215_3_, p_72215_4_);
        p_72215_1_.func_72836_a(p_72215_2_, p_72215_3_, p_72215_4_, field_71990_ca - 1, func_71859_p_());
        p_72215_1_.field_73014_t = false;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(field_72018_cp == Material.field_76256_h)
        {
            int i = p_71847_5_.nextInt(3);
            for(int j = 0; j < i; j++)
            {
                p_71847_2_ += p_71847_5_.nextInt(3) - 1;
                p_71847_3_++;
                p_71847_4_ += p_71847_5_.nextInt(3) - 1;
                int l = p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_, p_71847_4_);
                if(l == 0)
                {
                    if(func_72216_n(p_71847_1_, p_71847_2_ - 1, p_71847_3_, p_71847_4_) || func_72216_n(p_71847_1_, p_71847_2_ + 1, p_71847_3_, p_71847_4_) || func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ - 1) || func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_ + 1) || func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_ - 1, p_71847_4_) || func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_ + 1, p_71847_4_))
                    {
                        p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72067_ar.field_71990_ca);
                        return;
                    }
                    continue;
                }
                if(Block.field_71973_m[l].field_72018_cp.func_76230_c())
                {
                    return;
                }
            }

            if(i == 0)
            {
                int k = p_71847_2_;
                int i1 = p_71847_4_;
                for(int j1 = 0; j1 < 3; j1++)
                {
                    p_71847_2_ = (k + p_71847_5_.nextInt(3)) - 1;
                    p_71847_4_ = (i1 + p_71847_5_.nextInt(3)) - 1;
                    if(p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_) && func_72216_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
                    {
                        p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_ + 1, p_71847_4_, Block.field_72067_ar.field_71990_ca);
                    }
                }

            }
        }
    }

    private boolean func_72216_n(World p_72216_1_, int p_72216_2_, int p_72216_3_, int p_72216_4_)
    {
        return p_72216_1_.func_72803_f(p_72216_2_, p_72216_3_, p_72216_4_).func_76217_h();
    }
}
