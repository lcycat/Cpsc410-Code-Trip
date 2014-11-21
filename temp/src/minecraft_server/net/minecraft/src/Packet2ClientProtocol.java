// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet2ClientProtocol extends Packet
{

    private int field_73458_a;
    private String field_73456_b;
    private String field_73457_c;
    private int field_73455_d;

    public Packet2ClientProtocol()
    {
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73458_a = p_73267_1_.readByte();
        field_73456_b = func_73282_a(p_73267_1_, 16);
        field_73457_c = func_73282_a(p_73267_1_, 255);
        field_73455_d = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73458_a);
        func_73271_a(field_73456_b, p_73273_1_);
        func_73271_a(field_73457_c, p_73273_1_);
        p_73273_1_.writeInt(field_73455_d);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72500_a(this);
    }

    public int func_73284_a()
    {
        return 3 + 2 * field_73456_b.length();
    }

    public int func_73453_d()
    {
        return field_73458_a;
    }

    public String func_73454_f()
    {
        return field_73456_b;
    }
}
