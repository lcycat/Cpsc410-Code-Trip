// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            DedicatedServer

class DedicatedServerCommandThread extends Thread
{

    final DedicatedServer field_72428_a; /* synthetic field */

    DedicatedServerCommandThread(DedicatedServer p_i3380_1_)
    {
        field_72428_a = p_i3380_1_;
        super();
    }

    public void run()
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String s;
            for(; !field_72428_a.func_71241_aa() && field_72428_a.func_71278_l() && (s = bufferedreader.readLine()) != null; field_72428_a.func_71331_a(s, field_72428_a)) { }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }
}
