// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, EnumDoorHelper, EnumDoor, Block, 
//            StructureBoundingBox, StructureStrongholdPieces, World, ComponentStrongholdStairs2

abstract class ComponentStronghold extends StructureComponent
{

    protected ComponentStronghold(int p_i3856_1_)
    {
        super(p_i3856_1_);
    }

    protected void func_74990_a(World p_74990_1_, Random p_74990_2_, StructureBoundingBox p_74990_3_, EnumDoor p_74990_4_, int p_74990_5_, int p_74990_6_, int p_74990_7_)
    {
        switch(EnumDoorHelper.field_75245_a[p_74990_4_.ordinal()])
        {
        case 1: // '\001'
        default:
            func_74884_a(p_74990_1_, p_74990_3_, p_74990_5_, p_74990_6_, p_74990_7_, (p_74990_5_ + 3) - 1, (p_74990_6_ + 3) - 1, p_74990_7_, 0, 0, false);
            break;

        case 2: // '\002'
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72054_aE.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72054_aE.field_71990_ca, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            break;

        case 3: // '\003'
            func_74864_a(p_74990_1_, 0, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, 0, 0, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72002_bp.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            break;

        case 4: // '\004'
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 2, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72007_bm.field_71990_ca, 0, p_74990_5_ + 2, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72045_aL.field_71990_ca, 0, p_74990_5_ + 1, p_74990_6_, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72045_aL.field_71990_ca, 8, p_74990_5_ + 1, p_74990_6_ + 1, p_74990_7_, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72034_aR.field_71990_ca, func_74863_c(Block.field_72034_aR.field_71990_ca, 4), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ + 1, p_74990_3_);
            func_74864_a(p_74990_1_, Block.field_72034_aR.field_71990_ca, func_74863_c(Block.field_72034_aR.field_71990_ca, 3), p_74990_5_ + 2, p_74990_6_ + 1, p_74990_7_ - 1, p_74990_3_);
            break;
        }
    }

    protected EnumDoor func_74988_a(Random p_74988_1_)
    {
        int i = p_74988_1_.nextInt(5);
        switch(i)
        {
        case 0: // '\0'
        case 1: // '\001'
        default:
            return EnumDoor.OPENING;

        case 2: // '\002'
            return EnumDoor.WOOD_DOOR;

        case 3: // '\003'
            return EnumDoor.GRATES;

        case 4: // '\004'
            return EnumDoor.IRON_DOOR;
        }
    }

    protected StructureComponent func_74986_a(ComponentStrongholdStairs2 p_74986_1_, List p_74986_2_, Random p_74986_3_, int p_74986_4_, int p_74986_5_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, field_74887_e.field_78897_a + p_74986_4_, field_74887_e.field_78895_b + p_74986_5_, field_74887_e.field_78896_c - 1, field_74885_f, func_74877_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, field_74887_e.field_78897_a + p_74986_4_, field_74887_e.field_78895_b + p_74986_5_, field_74887_e.field_78892_f + 1, field_74885_f, func_74877_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74986_5_, field_74887_e.field_78896_c + p_74986_4_, field_74885_f, func_74877_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_75195_a(p_74986_1_, p_74986_2_, p_74986_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74986_5_, field_74887_e.field_78896_c + p_74986_4_, field_74885_f, func_74877_c());
        }
        return null;
    }

    protected StructureComponent func_74989_b(ComponentStrongholdStairs2 p_74989_1_, List p_74989_2_, Random p_74989_3_, int p_74989_4_, int p_74989_5_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74989_4_, field_74887_e.field_78896_c + p_74989_5_, 1, func_74877_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74989_4_, field_74887_e.field_78896_c + p_74989_5_, 1, func_74877_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, field_74887_e.field_78897_a + p_74989_5_, field_74887_e.field_78895_b + p_74989_4_, field_74887_e.field_78896_c - 1, 2, func_74877_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_75195_a(p_74989_1_, p_74989_2_, p_74989_3_, field_74887_e.field_78897_a + p_74989_5_, field_74887_e.field_78895_b + p_74989_4_, field_74887_e.field_78896_c - 1, 2, func_74877_c());
        }
        return null;
    }

    protected StructureComponent func_74987_c(ComponentStrongholdStairs2 p_74987_1_, List p_74987_2_, Random p_74987_3_, int p_74987_4_, int p_74987_5_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74987_4_, field_74887_e.field_78896_c + p_74987_5_, 3, func_74877_c());

        case 0: // '\0'
            return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74987_4_, field_74887_e.field_78896_c + p_74987_5_, 3, func_74877_c());

        case 1: // '\001'
            return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, field_74887_e.field_78897_a + p_74987_5_, field_74887_e.field_78895_b + p_74987_4_, field_74887_e.field_78892_f + 1, 0, func_74877_c());

        case 3: // '\003'
            return StructureStrongholdPieces.func_75195_a(p_74987_1_, p_74987_2_, p_74987_3_, field_74887_e.field_78897_a + p_74987_5_, field_74887_e.field_78895_b + p_74987_4_, field_74887_e.field_78892_f + 1, 0, func_74877_c());
        }
        return null;
    }

    protected static boolean func_74991_a(StructureBoundingBox p_74991_0_)
    {
        return p_74991_0_ != null && p_74991_0_.field_78895_b > 10;
    }
}
