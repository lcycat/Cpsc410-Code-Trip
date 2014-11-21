// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            StatsSyncher

class ThreadStatSyncherSend extends Thread
{

    final Map field_77483_a; /* synthetic field */
    final StatsSyncher field_77482_b; /* synthetic field */

    ThreadStatSyncherSend(StatsSyncher p_i3217_1_, Map p_i3217_2_)
    {
        field_77482_b = p_i3217_1_;
        field_77483_a = p_i3217_2_;
        super();
    }

    public void run()
    {
        try
        {
            StatsSyncher.func_77414_a(field_77482_b, field_77483_a, StatsSyncher.func_77409_e(field_77482_b), StatsSyncher.func_77415_f(field_77482_b), StatsSyncher.func_77424_g(field_77482_b));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            StatsSyncher.func_77406_a(field_77482_b, false);
        }
    }
}
