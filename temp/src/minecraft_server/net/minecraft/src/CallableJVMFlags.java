// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            CrashReport

class CallableJVMFlags
    implements Callable
{

    final CrashReport field_71488_a; /* synthetic field */

    CallableJVMFlags(CrashReport p_i3249_1_)
    {
        field_71488_a = p_i3249_1_;
        super();
    }

    public String func_71487_a()
    {
        RuntimeMXBean runtimemxbean = ManagementFactory.getRuntimeMXBean();
        List list = runtimemxbean.getInputArguments();
        int i = 0;
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if(s.startsWith("-X"))
            {
                if(i++ > 0)
                {
                    stringbuilder.append(" ");
                }
                stringbuilder.append(s);
            }
        } while(true);
        return String.format("%d total; %s", new Object[] {
            Integer.valueOf(i), stringbuilder.toString()
        });
    }

    public Object call()
    {
        return func_71487_a();
    }
}
