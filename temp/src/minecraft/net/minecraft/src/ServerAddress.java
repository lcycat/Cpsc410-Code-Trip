// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Hashtable;
import javax.naming.directory.*;

public class ServerAddress
{

    private final String field_78866_a;
    private final int field_78865_b;

    private ServerAddress(String p_i3096_1_, int p_i3096_2_)
    {
        field_78866_a = p_i3096_1_;
        field_78865_b = p_i3096_2_;
    }

    public String func_78861_a()
    {
        return field_78866_a;
    }

    public int func_78864_b()
    {
        return field_78865_b;
    }

    public static ServerAddress func_78860_a(String p_78860_0_)
    {
        if(p_78860_0_ == null)
        {
            return null;
        }
        String as[] = p_78860_0_.split(":");
        if(p_78860_0_.startsWith("["))
        {
            int i = p_78860_0_.indexOf("]");
            if(i > 0)
            {
                String s1 = p_78860_0_.substring(1, i);
                String s2 = p_78860_0_.substring(i + 1).trim();
                if(s2.startsWith(":") && s2.length() > 0)
                {
                    s2 = s2.substring(1);
                    as = new String[2];
                    as[0] = s1;
                    as[1] = s2;
                } else
                {
                    as = new String[1];
                    as[0] = s1;
                }
            }
        }
        if(as.length > 2)
        {
            as = new String[1];
            as[0] = p_78860_0_;
        }
        String s = as[0];
        int j = as.length <= 1 ? 25565 : func_78862_a(as[1], 25565);
        if(j == 25565)
        {
            String as1[] = func_78863_b(s);
            s = as1[0];
            j = func_78862_a(as1[1], 25565);
        }
        return new ServerAddress(s, j);
    }

    private static String[] func_78863_b(String p_78863_0_)
    {
        try
        {
            Hashtable hashtable = new Hashtable();
            hashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            hashtable.put("java.naming.provider.url", "dns:");
            InitialDirContext initialdircontext = new InitialDirContext(hashtable);
            Attributes attributes = initialdircontext.getAttributes((new StringBuilder()).append("_minecraft._tcp.").append(p_78863_0_).toString(), new String[] {
                "SRV"
            });
            String as[] = attributes.get("srv").get().toString().split(" ", 4);
            return (new String[] {
                as[3], as[2]
            });
        }
        catch(Throwable throwable)
        {
            return (new String[] {
                p_78863_0_, Integer.toString(25565)
            });
        }
    }

    private static int func_78862_a(String p_78862_0_, int p_78862_1_)
    {
        try
        {
            return Integer.parseInt(p_78862_0_.trim());
        }
        catch(Exception exception)
        {
            return p_78862_1_;
        }
    }
}
