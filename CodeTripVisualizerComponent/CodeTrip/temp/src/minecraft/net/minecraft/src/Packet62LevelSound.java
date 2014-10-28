// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet62LevelSound extends Packet
{

    private String field_73579_a;
    private int field_73577_b;
    private int field_73578_c;
    private int field_73575_d;
    private float field_73576_e;
    private int field_73574_f;

    public Packet62LevelSound()
    {
        field_73578_c = 0x7fffffff;
    }

    public Packet62LevelSound(String p_i3326_1_, double p_i3326_2_, double p_i3326_4_, double p_i3326_6_, 
            float p_i3326_8_, float p_i3326_9_)
    {
        field_73578_c = 0x7fffffff;
        field_73579_a = p_i3326_1_;
        field_73577_b = (int)(p_i3326_2_ * 8D);
        field_73578_c = (int)(p_i3326_4_ * 8D);
        field_73575_d = (int)(p_i3326_6_ * 8D);
        field_73576_e = p_i3326_8_;
        field_73574_f = (int)(p_i3326_9_ * 63F);
        if(field_73574_f < 0)
        {
            field_73574_f = 0;
        }
        if(field_73574_f > 255)
        {
            field_73574_f = 255;
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73579_a = func_73282_a(p_73267_1_, 32);
        field_73577_b = p_73267_1_.readInt();
        field_73578_c = p_73267_1_.readInt();
        field_73575_d = p_73267_1_.readInt();
        field_73576_e = p_73267_1_.readFloat();
        field_73574_f = p_73267_1_.readUnsignedByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        func_73271_a(field_73579_a, p_73273_1_);
        p_73273_1_.writeInt(field_73577_b);
        p_73273_1_.writeInt(field_73578_c);
        p_73273_1_.writeInt(field_73575_d);
        p_73273_1_.writeFloat(field_73576_e);
        p_73273_1_.writeByte(field_73574_f);
    }

    public String func_73570_d()
    {
        return field_73579_a;
    }

    public double func_73572_f()
    {
        return (double)((float)field_73577_b / 8F);
    }

    public double func_73568_g()
    {
        return (double)((float)field_73578_c / 8F);
    }

    public double func_73569_h()
    {
        return (double)((float)field_73575_d / 8F);
    }

    public float func_73571_i()
    {
        return field_73576_e;
    }

    public float func_73573_j()
    {
        return (float)field_73574_f / 63F;
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72457_a(this);
    }

    public int func_73284_a()
    {
        return 24;
    }
}
