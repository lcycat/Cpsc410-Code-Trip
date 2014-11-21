// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Material, Block, 
//            BlockGrass

public class WorldGenSand extends WorldGenerator
{

    private int field_76540_a;
    private int field_76539_b;

    public WorldGenSand(int p_i3797_1_, int p_i3797_2_)
    {
        field_76540_a = p_i3797_2_;
        field_76539_b = p_i3797_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        if(p_76484_1_.func_72803_f(p_76484_3_, p_76484_4_, p_76484_5_) != Material.field_76244_g)
        {
            return false;
        }
        int i = p_76484_2_.nextInt(field_76539_b - 2) + 2;
        byte byte0 = 2;
        for(int j = p_76484_3_ - i; j <= p_76484_3_ + i; j++)
        {
            for(int k = p_76484_5_ - i; k <= p_76484_5_ + i; k++)
            {
                int l = j - p_76484_3_;
                int i1 = k - p_76484_5_;
                if(l * l + i1 * i1 > i * i)
                {
                    continue;
                }
                for(int j1 = p_76484_4_ - byte0; j1 <= p_76484_4_ + byte0; j1++)
                {
                    int k1 = p_76484_1_.func_72798_a(j, j1, k);
                    if(k1 == Block.field_71979_v.field_71990_ca || k1 == Block.field_71980_u.field_71990_ca)
                    {
                        p_76484_1_.func_72822_b(j, j1, k, field_76540_a);
                    }
                }

            }

        }

        return true;
    }
}
