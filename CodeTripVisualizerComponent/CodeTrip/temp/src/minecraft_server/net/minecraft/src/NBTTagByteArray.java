// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Arrays;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagByteArray extends NBTBase
{

    public byte field_74754_a[];

    public NBTTagByteArray(String p_i3261_1_)
    {
        super(p_i3261_1_);
    }

    public NBTTagByteArray(String p_i3262_1_, byte p_i3262_2_[])
    {
        super(p_i3262_1_);
        field_74754_a = p_i3262_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeInt(field_74754_a.length);
        p_74734_1_.write(field_74754_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        int i = p_74735_1_.readInt();
        field_74754_a = new byte[i];
        p_74735_1_.readFully(field_74754_a);
    }

    public byte func_74732_a()
    {
        return 7;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[").append(field_74754_a.length).append(" bytes]").toString();
    }

    public NBTBase func_74737_b()
    {
        byte abyte0[] = new byte[field_74754_a.length];
        System.arraycopy(field_74754_a, 0, abyte0, 0, field_74754_a.length);
        return new NBTTagByteArray(func_74740_e(), abyte0);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            return Arrays.equals(field_74754_a, ((NBTTagByteArray)p_equals_1_).field_74754_a);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ Arrays.hashCode(field_74754_a);
    }
}
