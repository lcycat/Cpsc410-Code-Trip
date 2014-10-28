// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet106Transaction extends Packet
{

    public int field_73435_a;
    public short field_73433_b;
    public boolean field_73434_c;

    public Packet106Transaction()
    {
    }

    public Packet106Transaction(int p_i3307_1_, short p_i3307_2_, boolean p_i3307_3_)
    {
        field_73435_a = p_i3307_1_;
        field_73433_b = p_i3307_2_;
        field_73434_c = p_i3307_3_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72476_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73435_a = p_73267_1_.readByte();
        field_73433_b = p_73267_1_.readShort();
        field_73434_c = p_73267_1_.readByte() != 0;
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73435_a);
        p_73273_1_.writeShort(field_73433_b);
        p_73273_1_.writeByte(field_73434_c ? 1 : 0);
    }

    public int func_73284_a()
    {
        return 4;
    }
}
