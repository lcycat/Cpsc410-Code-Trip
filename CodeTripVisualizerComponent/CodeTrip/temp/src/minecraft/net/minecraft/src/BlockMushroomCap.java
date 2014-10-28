// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, BlockFlower, Material, World

public class BlockMushroomCap extends Block
{

    private int field_72197_a;

    public BlockMushroomCap(int p_i3958_1_, Material p_i3958_2_, int p_i3958_3_, int p_i3958_4_)
    {
        super(p_i3958_1_, p_i3958_3_, p_i3958_2_);
        field_72197_a = p_i3958_4_;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_2_ == 10 && p_71858_1_ > 1)
        {
            return field_72059_bZ - 1;
        }
        if(p_71858_2_ >= 1 && p_71858_2_ <= 9 && p_71858_1_ == 1)
        {
            return field_72059_bZ - 16 - field_72197_a;
        }
        if(p_71858_2_ >= 1 && p_71858_2_ <= 3 && p_71858_1_ == 2)
        {
            return field_72059_bZ - 16 - field_72197_a;
        }
        if(p_71858_2_ >= 7 && p_71858_2_ <= 9 && p_71858_1_ == 3)
        {
            return field_72059_bZ - 16 - field_72197_a;
        }
        if((p_71858_2_ == 1 || p_71858_2_ == 4 || p_71858_2_ == 7) && p_71858_1_ == 4)
        {
            return field_72059_bZ - 16 - field_72197_a;
        }
        if((p_71858_2_ == 3 || p_71858_2_ == 6 || p_71858_2_ == 9) && p_71858_1_ == 5)
        {
            return field_72059_bZ - 16 - field_72197_a;
        }
        if(p_71858_2_ == 14)
        {
            return field_72059_bZ - 16 - field_72197_a;
        }
        if(p_71858_2_ == 15)
        {
            return field_72059_bZ - 1;
        } else
        {
            return field_72059_bZ;
        }
    }

    public int func_71925_a(Random p_71925_1_)
    {
        int i = p_71925_1_.nextInt(10) - 7;
        if(i < 0)
        {
            i = 0;
        }
        return i;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return Block.field_72109_af.field_71990_ca + field_72197_a;
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Block.field_72109_af.field_71990_ca + field_72197_a;
    }
}
