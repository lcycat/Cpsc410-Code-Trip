// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet200Statistic extends Packet
{

    public int field_73472_a;
    public int field_73471_b;

    public Packet200Statistic()
    {
    }

    public Packet200Statistic(int p_i3298_1_, int p_i3298_2_)
    {
        field_73472_a = p_i3298_1_;
        field_73471_b = p_i3298_2_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72517_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73472_a = p_73267_1_.readInt();
        field_73471_b = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73472_a);
        p_73273_1_.writeByte(field_73471_b);
    }

    public int func_73284_a()
    {
        return 6;
    }

    public boolean func_73277_a_()
    {
        return true;
    }
}
