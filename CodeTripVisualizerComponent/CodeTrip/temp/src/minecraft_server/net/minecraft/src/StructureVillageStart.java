// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureStart, StructureVillagePieces, ComponentVillageStartPiece, World, 
//            StructureComponent, ComponentVillageRoadPiece

class StructureVillageStart extends StructureStart
{

    private boolean field_75076_c;

    public StructureVillageStart(World p_i3858_1_, Random p_i3858_2_, int p_i3858_3_, int p_i3858_4_, int p_i3858_5_)
    {
        field_75076_c = false;
        ArrayList arraylist = StructureVillagePieces.func_75084_a(p_i3858_2_, p_i3858_5_);
        ComponentVillageStartPiece componentvillagestartpiece = new ComponentVillageStartPiece(p_i3858_1_.func_72959_q(), 0, p_i3858_2_, (p_i3858_3_ << 4) + 2, (p_i3858_4_ << 4) + 2, arraylist, p_i3858_5_);
        field_75075_a.add(componentvillagestartpiece);
        componentvillagestartpiece.func_74861_a(componentvillagestartpiece, field_75075_a, p_i3858_2_);
        ArrayList arraylist1 = componentvillagestartpiece.field_74930_j;
        for(ArrayList arraylist2 = componentvillagestartpiece.field_74932_i; !arraylist1.isEmpty() || !arraylist2.isEmpty();)
        {
            if(arraylist1.isEmpty())
            {
                int i = p_i3858_2_.nextInt(arraylist2.size());
                StructureComponent structurecomponent = (StructureComponent)arraylist2.remove(i);
                structurecomponent.func_74861_a(componentvillagestartpiece, field_75075_a, p_i3858_2_);
            } else
            {
                int j = p_i3858_2_.nextInt(arraylist1.size());
                StructureComponent structurecomponent1 = (StructureComponent)arraylist1.remove(j);
                structurecomponent1.func_74861_a(componentvillagestartpiece, field_75075_a, p_i3858_2_);
            }
        }

        func_75072_c();
        int k = 0;
        Iterator iterator = field_75075_a.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureComponent structurecomponent2 = (StructureComponent)iterator.next();
            if(!(structurecomponent2 instanceof ComponentVillageRoadPiece))
            {
                k++;
            }
        } while(true);
        field_75076_c = k > 2;
    }

    public boolean func_75069_d()
    {
        return field_75076_c;
    }
}
