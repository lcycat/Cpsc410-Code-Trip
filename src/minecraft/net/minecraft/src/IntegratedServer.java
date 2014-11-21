package net.minecraft.src;

import java.io.*;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

public class IntegratedServer extends MinecraftServer
{
    /** The Minecraft instance. */
    private final Minecraft mc;
    private final WorldSettings field_71350_m;
    private IntegratedServerListenThread field_71347_n;
    private boolean field_71348_o;
    private boolean isPublic;
    private ThreadLanServerPing field_71345_q;

    public IntegratedServer(Minecraft par1Minecraft, String par2Str, String par3Str, WorldSettings par4WorldSettings)
    {
        super(new File(Minecraft.getMinecraftDir(), "saves"));
        field_71348_o = false;
        setServerOwner(par1Minecraft.session.username);
        setFolderName(par2Str);
        setWorldName(par3Str);
        setDemo(par1Minecraft.isDemo());
        canCreateBonusChest(par4WorldSettings.isBonusChestEnabled());
        setBuildLimit(256);
        setServerConfigManager(new IntegratedPlayerList(this));
        mc = par1Minecraft;
        field_71350_m = par4WorldSettings;
        ModLoader.registerCommands(this);

        try
        {
            field_71347_n = new IntegratedServerListenThread(this);
        }
        catch (IOException ioexception)
        {
            throw new Error();
        }
    }

    protected void loadAllDimensions(String par1Str, String par2Str, long par3, WorldType par5WorldType)
    {
        convertMapIfNeeded(par1Str);
        dimensionServerList = new WorldServer[3];
        timeOfLastDimenstionTick = new long[dimensionServerList.length][100];
        ISaveHandler isavehandler = getActiveAnvilConverter().getSaveLoader(par1Str, true);

        for (int i = 0; i < dimensionServerList.length; i++)
        {
            byte byte0 = 0;

            if (i == 1)
            {
                byte0 = -1;
            }

            if (i == 2)
            {
                byte0 = 1;
            }

            if (i == 0)
            {
                if (isDemo())
                {
                    dimensionServerList[i] = new DemoWorldServer(this, isavehandler, par2Str, byte0, theProfiler);
                }
                else
                {
                    dimensionServerList[i] = new WorldServer(this, isavehandler, par2Str, byte0, field_71350_m, theProfiler);
                }
            }
            else
            {
                dimensionServerList[i] = new WorldServerMulti(this, isavehandler, par2Str, byte0, field_71350_m, dimensionServerList[0], theProfiler);
            }

            dimensionServerList[i].addWorldAccess(new WorldManager(this, dimensionServerList[i]));
            getConfigurationManager().func_72364_a(dimensionServerList);
        }

        setDifficultyForAllDimensions(getDifficulty());
        initialWorldChunkLoad();
    }

    /**
     * Initialises the server and starts it.
     */
    protected boolean startServer() throws IOException
    {
        logger.info("Starting integrated minecraft server version 1.3.1");
        setOnlineMode(false);
        setSpawnAnimals(true);
        setSpawnNpcs(true);
        setAllowPvp(true);
        setAllowFlight(true);
        logger.info("Generating keypair");
        setKeyPair(CryptManager.createNewKeyPair());
        loadAllDimensions(getFolderName(), getWorldName(), field_71350_m.getSeed(), field_71350_m.getTerrainType());
        setMOTD((new StringBuilder()).append(getServerOwner()).append(" - ").append(dimensionServerList[0].getWorldInfo().getWorldName()).toString());
        return true;
    }

    /**
     * main function called by run() every loop
     */
    public void tick()
    {
        boolean flag = field_71348_o;
        field_71348_o = field_71347_n.func_71752_f();

        if (!flag && field_71348_o)
        {
            logger.info("Saving and pausing game...");
            getConfigurationManager().saveAllPlayerData();
            saveAllDimensions(false);
        }

        if (!field_71348_o)
        {
            super.tick();
        }
    }

    public boolean canStructuresSpawn()
    {
        return false;
    }

    public EnumGameType getGameType()
    {
        return field_71350_m.getGameType();
    }

    /**
     * defaults to "1" for the dedicated server
     */
    public int getDifficulty()
    {
        return mc.gameSettings.difficulty;
    }

    /**
     * defaults to false
     */
    public boolean isHardcore()
    {
        return field_71350_m.getHardcoreEnabled();
    }

    protected File getDataDirectory()
    {
        return mc.mcDataDir;
    }

    public boolean isDedicatedServer()
    {
        return false;
    }

    public IntegratedServerListenThread func_71343_a()
    {
        return field_71347_n;
    }

    /**
     * called on exit from the main run loop
     */
    protected void finalTick(CrashReport par1CrashReport)
    {
        mc.crashed(par1CrashReport);
    }

    /**
     * iterates the worldServers and adds their info also
     */
    public CrashReport addServerInfoToCrashReport(CrashReport par1CrashReport)
    {
        par1CrashReport.addCrashSectionCallable("Type", new CallableType3(this));
        par1CrashReport.addCrashSectionCallable("Is Modded", new CallableIsModded(this));
        return super.addServerInfoToCrashReport(par1CrashReport);
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return Minecraft.getMinecraft().isSnooperEnabled();
    }

    /**
     * does nothing on dedicated. on integrated, sets commandsAllowedForAll and gameType and allows external connections
     */
    public String shareToLAN(EnumGameType par1EnumGameType, boolean par2)
    {
        try
        {
            String s = field_71347_n.func_71755_c();
            System.out.println((new StringBuilder()).append("Started on ").append(s).toString());
            isPublic = true;
            field_71345_q = new ThreadLanServerPing(getMOTD(), s);
            field_71345_q.start();
            getConfigurationManager().setGameType(par1EnumGameType);
            getConfigurationManager().setCommandsAllowedForAll(par2);
            return s;
        }
        catch (IOException ioexception)
        {
            return null;
        }
    }

    /**
     * Saves all necessary data as preparation for stopping the server.
     */
    public void stopServer()
    {
        super.stopServer();

        if (field_71345_q != null)
        {
            field_71345_q.interrupt();
            field_71345_q = null;
        }
    }

    /**
     * sets serverRunning to false
     */
    public void setServerStopping()
    {
        super.setServerStopping();

        if (field_71345_q != null)
        {
            field_71345_q.interrupt();
            field_71345_q = null;
        }
    }

    public boolean func_71344_c()
    {
        return isPublic;
    }

    /**
     * sets the game type for all dimensions
     */
    public void setGameType(EnumGameType par1EnumGameType)
    {
        getConfigurationManager().setGameType(par1EnumGameType);
    }

    public NetworkListenThread getNetworkThread()
    {
        return func_71343_a();
    }
}
