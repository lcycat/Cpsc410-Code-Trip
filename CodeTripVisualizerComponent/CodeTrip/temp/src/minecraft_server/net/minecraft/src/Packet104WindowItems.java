// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Packet, ItemStack, NetHandler

public class Packet104WindowItems extends Packet
{

    public int field_73427_a;
    public ItemStack field_73426_b[];

    public Packet104WindowItems()
    {
    }

    public Packet104WindowItems(int p_i3312_1_, List p_i3312_2_)
    {
        field_73427_a = p_i3312_1_;
        field_73426_b = new ItemStack[p_i3312_2_.size()];
        for(int i = 0; i < field_73426_b.length; i++)
        {
            ItemStack itemstack = (ItemStack)p_i3312_2_.get(i);
            field_73426_b[i] = itemstack != null ? itemstack.func_77946_l() : null;
        }

    }

    public void func_73267_a(DataInputStream p_73267_1_)
        throws IOException
    {
        field_73427_a = p_73267_1_.readByte();
        short word0 = p_73267_1_.readShort();
        field_73426_b = new ItemStack[word0];
        for(int i = 0; i < word0; i++)
        {
            field_73426_b[i] = func_73276_c(p_73267_1_);
        }

    }

    public void func_73273_a(DataOutputStream p_73273_1_)
        throws IOException
    {
        p_73273_1_.writeByte(field_73427_a);
        p_73273_1_.writeShort(field_73426_b.length);
        ItemStack aitemstack[] = field_73426_b;
        int i = aitemstack.length;
        for(int j = 0; j < i; j++)
        {
            ItemStack itemstack = aitemstack[j];
            func_73270_a(itemstack, p_73273_1_);
        }

    }

    public void func_73279_a(NetHandler p_73279_1_)
    {
        p_73279_1_.func_72486_a(this);
    }

    public int func_73284_a()
    {
        return 3 + field_73426_b.length * 5;
    }
}
