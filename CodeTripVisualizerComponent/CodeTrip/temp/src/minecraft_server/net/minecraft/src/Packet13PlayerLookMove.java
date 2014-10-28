// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet10Flying

public class Packet13PlayerLookMove extends Packet10Flying
{

    public Packet13PlayerLookMove()
    {
        field_73547_i = true;
        field_73546_h = true;
    }

    public Packet13PlayerLookMove(double p_i3333_1_, double p_i3333_3_, double p_i3333_5_, double p_i3333_7_, float p_i3333_9_, float p_i3333_10_, boolean p_i3333_11_)
    {
        field_73545_a = p_i3333_1_;
        field_73543_b = p_i3333_3_;
        field_73541_d = p_i3333_5_;
        field_73544_c = p_i3333_7_;
        field_73542_e = p_i3333_9_;
        field_73539_f = p_i3333_10_;
        field_73540_g = p_i3333_11_;
        field_73547_i = true;
        field_73546_h = true;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73545_a = p_73267_1_.readDouble();
        field_73543_b = p_73267_1_.readDouble();
        field_73541_d = p_73267_1_.readDouble();
        field_73544_c = p_73267_1_.readDouble();
        field_73542_e = p_73267_1_.readFloat();
        field_73539_f = p_73267_1_.readFloat();
        super.func_73267_a(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeDouble(field_73545_a);
        p_73273_1_.writeDouble(field_73543_b);
        p_73273_1_.writeDouble(field_73541_d);
        p_73273_1_.writeDouble(field_73544_c);
        p_73273_1_.writeFloat(field_73542_e);
        p_73273_1_.writeFloat(field_73539_f);
        super.func_73273_a(p_73273_1_);
    }

    public int func_73284_a()
    {
        return 41;
    }
}
