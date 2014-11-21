// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, StructureMineshaftPieces, Block, 
//            World

public class ComponentMineshaftRoom extends StructureComponent
{

    private List field_74949_a;

    public ComponentMineshaftRoom(int p_i3809_1_, Random p_i3809_2_, int p_i3809_3_, int p_i3809_4_)
    {
        super(p_i3809_1_);
        field_74949_a = new LinkedList();
        field_74887_e = new StructureBoundingBox(p_i3809_3_, 50, p_i3809_4_, p_i3809_3_ + 7 + p_i3809_2_.nextInt(6), 54 + p_i3809_2_.nextInt(6), p_i3809_4_ + 7 + p_i3809_2_.nextInt(6));
    }

    public void func_74861_a(StructureComponent p_74861_1_, List p_74861_2_, Random p_74861_3_)
    {
        int i = func_74877_c();
        int j1 = field_74887_e.func_78882_c() - 3 - 1;
        if(j1 <= 0)
        {
            j1 = 1;
        }
        for(int j = 0; j < field_74887_e.func_78883_b(); j += 4)
        {
            j += p_74861_3_.nextInt(field_74887_e.func_78883_b());
            if(j + 3 > field_74887_e.func_78883_b())
            {
                break;
            }
            StructureComponent structurecomponent = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + j, field_74887_e.field_78895_b + p_74861_3_.nextInt(j1) + 1, field_74887_e.field_78896_c - 1, 2, i);
            if(structurecomponent != null)
            {
                StructureBoundingBox structureboundingbox = structurecomponent.func_74874_b();
                field_74949_a.add(new StructureBoundingBox(structureboundingbox.field_78897_a, structureboundingbox.field_78895_b, field_74887_e.field_78896_c, structureboundingbox.field_78893_d, structureboundingbox.field_78894_e, field_74887_e.field_78896_c + 1));
            }
        }

        for(int k = 0; k < field_74887_e.func_78883_b(); k += 4)
        {
            k += p_74861_3_.nextInt(field_74887_e.func_78883_b());
            if(k + 3 > field_74887_e.func_78883_b())
            {
                break;
            }
            StructureComponent structurecomponent1 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a + k, field_74887_e.field_78895_b + p_74861_3_.nextInt(j1) + 1, field_74887_e.field_78892_f + 1, 0, i);
            if(structurecomponent1 != null)
            {
                StructureBoundingBox structureboundingbox1 = structurecomponent1.func_74874_b();
                field_74949_a.add(new StructureBoundingBox(structureboundingbox1.field_78897_a, structureboundingbox1.field_78895_b, field_74887_e.field_78892_f - 1, structureboundingbox1.field_78893_d, structureboundingbox1.field_78894_e, field_74887_e.field_78892_f));
            }
        }

        for(int l = 0; l < field_74887_e.func_78880_d(); l += 4)
        {
            l += p_74861_3_.nextInt(field_74887_e.func_78880_d());
            if(l + 3 > field_74887_e.func_78880_d())
            {
                break;
            }
            StructureComponent structurecomponent2 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78897_a - 1, field_74887_e.field_78895_b + p_74861_3_.nextInt(j1) + 1, field_74887_e.field_78896_c + l, 1, i);
            if(structurecomponent2 != null)
            {
                StructureBoundingBox structureboundingbox2 = structurecomponent2.func_74874_b();
                field_74949_a.add(new StructureBoundingBox(field_74887_e.field_78897_a, structureboundingbox2.field_78895_b, structureboundingbox2.field_78896_c, field_74887_e.field_78897_a + 1, structureboundingbox2.field_78894_e, structureboundingbox2.field_78892_f));
            }
        }

        for(int i1 = 0; i1 < field_74887_e.func_78880_d(); i1 += 4)
        {
            i1 += p_74861_3_.nextInt(field_74887_e.func_78880_d());
            if(i1 + 3 > field_74887_e.func_78880_d())
            {
                break;
            }
            StructureComponent structurecomponent3 = StructureMineshaftPieces.func_78814_a(p_74861_1_, p_74861_2_, p_74861_3_, field_74887_e.field_78893_d + 1, field_74887_e.field_78895_b + p_74861_3_.nextInt(j1) + 1, field_74887_e.field_78896_c + i1, 3, i);
            if(structurecomponent3 != null)
            {
                StructureBoundingBox structureboundingbox3 = structurecomponent3.func_74874_b();
                field_74949_a.add(new StructureBoundingBox(field_74887_e.field_78893_d - 1, structureboundingbox3.field_78895_b, structureboundingbox3.field_78896_c, field_74887_e.field_78893_d, structureboundingbox3.field_78894_e, structureboundingbox3.field_78892_f));
            }
        }

    }

    public boolean func_74875_a(World p_74875_1_, Random p_74875_2_, StructureBoundingBox p_74875_3_)
    {
        if(func_74860_a(p_74875_1_, p_74875_3_))
        {
            return false;
        }
        func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b, field_74887_e.field_78896_c, field_74887_e.field_78893_d, field_74887_e.field_78895_b, field_74887_e.field_78892_f, Block.field_71979_v.field_71990_ca, 0, true);
        func_74884_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b + 1, field_74887_e.field_78896_c, field_74887_e.field_78893_d, Math.min(field_74887_e.field_78895_b + 3, field_74887_e.field_78894_e), field_74887_e.field_78892_f, 0, 0, false);
        StructureBoundingBox structureboundingbox;
        for(Iterator iterator = field_74949_a.iterator(); iterator.hasNext(); func_74884_a(p_74875_1_, p_74875_3_, structureboundingbox.field_78897_a, structureboundingbox.field_78894_e - 2, structureboundingbox.field_78896_c, structureboundingbox.field_78893_d, structureboundingbox.field_78894_e, structureboundingbox.field_78892_f, 0, 0, false))
        {
            structureboundingbox = (StructureBoundingBox)iterator.next();
        }

        func_74867_a(p_74875_1_, p_74875_3_, field_74887_e.field_78897_a, field_74887_e.field_78895_b + 4, field_74887_e.field_78896_c, field_74887_e.field_78893_d, field_74887_e.field_78894_e, field_74887_e.field_78892_f, 0, false);
        return true;
    }
}
