// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockSand, 
//            EntityFallingSand, EntityPlayer

public class BlockDragonEgg extends Block
{

    public BlockDragonEgg(int p_i3940_1_, int p_i3940_2_)
    {
        super(p_i3940_1_, p_i3940_2_, Material.field_76236_A);
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, field_71990_ca, func_71859_p_());
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, field_71990_ca, func_71859_p_());
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        func_72236_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
    }

    private void func_72236_l(World p_72236_1_, int p_72236_2_, int p_72236_3_, int p_72236_4_)
    {
        if(BlockSand.func_72191_e_(p_72236_1_, p_72236_2_, p_72236_3_ - 1, p_72236_4_) && p_72236_3_ >= 0)
        {
            byte byte0 = 32;
            if(BlockSand.field_72192_a || !p_72236_1_.func_72904_c(p_72236_2_ - byte0, p_72236_3_ - byte0, p_72236_4_ - byte0, p_72236_2_ + byte0, p_72236_3_ + byte0, p_72236_4_ + byte0))
            {
                p_72236_1_.func_72859_e(p_72236_2_, p_72236_3_, p_72236_4_, 0);
                for(; BlockSand.func_72191_e_(p_72236_1_, p_72236_2_, p_72236_3_ - 1, p_72236_4_) && p_72236_3_ > 0; p_72236_3_--) { }
                if(p_72236_3_ > 0)
                {
                    p_72236_1_.func_72859_e(p_72236_2_, p_72236_3_, p_72236_4_, field_71990_ca);
                }
            } else
            {
                EntityFallingSand entityfallingsand = new EntityFallingSand(p_72236_1_, (float)p_72236_2_ + 0.5F, (float)p_72236_3_ + 0.5F, (float)p_72236_4_ + 0.5F, field_71990_ca);
                p_72236_1_.func_72838_d(entityfallingsand);
            }
        }
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        func_72237_n(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
        return true;
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_)
    {
        func_72237_n(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_);
    }

    private void func_72237_n(World p_72237_1_, int p_72237_2_, int p_72237_3_, int p_72237_4_)
    {
        if(p_72237_1_.func_72798_a(p_72237_2_, p_72237_3_, p_72237_4_) != field_71990_ca)
        {
            return;
        }
        if(p_72237_1_.field_72995_K)
        {
            return;
        }
        for(int i = 0; i < 1000; i++)
        {
            int j = (p_72237_2_ + p_72237_1_.field_73012_v.nextInt(16)) - p_72237_1_.field_73012_v.nextInt(16);
            int k = (p_72237_3_ + p_72237_1_.field_73012_v.nextInt(8)) - p_72237_1_.field_73012_v.nextInt(8);
            int l = (p_72237_4_ + p_72237_1_.field_73012_v.nextInt(16)) - p_72237_1_.field_73012_v.nextInt(16);
            if(p_72237_1_.func_72798_a(j, k, l) == 0)
            {
                p_72237_1_.func_72832_d(j, k, l, field_71990_ca, p_72237_1_.func_72805_g(p_72237_2_, p_72237_3_, p_72237_4_));
                p_72237_1_.func_72859_e(p_72237_2_, p_72237_3_, p_72237_4_, 0);
                char c = '\200';
                for(int i1 = 0; i1 < c; i1++)
                {
                    double d = p_72237_1_.field_73012_v.nextDouble();
                    float f = (p_72237_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                    float f1 = (p_72237_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                    float f2 = (p_72237_1_.field_73012_v.nextFloat() - 0.5F) * 0.2F;
                    double d1 = (double)j + (double)(p_72237_2_ - j) * d + (p_72237_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
                    double d2 = ((double)k + (double)(p_72237_3_ - k) * d + p_72237_1_.field_73012_v.nextDouble() * 1.0D) - 0.5D;
                    double d3 = (double)l + (double)(p_72237_4_ - l) * d + (p_72237_1_.field_73012_v.nextDouble() - 0.5D) * 1.0D + 0.5D;
                    p_72237_1_.func_72869_a("portal", d1, d2, d3, f, f1, f2);
                }

                return;
            }
        }

    }

    public int func_71859_p_()
    {
        return 3;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71857_b()
    {
        return 27;
    }
}
