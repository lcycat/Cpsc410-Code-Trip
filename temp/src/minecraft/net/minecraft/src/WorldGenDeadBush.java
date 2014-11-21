// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves

public class WorldGenDeadBush extends WorldGenerator
{

    private int field_76516_a;

    public WorldGenDeadBush(int p_i3788_1_)
    {
        field_76516_a = p_i3788_1_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for(int i = 0; ((i = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || i == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 0; p_76484_4_--) { }
        for(int j = 0; j < 4; j++)
        {
            int k = (p_76484_3_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            int l = (p_76484_4_ + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
            int i1 = (p_76484_5_ + p_76484_2_.nextInt(8)) - p_76484_2_.nextInt(8);
            if(p_76484_1_.func_72799_c(k, l, i1) && Block.field_71973_m[field_76516_a].func_71854_d(p_76484_1_, k, l, i1))
            {
                p_76484_1_.func_72822_b(k, l, i1, field_76516_a);
            }
        }

        return true;
    }
}
