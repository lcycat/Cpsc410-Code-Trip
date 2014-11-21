// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, Block, World, Material

public class WorldGenClay extends WorldGenerator
{

    private int field_76518_a;
    private int field_76517_b;

    public WorldGenClay(int p_i3787_1_)
    {
        field_76518_a = Block.field_72041_aW.field_71990_ca;
        field_76517_b = p_i3787_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if(p_76484_1_.func_72803_f(p_76484_3_, p_76484_4_, p_76484_5_) != Material.field_76244_g)
        {
            return false;
        }
        int i = p_76484_2_.nextInt(field_76517_b - 2) + 2;
        int j = 1;
        for(int k = p_76484_3_ - i; k <= p_76484_3_ + i; k++)
        {
            for(int l = p_76484_5_ - i; l <= p_76484_5_ + i; l++)
            {
                int i1 = k - p_76484_3_;
                int j1 = l - p_76484_5_;
                if(i1 * i1 + j1 * j1 > i * i)
                {
                    continue;
                }
                for(int k1 = p_76484_4_ - j; k1 <= p_76484_4_ + j; k1++)
                {
                    int l1 = p_76484_1_.func_72798_a(k, k1, l);
                    if(l1 == Block.field_71979_v.field_71990_ca || l1 == Block.field_72041_aW.field_71990_ca)
                    {
                        p_76484_1_.func_72822_b(k, k1, l, field_76518_a);
                    }
                }

            }

        }

        return true;
    }
}
