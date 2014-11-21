// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet130UpdateSign extends Packet
{

    public int field_73311_a;
    public int field_73309_b;
    public int field_73310_c;
    public String field_73308_d[];

    public Packet130UpdateSign()
    {
        field_73287_r = true;
    }

    public Packet130UpdateSign(int p_i3357_1_, int p_i3357_2_, int p_i3357_3_, String p_i3357_4_[])
    {
        field_73287_r = true;
        field_73311_a = p_i3357_1_;
        field_73309_b = p_i3357_2_;
        field_73310_c = p_i3357_3_;
        field_73308_d = (new String[] {
            p_i3357_4_[0], p_i3357_4_[1], p_i3357_4_[2], p_i3357_4_[3]
        });
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73311_a = p_73267_1_.readInt();
        field_73309_b = p_73267_1_.readShort();
        field_73310_c = p_73267_1_.readInt();
        field_73308_d = new String[4];
        for(int i = 0; i < 4; i++)
        {
            field_73308_d[i] = func_73282_a(p_73267_1_, 15);
        }

    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73311_a);
        p_73273_1_.writeShort(field_73309_b);
        p_73273_1_.writeInt(field_73310_c);
        for(int i = 0; i < 4; i++)
        {
            func_73271_a(field_73308_d[i], p_73273_1_);
        }

    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72487_a(this);
    }

    public int func_73284_a()
    {
        int i = 0;
        for(int j = 0; j < 4; j++)
        {
            i += field_73308_d[j].length();
        }

        return i;
    }
}
