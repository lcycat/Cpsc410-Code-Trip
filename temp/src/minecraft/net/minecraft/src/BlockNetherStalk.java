// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, Block, World, ItemStack, 
//            Item

public class BlockNetherStalk extends BlockFlower
{

    protected BlockNetherStalk(int p_i3974_1_)
    {
        super(p_i3974_1_, 226);
        func_71907_b(true);
        float f = 0.5F;
        func_71905_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        func_71849_a(null);
    }

    protected boolean func_72263_d_(int p_72263_1_)
    {
        return p_72263_1_ == Block.field_72013_bc.field_71990_ca;
    }

    public boolean func_71854_d(World p_71854_1_, int p_71854_2_, int p_71854_3_, int p_71854_4_)
    {
        return func_72263_d_(p_71854_1_.func_72798_a(p_71854_2_, p_71854_3_ - 1, p_71854_4_));
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        int i = p_71847_1_.func_72805_g(p_71847_2_, p_71847_3_, p_71847_4_);
        if(i < 3 && p_71847_5_.nextInt(10) == 0)
        {
            i++;
            p_71847_1_.func_72921_c(p_71847_2_, p_71847_3_, p_71847_4_, i);
        }
        super.func_71847_b(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_, p_71847_5_);
    }

    public int func_71858_a(int p_71858_1_, int p_71858_2_)
    {
        if(p_71858_2_ >= 3)
        {
            return field_72059_bZ + 2;
        }
        if(p_71858_2_ > 0)
        {
            return field_72059_bZ + 1;
        } else
        {
            return field_72059_bZ;
        }
    }

    public int func_71857_b()
    {
        return 6;
    }

    public void func_71914_a(World p_71914_1_, int p_71914_2_, int p_71914_3_, int p_71914_4_, int p_71914_5_, float p_71914_6_, int p_71914_7_)
    {
        if(p_71914_1_.field_72995_K)
        {
            return;
        }
        int i = 1;
        if(p_71914_5_ >= 3)
        {
            i = 2 + p_71914_1_.field_73012_v.nextInt(3);
            if(p_71914_7_ > 0)
            {
                i += p_71914_1_.field_73012_v.nextInt(p_71914_7_ + 1);
            }
        }
        for(int j = 0; j < i; j++)
        {
            func_71929_a(p_71914_1_, p_71914_2_, p_71914_3_, p_71914_4_, new ItemStack(Item.field_77727_br));
        }

    }

    public int func_71885_a(int p_71885_1_, Random p_71885_2_, int p_71885_3_)
    {
        return 0;
    }

    public int func_71925_a(Random p_71925_1_)
    {
        return 0;
    }

    public int func_71922_a(World p_71922_1_, int p_71922_2_, int p_71922_3_, int p_71922_4_)
    {
        return Item.field_77727_br.field_77779_bT;
    }
}
