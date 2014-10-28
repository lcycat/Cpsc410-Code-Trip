// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet4UpdateTime extends Packet
{

    public long field_73301_a;

    public Packet4UpdateTime()
    {
    }

    public Packet4UpdateTime(long p_i3355_1_)
    {
        field_73301_a = p_i3355_1_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73301_a = p_73267_1_.readLong();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeLong(field_73301_a);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72497_a(this);
    }

    public int func_73284_a()
    {
        return 8;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        return true;
    }

    public boolean func_73277_a_()
    {
        return true;
    }
}
