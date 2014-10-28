// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            StructureNetherBridgePieceWeight, ComponentNetherBridgeStraight, ComponentNetherBridgeCrossing3, ComponentNetherBridgeCrossing, 
//            ComponentNetherBridgeStairs, ComponentNetherBridgeThrone, ComponentNetherBridgeEntrance, ComponentNetherBridgeCorridor5, 
//            ComponentNetherBridgeCorridor2, ComponentNetherBridgeCorridor, ComponentNetherBridgeCorridor3, ComponentNetherBridgeCorridor4, 
//            ComponentNetherBridgeCrossing2, ComponentNetherBridgeNetherStalkRoom, ComponentNetherBridgePiece

public class StructureNetherBridgePieces
{

    private static final StructureNetherBridgePieceWeight field_78742_a[];
    private static final StructureNetherBridgePieceWeight field_78741_b[];

    private static ComponentNetherBridgePiece func_78738_b(StructureNetherBridgePieceWeight p_78738_0_, List p_78738_1_, Random p_78738_2_, int p_78738_3_, int p_78738_4_, int p_78738_5_, int p_78738_6_, int p_78738_7_)
    {
        Class class1 = p_78738_0_.field_78828_a;
        Object obj = null;
        if(class1 == (net.minecraft.src.ComponentNetherBridgeStraight.class))
        {
            obj = ComponentNetherBridgeStraight.func_74983_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCrossing3.class))
        {
            obj = ComponentNetherBridgeCrossing3.func_74966_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCrossing.class))
        {
            obj = ComponentNetherBridgeCrossing.func_74974_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeStairs.class))
        {
            obj = ComponentNetherBridgeStairs.func_74973_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeThrone.class))
        {
            obj = ComponentNetherBridgeThrone.func_74975_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeEntrance.class))
        {
            obj = ComponentNetherBridgeEntrance.func_74984_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCorridor5.class))
        {
            obj = ComponentNetherBridgeCorridor5.func_74981_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCorridor2.class))
        {
            obj = ComponentNetherBridgeCorridor2.func_74980_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCorridor.class))
        {
            obj = ComponentNetherBridgeCorridor.func_74978_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCorridor3.class))
        {
            obj = ComponentNetherBridgeCorridor3.func_74982_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCorridor4.class))
        {
            obj = ComponentNetherBridgeCorridor4.func_74985_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeCrossing2.class))
        {
            obj = ComponentNetherBridgeCrossing2.func_74979_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        } else
        if(class1 == (net.minecraft.src.ComponentNetherBridgeNetherStalkRoom.class))
        {
            obj = ComponentNetherBridgeNetherStalkRoom.func_74977_a(p_78738_1_, p_78738_2_, p_78738_3_, p_78738_4_, p_78738_5_, p_78738_6_, p_78738_7_);
        }
        return ((ComponentNetherBridgePiece) (obj));
    }

    static ComponentNetherBridgePiece func_78740_a(StructureNetherBridgePieceWeight p_78740_0_, List p_78740_1_, Random p_78740_2_, int p_78740_3_, int p_78740_4_, int p_78740_5_, int p_78740_6_, int p_78740_7_)
    {
        return func_78738_b(p_78740_0_, p_78740_1_, p_78740_2_, p_78740_3_, p_78740_4_, p_78740_5_, p_78740_6_, p_78740_7_);
    }

    static StructureNetherBridgePieceWeight[] func_78739_a()
    {
        return field_78742_a;
    }

    static StructureNetherBridgePieceWeight[] func_78737_b()
    {
        return field_78741_b;
    }

    static 
    {
        field_78742_a = (new StructureNetherBridgePieceWeight[] {
            new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeStraight.class, 30, 0, true), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCrossing3.class, 10, 4), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCrossing.class, 10, 4), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeStairs.class, 10, 3), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeThrone.class, 5, 2), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeEntrance.class, 5, 1)
        });
        field_78741_b = (new StructureNetherBridgePieceWeight[] {
            new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCorridor5.class, 25, 0, true), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCrossing2.class, 15, 5), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCorridor2.class, 5, 10), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCorridor.class, 5, 10), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCorridor3.class, 10, 3, true), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeCorridor4.class, 7, 2), new StructureNetherBridgePieceWeight(net.minecraft.src.ComponentNetherBridgeNetherStalkRoom.class, 5, 2)
        });
    }
}
