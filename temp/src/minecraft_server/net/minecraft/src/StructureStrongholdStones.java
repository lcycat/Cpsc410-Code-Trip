// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructurePieceBlockSelector, Block, StructureStrongholdPieceWeight2

class StructureStrongholdStones extends StructurePieceBlockSelector
{

    private StructureStrongholdStones()
    {
    }

    public void func_75062_a(Random p_75062_1_, int p_75062_2_, int p_75062_3_, int p_75062_4_, boolean p_75062_5_)
    {
        if(p_75062_5_)
        {
            field_75066_a = Block.field_72007_bm.field_71990_ca;
            float f = p_75062_1_.nextFloat();
            if(f < 0.2F)
            {
                field_75065_b = 2;
            } else
            if(f < 0.5F)
            {
                field_75065_b = 1;
            } else
            if(f < 0.55F)
            {
                field_75066_a = Block.field_72006_bl.field_71990_ca;
                field_75065_b = 2;
            } else
            {
                field_75065_b = 0;
            }
        } else
        {
            field_75066_a = 0;
            field_75065_b = 0;
        }
    }

    StructureStrongholdStones(StructureStrongholdPieceWeight2 p_i3849_1_)
    {
        this();
    }
}
