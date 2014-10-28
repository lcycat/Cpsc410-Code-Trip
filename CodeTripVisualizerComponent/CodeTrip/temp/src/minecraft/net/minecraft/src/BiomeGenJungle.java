// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, BiomeDecorator, SpawnListEntry, EntityOcelot, 
//            EntityChicken, WorldGenShrub, WorldGenHugeTrees, WorldGenTrees, 
//            WorldGenTallGrass, Block, BlockTallGrass, WorldGenVines, 
//            WorldGenerator, World

public class BiomeGenJungle extends BiomeGenBase
{

    public BiomeGenJungle(int p_i3759_1_)
    {
        super(p_i3759_1_);
        field_76760_I.field_76832_z = 50;
        field_76760_I.field_76803_B = 25;
        field_76760_I.field_76802_A = 4;
        field_76761_J.add(new SpawnListEntry(net.minecraft.src.EntityOcelot.class, 2, 1, 1));
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntityChicken.class, 10, 4, 4));
    }

    public WorldGenerator func_76740_a(Random p_76740_1_)
    {
        if(p_76740_1_.nextInt(10) == 0)
        {
            return field_76758_O;
        }
        if(p_76740_1_.nextInt(2) == 0)
        {
            return new WorldGenShrub(3, 0);
        }
        if(p_76740_1_.nextInt(3) == 0)
        {
            return new WorldGenHugeTrees(false, 10 + p_76740_1_.nextInt(20), 3, 3);
        } else
        {
            return new WorldGenTrees(false, 4 + p_76740_1_.nextInt(7), 3, 3, true);
        }
    }

    public WorldGenerator func_76730_b(Random p_76730_1_)
    {
        if(p_76730_1_.nextInt(4) == 0)
        {
            return new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2);
        } else
        {
            return new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
        }
    }

    public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        WorldGenVines worldgenvines = new WorldGenVines();
        for(int i = 0; i < 50; i++)
        {
            int j = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
            byte byte0 = 64;
            int k = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
            worldgenvines.func_76484_a(p_76728_1_, p_76728_2_, j, byte0, k);
        }

    }
}
