// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet0KeepAlive extends Packet
{

    public int field_73592_a;

    public Packet0KeepAlive()
    {
    }

    public Packet0KeepAlive(int p_i3322_1_)
    {
        field_73592_a = p_i3322_1_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72477_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73592_a = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73592_a);
    }

    public int func_73284_a()
    {
        return 4;
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
