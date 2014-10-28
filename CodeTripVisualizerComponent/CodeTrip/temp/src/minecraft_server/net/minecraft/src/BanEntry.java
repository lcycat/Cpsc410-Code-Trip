// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class BanEntry
{

    public static final SimpleDateFormat field_73698_a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    public static Logger field_73696_b = Logger.getLogger("Minecraft");
    private final String field_73697_c;
    private Date field_73694_d;
    private String field_73695_e;
    private Date field_73692_f;
    private String field_73693_g;

    public BanEntry(String p_i3367_1_)
    {
        field_73694_d = new Date();
        field_73695_e = "(Unknown)";
        field_73692_f = null;
        field_73693_g = "Banned by an operator.";
        field_73697_c = p_i3367_1_;
    }

    public String func_73684_a()
    {
        return field_73697_c;
    }

    public Date func_73683_b()
    {
        return field_73694_d;
    }

    public void func_73681_a(Date p_73681_1_)
    {
        field_73694_d = p_73681_1_ == null ? new Date() : p_73681_1_;
    }

    public String func_73690_c()
    {
        return field_73695_e;
    }

    public void func_73687_a(String p_73687_1_)
    {
        field_73695_e = p_73687_1_;
    }

    public Date func_73680_d()
    {
        return field_73692_f;
    }

    public void func_73691_b(Date p_73691_1_)
    {
        field_73692_f = p_73691_1_;
    }

    public boolean func_73682_e()
    {
        if(field_73692_f == null)
        {
            return false;
        } else
        {
            return field_73692_f.before(new Date());
        }
    }

    public String func_73686_f()
    {
        return field_73693_g;
    }

    public void func_73689_b(String p_73689_1_)
    {
        field_73693_g = p_73689_1_;
    }

    public String func_73685_g()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(func_73684_a());
        stringbuilder.append("|");
        stringbuilder.append(field_73698_a.format(func_73683_b()));
        stringbuilder.append("|");
        stringbuilder.append(func_73690_c());
        stringbuilder.append("|");
        stringbuilder.append(func_73680_d() != null ? field_73698_a.format(func_73680_d()) : "Forever");
        stringbuilder.append("|");
        stringbuilder.append(func_73686_f());
        return stringbuilder.toString();
    }

    public static BanEntry func_73688_c(String p_73688_0_)
    {
        if(p_73688_0_.trim().length() < 2)
        {
            return null;
        }
        String as[] = p_73688_0_.trim().split(Pattern.quote("|"), 5);
        BanEntry banentry = new BanEntry(as[0].trim());
        int i = 0;
        if(as.length <= ++i)
        {
            return banentry;
        }
        try
        {
            banentry.func_73681_a(field_73698_a.parse(as[i].trim()));
        }
        catch(ParseException parseexception)
        {
            field_73696_b.log(Level.WARNING, (new StringBuilder()).append("Could not read creation date format for ban entry '").append(banentry.func_73684_a()).append("' (was: '").append(as[i]).append("')").toString(), parseexception);
        }
        if(as.length <= ++i)
        {
            return banentry;
        }
        banentry.func_73687_a(as[i].trim());
        if(as.length <= ++i)
        {
            return banentry;
        }
        try
        {
            String s = as[i].trim();
            if(!s.equalsIgnoreCase("Forever") && s.length() > 0)
            {
                banentry.func_73691_b(field_73698_a.parse(s));
            }
        }
        catch(ParseException parseexception1)
        {
            field_73696_b.log(Level.WARNING, (new StringBuilder()).append("Could not read expiry date format for ban entry '").append(banentry.func_73684_a()).append("' (was: '").append(as[i]).append("')").toString(), parseexception1);
        }
        if(as.length <= ++i)
        {
            return banentry;
        } else
        {
            banentry.func_73689_b(as[i].trim());
            return banentry;
        }
    }

}
