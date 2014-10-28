package net.minecraft.src;

import java.util.logging.*;

public class ConsoleLogManager
{
    /** Log manager of Minecraft. */
    public static Logger loggerLogManager = Logger.getLogger("Minecraft");

    public static void func_73699_a()
    {
        ConsoleLogFormatter consolelogformatter = new ConsoleLogFormatter();
        loggerLogManager.setUseParentHandlers(false);
        ConsoleHandler consolehandler = new ConsoleHandler();
        consolehandler.setFormatter(consolelogformatter);
        loggerLogManager.addHandler(consolehandler);

        try
        {
            FileHandler filehandler = new FileHandler("server.log", true);
            filehandler.setFormatter(consolelogformatter);
            loggerLogManager.addHandler(filehandler);
        }
        catch (Exception exception)
        {
            loggerLogManager.log(Level.WARNING, "Failed to log to server.log", exception);
        }
    }
}
