// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet43Experience extends Packet
{

    public float field_73396_a;
    public int field_73394_b;
    public int field_73395_c;

    public Packet43Experience()
    {
    }

    public Packet43Experience(float p_i3351_1_, int p_i3351_2_, int p_i3351_3_)
    {
        field_73396_a = p_i3351_1_;
        field_73394_b = p_i3351_2_;
        field_73395_c = p_i3351_3_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73396_a = p_73267_1_.readFloat();
        field_73395_c = p_73267_1_.readShort();
        field_73394_b = p_73267_1_.readShort();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeFloat(field_73396_a);
        p_73273_1_.writeShort(field_73395_c);
        p_73273_1_.writeShort(field_73394_b);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72522_a(this);
    }

    public int func_73284_a()
    {
        return 4;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        return true;
    }

    public boolean func_73277_a_()
    {
        return true;
    }
}
