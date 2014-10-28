// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Vec3, ChunkPosition, NetHandler

public class Packet60Explosion extends Packet
{

    public double field_73616_a;
    public double field_73614_b;
    public double field_73615_c;
    public float field_73612_d;
    public List field_73613_e;
    private float field_73610_f;
    private float field_73611_g;
    private float field_73617_h;

    public Packet60Explosion()
    {
    }

    public Packet60Explosion(double p_i3319_1_, double p_i3319_3_, double p_i3319_5_, float p_i3319_7_, 
            List p_i3319_8_, Vec3 p_i3319_9_)
    {
        field_73616_a = p_i3319_1_;
        field_73614_b = p_i3319_3_;
        field_73615_c = p_i3319_5_;
        field_73612_d = p_i3319_7_;
        field_73613_e = new ArrayList(p_i3319_8_);
        if(p_i3319_9_ != null)
        {
            field_73610_f = (float)p_i3319_9_.field_72450_a;
            field_73611_g = (float)p_i3319_9_.field_72448_b;
            field_73617_h = (float)p_i3319_9_.field_72449_c;
        }
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73616_a = p_73267_1_.readDouble();
        field_73614_b = p_73267_1_.readDouble();
        field_73615_c = p_73267_1_.readDouble();
        field_73612_d = p_73267_1_.readFloat();
        int i = p_73267_1_.readInt();
        field_73613_e = new ArrayList(i);
        int j = (int)field_73616_a;
        int k = (int)field_73614_b;
        int l = (int)field_73615_c;
        for(int i1 = 0; i1 < i; i1++)
        {
            int j1 = p_73267_1_.readByte() + j;
            int k1 = p_73267_1_.readByte() + k;
            int l1 = p_73267_1_.readByte() + l;
            field_73613_e.add(new ChunkPosition(j1, k1, l1));
        }

        field_73610_f = p_73267_1_.readFloat();
        field_73611_g = p_73267_1_.readFloat();
        field_73617_h = p_73267_1_.readFloat();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeDouble(field_73616_a);
        p_73273_1_.writeDouble(field_73614_b);
        p_73273_1_.writeDouble(field_73615_c);
        p_73273_1_.writeFloat(field_73612_d);
        p_73273_1_.writeInt(field_73613_e.size());
        int i = (int)field_73616_a;
        int j = (int)field_73614_b;
        int k = (int)field_73615_c;
        int j1;
        for(Iterator iterator = field_73613_e.iterator(); iterator.hasNext(); p_73273_1_.writeByte(j1))
        {
            ChunkPosition chunkposition = (ChunkPosition)iterator.next();
            int l = chunkposition.field_76930_a - i;
            int i1 = chunkposition.field_76928_b - j;
            j1 = chunkposition.field_76929_c - k;
            p_73273_1_.writeByte(l);
            p_73273_1_.writeByte(i1);
        }

        p_73273_1_.writeFloat(field_73610_f);
        p_73273_1_.writeFloat(field_73611_g);
        p_73273_1_.writeFloat(field_73617_h);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72499_a(this);
    }

    public int func_73284_a()
    {
        return 32 + field_73613_e.size() * 3 + 3;
    }

    public float func_73607_d()
    {
        return field_73610_f;
    }

    public float func_73609_f()
    {
        return field_73611_g;
    }

    public float func_73608_g()
    {
        return field_73617_h;
    }
}
