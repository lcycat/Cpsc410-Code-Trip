// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            ComponentVillageStartPiece, World

public class ComponentVillageWoodHut extends ComponentVillage
{

    private int field_74911_a;
    private final boolean field_74909_b;
    private final int field_74910_c;

    public ComponentVillageWoodHut(ComponentVillageStartPiece p_i3867_1_, int p_i3867_2_, Random p_i3867_3_, StructureBoundingBox p_i3867_4_, int p_i3867_5_)
    {
        super(p_i3867_1_, p_i3867_2_);
        field_74911_a = -1;
        field_74885_f = p_i3867_5_;
        field_74887_e = p_i3867_4_;
        field_74909_b = p_i3867_3_.nextBoolean();
        field_74910_c = p_i3867_3_.nextInt(3);
    }

    public static ComponentVillageWoodHut func_74908_a(ComponentVillageStartPiece p_74908_0_, List p_74908_1_, Random p_74908_2_, int p_74908_3_, int p_74908_4_, int p_74908_5_, int p_74908_6_, int p_74908_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74908_3_, p_74908_4_, p_74908_5_, 0, 0, 0, 4, 6, 5, p_74908_6_);
        if(!func_74895_a(structureboundingbox) || StructureComponent.func_74883_a(p_74908_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageWoodHut(p_74908_0_, p_74908_7_, p_74908_2_, structureboundingbox, p_74908_6_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74911_a < 0)
        {
            field_74911_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74911_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74911_a - field_74887_e.field_78894_e) + 6) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 3, 5, 4, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 3, 0, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 3, Block.field_71979_v.field_71990_ca, Block.field_71979_v.field_71990_ca, false);
        if(field_74909_b)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 1, 4, 1, 2, 4, 3, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        } else
        {
            func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 2, 5, 3, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        }
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 1, 4, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 4, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 1, 4, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 2, 4, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 4, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 4, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 0, 4, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 3, 4, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 3, 4, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_71951_J.field_71990_ca, 0, 3, 4, 3, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 0, 3, 0, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 0, 3, 3, 0, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 4, 0, 3, 4, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 4, 3, 3, 4, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 1, 0, 3, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 1, 3, 3, 3, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 0, 2, 3, 0, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 4, 2, 3, 4, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 0, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72003_bq.field_71990_ca, 0, 3, 2, 2, p_74875_3_);
        if(field_74910_c > 0)
        {
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, field_74910_c, 1, 3, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72046_aM.field_71990_ca, 0, field_74910_c, 2, 3, p_74875_3_);
        }
        func_74864_a(p_74875_1_, 0, 0, 1, 1, 0, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 1, 2, 0, p_74875_3_);
        func_74881_a(p_74875_1_, p_74875_3_, p_74875_2_, 1, 1, 0, func_74863_c(Block.field_72054_aE.field_71990_ca, 1));
        if(func_74866_a(p_74875_1_, 1, 0, -1, p_74875_3_) == 0 && func_74866_a(p_74875_1_, 1, -1, -1, p_74875_3_) != 0)
        {
            func_74864_a(p_74875_1_, Block.field_72057_aH.field_71990_ca, func_74863_c(Block.field_72057_aH.field_71990_ca, 3), 1, 0, -1, p_74875_3_);
        }
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                func_74871_b(p_74875_1_, j, 6, i, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71978_w.field_71990_ca, 0, j, -1, i, p_74875_3_);
            }

        }

        func_74893_a(p_74875_1_, p_74875_3_, 1, 1, 2, 1);
        return true;
    }
}
