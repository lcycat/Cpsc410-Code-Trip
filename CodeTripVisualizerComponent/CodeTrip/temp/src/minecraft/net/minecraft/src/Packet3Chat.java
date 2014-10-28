// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet3Chat extends Packet
{

    public static int field_73478_a = 119;
    public String field_73476_b;
    private boolean field_73477_c;

    public Packet3Chat()
    {
        field_73477_c = true;
    }

    public Packet3Chat(String p_i3300_1_)
    {
        this(p_i3300_1_, true);
    }

    public Packet3Chat(String p_i3301_1_, boolean p_i3301_2_)
    {
        field_73477_c = true;
        if(p_i3301_1_.length() > field_73478_a)
        {
            p_i3301_1_ = p_i3301_1_.substring(0, field_73478_a);
        }
        field_73476_b = p_i3301_1_;
        field_73477_c = p_i3301_2_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73476_b = func_73282_a(p_73267_1_, field_73478_a);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73271_a(field_73476_b, p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72481_a(this);
    }

    public int func_73284_a()
    {
        return 2 + field_73476_b.length() * 2;
    }

    public boolean func_73475_d()
    {
        return field_73477_c;
    }

    public boolean func_73277_a_()
    {
        return !field_73476_b.startsWith("/");
    }

}
