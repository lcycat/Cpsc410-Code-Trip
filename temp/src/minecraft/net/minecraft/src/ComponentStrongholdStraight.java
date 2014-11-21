// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, World

public class ComponentStrongholdStraight extends ComponentStronghold
{

    private final EnumDoor field_75021_a;
    private final boolean field_75019_b;
    private final boolean field_75020_c;

    public ComponentStrongholdStraight(int p_i3853_1_, Random p_i3853_2_, StructureBoundingBox p_i3853_3_, int p_i3853_4_)
    {
        super(p_i3853_1_);
        field_74885_f = p_i3853_4_;
        field_75021_a = func_74988_a(p_i3853_2_);
        field_74887_e = p_i3853_3_;
        field_75019_b = p_i3853_2_.nextInt(2) == 0;
        field_75020_c = p_i3853_2_.nextInt(2) == 0;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        if(field_75019_b)
        {
            func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
        }
        if(field_75020_c)
        {
            func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 2);
        }
    }

    public static ComponentStrongholdStraight func_75018_a(List p_75018_0_, Random p_75018_1_, int p_75018_2_, int p_75018_3_, int p_75018_4_, int p_75018_5_, int p_75018_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75018_2_, p_75018_3_, p_75018_4_, -1, -1, 0, 5, 5, 7, p_75018_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75018_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdStraight(p_75018_6_, p_75018_1_, structureboundingbox, p_75018_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, field_75021_a, 1, 1, 0);
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.OPENING, 1, 1, 6);
        func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 1, Block.field_72069_aq.field_71990_ca, 0);
        func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 1, Block.field_72069_aq.field_71990_ca, 0);
        func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 1, 2, 5, Block.field_72069_aq.field_71990_ca, 0);
        func_74876_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.1F, 3, 2, 5, Block.field_72069_aq.field_71990_ca, 0);
        if(field_75019_b)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 2, 0, 3, 4, 0, 0, false);
        }
        if(field_75020_c)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 2, 4, 3, 4, 0, 0, false);
        }
        return true;
    }
}
