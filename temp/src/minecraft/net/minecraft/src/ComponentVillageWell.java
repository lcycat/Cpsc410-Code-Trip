// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillage, StructureBoundingBox, ComponentVillageStartPiece, StructureVillagePieces, 
//            Block, StructureComponent, World

public class ComponentVillageWell extends ComponentVillage
{

    private final boolean field_74924_a = true;
    private int field_74923_b;

    public ComponentVillageWell(ComponentVillageStartPiece p_i3875_1_, int p_i3875_2_, Random p_i3875_3_, int p_i3875_4_, int p_i3875_5_)
    {
        super(p_i3875_1_, p_i3875_2_);
        field_74923_b = -1;
        field_74885_f = p_i3875_3_.nextInt(4);
        switch(field_74885_f)
        {
        case 0: // '\0'
        case 2: // '\002'
            field_74887_e = new StructureBoundingBox(p_i3875_4_, 64, p_i3875_5_, (p_i3875_4_ + 6) - 1, 78, (p_i3875_5_ + 6) - 1);
            break;

        default:
            field_74887_e = new StructureBoundingBox(p_i3875_4_, 64, p_i3875_5_, (p_i3875_4_ + 6) - 1, 78, (p_i3875_5_ + 6) - 1);
            break;
        }
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78894_e - 4, field_74887_e.field_78896_c + 1, 1, func_74877_c());
        StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78894_e - 4, field_74887_e.field_78896_c + 1, 3, func_74877_c());
        StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78894_e - 4, field_74887_e.field_78896_c - 1, 2, func_74877_c());
        StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + 1, field_74887_e.field_78894_e - 4, field_74887_e.field_78892_f + 1, 0, func_74877_c());
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(field_74923_b < 0)
        {
            field_74923_b = func_74889_b(p_74875_1_, p_74875_3_);
            if(field_74923_b < 0)
            {
                return true;
            }
            field_74887_e.func_78886_a(0, (field_74923_b - field_74887_e.field_78894_e) + 3, 0);
        }
        func_74884_a(p_74875_1_, p_74875_3_, 1, 0, 1, 4, 12, 4, Block.field_71978_w.field_71990_ca, Block.field_71942_A.field_71990_ca, false);
        func_74864_a(p_74875_1_, 0, 0, 2, 12, 2, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 3, 12, 2, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 2, 12, 3, p_74875_3_);
        func_74864_a(p_74875_1_, 0, 0, 3, 12, 3, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 13, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 14, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 13, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 14, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 13, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 1, 14, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 13, 4, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 4, 14, 4, p_74875_3_);
        func_74884_a(p_74875_1_, p_74875_3_, 1, 15, 1, 4, 15, 4, Block.field_71978_w.field_71990_ca, Block.field_71978_w.field_71990_ca, false);
        for(int i = 0; i <= 5; i++)
        {
            for(int j = 0; j <= 5; j++)
            {
                if(j == 0 || j == 5 || i == 0 || i == 5)
                {
                    func_74864_a(p_74875_1_, Block.field_71940_F.field_71990_ca, 0, j, 11, i, p_74875_3_);
                    func_74871_b(p_74875_1_, j, 12, i, p_74875_3_);
                }
            }

        }

        return true;
    }
}
