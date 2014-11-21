// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            DedicatedServer

public final class ThreadDedicatedServer extends Thread
{

    final DedicatedServer field_79030_a; /* synthetic field */

    public ThreadDedicatedServer(DedicatedServer p_i4100_1_)
    {
        field_79030_a = p_i4100_1_;
        super();
    }

    public void run()
    {
        field_79030_a.func_71260_j();
    }
}
