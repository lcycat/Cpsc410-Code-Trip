// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, ComponentNetherBridgeStartPiece, StructureComponent, World

class StructureNetherBridgeStart extends StructureStart
{

    public StructureNetherBridgeStart(World p_i3812_1_, Random p_i3812_2_, int p_i3812_3_, int p_i3812_4_)
    {
        ComponentNetherBridgeStartPiece componentnetherbridgestartpiece = new ComponentNetherBridgeStartPiece(p_i3812_2_, (p_i3812_3_ << 4) + 2, (p_i3812_4_ << 4) + 2);
        field_75075_a.add(componentnetherbridgestartpiece);
        componentnetherbridgestartpiece.func_74861_a(componentnetherbridgestartpiece, field_75075_a, p_i3812_2_);
        StructureComponent structurecomponent;
        for(ArrayList arraylist = componentnetherbridgestartpiece.field_74967_d; !arraylist.isEmpty(); structurecomponent.func_74861_a(componentnetherbridgestartpiece, field_75075_a, p_i3812_2_))
        {
            int i = p_i3812_2_.nextInt(arraylist.size());
            structurecomponent = (StructureComponent)arraylist.remove(i);
        }

        func_75072_c();
        func_75070_a(p_i3812_1_, p_i3812_2_, 48, 70);
    }
}
