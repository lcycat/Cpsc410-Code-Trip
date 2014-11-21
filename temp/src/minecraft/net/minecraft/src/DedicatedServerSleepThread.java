// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            DedicatedServer

class DedicatedServerSleepThread extends Thread
{

    final DedicatedServer field_72451_a; /* synthetic field */

    DedicatedServerSleepThread(DedicatedServer p_i3379_1_)
    {
        field_72451_a = p_i3379_1_;
        super();
        setDaemon(true);
        start();
    }

    public void run()
    {
        do
        {
            try
            {
                Thread.sleep(0x7fffffffL);
            }
            catch(InterruptedException interruptedexception) { }
        } while(true);
    }
}
