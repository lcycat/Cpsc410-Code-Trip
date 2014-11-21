// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TcpConnection

class TcpMasterThread extends Thread
{

    final TcpConnection field_74504_a; /* synthetic field */

    TcpMasterThread(TcpConnection p_i3285_1_)
    {
        field_74504_a = p_i3285_1_;
        super();
    }

    public void run()
    {
        try
        {
            Thread.sleep(5000L);
            if(TcpConnection.func_74457_g(field_74504_a).isAlive())
            {
                try
                {
                    TcpConnection.func_74457_g(field_74504_a).stop();
                }
                catch(Throwable throwable) { }
            }
            if(TcpConnection.func_74461_h(field_74504_a).isAlive())
            {
                try
                {
                    TcpConnection.func_74461_h(field_74504_a).stop();
                }
                catch(Throwable throwable1) { }
            }
        }
        catch(InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }
}
