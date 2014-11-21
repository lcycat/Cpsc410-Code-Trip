// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet10Flying

public class Packet11PlayerPosition extends Packet10Flying
{

    public Packet11PlayerPosition()
    {
        field_73546_h = true;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73545_a = p_73267_1_.readDouble();
        field_73543_b = p_73267_1_.readDouble();
        field_73541_d = p_73267_1_.readDouble();
        field_73544_c = p_73267_1_.readDouble();
        super.func_73267_a(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeDouble(field_73545_a);
        p_73273_1_.writeDouble(field_73543_b);
        p_73273_1_.writeDouble(field_73541_d);
        p_73273_1_.writeDouble(field_73544_c);
        super.func_73273_a(p_73273_1_);
    }

    public int func_73284_a()
    {
        return 33;
    }
}
