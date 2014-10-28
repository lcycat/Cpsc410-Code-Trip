// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IServer

public abstract class RConThreadBase
    implements Runnable
{

    protected boolean field_72619_a;
    protected IServer field_72617_b;
    protected Thread field_72618_c;
    protected int field_72615_d;
    protected List field_72616_e;
    protected List field_72614_f;

    RConThreadBase(IServer p_i3404_1_)
    {
        field_72619_a = false;
        field_72615_d = 5;
        field_72616_e = new ArrayList();
        field_72614_f = new ArrayList();
        field_72617_b = p_i3404_1_;
        if(field_72617_b.func_71239_B())
        {
            func_72606_c("Debugging is enabled, performance maybe reduced!");
        }
    }

    public synchronized void func_72602_a()
    {
        field_72618_c = new Thread(this);
        field_72618_c.start();
        field_72619_a = true;
    }

    public boolean func_72613_c()
    {
        return field_72619_a;
    }

    protected void func_72607_a(String p_72607_1_)
    {
        field_72617_b.func_71198_k(p_72607_1_);
    }

    protected void func_72609_b(String p_72609_1_)
    {
        field_72617_b.func_71244_g(p_72609_1_);
    }

    protected void func_72606_c(String p_72606_1_)
    {
        field_72617_b.func_71236_h(p_72606_1_);
    }

    protected void func_72610_d(String p_72610_1_)
    {
        field_72617_b.func_71201_j(p_72610_1_);
    }

    protected int func_72603_d()
    {
        return field_72617_b.func_71233_x();
    }

    protected void func_72601_a(DatagramSocket p_72601_1_)
    {
        func_72607_a((new StringBuilder()).append("registerSocket: ").append(p_72601_1_).toString());
        field_72616_e.add(p_72601_1_);
    }

    protected boolean func_72604_a(DatagramSocket p_72604_1_, boolean p_72604_2_)
    {
        func_72607_a((new StringBuilder()).append("closeSocket: ").append(p_72604_1_).toString());
        if(null == p_72604_1_)
        {
            return false;
        }
        boolean flag = false;
        if(!p_72604_1_.isClosed())
        {
            p_72604_1_.close();
            flag = true;
        }
        if(p_72604_2_)
        {
            field_72616_e.remove(p_72604_1_);
        }
        return flag;
    }

    protected boolean func_72608_b(ServerSocket p_72608_1_)
    {
        return func_72605_a(p_72608_1_, true);
    }

    protected boolean func_72605_a(ServerSocket p_72605_1_, boolean p_72605_2_)
    {
        func_72607_a((new StringBuilder()).append("closeSocket: ").append(p_72605_1_).toString());
        if(null == p_72605_1_)
        {
            return false;
        }
        boolean flag = false;
        try
        {
            if(!p_72605_1_.isClosed())
            {
                p_72605_1_.close();
                flag = true;
            }
        }
        catch(IOException ioexception)
        {
            func_72606_c((new StringBuilder()).append("IO: ").append(ioexception.getMessage()).toString());
        }
        if(p_72605_2_)
        {
            field_72614_f.remove(p_72605_1_);
        }
        return flag;
    }

    protected void func_72611_e()
    {
        func_72612_a(false);
    }

    protected void func_72612_a(boolean p_72612_1_)
    {
        int i = 0;
        Iterator iterator = field_72616_e.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            DatagramSocket datagramsocket = (DatagramSocket)iterator.next();
            if(func_72604_a(datagramsocket, false))
            {
                i++;
            }
        } while(true);
        field_72616_e.clear();
        iterator = field_72614_f.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            ServerSocket serversocket = (ServerSocket)iterator.next();
            if(func_72605_a(serversocket, false))
            {
                i++;
            }
        } while(true);
        field_72614_f.clear();
        if(p_72612_1_ && 0 < i)
        {
            func_72606_c((new StringBuilder()).append("Force closed ").append(i).append(" sockets").toString());
        }
    }
}
