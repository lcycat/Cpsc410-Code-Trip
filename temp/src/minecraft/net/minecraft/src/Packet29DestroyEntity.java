// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet29DestroyEntity extends Packet
{

    public int field_73368_a[];

    public Packet29DestroyEntity()
    {
    }

    public Packet29DestroyEntity(int p_i3340_1_[])
    {
        field_73368_a = p_i3340_1_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73368_a = new int[p_73267_1_.readByte()];
        for(int i = 0; i < field_73368_a.length; i++)
        {
            field_73368_a[i] = p_73267_1_.readInt();
        }

    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73368_a.length);
        for(int i = 0; i < field_73368_a.length; i++)
        {
            p_73273_1_.writeInt(field_73368_a[i]);
        }

    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72491_a(this);
    }

    public int func_73284_a()
    {
        return 1 + field_73368_a.length * 4;
    }
}
