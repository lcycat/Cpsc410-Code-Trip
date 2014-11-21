// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet14BlockDig extends Packet
{

    public int field_73345_a;
    public int field_73343_b;
    public int field_73344_c;
    public int field_73341_d;
    public int field_73342_e;

    public Packet14BlockDig()
    {
    }

    public Packet14BlockDig(int p_i3337_1_, int p_i3337_2_, int p_i3337_3_, int p_i3337_4_, int p_i3337_5_)
    {
        field_73342_e = p_i3337_1_;
        field_73345_a = p_i3337_2_;
        field_73343_b = p_i3337_3_;
        field_73344_c = p_i3337_4_;
        field_73341_d = p_i3337_5_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73342_e = p_73267_1_.read();
        field_73345_a = p_73267_1_.readInt();
        field_73343_b = p_73267_1_.read();
        field_73344_c = p_73267_1_.readInt();
        field_73341_d = p_73267_1_.read();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.write(field_73342_e);
        p_73273_1_.writeInt(field_73345_a);
        p_73273_1_.write(field_73343_b);
        p_73273_1_.writeInt(field_73344_c);
        p_73273_1_.write(field_73341_d);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72510_a(this);
    }

    public int func_73284_a()
    {
        return 11;
    }
}
