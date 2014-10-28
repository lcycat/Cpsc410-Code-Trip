package net.minecraft.src;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrashReport
{
    /** Description of the crash report. */
    private final String description;

    /** The Throwable that is the "cause" for this crash and Crash Report. */
    private final Throwable cause;

    /** Holds the keys and values of all crash report sections. */
    private final Map crashReportSections = new LinkedHashMap();

    /** File of crash report. */
    private File crashReportFile;

    public CrashReport(String par1Str, Throwable par2Throwable)
    {
        crashReportFile = null;
        description = par1Str;
        cause = par2Throwable;
        func_71504_g();
    }

    private void func_71504_g()
    {
        addCrashSectionCallable("Minecraft Version", new CallableMinecraftVersion(this));
        addCrashSectionCallable("Operating System", new CallableOSInfo(this));
        addCrashSectionCallable("Java Version", new CallableJavaInfo(this));
        addCrashSectionCallable("Java VM Version", new CallableJavaInfo2(this));
        addCrashSectionCallable("Memory", new CallableMemoryInfo(this));
        addCrashSectionCallable("JVM Flags", new CallableJVMFlags(this));
        addCrashSection("ModLoader", ModLoader.getCrashReport());
    }

    /**
     * Adds a Crashreport section with the given name with the value set to the result of the given Callable;
     */
    public void addCrashSectionCallable(String par1Str, Callable par2Callable)
    {
        try
        {
            addCrashSection(par1Str, par2Callable.call());
        }
        catch (Throwable throwable)
        {
            addCrashSectionThrowable(par1Str, throwable);
        }
    }

    /**
     * Adds a Crashreport section with the given name with the given value (convered .toString())
     */
    public void addCrashSection(String par1Str, Object par2Obj)
    {
        crashReportSections.put(par1Str, par2Obj == null ? "null" : ((Object)(par2Obj.toString())));
    }

    /**
     * Adds a Crashreport section with the given name with the given Throwable
     */
    public void addCrashSectionThrowable(String par1Str, Throwable par2Throwable)
    {
        addCrashSection(par1Str, (new StringBuilder()).append("~ERROR~ ").append(par2Throwable.getClass().getSimpleName()).append(": ").append(par2Throwable.getMessage()).toString());
    }

    /**
     * Returns the description of the Crash Report.
     */
    public String getDescription()
    {
        return description;
    }

    public Throwable func_71505_b()
    {
        return cause;
    }

    /**
     * Gets a string representation of all sections in the crash report.
     */
    public String getSections()
    {
        StringBuilder stringbuilder = new StringBuilder();
        getSectionsInStringBuilder(stringbuilder);
        return stringbuilder.toString();
    }

    /**
     * Gets the various sections of the crash report into the given StringBuilder
     */
    public void getSectionsInStringBuilder(StringBuilder par1StringBuilder)
    {
        boolean flag = true;

        for (Iterator iterator = crashReportSections.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();

            if (!flag)
            {
                par1StringBuilder.append("\n");
            }

            par1StringBuilder.append("- ");
            par1StringBuilder.append((String)entry.getKey());
            par1StringBuilder.append(": ");
            par1StringBuilder.append((String)entry.getValue());
            flag = false;
        }
    }

    /**
     * Gets the stack trace of the Throwable that caused this crash report, or if that fails, the cause .toString().
     */
    public String getCauseStackTraceOrString()
    {
        StringWriter stringwriter = null;
        PrintWriter printwriter = null;
        String s = cause.toString();

        try
        {
            stringwriter = new StringWriter();
            printwriter = new PrintWriter(stringwriter);
            cause.printStackTrace(printwriter);
            s = stringwriter.toString();
        }
        finally
        {
            try
            {
                if (stringwriter != null)
                {
                    stringwriter.close();
                }

                if (printwriter != null)
                {
                    printwriter.close();
                }
            }
            catch (IOException ioexception) { }
        }

        return s;
    }

    /**
     * Gets the complete report with headers, stack trace, and different sections as a string.
     */
    public String getCompleteReport()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("---- Minecraft Crash Report ----\n");
        stringbuilder.append("// ");
        stringbuilder.append(getWittyComment());
        stringbuilder.append("\n\n");
        stringbuilder.append("Time: ");
        stringbuilder.append((new SimpleDateFormat()).format(new Date()));
        stringbuilder.append("\n");
        stringbuilder.append("Description: ");
        stringbuilder.append(description);
        stringbuilder.append("\n\n");
        stringbuilder.append(getCauseStackTraceOrString());
        stringbuilder.append("\n");
        stringbuilder.append("Relevant Details:");
        stringbuilder.append("\n");
        getSectionsInStringBuilder(stringbuilder);
        return stringbuilder.toString();
    }

    /**
     * Gets the file this crash report is saved into.
     */
    public File getFile()
    {
        return crashReportFile;
    }

    /**
     * Saves the complete crash report to the given File.
     */
    public boolean saveToFile(File par1File)
    {
        if (crashReportFile != null)
        {
            return false;
        }

        if (par1File.getParentFile() != null)
        {
            par1File.getParentFile().mkdirs();
        }

        try
        {
            FileWriter filewriter = new FileWriter(par1File);
            filewriter.write(getCompleteReport());
            filewriter.close();
            crashReportFile = par1File;
            return true;
        }
        catch (Throwable throwable)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, (new StringBuilder()).append("Could not save crash report to ").append(par1File).toString(), throwable);
        }

        return false;
    }

    /**
     * Gets a random witty comment for inclusion in this CrashReport
     */
    private static String getWittyComment()
    {
        String as[] =
        {
            "Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!",
            "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.",
            "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :("
        };

        try
        {
            return as[(int)(System.nanoTime() % (long)as.length)];
        }
        catch (Throwable throwable)
        {
            return "Witty comment unavailable :(";
        }
    }
}
