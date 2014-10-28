// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ProfilerResult

public class Profiler
{

    private final List field_76325_b = new ArrayList();
    private final List field_76326_c = new ArrayList();
    public boolean field_76327_a;
    private String field_76323_d;
    private final Map field_76324_e = new HashMap();

    public Profiler()
    {
        field_76327_a = false;
        field_76323_d = "";
    }

    public void func_76317_a()
    {
        field_76324_e.clear();
        field_76323_d = "";
        field_76325_b.clear();
    }

    public void func_76320_a(String p_76320_1_)
    {
        if(!field_76327_a)
        {
            return;
        }
        if(field_76323_d.length() <= 0) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_76323_d;
        append();
        ".";
        append();
        toString();
        field_76323_d;
_L2:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_76323_d;
        append();
        p_76320_1_;
        append();
        toString();
        field_76323_d;
        field_76325_b.add(field_76323_d);
        field_76326_c.add(Long.valueOf(System.nanoTime()));
        return;
    }

    public void func_76319_b()
    {
        if(!field_76327_a)
        {
            return;
        }
        long l = System.nanoTime();
        long l1 = ((Long)field_76326_c.remove(field_76326_c.size() - 1)).longValue();
        field_76325_b.remove(field_76325_b.size() - 1);
        long l2 = l - l1;
        if(field_76324_e.containsKey(field_76323_d))
        {
            field_76324_e.put(field_76323_d, Long.valueOf(((Long)field_76324_e.get(field_76323_d)).longValue() + l2));
        } else
        {
            field_76324_e.put(field_76323_d, Long.valueOf(l2));
        }
        if(l2 > 0x5f5e100L)
        {
            System.out.println((new StringBuilder()).append("Something's taking too long! '").append(field_76323_d).append("' took aprox ").append((double)l2 / 1000000D).append(" ms").toString());
        }
        field_76323_d = field_76325_b.isEmpty() ? "" : (String)field_76325_b.get(field_76325_b.size() - 1);
    }

    public List func_76321_b(String p_76321_1_)
    {
        if(!field_76327_a)
        {
            return null;
        }
        String s = p_76321_1_;
        long l = field_76324_e.containsKey("root") ? ((Long)field_76324_e.get("root")).longValue() : 0L;
        long l1 = field_76324_e.containsKey(p_76321_1_) ? ((Long)field_76324_e.get(p_76321_1_)).longValue() : -1L;
        ArrayList arraylist = new ArrayList();
        if(p_76321_1_.length() > 0)
        {
            p_76321_1_ = (new StringBuilder()).append(p_76321_1_).append(".").toString();
        }
        long l2 = 0L;
        Iterator iterator = field_76324_e.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if(s1.length() > p_76321_1_.length() && s1.startsWith(p_76321_1_) && s1.indexOf(".", p_76321_1_.length() + 1) < 0)
            {
                l2 += ((Long)field_76324_e.get(s1)).longValue();
            }
        } while(true);
        float f = l2;
        if(l2 < l1)
        {
            l2 = l1;
        }
        if(l < l2)
        {
            l = l2;
        }
        Iterator iterator1 = field_76324_e.keySet().iterator();
        do
        {
            if(!iterator1.hasNext())
            {
                break;
            }
            String s2 = (String)iterator1.next();
            if(s2.length() > p_76321_1_.length() && s2.startsWith(p_76321_1_) && s2.indexOf(".", p_76321_1_.length() + 1) < 0)
            {
                long l3 = ((Long)field_76324_e.get(s2)).longValue();
                double d = ((double)l3 * 100D) / (double)l2;
                double d1 = ((double)l3 * 100D) / (double)l;
                String s4 = s2.substring(p_76321_1_.length());
                arraylist.add(new ProfilerResult(s4, d, d1));
            }
        } while(true);
        String s3;
        for(Iterator iterator2 = field_76324_e.keySet().iterator(); iterator2.hasNext(); field_76324_e.put(s3, Long.valueOf((((Long)field_76324_e.get(s3)).longValue() * 999L) / 1000L)))
        {
            s3 = (String)iterator2.next();
        }

        if((float)l2 > f)
        {
            arraylist.add(new ProfilerResult("unspecified", ((double)((float)l2 - f) * 100D) / (double)l2, ((double)((float)l2 - f) * 100D) / (double)l));
        }
        Collections.sort(arraylist);
        arraylist.add(0, new ProfilerResult(s, 100D, ((double)l2 * 100D) / (double)l));
        return arraylist;
    }

    public void func_76318_c(String p_76318_1_)
    {
        func_76319_b();
        func_76320_a(p_76318_1_);
    }

    public String func_76322_c()
    {
        return field_76325_b.size() != 0 ? (String)field_76325_b.get(field_76325_b.size() - 1) : "[UNKNOWN]";
    }
}
