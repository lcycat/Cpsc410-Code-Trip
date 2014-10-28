// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet204ClientInfo extends Packet
{

    private String field_73468_a;
    private int field_73466_b;
    private int field_73467_c;
    private boolean field_73464_d;
    private int field_73465_e;

    public Packet204ClientInfo()
    {
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73468_a = func_73282_a(p_73267_1_, 7);
        field_73466_b = p_73267_1_.readByte();
        byte byte0 = p_73267_1_.readByte();
        field_73467_c = byte0 & 7;
        field_73464_d = (byte0 & 8) == 8;
        field_73465_e = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73271_a(field_73468_a, p_73273_1_);
        p_73273_1_.writeByte(field_73466_b);
        p_73273_1_.writeByte(field_73467_c | (field_73464_d ? 1 : 0) << 3);
        p_73273_1_.writeByte(field_73465_e);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72504_a(this);
    }

    public int func_73284_a()
    {
        return 0;
    }

    public String func_73459_d()
    {
        return field_73468_a;
    }

    public int func_73461_f()
    {
        return field_73466_b;
    }

    public int func_73463_g()
    {
        return field_73467_c;
    }

    public boolean func_73460_h()
    {
        return field_73464_d;
    }

    public int func_73462_i()
    {
        return field_73465_e;
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
