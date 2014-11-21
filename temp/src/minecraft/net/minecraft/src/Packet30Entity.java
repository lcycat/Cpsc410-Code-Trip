// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet30Entity extends Packet
{

    public int field_73554_a;
    public byte field_73552_b;
    public byte field_73553_c;
    public byte field_73550_d;
    public byte field_73551_e;
    public byte field_73548_f;
    public boolean field_73549_g;

    public Packet30Entity()
    {
        field_73549_g = false;
    }

    public Packet30Entity(int p_i3331_1_)
    {
        field_73549_g = false;
        field_73554_a = p_i3331_1_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73554_a = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73554_a);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72482_a(this);
    }

    public int func_73284_a()
    {
        return 4;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Entity_").append(super.toString()).toString();
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        Packet30Entity packet30entity = (Packet30Entity)p_73268_1_;
        return packet30entity.field_73554_a == field_73554_a;
    }
}
