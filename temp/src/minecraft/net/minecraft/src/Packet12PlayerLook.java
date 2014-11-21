// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet10Flying

public class Packet12PlayerLook extends Packet10Flying
{

    public Packet12PlayerLook()
    {
        field_73547_i = true;
    }

    public Packet12PlayerLook(float p_i3334_1_, float p_i3334_2_, boolean p_i3334_3_)
    {
        field_73542_e = p_i3334_1_;
        field_73539_f = p_i3334_2_;
        field_73540_g = p_i3334_3_;
        field_73547_i = true;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73542_e = p_73267_1_.readFloat();
        field_73539_f = p_73267_1_.readFloat();
        super.func_73267_a(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeFloat(field_73542_e);
        p_73273_1_.writeFloat(field_73539_f);
        super.func_73273_a(p_73273_1_);
    }

    public int func_73284_a()
    {
        return 9;
    }
}
