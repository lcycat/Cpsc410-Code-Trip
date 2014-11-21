// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet7UseEntity extends Packet
{

    public int field_73606_a;
    public int field_73604_b;
    public int field_73605_c;

    public Packet7UseEntity()
    {
    }

    public Packet7UseEntity(int p_i3321_1_, int p_i3321_2_, int p_i3321_3_)
    {
        field_73606_a = p_i3321_1_;
        field_73604_b = p_i3321_2_;
        field_73605_c = p_i3321_3_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73606_a = p_73267_1_.readInt();
        field_73604_b = p_73267_1_.readInt();
        field_73605_c = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73606_a);
        p_73273_1_.writeInt(field_73604_b);
        p_73273_1_.writeByte(field_73605_c);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72507_a(this);
    }

    public int func_73284_a()
    {
        return 9;
    }
}
