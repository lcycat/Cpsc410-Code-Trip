// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureNetherBridgePieceWeight, ComponentNetherBridgeStartPiece, StructureNetherBridgePieces, 
//            ComponentNetherBridgeEnd, StructureBoundingBox

abstract class ComponentNetherBridgePiece extends StructureComponent
{

    protected ComponentNetherBridgePiece(int p_i3826_1_)
    {
        super(p_i3826_1_);
    }

    private int func_74960_a(List p_74960_1_)
    {
        boolean flag = false;
        int i = 0;
        for(Iterator iterator = p_74960_1_.iterator(); iterator.hasNext();)
        {
            StructureNetherBridgePieceWeight structurenetherbridgepieceweight = (StructureNetherBridgePieceWeight)iterator.next();
            if(structurenetherbridgepieceweight.field_78824_d > 0 && structurenetherbridgepieceweight.field_78827_c < structurenetherbridgepieceweight.field_78824_d)
            {
                flag = true;
            }
            i += structurenetherbridgepieceweight.field_78826_b;
        }

        return flag ? i : -1;
    }

    private ComponentNetherBridgePiece func_74959_a(ComponentNetherBridgeStartPiece p_74959_1_, List p_74959_2_, List p_74959_3_, Random p_74959_4_, int p_74959_5_, int p_74959_6_, int p_74959_7_, 
            int p_74959_8_, int p_74959_9_)
    {
        int i;
        boolean flag;
        int j;
        i = func_74960_a(p_74959_2_);
        flag = i > 0 && p_74959_9_ <= 30;
        j = 0;
_L2:
        int k;
        Iterator iterator;
        if(j >= 5 || !flag)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        j++;
        k = p_74959_4_.nextInt(i);
        iterator = p_74959_2_.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        StructureNetherBridgePieceWeight structurenetherbridgepieceweight;
        structurenetherbridgepieceweight = (StructureNetherBridgePieceWeight)iterator.next();
        k -= structurenetherbridgepieceweight.field_78826_b;
        if(k >= 0) goto _L4; else goto _L3
_L3:
        if(structurenetherbridgepieceweight.func_78822_a(p_74959_9_) && (structurenetherbridgepieceweight != p_74959_1_.field_74970_a || structurenetherbridgepieceweight.field_78825_e)) goto _L5; else goto _L2
_L5:
        ComponentNetherBridgePiece componentnetherbridgepiece = StructureNetherBridgePieces.func_78740_a(structurenetherbridgepieceweight, p_74959_3_, p_74959_4_, p_74959_5_, p_74959_6_, p_74959_7_, p_74959_8_, p_74959_9_);
        if(componentnetherbridgepiece == null) goto _L4; else goto _L6
_L6:
        structurenetherbridgepieceweight.field_78827_c++;
        p_74959_1_.field_74970_a = structurenetherbridgepieceweight;
        if(!structurenetherbridgepieceweight.func_78823_a())
        {
            p_74959_2_.remove(structurenetherbridgepieceweight);
        }
        return componentnetherbridgepiece;
        return ComponentNetherBridgeEnd.func_74971_a(p_74959_3_, p_74959_4_, p_74959_5_, p_74959_6_, p_74959_7_, p_74959_8_, p_74959_9_);
    }

    private StructureComponent func_74962_a(ComponentNetherBridgeStartPiece p_74962_1_, List p_74962_2_, Random p_74962_3_, int p_74962_4_, int p_74962_5_, int p_74962_6_, int p_74962_7_, 
            int p_74962_8_, boolean p_74962_9_)
    {
        if(Math.abs(p_74962_4_ - p_74962_1_.func_74874_b().field_78897_a) > 112 || Math.abs(p_74962_6_ - p_74962_1_.func_74874_b().field_78896_c) > 112)
        {
            return ComponentNetherBridgeEnd.func_74971_a(p_74962_2_, p_74962_3_, p_74962_4_, p_74962_5_, p_74962_6_, p_74962_7_, p_74962_8_);
        }
        List list = p_74962_1_.field_74968_b;
        if(p_74962_9_)
        {
            list = p_74962_1_.field_74969_c;
        }
        ComponentNetherBridgePiece componentnetherbridgepiece = func_74959_a(p_74962_1_, list, p_74962_2_, p_74962_3_, p_74962_4_, p_74962_5_, p_74962_6_, p_74962_7_, p_74962_8_ + 1);
        if(componentnetherbridgepiece != null)
        {
            p_74962_2_.add(componentnetherbridgepiece);
            p_74962_1_.field_74967_d.add(componentnetherbridgepiece);
        }
        return componentnetherbridgepiece;
    }

