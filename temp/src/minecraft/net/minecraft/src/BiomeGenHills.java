// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, World, Block

public class BiomeGenHills extends BiomeGenBase
{

    protected BiomeGenHills(int p_i3754_1_)
    {
        super(p_i3754_1_);
    }

    public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        int i = 3 + p_76728_2_.nextInt(6);
        for(int j = 0; j < i; j++)
        {
            int k = p_76728_3_ + p_76728_2_.nextInt(16);
            int l = p_76728_2_.nextInt(28) + 4;
            int i1 = p_76728_4_ + p_76728_2_.nextInt(16);
            int j1 = p_76728_1_.func_72798_a(k, l, i1);
            if(j1 == Block.field_71981_t.field_71990_ca)
            {
                p_76728_1_.func_72822_b(k, l, i1, Block.field_72068_bR.field_71990_ca);
            }
        }

    }
}
