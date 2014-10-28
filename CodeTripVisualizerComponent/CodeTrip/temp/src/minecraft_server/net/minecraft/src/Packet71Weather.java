// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, MathHelper, EntityLightningBolt, 
//            NetHandler

public class Packet71Weather extends Packet
{

    public int field_73538_a;
    public int field_73536_b;
    public int field_73537_c;
    public int field_73534_d;
    public int field_73535_e;

    public Packet71Weather()
    {
    }

    public Packet71Weather(Entity p_i3292_1_)
    {
        field_73538_a = p_i3292_1_.field_70157_k;
        field_73536_b = MathHelper.func_76128_c(p_i3292_1_.field_70165_t * 32D);
        field_73537_c = MathHelper.func_76128_c(p_i3292_1_.field_70163_u * 32D);
        field_73534_d = MathHelper.func_76128_c(p_i3292_1_.field_70161_v * 32D);
        if(p_i3292_1_ instanceof EntityLightningBolt)
        {
            field_73535_e = 1;
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73538_a = p_73267_1_.readInt();
        field_73535_e = p_73267_1_.readByte();
        field_73536_b = p_73267_1_.readInt();
        field_73537_c = p_73267_1_.readInt();
        field_73534_d = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73538_a);
        p_73273_1_.writeByte(field_73535_e);
        p_73273_1_.writeInt(field_73536_b);
        p_73273_1_.writeInt(field_73537_c);
        p_73273_1_.writeInt(field_73534_d);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72508_a(this);
    }

    public int func_73284_a()
    {
        return 17;
    }
}
