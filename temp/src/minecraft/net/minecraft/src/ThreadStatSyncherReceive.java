// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;

// Referenced classes of package net.minecraft.src:
//            StatsSyncher

class ThreadStatSyncherReceive extends Thread
{

    final StatsSyncher field_77486_a; /* synthetic field */

    ThreadStatSyncherReceive(StatsSyncher p_i3219_1_)
    {
        field_77486_a = p_i3219_1_;
        super();
    }

    public void run()
    {
        try
        {
            if(StatsSyncher.func_77419_a(field_77486_a) != null)
            {
                StatsSyncher.func_77414_a(field_77486_a, StatsSyncher.func_77419_a(field_77486_a), StatsSyncher.func_77408_b(field_77486_a), StatsSyncher.func_77407_c(field_77486_a), StatsSyncher.func_77411_d(field_77486_a));
            } else
            if(StatsSyncher.func_77408_b(field_77486_a).exists())
            {
                StatsSyncher.func_77416_a(field_77486_a, StatsSyncher.func_77410_a(field_77486_a, StatsSyncher.func_77408_b(field_77486_a), StatsSyncher.func_77407_c(field_77486_a), StatsSyncher.func_77411_d(field_77486_a)));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            StatsSyncher.func_77406_a(field_77486_a, false);
        }
    }
}
