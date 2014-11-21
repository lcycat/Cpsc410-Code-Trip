// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, World

public class ComponentMineshaftStairs extends StructureComponent
{

    public ComponentMineshaftStairs(int p_i3810_1_, Random p_i3810_2_, StructureBoundingBox p_i3810_3_, int p_i3810_4_)
    {
        super(p_i3810_1_);
        field_74885_f = p_i3810_4_;
        field_74887_e = p_i3810_3_;
    }

    public static StructureBoundingBox func_74950_a(List p_74950_0_, Random p_74950_1_, int p_74950_2_, int p_74950_3_, int p_74950_4_, int p_74950_5_)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74950_2_, p_74950_3_ - 5, p_74950_4_, p_74950_2_, p_74950_3_ + 2, p_74950_4_);
        switch(p_74950_5_)
        {
        case 2: // '\002'
            structureboundingbox.field_78893_d = p_74950_2_ + 2;
            structureboundingbox.field_78896_c = p_74950_4_ - 8;
            break;

        case 0: // '\0'
            structureboundingbox.field_78893_d = p_74950_2_ + 2;
            structureboundingbox.field_78892_f = p_74950_4_ + 8;
            break;

        case 1: // '\001'
            structureboundingbox.field_78897_a = p_74950_2_ - 8;
            structureboundingbox.field_78892_f = p_74950_4_ + 2;
            break;

        case 3: // '\003'
            structureboundingbox.field_78893_d = p_74950_2_ + 8;
            structureboundingbox.field_78892_f = p_74950_4_ + 2;
            break;
        }
        if(StructureComponent.func_74883_a(p_74950_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return structureboundingbox;
        }
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        int i = func_74877_c();
        switch(field_74885_f)
        {
        case 2: // '\002'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, i);
            break;

        case 0: // '\0'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, i);
            break;

        case 1: // '\001'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c, 1, i);
            break;

        case 3: // '\003'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c, 3, i);
            break;
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 2, 7, 1, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 7, 2, 2, 8, 0, 0, false);
        for(int i = 0; i < 5; i++)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 0, 5 - i - (i >= 4 ? 0 : 1), 2 + i, 2, 7 - i, 2 + i, 0, 0, false);
        }

        return true;
    }
}
