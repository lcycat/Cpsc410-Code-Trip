// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Block, BlockLeaves, 
//            TileEntityChest, WeightedRandomChestContent

public class WorldGeneratorBonusChest extends WorldGenerator
{

    private final WeightedRandomChestContent field_76546_a[];
    private final int field_76545_b;

    public WorldGeneratorBonusChest(WeightedRandomChestContent p_i3786_1_[], int p_i3786_2_)
    {
        field_76546_a = p_i3786_1_;
        field_76545_b = p_i3786_2_;
    }

    public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
        for(int i = 0; ((i = p_76484_1_.func_72798_a(p_76484_3_, p_76484_4_, p_76484_5_)) == 0 || i == Block.field_71952_K.field_71990_ca) && p_76484_4_ > 1; p_76484_4_--) { }
        if(p_76484_4_ < 1)
        {
            return false;
        }
        p_76484_4_++;
        for(int j = 0; j < 4; j++)
        {
            int k = (p_76484_3_ + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
            int l = (p_76484_4_ + p_76484_2_.nextInt(3)) - p_76484_2_.nextInt(3);
            int i1 = (p_76484_5_ + p_76484_2_.nextInt(4)) - p_76484_2_.nextInt(4);
            if(p_76484_1_.func_72799_c(k, l, i1) && p_76484_1_.func_72797_t(k, l - 1, i1))
            {
                p_76484_1_.func_72859_e(k, l, i1, Block.field_72077_au.field_71990_ca);
                TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.func_72796_p(k, l, i1);
                if(tileentitychest != null && tileentitychest != null)
                {
                    WeightedRandomChestContent.func_76293_a(p_76484_2_, field_76546_a, tileentitychest, field_76545_b);
                }
                if(p_76484_1_.func_72799_c(k - 1, l, i1) && p_76484_1_.func_72797_t(k - 1, l - 1, i1))
                {
                    p_76484_1_.func_72859_e(k - 1, l, i1, Block.field_72069_aq.field_71990_ca);
                }
                if(p_76484_1_.func_72799_c(k + 1, l, i1) && p_76484_1_.func_72797_t(k - 1, l - 1, i1))
                {
                    p_76484_1_.func_72859_e(k + 1, l, i1, Block.field_72069_aq.field_71990_ca);
                }
                if(p_76484_1_.func_72799_c(k, l, i1 - 1) && p_76484_1_.func_72797_t(k - 1, l - 1, i1))
                {
                    p_76484_1_.func_72859_e(k, l, i1 - 1, Block.field_72069_aq.field_71990_ca);
                }
                if(p_76484_1_.func_72799_c(k, l, i1 + 1) && p_76484_1_.func_72797_t(k - 1, l - 1, i1))
                {
                    p_76484_1_.func_72859_e(k, l, i1 + 1, Block.field_72069_aq.field_71990_ca);
                }
                return true;
            }
        }

        return false;
    }
}
