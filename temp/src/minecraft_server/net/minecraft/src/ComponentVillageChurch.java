// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            ComponentVillageStartPiece, World

public class ComponentVillageChurch extends ComponentVillage
{

    private int field_74920_a;

    public ComponentVillageChurch(ComponentVillageStartPiece p_i3868_1_, int p_i3868_2_, Random p_i3868_3_, StructureBoundingBox p_i3868_4_, int p_i3868_5_)
    {
        super(p_i3868_1_, p_i3868_2_);
        field_74920_a = -1;
        field_74885_f = p_i3868_5_;
        field_74887_e = p_i3868_4_;
    }

    public static ComponentVillageChurch func_74919_a(ComponentVillageStartPiece p_74919_0_, List p_74919_1_, Random p_74919_2_, int p_74919_3_, int p_74919_4_, int p_74919_5_, int p_74919_6_, int p_74919_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74919_3_, p_74919_4_, p_74919_5_, 0, 0, 0, 5, 12, 9, p_74919_6_);
        if(!func_74895_a(structureboundingbox) || StructureComponent.func_74883_a(p_74919_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageChurch(p_74919_0_, p_74919_7_, p_74919_2_, structureboundingbox, p_74919_6_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74920_a < 0)
        {
            field_74920_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74920_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74920_a - field_74887_e.field_78894_e) + 12) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 3, 7, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 9, 3, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 3, 0, 8, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 0, 3, 10, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 10, 3, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 1, 4, 10, 3, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 4, 0, 4, 7, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 4, 4, 4, 7, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 8, 3, 4, 8, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 4, 3, 10, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 5, 3, 5, 7, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 9, 0, 4, 9, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 0, 4, 4, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 0, 11, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 4, 11, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 2, 11, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 2, 11, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 1, 1, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 1, 1, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 2, 1, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 3, 1, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 3, 1, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 1, 1, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 1, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 3, 1, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 1), 1, 2, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 0), 3, 2, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 3, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 6, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 7, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 6, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 7, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 6, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 7, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 6, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 7, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 3, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 3, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 4, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 1, 4, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 3, 4, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 4, 5, p_74875_3_);
        int i = func_74863_c(Block.field_72055_aF.field_71990_ca, 4);
        for(int j = 1; j <= 9; j++)
        {
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, i, 3, j, 3, p_74875_3_);
        }

        func_74864_a(p_74875_1_, 0, 0, 2, 1, 0, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 2, 2, 0, p_74875_3_);
        func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        if(func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0)
        {
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
        }
        for(int k = 0; k < 9; k++)
        {
            for(int l = 0; l < 5; l++)
            {
                func_74871_b(p_74875_1_, l, 12, k, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, l, -1, k, p_74875_3_);
            }

        }

        func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
        return true;
    }

    protected int func_74888_b(int p_74888_1_)
    {
        return 2;
    }
}
