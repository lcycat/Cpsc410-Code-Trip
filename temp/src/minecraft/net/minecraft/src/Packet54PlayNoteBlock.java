// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet54PlayNoteBlock extends Packet
{

    public int field_73340_a;
    public int field_73338_b;
    public int field_73339_c;
    public int field_73336_d;
    public int field_73337_e;
    public int field_73335_f;

    public Packet54PlayNoteBlock()
    {
    }

    public Packet54PlayNoteBlock(int p_i3363_1_, int p_i3363_2_, int p_i3363_3_, int p_i3363_4_, int p_i3363_5_, int p_i3363_6_)
    {
        field_73340_a = p_i3363_1_;
        field_73338_b = p_i3363_2_;
        field_73339_c = p_i3363_3_;
        field_73336_d = p_i3363_5_;
        field_73337_e = p_i3363_6_;
        field_73335_f = p_i3363_4_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73340_a = p_73267_1_.readInt();
        field_73338_b = p_73267_1_.readShort();
        field_73339_c = p_73267_1_.readInt();
        field_73336_d = p_73267_1_.read();
        field_73337_e = p_73267_1_.read();
        field_73335_f = p_73267_1_.readShort() & 0xfff;
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73340_a);
        p_73273_1_.writeShort(field_73338_b);
        p_73273_1_.writeInt(field_73339_c);
        p_73273_1_.write(field_73336_d);
        p_73273_1_.write(field_73337_e);
        p_73273_1_.writeShort(field_73335_f & 0xfff);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72454_a(this);
    }

    public int func_73284_a()
    {
        return 14;
    }
}
