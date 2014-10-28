// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockHalfSlab, Material, CreativeTabs, Block, 
//            ItemStack

public class BlockWoodSlab extends BlockHalfSlab
{

    public static final String field_72243_a[] = {
        "oak", "spruce", "birch", "jungle"
    };

    public BlockWoodSlab(int p_i4022_1_, boolean p_i4022_2_)
    {
        super(p_i4022_1_, p_i4022_2_, Material.field_76245_d);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        switch(p_71858_2_ & 7)
        {
        default:
            return 4;

        case 1: // '\001'
            return 198;

        case 2: // '\002'
            return 214;

        case 3: // '\003'
            return 199;
        }
    }

    public int func_71851_a(int p_71851_1_)
    {
        return func_71858_a(p_71851_1_, 0);
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72092_bO.field_71990_ca;
    }

    protected ItemStack func_71880_c_(int p_71880_1_)
    {
        return new ItemStack(Block.field_72092_bO.field_71990_ca, 2, p_71880_1_ & 7);
    }

    public String func_72240_d(int p_72240_1_)
    {
        if(p_72240_1_ < 0 || p_72240_1_ >= field_72243_a.length)
        {
            p_72240_1_ = 0;
        }
        return (new StringBuilder()).append(super.func_71917_a()).append(".").append(field_72243_a[p_72240_1_]).toString();
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        if(p_71879_1_ == Block.field_72090_bN.field_71990_ca)
        {
            return;
        }
        for(int i = 0; i < 4; i++)
        {
            p_71879_3_.add(new ItemStack(p_71879_1_, 1, i));
        }

    }

}
