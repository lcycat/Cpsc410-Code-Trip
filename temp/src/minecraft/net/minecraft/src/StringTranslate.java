// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.*;

public class StringTranslate
{

    private static StringTranslate field_74817_a = new StringTranslate("en_US");
    private Properties field_74815_b;
    private TreeMap field_74816_c;
    private String field_74813_d;
    private boolean field_74814_e;

    public StringTranslate(String p_i3260_1_)
    {
        field_74815_b = new Properties();
        func_74807_e();
        func_74810_a(p_i3260_1_);
    }

    public static StringTranslate func_74808_a()
    {
        return field_74817_a;
    }

    private void func_74807_e()
    {
        TreeMap treemap = new TreeMap();
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.StringTranslate.class).getResourceAsStream("/lang/languages.txt"), "UTF-8"));
            for(String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            {
                String as[] = s.split("=");
                if(as != null && as.length == 2)
                {
                    treemap.put(as[0], as[1]);
                }
            }

        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
            return;
        }
        field_74816_c = treemap;
        field_74816_c.put("en_US", "English (US)");
    }

    public TreeMap func_74806_b()
    {
        return field_74816_c;
    }

    private void func_74812_a(Properties p_74812_1_, String p_74812_2_)
        throws IOException
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.StringTranslate.class).getResourceAsStream((new StringBuilder()).append("/lang/").append(p_74812_2_).append(".lang").toString()), "UTF-8"));
        for(String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
        {
            s = s.trim();
            if(s.startsWith("#"))
            {
                continue;
            }
            String as[] = s.split("=");
            if(as != null && as.length == 2)
            {
                p_74812_1_.setProperty(as[0], as[1]);
            }
        }

    }

    public void func_74810_a(String p_74810_1_)
    {
        Properties properties;
        if(p_74810_1_.equals(field_74813_d))
        {
            return;
        }
        properties = new Properties();
        try
        {
            func_74812_a(properties, "en_US");
        }
        catch(IOException ioexception) { }
        field_74814_e = false;
        if("en_US".equals(p_74810_1_))
        {
            break MISSING_BLOCK_LABEL_152;
        }
        Enumeration enumeration;
        func_74812_a(properties, p_74810_1_);
        enumeration = properties.propertyNames();
_L2:
        String s;
        int i;
        Object obj1;
        do
        {
            if(!enumeration.hasMoreElements() || field_74814_e)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            Object obj = enumeration.nextElement();
            obj1 = properties.get(obj);
        } while(obj1 == null);
        s = obj1.toString();
        i = 0;
_L5:
        if(i >= s.length()) goto _L2; else goto _L1
_L1:
        if(s.charAt(i) < '\u0100') goto _L4; else goto _L3
_L3:
        field_74814_e = true;
          goto _L2
_L4:
        i++;
          goto _L5
        IOException ioexception1;
        ioexception1;
        ioexception1.printStackTrace();
        return;
        field_74813_d = p_74810_1_;
        field_74815_b = properties;
        return;
          goto _L2
    }

    public String func_74811_c()
    {
        return field_74813_d;
    }

    public boolean func_74804_d()
    {
        return field_74814_e;
    }

    public String func_74805_b(String p_74805_1_)
    {
        return field_74815_b.getProperty(p_74805_1_, p_74805_1_);
    }

    public String func_74803_a(String p_74803_1_, Object p_74803_2_[])
    {
        String s = field_74815_b.getProperty(p_74803_1_, p_74803_1_);
        try
        {
            return String.format(s, p_74803_2_);
        }
        catch(IllegalFormatException illegalformatexception)
        {
            return (new StringBuilder()).append("Format error: ").append(s).toString();
        }
    }

    public String func_74809_c(String p_74809_1_)
    {
        return field_74815_b.getProperty((new StringBuilder()).append(p_74809_1_).append(".name").toString(), "");
    }

    public static boolean func_74802_e(String p_74802_0_)
    {
        return "ar_SA".equals(p_74802_0_) || "he_IL".equals(p_74802_0_);
    }

}
