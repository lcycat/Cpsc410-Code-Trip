// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet8UpdateHealth extends Packet
{

    public int field_73640_a;
    public int field_73638_b;
    public float field_73639_c;

    public Packet8UpdateHealth()
    {
    }

    public Packet8UpdateHealth(int p_i3352_1_, int p_i3352_2_, float p_i3352_3_)
    {
        field_73640_a = p_i3352_1_;
        field_73638_b = p_i3352_2_;
        field_73639_c = p_i3352_3_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73640_a = p_73267_1_.readShort();
        field_73638_b = p_73267_1_.readShort();
        field_73639_c = p_73267_1_.readFloat();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeShort(field_73640_a);
        p_73273_1_.writeShort(field_73638_b);
        p_73273_1_.writeFloat(field_73639_c);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72521_a(this);
    }

    public int func_73284_a()
    {
        return 8;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        return true;
    }
}
