// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, MathHelper, NetHandler

public class Packet34EntityTeleport extends Packet
{

    public int field_73319_a;
    public int field_73317_b;
    public int field_73318_c;
    public int field_73315_d;
    public byte field_73316_e;
    public byte field_73314_f;

    public Packet34EntityTeleport()
    {
    }

    public Packet34EntityTeleport(Entity p_i3359_1_)
    {
        field_73319_a = p_i3359_1_.field_70157_k;
        field_73317_b = MathHelper.func_76128_c(p_i3359_1_.field_70165_t * 32D);
        field_73318_c = MathHelper.func_76128_c(p_i3359_1_.field_70163_u * 32D);
        field_73315_d = MathHelper.func_76128_c(p_i3359_1_.field_70161_v * 32D);
        field_73316_e = (byte)(int)((p_i3359_1_.field_70177_z * 256F) / 360F);
        field_73314_f = (byte)(int)((p_i3359_1_.field_70125_A * 256F) / 360F);
    }

    public Packet34EntityTeleport(int p_i3360_1_, int p_i3360_2_, int p_i3360_3_, int p_i3360_4_, byte p_i3360_5_, byte p_i3360_6_)
    {
        field_73319_a = p_i3360_1_;
        field_73317_b = p_i3360_2_;
        field_73318_c = p_i3360_3_;
        field_73315_d = p_i3360_4_;
        field_73316_e = p_i3360_5_;
        field_73314_f = p_i3360_6_;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73319_a = p_73267_1_.readInt();
        field_73317_b = p_73267_1_.readInt();
        field_73318_c = p_73267_1_.readInt();
        field_73315_d = p_73267_1_.readInt();
        field_73316_e = (byte)p_73267_1_.read();
        field_73314_f = (byte)p_73267_1_.read();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73319_a);
        p_73273_1_.writeInt(field_73317_b);
        p_73273_1_.writeInt(field_73318_c);
        p_73273_1_.writeInt(field_73315_d);
        p_73273_1_.write(field_73316_e);
        p_73273_1_.write(field_73314_f);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72512_a(this);
    }

    public int func_73284_a()
    {
        return 34;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        Packet34EntityTeleport packet34entityteleport = (Packet34EntityTeleport)p_73268_1_;
        return packet34entityteleport.field_73319_a == field_73319_a;
    }
}
