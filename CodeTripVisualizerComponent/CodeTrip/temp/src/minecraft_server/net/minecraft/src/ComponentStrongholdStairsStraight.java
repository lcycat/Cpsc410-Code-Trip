// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, World

public class ComponentStrongholdStairsStraight extends ComponentStronghold
{

    private final EnumDoor field_75029_a;

    public ComponentStrongholdStairsStraight(int p_i3854_1_, Random p_i3854_2_, StructureBoundingBox p_i3854_3_, int p_i3854_4_)
    {
        super(p_i3854_1_);
        field_74885_f = p_i3854_4_;
        field_75029_a = func_74988_a(p_i3854_2_);
        field_74887_e = p_i3854_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
    }

    public static ComponentStrongholdStairsStraight func_75028_a(List p_75028_0_, Random p_75028_1_, int p_75028_2_, int p_75028_3_, int p_75028_4_, int p_75028_5_, int p_75028_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75028_2_, p_75028_3_, p_75028_4_, -1, -7, 0, 5, 11, 8, p_75028_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75028_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdStairsStraight(p_75028_6_, p_75028_1_, structureboundingbox, p_75028_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 10, 7, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, field_75029_a, 1, 7, 0);
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.OPENING, 1, 1, 7);
        int i = func_74863_c(Block.field_72057_aH.field_71990_ca, 2);
        for(int j = 0; j < 6; j++)
        {
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, i, 1, 6 - j, 1 + j, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, i, 2, 6 - j, 1 + j, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, i, 3, 6 - j, 1 + j, p_74875_3_);
            if(j < 5)
            {
                func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 5 - j, 1 + j, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 5 - j, 1 + j, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 5 - j, 1 + j, p_74875_3_);
            }
        }

        return true;
    }
}
