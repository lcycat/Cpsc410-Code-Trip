// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeStairs extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeStairs(int p_i3830_1_, Random p_i3830_2_, StructureBoundingBox p_i3830_3_, int p_i3830_4_)
    {
        super(p_i3830_1_);
        field_74885_f = p_i3830_4_;
        field_74887_e = p_i3830_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 6, 2, false);
    }

    public static ComponentNetherBridgeStairs func_74973_a(List p_74973_0_, Random p_74973_1_, int p_74973_2_, int p_74973_3_, int p_74973_4_, int p_74973_5_, int p_74973_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74973_2_, p_74973_3_, p_74973_4_, -2, 0, 0, 7, 11, 7, p_74973_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74973_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeStairs(p_74973_6_, p_74973_1_, structureboundingbox, p_74973_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 6, 1, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 10, 6, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 1, 8, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 0, 6, 8, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 8, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 1, 6, 8, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 6, 5, 8, 6, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 2, 0, 5, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 3, 2, 6, 5, 2, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 3, 4, 6, 5, 4, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 5, 2, 5, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 5, 4, 3, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 2, 5, 3, 4, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 2, 5, 2, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 1, 6, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 7, 1, 5, 7, 4, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 8, 2, 6, 8, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 6, 0, 4, 8, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 5, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
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
