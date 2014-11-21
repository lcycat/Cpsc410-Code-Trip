package net.minecraft.src;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BanList
{
    private final LowerStringMap field_73715_a = new LowerStringMap();
    private final File field_73713_b;
    private boolean field_73714_c;

    public BanList(File par1File)
    {
        field_73714_c = true;
        field_73713_b = par1File;
    }

    public boolean func_73710_b()
    {
        return field_73714_c;
    }

    public void func_73708_a(boolean par1)
    {
        field_73714_c = par1;
    }

    public Map func_73712_c()
    {
        func_73705_d();
        return field_73715_a;
    }

    public boolean func_73704_a(String par1Str)
    {
        if (!func_73710_b())
        {
            return false;
        }
        else
        {
            func_73705_d();
            return field_73715_a.containsKey(par1Str);
        }
    }

    public void func_73706_a(BanEntry par1BanEntry)
    {
        field_73715_a.func_76116_a(par1BanEntry.func_73684_a(), par1BanEntry);
        func_73711_f();
    }

    public void func_73709_b(String par1Str)
    {
        field_73715_a.remove(par1Str);
        func_73711_f();
    }

    public void func_73705_d()
    {
        Iterator iterator = field_73715_a.values().iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            BanEntry banentry = (BanEntry)iterator.next();

            if (banentry.func_73682_e())
            {
                iterator.remove();
            }
        }
        while (true);
    }

    public void func_73707_e()
    {
        if (!field_73713_b.isFile())
        {
            return;
        }

        BufferedReader bufferedreader;

        try
        {
            bufferedreader = new BufferedReader(new FileReader(field_73713_b));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            throw new Error();
        }

        try
        {
            do
            {
                String s;

                if ((s = bufferedreader.readLine()) == null)
                {
                    break;
                }

                if (!s.startsWith("#"))
                {
                    BanEntry banentry = BanEntry.func_73688_c(s);

                    if (banentry != null)
                    {
                        field_73715_a.func_76116_a(banentry.func_73684_a(), banentry);
                    }
                }
            }
            while (true);
        }
        catch (IOException ioexception)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not load ban list", ioexception);
        }
    }

    public void func_73711_f()
    {
        func_73703_b(true);
    }

    public void func_73703_b(boolean par1)
    {
        func_73705_d();

        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_73713_b, false));

            if (par1)
            {
                printwriter.println((new StringBuilder()).append("# Updated ").append((new SimpleDateFormat()).format(new Date())).append(" by Minecraft ").append("1.3.1").toString());
                printwriter.println("# victim name | ban date | banned by | banned until | reason");
                printwriter.println();
            }

            BanEntry banentry;

            for (Iterator iterator = field_73715_a.values().iterator(); iterator.hasNext(); printwriter.println(banentry.func_73685_g()))
            {
                banentry = (BanEntry)iterator.next();
            }

            printwriter.close();
        }
        catch (IOException ioexception)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not save ban list", ioexception);
        }
    }
}
