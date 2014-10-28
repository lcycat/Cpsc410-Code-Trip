// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, NetHandler

public class Packet28EntityVelocity extends Packet
{

    public int field_73390_a;
    public int field_73388_b;
    public int field_73389_c;
    public int field_73387_d;

    public Packet28EntityVelocity()
    {
    }

    public Packet28EntityVelocity(Entity p_i3348_1_)
    {
        this(p_i3348_1_.field_70157_k, p_i3348_1_.field_70159_w, p_i3348_1_.field_70181_x, p_i3348_1_.field_70179_y);
    }

    public Packet28EntityVelocity(int p_i3349_1_, double p_i3349_2_, double p_i3349_4_, double p_i3349_6_)
    {
        field_73390_a = p_i3349_1_;
        double d = 3.8999999999999999D;
        if(p_i3349_2_ < -d)
        {
            p_i3349_2_ = -d;
        }
        if(p_i3349_4_ < -d)
        {
            p_i3349_4_ = -d;
        }
        if(p_i3349_6_ < -d)
        {
            p_i3349_6_ = -d;
        }
        if(p_i3349_2_ > d)
        {
            p_i3349_2_ = d;
        }
        if(p_i3349_4_ > d)
        {
            p_i3349_4_ = d;
        }
        if(p_i3349_6_ > d)
        {
            p_i3349_6_ = d;
        }
        field_73388_b = (int)(p_i3349_2_ * 8000D);
        field_73389_c = (int)(p_i3349_4_ * 8000D);
        field_73387_d = (int)(p_i3349_6_ * 8000D);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73390_a = p_73267_1_.readInt();
        field_73388_b = p_73267_1_.readShort();
        field_73389_c = p_73267_1_.readShort();
        field_73387_d = p_73267_1_.readShort();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73390_a);
        p_73273_1_.writeShort(field_73388_b);
        p_73273_1_.writeShort(field_73389_c);
        p_73273_1_.writeShort(field_73387_d);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72520_a(this);
    }

    public int func_73284_a()
    {
        return 10;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        Packet28EntityVelocity packet28entityvelocity = (Packet28EntityVelocity)p_73268_1_;
        return packet28entityvelocity.field_73390_a == field_73390_a;
    }
}
