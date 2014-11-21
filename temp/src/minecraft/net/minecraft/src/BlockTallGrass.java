// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Material, ColorizerGrass, ColorizerFoliage, 
//            IBlockAccess, BiomeGenBase, Item, World, 
//            EntityPlayer, ItemStack, ItemShears, StatList, 
//            Block, CreativeTabs

public class BlockTallGrass extends BlockFlower
{

    protected BlockTallGrass(int p_i4002_1_, int p_i4002_2_)
    {
        super(p_i4002_1_, p_i4002_2_, Material.field_76255_k);
        float f = 0.4F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_2_ == 1)
        {
            return field_72059_bZ;
        }
        if(p_71858_2_ == 2)
        {
            return field_72059_bZ + 16 + 1;
        }
        if(p_71858_2_ == 0)
        {
            return field_72059_bZ + 16;
        } else
        {
            return field_72059_bZ;
        }
    }

    public int func_71933_m()
    {
        double d = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.func_77480_a(d, d1);
    }

    public int func_71889_f_(int p_71889_1_)
    {
        if(p_71889_1_ == 0)
        {
            return 0xffffff;
        } else
        {
            return ColorizerFoliage.func_77468_c();
        }
    }

    public int func_71920_b(IBlockAccess p_71920_1_, int p_71920_2_, int p_71920_3_, int p_71920_4_)
    {
        int i = p_71920_1_.func_72805_g(p_71920_2_, p_71920_3_, p_71920_4_);
        if(i == 0)
        {
            return 0xffffff;
        } else
        {
            return p_71920_1_.func_72807_a(p_71920_2_, p_71920_4_).func_76737_k();
        }
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        if(p_71885_2_.nextInt(8) == 0)
        {
            return Item.field_77690_S.field_77779_bT;
        } else
        {
            return -1;
        }
    }

    public int func_71910_a(int p_71910_1_, Random p_71910_2_)
    {
        return 1 + p_71910_2_.nextInt(p_71910_1_ * 2 + 1);
    }

    public void func_71893_a(World p_71893_1_, EntityPlayer p_71893_2_, int p_71893_3_, int p_71893_4_, int p_71893_5_, int p_71893_6_)
    {
        if(!p_71893_1_.field_72995_K && p_71893_2_.func_71045_bC() != null && p_71893_2_.func_71045_bC().field_77993_c == Item.field_77745_be.field_77779_bT)
        {
            p_71893_2_.func_71064_a(StatList.field_75934_C[field_71990_ca], 1);
            func_71929_a(p_71893_1_, p_71893_3_, p_71893_4_, p_71893_5_, new ItemStack(Block.field_71962_X, 1, p_71893_6_));
        } else
        {
            super.func_71893_a(p_71893_1_, p_71893_2_, p_71893_3_, p_71893_4_, p_71893_5_, p_71893_6_);
        }
    }

    public int func_71873_h(World p_71873_1_, int p_71873_2_, int p_71873_3_, int p_71873_4_)
    {
        return p_71873_1_.func_72805_g(p_71873_2_, p_71873_3_, p_71873_4_);
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        for(int i = 1; i < 3; i++)
        {
            p_71879_3_.add(new ItemStack(p_71879_1_, 1, i));
        }

    }
}
