// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, CreativeTabs, World, 
//            EntityFallingSand, BlockFire

public class BlockSand extends Block
{

    public static boolean field_72192_a = false;

    public BlockSand(int p_i3991_1_, int p_i3991_2_)
    {
        super(p_i3991_1_, p_i3991_2_, Material.field_76251_o);
        func_71849_a(CreativeTabs.field_78030_b);
    }

    public void func_71861_g(World p_71861_1_, int p_71861_2_, int p_71861_3_, int p_71861_4_)
    {
        p_71861_1_.func_72836_a(p_71861_2_, p_71861_3_, p_71861_4_, field_71990_ca, func_71859_p_());
    }

    public void func_71863_a(World p_71863_1_, int p_71863_2_, int p_71863_3_, int p_71863_4_, int p_71863_5_)
    {
        p_71863_1_.func_72836_a(p_71863_2_, p_71863_3_, p_71863_4_, field_71990_ca, func_71859_p_());
    }

    public void func_71847_b(World p_71847_1_, int p_71847_2_, int p_71847_3_, int p_71847_4_, Random p_71847_5_)
    {
        if(!p_71847_1_.field_72995_K)
        {
            func_72190_l(p_71847_1_, p_71847_2_, p_71847_3_, p_71847_4_);
        }
    }

    private void func_72190_l(World p_72190_1_, int p_72190_2_, int p_72190_3_, int p_72190_4_)
    {
        int i = p_72190_2_;
        int j = p_72190_3_;
        int k = p_72190_4_;
        if(func_72191_e_(p_72190_1_, i, j - 1, k) && j >= 0)
        {
            byte byte0 = 32;
            if(field_72192_a || !p_72190_1_.func_72904_c(p_72190_2_ - byte0, p_72190_3_ - byte0, p_72190_4_ - byte0, p_72190_2_ + byte0, p_72190_3_ + byte0, p_72190_4_ + byte0))
            {
                p_72190_1_.func_72859_e(p_72190_2_, p_72190_3_, p_72190_4_, 0);
                for(; func_72191_e_(p_72190_1_, p_72190_2_, p_72190_3_ - 1, p_72190_4_) && p_72190_3_ > 0; p_72190_3_--) { }
                if(p_72190_3_ > 0)
                {
                    p_72190_1_.func_72859_e(p_72190_2_, p_72190_3_, p_72190_4_, field_71990_ca);
                }
            } else
            if(!p_72190_1_.field_72995_K)
            {
                EntityFallingSand entityfallingsand = new EntityFallingSand(p_72190_1_, (float)p_72190_2_ + 0.5F, (float)p_72190_3_ + 0.5F, (float)p_72190_4_ + 0.5F, field_71990_ca);
                p_72190_1_.func_72838_d(entityfallingsand);
            }
        }
    }

    public int func_71859_p_()
    {
        return 3;
    }

    public static boolean func_72191_e_(World p_72191_0_, int p_72191_1_, int p_72191_2_, int p_72191_3_)
    {
        int i = p_72191_0_.func_72798_a(p_72191_1_, p_72191_2_, p_72191_3_);
        if(i == 0)
        {
            return true;
        }
        if(i == Block.field_72067_ar.field_71990_ca)
        {
            return true;
        }
        Material material = Block.field_71973_m[i].field_72018_cp;
        if(material == Material.field_76244_g)
        {
            return true;
        }
        return material == Material.field_76256_h;
    }

}
