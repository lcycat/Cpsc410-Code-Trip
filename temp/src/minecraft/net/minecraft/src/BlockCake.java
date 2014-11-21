// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, World, 
//            AxisAlignedBB, AABBPool, EntityPlayer, FoodStats, 
//            Item

public class BlockCake extends Block
{

    protected BlockCake(int p_i3926_1_, int p_i3926_2_)
    {
        super(p_i3926_1_, p_i3926_2_, Material.field_76238_C);
        func_71907_b(true);
    }

    public void func_71902_a(IBlockAccess p_71902_1_, int p_71902_2_, int p_71902_3_, int p_71902_4_)
    {
        int i = p_71902_1_.func_72805_g(p_71902_2_, p_71902_3_, p_71902_4_);
        float f = 0.0625F;
        float f1 = (float)(1 + i * 2) / 16F;
        float f2 = 0.5F;
        func_71905_a(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }

    public void func_71919_f()
    {
        float f = 0.0625F;
        float f1 = 0.5F;
        func_71905_a(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        int i = p_71872_1_.func_72805_g(p_71872_2_, p_71872_3_, p_71872_4_);
        float f = 0.0625F;
        float f1 = (float)(1 + i * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.func_72332_a().func_72299_a((float)p_71872_2_ + f1, p_71872_3_, (float)p_71872_4_ + f, (float)(p_71872_2_ + 1) - f, ((float)p_71872_3_ + f2) - f, (float)(p_71872_4_ + 1) - f);
    }

    public AxisAlignedBB func_71911_a_(World p_71911_1_, int p_71911_2_, int p_71911_3_, int p_71911_4_)
    {
        int i = p_71911_1_.func_72805_g(p_71911_2_, p_71911_3_, p_71911_4_);
        float f = 0.0625F;
        float f1 = (float)(1 + i * 2) / 16F;
        float f2 = 0.5F;
        return AxisAlignedBB.func_72332_a().func_72299_a((float)p_71911_2_ + f1, p_71911_3_, (float)p_71911_4_ + f, (float)(p_71911_2_ + 1) - f, (float)p_71911_3_ + f2, (float)(p_71911_4_ + 1) - f);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_1_ == 1)
        {
            return field_72059_bZ;
        }
        if(p_71858_1_ == 0)
        {
            return field_72059_bZ + 3;
        }
        if(p_71858_2_ > 0 && p_71858_1_ == 4)
        {
            return field_72059_bZ + 2;
        } else
        {
            return field_72059_bZ + 1;
        }
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ;
        }
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ + 3;
        } else
        {
            return field_72059_bZ + 1;
        }
    }

    public boolean func_71886_c()
    {
        return false;
    }

    public boolean func_71926_d()
    {
        return false;
    }

    public boolean func_71903_a(World p_71903_1_, int p_71903_2_, int p_71903_3_, int p_71903_4_, EntityPlayer p_71903_5_, int p_71903_6_, float p_71903_7_, 
            float p_71903_8_, float p_71903_9_)
    {
        func_72259_b(p_71903_1_, p_71903_2_, p_71903_3_, p_71903_4_, p_71903_5_);
        return true;
    }

    public void func_71921_a(World p_71921_1_, int p_71921_2_, int p_71921_3_, int p_71921_4_, EntityPlayer p_71921_5_)
    {
        func_72259_b(p_71921_1_, p_71921_2_, p_71921_3_, p_71921_4_, p_71921_5_);
    }

    private void func_72259_b(World p_72259_1_, int p_72259_2_, int p_72259_3_, int p_72259_4_, EntityPlayer p_72259_5_)
    {
        if(p_72259_5_.func_71043_e(false))
        {
            p_72259_5_.func_71024_bL().func_75122_a(2, 0.1F);
            int i = p_72259_1_.func_72805_g(p_72259_2_, p_72259_3_, p_72259_4_) + 1;
            if(i >= 6)
            {
                p_72259_1_.func_72859_e(p_72259_2_, p_72259_3_, p_72259_4_, 0);
            } else
            {
                p_72259_1_.func_72921_c(p_72259_2_, p_72259_3_, p_72259_4_, i);
                p_72259_1_.func_72862_i(p_72259_2_, p_72259_3_, p_72259_4_);
            }
        }
    }

    public boolean func_71930_b(World p_71930_1_, int p_71930_2_, int p_71930_3_, int p_71930_4_)
    {
        if(!super.func_71930_b(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_))
        {
            return false;
        } else
        {
            return func_71854_d(p_71930_1_, p_71930_2_, p_71930_3_, p_71930_4_);
        }
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        if(!func_71854_d(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_))
        {
            func_71897_c(p_71863_1_, p_71863_2_, p_71863_3_, p_71863_4_, p_71863_1_.func_72805_g(p_71863_2_, p_71863_3_, p_71863_4_), 0);
            p_71863_1_.func_72859_e(p_71863_2_, p_71863_3_, p_71863_4_, 0);
        }
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        return p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_ - 1, p_71854_4_).func_76220_a();
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return 0;
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_77746_aZ.field_77779_bT;
    }
}
