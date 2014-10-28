// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagInt extends NBTBase
{

    public int field_74748_a;

    public NBTTagInt(String p_i3272_1_)
    {
        super(p_i3272_1_);
    }

    public NBTTagInt(String p_i3273_1_, int p_i3273_2_)
    {
        super(p_i3273_1_);
        field_74748_a = p_i3273_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeInt(field_74748_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74748_a = p_74735_1_.readInt();
    }

    public byte func_74732_a()
    {
        return 3;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74748_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagInt(func_74740_e(), field_74748_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagInt nbttagint = (NBTTagInt)p_equals_1_;
            return field_74748_a == nbttagint.field_74748_a;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ field_74748_a;
    }
}
