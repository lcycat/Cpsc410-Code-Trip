// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Packet3Chat, NetHandler

public class Packet203AutoComplete extends Packet
{

    private String field_73474_a;

    public Packet203AutoComplete()
    {
    }

    public Packet203AutoComplete(String p_i3299_1_)
    {
        field_73474_a = p_i3299_1_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73474_a = func_73282_a(p_73267_1_, Packet3Chat.field_73478_a);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73271_a(field_73474_a, p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72461_a(this);
    }

    public int func_73284_a()
    {
        return 2 + field_73474_a.length() * 2;
    }

    public String func_73473_d()
    {
        return field_73474_a;
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
