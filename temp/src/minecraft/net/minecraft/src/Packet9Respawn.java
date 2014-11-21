// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, EnumGameType, WorldType

public class Packet9Respawn extends Packet
{

    public int field_73373_a;
    public int field_73371_b;
    public int field_73372_c;
    public EnumGameType field_73369_d;
    public WorldType field_73370_e;

    public Packet9Respawn()
    {
    }

    public Packet9Respawn(int p_i3342_1_, byte p_i3342_2_, WorldType p_i3342_3_, int p_i3342_4_, EnumGameType p_i3342_5_)
    {
        field_73373_a = p_i3342_1_;
        field_73371_b = p_i3342_2_;
        field_73372_c = p_i3342_4_;
        field_73369_d = p_i3342_5_;
        field_73370_e = p_i3342_3_;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72483_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73373_a = p_73267_1_.readInt();
        field_73371_b = p_73267_1_.readByte();
        field_73369_d = EnumGameType.func_77146_a(p_73267_1_.readByte());
        field_73372_c = p_73267_1_.readShort();
        String s = func_73282_a(p_73267_1_, 16);
        field_73370_e = WorldType.func_77130_a(s);
        if(field_73370_e == null)
        {
            field_73370_e = WorldType.field_77137_b;
        }
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73373_a);
        p_73273_1_.writeByte(field_73371_b);
        p_73273_1_.writeByte(field_73369_d.func_77148_a());
        p_73273_1_.writeShort(field_73372_c);
        func_73271_a(field_73370_e.func_77127_a(), p_73273_1_);
    }

    public int func_73284_a()
    {
        return 8 + (field_73370_e != null ? field_73370_e.func_77127_a().length() : 0);
    }
}
