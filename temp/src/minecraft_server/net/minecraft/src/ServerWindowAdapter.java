// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Referenced classes of package net.minecraft.src:
//            DedicatedServer

final class ServerWindowAdapter extends WindowAdapter
{

    final DedicatedServer field_79002_a; /* synthetic field */

    ServerWindowAdapter(DedicatedServer p_i4108_1_)
    {
        field_79002_a = p_i4108_1_;
        super();
    }

    public void windowClosing(WindowEvent p_windowClosing_1_)
    {
        field_79002_a.func_71263_m();
        while(!field_79002_a.func_71241_aa()) 
        {
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
        System.exit(0);
    }
}
