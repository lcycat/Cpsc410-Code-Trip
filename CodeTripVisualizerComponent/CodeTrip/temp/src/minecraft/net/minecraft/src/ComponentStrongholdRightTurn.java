// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStrongholdLeftTurn, ComponentStrongholdStairs2, StructureStrongholdPieces, StructureComponent, 
//            World, StructureBoundingBox

public class ComponentStrongholdRightTurn extends ComponentStrongholdLeftTurn
{

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        if(field_74885_f == 2 || field_74885_f == 3)
        {
            func_74987_c((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
        } else
        {
            func_74989_b((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
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
            func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 3, 3, 0, 0, false);
        } else
        {
            func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, 0, 0, false);
        }
        return true;
    }
}
