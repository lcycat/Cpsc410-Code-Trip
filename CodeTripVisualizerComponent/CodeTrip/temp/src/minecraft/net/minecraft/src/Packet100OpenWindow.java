// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet100OpenWindow extends Packet
{

    public int field_73431_a;
    public int field_73429_b;
    public String field_73430_c;
    public int field_73428_d;

    public Packet100OpenWindow()
    {
    }

    public Packet100OpenWindow(int p_i3311_1_, int p_i3311_2_, String p_i3311_3_, int p_i3311_4_)
    {
        field_73431_a = p_i3311_1_;
        field_73429_b = p_i3311_2_;
        field_73430_c = p_i3311_3_;
        field_73428_d = p_i3311_4_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72516_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73431_a = p_73267_1_.readByte() & 0xff;
        field_73429_b = p_73267_1_.readByte() & 0xff;
        field_73430_c = func_73282_a(p_73267_1_, 32);
        field_73428_d = p_73267_1_.readByte() & 0xff;
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73431_a & 0xff);
        p_73273_1_.writeByte(field_73429_b & 0xff);
        func_73271_a(field_73430_c, p_73273_1_);
        p_73273_1_.writeByte(field_73428_d & 0xff);
    }

    public int func_73284_a()
    {
        return 3 + field_73430_c.length();
    }
}
