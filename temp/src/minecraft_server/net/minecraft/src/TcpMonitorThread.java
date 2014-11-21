// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TcpConnection

class TcpMonitorThread extends Thread
{

    final TcpConnection field_74417_a; /* synthetic field */

    TcpMonitorThread(TcpConnection p_i3286_1_)
    {
        field_74417_a = p_i3286_1_;
        super();
    }

    public void run()
    {
        try
        {
            Thread.sleep(2000L);
            if(TcpConnection.func_74462_a(field_74417_a))
            {
                TcpConnection.func_74461_h(field_74417_a).interrupt();
                field_74417_a.func_74424_a("disconnect.closed", new Object[0]);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
