// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagFloat extends NBTBase
{

    public float field_74750_a;

    public NBTTagFloat(String p_i3268_1_)
    {
        super(p_i3268_1_);
    }

    public NBTTagFloat(String p_i3269_1_, float p_i3269_2_)
    {
        super(p_i3269_1_);
        field_74750_a = p_i3269_2_;
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        p_74734_1_.writeFloat(field_74750_a);
    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74750_a = p_74735_1_.readFloat();
    }

    public byte func_74732_a()
    {
        return 5;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74750_a).toString();
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagFloat(func_74740_e(), field_74750_a);
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagFloat nbttagfloat = (NBTTagFloat)p_equals_1_;
            return field_74750_a == nbttagfloat.field_74750_a;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return super.hashCode() ^ Float.floatToIntBits(field_74750_a);
    }
}
