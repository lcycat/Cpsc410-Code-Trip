// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, Direction, 
//            Facing

public class WorldGenVines extends WorldGenerator
{

    public WorldGenVines()
    {
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        int i = p_76484_3_;
        int j = p_76484_5_;
label0:
        for(; p_76484_4_ < 128; p_76484_4_++)
        {
            if(p_76484_1_.func_72799_c(p_76484_3_, p_76484_4_, p_76484_5_))
            {
                int k = 2;
                do
                {
                    if(k > 5)
                    {
                        continue label0;
                    }
                    if(Block.field_71998_bu.func_71850_a_(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, k))
                    {
                        p_76484_1_.func_72961_c(p_76484_3_, p_76484_4_, p_76484_5_, Block.field_71998_bu.field_71990_ca, 1 << Direction.field_71579_d[Facing.field_71588_a[k]]);
                        continue label0;
                    }
                    k++;
                } while(true);
            }
            p_76484_3_ = (i + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
            p_76484_5_ = (j + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
        }

        return true;
    }
}
