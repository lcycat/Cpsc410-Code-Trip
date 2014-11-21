// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, StructureComponent, Block, 
//            ComponentVillageStartPiece, World

public class ComponentVillageTorch extends ComponentVillage
{

    private int field_74905_a;

    public ComponentVillageTorch(ComponentVillageStartPiece p_i3863_1_, int p_i3863_2_, Random p_i3863_3_, StructureBoundingBox p_i3863_4_, int p_i3863_5_)
    {
        super(p_i3863_1_, p_i3863_2_);
        field_74905_a = -1;
        field_74885_f = p_i3863_5_;
        field_74887_e = p_i3863_4_;
    }

    public static StructureBoundingBox func_74904_a(ComponentVillageStartPiece p_74904_0_, List p_74904_1_, Random p_74904_2_, int p_74904_3_, int p_74904_4_, int p_74904_5_, int p_74904_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74904_3_, p_74904_4_, p_74904_5_, 0, 0, 0, 3, 4, 2, p_74904_6_);
        if(StructureComponent.func_74883_a(p_74904_1_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return structureboundingbox;
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74905_a < 0)
        {
            field_74905_a = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74905_a < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, ((field_74905_a - field_74887_e.field_78894_e) + 4) - 1, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 0, 0, 0, 2, 3, 1, 0, 0, false);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 0, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 1, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 2, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72101_ab.field_71990_ca, 15, 1, 3, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 15, 0, 3, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 15, 1, 3, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 15, 2, 3, 0, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 15, 1, 3, -1, p_74875_3_);
        return true;
    }
}
