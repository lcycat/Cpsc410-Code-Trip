// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet19EntityAction extends Packet
{

    public int field_73367_a;
    public int field_73366_b;

    public Packet19EntityAction()
    {
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73367_a = p_73267_1_.readInt();
        field_73366_b = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73367_a);
        p_73273_1_.writeByte(field_73366_b);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72473_a(this);
    }

    public int func_73284_a()
    {
        return 5;
    }
}
