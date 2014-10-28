// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet131MapData extends Packet
{

    public short field_73438_a;
    public short field_73436_b;
    public byte field_73437_c[];

    public Packet131MapData()
    {
        field_73287_r = true;
    }

    public Packet131MapData(short p_i3306_1_, short p_i3306_2_, byte p_i3306_3_[])
    {
        field_73287_r = true;
        field_73438_a = p_i3306_1_;
        field_73436_b = p_i3306_2_;
        field_73437_c = p_i3306_3_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73438_a = p_73267_1_.readShort();
        field_73436_b = p_73267_1_.readShort();
        field_73437_c = new byte[p_73267_1_.readByte() & 0xff];
        p_73267_1_.readFully(field_73437_c);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeShort(field_73438_a);
        p_73273_1_.writeShort(field_73436_b);
        p_73273_1_.writeByte(field_73437_c.length);
        p_73273_1_.write(field_73437_c);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72494_a(this);
    }

    public int func_73284_a()
    {
        return 4 + field_73437_c.length;
    }
}
