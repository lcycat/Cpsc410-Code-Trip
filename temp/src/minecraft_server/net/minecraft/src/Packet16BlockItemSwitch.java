// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet16BlockItemSwitch extends Packet
{

    public int field_73386_a;

    public Packet16BlockItemSwitch()
    {
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73386_a = p_73267_1_.readShort();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeShort(field_73386_a);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72502_a(this);
    }

    public int func_73284_a()
    {
        return 2;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        return true;
    }
}
