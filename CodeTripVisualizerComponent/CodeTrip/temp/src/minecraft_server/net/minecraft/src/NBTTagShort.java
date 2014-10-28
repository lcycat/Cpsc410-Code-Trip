// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagShort extends NBTBase
{

    public short field_74752_a;

    public NBTTagShort(String p_i3277_1_)
    {
        super(p_i3277_1_);
    }

    public NBTTagShort(String p_i3278_1_, short p_i3278_2_)
    {
        super(p_i3278_1_);
        field_74752_a = p_i3278_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeShort(field_74752_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74752_a = p_74735_1_.readShort();
    }

    public byte func_74732_a()
    {
        return 2;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74752_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagShort(func_74740_e(), field_74752_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagShort nbttagshort = (NBTTagShort)p_equals_1_;
            return field_74752_a == nbttagshort.field_74752_a;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ field_74752_a;
    }
}
