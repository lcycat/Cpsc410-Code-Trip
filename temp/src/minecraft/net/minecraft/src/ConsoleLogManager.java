// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.logging.*;

// Referenced classes of package net.minecraft.src:
//            ConsoleLogFormatter

public class ConsoleLogManager
{

    public static Logger field_73700_a = Logger.getLogger("Minecraft");

    public static void func_73699_a()
    {
        ConsoleLogFormatter consolelogformatter = new ConsoleLogFormatter();
        field_73700_a.setUseParentHandlers(false);
        ConsoleHandler consolehandler = new ConsoleHandler();
        consolehandler.setFormatter(consolelogformatter);
        field_73700_a.addHandler(consolehandler);
        try
        {
            FileHandler filehandler = new FileHandler("server.log", true);
            filehandler.setFormatter(consolelogformatter);
            field_73700_a.addHandler(filehandler);
        }
        catch(Exception exception)
        {
            field_73700_a.log(Level.WARNING, "Failed to log to server.log", exception);
        }
    }

}
