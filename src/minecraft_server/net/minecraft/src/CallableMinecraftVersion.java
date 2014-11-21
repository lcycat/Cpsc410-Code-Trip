package net.minecraft.src;

import java.util.concurrent.Callable;

class CallableMinecraftVersion implements Callable
{
    /** Initialises the CrashReport to have current Minecraft Version. */
    final CrashReport minecraftCrashReports;

    CallableMinecraftVersion(CrashReport par1CrashReport)
    {
        minecraftCrashReports = par1CrashReport;
    }

    public String func_71493_a()
    {
        return "1.3.1";
    }

    public Object call()
    {
        return func_71493_a();
    }
}
