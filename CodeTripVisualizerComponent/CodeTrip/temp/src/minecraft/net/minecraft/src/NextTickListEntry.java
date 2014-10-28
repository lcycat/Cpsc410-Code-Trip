// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


public class NextTickListEntry
    implements Comparable
{

    private static long field_77177_f = 0L;
    public int field_77183_a;
    public int field_77181_b;
    public int field_77182_c;
    public int field_77179_d;
    public long field_77180_e;
    private long field_77178_g;

    public NextTickListEntry(int p_i3741_1_, int p_i3741_2_, int p_i3741_3_, int p_i3741_4_)
    {
        field_77178_g = field_77177_f++;
        field_77183_a = p_i3741_1_;
        field_77181_b = p_i3741_2_;
        field_77182_c = p_i3741_3_;
        field_77179_d = p_i3741_4_;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(p_equals_1_ instanceof NextTickListEntry)
        {
            NextTickListEntry nextticklistentry = (NextTickListEntry)p_equals_1_;
            return field_77183_a == nextticklistentry.field_77183_a && field_77181_b == nextticklistentry.field_77181_b && field_77182_c == nextticklistentry.field_77182_c && field_77179_d == nextticklistentry.field_77179_d;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return (field_77183_a * 1024 * 1024 + field_77182_c * 1024 + field_77181_b) * 256 + field_77179_d;
    }

    public NextTickListEntry func_77176_a(long p_77176_1_)
    {
        field_77180_e = p_77176_1_;
        return this;
    }

    public int func_77175_a(NextTickListEntry p_77175_1_)
    {
        if(field_77180_e < p_77175_1_.field_77180_e)
        {
            return -1;
        }
        if(field_77180_e > p_77175_1_.field_77180_e)
        {
            return 1;
        }
        if(field_77178_g < p_77175_1_.field_77178_g)
        {
            return -1;
        }
        return field_77178_g <= p_77175_1_.field_77178_g ? 0 : 1;
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return func_77175_a((NextTickListEntry)p_compareTo_1_);
    }

}
