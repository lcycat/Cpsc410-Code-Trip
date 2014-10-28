// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet61DoorChange extends Packet
{

    public int field_73567_a;
    public int field_73565_b;
    public int field_73566_c;
    public int field_73563_d;
    public int field_73564_e;

    public Packet61DoorChange()
    {
    }

    public Packet61DoorChange(int p_i3325_1_, int p_i3325_2_, int p_i3325_3_, int p_i3325_4_, int p_i3325_5_)
    {
        field_73567_a = p_i3325_1_;
        field_73566_c = p_i3325_2_;
        field_73563_d = p_i3325_3_;
        field_73564_e = p_i3325_4_;
        field_73565_b = p_i3325_5_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73567_a = p_73267_1_.readInt();
        field_73566_c = p_73267_1_.readInt();
        field_73563_d = p_73267_1_.readByte() & 0xff;
        field_73564_e = p_73267_1_.readInt();
        field_73565_b = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73567_a);
        p_73273_1_.writeInt(field_73566_c);
        p_73273_1_.writeByte(field_73563_d & 0xff);
        p_73273_1_.writeInt(field_73564_e);
        p_73273_1_.writeInt(field_73565_b);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72462_a(this);
    }

    public int func_73284_a()
    {
        return 20;
    }
}
