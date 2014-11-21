// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, MathHelper, NetHandler

public class Packet23VehicleSpawn extends Packet
{

    public int field_73526_a;
    public int field_73524_b;
    public int field_73525_c;
    public int field_73522_d;
    public int field_73523_e;
    public int field_73520_f;
    public int field_73521_g;
    public int field_73527_h;
    public int field_73528_i;

    public Packet23VehicleSpawn()
    {
    }

    public Packet23VehicleSpawn(Entity p_i3289_1_, int p_i3289_2_)
    {
        this(p_i3289_1_, p_i3289_2_, 0);
    }

    public Packet23VehicleSpawn(Entity p_i3290_1_, int p_i3290_2_, int p_i3290_3_)
    {
        field_73526_a = p_i3290_1_.field_70157_k;
        field_73524_b = MathHelper.func_76128_c(p_i3290_1_.field_70165_t * 32D);
        field_73525_c = MathHelper.func_76128_c(p_i3290_1_.field_70163_u * 32D);
        field_73522_d = MathHelper.func_76128_c(p_i3290_1_.field_70161_v * 32D);
        field_73527_h = p_i3290_2_;
        field_73528_i = p_i3290_3_;
        if(p_i3290_3_ > 0)
        {
            double d = p_i3290_1_.field_70159_w;
            double d1 = p_i3290_1_.field_70181_x;
            double d2 = p_i3290_1_.field_70179_y;
            double d3 = 3.8999999999999999D;
            if(d < -d3)
            {
                d = -d3;
            }
            if(d1 < -d3)
            {
                d1 = -d3;
            }
            if(d2 < -d3)
            {
                d2 = -d3;
            }
            if(d > d3)
            {
                d = d3;
            }
            if(d1 > d3)
            {
                d1 = d3;
            }
            if(d2 > d3)
            {
                d2 = d3;
            }
            field_73523_e = (int)(d * 8000D);
            field_73520_f = (int)(d1 * 8000D);
            field_73521_g = (int)(d2 * 8000D);
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73526_a = p_73267_1_.readInt();
        field_73527_h = p_73267_1_.readByte();
        field_73524_b = p_73267_1_.readInt();
        field_73525_c = p_73267_1_.readInt();
        field_73522_d = p_73267_1_.readInt();
        field_73528_i = p_73267_1_.readInt();
        if(field_73528_i > 0)
        {
            field_73523_e = p_73267_1_.readShort();
            field_73520_f = p_73267_1_.readShort();
            field_73521_g = p_73267_1_.readShort();
        }
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73526_a);
        p_73273_1_.writeByte(field_73527_h);
        p_73273_1_.writeInt(field_73524_b);
        p_73273_1_.writeInt(field_73525_c);
        p_73273_1_.writeInt(field_73522_d);
        p_73273_1_.writeInt(field_73528_i);
        if(field_73528_i > 0)
        {
            p_73273_1_.writeShort(field_73523_e);
            p_73273_1_.writeShort(field_73520_f);
            p_73273_1_.writeShort(field_73521_g);
        }
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72511_a(this);
    }

    public int func_73284_a()
    {
        return 21 + field_73528_i <= 0 ? 0 : 6;
    }
}
