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

    /** Creates Ban Entry in the logger. */
    public static Logger loggerBanEntry = Logger.getLogger("Minecraft");
    private final String field_73697_c;
    private Date field_73694_d;
    private String field_73695_e;
    private Date field_73692_f;
    private String field_73693_g;

    public BanEntry(String par1Str)
    {
        field_73694_d = new Date();
        field_73695_e = "(Unknown)";
        field_73692_f = null;
        field_73693_g = "Banned by an operator.";
        field_73697_c = par1Str;
    }

    public String func_73684_a()
    {
        return field_73697_c;
    }

    public Date func_73683_b()
    {
        return field_73694_d;
    }

    public void func_73681_a(Date par1Date)
    {
        field_73694_d = par1Date == null ? new Date() : par1Date;
    }

    public String func_73690_c()
    {
        return field_73695_e;
    }

    public void func_73687_a(String par1Str)
    {
        field_73695_e = par1Str;
    }

    public Date func_73680_d()
    {
        return field_73692_f;
    }

    public void func_73691_b(Date par1Date)
    {
        field_73692_f = par1Date;
    }

    public boolean func_73682_e()
    {
        if (field_73692_f == null)
        {
            return false;
        }
        else
        {
            return field_73692_f.before(new Date());
        }
    }

    public String func_73686_f()
    {
        return field_73693_g;
    }

    public void func_73689_b(String par1Str)
    {
        field_73693_g = par1Str;
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

    public static BanEntry func_73688_c(String par0Str)
    {
        if (par0Str.trim().length() < 2)
        {
            return null;
        }

        String as[] = par0Str.trim().split(Pattern.quote("|"), 5);
        BanEntry banentry = new BanEntry(as[0].trim());
        int i = 0;

        if (as.length <= ++i)
        {
            return banentry;
        }

        try
        {
            banentry.func_73681_a(field_73698_a.parse(as[i].trim()));
        }
        catch (ParseException parseexception)
        {
            loggerBanEntry.log(Level.WARNING, (new StringBuilder()).append("Could not read creation date format for ban entry '").append(banentry.func_73684_a()).append("' (was: '").append(as[i]).append("')").toString(), parseexception);
        }

        if (as.length <= ++i)
        {
            return banentry;
        }

        banentry.func_73687_a(as[i].trim());

        if (as.length <= ++i)
        {
            return banentry;
        }

        try
        {
            String s = as[i].trim();

            if (!s.equalsIgnoreCase("Forever") && s.length() > 0)
            {
                banentry.func_73691_b(field_73698_a.parse(s));
            }
        }
        catch (ParseException parseexception1)
        {
            loggerBanEntry.log(Level.WARNING, (new StringBuilder()).append("Could not read expiry date format for ban entry '").append(banentry.func_73684_a()).append("' (was: '").append(as[i]).append("')").toString(), parseexception1);
        }

        if (as.length <= ++i)
        {
            return banentry;
        }
        else
        {
            banentry.func_73689_b(as[i].trim());
            return banentry;
        }
    }
}
