// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            ComponentVillageStartPiece, World

public class ComponentVillageHouse1 extends ComponentVillage
{

    private int field_74899_a;

    public ComponentVillageHouse1(ComponentVillageStartPiece p_i3860_1_, int p_i3860_2_, Random p_i3860_3_, StructureBoundingBox p_i3860_4_, int p_i3860_5_)
    {
        super(p_i3860_1_, p_i3860_2_);
        field_74899_a = -1;
        field_74885_f = p_i3860_5_;
        field_74887_e = p_i3860_4_;
    }

    public static ComponentVillageHouse1 func_74898_a(ComponentVillageStartPiece p_74898_0_, List p_74898_1_, Random p_74898_2_, int p_74898_3_, int p_74898_4_, int p_74898_5_, int p_74898_6_, int p_74898_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74898_3_, p_74898_4_, p_74898_5_, 0, 0, 0, 9, 9, 6, p_74898_6_);
        if(!func_74895_a(structureboundingbox) || StructureComponent.func_74883_a(p_74898_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHouse1(p_74898_0_, p_74898_7_, p_74898_2_, structureboundingbox, p_74898_6_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74899_a < 0)
        {
            field_74899_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74899_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74899_a - field_74887_e.field_78894_e) + 9) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 5, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 8, 0, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 0, 8, 5, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 6, 1, 8, 6, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 7, 2, 8, 7, 3, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        int i = func_74863_c(Block.field_72063_at.field_71990_ca, 3);
        int j = func_74863_c(Block.field_72063_at.field_71990_ca, 2);
        for(int k = -1; k <= 2; k++)
        {
            for(int i1 = 0; i1 <= 8; i1++)
            {
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, i, i1, 6 + k, k, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, j, i1, 6 + k, 5 - k, p_74875_3_);
            }

        }

        func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 5, 8, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 1, 0, 8, 1, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 0, 7, 1, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 0, 0, 4, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 5, 0, 4, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 2, 5, 8, 4, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 2, 0, 8, 4, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 2, 1, 0, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 4, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 2, 1, 8, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 4, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 4, 3, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 3, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 3, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 3, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 3, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 3, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 3, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 2, 5, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 1, 7, 4, 1, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 4, 7, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 3, 4, 7, 3, 4, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 7, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, func_74863_c(Block.field_72063_at.field_71990_ca, 0), 7, 1, 3, p_74875_3_);
        int l = func_74863_c(Block.field_72063_at.field_71990_ca, 3);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, 6, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, 5, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, 4, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, 3, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 6, 1, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, 6, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 1, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, 4, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72060_ay.field_71990_ca, 0, 7, 1, 1, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 1, 1, 0, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 1, 2, 0, p_74875_3_);
        func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        if(func_74866_a(p_74875_1_, 1, 0, -1, p_74875_3_) == 0 && func_74866_a(p_74875_1_, 1, -1, -1, p_74875_3_) != 0)
        {
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 1, 0, -1, p_74875_3_);
        }
        for(int j1 = 0; j1 < 6; j1++)
        {
            for(int k1 = 0; k1 < 9; k1++)
            {
                func_74871_b(p_74875_1_, k1, 9, j1, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, k1, -1, j1, p_74875_3_);
            }

        }

        func_74893_a(p_74875_1_, p_74875_3_, 2, 1, 2, 1);
        return true;
    }

    protected int func_74888_b(int p_74888_1_)
    {
        return 1;
    }
}
