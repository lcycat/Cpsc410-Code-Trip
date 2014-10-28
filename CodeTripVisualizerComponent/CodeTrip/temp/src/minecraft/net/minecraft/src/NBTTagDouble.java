// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagDouble extends NBTBase
{

    public double field_74755_a;

    public NBTTagDouble(String p_i3266_1_)
    {
        super(p_i3266_1_);
    }

    public NBTTagDouble(String p_i3267_1_, double p_i3267_2_)
    {
        super(p_i3267_1_);
        field_74755_a = p_i3267_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeDouble(field_74755_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74755_a = p_74735_1_.readDouble();
    }

    public byte func_74732_a()
    {
        return 6;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74755_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagDouble(func_74740_e(), field_74755_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagDouble nbttagdouble = (NBTTagDouble)p_equals_1_;
            return field_74755_a == nbttagdouble.field_74755_a;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(field_74755_a);
        return super.hashCode() ^ (int)(l ^ l >>> 32);
    }
}
