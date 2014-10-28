// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, BlockHalfSlab, 
//            WeightedRandomChestContent, Item, World

public class ComponentStrongholdChestCorridor extends ComponentStronghold
{

    private static final WeightedRandomChestContent field_75003_a[];
    private final EnumDoor field_75001_b;
    private boolean field_75002_c;

    public ComponentStrongholdChestCorridor(int p_i3840_1_, Random p_i3840_2_, StructureBoundingBox p_i3840_3_, int p_i3840_4_)
    {
        super(p_i3840_1_);
        field_74885_f = p_i3840_4_;
        field_75001_b = func_74988_a(p_i3840_2_);
        field_74887_e = p_i3840_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        func_74986_a((ComponentStrongholdStairs2)p_74861_1_, p_74861_2_, p_74861_3_, 1, 1);
    }

    public static ComponentStrongholdChestCorridor func_75000_a(List p_75000_0_, Random p_75000_1_, int p_75000_2_, int p_75000_3_, int p_75000_4_, int p_75000_5_, int p_75000_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75000_2_, p_75000_3_, p_75000_4_, -1, -1, 0, 5, 5, 7, p_75000_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75000_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdChestCorridor(p_75000_6_, p_75000_1_, structureboundingbox, p_75000_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 4, 4, 6, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, field_75001_b, 1, 1, 0);
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.OPENING, 1, 1, 6);
        func_74884_a(p_74875_1_, p_74875_3_, 3, 1, 2, 3, 1, 4, Block.field_72007_bm.field_71990_ca, Block.field_72007_bm.field_71990_ca, false);
        func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 1, 1, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 1, 5, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 2, 2, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 3, 2, 4, p_74875_3_);
        for(int i = 2; i <= 4; i++)
        {
            func_74864_a(p_74875_1_, Block.field_72079_ak.field_71990_ca, 5, 2, 1, i, p_74875_3_);
        }

        if(!field_75002_c)
        {
            int j = func_74862_a(2);
            int k = func_74865_a(3, 3);
            int l = func_74873_b(3, 3);
            if(p_74875_3_.func_78890_b(k, j, l))
            {
                field_75002_c = true;
                func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 2, 3, field_75003_a, 2 + p_74875_2_.nextInt(2));
            }
        }
        return true;
    }

    static 
    {
        field_75003_a = (new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.field_77730_bn.field_77779_bT, 0, 1, 1, 10), new WeightedRandomChestContent(Item.field_77702_n.field_77779_bT, 0, 1, 3, 3), new WeightedRandomChestContent(Item.field_77703_o.field_77779_bT, 0, 1, 5, 10), new WeightedRandomChestContent(Item.field_77717_p.field_77779_bT, 0, 1, 3, 5), new WeightedRandomChestContent(Item.field_77767_aC.field_77779_bT, 0, 4, 9, 5), new WeightedRandomChestContent(Item.field_77684_U.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77706_j.field_77779_bT, 0, 1, 3, 15), new WeightedRandomChestContent(Item.field_77696_g.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77716_q.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77822_ae.field_77779_bT, 0, 1, 1, 5), 
            new WeightedRandomChestContent(Item.field_77812_ad.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77824_af.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77818_ag.field_77779_bT, 0, 1, 1, 5), new WeightedRandomChestContent(Item.field_77778_at.field_77779_bT, 0, 1, 1, 1)
        });
    }
}
