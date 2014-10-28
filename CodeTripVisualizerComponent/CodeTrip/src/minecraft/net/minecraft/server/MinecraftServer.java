package net.minecraft.server;

import java.io.File;
import java.io.IOException;
import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.src.AABBPool;
import net.minecraft.src.AnvilSaveConverter;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.CallableIsServerModded;
import net.minecraft.src.CallablePlayers;
import net.minecraft.src.CallableServerProfiler;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkProviderServer;
import net.minecraft.src.CommandBase;
import net.minecraft.src.ConvertProgressUpdater;
import net.minecraft.src.CrashReport;
import net.minecraft.src.DemoWorldServer;
import net.minecraft.src.EntityTracker;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.ICommandManager;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.IPlayerUsage;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.IUpdatePlayerListBox;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.NetworkListenThread;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.PlayerUsageSnooper;
import net.minecraft.src.Profiler;
import net.minecraft.src.RConConsoleSource;
import net.minecraft.src.ReportedException;
import net.minecraft.src.ServerCommandManager;
import net.minecraft.src.ServerConfigurationManager;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.StringUtils;
import net.minecraft.src.ThreadServerApplication;
import net.minecraft.src.Vec3;
import net.minecraft.src.Vec3Pool;
import net.minecraft.src.World;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldManager;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldServer;
import net.minecraft.src.WorldServerMulti;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;

public abstract class MinecraftServer implements Runnable, IPlayerUsage, ICommandSender
{
    /** The logging system. */
    public static Logger logger = Logger.getLogger("Minecraft");

    /** Instance of Minecraft Server. */
    private static MinecraftServer mcServer = null;
    private final ISaveFormat anvilConverterForAnvilFile;

    /** The PlayerUsageSnooper instance. */
    private final PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("server", this);
    private final File anvilFile;

    /** List of names of players who are online. */
    private final List playersOnline = new ArrayList();
    private final ICommandManager commandManager;
    public final Profiler theProfiler = new Profiler();

    /** The server's hostname. */
    private String hostname;
    private int serverPort;
    public WorldServer dimensionServerList[];

    /** The ServerConfigurationManager instance. */
    private ServerConfigurationManager serverConfigManager;
    private boolean serverShouldContinueRunning;

    /** Indicates to other classes that the server is safely stopped. */
    private boolean serverStopped;

    /** incremented every tick */
    private int tickCounter;

    /**
     * The task the server is currently working on(and will output on outputPercentRemaining).
     */
    public String currentTask;

    /** The percentage of the current task finished so far. */
    public int percentDone;

    /** True if the server is in online mode. */
    private boolean onlineMode;
    private boolean canAnimalsSpawn;
    private boolean canNPCsSpawn;

    /** Indicates whether PvP is active on the server or not. */
    private boolean pvpEnabled;

    /** Determines if flight is Allowed or not. */
    private boolean allowFlight;

    /** The server MOTD string. */
    private String motd;

    /** Maximum build height. */
    private int buildLimit;
    private long lastSentPacketID;
    private long lastSentPacketSize;
    private long lastRecievedID;
    private long lastRecievedSize;
    public final long sentPacketCountArray[] = new long[100];
    public final long sentPacketSizeArray[] = new long[100];
    public final long recievedPacketCountArray[] = new long[100];
    public final long recievedPacketSizeArray[] = new long[100];
    public final long tickTimeArray[] = new long[100];
    public long timeOfLastDimenstionTick[][];
    private KeyPair serverKeyPair;

    /** Username of the server owner (for integrated servers) */
    private String serverOwner;
    private String folderName;
    private String worldName;
    private boolean isDemo;
    private boolean enableBonusChest;

    /**
     * if this is set, there is no need to save chunks or stop the server, because that is already being done.
     */
    private boolean worldIsBeingDeleted;
    private String texturePack;
    private boolean serverIsRunning;

