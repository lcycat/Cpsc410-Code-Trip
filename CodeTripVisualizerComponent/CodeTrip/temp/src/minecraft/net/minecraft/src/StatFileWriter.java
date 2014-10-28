// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import argo.jdom.*;
import argo.saj.InvalidSyntaxException;
import java.io.File;
import java.io.PrintStream;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            StatsSyncher, StatBase, StatList, MD5String, 
//            Achievement, Session

public class StatFileWriter
{

    private Map field_77457_a;
    private Map field_77455_b;
    private boolean field_77456_c;
    private StatsSyncher field_77454_d;

    public StatFileWriter(Session p_i3218_1_, File p_i3218_2_)
    {
        field_77457_a = new HashMap();
        field_77455_b = new HashMap();
        field_77456_c = false;
        File file = new File(p_i3218_2_, "stats");
        if(!file.exists())
        {
            file.mkdir();
        }
        File afile[] = p_i3218_2_.listFiles();
        int i = afile.length;
        for(int j = 0; j < i; j++)
        {
            File file1 = afile[j];
            if(!file1.getName().startsWith("stats_") || !file1.getName().endsWith(".dat"))
            {
                continue;
            }
            File file2 = new File(file, file1.getName());
            if(!file2.exists())
            {
                System.out.println((new StringBuilder()).append("Relocating ").append(file1.getName()).toString());
                file1.renameTo(file2);
            }
        }

        field_77454_d = new StatsSyncher(p_i3218_1_, this, file);
    }

    public void func_77450_a(StatBase p_77450_1_, int p_77450_2_)
    {
        func_77451_a(field_77455_b, p_77450_1_, p_77450_2_);
        func_77451_a(field_77457_a, p_77450_1_, p_77450_2_);
        field_77456_c = true;
    }

    private void func_77451_a(Map p_77451_1_, StatBase p_77451_2_, int p_77451_3_)
    {
        Integer integer = (Integer)p_77451_1_.get(p_77451_2_);
        int i = integer != null ? integer.intValue() : 0;
        p_77451_1_.put(p_77451_2_, Integer.valueOf(i + p_77451_3_));
    }

    public Map func_77445_b()
    {
        return new HashMap(field_77455_b);
    }

    public void func_77447_a(Map p_77447_1_)
    {
        if(p_77447_1_ == null)
        {
            return;
        }
        field_77456_c = true;
        StatBase statbase;
        for(Iterator iterator = p_77447_1_.keySet().iterator(); iterator.hasNext(); func_77451_a(field_77457_a, statbase, ((Integer)p_77447_1_.get(statbase)).intValue()))
        {
            statbase = (StatBase)iterator.next();
            func_77451_a(field_77455_b, statbase, ((Integer)p_77447_1_.get(statbase)).intValue());
        }

    }

    public void func_77452_b(Map p_77452_1_)
    {
        if(p_77452_1_ == null)
        {
            return;
        }
        StatBase statbase;
        int i;
        for(Iterator iterator = p_77452_1_.keySet().iterator(); iterator.hasNext(); field_77457_a.put(statbase, Integer.valueOf(((Integer)p_77452_1_.get(statbase)).intValue() + i)))
        {
            statbase = (StatBase)iterator.next();
            Integer integer = (Integer)field_77455_b.get(statbase);
            i = integer != null ? integer.intValue() : 0;
        }

    }

    public void func_77448_c(Map p_77448_1_)
    {
        if(p_77448_1_ == null)
        {
            return;
        }
        field_77456_c = true;
        StatBase statbase;
        for(Iterator iterator = p_77448_1_.keySet().iterator(); iterator.hasNext(); func_77451_a(field_77455_b, statbase, ((Integer)p_77448_1_.get(statbase)).intValue()))
        {
            statbase = (StatBase)iterator.next();
        }

    }

