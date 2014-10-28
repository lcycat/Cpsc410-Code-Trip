// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCorridor extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCorridor(int p_i3821_1_, Random p_i3821_2_, StructureBoundingBox p_i3821_3_, int p_i3821_4_)
    {
        super(p_i3821_1_);
        field_74885_f = p_i3821_4_;
        field_74887_e = p_i3821_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74961_b((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, 1, true);
    }

    public static ComponentNetherBridgeCorridor func_74978_a(List p_74978_0_, Random p_74978_1_, int p_74978_2_, int p_74978_3_, int p_74978_4_, int p_74978_5_, int p_74978_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74978_2_, p_74978_3_, p_74978_4_, -1, 0, 0, 5, 7, 5, p_74978_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74978_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCorridor(p_74978_6_, p_74978_1_, structureboundingbox, p_74978_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 1, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 4, 5, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 4, 5, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 1, 4, 4, 1, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 3, 3, 4, 4, 3, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 5, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 3, 5, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 4, 1, 4, 4, Block.field_72098_bB.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 3, 4, 3, 4, 4, Block.field_72098_bB.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 0, 4, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        for(int i = 0; i <= 4; i++)
        {
            for(int j = 0; j <= 4; j++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, -1, j, p_74875_3_);
            }

        }

        return true;
    }
}
