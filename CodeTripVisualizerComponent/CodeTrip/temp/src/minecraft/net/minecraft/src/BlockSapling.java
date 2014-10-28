// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, CreativeTabs, World, WorldGenTaiga2, 
//            WorldGenForest, WorldGenHugeTrees, WorldGenTrees, WorldGenBigTree, 
//            WorldGenerator, ItemStack

public class BlockSapling extends BlockFlower
{

    public static final String field_72270_a[] = {
        "oak", "spruce", "birch", "jungle"
    };

    protected BlockSapling(int p_i3992_1_, int p_i3992_2_)
    {
        super(p_i3992_1_, p_i3992_2_);
        float f = 0.4F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.field_72995_K)
        {
            return;
        }
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
        if(p_71847_1_.func_72957_l(p_71847_2_, p_71847_3_ + 1, p_71847_4_) >= 9 && p_71847_5_.nextInt(7) == 0)
        {
            int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
            if((i & 8) == 0)
            {
                p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, i | 8);
            } else
            {
                func_72269_c(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
            }
        }
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        p_71858_2_ &= 3;
        if(p_71858_2_ == 1)
        {
            return 63;
        }
        if(p_71858_2_ == 2)
        {
            return 79;
        }
        if(p_71858_2_ == 3)
        {
            return 30;
        } else
        {
            return super.func_71858_a(p_71858_1_, p_71858_2_);
        }
    }

    public void func_72269_c(World p_72269_1_, int p_72269_2_, int p_72269_3_, int p_72269_4_, Random p_72269_5_)
    {
        int i = p_72269_1_.func_72805_g(p_72269_2_, p_72269_3_, p_72269_4_) & 3;
        Object obj = null;
        int j = 0;
        int k = 0;
        boolean flag = false;
        if(i == 1)
        {
            obj = new WorldGenTaiga2(true);
        } else
        if(i == 2)
        {
            obj = new WorldGenForest(true);
        } else
        if(i == 3)
        {
            j = 0;
            do
            {
                if(j < -1)
                {
                    break;
                }
                k = 0;
                do
                {
                    if(k < -1)
                    {
                        break;
                    }
                    if(func_72268_e(p_72269_1_, p_72269_2_ + j, p_72269_3_, p_72269_4_ + k, 3) && func_72268_e(p_72269_1_, p_72269_2_ + j + 1, p_72269_3_, p_72269_4_ + k, 3) && func_72268_e(p_72269_1_, p_72269_2_ + j, p_72269_3_, p_72269_4_ + k + 1, 3) && func_72268_e(p_72269_1_, p_72269_2_ + j + 1, p_72269_3_, p_72269_4_ + k + 1, 3))
                    {
                        obj = new WorldGenHugeTrees(true, 10 + p_72269_5_.nextInt(20), 3, 3);
                        flag = true;
                        break;
                    }
                    k--;
                } while(true);
                if(obj != null)
                {
                    break;
                }
                j--;
            } while(true);
            if(obj == null)
            {
                j = k = 0;
                obj = new WorldGenTrees(true, 4 + p_72269_5_.nextInt(7), 3, 3, false);
            }
        } else
        {
            obj = new WorldGenTrees(true);
            if(p_72269_5_.nextInt(10) == 0)
            {
                obj = new WorldGenBigTree(true);
            }
        }
        if(flag)
        {
            p_72269_1_.func_72822_b(p_72269_2_ + j, p_72269_3_, p_72269_4_ + k, 0);
            p_72269_1_.func_72822_b(p_72269_2_ + j + 1, p_72269_3_, p_72269_4_ + k, 0);
            p_72269_1_.func_72822_b(p_72269_2_ + j, p_72269_3_, p_72269_4_ + k + 1, 0);
            p_72269_1_.func_72822_b(p_72269_2_ + j + 1, p_72269_3_, p_72269_4_ + k + 1, 0);
        } else
        {
            p_72269_1_.func_72822_b(p_72269_2_, p_72269_3_, p_72269_4_, 0);
        }
        if(!((WorldGenerator) (obj)).func_76484_a(p_72269_1_, p_72269_5_, p_72269_2_ + j, p_72269_3_, p_72269_4_ + k))
        {
            if(flag)
            {
                p_72269_1_.func_72961_c(p_72269_2_ + j, p_72269_3_, p_72269_4_ + k, field_71990_ca, i);
                p_72269_1_.func_72961_c(p_72269_2_ + j + 1, p_72269_3_, p_72269_4_ + k, field_71990_ca, i);
                p_72269_1_.func_72961_c(p_72269_2_ + j, p_72269_3_, p_72269_4_ + k + 1, field_71990_ca, i);
                p_72269_1_.func_72961_c(p_72269_2_ + j + 1, p_72269_3_, p_72269_4_ + k + 1, field_71990_ca, i);
            } else
            {
                p_72269_1_.func_72961_c(p_72269_2_, p_72269_3_, p_72269_4_, field_71990_ca, i);
            }
        }
    }

    public boolean func_72268_e(World p_72268_1_, int p_72268_2_, int p_72268_3_, int p_72268_4_, int p_72268_5_)
    {
        return p_72268_1_.func_72798_a(p_72268_2_, p_72268_3_, p_72268_4_) == field_71990_ca && (p_72268_1_.func_72805_g(p_72268_2_, p_72268_3_, p_72268_4_) & 3) == p_72268_5_;
    }

    protected int func_71899_b(int p_71899_1_)
    {
        return p_71899_1_ & 3;
    }

    public void func_71879_a(int p_71879_1_, CreativeTabs p_71879_2_, List p_71879_3_)
    {
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 0));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 1));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 2));
        p_71879_3_.add(new ItemStack(p_71879_1_, 1, 3));
    }

}
