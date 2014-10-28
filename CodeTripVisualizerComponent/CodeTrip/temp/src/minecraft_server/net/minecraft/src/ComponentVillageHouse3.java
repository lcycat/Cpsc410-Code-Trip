// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            ComponentVillageStartPiece, World

public class ComponentVillageHouse3 extends ComponentVillage
{

    private int field_74922_a;

    public ComponentVillageHouse3(ComponentVillageStartPiece p_i3872_1_, int p_i3872_2_, Random p_i3872_3_, StructureBoundingBox p_i3872_4_, int p_i3872_5_)
    {
        super(p_i3872_1_, p_i3872_2_);
        field_74922_a = -1;
        field_74885_f = p_i3872_5_;
        field_74887_e = p_i3872_4_;
    }

    public static ComponentVillageHouse3 func_74921_a(ComponentVillageStartPiece p_74921_0_, List p_74921_1_, Random p_74921_2_, int p_74921_3_, int p_74921_4_, int p_74921_5_, int p_74921_6_, int p_74921_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74921_3_, p_74921_4_, p_74921_5_, 0, 0, 0, 9, 7, 12, p_74921_6_);
        if(!func_74895_a(structureboundingbox) || StructureComponent.func_74883_a(p_74921_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageHouse3(p_74921_0_, p_74921_7_, p_74921_2_, structureboundingbox, p_74921_6_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74922_a < 0)
        {
            field_74922_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74922_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74922_a - field_74887_e.field_78894_e) + 7) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 5, 8, 0, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 2, 0, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 5, 2, 1, 5, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 2, 0, 6, 2, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 0, 10, 7, 3, 10, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 2, 5, 2, 3, 5, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 4, 4, 3, 4, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 0, 4, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 4, 4, p_74875_3_);
        int i = func_74863_c(Block.field_72063_at.field_71990_ca, 3);
        int j = func_74863_c(Block.field_72063_at.field_71990_ca, 2);
        for(int k = -1; k <= 2; k++)
        {
            for(int i1 = 0; i1 <= 8; i1++)
            {
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, i, i1, 4 + k, k, p_74875_3_);
                if((k > -1 || i1 <= 1) && (k > 0 || i1 <= 3) && (k > 1 || i1 <= 4 || i1 >= 6))
                {
                    func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, j, i1, 4 + k, 5 - k, p_74875_3_);
                }
            }

        }

        func_74884_a(p_74875_1_, p_74875_3_, 3, 4, 5, 3, 4, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 7, 4, 2, 7, 4, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 4, 4, 5, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 5, 4, 6, 5, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 5, 6, 3, 5, 6, 10, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        int l = func_74863_c(Block.field_72063_at.field_71990_ca, 0);
        for(int j1 = 4; j1 >= 1; j1--)
        {
            func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, j1, 2 + j1, 7 - j1, p_74875_3_);
            for(int l1 = 8 - j1; l1 <= 10; l1++)
            {
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, l, j1, 2 + j1, l1, p_74875_3_);
            }

        }

        int k1 = func_74863_c(Block.field_72063_at.field_71990_ca, 1);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 6, 6, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 7, 5, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, k1, 6, 6, 4, p_74875_3_);
        for(int i2 = 6; i2 <= 8; i2++)
        {
            for(int l2 = 5; l2 <= 10; l2++)
            {
                func_74864_a(p_74875_1_, Block.field_72063_at.field_71990_ca, k1, i2, 12 - i2, l2, p_74875_3_);
            }

        }

        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 2, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 4, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 6, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 2, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 8, 2, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 8, 2, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 2, 6, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 7, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 2, 2, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 2, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 4, 4, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 5, 4, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 6, 4, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 5, 5, 10, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 2, 1, 0, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 2, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, 1, p_74875_3_);
        func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 2, 1, 0, func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, -1, 3, 2, -1, 0, 0, false);
        if(func_74866_a(p_74875_1_, 2, 0, -1, p_74875_3_) == 0 && func_74866_a(p_74875_1_, 2, -1, -1, p_74875_3_) != 0)
        {
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 2, 0, -1, p_74875_3_);
        }
        for(int j2 = 0; j2 < 5; j2++)
        {
            for(int i3 = 0; i3 < 9; i3++)
            {
                func_74871_b(p_74875_1_, i3, 7, j2, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, i3, -1, j2, p_74875_3_);
            }

        }

        for(int k2 = 5; k2 < 11; k2++)
        {
            for(int j3 = 2; j3 < 9; j3++)
            {
                func_74871_b(p_74875_1_, j3, 7, k2, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, j3, -1, k2, p_74875_3_);
            }

        }

        func_74893_a(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
        return true;
    }
}
