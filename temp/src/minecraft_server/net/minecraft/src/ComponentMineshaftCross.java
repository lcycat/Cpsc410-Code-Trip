// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, Block, 
//            World

public class ComponentMineshaftCross extends StructureComponent
{

    private final int field_74953_a;
    private final boolean field_74952_b;

    public ComponentMineshaftCross(int p_i3808_1_, Random p_i3808_2_, StructureBoundingBox p_i3808_3_, int p_i3808_4_)
    {
        super(p_i3808_1_);
        field_74953_a = p_i3808_4_;
        field_74887_e = p_i3808_3_;
        field_74952_b = p_i3808_3_.func_78882_c() > 3;
    }

    public static StructureBoundingBox func_74951_a(List p_74951_0_, Random p_74951_1_, int p_74951_2_, int p_74951_3_, int p_74951_4_, int p_74951_5_)
    {
        StructureBoundingBox structureboundingbox = new StructureBoundingBox(p_74951_2_, p_74951_3_, p_74951_4_, p_74951_2_, p_74951_3_ + 2, p_74951_4_);
        if(p_74951_1_.nextInt(4) == 0)
        {
            structureboundingbox.field_78894_e += 4;
        }
        switch(p_74951_5_)
        {
        case 2: // '\002'
            structureboundingbox.field_78897_a = p_74951_2_ - 1;
            structureboundingbox.field_78893_d = p_74951_2_ + 3;
            structureboundingbox.field_78896_c = p_74951_4_ - 4;
            break;

        case 0: // '\0'
            structureboundingbox.field_78897_a = p_74951_2_ - 1;
            structureboundingbox.field_78893_d = p_74951_2_ + 3;
            structureboundingbox.field_78892_f = p_74951_4_ + 4;
            break;

        case 1: // '\001'
            structureboundingbox.field_78897_a = p_74951_2_ - 4;
            structureboundingbox.field_78896_c = p_74951_4_ - 1;
            structureboundingbox.field_78892_f = p_74951_4_ + 3;
            break;

        case 3: // '\003'
            structureboundingbox.field_78893_d = p_74951_2_ + 4;
            structureboundingbox.field_78896_c = p_74951_4_ - 1;
            structureboundingbox.field_78892_f = p_74951_4_ + 3;
            break;
        }
        if(StructureComponent.func_74883_a(p_74951_0_, structureboundingbox) != null)
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
        switch(field_74953_a)
        {
        case 2: // '\002'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, 1, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, 3, i);
            break;

        case 0: // '\0'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, 1, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, 3, i);
            break;

        case 1: // '\001'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, 1, i);
            break;

        case 3: // '\003'
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, i);
            StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, 3, i);
            break;
        }
        if(field_74952_b)
        {
            if(p_74861_3_.nextBoolean())
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b + 3 + 1, field_74887_e.field_78896_c - 1, 2, i);
            }
            if(p_74861_3_.nextBoolean())
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + 3 + 1, field_74887_e.field_78896_c + 1, 1, i);
            }
            if(p_74861_3_.nextBoolean())
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + 3 + 1, field_74887_e.field_78896_c + 1, 3, i);
            }
            if(p_74861_3_.nextBoolean())
            {
                StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b + 3 + 1, field_74887_e.field_78892_f + 1, 0, i);
            }
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        if(field_74952_b)
        {
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c, field_74887_e.field_78893_d - 1, (field_74887_e.field_78895_b + 3) - 1, field_74887_e.field_78892_f, 0, 0, false);
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, field_74887_e.field_78893_d, (field_74887_e.field_78895_b + 3) - 1, field_74887_e.field_78892_f - 1, 0, 0, false);
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78894_e - 2, field_74887_e.field_78896_c, field_74887_e.field_78893_d - 1, field_74887_e.field_78894_e, field_74887_e.field_78892_f, 0, 0, false);
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a, field_74887_e.field_78894_e - 2, field_74887_e.field_78896_c + 1, field_74887_e.field_78893_d, field_74887_e.field_78894_e, field_74887_e.field_78892_f - 1, 0, 0, false);
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b + 3, field_74887_e.field_78896_c + 1, field_74887_e.field_78893_d - 1, field_74887_e.field_78895_b + 3, field_74887_e.field_78892_f - 1, 0, 0, false);
        } else
        {
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c, field_74887_e.field_78893_d - 1, field_74887_e.field_78894_e, field_74887_e.field_78892_f, 0, 0, false);
            func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, field_74887_e.field_78893_d, field_74887_e.field_78894_e, field_74887_e.field_78892_f - 1, 0, 0, false);
        }
        func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, field_74887_e.field_78897_a + 1, field_74887_e.field_78894_e, field_74887_e.field_78896_c + 1, Block.field_71988_x.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f - 1, field_74887_e.field_78897_a + 1, field_74887_e.field_78894_e, field_74887_e.field_78892_f - 1, Block.field_71988_x.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78893_d - 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c + 1, field_74887_e.field_78893_d - 1, field_74887_e.field_78894_e, field_74887_e.field_78896_c + 1, Block.field_71988_x.field_71990_ca, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78893_d - 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f - 1, field_74887_e.field_78893_d - 1, field_74887_e.field_78894_e, field_74887_e.field_78892_f - 1, Block.field_71988_x.field_71990_ca, 0, false);
        for(int i = field_74887_e.field_78897_a; i <= field_74887_e.field_78893_d; i++)
        {
            for(int j = field_74887_e.field_78896_c; j <= field_74887_e.field_78892_f; j++)
            {
                int k = func_74866_a(p_74875_1_, i, field_74887_e.field_78895_b - 1, j, p_74875_3_);
                if(k == 0)
                {
                    func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, i, field_74887_e.field_78895_b - 1, j, p_74875_3_);
                }
            }

        }

        return true;
    }
}
