// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCorridor3 extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCorridor3(int p_i3817_1_, Random p_i3817_2_, StructureBoundingBox p_i3817_3_, int p_i3817_4_)
    {
        super(p_i3817_1_);
        field_74885_f = p_i3817_4_;
        field_74887_e = p_i3817_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 1, 0, true);
    }

    public static ComponentNetherBridgeCorridor3 func_74982_a(List p_74982_0_, Random p_74982_1_, int p_74982_2_, int p_74982_3_, int p_74982_4_, int p_74982_5_, int p_74982_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74982_2_, p_74982_3_, p_74982_4_, -1, -7, 0, 5, 14, 10, p_74982_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74982_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCorridor3(p_74982_6_, p_74982_1_, structureboundingbox, p_74982_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        int i = func_74863_c(Block.field_72100_bC.field_71990_ca, 2);
        for(int j = 0; j <= 9; j++)
        {
            int k = Math.max(1, 7 - j);
            int l = Math.min(Math.max(k + 5, 14 - j), 13);
            int i1 = j;
            func_74884_a(p_74875_1_, p_74875_3_, 0, 0, i1, 4, k, i1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 1, k + 1, i1, 3, l - 1, i1, 0, 0, false);
            if(j <= 6)
            {
                func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, 1, k + 1, i1, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, 2, k + 1, i1, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, i, 3, k + 1, i1, p_74875_3_);
            }
            func_74884_a(p_74875_1_, p_74875_3_, 0, l, i1, 4, l, i1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 0, k + 1, i1, 0, l - 1, i1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 4, k + 1, i1, 4, l - 1, i1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            if((j & 1) == 0)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 0, k + 2, i1, 0, k + 3, i1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
                func_74884_a(p_74875_1_, p_74875_3_, 4, k + 2, i1, 4, k + 3, i1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            }
            for(int j1 = 0; j1 <= 4; j1++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, j1, -1, i1, p_74875_3_);
            }

        }

        return true;
    }
}
