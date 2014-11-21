// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, NBTTagCompound

public class Packet132TileEntityData extends Packet
{

    public int field_73334_a;
    public int field_73332_b;
    public int field_73333_c;
    public int field_73330_d;
    public NBTTagCompound field_73331_e;

    public Packet132TileEntityData()
    {
        field_73287_r = true;
    }

    public Packet132TileEntityData(int p_i3362_1_, int p_i3362_2_, int p_i3362_3_, int p_i3362_4_, NBTTagCompound p_i3362_5_)
    {
        field_73287_r = true;
        field_73334_a = p_i3362_1_;
        field_73332_b = p_i3362_2_;
        field_73333_c = p_i3362_3_;
        field_73330_d = p_i3362_4_;
        field_73331_e = p_i3362_5_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73334_a = p_73267_1_.readInt();
        field_73332_b = p_73267_1_.readShort();
        field_73333_c = p_73267_1_.readInt();
        field_73330_d = p_73267_1_.readByte();
        field_73331_e = func_73283_d(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73334_a);
        p_73273_1_.writeShort(field_73332_b);
        p_73273_1_.writeInt(field_73333_c);
        p_73273_1_.writeByte((byte)field_73330_d);
        func_73275_a(field_73331_e, p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72468_a(this);
    }

    public int func_73284_a()
    {
        return 25;
    }
}
