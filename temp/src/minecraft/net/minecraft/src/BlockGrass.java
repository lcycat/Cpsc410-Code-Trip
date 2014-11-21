// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, IBlockAccess, 
//            ColorizerGrass, BiomeGenBase, World

public class BlockGrass extends Block
{

    protected BlockGrass(int p_i3952_1_)
    {
        super(p_i3952_1_, Material.field_76247_b);
        field_72059_bZ = 3;
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 1)
        {
            return 0;
        }
        return p_71858_1_ != 0 ? 3 : 2;
    }

    public int func_71895_b(IBlockAccess p_71895_1_, int p_71895_2_, int p_71895_3_, int p_71895_4_, int p_71895_5_)
    {
        if(p_71895_5_ == 1)
        {
            return 0;
        }
        if(p_71895_5_ == 0)
        {
            return 2;
        }
        Material material = p_71895_1_.func_72803_f(p_71895_2_, p_71895_3_ + 1, p_71895_4_);
        return material != Material.field_76259_v && material != Material.field_76258_w ? 3 : 68;
    }

    public int func_71933_m()
    {
        double d = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.func_77480_a(d, d1);
    }

    public int func_71889_f_(int p_71889_1_)
    {
        return func_71933_m();
    }

    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        for(int l = -1; l <= 1; l++)
        {
            for(int i1 = -1; i1 <= 1; i1++)
            {
                int j1 = p_71920_1_.func_72807_a(p_71920_2_ + i1, p_71920_4_ + l).func_76737_k();
                i += (j1 & 0xff0000) >> 16;
                j += (j1 & 0xff00) >> 8;
                k += j1 & 0xff;
            }

        }

        return (i / 9 & 0xff) << 16 | (j / 9 & 0xff) << 8 | k / 9 & 0xff;
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) < 4 && Block.field_71971_o[p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ + 1, p_71847_4_)] > 2)
        {
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_71979_v.field_71990_ca);
        } else
        if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9)
        {
            for(int i = 0; i < 4; i++)
            {
                int j = (p_71847_2_ + p_71847_5_.nextInt(3)) - 1;
                int k = (p_71847_3_ + p_71847_5_.nextInt(5)) - 3;
                int l = (p_71847_4_ + p_71847_5_.nextInt(3)) - 1;
                int i1 = p_71847_1_.func_72798_a(j, k + 1, l);
                if(p_71847_1_.func_72798_a(j, k, l) == Block.field_71979_v.field_71990_ca && p_71847_1_.func_72957_l(j, k + 1, l) >= 4 && Block.field_71971_o[i1] <= 2)
                {
                    p_71847_1_.func_72859_e(j, k, l, Block.field_71980_u.field_71990_ca);
                }
            }

        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_71979_v.func_71885_a(0, p_71885_2_, p_71885_3_);
    }
}
