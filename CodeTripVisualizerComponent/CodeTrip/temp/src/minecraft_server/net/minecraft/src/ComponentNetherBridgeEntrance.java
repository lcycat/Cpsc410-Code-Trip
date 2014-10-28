// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeEntrance extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeEntrance(int p_i3819_1_, Random p_i3819_2_, StructureBoundingBox p_i3819_3_, int p_i3819_4_)
    {
        super(p_i3819_1_);
        field_74885_f = p_i3819_4_;
        field_74887_e = p_i3819_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74963_a((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 5, 3, true);
    }

    public static ComponentNetherBridgeEntrance func_74984_a(List p_74984_0_, Random p_74984_1_, int p_74984_2_, int p_74984_3_, int p_74984_4_, int p_74984_5_, int p_74984_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74984_2_, p_74984_3_, p_74984_4_, -5, -3, 0, 13, 14, 13, p_74984_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74984_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeEntrance(p_74984_6_, p_74984_1_, structureboundingbox, p_74984_5_);
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
        func_74884_a(p_74875_1_, p_74875_3_, 5, 8, 0, 7, 8, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
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

        func_74884_a(p_74875_1_, p_74875_3_, 4, 2, 0, 8, 2, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 12, 2, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 0, 8, 1, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 9, 8, 1, 12, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 4, 3, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 0, 4, 12, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        for(int k = 4; k <= 8; k++)
        {
            for(int j1 = 0; j1 <= 2; j1++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, k, -1, j1, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, k, -1, 12 - j1, p_74875_3_);
            }

        }

        for(int l = 0; l <= 2; l++)
        {
            for(int k1 = 4; k1 <= 8; k1++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, l, -1, k1, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 12 - l, -1, k1, p_74875_3_);
            }

        }

        func_74884_a(p_74875_1_, p_74875_3_, 5, 5, 5, 7, 5, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 1, 6, 6, 4, 6, 0, 0, false);
        func_74864_a(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, 6, 0, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71944_C.field_71990_ca, 0, 6, 5, 6, p_74875_3_);
        int i1 = func_74865_a(6, 6);
        int l1 = func_74862_a(5);
        int i2 = func_74873_b(6, 6);
        if(p_74875_3_.func_78890_b(i1, l1, i2))
        {
            p_74875_1_.field_72999_e = true;
            Block.field_71973_m[Block.field_71944_C.field_71990_ca].func_71847_b(p_74875_1_, i1, l1, i2, p_74875_2_);
            p_74875_1_.field_72999_e = false;
        }
        return true;
    }
}