    protected StructureComponent func_74963_a(ComponentNetherBridgeStartPiece p_74963_1_, List p_74963_2_, Random p_74963_3_, int p_74963_4_, int p_74963_5_, boolean p_74963_6_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, field_74887_e.field_78897_a + p_74963_4_, field_74887_e.field_78895_b + p_74963_5_, field_74887_e.field_78896_c - 1, field_74885_f, func_74877_c(), p_74963_6_);

        case 0: // '\0'
            return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, field_74887_e.field_78897_a + p_74963_4_, field_74887_e.field_78895_b + p_74963_5_, field_74887_e.field_78892_f + 1, field_74885_f, func_74877_c(), p_74963_6_);

        case 1: // '\001'
            return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74963_5_, field_74887_e.field_78896_c + p_74963_4_, field_74885_f, func_74877_c(), p_74963_6_);

        case 3: // '\003'
            return func_74962_a(p_74963_1_, p_74963_2_, p_74963_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74963_5_, field_74887_e.field_78896_c + p_74963_4_, field_74885_f, func_74877_c(), p_74963_6_);
        }
        return null;
    }

    protected StructureComponent func_74961_b(ComponentNetherBridgeStartPiece p_74961_1_, List p_74961_2_, Random p_74961_3_, int p_74961_4_, int p_74961_5_, boolean p_74961_6_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74961_4_, field_74887_e.field_78896_c + p_74961_5_, 1, func_74877_c(), p_74961_6_);

        case 0: // '\0'
            return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74961_4_, field_74887_e.field_78896_c + p_74961_5_, 1, func_74877_c(), p_74961_6_);

        case 1: // '\001'
            return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, field_74887_e.field_78897_a + p_74961_5_, field_74887_e.field_78895_b + p_74961_4_, field_74887_e.field_78896_c - 1, 2, func_74877_c(), p_74961_6_);

        case 3: // '\003'
            return func_74962_a(p_74961_1_, p_74961_2_, p_74961_3_, field_74887_e.field_78897_a + p_74961_5_, field_74887_e.field_78895_b + p_74961_4_, field_74887_e.field_78896_c - 1, 2, func_74877_c(), p_74961_6_);
        }
        return null;
    }

    protected StructureComponent func_74965_c(ComponentNetherBridgeStartPiece p_74965_1_, List p_74965_2_, Random p_74965_3_, int p_74965_4_, int p_74965_5_, boolean p_74965_6_)
    {
        switch(field_74885_f)
        {
        case 2: // '\002'
            return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74965_4_, field_74887_e.field_78896_c + p_74965_5_, 3, func_74877_c(), p_74965_6_);

        case 0: // '\0'
            return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74965_4_, field_74887_e.field_78896_c + p_74965_5_, 3, func_74877_c(), p_74965_6_);

        case 1: // '\001'
            return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, field_74887_e.field_78897_a + p_74965_5_, field_74887_e.field_78895_b + p_74965_4_, field_74887_e.field_78892_f + 1, 0, func_74877_c(), p_74965_6_);

        case 3: // '\003'
            return func_74962_a(p_74965_1_, p_74965_2_, p_74965_3_, field_74887_e.field_78897_a + p_74965_5_, field_74887_e.field_78895_b + p_74965_4_, field_74887_e.field_78892_f + 1, 0, func_74877_c(), p_74965_6_);
        }
        return null;
    }

    protected static boolean func_74964_a(StructureBoundingBox p_74964_0_)
    {
        return p_74964_0_ != null && p_74964_0_.field_78895_b > 10;
    }
}
