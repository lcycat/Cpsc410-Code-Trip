// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            Packet, ItemStack, NetHandler

public class Packet5PlayerInventory extends Packet
{

    public int field_73400_a;
    public int field_73398_b;
    private ItemStack field_73399_c;

    public Packet5PlayerInventory()
    {
    }

    public Packet5PlayerInventory(int p_i3350_1_, int p_i3350_2_, ItemStack p_i3350_3_)
    {
        field_73400_a = p_i3350_1_;
        field_73398_b = p_i3350_2_;
        field_73399_c = p_i3350_3_ != null ? p_i3350_3_.func_77946_l() : null;
    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73400_a = p_73267_1_.readInt();
        field_73398_b = p_73267_1_.readShort();
        field_73399_c = func_73276_c(p_73267_1_);
    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeInt(field_73400_a);
        p_73273_1_.writeShort(field_73398_b);
        func_73270_a(field_73399_c, p_73273_1_);
    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72506_a(this);
    }

    public int func_73284_a()
    {
        return 8;
    }

    public ItemStack func_73397_d()
    {
        return field_73399_c;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet p_73268_1_)
    {
        Packet5PlayerInventory packet5playerinventory = (Packet5PlayerInventory)p_73268_1_;
        return packet5playerinventory.field_73400_a == field_73400_a && packet5playerinventory.field_73398_b == field_73398_b;
    }
}
