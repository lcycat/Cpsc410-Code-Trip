// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockHalfSlab, Material, CreativeTabs, Block, 
//            ItemStack

public class BlockStep extends BlockHalfSlab
{

    public static final String field_72244_a[] = {
        "stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick"
    };

    public BlockStep(int p_i4000_1_, boolean p_i4000_2_)
    {
        super(p_i4000_1_, p_i4000_2_, Material.field_76246_e);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        int i = p_71858_2_ & 7;
        if(i == 0)
        {
            return p_71858_1_ > 1 ? 5 : 6;
        }
        if(i == 1)
        {
            if(p_71858_1_ == 0)
            {
                return 208;
            }
            return p_71858_1_ != 1 ? 192 : 176;
        }
        if(i == 2)
        {
            return 4;
        }
        if(i == 3)
        {
            return 16;
        }
        if(i == 4)
        {
            return Block.field_72081_al.field_72059_bZ;
        }
        if(i == 5)
        {
            return Block.field_72007_bm.field_72059_bZ;
        } else
        {
            return 6;
        }
    }

    public int func_71851_a(int p_71851_1_)
    {
        return func_71858_a(p_71851_1_, 0);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72079_ak.field_71990_ca;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(Block.field_72079_ak.field_71990_ca, 2, p_71880_1_ & 7);
    }

    public String func_72240_d(int p_72240_1_)
    {
        if(p_72240_1_ < 0 || p_72240_1_ >= field_72244_a.length)
        {
            p_72240_1_ = 0;
        }
        return (new StringBuilder()).append(super.func_71917_a()).append(".").append(field_72244_a[p_72240_1_]).toString();
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        if(p_71879_1_ == Block.field_72085_aj.field_71990_ca)
        {
            return;
        }
        for(int i = 0; i < 6; i++)
        {
            if(i != 2)
            {
                p_71879_3_.add(new ItemStack(p_71879_1_, 1, i));
            }
        }

    }

}
