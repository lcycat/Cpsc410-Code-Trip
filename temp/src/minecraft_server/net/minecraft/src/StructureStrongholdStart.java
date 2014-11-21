// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, StructureStrongholdPieces, ComponentStrongholdStairs2, StructureComponent, 
//            World

class StructureStrongholdStart extends StructureStart
{

    public StructureStrongholdStart(World p_i3837_1_, Random p_i3837_2_, int p_i3837_3_, int p_i3837_4_)
    {
        StructureStrongholdPieces.func_75198_a();
        ComponentStrongholdStairs2 componentstrongholdstairs2 = new ComponentStrongholdStairs2(0, p_i3837_2_, (p_i3837_3_ << 4) + 2, (p_i3837_4_ << 4) + 2);
        field_75075_a.add(componentstrongholdstairs2);
        componentstrongholdstairs2.func_74861_a(componentstrongholdstairs2, field_75075_a, p_i3837_2_);
        StructureComponent structurecomponent;
        for(ArrayList arraylist = componentstrongholdstairs2.field_75026_c; !arraylist.isEmpty(); structurecomponent.func_74861_a(componentstrongholdstairs2, field_75075_a, p_i3837_2_))
        {
            int i = p_i3837_2_.nextInt(arraylist.size());
            structurecomponent = (StructureComponent)arraylist.remove(i);
        }

        func_75072_c();
        func_75067_a(p_i3837_1_, p_i3837_2_, 10);
    }
}
