// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler, ItemStack

public class Packet15Place extends Packet
{

    private int field_73415_a;
    private int field_73413_b;
    private int field_73414_c;
    private int field_73411_d;
    private ItemStack field_73412_e;
    private float field_73409_f;
    private float field_73410_g;
    private float field_73416_h;

    public Packet15Place()
    {
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73415_a = p_73267_1_.readInt();
        field_73413_b = p_73267_1_.read();
        field_73414_c = p_73267_1_.readInt();
        field_73411_d = p_73267_1_.read();
        field_73412_e = func_73276_c(p_73267_1_);
        field_73409_f = (float)p_73267_1_.read() / 16F;
        field_73410_g = (float)p_73267_1_.read() / 16F;
        field_73416_h = (float)p_73267_1_.read() / 16F;
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73415_a);
        p_73273_1_.write(field_73413_b);
        p_73273_1_.writeInt(field_73414_c);
        p_73273_1_.write(field_73411_d);
        func_73270_a(field_73412_e, p_73273_1_);
        p_73273_1_.write((int)(field_73409_f * 16F));
        p_73273_1_.write((int)(field_73410_g * 16F));
        p_73273_1_.write((int)(field_73416_h * 16F));
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72472_a(this);
    }

    public int func_73284_a()
    {
        return 19;
    }

    public int func_73403_d()
    {
        return field_73415_a;
    }

    public int func_73402_f()
    {
        return field_73413_b;
    }

    public int func_73407_g()
    {
        return field_73414_c;
    }

    public int func_73401_h()
    {
        return field_73411_d;
    }

    public ItemStack func_73405_i()
    {
        return field_73412_e;
    }

    public float func_73406_j()
    {
        return field_73409_f;
    }

    public float func_73404_l()
    {
        return field_73410_g;
    }

    public float func_73408_m()
    {
        return field_73416_h;
    }
}
