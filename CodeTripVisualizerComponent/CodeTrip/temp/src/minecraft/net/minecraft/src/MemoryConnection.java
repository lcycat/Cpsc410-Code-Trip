// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            NetworkManager, Packet, NetHandler

public class MemoryConnection
    implements NetworkManager
{

    private static final SocketAddress field_74444_a = new InetSocketAddress("127.0.0.1", 0);
    private final List field_74442_b = Collections.synchronizedList(new ArrayList());
    private MemoryConnection field_74443_c;
    private NetHandler field_74440_d;
    private boolean field_74441_e;
    private String field_74438_f;
    private Object field_74439_g[];
    private boolean field_74445_h;

    public MemoryConnection(NetHandler p_i3282_1_)
        throws IOException
    {
        field_74441_e = false;
        field_74438_f = "";
        field_74445_h = false;
        field_74440_d = p_i3282_1_;
    }

    public void func_74425_a(NetHandler p_74425_1_)
    {
        field_74440_d = p_74425_1_;
    }

    public void func_74429_a(Packet p_74429_1_)
    {
        if(field_74441_e)
        {
            return;
        } else
        {
            field_74443_c.func_74436_b(p_74429_1_);
            return;
        }
    }

    public void func_74431_f()
    {
        field_74443_c = null;
        field_74440_d = null;
    }

    public boolean func_74435_g()
    {
        return !field_74441_e && field_74443_c != null;
    }

    public void func_74427_a()
    {
    }

    public void func_74428_b()
    {
        int i;
        Packet packet;
        for(i = 2500; i-- >= 0 && !field_74442_b.isEmpty(); packet.func_73279_a(field_74440_d))
        {
            packet = (Packet)field_74442_b.remove(0);
        }

        if(field_74442_b.size() > i)
        {
            System.out.println((new StringBuilder()).append("Memory connection overburdened; after processing 2500 packets, we still have ").append(field_74442_b.size()).append(" to go!").toString());
        }
        if(field_74441_e && field_74442_b.isEmpty())
        {
            field_74440_d.func_72515_a(field_74438_f, field_74439_g);
        }
    }

    public SocketAddress func_74430_c()
    {
        return field_74444_a;
    }

    public void func_74423_d()
    {
        field_74441_e = true;
    }

    public void func_74424_a(String p_74424_1_, Object p_74424_2_[])
    {
        field_74441_e = true;
        field_74438_f = p_74424_1_;
        field_74439_g = p_74424_2_;
    }

    public int func_74426_e()
    {
        return 0;
    }

    public void func_74434_a(MemoryConnection p_74434_1_)
    {
        field_74443_c = p_74434_1_;
        p_74434_1_.field_74443_c = this;
    }

    public boolean func_74433_h()
    {
        return field_74445_h;
    }

    public void func_74437_a(boolean p_74437_1_)
    {
        field_74445_h = p_74437_1_;
    }

    public MemoryConnection func_74432_i()
    {
        return field_74443_c;
    }

    public void func_74436_b(Packet p_74436_1_)
    {
        if(p_74436_1_.func_73277_a_() && field_74440_d.func_72469_b())
        {
            p_74436_1_.func_73279_a(field_74440_d);
        } else
        {
            field_74442_b.add(p_74436_1_);
        }
    }

}
