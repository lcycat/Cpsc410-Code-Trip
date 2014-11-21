// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, PlayerCapabilities, NetHandler

public class Packet202PlayerAbilities extends Packet
{

    private boolean field_73362_a;
    private boolean field_73360_b;
    private boolean field_73361_c;
    private boolean field_73358_d;
    private float field_73359_e;
    private float field_73357_f;

    public Packet202PlayerAbilities()
    {
        field_73362_a = false;
        field_73360_b = false;
        field_73361_c = false;
        field_73358_d = false;
    }

    public Packet202PlayerAbilities(PlayerCapabilities p_i3336_1_)
    {
        field_73362_a = false;
        field_73360_b = false;
        field_73361_c = false;
        field_73358_d = false;
        func_73353_a(p_i3336_1_.field_75102_a);
        func_73349_b(p_i3336_1_.field_75100_b);
        func_73354_c(p_i3336_1_.field_75101_c);
        func_73356_d(p_i3336_1_.field_75098_d);
        func_73351_a(p_i3336_1_.func_75093_a());
        func_73355_b(p_i3336_1_.func_75094_b());
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        byte byte0 = p_73267_1_.readByte();
        func_73353_a((byte0 & 1) > 0);
        func_73349_b((byte0 & 2) > 0);
        func_73354_c((byte0 & 4) > 0);
        func_73356_d((byte0 & 8) > 0);
        func_73351_a((float)p_73267_1_.readByte() / 255F);
        func_73355_b((float)p_73267_1_.readByte() / 255F);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        byte byte0 = 0;
        if(func_73352_d())
        {
            byte0 |= 1;
        }
        if(func_73350_f())
        {
            byte0 |= 2;
        }
        if(func_73348_g())
        {
            byte0 |= 4;
        }
        if(func_73346_h())
        {
            byte0 |= 8;
        }
        p_73273_1_.writeByte(byte0);
        p_73273_1_.writeByte((int)(field_73359_e * 255F));
        p_73273_1_.writeByte((int)(field_73357_f * 255F));
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72471_a(this);
    }

    public int func_73284_a()
    {
        return 2;
    }

    public boolean func_73352_d()
    {
        return field_73362_a;
    }

    public void func_73353_a(boolean p_73353_1_)
    {
        field_73362_a = p_73353_1_;
    }

    public boolean func_73350_f()
    {
        return field_73360_b;
    }

    public void func_73349_b(boolean p_73349_1_)
    {
        field_73360_b = p_73349_1_;
    }

    public boolean func_73348_g()
    {
        return field_73361_c;
    }

    public void func_73354_c(boolean p_73354_1_)
    {
        field_73361_c = p_73354_1_;
    }

    public boolean func_73346_h()
    {
        return field_73358_d;
    }

    public void func_73356_d(boolean p_73356_1_)
    {
        field_73358_d = p_73356_1_;
    }

    public void func_73351_a(float p_73351_1_)
    {
        field_73359_e = p_73351_1_;
    }

    public void func_73355_b(float p_73355_1_)
    {
        field_73357_f = p_73355_1_;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        return true;
    }
}
