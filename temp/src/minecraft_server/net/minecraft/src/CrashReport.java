// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package net.minecraft.src:
//            CallableMinecraftVersion, CallableOSInfo, CallableJavaInfo, CallableJavaInfo2, 
//            CallableMemoryInfo, CallableJVMFlags, ModLoader

public class CrashReport
{

    private final String field_71513_a;
    private final Throwable field_71511_b;
    private final Map field_71512_c = new LinkedHashMap();
    private File field_71510_d;

    public CrashReport(String p_i3250_1_, Throwable p_i3250_2_)
    {
        field_71510_d = null;
        field_71513_a = p_i3250_1_;
        field_71511_b = p_i3250_2_;
        func_71504_g();
    }

    private void func_71504_g()
    {
        func_71500_a("Minecraft Version", new CallableMinecraftVersion(this));
        func_71500_a("Operating System", new CallableOSInfo(this));
        func_71500_a("Java Version", new CallableJavaInfo(this));
        func_71500_a("Java VM Version", new CallableJavaInfo2(this));
        func_71500_a("Memory", new CallableMemoryInfo(this));
        func_71500_a("JVM Flags", new CallableJVMFlags(this));
        func_71507_a("ModLoaderMP", ModLoader.getCrashReport());
    }

    public void func_71500_a(String p_71500_1_, Callable p_71500_2_)
    {
        try
        {
            func_71507_a(p_71500_1_, p_71500_2_.call());
        }
        catch(Throwable throwable)
        {
            func_71499_a(p_71500_1_, throwable);
        }
    }

    public void func_71507_a(String p_71507_1_, Object p_71507_2_)
    {
        field_71512_c.put(p_71507_1_, p_71507_2_ != null ? ((Object) (p_71507_2_.toString())) : "null");
    }

    public void func_71499_a(String p_71499_1_, Throwable p_71499_2_)
    {
        func_71507_a(p_71499_1_, (new StringBuilder()).append("~ERROR~ ").append(p_71499_2_.getClass().getSimpleName()).append(": ").append(p_71499_2_.getMessage()).toString());
    }

    public String func_71501_a()
    {
        return field_71513_a;
    }

    public Throwable func_71505_b()
    {
        return field_71511_b;
    }

    public void func_71506_a(StringBuilder p_71506_1_)
    {
        boolean flag = true;
        for(Iterator iterator = field_71512_c.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(!flag)
            {
                p_71506_1_.append("\n");
            }
            p_71506_1_.append("- ");
            p_71506_1_.append((String)entry.getKey());
            p_71506_1_.append(": ");
            p_71506_1_.append((String)entry.getValue());
            flag = false;
        }

    }

    public String func_71498_d()
    {
        StringWriter stringwriter = null;
        PrintWriter printwriter = null;
        String s = field_71511_b.toString();
        try
        {
            stringwriter = new StringWriter();
            printwriter = new PrintWriter(stringwriter);
            field_71511_b.printStackTrace(printwriter);
            s = stringwriter.toString();
        }
        finally
        {
            try
            {
                if(stringwriter != null)
                {
                    stringwriter.close();
                }
                if(printwriter != null)
                {
                    printwriter.close();
                }
            }
            catch(IOException ioexception) { }
        }
        return s;
    }

    public String func_71502_e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("---- Minecraft Crash Report ----\n");
        stringbuilder.append("// ");
        stringbuilder.append(func_71503_h());
        stringbuilder.append("\n\n");
        stringbuilder.append("Time: ");
        stringbuilder.append((new SimpleDateFormat()).format(new Date()));
        stringbuilder.append("\n");
        stringbuilder.append("Description: ");
        stringbuilder.append(field_71513_a);
        stringbuilder.append("\n\n");
        stringbuilder.append(func_71498_d());
        stringbuilder.append("\n");
        stringbuilder.append("Relevant Details:");
        stringbuilder.append("\n");
        func_71506_a(stringbuilder);
        return stringbuilder.toString();
    }

    public boolean func_71508_a(File p_71508_1_)
    {
        if(field_71510_d != null)
        {
            return false;
        }
        if(p_71508_1_.getParentFile() != null)
        {
            p_71508_1_.getParentFile().mkdirs();
        }
        try
        {
            FileWriter filewriter = new FileWriter(p_71508_1_);
            filewriter.write(func_71502_e());
            filewriter.close();
            field_71510_d = p_71508_1_;
            return true;
        }
        catch(Throwable throwable)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, (new StringBuilder()).append("Could not save crash report to ").append(p_71508_1_).toString(), throwable);
        }
        return false;
    }

    private static String func_71503_h()
    {
        String as[] = {
            "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", 
            "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", 
            "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :("
        };
        try
        {
            return as[(int)(System.nanoTime() % (long)as.length)];
        }
        catch(Throwable throwable)
        {
            return "Witty comment unavailable :(";
        }
    }
}
