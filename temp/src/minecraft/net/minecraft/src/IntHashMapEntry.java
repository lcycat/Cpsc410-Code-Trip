// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            IntHashMap

class IntHashMapEntry
{

    final int field_76035_a;
    Object field_76033_b;
    IntHashMapEntry field_76034_c;
    final int field_76032_d;

    IntHashMapEntry(int p_i3419_1_, int p_i3419_2_, Object p_i3419_3_, IntHashMapEntry p_i3419_4_)
    {
        field_76033_b = p_i3419_3_;
        field_76034_c = p_i3419_4_;
        field_76035_a = p_i3419_2_;
        field_76032_d = p_i3419_1_;
    }

    public final int func_76031_a()
    {
        return field_76035_a;
    }

    public final Object func_76030_b()
    {
        return field_76033_b;
    }

    public final boolean equals(Object p_equals_1_)
    {
        if(!(p_equals_1_ instanceof IntHashMapEntry))
        {
            return false;
        }
        IntHashMapEntry inthashmapentry = (IntHashMapEntry)p_equals_1_;
        Integer integer = Integer.valueOf(func_76031_a());
        Integer integer1 = Integer.valueOf(inthashmapentry.func_76031_a());
        if(integer == integer1 || integer != null && integer.equals(integer1))
        {
            Object obj = func_76030_b();
            Object obj1 = inthashmapentry.func_76030_b();
            if(obj == obj1 || obj != null && obj.equals(obj1))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return IntHashMap.func_76042_f(field_76035_a);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(func_76031_a()).append("=").append(func_76030_b()).toString();
    }
}
