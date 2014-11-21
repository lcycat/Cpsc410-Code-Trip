// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package net.minecraft.src:
//            TcpConnection

class TcpReaderThread extends Thread
{

    final TcpConnection field_74498_a; /* synthetic field */

    TcpReaderThread(TcpConnection p_i3283_1_, String p_i3283_2_)
    {
        field_74498_a = p_i3283_1_;
        super(p_i3283_2_);
    }

    public void run()
    {
        TcpConnection.field_74471_a.getAndIncrement();
        try
        {
            while(TcpConnection.func_74462_a(field_74498_a) && !TcpConnection.func_74449_b(field_74498_a)) 
            {
                while(TcpConnection.func_74450_c(field_74498_a)) ;
                try
                {
                    sleep(2L);
                }
                catch(InterruptedException interruptedexception) { }
            }
        }
        finally
        {
            TcpConnection.field_74471_a.getAndDecrement();
        }
    }
}