    /**
     * set when the client is warned for "can'tKeepUp", only trigger again after 15 seconds
     */
    private long timeOfLastWarning;
    private String userMessage;
    private boolean startProfiling;

    public MinecraftServer(File par1File)
    {
        serverPort = -1;
        serverShouldContinueRunning = true;
        serverStopped = false;
        tickCounter = 0;
        texturePack = "";
        serverIsRunning = false;
        mcServer = this;
        anvilFile = par1File;
        commandManager = new ServerCommandManager();
        anvilConverterForAnvilFile = new AnvilSaveConverter(par1File);
    }

    /**
     * Initialises the server and starts it.
     */
    protected abstract boolean startServer() throws IOException;

    protected void convertMapIfNeeded(String par1Str)
    {
        if (getActiveAnvilConverter().isOldMapFormat(par1Str))
        {
            logger.info("Converting map!");
            setUserMessage("menu.convertingLevel");
            getActiveAnvilConverter().convertMapFormat(par1Str, new ConvertProgressUpdater(this));
        }
    }

    /**
     * typically menu.convertingLevel, menu.loadingLevel,  saving, or others
     */
    protected synchronized void setUserMessage(String par1Str)
    {
        userMessage = par1Str;
    }

    public synchronized String getUserMessage()
    {
        return userMessage;
    }

