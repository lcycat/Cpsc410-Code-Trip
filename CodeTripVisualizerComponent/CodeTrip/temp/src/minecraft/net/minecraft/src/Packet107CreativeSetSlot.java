// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet107CreativeSetSlot extends Packet
{

    public int field_73385_a;
    public ItemStack field_73384_b;

    public Packet107CreativeSetSlot()
    {
    }

    public Packet107CreativeSetSlot(int p_i3346_1_, ItemStack p_i3346_2_)
    {
        field_73385_a = p_i3346_1_;
        field_73384_b = p_i3346_2_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72464_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73385_a = p_73267_1_.readShort();
        field_73384_b = func_73276_c(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeShort(field_73385_a);
        func_73270_a(field_73384_b, p_73273_1_);
    }

    public int func_73284_a()
    {
        return 8;
    }
}
