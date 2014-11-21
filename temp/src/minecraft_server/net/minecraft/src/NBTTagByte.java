// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagByte extends NBTBase
{

    public byte field_74756_a;

    public NBTTagByte(String p_i3263_1_)
    {
        super(p_i3263_1_);
    }

    public NBTTagByte(String p_i3264_1_, byte p_i3264_2_)
    {
        super(p_i3264_1_);
        field_74756_a = p_i3264_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeByte(field_74756_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74756_a = p_74735_1_.readByte();
    }

    public byte func_74732_a()
    {
        return 1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74756_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagByte(func_74740_e(), field_74756_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagByte nbttagbyte = (NBTTagByte)p_equals_1_;
            return field_74756_a == nbttagbyte.field_74756_a;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ field_74756_a;
    }
}
