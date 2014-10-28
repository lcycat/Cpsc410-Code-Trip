// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package net.minecraft.src:
//            LowerStringMap, BanEntry

public class BanList
{

    private final LowerStringMap field_73715_a = new LowerStringMap();
    private final File field_73713_b;
    private boolean field_73714_c;

    public BanList(File p_i3368_1_)
    {
        field_73714_c = true;
        field_73713_b = p_i3368_1_;
    }

    public boolean func_73710_b()
    {
        return field_73714_c;
    }

    public void func_73708_a(boolean p_73708_1_)
    {
        field_73714_c = p_73708_1_;
    }

    public Map func_73712_c()
    {
        func_73705_d();
        return field_73715_a;
    }

    public boolean func_73704_a(String p_73704_1_)
    {
        if(!func_73710_b())
        {
            return false;
        } else
        {
            func_73705_d();
            return field_73715_a.containsKey(p_73704_1_);
        }
    }

    public void func_73706_a(BanEntry p_73706_1_)
    {
        field_73715_a.func_76116_a(p_73706_1_.func_73684_a(), p_73706_1_);
        func_73711_f();
    }

    public void func_73709_b(String p_73709_1_)
    {
        field_73715_a.remove(p_73709_1_);
        func_73711_f();
    }

    public void func_73705_d()
    {
        Iterator iterator = field_73715_a.values().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            BanEntry banentry = (BanEntry)iterator.next();
            if(banentry.func_73682_e())
            {
                iterator.remove();
            }
        } while(true);
    }

    public void func_73707_e()
    {
        if(!field_73713_b.isFile())
        {
            return;
        }
        BufferedReader bufferedreader;
        try
        {
            bufferedreader = new BufferedReader(new FileReader(field_73713_b));
        }
        catch(FileNotFoundException filenotfoundexception)
        {
            throw new Error();
        }
        try
        {
            do
            {
                String s;
                if((s = bufferedreader.readLine()) == null)
                {
                    break;
                }
                if(!s.startsWith("#"))
                {
                    BanEntry banentry = BanEntry.func_73688_c(s);
                    if(banentry != null)
                    {
                        field_73715_a.func_76116_a(banentry.func_73684_a(), banentry);
                    }
                }
            } while(true);
        }
        catch(IOException ioexception)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not load ban list", ioexception);
        }
    }

    public void func_73711_f()
    {
        func_73703_b(true);
    }

    public void func_73703_b(boolean p_73703_1_)
    {
        func_73705_d();
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_73713_b, false));
            if(p_73703_1_)
            {
                printwriter.println((new StringBuilder()).append("# Updated ").append((new SimpleDateFormat()).format(new Date())).append(" by Minecraft ").append("1.3.1").toString());
                printwriter.println("# victim name | ban date | banned by | banned until | reason");
                printwriter.println();
            }
            BanEntry banentry;
            for(Iterator iterator = field_73715_a.values().iterator(); iterator.hasNext(); printwriter.println(banentry.func_73685_g()))
            {
                banentry = (BanEntry)iterator.next();
            }

            printwriter.close();
        }
        catch(IOException ioexception)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, "Could not save ban list", ioexception);
        }
    }
}
