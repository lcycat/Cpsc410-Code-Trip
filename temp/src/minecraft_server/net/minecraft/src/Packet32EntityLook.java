// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet30Entity

public class Packet32EntityLook extends Packet30Entity
{

    public Packet32EntityLook()
    {
        field_73549_g = true;
    }

    public Packet32EntityLook(int p_i3330_1_, byte p_i3330_2_, byte p_i3330_3_)
    {
        super(p_i3330_1_);
        field_73551_e = p_i3330_2_;
        field_73548_f = p_i3330_3_;
        field_73549_g = true;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        super.func_73267_a(p_73267_1_);
        field_73551_e = p_73267_1_.readByte();
        field_73548_f = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        super.func_73273_a(p_73273_1_);
        p_73273_1_.writeByte(field_73551_e);
        p_73273_1_.writeByte(field_73548_f);
    }

    public int func_73284_a()
    {
        return 6;
    }
}
