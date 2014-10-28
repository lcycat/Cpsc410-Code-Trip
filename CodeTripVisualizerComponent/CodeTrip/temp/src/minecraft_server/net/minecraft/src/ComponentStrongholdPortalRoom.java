// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            ComponentStronghold, ComponentStrongholdStairs2, StructureBoundingBox, StructureComponent, 
//            StructureStrongholdPieces, EnumDoor, Block, World, 
//            TileEntityMobSpawner

public class ComponentStrongholdPortalRoom extends ComponentStronghold
{

    private boolean field_75005_a;

    public ComponentStrongholdPortalRoom(int p_i3846_1_, Random p_i3846_2_, StructureBoundingBox p_i3846_3_, int p_i3846_4_)
    {
        super(p_i3846_1_);
        field_74885_f = p_i3846_4_;
        field_74887_e = p_i3846_3_;
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        if(p_74861_1_ != null)
        {
            ((ComponentStrongholdStairs2)p_74861_1_).field_75025_b = this;
        }
    }

    public static ComponentStrongholdPortalRoom func_75004_a(List p_75004_0_, Random p_75004_1_, int p_75004_2_, int p_75004_3_, int p_75004_4_, int p_75004_5_, int p_75004_6_)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.func_78889_a(p_75004_2_, p_75004_3_, p_75004_4_, -4, -1, 0, 11, 8, 16, p_75004_5_);
        if(!func_74991_a(structureboundingbox) || StructureComponent.func_74883_a(p_75004_0_, structureboundingbox) != null)
        {
            return null;
        } else
        {
            return new ComponentStrongholdPortalRoom(p_75004_6_, p_75004_1_, structureboundingbox, p_75004_5_);
        }
    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        func_74882_a(p_74875_1_, p_74875_3_, 0, 0, 0, 10, 7, 15, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74990_a(p_74875_1_, p_74875_2_, p_74875_3_, EnumDoor.GRATES, 4, 1, 0);
        byte byte0 = 6;
        func_74882_a(p_74875_1_, p_74875_3_, 1, byte0, 1, 1, byte0, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 9, byte0, 1, 9, byte0, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 2, byte0, 1, 8, byte0, 2, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 2, byte0, 14, 8, byte0, 14, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 1, 1, 1, 2, 1, 4, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 8, 1, 1, 9, 1, 4, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74884_a(p_74875_1_, p_74875_3_, 1, 1, 1, 1, 1, 3, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
        func_74884_a(p_74875_1_, p_74875_3_, 9, 1, 1, 9, 1, 3, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
        func_74882_a(p_74875_1_, p_74875_3_, 3, 1, 8, 7, 1, 12, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74884_a(p_74875_1_, p_74875_3_, 4, 1, 9, 6, 1, 11, Block.field_71944_C.field_71990_ca, Block.field_71944_C.field_71990_ca, false);
        for(int j = 3; j < 14; j += 2)
        {
            func_74884_a(p_74875_1_, p_74875_3_, 0, 3, j, 0, 4, j, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
            func_74884_a(p_74875_1_, p_74875_3_, 10, 3, j, 10, 4, j, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
        }

        for(int k = 2; k < 9; k += 2)
        {
            func_74884_a(p_74875_1_, p_74875_3_, k, 3, 15, k, 4, 15, Block.field_72002_bp.field_71990_ca, Block.field_72002_bp.field_71990_ca, false);
        }

        int l = func_74863_c(Block.field_71995_bx.field_71990_ca, 3);
        func_74882_a(p_74875_1_, p_74875_3_, 4, 1, 5, 6, 1, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 4, 2, 6, 6, 2, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        func_74882_a(p_74875_1_, p_74875_3_, 4, 3, 7, 6, 3, 7, false, p_74875_2_, StructureStrongholdPieces.func_75197_b());
        for(int i1 = 4; i1 <= 6; i1++)
        {
            func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, l, i1, 1, 4, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, l, i1, 2, 5, p_74875_3_);
            func_74864_a(p_74875_1_, Block.field_71995_bx.field_71990_ca, l, i1, 3, 6, p_74875_3_);
        }

        byte byte1 = 2;
        byte byte2 = 0;
        byte byte3 = 3;
        byte byte4 = 1;
        switch(field_74885_f)
        {
        case 0: // '\0'
            byte1 = 0;
            byte2 = 2;
            break;

        case 3: // '\003'
            byte1 = 3;
            byte2 = 1;
            byte3 = 0;
            byte4 = 2;
            break;

        case 1: // '\001'
            byte1 = 1;
            byte2 = 3;
            byte3 = 0;
            byte4 = 2;
            break;
        }
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte1 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 4, 3, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte1 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 5, 3, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte1 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 6, 3, 8, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte2 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 4, 3, 12, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte2 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 5, 3, 12, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte2 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 6, 3, 12, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte3 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 3, 3, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte3 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 3, 3, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte3 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 3, 3, 11, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte4 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 7, 3, 9, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte4 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 7, 3, 10, p_74875_3_);
        func_74864_a(p_74875_1_, Block.field_72104_bI.field_71990_ca, byte4 + (p_74875_2_.nextFloat() <= 0.9F ? 0 : 4), 7, 3, 11, p_74875_3_);
        if(!field_75005_a)
        {
            int i = func_74862_a(3);
            int j1 = func_74865_a(5, 6);
            int k1 = func_74873_b(5, 6);
            if(p_74875_3_.func_78890_b(j1, i, k1))
            {
                field_75005_a = true;
                p_74875_1_.func_72859_e(j1, i, k1, Block.field_72065_as.field_71990_ca);
                TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)p_74875_1_.func_72796_p(j1, i, k1);
                if(tileentitymobspawner != null)
                {
                    tileentitymobspawner.func_70385_a("Silverfish");
                }
            }
        }
        return true;
    }
}
