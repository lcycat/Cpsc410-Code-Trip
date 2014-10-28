// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagList extends NBTBase
{

    private List field_74747_a;
    private byte field_74746_b;

    public NBTTagList()
    {
        super("");
        field_74747_a = new ArrayList();
    }

    public NBTTagList(String p_i3274_1_)
    {
        super(p_i3274_1_);
        field_74747_a = new ArrayList();
    }

    void func_74734_a(DataOutput p_74734_1_)
        throws IOException
    {
        if(!field_74747_a.isEmpty())
        {
            field_74746_b = ((NBTBase)field_74747_a.get(0)).func_74732_a();
        } else
        {
            field_74746_b = 1;
        }
        p_74734_1_.writeByte(field_74746_b);
        p_74734_1_.writeInt(field_74747_a.size());
        NBTBase nbtbase;
        for(Iterator iterator = field_74747_a.iterator(); iterator.hasNext(); nbtbase.func_74734_a(p_74734_1_))
        {
            nbtbase = (NBTBase)iterator.next();
        }

    }

    void func_74735_a(DataInput p_74735_1_)
        throws IOException
    {
        field_74746_b = p_74735_1_.readByte();
        int i = p_74735_1_.readInt();
        field_74747_a = new ArrayList();
        for(int j = 0; j < i; j++)
        {
            NBTBase nbtbase = NBTBase.func_74733_a(field_74746_b, null);
            nbtbase.func_74735_a(p_74735_1_);
            field_74747_a.add(nbtbase);
        }

    }

    public byte func_74732_a()
    {
        return 9;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(field_74747_a.size()).append(" entries of type ").append(NBTBase.func_74736_a(field_74746_b)).toString();
    }

    public void func_74742_a(NBTBase p_74742_1_)
    {
        field_74746_b = p_74742_1_.func_74732_a();
        field_74747_a.add(p_74742_1_);
    }

    public NBTBase func_74743_b(int p_74743_1_)
    {
        return (NBTBase)field_74747_a.get(p_74743_1_);
    }

    public int func_74745_c()
    {
        return field_74747_a.size();
    }

    public NBTBase func_74737_b()
    {
        NBTTagList nbttaglist = new NBTTagList(func_74740_e());
        nbttaglist.field_74746_b = field_74746_b;
        NBTBase nbtbase1;
        for(Iterator iterator = field_74747_a.iterator(); iterator.hasNext(); nbttaglist.field_74747_a.add(nbtbase1))
        {
            NBTBase nbtbase = (NBTBase)iterator.next();
            nbtbase1 = nbtbase.func_74737_b();
        }

        return nbttaglist;
    }

    public boolean equals(Object p_equals_1_)
    {
        if(super.equals(p_equals_1_))
        {
            NBTTagList nbttaglist = (NBTTagList)p_equals_1_;
            if(field_74746_b == nbttaglist.field_74746_b)
            {
                return field_74747_a.equals(nbttaglist.field_74747_a);
            }
        }
        return false;
    }

    public int hashCode()
    {
        return super.hashCode() ^ field_74747_a.hashCode();
    }
}
