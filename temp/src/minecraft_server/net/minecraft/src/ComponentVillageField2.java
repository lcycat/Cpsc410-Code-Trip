// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            MathHelper, ComponentVillageStartPiece, World

public class ComponentVillageField2 extends ComponentVillage
{

    private int field_74903_a;

    public ComponentVillageField2(ComponentVillageStartPiece p_i3862_1_, int p_i3862_2_, Random p_i3862_3_, StructureBoundingBox p_i3862_4_, int p_i3862_5_)
    {
        super(p_i3862_1_, p_i3862_2_);
        field_74903_a = -1;
        field_74885_f = p_i3862_5_;
        field_74887_e = p_i3862_4_;
    }

    public static ComponentVillageField2 func_74902_a(ComponentVillageStartPiece p_74902_0_, List p_74902_1_, Random p_74902_2_, int p_74902_3_, int p_74902_4_, int p_74902_5_, int p_74902_6_, int p_74902_7_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74902_3_, p_74902_4_, p_74902_5_, 0, 0, 0, 7, 4, 9, p_74902_6_);
        if(!func_74895_a(structureboundingbox) || StructureComponent.func_74883_a(p_74902_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentVillageField2(p_74902_0_, p_74902_7_, p_74902_2_, structureboundingbox, p_74902_6_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74903_a < 0)
        {
            field_74903_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74903_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74903_a - field_74887_e.field_78894_e) + 4) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 0, 1, 0, 6, 4, 8, 0, 0, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 2, 0, 7, Block.field_72050_aA.field_71990_ca, Block.field_72050_aA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 4, 0, 1, 5, 0, 7, Block.field_72050_aA.field_71990_ca, Block.field_72050_aA.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 6, 0, 0, 6, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 0, 5, 0, 0, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 8, 5, 0, 8, Block.field_71951_J.field_71990_ca, Block.field_71951_J.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 0, 1, 3, 0, 7, Block.field_71942_A.field_71990_ca, Block.field_71942_A.field_71990_ca, false);
        for(int i = 1; i <= 7; i++)
        {
            func_74864_a(p_74875_1_, Block.field_72058_az.field_71990_ca, MathHelper.func_76136_a(p_74875_2_, 2, 7), 1, 1, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72058_az.field_71990_ca, MathHelper.func_76136_a(p_74875_2_, 2, 7), 2, 1, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72058_az.field_71990_ca, MathHelper.func_76136_a(p_74875_2_, 2, 7), 4, 1, i, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72058_az.field_71990_ca, MathHelper.func_76136_a(p_74875_2_, 2, 7), 5, 1, i, p_74875_3_);
        }

        for(int j = 0; j < 9; j++)
        {
            for(int k = 0; k < 7; k++)
            {
                func_74871_b(p_74875_1_, k, 4, j, p_74875_3_);
                func_74870_b(p_74875_1_, Block.field_71979_v.field_71990_ca, 0, k, -1, j, p_74875_3_);
            }

        }

        return true;
    }
}
