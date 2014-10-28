// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagEnd extends NBTBase
{

    public NBTTagEnd()
    {
        super(null);
    }

    void func_74735_a(DataInput datainput)
        throws IOException
    {
    }

    void func_74734_a(DataOutput dataoutput)
        throws IOException
    {
    }

    public byte func_74732_a()
    {
        return 0;
    }

    public String toString()
    {
        return "END";
    }

    public NBTBase func_74737_b()
    {
        return new NBTTagEnd();
    }
}
