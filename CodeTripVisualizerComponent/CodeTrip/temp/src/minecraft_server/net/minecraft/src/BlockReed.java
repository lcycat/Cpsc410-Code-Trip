// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockGrass, 
//            Item, AxisAlignedBB

public class BlockReed extends Block
{

    protected BlockReed(int p_i3989_1_, int p_i3989_2_)
    {
        super(p_i3989_1_, Material.field_76254_j);
        field_72059_bZ = p_i3989_2_;
        float f = 0.375F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        func_71907_b(true);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_))
        {
            int i;
            for(i = 1; p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - i, p_71847_4_) == field_71990_ca; i++) { }
            if(i < 3)
            {
                int j = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
                if(j == 15)
                {
                    p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_ + 1, p_71847_4_, field_71990_ca);
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, 0);
                } else
                {
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, j + 1);
                }
            }
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        int i = p_71930_1_.func_72798_a(p_71930_2_, p_71930_3_ - 1, p_71930_4_);
        if(i == field_71990_ca)
        {
            return true;
        }
        if(i != Block.field_71980_u.field_71990_ca && i != Block.field_71979_v.field_71990_ca && i != Block.field_71939_E.field_71990_ca)
        {
            return false;
        }
        if(p_71930_1_.func_72803_f(p_71930_2_ - 1, p_71930_3_ - 1, p_71930_4_) == Material.field_76244_g)
        {
            return true;
        }
        if(p_71930_1_.func_72803_f(p_71930_2_ + 1, p_71930_3_ - 1, p_71930_4_) == Material.field_76244_g)
        {
            return true;
        }
        if(p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_ - 1) == Material.field_76244_g)
        {
            return true;
        }
        return p_71930_1_.func_72803_f(p_71930_2_, p_71930_3_ - 1, p_71930_4_ + 1) == Material.field_76244_g;
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        func_72167_k_(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_);
    }

    protected final void func_72167_k_(World p_72167_1_, int p_72167_2_, int p_72167_3_, int p_72167_4_)
    {
        if(!func_71854_d(p_72167_1_, p_72167_2_, p_72167_3_, p_72167_4_))
        {
            func_71897_c(p_72167_1_, p_72167_2_, p_72167_3_, p_72167_4_, p_72167_1_.func_72805_g(p_72167_2_, p_72167_3_, p_72167_4_), 0);
            p_72167_1_.func_72859_e(p_72167_2_, p_72167_3_, p_72167_4_, 0);
        }
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        return func_71930_b(p_71854_1_, p_71854_2_, p_71854_3_, p_71854_4_);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int i)
    {
        return null;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77758_aJ.field_77779_bT;
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
        return 1;
    }
}
