// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStrongholdPieceWeight, ComponentStrongholdStraight, ComponentStrongholdPrison, ComponentStrongholdLeftTurn, 
//            ComponentStrongholdRightTurn, ComponentStrongholdRoomCrossing, ComponentStrongholdStairsStraight, ComponentStrongholdStairs, 
//            ComponentStrongholdCrossing, ComponentStrongholdChestCorridor, ComponentStrongholdLibrary, ComponentStrongholdPortalRoom, 
//            ComponentStrongholdStairs2, ComponentStrongholdCorridor, StructureBoundingBox, StructureStrongholdPieceWeight2, 
//            StructureStrongholdPieceWeight3, StructureStrongholdStones, ComponentStronghold, StructureComponent

public class StructureStrongholdPieces
{

    private static final StructureStrongholdPieceWeight field_75205_b[];
    private static List field_75206_c;
    private static Class field_75203_d;
    static int field_75207_a = 0;
    private static final StructureStrongholdStones field_75204_e = new StructureStrongholdStones(null);

    public static void func_75198_a()
    {
        field_75206_c = new ArrayList();
        StructureStrongholdPieceWeight astructurestrongholdpieceweight[] = field_75205_b;
        int i = astructurestrongholdpieceweight.length;
        for(int j = 0; j < i; j++)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = astructurestrongholdpieceweight[j];
            structurestrongholdpieceweight.field_75193_c = 0;
            field_75206_c.add(structurestrongholdpieceweight);
        }

