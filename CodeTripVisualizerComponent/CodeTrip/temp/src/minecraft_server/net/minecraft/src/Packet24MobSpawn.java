// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityLiving, EntityList, EnumEntitySize, 
//            MathHelper, DataWatcher, NetHandler

public class Packet24MobSpawn extends Packet
{

    public int field_73496_a;
    public int field_73494_b;
    public int field_73495_c;
    public int field_73492_d;
    public int field_73493_e;
    public int field_73490_f;
    public int field_73491_g;
    public int field_73499_h;
    public byte field_73500_i;
    public byte field_73497_j;
    public byte field_73498_k;
    private DataWatcher field_73502_s;
    private List field_73501_t;

    public Packet24MobSpawn()
    {
    }

    public Packet24MobSpawn(EntityLiving p_i3294_1_)
    {
        field_73496_a = p_i3294_1_.field_70157_k;
        field_73494_b = (byte)EntityList.func_75619_a(p_i3294_1_);
        field_73495_c = p_i3294_1_.field_70168_am.func_75630_a(p_i3294_1_.field_70165_t);
        field_73492_d = MathHelper.func_76128_c(p_i3294_1_.field_70163_u * 32D);
        field_73493_e = p_i3294_1_.field_70168_am.func_75630_a(p_i3294_1_.field_70161_v);
        field_73500_i = (byte)(int)((p_i3294_1_.field_70177_z * 256F) / 360F);
        field_73497_j = (byte)(int)((p_i3294_1_.field_70125_A * 256F) / 360F);
        field_73498_k = (byte)(int)((p_i3294_1_.field_70759_as * 256F) / 360F);
        double d = 3.8999999999999999D;
        double d1 = p_i3294_1_.field_70159_w;
        double d2 = p_i3294_1_.field_70181_x;
        double d3 = p_i3294_1_.field_70179_y;
        if(d1 < -d)
        {
            d1 = -d;
        }
        if(d2 < -d)
        {
            d2 = -d;
        }
        if(d3 < -d)
        {
            d3 = -d;
        }
        if(d1 > d)
        {
            d1 = d;
        }
        if(d2 > d)
        {
            d2 = d;
        }
        if(d3 > d)
        {
            d3 = d;
        }
        field_73490_f = (int)(d1 * 8000D);
        field_73491_g = (int)(d2 * 8000D);
        field_73499_h = (int)(d3 * 8000D);
        field_73502_s = p_i3294_1_.func_70096_w();
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73496_a = p_73267_1_.readInt();
        field_73494_b = p_73267_1_.readByte() & 0xff;
        field_73495_c = p_73267_1_.readInt();
        field_73492_d = p_73267_1_.readInt();
        field_73493_e = p_73267_1_.readInt();
        field_73500_i = p_73267_1_.readByte();
        field_73497_j = p_73267_1_.readByte();
        field_73498_k = p_73267_1_.readByte();
        field_73490_f = p_73267_1_.readShort();
        field_73491_g = p_73267_1_.readShort();
        field_73499_h = p_73267_1_.readShort();
        field_73501_t = DataWatcher.func_75686_a(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73496_a);
        p_73273_1_.writeByte(field_73494_b & 0xff);
        p_73273_1_.writeInt(field_73495_c);
        p_73273_1_.writeInt(field_73492_d);
        p_73273_1_.writeInt(field_73493_e);
        p_73273_1_.writeByte(field_73500_i);
        p_73273_1_.writeByte(field_73497_j);
        p_73273_1_.writeByte(field_73498_k);
        p_73273_1_.writeShort(field_73490_f);
        p_73273_1_.writeShort(field_73491_g);
        p_73273_1_.writeShort(field_73499_h);
        field_73502_s.func_75689_a(p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72519_a(this);
    }

    public int func_73284_a()
    {
        return 26;
    }
}
