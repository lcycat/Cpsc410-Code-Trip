// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            AxisAlignedBB, AABBPool, DamageSource, Entity

public class BlockCactus extends Block
{

    protected BlockCactus(int p_i3925_1_, int p_i3925_2_)
    {
        super(p_i3925_1_, p_i3925_2_, Material.field_76268_x);
        func_71907_b(true);
        func_71849_a(CreativeTabs.field_78031_c);
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(p_71847_1_.func_72799_c(p_71847_2_, p_71847_3_ + 1, p_71847_4_))
        {
            int i;
            for(i = 1; p_71847_1_.func_72798_a(p_71847_2_, p_71847_3_ - i, p_71847_4_) == field_71990_ca; i++) { }
            if(i < 3)
            {
                int j = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
                if(j == 15)
                {
                    p_71847_1_.func_72859_e(p_71847_2_, p_71847_3_ + 1, p_71847_4_, field_71990_ca);
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, 0);
                } else
                {
                    p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, j + 1);
                }
            }
        }
    }

    public AxisAlignedBB func_71872_e(World p_71872_1_, int p_71872_2_, int p_71872_3_, int p_71872_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.func_72332_a().func_72299_a((float)p_71872_2_ + f, p_71872_3_, (float)p_71872_4_ + f, (float)(p_71872_2_ + 1) - f, (float)(p_71872_3_ + 1) - f, (float)(p_71872_4_ + 1) - f);
    }

    public int func_71851_a(int p_71851_1_)
    {
        if(p_71851_1_ == 1)
        {
            return field_72059_bZ - 1;
        }
        if(p_71851_1_ == 0)
        {
            return field_72059_bZ + 1;
        } else
        {
            return field_72059_bZ;
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

    public int func_71857_b()
    {
        return 13;
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
        if(p_71854_1_.func_72803_f(p_71854_2_ - 1, p_71854_3_, p_71854_4_).func_76220_a())
        {
            return false;
        }
        if(p_71854_1_.func_72803_f(p_71854_2_ + 1, p_71854_3_, p_71854_4_).func_76220_a())
        {
            return false;
        }
        if(p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_, p_71854_4_ - 1).func_76220_a())
        {
            return false;
        }
        if(p_71854_1_.func_72803_f(p_71854_2_, p_71854_3_, p_71854_4_ + 1).func_76220_a())
        {
            return false;
        } else
        {
            int i = p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_);
            return i == Block.field_72038_aV.field_71990_ca || i == Block.field_71939_E.field_71990_ca;
        }
    }

    public void func_71869_a(World p_71869_1_, int p_71869_2_, int p_71869_3_, int p_71869_4_, Entity p_71869_5_)
    {
        p_71869_5_.func_70097_a(DamageSource.field_76367_g, 1);
    }
}
