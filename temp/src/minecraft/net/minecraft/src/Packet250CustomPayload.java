// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet250CustomPayload extends Packet
{

    public String field_73630_a;
    public int field_73628_b;
    public byte field_73629_c[];

    public Packet250CustomPayload()
    {
    }

    public Packet250CustomPayload(String p_i3315_1_, byte p_i3315_2_[])
    {
        field_73630_a = p_i3315_1_;
        field_73629_c = p_i3315_2_;
        if(p_i3315_2_ != null)
        {
            field_73628_b = p_i3315_2_.length;
            if(field_73628_b > 32767)
            {
                throw new IllegalArgumentException("Payload may not be larger than 32k");
            }
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73630_a = func_73282_a(p_73267_1_, 20);
        field_73628_b = p_73267_1_.readShort();
        if(field_73628_b > 0 && field_73628_b < 32767)
        {
            field_73629_c = new byte[field_73628_b];
            p_73267_1_.readFully(field_73629_c);
        }
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73271_a(field_73630_a, p_73273_1_);
        p_73273_1_.writeShort((short)field_73628_b);
        if(field_73629_c != null)
        {
            p_73273_1_.write(field_73629_c);
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72501_a(this);
    }

    public int func_73284_a()
    {
        return 2 + field_73630_a.length() * 2 + 2 + field_73628_b;
    }
}
