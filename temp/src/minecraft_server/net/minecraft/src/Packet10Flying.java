// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet10Flying extends Packet
{

    public double field_73545_a;
    public double field_73543_b;
    public double field_73544_c;
    public double field_73541_d;
    public float field_73542_e;
    public float field_73539_f;
    public boolean field_73540_g;
    public boolean field_73546_h;
    public boolean field_73547_i;

    public Packet10Flying()
    {
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72498_a(this);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73540_g = p_73267_1_.read() != 0;
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.write(field_73540_g ? 1 : 0);
    }

    public int func_73284_a()
    {
        return 1;
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
