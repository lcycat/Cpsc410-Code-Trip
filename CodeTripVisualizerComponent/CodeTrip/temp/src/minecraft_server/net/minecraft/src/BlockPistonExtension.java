// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, Facing, World, 
//            BlockPistonBase, IBlockAccess, AxisAlignedBB, Entity

public class BlockPistonExtension extends Block
{

    private int field_72123_a;

    public BlockPistonExtension(int p_i4026_1_, int p_i4026_2_)
    {
        super(p_i4026_1_, p_i4026_2_, Material.field_76233_E);
        field_72123_a = -1;
        func_71884_a(field_71976_h);
        func_71848_c(0.5F);
    }

    public void func_71852_a(World p_71852_1_, int p_71852_2_, int p_71852_3_, int p_71852_4_, int p_71852_5_, int p_71852_6_)
    {
        super.func_71852_a(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_5_, p_71852_6_);
        int i = Facing.field_71588_a[func_72121_f(p_71852_6_)];
        p_71852_2_ += Facing.field_71586_b[i];
        p_71852_3_ += Facing.field_71587_c[i];
        p_71852_4_ += Facing.field_71585_d[i];
        int j = p_71852_1_.func_72798_a(p_71852_2_, p_71852_3_, p_71852_4_);
        if(j == Block.field_71963_Z.field_71990_ca || j == Block.field_71956_V.field_71990_ca)
        {
            p_71852_6_ = p_71852_1_.func_72805_g(p_71852_2_, p_71852_3_, p_71852_4_);
            if(BlockPistonBase.func_72114_f(p_71852_6_))
            {
                Block.field_71973_m[j].func_71897_c(p_71852_1_, p_71852_2_, p_71852_3_, p_71852_4_, p_71852_6_, 0);
                p_71852_1_.func_72859_e(p_71852_2_, p_71852_3_, p_71852_4_, 0);
            }
        }
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        int i = func_72121_f(p_71858_2_);
        if(p_71858_1_ == i)
        {
            if(field_72123_a >= 0)
            {
                return field_72123_a;
            }
            if((p_71858_2_ & 8) != 0)
            {
                return field_72059_bZ - 1;
            } else
            {
                return field_72059_bZ;
            }
        }
        return i >= 6 || p_71858_1_ != Facing.field_71588_a[i] ? 108 : 107;
    }

    public int func_71857_b()
    {
        return 17;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int i)
    {
        return false;
    }

    public boolean func_71850_a_(World p_71850_1_, int p_71850_2_, int p_71850_3_, int i, int j)
    {
        return false;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public void func_71871_a(World p_71871_1_, int p_71871_2_, int p_71871_3_, int p_71871_4_, AxisAlignedBB p_71871_5_, List p_71871_6_, Entity p_71871_7_)
    {
        int i = p_71871_1_.func_72805_g(p_71871_2_, p_71871_3_, p_71871_4_);
        switch(func_72121_f(i))
        {
        case 0: // '\0'
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            func_71905_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            break;

        case 1: // '\001'
            func_71905_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            func_71905_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            break;

        case 2: // '\002'
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            func_71905_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            break;

        case 3: // '\003'
            func_71905_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            func_71905_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            break;

        case 4: // '\004'
            func_71905_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            func_71905_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            break;

        case 5: // '\005'
            func_71905_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            func_71905_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.func_71871_a(p_71871_1_, p_71871_2_, p_71871_3_, p_71871_4_, p_71871_5_, p_71871_6_, p_71871_7_);
            break;
        }
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        switch(func_72121_f(i))
        {
        case 0: // '\0'
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;

        case 1: // '\001'
            func_71905_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;

        case 2: // '\002'
            func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;

        case 3: // '\003'
            func_71905_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;

        case 4: // '\004'
            func_71905_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;

        case 5: // '\005'
            func_71905_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        int i = func_72121_f(p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_));
        int j = p_71863_1_.func_72798_a(p_71863_2_ - Facing.field_71586_b[i], p_71863_3_ - Facing.field_71587_c[i], p_71863_4_ - Facing.field_71585_d[i]);
        if(j != Block.field_71963_Z.field_71990_ca && j != Block.field_71956_V.field_71990_ca)
        {
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        } else
        {
            Block.field_71973_m[j].func_71863_a(p_71863_1_, p_71863_2_ - Facing.field_71586_b[i], p_71863_3_ - Facing.field_71587_c[i], p_71863_4_ - Facing.field_71585_d[i], p_71863_5_);
        }
    }

    public static int func_72121_f(int p_72121_0_)
    {
        return p_72121_0_ & 7;
    }
}
