// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet70GameEvent extends Packet
{

    public static final String field_73620_a[] = {
        "tile.bed.notValid", null, null, "gameMode.changed"
    };
    public int field_73618_b;
    public int field_73619_c;

    public Packet70GameEvent()
    {
    }

    public Packet70GameEvent(int p_i3320_1_, int p_i3320_2_)
    {
        field_73618_b = p_i3320_1_;
        field_73619_c = p_i3320_2_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73618_b = p_73267_1_.readByte();
        field_73619_c = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73618_b);
        p_73273_1_.writeByte(field_73619_c);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72488_a(this);
    }

    public int func_73284_a()
    {
        return 2;
    }

}
