// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, WorldType, EnumGameType, NetHandler

public class Packet1Login extends Packet
{

    public int field_73561_a;
    public WorldType field_73559_b;
    public boolean field_73560_c;
    public EnumGameType field_73557_d;
    public int field_73558_e;
    public byte field_73555_f;
    public byte field_73556_g;
    public byte field_73562_h;

    public Packet1Login()
    {
        field_73561_a = 0;
    }

    public Packet1Login(int p_i3327_1_, WorldType p_i3327_2_, EnumGameType p_i3327_3_, boolean p_i3327_4_, int p_i3327_5_, int p_i3327_6_, int p_i3327_7_, 
            int p_i3327_8_)
    {
        field_73561_a = 0;
        field_73561_a = p_i3327_1_;
        field_73559_b = p_i3327_2_;
        field_73558_e = p_i3327_5_;
        field_73555_f = (byte)p_i3327_6_;
        field_73557_d = p_i3327_3_;
        field_73556_g = (byte)p_i3327_7_;
        field_73562_h = (byte)p_i3327_8_;
        field_73560_c = p_i3327_4_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73561_a = p_73267_1_.readInt();
        String s = func_73282_a(p_73267_1_, 16);
        field_73559_b = WorldType.func_77130_a(s);
        if(field_73559_b == null)
        {
            field_73559_b = WorldType.field_77137_b;
        }
        int i = p_73267_1_.readByte();
        field_73560_c = (i & 8) == 8;
        i &= -9;
        field_73557_d = EnumGameType.func_77146_a(i);
        field_73558_e = p_73267_1_.readByte();
        field_73555_f = p_73267_1_.readByte();
        field_73556_g = p_73267_1_.readByte();
        field_73562_h = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73561_a);
        func_73271_a(field_73559_b != null ? field_73559_b.func_77127_a() : "", p_73273_1_);
        int i = field_73557_d.func_77148_a();
        if(field_73560_c)
        {
            i |= 8;
        }
        p_73273_1_.writeByte(i);
        p_73273_1_.writeByte(field_73558_e);
        p_73273_1_.writeByte(field_73555_f);
        p_73273_1_.writeByte(field_73556_g);
        p_73273_1_.writeByte(field_73562_h);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72455_a(this);
    }

    public int func_73284_a()
    {
        int i = 0;
        if(field_73559_b != null)
        {
            i = field_73559_b.func_77127_a().length();
        }
        return 6 + 2 * i + 4 + 4 + 1 + 1 + 1;
    }
}
