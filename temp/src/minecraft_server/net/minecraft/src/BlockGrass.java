// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World

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
