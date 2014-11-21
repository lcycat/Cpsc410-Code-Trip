// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, NetHandler

public class Packet17Sleep extends Packet
{

    public int field_73625_a;
    public int field_73623_b;
    public int field_73624_c;
    public int field_73621_d;
    public int field_73622_e;

    public Packet17Sleep()
    {
    }

    public Packet17Sleep(Entity p_i3317_1_, int p_i3317_2_, int p_i3317_3_, int p_i3317_4_, int p_i3317_5_)
    {
        field_73622_e = p_i3317_2_;
        field_73623_b = p_i3317_3_;
        field_73624_c = p_i3317_4_;
        field_73621_d = p_i3317_5_;
        field_73625_a = p_i3317_1_.field_70157_k;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73625_a = p_73267_1_.readInt();
        field_73622_e = p_73267_1_.readByte();
        field_73623_b = p_73267_1_.readInt();
        field_73624_c = p_73267_1_.readByte();
        field_73621_d = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73625_a);
        p_73273_1_.writeByte(field_73622_e);
        p_73273_1_.writeInt(field_73623_b);
        p_73273_1_.writeByte(field_73624_c);
        p_73273_1_.writeInt(field_73621_d);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72460_a(this);
    }

    public int func_73284_a()
    {
        return 14;
    }
}
