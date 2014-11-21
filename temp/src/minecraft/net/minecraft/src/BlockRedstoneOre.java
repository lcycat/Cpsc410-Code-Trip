// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, Item, 
//            ItemStack, EntityPlayer, Entity

public class BlockRedstoneOre extends Block
{

    private boolean field_72178_a;

    public BlockRedstoneOre(int p_i3987_1_, int p_i3987_2_, boolean p_i3987_3_)
    {
        super(p_i3987_1_, p_i3987_2_, Material.field_76246_e);
        if(p_i3987_3_)
        {
            func_71907_b(true);
        }
        field_72178_a = p_i3987_3_;
    }

    public int func_71859_p_()
    {
        return 30;
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_)
    {
        func_72176_l(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_);
        super.func_71921_a(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_);
    }

    public void func_71891_b(World p_71891_1_, int p_71891_2_, int p_71891_3_, int p_71891_4_, Entity p_71891_5_)
    {
        func_72176_l(p_71891_1_, p_71891_2_, p_71891_3_, p_71891_4_);
        super.func_71891_b(p_71891_1_, p_71891_2_, p_71891_3_, p_71891_4_, p_71891_5_);
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        func_72176_l(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_);
        return super.func_71903_a(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_, p_71903_6_, p_71903_7_, p_71903_8_, p_71903_9_);
    }

    private void func_72176_l(World p_72176_1_, int p_72176_2_, int p_72176_3_, int p_72176_4_)
    {
        func_72177_n(p_72176_1_, p_72176_2_, p_72176_3_, p_72176_4_);
        if(field_71990_ca == Block.field_72047_aN.field_71990_ca)
        {
            p_72176_1_.func_72859_e(p_72176_2_, p_72176_3_, p_72176_4_, Block.field_72048_aO.field_71990_ca);
        }
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(field_71990_ca == Block.field_72048_aO.field_71990_ca)
        {
            p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_, p_71847_4_, Block.field_72047_aN.field_71990_ca);
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Item.field_77767_aC.field_77779_bT;
    }

    public int func_71910_a(int p_71910_1_, Random p_71910_2_)
    {
        return func_71925_a(p_71910_2_) + p_71910_2_.nextInt(p_71910_1_ + 1);
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 4 + p_71925_1_.nextInt(2);
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        super.func_71914_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, p_71914_5_, p_71914_6_, p_71914_7_);
        if(func_71885_a(p_71914_5_, p_71914_1_.field_73012_v, p_71914_7_) != field_71990_ca)
        {
            int i = 1 + p_71914_1_.field_73012_v.nextInt(5);
            func_71923_g(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, i);
        }
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        if(field_72178_a)
        {
            func_72177_n(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_);
        }
    }

    private void func_72177_n(World p_72177_1_, int p_72177_2_, int p_72177_3_, int p_72177_4_)
    {
        Random random = p_72177_1_.field_73012_v;
        double d = 0.0625D;
        for(int i = 0; i < 6; i++)
        {
            double d1 = (float)p_72177_2_ + random.nextFloat();
            double d2 = (float)p_72177_3_ + random.nextFloat();
            double d3 = (float)p_72177_4_ + random.nextFloat();
            if(i == 0 && !p_72177_1_.func_72804_r(p_72177_2_, p_72177_3_ + 1, p_72177_4_))
            {
                d2 = (double)(p_72177_3_ + 1) + d;
            }
            if(i == 1 && !p_72177_1_.func_72804_r(p_72177_2_, p_72177_3_ - 1, p_72177_4_))
            {
                d2 = (double)(p_72177_3_ + 0) - d;
            }
            if(i == 2 && !p_72177_1_.func_72804_r(p_72177_2_, p_72177_3_, p_72177_4_ + 1))
            {
                d3 = (double)(p_72177_4_ + 1) + d;
            }
            if(i == 3 && !p_72177_1_.func_72804_r(p_72177_2_, p_72177_3_, p_72177_4_ - 1))
            {
                d3 = (double)(p_72177_4_ + 0) - d;
            }
            if(i == 4 && !p_72177_1_.func_72804_r(p_72177_2_ + 1, p_72177_3_, p_72177_4_))
            {
                d1 = (double)(p_72177_2_ + 1) + d;
            }
            if(i == 5 && !p_72177_1_.func_72804_r(p_72177_2_ - 1, p_72177_3_, p_72177_4_))
            {
                d1 = (double)(p_72177_2_ + 0) - d;
            }
            if(d1 < (double)p_72177_2_ || d1 > (double)(p_72177_2_ + 1) || d2 < 0.0D || d2 > (double)(p_72177_3_ + 1) || d3 < (double)p_72177_4_ || d3 > (double)(p_72177_4_ + 1))
            {
                p_72177_1_.func_72869_a("reddust", d1, d2, d3, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(Block.field_72047_aN);
    }
}
