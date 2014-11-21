// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block

public class WorldGenGlowStone1 extends WorldGenerator
{

    public WorldGenGlowStone1()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if(!p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_))
        {
            return false;
        }
        if(p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Block.field_72012_bb.field_71990_ca)
        {
            return false;
        }
        p_76484_1_.func_72859_e(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_72014_bd.field_71990_ca);
        for(int i = 0; i < 1500; i++)
        {
            int j = (p_76484_3_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            int k = p_76484_4_ - p_76484_2_.nextInt(12);
            int l = (p_76484_5_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            if(p_76484_1_.func_72798_a(j, k, l) != 0)
            {
                continue;
            }
            int i1 = 0;
            for(int j1 = 0; j1 < 6; j1++)
            {
                int k1 = 0;
                if(j1 == 0)
                {
                    k1 = p_76484_1_.func_72798_a(j - 1, k, l);
                }
                if(j1 == 1)
                {
                    k1 = p_76484_1_.func_72798_a(j + 1, k, l);
                }
                if(j1 == 2)
                {
                    k1 = p_76484_1_.func_72798_a(j, k - 1, l);
                }
                if(j1 == 3)
                {
                    k1 = p_76484_1_.func_72798_a(j, k + 1, l);
                }
                if(j1 == 4)
                {
                    k1 = p_76484_1_.func_72798_a(j, k, l - 1);
                }
                if(j1 == 5)
                {
                    k1 = p_76484_1_.func_72798_a(j, k, l + 1);
                }
                if(k1 == Block.field_72014_bd.field_71990_ca)
                {
                    i1++;
                }
            }

            if(i1 == 1)
            {
                p_76484_1_.func_72859_e(j, k, l, Block.field_72014_bd.field_71990_ca);
            }
        }

        return true;
    }
}
