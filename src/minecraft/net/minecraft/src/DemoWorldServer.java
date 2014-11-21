package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class DemoWorldServer extends WorldServer
{
    private static final long demoWorldSeed;
    public static final WorldSettings demoWorldSettings;

    public DemoWorldServer(MinecraftServer par1MinecraftServer, ISaveHandler par2ISaveHandler, String par3Str, int par4, Profiler par5Profiler)
    {
        super(par1MinecraftServer, par2ISaveHandler, par3Str, par4, demoWorldSettings, par5Profiler);
    }

    static
    {
        demoWorldSeed = "North Carolina".hashCode();
        demoWorldSettings = (new WorldSettings(demoWorldSeed, EnumGameType.SURVIVAL, true, false, WorldType.DEFAULT)).enableBonusChest();
    }
}
