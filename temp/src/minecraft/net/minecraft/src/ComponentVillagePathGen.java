// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentVillageRoadPiece, StructureBoundingBox, ComponentVillageStartPiece, StructureComponent, 
//            StructureVillagePieces, MathHelper, Block, World

public class ComponentVillagePathGen extends ComponentVillageRoadPiece
{

    private int field_74934_a;

    public ComponentVillagePathGen(ComponentVillageStartPiece p_i3871_1_, int p_i3871_2_, Random p_i3871_3_, StructureBoundingBox p_i3871_4_, int p_i3871_5_)
    {
        super(p_i3871_1_, p_i3871_2_);
        field_74885_f = p_i3871_5_;
        field_74887_e = p_i3871_4_;
        field_74934_a = Math.max(p_i3871_4_.func_78883_b(), p_i3871_4_.func_78880_d());
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        boolean flag = false;
        for(int i = p_74861_3_.nextInt(5); i < field_74934_a - 8; i += 2 + p_74861_3_.nextInt(5))
        {
            StructureComponent structurecomponent = func_74891_a((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, i);
            if(structurecomponent != null)
            {
                i += Math.max(structurecomponent.field_74887_e.func_78883_b(), structurecomponent.field_74887_e.func_78880_d());
                flag = true;
            }
        }

        for(int j = p_74861_3_.nextInt(5); j < field_74934_a - 8; j += 2 + p_74861_3_.nextInt(5))
        {
            StructureComponent structurecomponent1 = func_74894_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, 0, j);
            if(structurecomponent1 != null)
            {
                j += Math.max(structurecomponent1.field_74887_e.func_78883_b(), structurecomponent1.field_74887_e.func_78880_d());
                flag = true;
            }
        }

        if(flag && p_74861_3_.nextInt(3) > 0)
        {
            switch(field_74885_f)
            {
            case 2: // '\002'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c, 1, func_74877_c());
                break;

            case 0: // '\0'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f - 2, 1, func_74877_c());
                break;

            case 3: // '\003'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d - 2, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, func_74877_c());
                break;

            case 1: // '\001'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78896_c - 1, 2, func_74877_c());
                break;
            }
        }
        if(flag && p_74861_3_.nextInt(3) > 0)
        {
            switch(field_74885_f)
            {
            case 2: // '\002'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, field_74887_e.field_78896_c, 3, func_74877_c());
                break;

            case 0: // '\0'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b, field_74887_e.field_78892_f - 2, 3, func_74877_c());
                break;

            case 3: // '\003'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d - 2, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, func_74877_c());
                break;

            case 1: // '\001'
                StructureVillagePieces.func_75082_b((ComponentVillageStartPiece)p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78892_f + 1, 0, func_74877_c());
                break;
            }
        }
    }

    public static StructureBoundingBox func_74933_a(ComponentVillageStartPiece p_74933_0_, List p_74933_1_, Random p_74933_2_, int p_74933_3_, int p_74933_4_, int p_74933_5_, int p_74933_6_)
    {
        for(int i = 7 * MathHelper.func_76136_a(p_74933_2_, 3, 5); i >= 7; i -= 7)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_74933_3_, p_74933_4_, p_74933_5_, 0, 0, 0, 3, 3, i, p_74933_6_);
            if(StructureComponent.func_74883_a(p_74933_1_, structureboundingbox) == null)
            {
                return structureboundingbox;
            }
        }

        return null;
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        int i = func_74890_d(Block.field_71940_F.field_71990_ca, 0);
        for(int j = field_74887_e.field_78897_a; j <= field_74887_e.field_78893_d; j++)
        {
            for(int k = field_74887_e.field_78896_c; k <= field_74887_e.field_78892_f; k++)
            {
                if(p_74875_3_.func_78890_b(j, 64, k))
                {
                    int l = p_74875_1_.func_72825_h(j, k) - 1;
                    p_74875_1_.func_72822_b(j, l, k, i);
                }
            }

        }

        return true;
    }
}
