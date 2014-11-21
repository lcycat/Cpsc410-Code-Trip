// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            PlayerUsageSnooperThread, IPlayerUsage

public class PlayerUsageSnooper
{

    private Map field_76482_a;
    private final String field_76480_b = UUID.randomUUID().toString();
    private final URL field_76481_c;
    private final IPlayerUsage field_76478_d;
    private final Timer field_76479_e = new Timer("Snooper Timer", true);
    private final Object field_76476_f = new Object();
    private boolean field_76477_g;
    private int field_76483_h;

    public PlayerUsageSnooper(String p_i3428_1_, IPlayerUsage p_i3428_2_)
    {
        field_76482_a = new HashMap();
        field_76477_g = false;
        field_76483_h = 0;
        try
        {
            field_76481_c = new URL((new StringBuilder()).append("http://snoop.minecraft.net/").append(p_i3428_1_).append("?version=").append(1).toString());
        }
        catch(MalformedURLException malformedurlexception)
        {
            throw new IllegalArgumentException();
        }
        field_76478_d = p_i3428_2_;
    }

    public void func_76463_a()
    {
        if(field_76477_g)
        {
            return;
        } else
        {
            field_76477_g = true;
            func_76464_f();
            field_76479_e.schedule(new PlayerUsageSnooperThread(this), 0L, 0xdbba0L);
            return;
        }
    }

    private void func_76464_f()
    {
        func_76467_g();
        func_76472_a("snooper_token", field_76480_b);
        func_76472_a("os_name", System.getProperty("os.name"));
        func_76472_a("os_version", System.getProperty("os.version"));
        func_76472_a("os_architecture", System.getProperty("os.arch"));
        func_76472_a("java_version", System.getProperty("java.version"));
        func_76472_a("version", "1.3.1");
        field_76478_d.func_70001_b(this);
    }

    private void func_76467_g()
    {
        RuntimeMXBean runtimemxbean = ManagementFactory.getRuntimeMXBean();
        List list = runtimemxbean.getInputArguments();
        int i = 0;
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
                func_76472_a((new StringBuilder()).append("jvm_arg[").append(i++).append("]").toString(), s);
            }
        } while(true);
        func_76472_a("jvm_args", Integer.valueOf(i));
    }

    public void func_76471_b()
    {
        func_76472_a("memory_total", Long.valueOf(Runtime.getRuntime().totalMemory()));
        func_76472_a("memory_max", Long.valueOf(Runtime.getRuntime().maxMemory()));
        func_76472_a("memory_free", Long.valueOf(Runtime.getRuntime().freeMemory()));
        func_76472_a("cpu_cores", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        field_76478_d.func_70000_a(this);
    }

    public void func_76472_a(String p_76472_1_, Object p_76472_2_)
    {
        synchronized(field_76476_f)
        {
            field_76482_a.put(p_76472_1_, p_76472_2_);
        }
    }

    public Map func_76465_c()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        synchronized(field_76476_f)
        {
            func_76471_b();
            java.util.Map.Entry entry;
            for(Iterator iterator = field_76482_a.entrySet().iterator(); iterator.hasNext(); linkedhashmap.put(entry.getKey(), entry.getValue().toString()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        return linkedhashmap;
    }

    public boolean func_76468_d()
    {
        return field_76477_g;
    }

    public void func_76470_e()
    {
        field_76479_e.cancel();
    }

    static IPlayerUsage func_76473_a(PlayerUsageSnooper p_76473_0_)
    {
        return p_76473_0_.field_76478_d;
    }

    static Object func_76474_b(PlayerUsageSnooper p_76474_0_)
    {
        return p_76474_0_.field_76476_f;
    }

    static Map func_76469_c(PlayerUsageSnooper p_76469_0_)
    {
        return p_76469_0_.field_76482_a;
    }

    static int func_76466_d(PlayerUsageSnooper p_76466_0_)
    {
        return p_76466_0_.field_76483_h++;
    }

    static URL func_76475_e(PlayerUsageSnooper p_76475_0_)
    {
        return p_76475_0_.field_76481_c;
    }
}
