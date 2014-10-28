// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Packet, DataWatcher, NetHandler

public class Packet40EntityMetadata extends Packet
{

    public int field_73393_a;
    private List field_73392_b;

    public Packet40EntityMetadata()
    {
    }

    public Packet40EntityMetadata(int p_i3347_1_, DataWatcher p_i3347_2_)
    {
        field_73393_a = p_i3347_1_;
        field_73392_b = p_i3347_2_.func_75688_b();
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73393_a = p_73267_1_.readInt();
        field_73392_b = DataWatcher.func_75686_a(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73393_a);
        DataWatcher.func_75680_a(field_73392_b, p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72493_a(this);
    }

    public int func_73284_a()
    {
        return 5;
    }

    public boolean func_73277_a_()
    {
        return true;
    }
}
