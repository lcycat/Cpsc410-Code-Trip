// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, PotionEffect, NetHandler

public class Packet41EntityEffect extends Packet
{

    public int field_73420_a;
    public byte field_73418_b;
    public byte field_73419_c;
    public short field_73417_d;

    public Packet41EntityEffect()
    {
    }

    public Packet41EntityEffect(int p_i3365_1_, PotionEffect p_i3365_2_)
    {
        field_73420_a = p_i3365_1_;
        field_73418_b = (byte)(p_i3365_2_.func_76456_a() & 0xff);
        field_73419_c = (byte)(p_i3365_2_.func_76458_c() & 0xff);
        field_73417_d = (short)p_i3365_2_.func_76459_b();
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73420_a = p_73267_1_.readInt();
        field_73418_b = p_73267_1_.readByte();
        field_73419_c = p_73267_1_.readByte();
        field_73417_d = p_73267_1_.readShort();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73420_a);
        p_73273_1_.writeByte(field_73418_b);
        p_73273_1_.writeByte(field_73419_c);
        p_73273_1_.writeShort(field_73417_d);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72503_a(this);
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
        Packet41EntityEffect packet41entityeffect = (Packet41EntityEffect)p_73268_1_;
        return packet41entityeffect.field_73420_a == field_73420_a && packet41entityeffect.field_73418_b == field_73418_b;
    }
}
