// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Packet, EntityPlayer, MathHelper, InventoryPlayer, 
//            ItemStack, DataWatcher, NetHandler

public class Packet20NamedEntitySpawn extends Packet
{

    public int field_73516_a;
    public String field_73514_b;
    public int field_73515_c;
    public int field_73512_d;
    public int field_73513_e;
    public byte field_73510_f;
    public byte field_73511_g;
    public int field_73518_h;
    private DataWatcher field_73519_i;
    private List field_73517_j;

    public Packet20NamedEntitySpawn()
    {
    }

    public Packet20NamedEntitySpawn(EntityPlayer p_i3296_1_)
    {
        field_73516_a = p_i3296_1_.field_70157_k;
        field_73514_b = p_i3296_1_.field_71092_bJ;
        field_73515_c = MathHelper.func_76128_c(p_i3296_1_.field_70165_t * 32D);
        field_73512_d = MathHelper.func_76128_c(p_i3296_1_.field_70163_u * 32D);
        field_73513_e = MathHelper.func_76128_c(p_i3296_1_.field_70161_v * 32D);
        field_73510_f = (byte)(int)((p_i3296_1_.field_70177_z * 256F) / 360F);
        field_73511_g = (byte)(int)((p_i3296_1_.field_70125_A * 256F) / 360F);
        ItemStack itemstack = p_i3296_1_.field_71071_by.func_70448_g();
        field_73518_h = itemstack != null ? itemstack.field_77993_c : 0;
        field_73519_i = p_i3296_1_.func_70096_w();
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73516_a = p_73267_1_.readInt();
        field_73514_b = func_73282_a(p_73267_1_, 16);
        field_73515_c = p_73267_1_.readInt();
        field_73512_d = p_73267_1_.readInt();
        field_73513_e = p_73267_1_.readInt();
        field_73510_f = p_73267_1_.readByte();
        field_73511_g = p_73267_1_.readByte();
        field_73518_h = p_73267_1_.readShort();
        field_73517_j = DataWatcher.func_75686_a(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73516_a);
        func_73271_a(field_73514_b, p_73273_1_);
        p_73273_1_.writeInt(field_73515_c);
        p_73273_1_.writeInt(field_73512_d);
        p_73273_1_.writeInt(field_73513_e);
        p_73273_1_.writeByte(field_73510_f);
        p_73273_1_.writeByte(field_73511_g);
        p_73273_1_.writeShort(field_73518_h);
        field_73519_i.func_75689_a(p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72518_a(this);
    }

    public int func_73284_a()
    {
        return 28;
    }

    public List func_73509_c()
    {
        if(field_73517_j == null)
        {
            field_73517_j = field_73519_i.func_75685_c();
        }
        return field_73517_j;
    }
}
