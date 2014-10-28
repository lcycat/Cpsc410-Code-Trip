// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StructureComponent, StructureBoundingBox, World

public abstract class StructureStart
{

    protected LinkedList field_75075_a;
    protected StructureBoundingBox field_75074_b;

    protected StructureStart()
    {
        field_75075_a = new LinkedList();
    }

    public StructureBoundingBox func_75071_a()
    {
        return field_75074_b;
    }

    public LinkedList func_75073_b()
    {
        return field_75075_a;
    }

    public void func_75068_a(World p_75068_1_, Random p_75068_2_, StructureBoundingBox p_75068_3_)
    {
        Iterator iterator = field_75075_a.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            StructureComponent structurecomponent = (StructureComponent)iterator.next();
            if(structurecomponent.func_74874_b().func_78884_a(p_75068_3_) && !structurecomponent.func_74875_a(p_75068_1_, p_75068_2_, p_75068_3_))
            {
                iterator.remove();
            }
        } while(true);
    }

    protected void func_75072_c()
    {
        field_75074_b = StructureBoundingBox.func_78887_a();
        StructureComponent structurecomponent;
        for(Iterator iterator = field_75075_a.iterator(); iterator.hasNext(); field_75074_b.func_78888_b(structurecomponent.func_74874_b()))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }

    protected void func_75067_a(World p_75067_1_, Random p_75067_2_, int p_75067_3_)
    {
        int i = 63 - p_75067_3_;
        int j = field_75074_b.func_78882_c() + 1;
        if(j < i)
        {
            j += p_75067_2_.nextInt(i - j);
        }
        int k = j - field_75074_b.field_78894_e;
        field_75074_b.func_78886_a(0, k, 0);
        StructureComponent structurecomponent;
        for(Iterator iterator = field_75075_a.iterator(); iterator.hasNext(); structurecomponent.func_74874_b().func_78886_a(0, k, 0))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }

    protected void func_75070_a(World p_75070_1_, Random p_75070_2_, int p_75070_3_, int p_75070_4_)
    {
        int i = ((p_75070_4_ - p_75070_3_) + 1) - field_75074_b.func_78882_c();
        int j = 1;
        if(i > 1)
        {
            j = p_75070_3_ + p_75070_2_.nextInt(i);
        } else
        {
            j = p_75070_3_;
        }
        int k = j - field_75074_b.field_78895_b;
        field_75074_b.func_78886_a(0, k, 0);
        StructureComponent structurecomponent;
        for(Iterator iterator = field_75075_a.iterator(); iterator.hasNext(); structurecomponent.func_74874_b().func_78886_a(0, k, 0))
        {
            structurecomponent = (StructureComponent)iterator.next();
        }

    }

    public boolean func_75069_d()
    {
        return true;
    }
}
