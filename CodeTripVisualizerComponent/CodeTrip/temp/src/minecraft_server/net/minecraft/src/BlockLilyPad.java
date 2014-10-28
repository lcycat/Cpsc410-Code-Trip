// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, CreativeTabs, EntityBoat, AxisAlignedBB, 
//            AABBPool, Block, World, Material, 
//            Entity

public class BlockLilyPad extends BlockFlower
{

    protected BlockLilyPad(int p_i4020_1_, int p_i4020_2_)
    {
        super(p_i4020_1_, p_i4020_2_);
        float f = 0.5F;
        float f1 = 0.015625F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public int func_71857_b()
    {
        return 23;
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        if(p_71871_7_ == null || !(p_71871_7_ instanceof EntityBoat))
        {
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        return AxisAlignedBB.func_72332_a().func_72299_a((double)p_71872_2_ + field_72026_ch, (double)p_71872_3_ + field_72023_ci, (double)p_71872_4_ + field_72024_cj, (double)p_71872_2_ + field_72021_ck, (double)p_71872_3_ + field_72022_cl, (double)p_71872_4_ + field_72019_cm);
    }

    protected boolean func_72263_d_(int p_72263_1_)
    {
        return p_72263_1_ == Block.field_71943_B.field_71990_ca;
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        if(p_71854_3_ < 0 || p_71854_3_ >= 256)
        {
            return false;
        } else
        {
            return p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_ - 1, p_71854_4_) == Material.field_76244_g && p_71854_1_.func_72805_g(p_71854_2_, p_71854_3_ - 1, p_71854_4_) == 0;
        }
    }
}
