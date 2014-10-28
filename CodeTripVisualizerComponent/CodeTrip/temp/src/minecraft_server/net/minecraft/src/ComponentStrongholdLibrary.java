// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, StructureBoundingBox, StructureComponent, StructureStrongholdPieces, 
//            Block, WeightedRandomChestContent, Item, ItemMap, 
//            EnumDoor, World

public class ComponentStrongholdLibrary extends ComponentStronghold
{

    private static final WeightedRandomChestContent field_75007_b[];
    protected final EnumDoor field_75009_a;
    private final boolean field_75008_c;

    public ComponentStrongholdLibrary(int p_i3844_1_, Random p_i3844_2_, StructureBoundingBox p_i3844_3_, int p_i3844_4_)
    {
        super(p_i3844_1_);
        field_74885_f = p_i3844_4_;
        field_75009_a = func_74988_a(p_i3844_2_);
        field_74887_e = p_i3844_3_;
        field_75008_c = p_i3844_3_.func_78882_c() > 6;
    }

    public static ComponentStrongholdLibrary func_75006_a(List p_75006_0_, Random p_75006_1_, int p_75006_2_, int p_75006_3_, int p_75006_4_, int p_75006_5_, int p_75006_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 11, 15, p_75006_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75006_0_, structureboundingbox) != null)
        {
            structureboundingbox = StructureBoundingBox.func_78889_a(p_75006_2_, p_75006_3_, p_75006_4_, -4, -1, 0, 14, 6, 15, p_75006_5_);
            if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75006_0_, structureboundingbox) != null)
            {
                return null;
            }
        }
        return new ComponentStrongholdLibrary(p_75006_6_, p_75006_1_, structureboundingbox, p_75006_5_);
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        byte byte0 = 11;
        if(!field_75008_c)
        {
            byte0 = 6;
        }
        func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 13, byte0 - 1, 14, true, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, field_75009_a, 4, 1, 0);
        func_74880_a(p_74875_1_, p_74875_3_, p_74875_2_, 0.07F, 2, 1, 1, 11, 4, 13, Block.field_71955_W.field_71990_ca, Block.field_71955_W.field_71990_ca, false);
        for(int i = 1; i <= 13; i++)
        {
            if((i - 1) % 4 == 0)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                func_74884_a(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 2, 3, i, p_74875_3_);
                func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, 11, 3, i, p_74875_3_);
                if(field_75008_c)
                {
                    func_74884_a(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                    func_74884_a(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
                }
                continue;
            }
            func_74884_a(p_74875_1_, p_74875_3_, 1, 1, i, 1, 4, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 12, 1, i, 12, 4, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            if(field_75008_c)
            {
                func_74884_a(p_74875_1_, p_74875_3_, 1, 6, i, 1, 9, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
                func_74884_a(p_74875_1_, p_74875_3_, 12, 6, i, 12, 9, i, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            }
        }

        for(int j = 3; j < 12; j += 2)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 3, 1, j, 4, 3, j, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 6, 1, j, 7, 3, j, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 9, 1, j, 10, 3, j, Block.field_72093_an.field_71990_ca, Block.field_72093_an.field_71990_ca, false);
        }

        if(field_75008_c)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 1, 5, 1, 3, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 10, 5, 1, 12, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 1, 9, 5, 2, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 4, 5, 12, 9, 5, 13, Block.field_71988_x.field_71990_ca, Block.field_71988_x.field_71990_ca, false);
            func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 9, 5, 11, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 8, 5, 11, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71988_x.field_71990_ca, 0, 9, 5, 10, p_74875_3_);
            func_74884_a(p_74875_1_, p_74875_3_, 3, 6, 2, 3, 6, 12, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 10, 6, 2, 10, 6, 10, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 4, 6, 2, 9, 6, 2, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 4, 6, 12, 8, 6, 12, Block.field_72031_aZ.field_71990_ca, Block.field_72031_aZ.field_71990_ca, false);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 9, 6, 11, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 8, 6, 11, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, 9, 6, 10, p_74875_3_);
            int k = func_74863_c(Block.field_72055_aF.field_71990_ca, 3);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 1, 13, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 2, 13, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 3, 13, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 4, 13, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 5, 13, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 6, 13, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72055_aF.field_71990_ca, k, 10, 7, 13, p_74875_3_);
            byte byte1 = 7;
            byte byte2 = 7;
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 - 1, 9, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1, 9, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 - 1, 8, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1, 8, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 - 1, 7, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1, 7, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 - 2, 7, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 + 1, 7, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 - 1, 7, byte2 - 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1 - 1, 7, byte2 + 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1, 7, byte2 - 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72031_aZ.field_71990_ca, 0, byte1, 7, byte2 + 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, byte1 - 2, 8, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, byte1 + 1, 8, byte2, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, byte1 - 1, 8, byte2 - 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, byte1 - 1, 8, byte2 + 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, byte1, 8, byte2 - 1, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_72069_aq.field_71990_ca, 0, byte1, 8, byte2 + 1, p_74875_3_);
        }
        func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 3, 3, 5, field_75007_b, 1 + p_74875_2_.nextInt(4));
        if(field_75008_c)
        {
            func_74864_a(p_74875_1_, 0, 0, 12, 9, 1, p_74875_3_);
            func_74879_a(p_74875_1_, p_74875_3_, p_74875_2_, 12, 8, 1, field_75007_b, 1 + p_74875_2_.nextInt(4));
        }
        return true;
    }

    static 
    {
        field_75007_b = (new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.field_77760_aL.field_77779_bT, 0, 1, 3, 20), new WeightedRandomChestContent(Item.field_77759_aK.field_77779_bT, 0, 2, 7, 20), new WeightedRandomChestContent(Item.field_77744_bd.field_77779_bT, 0, 1, 1, 1), new WeightedRandomChestContent(Item.field_77750_aQ.field_77779_bT, 0, 1, 1, 1)
        });
    }
}