    public static Map func_77453_b(String p_77453_0_)
    {
        HashMap hashmap = new HashMap();
        try
        {
            String s = "local";
            StringBuilder stringbuilder = new StringBuilder();
            JsonRootNode jsonrootnode = (new JdomParser()).parse(p_77453_0_);
            List list = jsonrootnode.getArrayNode(new Object[] {
                "stats-change"
            });
            for(Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                JsonNode jsonnode = (JsonNode)iterator.next();
                Map map = jsonnode.getFields();
                java.util.Map.Entry entry = (java.util.Map.Entry)map.entrySet().iterator().next();
                int i = Integer.parseInt(((JsonStringNode)entry.getKey()).getText());
                int j = Integer.parseInt(((JsonNode)entry.getValue()).getText());
                StatBase statbase = StatList.func_75923_a(i);
                if(statbase == null)
                {
                    System.out.println((new StringBuilder()).append(i).append(" is not a valid stat").toString());
                } else
                {
                    stringbuilder.append(StatList.func_75923_a(i).field_75973_g).append(",");
                    stringbuilder.append(j).append(",");
                    hashmap.put(statbase, Integer.valueOf(j));
                }
            }

            MD5String md5string = new MD5String(s);
            String s1 = md5string.func_75899_a(stringbuilder.toString());
            if(!s1.equals(jsonrootnode.getStringValue(new Object[] {
    "checksum"
})))
            {
                System.out.println("CHECKSUM MISMATCH");
                return null;
            }
        }
        catch(InvalidSyntaxException invalidsyntaxexception)
        {
            invalidsyntaxexception.printStackTrace();
        }
        return hashmap;
    }

    public static String func_77441_a(String p_77441_0_, String p_77441_1_, Map p_77441_2_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = new StringBuilder();
        boolean flag = true;
        stringbuilder.append("{\r\n");
        if(p_77441_0_ != null && p_77441_1_ != null)
        {
            stringbuilder.append("  \"user\":{\r\n");
            stringbuilder.append("    \"name\":\"").append(p_77441_0_).append("\",\r\n");
            stringbuilder.append("    \"sessionid\":\"").append(p_77441_1_).append("\"\r\n");
            stringbuilder.append("  },\r\n");
        }
        stringbuilder.append("  \"stats-change\":[");
        StatBase statbase;
        for(Iterator iterator = p_77441_2_.keySet().iterator(); iterator.hasNext(); stringbuilder1.append(p_77441_2_.get(statbase)).append(","))
        {
            statbase = (StatBase)iterator.next();
            if(flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("},");
            }
            stringbuilder.append("\r\n    {\"").append(statbase.field_75975_e).append("\":").append(p_77441_2_.get(statbase));
            stringbuilder1.append(statbase.field_75973_g).append(",");
        }

        if(!flag)
        {
            stringbuilder.append("}");
        }
        MD5String md5string = new MD5String(p_77441_1_);
        stringbuilder.append("\r\n  ],\r\n");
        stringbuilder.append("  \"checksum\":\"").append(md5string.func_75899_a(stringbuilder1.toString())).append("\"\r\n");
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public boolean func_77443_a(Achievement p_77443_1_)
    {
        return field_77457_a.containsKey(p_77443_1_);
    }

    public boolean func_77442_b(Achievement p_77442_1_)
    {
        return p_77442_1_.field_75992_c == null || func_77443_a(p_77442_1_.field_75992_c);
    }

    public int func_77444_a(StatBase p_77444_1_)
    {
        Integer integer = (Integer)field_77457_a.get(p_77444_1_);
        return integer != null ? integer.intValue() : 0;
    }

    public void func_77446_d()
    {
        field_77454_d.func_77420_c(func_77445_b());
    }

    public void func_77449_e()
    {
        if(field_77456_c && field_77454_d.func_77425_c())
        {
            field_77454_d.func_77418_a(func_77445_b());
        }
        field_77454_d.func_77422_e();
    }
}
