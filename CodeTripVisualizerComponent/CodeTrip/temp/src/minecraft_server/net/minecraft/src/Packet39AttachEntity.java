// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, Entity, NetHandler

public class Packet39AttachEntity extends Packet
{

    public int field_73297_a;
    public int field_73296_b;

    public Packet39AttachEntity()
    {
    }

    public Packet39AttachEntity(Entity p_i3353_1_, Entity p_i3353_2_)
    {
        field_73297_a = p_i3353_1_.field_70157_k;
        field_73296_b = p_i3353_2_ == null ? -1 : p_i3353_2_.field_70157_k;
    }

    public int func_73284_a()
    {
        return 8;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73297_a = p_73267_1_.readInt();
        field_73296_b = p_73267_1_.readInt();
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73297_a);
        p_73273_1_.writeInt(field_73296_b);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72484_a(this);
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        Packet39AttachEntity packet39attachentity = (Packet39AttachEntity)p_73268_1_;
        return packet39attachentity.field_73297_a == field_73297_a;
    }
}
