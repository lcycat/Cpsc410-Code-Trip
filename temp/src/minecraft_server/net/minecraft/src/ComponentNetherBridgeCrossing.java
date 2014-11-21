// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCrossing extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCrossing(int p_i3829_1_, Random p_i3829_2_, StructureBoundingBox p_i3829_3_, int p_i3829_4_)
    {
        super(p_i3829_1_);
        field_74885_f = p_i3829_4_;
        field_74887_e = p_i3829_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 2, 0, false);
        func_74961_b((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
        func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, 2, false);
    }

    public static ComponentNetherBridgeCrossing func_74974_a(List p_74974_0_, Random p_74974_1_, int p_74974_2_, int p_74974_3_, int p_74974_4_, int p_74974_5_, int p_74974_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74974_2_, p_74974_3_, p_74974_4_, -2, 0, 0, 7, 9, 7, p_74974_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74974_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCrossing(p_74974_6_, p_74974_1_, structureboundingbox, p_74974_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 6, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 6, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 6, 1, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 6, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 6, 6, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 6, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 0, 6, 6, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 5, 6, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 6, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 6, 6, 4, 6, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 6, 4, 5, 6, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 2, 0, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 2, 0, 5, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 6, 2, 6, 6, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 2, 6, 5, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        for(int i = 0; i <= 6; i++)
        {
            for(int j = 0; j <= 6; j++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, -1, j, p_74875_3_);
            }

        }

        return true;
    }
}
