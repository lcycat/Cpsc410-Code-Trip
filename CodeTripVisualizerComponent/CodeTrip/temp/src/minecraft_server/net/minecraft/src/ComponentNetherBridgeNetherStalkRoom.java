// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeNetherStalkRoom extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeNetherStalkRoom(int p_i3824_1_, Random p_i3824_2_, StructureBoundingBox p_i3824_3_, int p_i3824_4_)
    {
        super(p_i3824_1_);
        field_74885_f = p_i3824_4_;
        field_74887_e = p_i3824_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
        func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 5, 11, true);
    }

    public static ComponentNetherBridgeNetherStalkRoom func_74977_a(List p_74977_0_, Random p_74977_1_, int p_74977_2_, int p_74977_3_, int p_74977_4_, int p_74977_5_, int p_74977_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74977_2_, p_74977_3_, p_74977_4_, -5, -3, 0, 13, 14, 13, p_74977_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74977_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeNetherStalkRoom(p_74977_6_, p_74977_1_, structureboundingbox, p_74977_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 0, 12, 4, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 12, 13, 12, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 1, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 11, 5, 0, 12, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 11, 4, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 11, 10, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 9, 11, 7, 12, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 0, 4, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 0, 10, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 9, 0, 7, 12, 1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 11, 2, 10, 12, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        for(int i = 1; i <= 11; i += 2)
        {
            func_74884_a(p_74875_1_, p_74875_3_, i, 10, 0, i, 11, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, i, 10, 12, i, 11, 12, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 0, 10, i, 0, 11, i, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 12, 10, i, 12, 11, i, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, 13, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, i, 13, 12, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 0, 13, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12, 13, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, i + 1, 13, 0, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, i + 1, 13, 12, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, i + 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 12, 13, i + 1, p_74875_3_);
        }

        func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 12, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 0, 13, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 12, 13, 0, p_74875_3_);
        for(int j = 3; j <= 9; j += 2)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 1, 7, j, 1, 8, j, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 11, 7, j, 11, 8, j, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        }

        int k = func_74863_c(Block.field_72100_bC.field_71990_ca, 3);
        for(int l = 0; l <= 6; l++)
        {
            int k1 = l + 4;
            for(int i2 = 5; i2 <= 7; i2++)
            {
                func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, k, i2, 5 + l, k1, p_74875_3_);
            }

            if(k1 >= 5 && k1 <= 8)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 5, 5, k1, 7, l + 4, k1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            } else
            if(k1 >= 9 && k1 <= 10)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 5, 8, k1, 7, l + 4, k1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }
            if(l >= 1)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 5, 6 + l, k1, 7, 9 + l, k1, 0, 0, false);
            }
        }

        for(int i1 = 5; i1 <= 7; i1++)
        {
            func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, k, i1, 12, 11, p_74875_3_);
        }

        func_74884_a(p_74875_1_, p_74875_3_, 5, 6, 7, 5, 7, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 7, 6, 7, 7, 7, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 13, 12, 7, 13, 12, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 2, 3, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 9, 3, 5, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 5, 4, 2, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 5, 2, 10, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 5, 9, 10, 5, 10, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 10, 5, 4, 10, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        int j1 = func_74863_c(Block.field_72100_bC.field_71990_ca, 0);
        int l1 = func_74863_c(Block.field_72100_bC.field_71990_ca, 1);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, l1, 4, 5, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, l1, 4, 5, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, l1, 4, 5, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, l1, 4, 5, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j1, 8, 5, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j1, 8, 5, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j1, 8, 5, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72100_bC.field_71990_ca, j1, 8, 5, 10, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 4, 4, 4, 4, 8, Block.field_72013_bc.field_71990_ca, Block.field_72013_bc.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 4, 4, 9, 4, 8, Block.field_72013_bc.field_71990_ca, Block.field_72013_bc.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 5, 4, 4, 5, 8, Block.field_72094_bD.field_71990_ca, Block.field_72094_bD.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 5, 4, 9, 5, 8, Block.field_72094_bD.field_71990_ca, Block.field_72094_bD.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        for(int j2 = 4; j2 <= 8; j2++)
        {
            for(int l2 = 0; l2 <= 2; l2++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, j2, -1, l2, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, j2, -1, 12 - l2, p_74875_3_);
            }

        }

        for(int k2 = 0; k2 <= 2; k2++)
        {
            for(int i3 = 4; i3 <= 8; i3++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, k2, -1, i3, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12 - k2, -1, i3, p_74875_3_);
            }

        }

        return true;
    }
}