        field_75203_d = null;
    }

    private static boolean func_75202_c()
    {
        boolean flag = false;
        field_75207_a = 0;
        for(Iterator iterator = field_75206_c.iterator(); iterator.hasNext();)
        {
            StructureStrongholdPieceWeight structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();
            if(structurestrongholdpieceweight.field_75191_d > 0 && structurestrongholdpieceweight.field_75193_c < structurestrongholdpieceweight.field_75191_d)
            {
                flag = true;
            }
            field_75207_a += structurestrongholdpieceweight.field_75192_b;
        }

        return flag;
    }

    private static ComponentStronghold func_75200_a(Class p_75200_0_, List p_75200_1_, Random p_75200_2_, int p_75200_3_, int p_75200_4_, int p_75200_5_, int p_75200_6_, int p_75200_7_)
    {
        Object obj = null;
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdStraight.class))
        {
            obj = ComponentStrongholdStraight.func_75018_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdPrison.class))
        {
            obj = ComponentStrongholdPrison.func_75016_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdLeftTurn.class))
        {
            obj = ComponentStrongholdLeftTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdRightTurn.class))
        {
            obj = ComponentStrongholdRightTurn.func_75010_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdRoomCrossing.class))
        {
            obj = ComponentStrongholdRoomCrossing.func_75012_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdStairsStraight.class))
        {
            obj = ComponentStrongholdStairsStraight.func_75028_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdStairs.class))
        {
            obj = ComponentStrongholdStairs.func_75022_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdCrossing.class))
        {
            obj = ComponentStrongholdCrossing.func_74994_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdChestCorridor.class))
        {
            obj = ComponentStrongholdChestCorridor.func_75000_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdLibrary.class))
        {
            obj = ComponentStrongholdLibrary.func_75006_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        } else
        if(p_75200_0_ == (net.minecraft.src.ComponentStrongholdPortalRoom.class))
        {
            obj = ComponentStrongholdPortalRoom.func_75004_a(p_75200_1_, p_75200_2_, p_75200_3_, p_75200_4_, p_75200_5_, p_75200_6_, p_75200_7_);
        }
        return ((ComponentStronghold) (obj));
    }

    private static ComponentStronghold func_75201_b(ComponentStrongholdStairs2 p_75201_0_, List p_75201_1_, Random p_75201_2_, int p_75201_3_, int p_75201_4_, int p_75201_5_, int p_75201_6_, int p_75201_7_)
    {
        int i;
        if(!func_75202_c())
        {
            return null;
        }
        if(field_75203_d != null)
        {
            ComponentStronghold componentstronghold = func_75200_a(field_75203_d, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
            field_75203_d = null;
            if(componentstronghold != null)
            {
                return componentstronghold;
            }
        }
        i = 0;
_L2:
        int j;
        Iterator iterator;
        if(i >= 5)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        i++;
        j = p_75201_2_.nextInt(field_75207_a);
        iterator = field_75206_c.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        StructureStrongholdPieceWeight structurestrongholdpieceweight;
        structurestrongholdpieceweight = (StructureStrongholdPieceWeight)iterator.next();
        j -= structurestrongholdpieceweight.field_75192_b;
        if(j >= 0) goto _L4; else goto _L3
_L3:
        if(structurestrongholdpieceweight.func_75189_a(p_75201_7_) && structurestrongholdpieceweight != p_75201_0_.field_75027_a) goto _L5; else goto _L2
_L5:
        ComponentStronghold componentstronghold1 = func_75200_a(structurestrongholdpieceweight.field_75194_a, p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_, p_75201_7_);
        if(componentstronghold1 == null) goto _L4; else goto _L6
_L6:
        structurestrongholdpieceweight.field_75193_c++;
        p_75201_0_.field_75027_a = structurestrongholdpieceweight;
        if(!structurestrongholdpieceweight.func_75190_a())
        {
            field_75206_c.remove(structurestrongholdpieceweight);
        }
        return componentstronghold1;
        StructureBoundingBox structureboundingbox = ComponentStrongholdCorridor.func_74992_a(p_75201_1_, p_75201_2_, p_75201_3_, p_75201_4_, p_75201_5_, p_75201_6_);
        if(structureboundingbox != null && structureboundingbox.field_78895_b > 1)
        {
            return new ComponentStrongholdCorridor(p_75201_7_, p_75201_2_, structureboundingbox, p_75201_6_);
        } else
        {
            return null;
        }
    }

    private static StructureComponent func_75196_c(ComponentStrongholdStairs2 p_75196_0_, List p_75196_1_, Random p_75196_2_, int p_75196_3_, int p_75196_4_, int p_75196_5_, int p_75196_6_, int p_75196_7_)
    {
        if(p_75196_7_ > 50)
        {
            return null;
        }
        if(Math.abs(p_75196_3_ - p_75196_0_.func_74874_b().field_78897_a) > 112 || Math.abs(p_75196_5_ - p_75196_0_.func_74874_b().field_78896_c) > 112)
        {
            return null;
        }
        ComponentStronghold componentstronghold = func_75201_b(p_75196_0_, p_75196_1_, p_75196_2_, p_75196_3_, p_75196_4_, p_75196_5_, p_75196_6_, p_75196_7_ + 1);
        if(componentstronghold != null)
        {
            p_75196_1_.add(componentstronghold);
            p_75196_0_.field_75026_c.add(componentstronghold);
        }
        return componentstronghold;
    }

    static StructureComponent func_75195_a(ComponentStrongholdStairs2 p_75195_0_, List p_75195_1_, Random p_75195_2_, int p_75195_3_, int p_75195_4_, int p_75195_5_, int p_75195_6_, int p_75195_7_)
    {
        return func_75196_c(p_75195_0_, p_75195_1_, p_75195_2_, p_75195_3_, p_75195_4_, p_75195_5_, p_75195_6_, p_75195_7_);
    }

    static Class func_75199_a(Class p_75199_0_)
    {
        return field_75203_d = p_75199_0_;
    }

    static StructureStrongholdStones func_75197_b()
    {
        return field_75204_e;
    }

    static 
    {
        field_75205_b = (new StructureStrongholdPieceWeight[] {
            new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStraight.class, 40, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdPrison.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdLeftTurn.class, 20, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdRightTurn.class, 20, 0), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdRoomCrossing.class, 10, 6), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStairsStraight.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdStairs.class, 5, 5), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdCrossing.class, 5, 4), new StructureStrongholdPieceWeight(net.minecraft.src.ComponentStrongholdChestCorridor.class, 5, 4), new StructureStrongholdPieceWeight2(net.minecraft.src.ComponentStrongholdLibrary.class, 10, 2), 
            new StructureStrongholdPieceWeight3(net.minecraft.src.ComponentStrongholdPortalRoom.class, 20, 1)
        });
    }
}
