// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, Block, EnumDoor, World

public class ComponentStrongholdPrison extends ComponentStronghold
{

    protected final EnumDoor field_75017_a;

    public ComponentStrongholdPrison(int p_i3847_1_, Random p_i3847_2_, StructureBoundingBox p_i3847_3_, int p_i3847_4_)
    {
        super(p_i3847_1_);
        field_74885_f = p_i3847_4_;
        field_75017_a = func_74988_a(p_i3847_2_);
        field_74887_e = p_i3847_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
    }

    public static ComponentStrongholdPrison func_75016_a(List p_75016_0_, Random p_75016_1_, int p_75016_2_, int p_75016_3_, int p_75016_4_, int p_75016_5_, int p_75016_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75016_2_, p_75016_3_, p_75016_4_, -1, -1, 0, 9, 5, 11, p_75016_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75016_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdPrison(p_75016_6_, p_75016_1_, structureboundingbox, p_75016_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        } else
        {
            func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 4, 10, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, field_75017_a, 1, 1, 0);
            func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 10, 3, 3, 10, 0, 0, false);
            func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 1, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 3, 4, 3, 3, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 7, 4, 3, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 9, 4, 3, 9, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
            func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 4, 4, 3, 6, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 5, 1, 5, 7, 3, 5, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
            func_74864_a(p_74875_1_, Block.field_72002_bp.field_71990_ca, 0, 4, 3, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72002_bp.field_71990_ca, 0, 4, 3, 8, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72045_aL.field_71990_ca, func_74863_c(Block.field_72045_aL.field_71990_ca, 3), 4, 1, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72045_aL.field_71990_ca, func_74863_c(Block.field_72045_aL.field_71990_ca, 3) + 8, 4, 2, 2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72045_aL.field_71990_ca, func_74863_c(Block.field_72045_aL.field_71990_ca, 3), 4, 1, 8, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72045_aL.field_71990_ca, func_74863_c(Block.field_72045_aL.field_71990_ca, 3) + 8, 4, 2, 8, p_74875_3_);
            return true;
        }
    }
}
