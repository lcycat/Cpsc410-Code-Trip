// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagLong extends NBTBase
{

    public long field_74753_a;

    public NBTTagLong(String p_i3275_1_)
    {
        super(p_i3275_1_);
    }

    public NBTTagLong(String p_i3276_1_, long p_i3276_2_)
    {
        super(p_i3276_1_);
        field_74753_a = p_i3276_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeLong(field_74753_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74753_a = p_74735_1_.readLong();
    }

    public byte func_74732_a()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74753_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagLong(func_74740_e(), field_74753_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagLong nbttaglong = (NBTTagLong)p_equals_1_;
            return field_74753_a == nbttaglong.field_74753_a;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ (int)(field_74753_a ^ field_74753_a >>> 32);
    }
}
