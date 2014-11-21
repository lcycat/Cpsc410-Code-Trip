// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.InetAddress;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ThreadLanServerPing, LanServer

public class LanServerList
{

    private ArrayList field_77555_b;
    boolean field_77556_a;

    public LanServerList()
    {
        field_77555_b = new ArrayList();
    }

    public synchronized boolean func_77553_a()
    {
        return field_77556_a;
    }

    public synchronized void func_77552_b()
    {
        field_77556_a = false;
    }

    public synchronized List func_77554_c()
    {
        return Collections.unmodifiableList(field_77555_b);
    }

    public synchronized void func_77551_a(String p_77551_1_, InetAddress p_77551_2_)
    {
        String s = ThreadLanServerPing.func_77524_a(p_77551_1_);
        String s1 = ThreadLanServerPing.func_77523_b(p_77551_1_);
        if(s1 == null)
        {
            return;
        }
        boolean flag = false;
        Iterator iterator = field_77555_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            LanServer lanserver = (LanServer)iterator.next();
            if(!lanserver.func_77488_b().equals(s1))
            {
                continue;
            }
            lanserver.func_77489_c();
            flag = true;
            break;
        } while(true);
        if(!flag)
        {
            field_77555_b.add(new LanServer(s, s1));
            field_77556_a = true;
        }
    }
}
