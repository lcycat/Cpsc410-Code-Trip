// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet55BlockDestroy extends Packet
{

    private int field_73329_a;
    private int field_73327_b;
    private int field_73328_c;
    private int field_73325_d;
    private int field_73326_e;

    public Packet55BlockDestroy()
    {
    }

    public Packet55BlockDestroy(int p_i3361_1_, int p_i3361_2_, int p_i3361_3_, int p_i3361_4_, int p_i3361_5_)
    {
        field_73329_a = p_i3361_1_;
        field_73327_b = p_i3361_2_;
        field_73328_c = p_i3361_3_;
        field_73325_d = p_i3361_4_;
        field_73326_e = p_i3361_5_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73329_a = p_73267_1_.readInt();
        field_73327_b = p_73267_1_.readInt();
        field_73328_c = p_73267_1_.readInt();
        field_73325_d = p_73267_1_.readInt();
        field_73326_e = p_73267_1_.read();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73329_a);
        p_73273_1_.writeInt(field_73327_b);
        p_73273_1_.writeInt(field_73328_c);
        p_73273_1_.writeInt(field_73325_d);
        p_73273_1_.write(field_73326_e);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72465_a(this);
    }

    public int func_73284_a()
    {
        return 13;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        Packet55BlockDestroy packet55blockdestroy = (Packet55BlockDestroy)p_73268_1_;
        return packet55blockdestroy.field_73329_a == field_73329_a;
    }
}
