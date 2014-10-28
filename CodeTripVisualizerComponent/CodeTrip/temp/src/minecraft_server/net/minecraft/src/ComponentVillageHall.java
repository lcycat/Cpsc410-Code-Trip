// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            BlockHalfSlab, ComponentVillageStartPiece, World

public class ComponentVillageHall extends ComponentVillage
{

    private int field_74907_a;

    public ComponentVillageHall(ComponentVillageStartPiece p_i3865_1_, int p_i3865_2_, Random p_i3865_3_, StructureBoundingBox p_i3865_4_, int p_i3865_5_)
    {
        super(p_i3865_1_, p_i3865_2_);
        field_74907_a = -1;
        field_74885_f = p_i3865_5_;
        field_74887_e = p_i3865_4_;
    }

    public static ComponentVillageHall func_74906_a(ComponentVillageStartPiece p_74906_0_, List p_74906_1_, Random p_74906_2_, int p_74906_3_, int p_74906_4_, int p_74906_5_, int p_74906_6_, int p_74906_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74906_3_, p_74906_4_, p_74906_5_, 0, 0, 0, 9, 7, 11, p_74906_6_);
        if(!func_74895_a(structureboundingbox) || StructureComponent.func_74883_a(p_74906_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHall(p_74906_0_, p_74906_7_, p_74906_2_, structureboundingbox, p_74906_6_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74907_a < 0)
        {
            field_74907_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74907_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74907_a - field_74887_e.field_78894_e) + 7) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 6, 8, 0, 10, Block.field_71979_v.field_71990_ca, Block.field_71979_v.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, 6, 0, 6, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 6, 2, 1, 10, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 1, 6, 8, 1, 10, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 10, 7, 1, 10, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 1, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 5, 7, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 3, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 4, 8, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 3, p_74875_3_);
        int i = func_74863_c(Block.field_72063_at.field_71990_ca, 3);
        int j = func_74863_c(Block.field_72063_at.field_71990_ca, 2);
        for(int k = -1; k <= 2; k++)
        {
            for(int i1 = 0; i1 <= 8; i1++)
            {
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, i, i1, 4 + k, k, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, j, i1, 4 + k, 5 - k, p_74875_3_);
            }

        }

        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 3, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 6, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 2, 1, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, 2, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 1, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, func_74863_c(Block.field_72063_at.field_71990_ca, 3), 2, 1, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, func_74863_c(Block.field_72063_at.field_71990_ca, 1), 1, 1, 3, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 0, 1, 7, 0, 3, Block.field_72085_aj.field_71990_ca, Block.field_72085_aj.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72085_aj.field_71990_ca, 0, 6, 1, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72085_aj.field_71990_ca, 0, 6, 1, 2, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 2, 1, 0, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 2, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, 1, p_74875_3_);
        func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        if(func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0)
        {
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
        }
        func_74864_a(p_74875_1_, 0, 0, 6, 1, 5, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 6, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 6, 3, 4, p_74875_3_);
        func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 6, 1, 5, func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        for(int l = 0; l < 5; l++)
        {
            for(int j1 = 0; j1 < 9; j1++)
            {
                func_74871_b(p_74875_1_, j1, 7, l, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, j1, -1, l, p_74875_3_);
            }

        }

        func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
        return true;
    }

    protected int func_74888_b(int p_74888_1_)
    {
        return p_74888_1_ != 0 ? 0 : 4;
    }
}
