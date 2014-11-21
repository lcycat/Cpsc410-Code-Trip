// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet38EntityStatus extends Packet
{

    public int field_73627_a;
    public byte field_73626_b;

    public Packet38EntityStatus()
    {
    }

    public Packet38EntityStatus(int p_i3318_1_, byte p_i3318_2_)
    {
        field_73627_a = p_i3318_1_;
        field_73626_b = p_i3318_2_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73627_a = p_73267_1_.readInt();
        field_73626_b = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73627_a);
        p_73273_1_.writeByte(field_73626_b);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72485_a(this);
    }

    public int func_73284_a()
    {
        return 5;
    }
}
