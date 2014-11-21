// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, Block, BiomeDecorator, WorldGenDesertWells, 
//            World, WorldGenerator

public class BiomeGenDesert extends BiomeGenBase
{

    public BiomeGenDesert(int p_i3753_1_)
    {
        super(p_i3753_1_);
        field_76762_K.clear();
        field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
        field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
        field_76760_I.field_76832_z = -999;
        field_76760_I.field_76804_C = 2;
        field_76760_I.field_76799_E = 50;
        field_76760_I.field_76800_F = 10;
    }

    public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        if(p_76728_2_.nextInt(1000) == 0)
        {
            int i = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
            int j = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
            WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
            worldgendesertwells.func_76484_a(p_76728_1_, p_76728_2_, i, p_76728_1_.func_72976_f(i, j) + 1, j);
        }
    }
}
