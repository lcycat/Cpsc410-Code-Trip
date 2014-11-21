// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentMineshaftCross, ComponentMineshaftStairs, ComponentMineshaftCorridor, StructureComponent, 
//            StructureBoundingBox, WeightedRandomChestContent, Item, Block

public class StructureMineshaftPieces
{

    private static final WeightedRandomChestContent field_78818_a[];

    private static StructureComponent func_78815_a(List p_78815_0_, Random p_78815_1_, int p_78815_2_, int p_78815_3_, int p_78815_4_, int p_78815_5_, int p_78815_6_)
    {
        int i = p_78815_1_.nextInt(100);
        if(i >= 80)
        {
            StructureBoundingBox structureboundingbox = ComponentMineshaftCross.func_74951_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
            if(structureboundingbox != null)
            {
                return new ComponentMineshaftCross(p_78815_6_, p_78815_1_, structureboundingbox, p_78815_5_);
            }
        } else
        if(i >= 70)
        {
            StructureBoundingBox structureboundingbox1 = ComponentMineshaftStairs.func_74950_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
            if(structureboundingbox1 != null)
            {
                return new ComponentMineshaftStairs(p_78815_6_, p_78815_1_, structureboundingbox1, p_78815_5_);
            }
        } else
        {
            StructureBoundingBox structureboundingbox2 = ComponentMineshaftCorridor.func_74954_a(p_78815_0_, p_78815_1_, p_78815_2_, p_78815_3_, p_78815_4_, p_78815_5_);
            if(structureboundingbox2 != null)
            {
                return new ComponentMineshaftCorridor(p_78815_6_, p_78815_1_, structureboundingbox2, p_78815_5_);
            }
        }
        return null;
    }

    private static StructureComponent func_78817_b(StructureComponent p_78817_0_, List p_78817_1_, Random p_78817_2_, int p_78817_3_, int p_78817_4_, int p_78817_5_, int p_78817_6_, int p_78817_7_)
    {
        if(p_78817_7_ > 8)
        {
            return null;
        }
        if(Math.abs(p_78817_3_ - p_78817_0_.func_74874_b().field_78897_a) > 80 || Math.abs(p_78817_5_ - p_78817_0_.func_74874_b().field_78896_c) > 80)
        {
            return null;
        }
        StructureComponent structurecomponent = func_78815_a(p_78817_1_, p_78817_2_, p_78817_3_, p_78817_4_, p_78817_5_, p_78817_6_, p_78817_7_ + 1);
        if(structurecomponent != null)
        {
            p_78817_1_.add(structurecomponent);
            structurecomponent.func_74861_a(p_78817_0_, p_78817_1_, p_78817_2_);
        }
        return structurecomponent;
    }

    static StructureComponent func_78814_a(StructureComponent p_78814_0_, List p_78814_1_, Random p_78814_2_, int p_78814_3_, int p_78814_4_, int p_78814_5_, int p_78814_6_, int p_78814_7_)
    {
        return func_78817_b(p_78814_0_, p_78814_1_, p_78814_2_, p_78814_3_, p_78814_4_, p_78814_5_, p_78814_6_, p_78814_7_);
    }

    static WeightedRandomChestContent[] func_78816_a()
    {
        return field_78818_a;
    }

    static 
    {
        field_78818_a = (new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 1, 3, 5), new WeightedRandomChestContent(Item.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new WeightedRandomChestContent(Item.field_77756_aW.field_77779_bT, 4, 4, 9, 5), new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 2, 3), new WeightedRandomChestContent(Item.field_77705_m.field_77779_bT, 0, 3, 8, 10), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77696_g.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Block.field_72056_aG.field_71990_ca, 0, 4, 8, 1), new WeightedRandomChestContent(Item.field_77740_bh.field_77779_bT, 0, 2, 4, 10), 
            new WeightedRandomChestContent(Item.field_77739_bg.field_77779_bT, 0, 2, 4, 10)
        });
    }
}
