// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, StructureBoundingBox, StructureComponent, Block, 
//            World, TileEntityMobSpawner

public class ComponentNetherBridgeThrone extends ComponentNetherBridgePiece
{

    private boolean field_74976_a;

    public ComponentNetherBridgeThrone(int p_i3825_1_, Random p_i3825_2_, StructureBoundingBox p_i3825_3_, int p_i3825_4_)
    {
        super(p_i3825_1_);
        field_74885_f = p_i3825_4_;
        field_74887_e = p_i3825_3_;
    }

    public static ComponentNetherBridgeThrone func_74975_a(List p_74975_0_, Random p_74975_1_, int p_74975_2_, int p_74975_3_, int p_74975_4_, int p_74975_5_, int p_74975_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74975_2_, p_74975_3_, p_74975_4_, -2, 0, 0, 7, 8, 9, p_74975_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74975_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeThrone(p_74975_6_, p_74975_1_, structureboundingbox, p_74975_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 6, 7, 7, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 1, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 1, 5, 2, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 2, 5, 3, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 3, 5, 4, 7, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 1, 4, 2, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 2, 0, 5, 4, 2, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 2, 1, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 5, 2, 5, 5, 3, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 3, 0, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 3, 6, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 8, 5, 5, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 1, 6, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72098_bB.field_71990_ca, 0, 5, 6, 3, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 3, 0, 6, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 6, 3, 6, 6, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 6, 8, 5, 7, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 8, 8, 4, 8, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        if(!field_74976_a)
        {
            int i = func_74862_a(5);
            int k = func_74865_a(3, 5);
            int i1 = func_74873_b(3, 5);
            if(p_74875_3_.func_78890_b(k, i, i1))
            {
                field_74976_a = true;
                p_74875_1_.func_72859_e(k, i, i1, Block.field_72065_as.field_71990_ca);
                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.func_72796_p(k, i, i1);
                if(tileentitymobspawner != null)
                {
                    tileentitymobspawner.func_70385_a("Blaze");
                }
            }
        }
        for(int j = 0; j <= 6; j++)
        {
            for(int l = 0; l <= 6; l++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, j, -1, l, p_74875_3_);
            }

        }

        return true;
    }
}
