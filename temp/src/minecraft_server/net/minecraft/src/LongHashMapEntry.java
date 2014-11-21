// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            LongHashMap

class LongHashMapEntry
{

    final long field_76150_a;
    Object field_76148_b;
    LongHashMapEntry field_76149_c;
    final int field_76147_d;

    LongHashMapEntry(int p_i3420_1_, long p_i3420_2_, Object p_i3420_4_, LongHashMapEntry p_i3420_5_)
    {
        field_76148_b = p_i3420_4_;
        field_76149_c = p_i3420_5_;
        field_76150_a = p_i3420_2_;
        field_76147_d = p_i3420_1_;
    }

    public final long func_76146_a()
    {
        return field_76150_a;
    }

    public final Object func_76145_b()
    {
        return field_76148_b;
    }

    public final boolean equals(Object p_equals_1_)
    {
        if(!(p_equals_1_ instanceof LongHashMapEntry))
        {
            return false;
        }
        LongHashMapEntry longhashmapentry = (LongHashMapEntry)p_equals_1_;
        Long long1 = Long.valueOf(func_76146_a());
        Long long2 = Long.valueOf(longhashmapentry.func_76146_a());
        if(long1 == long2 || long1 != null && long1.equals(long2))
        {
            Object obj = func_76145_b();
            Object obj1 = longhashmapentry.func_76145_b();
            if(obj == obj1 || obj != null && obj.equals(obj1))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return LongHashMap.func_76151_f(field_76150_a);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(func_76146_a()).append("=").append(func_76145_b()).toString();
    }
}
