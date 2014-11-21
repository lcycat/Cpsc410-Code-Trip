// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityXPOrb, MathHelper, NetHandler

public class Packet26EntityExpOrb extends Packet
{

    public int field_73533_a;
    public int field_73531_b;
    public int field_73532_c;
    public int field_73529_d;
    public int field_73530_e;

    public Packet26EntityExpOrb()
    {
    }

    public Packet26EntityExpOrb(EntityXPOrb p_i3291_1_)
    {
        field_73533_a = p_i3291_1_.field_70157_k;
        field_73531_b = MathHelper.func_76128_c(p_i3291_1_.field_70165_t * 32D);
        field_73532_c = MathHelper.func_76128_c(p_i3291_1_.field_70163_u * 32D);
        field_73529_d = MathHelper.func_76128_c(p_i3291_1_.field_70161_v * 32D);
        field_73530_e = p_i3291_1_.func_70526_d();
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73533_a = p_73267_1_.readInt();
        field_73531_b = p_73267_1_.readInt();
        field_73532_c = p_73267_1_.readInt();
        field_73529_d = p_73267_1_.readInt();
        field_73530_e = p_73267_1_.readShort();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73533_a);
        p_73273_1_.writeInt(field_73531_b);
        p_73273_1_.writeInt(field_73532_c);
        p_73273_1_.writeInt(field_73529_d);
        p_73273_1_.writeShort(field_73530_e);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72514_a(this);
    }

    public int func_73284_a()
    {
        return 18;
    }
}
