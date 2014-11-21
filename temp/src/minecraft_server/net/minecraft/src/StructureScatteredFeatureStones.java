// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructurePieceBlockSelector, Block, ComponentScatteredFeaturePieces2

class StructureScatteredFeatureStones extends StructurePieceBlockSelector
{

    private StructureScatteredFeatureStones()
    {
    }

    public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_)
    {
        if(p_75062_1_.nextFloat() < 0.4F)
        {
            field_75066_a = Block.field_71978_w.field_71990_ca;
        } else
        {
            field_75066_a = Block.field_72087_ao.field_71990_ca;
        }
    }

    StructureScatteredFeatureStones(ComponentScatteredFeaturePieces2 p_i3834_1_)
    {
        this();
    }
}
