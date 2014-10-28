// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.security.PublicKey;

// Referenced classes of package net.minecraft.src:
//            Packet, CryptManager, NetHandler

public class Packet253ServerAuthData extends Packet
{

    private String field_73381_a;
    private PublicKey field_73379_b;
    private byte field_73380_c[];

    public Packet253ServerAuthData()
    {
        field_73380_c = new byte[0];
    }

    public Packet253ServerAuthData(String p_i3344_1_, PublicKey p_i3344_2_, byte p_i3344_3_[])
    {
        field_73380_c = new byte[0];
        field_73381_a = p_i3344_1_;
        field_73379_b = p_i3344_2_;
        field_73380_c = p_i3344_3_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73381_a = func_73282_a(p_73267_1_, 20);
        field_73379_b = CryptManager.func_75896_a(func_73280_b(p_73267_1_));
        field_73380_c = func_73280_b(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73271_a(field_73381_a, p_73273_1_);
        func_73274_a(p_73273_1_, field_73379_b.getEncoded());
        func_73274_a(p_73273_1_, field_73380_c);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72470_a(this);
    }

    public int func_73284_a()
    {
        return 2 + field_73381_a.length() * 2 + 2 + field_73379_b.getEncoded().length + 2 + field_73380_c.length;
    }
}
