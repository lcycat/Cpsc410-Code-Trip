// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, StructureBoundingBox, StructureComponent, Block, 
//            World

public class ComponentStrongholdCorridor extends ComponentStronghold
{

    private final int field_74993_a;

    public ComponentStrongholdCorridor(int p_i3841_1_, Random p_i3841_2_, StructureBoundingBox p_i3841_3_, int p_i3841_4_)
    {
        super(p_i3841_1_);
        field_74885_f = p_i3841_4_;
        field_74887_e = p_i3841_3_;
        field_74993_a = p_i3841_4_ != 2 && p_i3841_4_ != 0 ? p_i3841_3_.func_78883_b() : p_i3841_3_.func_78880_d();
    }

    public static StructureBoundingBox func_74992_a(List p_74992_0_, Random p_74992_1_, int p_74992_2_, int p_74992_3_, int p_74992_4_, int p_74992_5_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, 4, p_74992_5_);
        StructureComponent structurecomponent = StructureComponent.func_74883_a(p_74992_0_, structureboundingbox);
        if(structurecomponent == null)
        {
            return null;
        }
        if(structurecomponent.func_74874_b().field_78895_b == structureboundingbox.field_78895_b)
        {
            for(int i = 3; i >= 1; i--)
            {
                StructureBoundingBox structureboundingbox1 = StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, i - 1, p_74992_5_);
                if(!structurecomponent.func_74874_b().func_78884_a(structureboundingbox1))
                {
                    return StructureBoundingBox.func_78889_a(p_74992_2_, p_74992_3_, p_74992_4_, -1, -1, 0, 5, 5, i, p_74992_5_);
                }
            }

        }
        return null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        for(int i = 0; i < field_74993_a; i++)
        {
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, 0, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 0, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 0, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 0, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, 0, i, p_74875_3_);
            for(int j = 1; j <= 3; j++)
            {
                func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, j, i, p_74875_3_);
                func_74864_a(p_74875_1_, 0, 0, 1, j, i, p_74875_3_);
                func_74864_a(p_74875_1_, 0, 0, 2, j, i, p_74875_3_);
                func_74864_a(p_74875_1_, 0, 0, 3, j, i, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, j, i, p_74875_3_);
            }

            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 0, 4, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 1, 4, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 2, 4, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 3, 4, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72007_bm.field_71990_ca, 0, 4, 4, i, p_74875_3_);
        }

        return true;
    }
}
