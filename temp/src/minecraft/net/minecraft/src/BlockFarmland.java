// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, AxisAlignedBB, AABBPool, 
//            World, Entity

public class BlockFarmland extends Block
{

    protected BlockFarmland(int p_i3945_1_)
    {
        super(p_i3945_1_, Material.field_76248_c);
        field_72059_bZ = 87;
        func_71907_b(true);
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        func_71868_h(255);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        return AxisAlignedBB.func_72332_a().func_72299_a(p_71872_2_ + 0, p_71872_3_ + 0, p_71872_4_ + 0, p_71872_2_ + 1, p_71872_3_ + 1, p_71872_4_ + 1);
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 1 && p_71858_2_ > 0)
        {
            return field_72059_bZ - 1;
        }
        if(p_71858_1_ == 1)
        {
            return field_72059_bZ;
        } else
        {
            return 2;
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(func_72247_n(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_) || p_71847_1_.func_72951_B(p_71847_2_, p_71847_3_ + 1, p_71847_4_))
        {
            p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, 7);
        } else
        {
            int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            if(i > 0)
            {
                p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, i - 1);
            } else
            if(!func_72248_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_))
            {
                p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_71979_v.field_71990_ca);
            }
        }
    }

    public void func_71866_a(World p_71866_1_, int p_71866_2_, int p_71866_3_, int p_71866_4_, Entity p_71866_5_, float p_71866_6_)
    {
        if(!p_71866_1_.field_72995_K && p_71866_1_.field_73012_v.nextFloat() < p_71866_6_ - 0.5F)
        {
            p_71866_1_.func_72859_e(p_71866_2_, p_71866_3_, p_71866_4_, Block.field_71979_v.field_71990_ca);
        }
    }

    private boolean func_72248_l(World p_72248_1_, int p_72248_2_, int p_72248_3_, int p_72248_4_)
    {
        int i = 0;
        for(int j = p_72248_2_ - i; j <= p_72248_2_ + i; j++)
        {
            for(int k = p_72248_4_ - i; k <= p_72248_4_ + i; k++)
            {
                int l = p_72248_1_.func_72798_a(j, p_72248_3_ + 1, k);
                if(l == Block.field_72058_az.field_71990_ca || l == Block.field_71999_bt.field_71990_ca || l == Block.field_71996_bs.field_71990_ca)
                {
                    return true;
                }
            }

        }

        return false;
    }

    private boolean func_72247_n(World p_72247_1_, int p_72247_2_, int p_72247_3_, int p_72247_4_)
    {
        for(int i = p_72247_2_ - 4; i <= p_72247_2_ + 4; i++)
        {
            for(int j = p_72247_3_; j <= p_72247_3_ + 1; j++)
            {
                for(int k = p_72247_4_ - 4; k <= p_72247_4_ + 4; k++)
                {
                    if(p_72247_1_.func_72803_f(i, j, k) == Material.field_76244_g)
                    {
                        return true;
                    }
                }

            }

        }

        return false;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        super.func_71863_a(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_5_);
        Material material = p_71863_1_.func_72803_f(p_71863_2_, p_71863_3_ + 1, p_71863_4_);
        if(material.func_76220_a())
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, Block.field_71979_v.field_71990_ca);
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_71979_v.func_71885_a(0, p_71885_2_, p_71885_3_);
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Block.field_71979_v.field_71990_ca;
    }
}
