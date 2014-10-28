// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class ThreadClientSleep extends Thread
{

    final Minecraft field_74532_a; /* synthetic field */

    public ThreadClientSleep(Minecraft p_i3019_1_, String p_i3019_2_)
    {
        field_74532_a = p_i3019_1_;
        super(p_i3019_2_);
    }

    public void run()
    {
        while(field_74532_a.field_71425_J) 
        {
            try
            {
                Thread.sleep(0x7fffffffL);
            }
            catch(InterruptedException interruptedexception) { }
        }
    }
}
