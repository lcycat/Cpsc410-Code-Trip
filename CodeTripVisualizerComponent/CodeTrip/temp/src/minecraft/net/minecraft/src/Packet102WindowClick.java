// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet102WindowClick extends Packet
{

    public int field_73444_a;
    public int field_73442_b;
    public int field_73443_c;
    public short field_73440_d;
    public ItemStack field_73441_e;
    public boolean field_73439_f;

    public Packet102WindowClick()
    {
    }

    public Packet102WindowClick(int p_i3309_1_, int p_i3309_2_, int p_i3309_3_, boolean p_i3309_4_, ItemStack p_i3309_5_, short p_i3309_6_)
    {
        field_73444_a = p_i3309_1_;
        field_73442_b = p_i3309_2_;
        field_73443_c = p_i3309_3_;
        field_73441_e = p_i3309_5_;
        field_73440_d = p_i3309_6_;
        field_73439_f = p_i3309_4_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72523_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73444_a = p_73267_1_.readByte();
        field_73442_b = p_73267_1_.readShort();
        field_73443_c = p_73267_1_.readByte();
        field_73440_d = p_73267_1_.readShort();
        field_73439_f = p_73267_1_.readBoolean();
        field_73441_e = func_73276_c(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73444_a);
        p_73273_1_.writeShort(field_73442_b);
        p_73273_1_.writeByte(field_73443_c);
        p_73273_1_.writeShort(field_73440_d);
        p_73273_1_.writeBoolean(field_73439_f);
        func_73270_a(field_73441_e, p_73273_1_);
    }

    public int func_73284_a()
    {
        return 11;
    }
}
