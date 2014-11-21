// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Arrays;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagIntArray extends NBTBase
{

    public int field_74749_a[];

    public NBTTagIntArray(String p_i3270_1_)
    {
        super(p_i3270_1_);
    }

    public NBTTagIntArray(String p_i3271_1_, int p_i3271_2_[])
    {
        super(p_i3271_1_);
        field_74749_a = p_i3271_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeInt(field_74749_a.length);
        int ai[] = field_74749_a;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int k = ai[j];
            p_74734_1_.writeInt(k);
        }

    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        int i = p_74735_1_.readInt();
        field_74749_a = new int[i];
        for(int j = 0; j < i; j++)
        {
            field_74749_a[j] = p_74735_1_.readInt();
        }

    }

    public byte func_74732_a()
    {
        return 11;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(field_74749_a.length).append(" bytes]").toString();
    }

    public NBTBase func_74737_b()
    {
        int ai[] = new int[field_74749_a.length];
        System.arraycopy(field_74749_a, 0, ai, 0, field_74749_a.length);
        return new NBTTagIntArray(func_74740_e(), ai);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagIntArray nbttagintarray = (NBTTagIntArray)p_equals_1_;
            return field_74749_a == null && nbttagintarray.field_74749_a == null || field_74749_a != null && Arrays.equals(field_74749_a, nbttagintarray.field_74749_a);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ Arrays.hashCode(field_74749_a);
    }
}
