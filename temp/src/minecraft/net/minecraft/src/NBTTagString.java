// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagString extends NBTBase
{

    public String field_74751_a;

    public NBTTagString(String p_i3279_1_)
    {
        super(p_i3279_1_);
    }

    public NBTTagString(String p_i3280_1_, String p_i3280_2_)
    {
        super(p_i3280_1_);
        field_74751_a = p_i3280_2_;
        if(p_i3280_2_ == null)
        {
            throw new IllegalArgumentException("Empty string not allowed");
        } else
        {
            return;
        }
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeUTF(field_74751_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74751_a = p_74735_1_.readUTF();
    }

    public byte func_74732_a()
    {
        return 8;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74751_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagString(func_74740_e(), field_74751_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagString nbttagstring = (NBTTagString)p_equals_1_;
            return field_74751_a == null && nbttagstring.field_74751_a == null || field_74751_a != null && field_74751_a.equals(nbttagstring.field_74751_a);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ field_74751_a.hashCode();
    }
}
