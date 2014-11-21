// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityPainting, EnumArt, NetHandler

public class Packet25EntityPainting extends Packet
{

    public int field_73508_a;
    public int field_73506_b;
    public int field_73507_c;
    public int field_73504_d;
    public int field_73505_e;
    public String field_73503_f;

    public Packet25EntityPainting()
    {
    }

    public Packet25EntityPainting(EntityPainting p_i3295_1_)
    {
        field_73508_a = p_i3295_1_.field_70157_k;
        field_73506_b = p_i3295_1_.field_70523_b;
        field_73507_c = p_i3295_1_.field_70524_c;
        field_73504_d = p_i3295_1_.field_70521_d;
        field_73505_e = p_i3295_1_.field_70525_a;
        field_73503_f = p_i3295_1_.field_70522_e.field_75702_A;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73508_a = p_73267_1_.readInt();
        field_73503_f = func_73282_a(p_73267_1_, EnumArt.field_75728_z);
        field_73506_b = p_73267_1_.readInt();
        field_73507_c = p_73267_1_.readInt();
        field_73504_d = p_73267_1_.readInt();
        field_73505_e = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73508_a);
        func_73271_a(field_73503_f, p_73273_1_);
        p_73273_1_.writeInt(field_73506_b);
        p_73273_1_.writeInt(field_73507_c);
        p_73273_1_.writeInt(field_73504_d);
        p_73273_1_.writeInt(field_73505_e);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72495_a(this);
    }

    public int func_73284_a()
    {
        return 24;
    }
}
