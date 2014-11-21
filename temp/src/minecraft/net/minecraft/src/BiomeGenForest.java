// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BiomeGenBase, SpawnListEntry, EntityWolf, BiomeDecorator, 
//            WorldGenerator

public class BiomeGenForest extends BiomeGenBase
{

    public BiomeGenForest(int p_i3756_1_)
    {
        super(p_i3756_1_);
        field_76762_K.add(new SpawnListEntry(net.minecraft.src.EntityWolf.class, 5, 4, 4));
        field_76760_I.field_76832_z = 10;
        field_76760_I.field_76803_B = 2;
    }

    public WorldGenerator func_76740_a(Random p_76740_1_)
    {
        if(p_76740_1_.nextInt(5) == 0)
        {
            return field_76764_P;
        }
        if(p_76740_1_.nextInt(10) == 0)
        {
            return field_76758_O;
        } else
        {
            return field_76757_N;
        }
    }
}
