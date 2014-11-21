// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockContainer, Material, CreativeTabs, World, 
//            Block, TileEntityEnchantmentTable, EntityPlayer, TileEntity

public class BlockEnchantmentTable extends BlockContainer
{

    protected BlockEnchantmentTable(int p_i3941_1_)
    {
        super(p_i3941_1_, 166, Material.field_76246_e);
        func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        func_71868_h(0);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public void func_71862_a(World p_71862_1_, int p_71862_2_, int p_71862_3_, int p_71862_4_, Random p_71862_5_)
    {
        super.func_71862_a(p_71862_1_, p_71862_2_, p_71862_3_, p_71862_4_, p_71862_5_);
        for(int i = p_71862_2_ - 2; i <= p_71862_2_ + 2; i++)
        {
            for(int j = p_71862_4_ - 2; j <= p_71862_4_ + 2; j++)
            {
                if(i > p_71862_2_ - 2 && i < p_71862_2_ + 2 && j == p_71862_4_ - 1)
                {
                    j = p_71862_4_ + 2;
                }
                if(p_71862_5_.nextInt(16) != 0)
                {
                    continue;
                }
                for(int k = p_71862_3_; k <= p_71862_3_ + 1; k++)
                {
                    if(p_71862_1_.func_72798_a(i, k, j) != Block.field_72093_an.field_71990_ca)
                    {
                        continue;
                    }
                    if(!p_71862_1_.func_72799_c((i - p_71862_2_) / 2 + p_71862_2_, k, (j - p_71862_4_) / 2 + p_71862_4_))
                    {
                        break;
                    }
                    p_71862_1_.func_72869_a("enchantmenttable", (double)p_71862_2_ + 0.5D, (double)p_71862_3_ + 2D, (double)p_71862_4_ + 0.5D, (double)((float)(i - p_71862_2_) + p_71862_5_.nextFloat()) - 0.5D, (float)(k - p_71862_3_) - p_71862_5_.nextFloat() - 1.0F, (double)((float)(j - p_71862_4_) + p_71862_5_.nextFloat()) - 0.5D);
                }

            }

        }

    }

    public boolean func_71926_d()
    {
        return false;
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        return func_71851_a(p_71858_1_);
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ + 17;
        }
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ;
        } else
        {
            return field_72059_bZ + 16;
        }
    }

    public TileEntity func_72274_a(World p_72274_1_)
    {
        return new TileEntityEnchantmentTable();
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        if(p_71903_1_.field_72995_K)
        {
            return true;
        } else
        {
            p_71903_5_.func_71002_c(p_71903_2_, p_71903_3_, p_71903_4_);
            return true;
        }
    }
}