    protected void loadAllDimensions(String par1Str, String par2Str, long par3, WorldType par5WorldType)
    {
        convertMapIfNeeded(par1Str);
        setUserMessage("menu.loadingLevel");
        dimensionServerList = new WorldServer[3];
        timeOfLastDimenstionTick = new long[dimensionServerList.length][100];
        ISaveHandler isavehandler = anvilConverterForAnvilFile.getSaveLoader(par1Str, true);
        WorldInfo worldinfo = isavehandler.loadWorldInfo();
        WorldSettings worldsettings;

        if (worldinfo == null)
        {
            worldsettings = new WorldSettings(par3, getGameType(), canStructuresSpawn(), isHardcore(), par5WorldType);
        }
        else
        {
            worldsettings = new WorldSettings(worldinfo);
        }

        if (enableBonusChest)
        {
            worldsettings.enableBonusChest();
        }

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
                    dimensionServerList[i] = new WorldServer(this, isavehandler, par2Str, byte0, worldsettings, theProfiler);
                }
            }
            else
            {
                dimensionServerList[i] = new WorldServerMulti(this, isavehandler, par2Str, byte0, worldsettings, dimensionServerList[0], theProfiler);
            }

            dimensionServerList[i].addWorldAccess(new WorldManager(this, dimensionServerList[i]));

            if (!isSinglePlayer())
            {
                dimensionServerList[i].getWorldInfo().setGameType(getGameType());
            }

            serverConfigManager.func_72364_a(dimensionServerList);
        }

        setDifficultyForAllDimensions(getDifficulty());
        initialWorldChunkLoad();
    }

    protected void initialWorldChunkLoad()
    {
        char c = '\304';
        long l = System.currentTimeMillis();
        setUserMessage("menu.generatingTerrain");

        for (int i = 0; i < 1; i++)
        {
            logger.info((new StringBuilder()).append("Preparing start region for level ").append(i).toString());
            WorldServer worldserver = dimensionServerList[i];
            ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();

            for (int j = -c; j <= c && isServerRunning(); j += 16)
            {
                for (int k = -c; k <= c && isServerRunning(); k += 16)
                {
                    long l1 = System.currentTimeMillis();

                    if (l1 < l)
                    {
                        l = l1;
                    }

                    if (l1 > l + 1000L)
                    {
                        int i1 = (c * 2 + 1) * (c * 2 + 1);
                        int j1 = (j + c) * (c * 2 + 1) + (k + 1);
                        outputPercentRemaining("Preparing spawn area", (j1 * 100) / i1);
                        l = l1;
                    }

                    worldserver.theChunkProviderServer.loadChunk(chunkcoordinates.posX + j >> 4, chunkcoordinates.posZ + k >> 4);

                    while (worldserver.updatingLighting() && isServerRunning()) ;
                }
            }
        }

        clearCurrentTask();
    }

    public abstract boolean canStructuresSpawn();

    public abstract EnumGameType getGameType();

    /**
     * defaults to "1" for the dedicated server
     */
    public abstract int getDifficulty();

    /**
     * defaults to false
     */
    public abstract boolean isHardcore();

    /**
     * Used to display a percent remaining given text and the percentage.
     */
    protected void outputPercentRemaining(String par1Str, int par2)
    {
        currentTask = par1Str;
        percentDone = par2;
        logger.info((new StringBuilder()).append(par1Str).append(": ").append(par2).append("%").toString());
    }

    /**
     * Set current task to null and set its percentage to 0.
     */
    protected void clearCurrentTask()
    {
        currentTask = null;
        percentDone = 0;
    }

    /**
     * par1 indicates if a log message should be output
     */
    protected void saveAllDimensions(boolean par1)
    {
        if (worldIsBeingDeleted)
        {
            return;
        }

        WorldServer aworldserver[] = dimensionServerList;
        int i = aworldserver.length;

        for (int j = 0; j < i; j++)
        {
            WorldServer worldserver = aworldserver[j];

            if (worldserver == null)
            {
                continue;
            }

            if (!par1)
            {
                logger.info((new StringBuilder()).append("Saving chunks for level '").append(worldserver.getWorldInfo().getWorldName()).append("'/").append(worldserver.provider).toString());
            }

            try
            {
                worldserver.saveAllChunks(true, null);
            }
            catch (MinecraftException minecraftexception)
            {
                logger.warning(minecraftexception.getMessage());
            }
        }
    }

    /**
     * Saves all necessary data as preparation for stopping the server.
     */
    public void stopServer()
    {
        if (worldIsBeingDeleted)
        {
            return;
        }

        logger.info("Stopping server");

        if (getNetworkThread() != null)
        {
            getNetworkThread().stopListening();
        }

        if (serverConfigManager != null)
        {
            logger.info("Saving players");
            serverConfigManager.saveAllPlayerData();
            serverConfigManager.removeAllPlayers();
        }

        logger.info("Saving worlds");
        saveAllDimensions(false);
        WorldServer aworldserver[] = dimensionServerList;
        int i = aworldserver.length;

        for (int j = 0; j < i; j++)
        {
            WorldServer worldserver = aworldserver[j];
            worldserver.flush();
        }

        if (usageSnooper != null && usageSnooper.isSnooperRunning())
        {
            usageSnooper.stopSnooper();
        }
    }

    public String getHostname()
    {
        return hostname;
    }

    public void getHostName(String par1Str)
    {
        hostname = par1Str;
    }

    public boolean isServerRunning()
    {
        return serverShouldContinueRunning;
    }

    /**
     * sets serverRunning to false
     */
    public void setServerStopping()
    {
        serverShouldContinueRunning = false;
    }

    public void run()
    {
        try
        {
            if (startServer())
            {
                long l = System.currentTimeMillis();
                long l1 = 0L;

                while (serverShouldContinueRunning)
                {
                    long l2 = System.currentTimeMillis();
                    long l3 = l2 - l;

                    if (l3 > 2000L && l - timeOfLastWarning >= 15000L)
                    {
                        logger.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        l3 = 2000L;
                        timeOfLastWarning = l;
                    }

                    if (l3 < 0L)
                    {
                        logger.warning("Time ran backwards! Did the system time change?");
                        l3 = 0L;
                    }

                    l1 += l3;
                    l = l2;

                    if (dimensionServerList[0].areAllPlayersAsleep())
                    {
                        tick();
                        l1 = 0L;
                    }
                    else
                    {
                        while (l1 > 50L)
                        {
                            l1 -= 50L;
                            tick();
                        }
                    }

                    Thread.sleep(1L);
                    serverIsRunning = true;
                }
            }
            else
            {
                finalTick(null);
            }
        }
        catch (Throwable throwable1)
        {
            throwable1.printStackTrace();
            logger.log(Level.SEVERE, (new StringBuilder()).append("Encountered an unexpected exception ").append(throwable1.getClass().getSimpleName()).toString(), throwable1);
            CrashReport crashreport = null;

            if (throwable1 instanceof ReportedException)
            {
                crashreport = addServerInfoToCrashReport(((ReportedException)throwable1).func_71575_a());
            }
            else
            {
                crashreport = addServerInfoToCrashReport(new CrashReport("Exception in server tick loop", throwable1));
            }

            File file = new File(new File(getDataDirectory(), "crash-reports"), (new StringBuilder()).append("crash-").append((new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date())).append("-server.txt").toString());

            if (crashreport.saveToFile(file))
            {
                logger.severe((new StringBuilder()).append("This crash report has been saved to: ").append(file.getAbsolutePath()).toString());
            }
            else
            {
                logger.severe("We were unable to save this crash report to disk.");
            }

            finalTick(crashreport);
        }
        finally
        {
            try
            {
                stopServer();
                serverStopped = true;
            }
            catch (Throwable throwable2)
            {
                throwable2.printStackTrace();
            }
            finally
            {
                systemExitNow();
            }
        }
    }

    protected File getDataDirectory()
    {
        return new File(".");
    }

    /**
     * called on exit from the main run loop
     */
    protected void finalTick(CrashReport crashreport)
    {
    }

    /**
     * directly calls system.exit, instantly killing the program
     */
    protected void systemExitNow()
    {
    }

    /**
     * main function called by run() every loop
     */
    public void tick()
    {
        long l = System.nanoTime();
        AxisAlignedBB.getAABBPool().cleanPool();
        Vec3.getVec3Pool().clear();
        tickCounter++;

        if (startProfiling)
        {
            startProfiling = false;
            theProfiler.profilingEnabled = true;
            theProfiler.clearProfiling();
        }

        theProfiler.startSection("root");
        updateTimeLightAndEntities();

        if (tickCounter % 900 == 0)
        {
            theProfiler.startSection("save");
            serverConfigManager.saveAllPlayerData();
            saveAllDimensions(true);
            theProfiler.endSection();
        }

        theProfiler.startSection("tallying");
        tickTimeArray[tickCounter % 100] = System.nanoTime() - l;
        sentPacketCountArray[tickCounter % 100] = Packet.sentID - lastSentPacketID;
        lastSentPacketID = Packet.sentID;
        sentPacketSizeArray[tickCounter % 100] = Packet.sentSize - lastSentPacketSize;
        lastSentPacketSize = Packet.sentSize;
        recievedPacketCountArray[tickCounter % 100] = Packet.recievedID - lastRecievedID;
        lastRecievedID = Packet.recievedID;
        recievedPacketSizeArray[tickCounter % 100] = Packet.recievedSize - lastRecievedSize;
        lastRecievedSize = Packet.recievedSize;
        theProfiler.endSection();
        theProfiler.startSection("snooper");

        if (!usageSnooper.isSnooperRunning() && tickCounter > 100)
        {
            usageSnooper.startSnooper();
        }

        if (tickCounter % 6000 == 0)
        {
            usageSnooper.addMemoryStatsToSnooper();
        }

        theProfiler.endSection();
        theProfiler.endSection();
    }

    public void updateTimeLightAndEntities()
    {
        theProfiler.startSection("levels");

        for (int i = 0; i < dimensionServerList.length; i++)
        {
            long l = System.nanoTime();

            if (i == 0 || getAllowNether())
            {
                WorldServer worldserver = dimensionServerList[i];
                theProfiler.startSection(worldserver.getWorldInfo().getWorldName());

                if (tickCounter % 20 == 0)
                {
                    theProfiler.startSection("timeSync");
                    serverConfigManager.sendPacketToAllPlayersInDimension(new Packet4UpdateTime(worldserver.getWorldTime()), worldserver.provider.worldType);
                    theProfiler.endSection();
                }

                theProfiler.startSection("tick");
                worldserver.tick();
                theProfiler.endStartSection("lights");

                while (worldserver.updatingLighting()) ;

                theProfiler.endSection();

                if (!worldserver.playerEntities.isEmpty())
                {
                    worldserver.updateEntities();
                }

                theProfiler.startSection("tracker");
                worldserver.getEntityTracker().processOutstandingEntries();
                theProfiler.endSection();
                theProfiler.endSection();
            }

            timeOfLastDimenstionTick[i][tickCounter % 100] = System.nanoTime() - l;
        }

        theProfiler.endStartSection("connection");
        getNetworkThread().networkTick();
        theProfiler.endStartSection("players");
        serverConfigManager.sendPlayerInfoToAllPlayers();
        theProfiler.endStartSection("tickables");
        IUpdatePlayerListBox iupdateplayerlistbox;

        for (Iterator iterator = playersOnline.iterator(); iterator.hasNext(); iupdateplayerlistbox.func_73660_a())
        {
            iupdateplayerlistbox = (IUpdatePlayerListBox)iterator.next();
        }

        theProfiler.endSection();
    }

    public boolean getAllowNether()
    {
        return true;
    }

    public void startServerThread()
    {
        (new ThreadServerApplication(this, "Server thread")).start();
    }

    /**
     * Returns a File object from the specified string.
     */
    public File getFile(String par1Str)
    {
        return new File(getDataDirectory(), par1Str);
    }

    public void logInfoMessage(String par1Str)
    {
        logger.info(par1Str);
    }

    public void logWarningMessage(String par1Str)
    {
        logger.warning(par1Str);
    }

    public WorldServer worldServerForDimension(int par1)
    {
        if (par1 == -1)
        {
            return dimensionServerList[1];
        }

        if (par1 == 1)
        {
            return dimensionServerList[2];
        }
        else
        {
            return dimensionServerList[0];
        }
    }

    public String getHostName()
    {
        return hostname;
    }

    /**
     * never used. Can not be called "getServerPort" is already taken
     */
    public int getMyServerPort()
    {
        return serverPort;
    }

    /**
     * minecraftServer.getMOTD is used in 2 places instead (it is a non-virtual function which returns the same thing)
     */
    public String getServerMOTD()
    {
        return motd;
    }

    public String getMinecraftVersion()
    {
        return "1.3.1";
    }

    public int getPlayerListSize()
    {
        return serverConfigManager.getPlayerListSize();
    }

    public int getMaxPlayers()
    {
        return serverConfigManager.getMaxPlayers();
    }

    public String[] getAllUsernames()
    {
        return serverConfigManager.getAllUsernames();
    }

    /**
     * rename this when a patch comes out which uses it
     */
    public String returnAnEmptyString()
    {
        return "";
    }

    public String executeCommand(String par1Str)
    {
        RConConsoleSource.consoleBuffer.clearChatBuffer();
        commandManager.executeCommand(RConConsoleSource.consoleBuffer, par1Str);
        return RConConsoleSource.consoleBuffer.getChatBuffer();
    }

    public boolean doLogInfoEvent()
    {
        return false;
    }

    public void logSevereEvent(String par1Str)
    {
        logger.log(Level.SEVERE, par1Str);
    }

    public void logInfoEvent(String par1Str)
    {
        if (doLogInfoEvent())
        {
            logger.log(Level.INFO, par1Str);
        }
    }

    public String getServerModName()
    {
        return "vanilla";
    }

    /**
     * iterates the worldServers and adds their info also
     */
    public CrashReport addServerInfoToCrashReport(CrashReport par1CrashReport)
    {
        par1CrashReport.addCrashSectionCallable("Is Modded", new CallableIsServerModded(this));
        par1CrashReport.addCrashSectionCallable("Profiler Position", new CallableServerProfiler(this));

        if (serverConfigManager != null)
        {
            par1CrashReport.addCrashSectionCallable("Player Count", new CallablePlayers(this));
        }

        if (dimensionServerList != null)
        {
            WorldServer aworldserver[] = dimensionServerList;
            int i = aworldserver.length;

            for (int j = 0; j < i; j++)
            {
                WorldServer worldserver = aworldserver[j];

                if (worldserver != null)
                {
                    worldserver.addWorldInfoToCrashReport(par1CrashReport);
                }
            }
        }

        return par1CrashReport;
    }

    /**
     * if par2 begins with / then it searches for commands, otherwise it returns users
     */
    public List getPossibleCompletions(ICommandSender par1ICommandSender, String par2Str)
    {
        ArrayList arraylist = new ArrayList();

        if (par2Str.startsWith("/"))
        {
            par2Str = par2Str.substring(1);
            boolean flag = !par2Str.contains(" ");
            List list = commandManager.getPossibleCommands(par1ICommandSender, par2Str);

            if (list != null)
            {
                for (Iterator iterator = list.iterator(); iterator.hasNext();)
                {
                    String s1 = (String)iterator.next();

                    if (flag)
                    {
                        arraylist.add((new StringBuilder()).append("/").append(s1).toString());
                    }
                    else
                    {
                        arraylist.add(s1);
                    }
                }
            }

            return arraylist;
        }

        String as[] = par2Str.split(" ", -1);
        String s = as[as.length - 1];
        String as1[] = serverConfigManager.getAllUsernames();
        int i = as1.length;

        for (int j = 0; j < i; j++)
        {
            String s2 = as1[j];

            if (CommandBase.doesStringStartWith(s, s2))
            {
                arraylist.add(s2);
            }
        }

        return arraylist;
    }

    /**
     * Gets mcServer.
     */
    public static MinecraftServer getServer()
    {
        return mcServer;
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return "Server";
    }

    public void sendChatToPlayer(String par1Str)
    {
        logger.info(StringUtils.stripControlCodes(par1Str));
    }

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    public boolean canCommandSenderUseCommand(String par1Str)
    {
        return true;
    }

    /**
     * Translates and formats the given string key with the given arguments.
     */
    public String translateString(String par1Str, Object par2ArrayOfObj[])
    {
        return StringTranslate.getInstance().translateKeyFormat(par1Str, par2ArrayOfObj);
    }

    public ICommandManager getCommandManager()
    {
        return commandManager;
    }

    /**
     * Gets KeyPair instanced in MinecraftServer.
     */
    public KeyPair getKeyPair()
    {
        return serverKeyPair;
    }

    /**
     * Gets serverPort.
     */
    public int getServerPort()
    {
        return serverPort;
    }

    public void setServerPort(int par1)
    {
        serverPort = par1;
    }

    /**
     * Returns the username of the server owner (for integrated servers)
     */
    public String getServerOwner()
    {
        return serverOwner;
    }

    /**
     * Sets the username of the owner of this server (in the case of an integrated server)
     */
    public void setServerOwner(String par1Str)
    {
        serverOwner = par1Str;
    }

    public boolean isSinglePlayer()
    {
        return serverOwner != null;
    }

    public String getFolderName()
    {
        return folderName;
    }

    public void setFolderName(String par1Str)
    {
        folderName = par1Str;
    }

    public void setWorldName(String par1Str)
    {
        worldName = par1Str;
    }

    public String getWorldName()
    {
        return worldName;
    }

    public void setKeyPair(KeyPair par1KeyPair)
    {
        serverKeyPair = par1KeyPair;
    }

    public void setDifficultyForAllDimensions(int par1)
    {
        for (int i = 0; i < dimensionServerList.length; i++)
        {
            WorldServer worldserver = dimensionServerList[i];

            if (worldserver == null)
            {
                continue;
            }

            if (worldserver.getWorldInfo().isHardcoreModeEnabled())
            {
                worldserver.difficultySetting = 3;
                worldserver.setAllowedSpawnTypes(true, true);
                continue;
            }

            if (isSinglePlayer())
            {
                worldserver.difficultySetting = par1;
                worldserver.setAllowedSpawnTypes(((World)(worldserver)).difficultySetting > 0, true);
            }
            else
            {
                worldserver.difficultySetting = par1;
                worldserver.setAllowedSpawnTypes(allowSpawnMonsters(), canAnimalsSpawn);
            }
        }
    }

    protected boolean allowSpawnMonsters()
    {
        return true;
    }

    /**
     * Gets whether this is a demo or not.
     */
    public boolean isDemo()
    {
        return isDemo;
    }

    /**
     * Sets whether this is a demo or not.
     */
    public void setDemo(boolean par1)
    {
        isDemo = par1;
    }

    public void canCreateBonusChest(boolean par1)
    {
        enableBonusChest = par1;
    }

    public ISaveFormat getActiveAnvilConverter()
    {
        return anvilConverterForAnvilFile;
    }

    /**
     * WARNING : directly calls
     * getActiveAnvilConverter().deleteWorldDirectory(dimensionServerList[0].getSaveHandler().getSaveDirectoryName());
     */
    public void deleteWorldAndStopServer()
    {
        worldIsBeingDeleted = true;
        getActiveAnvilConverter().flushCache();

        for (int i = 0; i < dimensionServerList.length; i++)
        {
            WorldServer worldserver = dimensionServerList[i];

            if (worldserver != null)
            {
                worldserver.flush();
            }
        }

        getActiveAnvilConverter().deleteWorldDirectory(dimensionServerList[0].getSaveHandler().getSaveDirectoryName());
        setServerStopping();
    }

    public String getTexturePack()
    {
        return texturePack;
    }

    public void setTexturePack(String par1Str)
    {
        texturePack = par1Str;
    }

    public void addServerStatsToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("whitelist_enabled", Boolean.valueOf(false));
        par1PlayerUsageSnooper.addData("whitelist_count", Integer.valueOf(0));
        par1PlayerUsageSnooper.addData("players_current", Integer.valueOf(getPlayerListSize()));
        par1PlayerUsageSnooper.addData("players_max", Integer.valueOf(getMaxPlayers()));
        par1PlayerUsageSnooper.addData("players_seen", Integer.valueOf(serverConfigManager.getAvailablePlayerDat().length));
        par1PlayerUsageSnooper.addData("uses_auth", Boolean.valueOf(onlineMode));
        par1PlayerUsageSnooper.addData("gui_state", getGuiEnabled() ? "enabled" : "disabled");
        par1PlayerUsageSnooper.addData("avg_tick_ms", Integer.valueOf((int)(MathHelper.average(tickTimeArray) * 9.9999999999999995E-007D)));
        par1PlayerUsageSnooper.addData("avg_sent_packet_count", Integer.valueOf((int)MathHelper.average(sentPacketCountArray)));
        par1PlayerUsageSnooper.addData("avg_sent_packet_size", Integer.valueOf((int)MathHelper.average(sentPacketSizeArray)));
        par1PlayerUsageSnooper.addData("avg_rec_packet_count", Integer.valueOf((int)MathHelper.average(recievedPacketCountArray)));
        par1PlayerUsageSnooper.addData("avg_rec_packet_size", Integer.valueOf((int)MathHelper.average(recievedPacketSizeArray)));
        int i = 0;

        for (int j = 0; j < dimensionServerList.length; j++)
        {
            if (dimensionServerList[j] != null)
            {
                WorldServer worldserver = dimensionServerList[j];
                WorldInfo worldinfo = worldserver.getWorldInfo();
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][dimension]").toString(), Integer.valueOf(worldserver.provider.worldType));
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][mode]").toString(), worldinfo.getGameType());
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][difficulty]").toString(), Integer.valueOf(worldserver.difficultySetting));
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][hardcore]").toString(), Boolean.valueOf(worldinfo.isHardcoreModeEnabled()));
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][generator_name]").toString(), worldinfo.getTerrainType().getWorldTypeName());
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][generator_version]").toString(), Integer.valueOf(worldinfo.getTerrainType().getGeneratorVersion()));
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][height]").toString(), Integer.valueOf(buildLimit));
                par1PlayerUsageSnooper.addData((new StringBuilder()).append("world[").append(i).append("][chunks_loaded]").toString(), Integer.valueOf(worldserver.getChunkProvider().getLoadedChunkCount()));
                i++;
            }
        }

        par1PlayerUsageSnooper.addData("worlds", Integer.valueOf(i));
    }

    public void addServerTypeToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("singleplayer", Boolean.valueOf(isSinglePlayer()));
        par1PlayerUsageSnooper.addData("server_brand", getServerModName());
        par1PlayerUsageSnooper.addData("gui_supported", java.awt.GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        par1PlayerUsageSnooper.addData("dedicated", Boolean.valueOf(isDedicatedServer()));
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return true;
    }

    /**
     * this is checked to be 16 on reception of the packet, and the packet is ignored otherwise
     */
    public int textureFlag()
    {
        return 16;
    }

    public abstract boolean isDedicatedServer();

    public boolean isServerInOnlineMode()
    {
        return onlineMode;
    }

    public void setOnlineMode(boolean par1)
    {
        onlineMode = par1;
    }

    public boolean getCanSpawnAnimals()
    {
        return canAnimalsSpawn;
    }

    public void setSpawnAnimals(boolean par1)
    {
        canAnimalsSpawn = par1;
    }

    public boolean getCanNPCsSpawn()
    {
        return canNPCsSpawn;
    }

    public void setSpawnNpcs(boolean par1)
    {
        canNPCsSpawn = par1;
    }

    public boolean isPVPEnabled()
    {
        return pvpEnabled;
    }

    public void setAllowPvp(boolean par1)
    {
        pvpEnabled = par1;
    }

    public boolean isFlightAllowed()
    {
        return allowFlight;
    }

    public void setAllowFlight(boolean par1)
    {
        allowFlight = par1;
    }

    public String getMOTD()
    {
        return motd;
    }

    public void setMOTD(String par1Str)
    {
        motd = par1Str;
    }

    public int getBuildLimit()
    {
        return buildLimit;
    }

    public void setBuildLimit(int par1)
    {
        buildLimit = par1;
    }

    public boolean isServerStopped()
    {
        return serverStopped;
    }

    public ServerConfigurationManager getConfigurationManager()
    {
        return serverConfigManager;
    }

    public void setServerConfigManager(ServerConfigurationManager par1ServerConfigurationManager)
    {
        serverConfigManager = par1ServerConfigurationManager;
    }

    /**
     * sets the game type for all dimensions
     */
    public void setGameType(EnumGameType par1EnumGameType)
    {
        for (int i = 0; i < dimensionServerList.length; i++)
        {
            getServer().dimensionServerList[i].getWorldInfo().setGameType(par1EnumGameType);
        }
    }

    public abstract NetworkListenThread getNetworkThread();

    public boolean serverIsInRunLoop()
    {
        return serverIsRunning;
    }

    public boolean getGuiEnabled()
    {
        return false;
    }

    /**
     * does nothing on dedicated. on integrated, sets commandsAllowedForAll and gameType and allows external connections
     */
    public abstract String shareToLAN(EnumGameType enumgametype, boolean flag);

    public int getTickCounter()
    {
        return tickCounter;
    }

    public void enableProfiling()
    {
        startProfiling = true;
    }

    public static ServerConfigurationManager func_71196_a(MinecraftServer par0MinecraftServer)
    {
        return par0MinecraftServer.serverConfigManager;
    }
}
