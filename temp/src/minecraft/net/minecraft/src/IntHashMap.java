// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;

// Referenced classes of package net.minecraft.src:
//            IntHashMapEntry

public class IntHashMap
{

    private transient IntHashMapEntry field_76055_a[];
    private transient int field_76053_b;
    private int field_76054_c;
    private final float field_76051_d = 0.75F;
    private volatile transient int field_76052_e;
    private Set field_76050_f;

    public IntHashMap()
    {
        field_76050_f = new HashSet();
        field_76054_c = 12;
        field_76055_a = new IntHashMapEntry[16];
    }

    private static int func_76044_g(int p_76044_0_)
    {
        p_76044_0_ ^= p_76044_0_ >>> 20 ^ p_76044_0_ >>> 12;
        return p_76044_0_ ^ p_76044_0_ >>> 7 ^ p_76044_0_ >>> 4;
    }

    private static int func_76043_a(int p_76043_0_, int p_76043_1_)
    {
        return p_76043_0_ & p_76043_1_ - 1;
    }

    public Object func_76041_a(int p_76041_1_)
    {
        int i = func_76044_g(p_76041_1_);
        for(IntHashMapEntry inthashmapentry = field_76055_a[func_76043_a(i, field_76055_a.length)]; inthashmapentry != null; inthashmapentry = inthashmapentry.field_76034_c)
        {
            if(inthashmapentry.field_76035_a == p_76041_1_)
            {
                return inthashmapentry.field_76033_b;
            }
        }

        return null;
    }

    public boolean func_76037_b(int p_76037_1_)
    {
        return func_76045_c(p_76037_1_) != null;
    }

    final IntHashMapEntry func_76045_c(int p_76045_1_)
    {
        int i = func_76044_g(p_76045_1_);
        for(IntHashMapEntry inthashmapentry = field_76055_a[func_76043_a(i, field_76055_a.length)]; inthashmapentry != null; inthashmapentry = inthashmapentry.field_76034_c)
        {
            if(inthashmapentry.field_76035_a == p_76045_1_)
            {
                return inthashmapentry;
            }
        }

        return null;
    }

    public void func_76038_a(int p_76038_1_, Object p_76038_2_)
    {
        field_76050_f.add(Integer.valueOf(p_76038_1_));
        int i = func_76044_g(p_76038_1_);
        int j = func_76043_a(i, field_76055_a.length);
        for(IntHashMapEntry inthashmapentry = field_76055_a[j]; inthashmapentry != null; inthashmapentry = inthashmapentry.field_76034_c)
        {
            if(inthashmapentry.field_76035_a == p_76038_1_)
            {
                inthashmapentry.field_76033_b = p_76038_2_;
                return;
            }
        }

        field_76052_e++;
        func_76040_a(i, p_76038_1_, p_76038_2_, j);
    }

    private void func_76047_h(int p_76047_1_)
    {
        IntHashMapEntry ainthashmapentry[] = field_76055_a;
        int i = ainthashmapentry.length;
        if(i == 0x40000000)
        {
            field_76054_c = 0x7fffffff;
            return;
        } else
        {
            IntHashMapEntry ainthashmapentry1[] = new IntHashMapEntry[p_76047_1_];
            func_76048_a(ainthashmapentry1);
            field_76055_a = ainthashmapentry1;
            field_76054_c = (int)((float)p_76047_1_ * field_76051_d);
            return;
        }
    }

    private void func_76048_a(IntHashMapEntry p_76048_1_[])
    {
        IntHashMapEntry ainthashmapentry[] = field_76055_a;
        int i = p_76048_1_.length;
        for(int j = 0; j < ainthashmapentry.length; j++)
        {
            IntHashMapEntry inthashmapentry = ainthashmapentry[j];
            if(inthashmapentry == null)
            {
                continue;
            }
            ainthashmapentry[j] = null;
            do
            {
                IntHashMapEntry inthashmapentry1 = inthashmapentry.field_76034_c;
                int k = func_76043_a(inthashmapentry.field_76032_d, i);
                inthashmapentry.field_76034_c = p_76048_1_[k];
                p_76048_1_[k] = inthashmapentry;
                inthashmapentry = inthashmapentry1;
            } while(inthashmapentry != null);
        }

    }

    public Object func_76049_d(int p_76049_1_)
    {
        field_76050_f.remove(Integer.valueOf(p_76049_1_));
        IntHashMapEntry inthashmapentry = func_76036_e(p_76049_1_);
        return inthashmapentry != null ? inthashmapentry.field_76033_b : null;
    }

    final IntHashMapEntry func_76036_e(int p_76036_1_)
    {
        int i = func_76044_g(p_76036_1_);
        int j = func_76043_a(i, field_76055_a.length);
        IntHashMapEntry inthashmapentry = field_76055_a[j];
        IntHashMapEntry inthashmapentry1;
        IntHashMapEntry inthashmapentry2;
        for(inthashmapentry1 = inthashmapentry; inthashmapentry1 != null; inthashmapentry1 = inthashmapentry2)
        {
            inthashmapentry2 = inthashmapentry1.field_76034_c;
            if(inthashmapentry1.field_76035_a == p_76036_1_)
            {
                field_76052_e++;
                field_76053_b--;
                if(inthashmapentry == inthashmapentry1)
                {
                    field_76055_a[j] = inthashmapentry2;
                } else
                {
                    inthashmapentry.field_76034_c = inthashmapentry2;
                }
                return inthashmapentry1;
            }
            inthashmapentry = inthashmapentry1;
        }

        return inthashmapentry1;
    }

    public void func_76046_c()
    {
        field_76052_e++;
        IntHashMapEntry ainthashmapentry[] = field_76055_a;
        for(int i = 0; i < ainthashmapentry.length; i++)
        {
            ainthashmapentry[i] = null;
        }

        field_76053_b = 0;
    }

    private void func_76040_a(int p_76040_1_, int p_76040_2_, Object p_76040_3_, int p_76040_4_)
    {
        IntHashMapEntry inthashmapentry = field_76055_a[p_76040_4_];
        field_76055_a[p_76040_4_] = new IntHashMapEntry(p_76040_1_, p_76040_2_, p_76040_3_, inthashmapentry);
        if(field_76053_b++ >= field_76054_c)
        {
            func_76047_h(2 * field_76055_a.length);
        }
    }

    public Set func_76039_d()
    {
        return field_76050_f;
    }

    static int func_76042_f(int p_76042_0_)
    {
        return func_76044_g(p_76042_0_);
    }
}
