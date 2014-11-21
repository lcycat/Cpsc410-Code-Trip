// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, World

public class ComponentStrongholdLeftTurn extends ComponentStronghold
{

    protected final EnumDoor field_75011_a;

    public ComponentStrongholdLeftTurn(int p_i3843_1_, Random p_i3843_2_, StructureBoundingBox p_i3843_3_, int p_i3843_4_)
    {
        super(p_i3843_1_);
        field_74885_f = p_i3843_4_;
        field_75011_a = func_74988_a(p_i3843_2_);
        field_74887_e = p_i3843_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        if(field_74885_f == 2 || field_74885_f == 3)
        {
            func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        } else
        {
            func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        }
    }

    public static ComponentStrongholdLeftTurn func_75010_a(List p_75010_0_, Random p_75010_1_, int p_75010_2_, int p_75010_3_, int p_75010_4_, int p_75010_5_, int p_75010_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75010_2_, p_75010_3_, p_75010_4_, -1, -1, 0, 5, 5, 5, p_75010_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75010_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdLeftTurn(p_75010_6_, p_75010_1_, structureboundingbox, p_75010_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 4, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, field_75011_a, 1, 1, 0);
        if(field_74885_f == 2 || field_74885_f == 3)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, 0, 0, false);
        } else
        {
            func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, 0, 0, false);
        }
        return true;
    }
}
