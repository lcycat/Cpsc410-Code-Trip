// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentNetherBridgePiece, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentNetherBridgeEnd extends ComponentNetherBridgePiece
{

    private int field_74972_a;

    public ComponentNetherBridgeEnd(int p_i3815_1_, Random p_i3815_2_, StructureBoundingBox p_i3815_3_, int p_i3815_4_)
    {
        super(p_i3815_1_);
        field_74885_f = p_i3815_4_;
        field_74887_e = p_i3815_3_;
        field_74972_a = p_i3815_2_.nextInt();
    }

    public static ComponentNetherBridgeEnd func_74971_a(List p_74971_0_, Random p_74971_1_, int p_74971_2_, int p_74971_3_, int p_74971_4_, int p_74971_5_, int p_74971_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74971_2_, p_74971_3_, p_74971_4_, -1, -3, 0, 5, 10, 8, p_74971_5_);
        if(!func_74964_a(structureboundingbox) || StructureComponent.func_74883_a(p_74971_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentNetherBridgeEnd(p_74971_6_, p_74971_1_, structureboundingbox, p_74971_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        Random random = new Random(field_74972_a);
        for(int i = 0; i <= 4; i++)
        {
            for(int i1 = 3; i1 <= 4; i1++)
            {
                int l1 = random.nextInt(8);
                func_74884_a(p_74875_1_, p_74875_3_, i, i1, 0, i, i1, l1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }

        }

        int j = random.nextInt(8);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 0, 5, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        j = random.nextInt(8);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 0, 4, 5, j, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        for(int k = 0; k <= 4; k++)
        {
            int j1 = random.nextInt(5);
            func_74884_a(p_74875_1_, p_74875_3_, k, 2, 0, k, 2, j1, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
        }

        for(int l = 0; l <= 4; l++)
        {
            for(int k1 = 0; k1 <= 1; k1++)
            {
                int i2 = random.nextInt(3);
                func_74884_a(p_74875_1_, p_74875_3_, l, k1, 0, l, k1, i2, Block.field_72033_bA.field_71990_ca, Block.field_72033_bA.field_71990_ca, false);
            }

        }

        return true;
    }
}
