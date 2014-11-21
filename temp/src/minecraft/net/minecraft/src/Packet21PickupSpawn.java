// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityItem, ItemStack, MathHelper, 
//            NetHandler

public class Packet21PickupSpawn extends Packet
{

    public int field_73485_a;
    public int field_73483_b;
    public int field_73484_c;
    public int field_73481_d;
    public byte field_73482_e;
    public byte field_73479_f;
    public byte field_73480_g;
    public int field_73487_h;
    public int field_73488_i;
    public int field_73486_j;

    public Packet21PickupSpawn()
    {
    }

    public Packet21PickupSpawn(EntityItem p_i3293_1_)
    {
        field_73485_a = p_i3293_1_.field_70157_k;
        field_73487_h = p_i3293_1_.field_70294_a.field_77993_c;
        field_73488_i = p_i3293_1_.field_70294_a.field_77994_a;
        field_73486_j = p_i3293_1_.field_70294_a.func_77960_j();
        field_73483_b = MathHelper.func_76128_c(p_i3293_1_.field_70165_t * 32D);
        field_73484_c = MathHelper.func_76128_c(p_i3293_1_.field_70163_u * 32D);
        field_73481_d = MathHelper.func_76128_c(p_i3293_1_.field_70161_v * 32D);
        field_73482_e = (byte)(int)(p_i3293_1_.field_70159_w * 128D);
        field_73479_f = (byte)(int)(p_i3293_1_.field_70181_x * 128D);
        field_73480_g = (byte)(int)(p_i3293_1_.field_70179_y * 128D);
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73485_a = p_73267_1_.readInt();
        field_73487_h = p_73267_1_.readShort();
        field_73488_i = p_73267_1_.readByte();
        field_73486_j = p_73267_1_.readShort();
        field_73483_b = p_73267_1_.readInt();
        field_73484_c = p_73267_1_.readInt();
        field_73481_d = p_73267_1_.readInt();
        field_73482_e = p_73267_1_.readByte();
        field_73479_f = p_73267_1_.readByte();
        field_73480_g = p_73267_1_.readByte();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73485_a);
        p_73273_1_.writeShort(field_73487_h);
        p_73273_1_.writeByte(field_73488_i);
        p_73273_1_.writeShort(field_73486_j);
        p_73273_1_.writeInt(field_73483_b);
        p_73273_1_.writeInt(field_73484_c);
        p_73273_1_.writeInt(field_73481_d);
        p_73273_1_.writeByte(field_73482_e);
        p_73273_1_.writeByte(field_73479_f);
        p_73273_1_.writeByte(field_73480_g);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72459_a(this);
    }

    public int func_73284_a()
    {
        return 24;
    }
}
