// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet105UpdateProgressbar extends Packet
{

    public int field_73634_a;
    public int field_73632_b;
    public int field_73633_c;

    public Packet105UpdateProgressbar()
    {
    }

    public Packet105UpdateProgressbar(int p_i3313_1_, int p_i3313_2_, int p_i3313_3_)
    {
        field_73634_a = p_i3313_1_;
        field_73632_b = p_i3313_2_;
        field_73633_c = p_i3313_3_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72505_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73634_a = p_73267_1_.readByte();
        field_73632_b = p_73267_1_.readShort();
        field_73633_c = p_73267_1_.readShort();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73634_a);
        p_73273_1_.writeShort(field_73632_b);
        p_73273_1_.writeShort(field_73633_c);
    }

    public int func_73284_a()
    {
        return 5;
    }
}
