// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package net.minecraft.src:
//            TcpConnection

class TcpWriterThread extends Thread
{

    final TcpConnection field_74501_a; /* synthetic field */

    TcpWriterThread(TcpConnection p_i3284_1_, String p_i3284_2_)
    {
        field_74501_a = p_i3284_1_;
        super(p_i3284_2_);
    }

    public void run()
    {
        TcpConnection.field_74469_b.getAndIncrement();
        try
        {
            while(TcpConnection.func_74462_a(field_74501_a)) 
            {
                boolean flag;
                for(flag = false; TcpConnection.func_74451_d(field_74501_a); flag = true) { }
                try
                {
                    if(flag && TcpConnection.func_74453_e(field_74501_a) != null)
                    {
                        TcpConnection.func_74453_e(field_74501_a).flush();
                    }
                }
                catch(IOException ioexception)
                {
                    if(!TcpConnection.func_74456_f(field_74501_a))
                    {
                        TcpConnection.func_74458_a(field_74501_a, ioexception);
                    }
                    ioexception.printStackTrace();
                }
                try
                {
                    sleep(2L);
                }
                catch(InterruptedException interruptedexception) { }
            }
        }
        finally
        {
            TcpConnection.field_74469_b.getAndDecrement();
        }
    }
}
