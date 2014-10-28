// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, ComponentNetherBridgeStartPiece, StructureBoundingBox, StructureComponent, 
//            Block, World

public class ComponentNetherBridgeCorridor4 extends ComponentNetherBridgePiece
{

    public ComponentNetherBridgeCorridor4(int p_i3818_1_, Random p_i3818_2_, StructureBoundingBox p_i3818_3_, int p_i3818_4_)
    {
        super(p_i3818_1_);
        field_74885_f = p_i3818_4_;
        field_74887_e = p_i3818_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        byte byte0 = 1;
        if(field_74885_f == 1 || field_74885_f == 2)
        {
            byte0 = 5;
        }
        func_74961_b((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, byte0, p_74861_3_.nextInt(8) > 0);
        func_74965_c((ComponentNetherBridgeStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, byte0, p_74861_3_.nextInt(8) > 0);
    }

    public static ComponentNetherBridgeCorridor4 func_74985_a(List p_74985_0_, Random p_74985_1_, int p_74985_2_, int p_74985_3_, int p_74985_4_, int p_74985_5_, int p_74985_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74985_2_, p_74985_3_, p_74985_4_, -3, 0, 0, 9, 7, 9, p_74985_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74985_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeCorridor4(p_74985_6_, p_74985_1_, structureboundingbox, p_74985_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 1, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 8, 5, 8, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 0, 8, 6, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 2, 5, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 2, 0, 8, 5, 0, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 0, 1, 4, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 7, 3, 0, 7, 4, 0, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 4, 8, 2, 8, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 2, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 1, 4, 7, 2, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 8, 8, 3, 8, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 6, 0, 3, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 3, 6, 8, 3, 7, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 3, 4, 0, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 3, 4, 8, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 5, 2, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 3, 5, 7, 5, 5, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 5, 1, 5, 5, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 7, 4, 5, 7, 5, 5, Block.field_72098_bB.field_71990_ca, Block.field_72098_bB.field_71990_ca, false);
        for(int i = 0; i <= 5; i++)
        {
            for(int j = 0; j <= 8; j++)
            {
                func_74870_b(p_74875_1_, Block.field_72033_bA.field_71990_ca, 0, j, -1, i, p_74875_3_);
            }

        }

        return true;
    }
}
