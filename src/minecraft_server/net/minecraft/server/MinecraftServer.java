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
import net.minecraft.src.DedicatedServer;
import net.minecraft.src.DemoWorldServer;
import net.minecraft.src.EntityTracker;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.ICommandManager;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.IPlayerUsage;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.IUpdatePlayerListBox;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.ModLoader;
import net.minecraft.src.NetworkListenThread;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.PlayerUsageSnooper;
import net.minecraft.src.Profiler;
import net.minecraft.src.RConConsoleSource;
import net.minecraft.src.ReportedException;
import net.minecraft.src.ServerCommandManager;
import net.minecraft.src.ServerConfigurationManager;
import net.minecraft.src.StatList;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.StringUtils;
import net.minecraft.src.ThreadDedicatedServer;
import net.minecraft.src.ThreadServerApplication;
import net.minecraft.src.Vec3;
import net.minecraft.src.Vec3Pool;
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
    private final ISaveFormat field_71310_m;

    /** The PlayerUsageSnooper instance. */
    private final PlayerUsageSnooper usageSnooper = new PlayerUsageSnooper("server", this);
    private final File field_71308_o;

    /** List of names of players who are online. */
    private final List playersOnline = new ArrayList();
    private final ICommandManager field_71321_q;
    public final Profiler field_71304_b = new Profiler();

    /** The server's hostname */
    private String hostname;

    /** The server's port */
    private int serverPort;
    public WorldServer worldMngr[];

    /** The ServerConfigurationManager instance. */
    public ServerConfigurationManager serverConfigManager;

    /**
     * Indicates whether the server is running or not. Set to false to initiate a shutdown.
     */
    private boolean serverRunning;

    /** Indicates to other classes that the server is safely stopped. */
    private boolean serverStopped;
    private int deathTime;

    /**
     * the task the server is currently working on(and will output on ouputPercentRemaining)
     */
    public String currentTask;

    /** the percentage of the current task finished so far */
    public int percentDone;

    /** True if the server is in online mode. */
    private boolean onlineMode;

    /** True if server has animals turned on */
    private boolean spawnPeacefulMobs;
    private boolean field_71323_z;

    /** Indicates whether PvP is active on the server or not. */
    private boolean pvpEnabled;

    /** Determines if flight is Allowed or not */
    private boolean allowFlight;

    /** The server MOTD string. */
    private String motd;

    /** Maximum build height */
    private int buildLimit;
    private long field_71281_E;
    private long field_71282_F;
    private long field_71283_G;
    private long field_71291_H;
    public final long field_71300_f[] = new long[100];
    public final long field_71301_g[] = new long[100];
    public final long field_71313_h[] = new long[100];
    public final long field_71314_i[] = new long[100];
    public final long field_71311_j[] = new long[100];
    public long field_71312_k[][];
    private KeyPair field_71292_I;

    /** Username of the server owner (for integrated servers) */
    private String serverOwner;
    private String field_71294_K;
    private boolean field_71288_M;
    private boolean field_71289_N;
    private boolean field_71290_O;
    private String field_71297_P;
    private boolean field_71296_Q;
    private long field_71299_R;
    private String field_71298_S;
    private boolean field_71295_T;

    public MinecraftServer(File par1File)
    {
        serverPort = -1;
        serverRunning = true;
        serverStopped = false;
        deathTime = 0;
        field_71297_P = "";
        field_71296_Q = false;
        mcServer = this;
        field_71308_o = par1File;
        field_71321_q = new ServerCommandManager();
        field_71310_m = new AnvilSaveConverter(par1File);
    }

    /**
     * Initialises the server and starts it.
     */
    protected abstract boolean startServer() throws IOException;

    protected void func_71237_c(String par1Str)
    {
        if (func_71254_M().isOldMapFormat(par1Str))
        {
            logger.info("Converting map!");
            func_71192_d("menu.convertingLevel");
            func_71254_M().convertMapFormat(par1Str, new ConvertProgressUpdater(this));
        }

        ModLoader.initialize(this);
        ModLoader.registerCommands(this);
    }

    protected synchronized void func_71192_d(String par1Str)
    {
        field_71298_S = par1Str;
    }

    protected void func_71247_a(String par1Str, String par2Str, long par3, WorldType par5WorldType)
    {
        func_71237_c(par1Str);
        func_71192_d("menu.loadingLevel");
        worldMngr = new WorldServer[3];
        field_71312_k = new long[worldMngr.length][100];
        ISaveHandler isavehandler = field_71310_m.getSaveLoader(par1Str, true);
        WorldInfo worldinfo = isavehandler.loadWorldInfo();
        WorldSettings worldsettings;

        if (worldinfo == null)
        {
            worldsettings = new WorldSettings(par3, func_71265_f(), func_71225_e(), func_71199_h(), par5WorldType);
        }
        else
        {
            worldsettings = new WorldSettings(worldinfo);
        }

        if (field_71289_N)
        {
            worldsettings.enableBonusChest();
        }

        for (int i = 0; i < worldMngr.length; i++)
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
                if (func_71242_L())
                {
                    worldMngr[i] = new DemoWorldServer(this, isavehandler, par2Str, byte0, field_71304_b);
                }
                else
                {
                    worldMngr[i] = new WorldServer(this, isavehandler, par2Str, byte0, worldsettings, field_71304_b);
                }
            }
            else
            {
                worldMngr[i] = new WorldServerMulti(this, isavehandler, par2Str, byte0, worldsettings, worldMngr[0], field_71304_b);
            }

            worldMngr[i].addWorldAccess(new WorldManager(this, worldMngr[i]));

            if (!func_71264_H())
            {
                worldMngr[i].getWorldInfo().setGameType(func_71265_f());
            }

            serverConfigManager.setPlayerManager(worldMngr);
        }

        func_71226_c(func_71232_g());
        func_71222_d();
    }

    protected void func_71222_d()
    {
        char c = '\304';
        long l = System.currentTimeMillis();
        func_71192_d("menu.generatingTerrain");

        for (int i = 0; i < 1; i++)
        {
            logger.info((new StringBuilder()).append("Preparing start region for level ").append(i).toString());
            WorldServer worldserver = worldMngr[i];
            ChunkCoordinates chunkcoordinates = worldserver.getSpawnPoint();

            for (int j = -c; j <= c && func_71278_l(); j += 16)
            {
                for (int k = -c; k <= c && func_71278_l(); k += 16)
                {
                    long l1 = System.currentTimeMillis();

                    if (l1 < l)
                    {
                        l = l1;
                    }

                    if (l1 > l + 1000L)
                    {
                        int i1 = (c * 2 + 1) * (c * 2 + 1);
                        int j1 = (j + c) * (c * 2 + 1) + k + 1;
                        outputPercentRemaining("Preparing spawn area", (j1 * 100) / i1);
                        l = l1;
                    }

                    worldserver.theChunkProviderServer.loadChunk(chunkcoordinates.posX + j >> 4, chunkcoordinates.posZ + k >> 4);

                    while (worldserver.updatingLighting() && func_71278_l()) ;
                }
            }
        }

        clearCurrentTask();
    }

    public abstract boolean func_71225_e();

    public abstract EnumGameType func_71265_f();

    public abstract int func_71232_g();

    public abstract boolean func_71199_h();

    /**
     * used to display a percent remaining given text and the percentage
     */
    protected void outputPercentRemaining(String par1Str, int par2)
    {
        currentTask = par1Str;
        percentDone = par2;
        logger.info((new StringBuilder()).append(par1Str).append(": ").append(par2).append("%").toString());
    }

    /**
     * set current task to null and set its percentage to 0
     */
    protected void clearCurrentTask()
    {
        currentTask = null;
        percentDone = 0;
    }

    protected void func_71267_a(boolean par1)
    {
        if (!field_71290_O)
        {
            WorldServer aworldserver[] = worldMngr;
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
                    logger.info((new StringBuilder()).append("Saving chunks for level '").append(worldserver.getWorldInfo().func_76065_j()).append("'/").append(worldserver.provider).toString());
                }

                try
                {
                    worldserver.saveAllChunks(true, (IProgressUpdate)null);
                }
                catch (MinecraftException minecraftexception)
                {
                    logger.warning(minecraftexception.getMessage());
                }
            }
        }
    }

    /**
     * Saves all necessary data as preparation for stopping the server.
     */
    public void stopServer()
    {
        if (!field_71290_O)
        {
            logger.info("Stopping server");

            if (func_71212_ac() != null)
            {
                func_71212_ac().stopListening();
            }

            if (serverConfigManager != null)
            {
                logger.info("Saving players");
                serverConfigManager.savePlayerStates();
                serverConfigManager.func_72392_r();
            }

            logger.info("Saving worlds");
            func_71267_a(false);
            WorldServer aworldserver[] = worldMngr;
            int i = aworldserver.length;

            for (int j = 0; j < i; j++)
            {
                WorldServer worldserver = aworldserver[j];
                worldserver.flush();
            }

            if (usageSnooper != null && usageSnooper.func_76468_d())
            {
                usageSnooper.func_76470_e();
            }
        }
    }

    public String func_71211_k()
    {
        return hostname;
    }

    public void func_71189_e(String par1Str)
    {
        hostname = par1Str;
    }

    public boolean func_71278_l()
    {
        return serverRunning;
    }

    /**
     * Sets the serverRunning variable to false, in order to get the server to shut down.
     */
    public void initiateShutdown()
    {
        serverRunning = false;
    }

    public void run()
    {
        try
        {
            if (startServer())
            {
                long l = System.currentTimeMillis();
                long l1 = 0L;

                while (serverRunning)
                {
                    ModLoader.onTick(this);
                    long l2 = System.currentTimeMillis();
                    long l3 = l2 - l;

                    if (l3 > 2000L && l - field_71299_R >= 15000L)
                    {
                        logger.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        l3 = 2000L;
                        field_71299_R = l;
                    }

                    if (l3 < 0L)
                    {
                        logger.warning("Time ran backwards! Did the system time change?");
                        l3 = 0L;
                    }

                    l1 += l3;
                    l = l2;

                    if (worldMngr[0].func_73056_e())
                    {
                        func_71217_p();
                        l1 = 0L;
                    }
                    else
                    {
                        while (l1 > 50L)
                        {
                            l1 -= 50L;
                            func_71217_p();
                        }
                    }

                    Thread.sleep(1L);
                    field_71296_Q = true;
                }
            }
            else
            {
                func_71228_a((CrashReport)null);
            }
        }
        catch (Throwable throwable1)
        {
            throwable1.printStackTrace();
            logger.log(Level.SEVERE, (new StringBuilder()).append("Encountered an unexpected exception ").append(throwable1.getClass().getSimpleName()).toString(), throwable1);
            CrashReport crashreport = null;

            if (throwable1 instanceof ReportedException)
            {
                crashreport = func_71230_b(((ReportedException)throwable1).func_71575_a());
            }
            else
            {
                crashreport = func_71230_b(new CrashReport("Exception in server tick loop", throwable1));
            }

            File file = new File(new File(func_71238_n(), "crash-reports"), (new StringBuilder()).append("crash-").append((new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date())).append("-server.txt").toString());

            if (crashreport.saveToFile(file))
            {
                logger.severe((new StringBuilder()).append("This crash report has been saved to: ").append(file.getAbsolutePath()).toString());
            }
            else
            {
                logger.severe("We were unable to save this crash report to disk.");
            }

            func_71228_a(crashreport);
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
                func_71240_o();
            }

        }
    }

    protected File func_71238_n()
    {
        return new File(".");
    }

    protected void func_71228_a(CrashReport crashreport)
    {
    }

    protected void func_71240_o()
    {
    }

    public void func_71217_p()
    {
        long l = System.nanoTime();
        AxisAlignedBB.getAABBPool().cleanPool();
        Vec3.func_72437_a().func_72343_a();
        deathTime++;

        if (field_71295_T)
        {
            field_71295_T = false;
            field_71304_b.profilingEnabled = true;
            field_71304_b.func_76317_a();
        }

        field_71304_b.startSection("root");
        func_71190_q();

        if (deathTime % 900 == 0)
        {
            field_71304_b.startSection("save");
            serverConfigManager.savePlayerStates();
            func_71267_a(true);
            field_71304_b.endSection();
        }

        field_71304_b.startSection("tallying");
        field_71311_j[deathTime % 100] = System.nanoTime() - l;
        field_71300_f[deathTime % 100] = Packet.field_73290_p - field_71281_E;
        field_71281_E = Packet.field_73290_p;
        field_71301_g[deathTime % 100] = Packet.field_73289_q - field_71282_F;
        field_71282_F = Packet.field_73289_q;
        field_71313_h[deathTime % 100] = Packet.field_73292_n - field_71283_G;
        field_71283_G = Packet.field_73292_n;
        field_71314_i[deathTime % 100] = Packet.field_73293_o - field_71291_H;
        field_71291_H = Packet.field_73293_o;
        field_71304_b.endSection();
        field_71304_b.startSection("snooper");

        if (!usageSnooper.func_76468_d() && deathTime > 100)
        {
            usageSnooper.func_76463_a();
        }

        if (deathTime % 6000 == 0)
        {
            usageSnooper.func_76471_b();
        }

        field_71304_b.endSection();
        field_71304_b.endSection();
    }

    public void func_71190_q()
    {
        field_71304_b.startSection("levels");

        for (int i = 0; i < worldMngr.length; i++)
        {
            long l = System.nanoTime();

            if (i == 0 || func_71255_r())
            {
                WorldServer worldserver = worldMngr[i];
                field_71304_b.startSection(worldserver.getWorldInfo().func_76065_j());

                if (deathTime % 20 == 0)
                {
                    field_71304_b.startSection("timeSync");
                    serverConfigManager.sendPacketToAllPlayersInDimension(new Packet4UpdateTime(worldserver.getWorldTime()), worldserver.provider.worldType);
                    field_71304_b.endSection();
                }

                field_71304_b.startSection("tick");
                worldserver.tick();
                field_71304_b.endStartSection("lights");

                while (worldserver.updatingLighting()) ;

                field_71304_b.endSection();

                if (!worldserver.playerEntities.isEmpty())
                {
                    worldserver.updateEntities();
                }

                field_71304_b.startSection("tracker");
                worldserver.getEntityTracker().updateTrackedEntities();
                field_71304_b.endSection();
                field_71304_b.endSection();
            }

            field_71312_k[i][deathTime % 100] = System.nanoTime() - l;
        }

        field_71304_b.endStartSection("connection");
        func_71212_ac().handleNetworkListenThread();
        field_71304_b.endStartSection("players");
        serverConfigManager.onTick();
        field_71304_b.endStartSection("tickables");
        IUpdatePlayerListBox iupdateplayerlistbox;

        for (Iterator iterator = playersOnline.iterator(); iterator.hasNext(); iupdateplayerlistbox.update())
        {
            iupdateplayerlistbox = (IUpdatePlayerListBox)iterator.next();
        }

        field_71304_b.endSection();
    }

    public boolean func_71255_r()
    {
        return true;
    }

    /**
     * Adds a player's name to the list of online players.
     */
    public void addToOnlinePlayerList(IUpdatePlayerListBox par1IUpdatePlayerListBox)
    {
        playersOnline.add(par1IUpdatePlayerListBox);
    }

    public static void main(String par0ArrayOfStr[])
    {
        StatList.func_75919_a();

        try
        {
            boolean flag = !java.awt.GraphicsEnvironment.isHeadless();
            String s = null;
            String s1 = ".";
            String s2 = null;
            boolean flag1 = false;
            boolean flag2 = false;
            int i = -1;

            for (int j = 0; j < par0ArrayOfStr.length; j++)
            {
                String s3 = par0ArrayOfStr[j];
                String s4 = j != par0ArrayOfStr.length - 1 ? par0ArrayOfStr[j + 1] : null;
                boolean flag3 = false;

                if (!s3.equals("nogui") && !s3.equals("--nogui"))
                {
                    if (s3.equals("--port") && s4 != null)
                    {
                        flag3 = true;

                        try
                        {
                            i = Integer.parseInt(s4);
                        }
                        catch (NumberFormatException numberformatexception) { }
                    }
                    else if (s3.equals("--singleplayer") && s4 != null)
                    {
                        flag3 = true;
                        s = s4;
                    }
                    else if (s3.equals("--universe") && s4 != null)
                    {
                        flag3 = true;
                        s1 = s4;
                    }
                    else if (s3.equals("--world") && s4 != null)
                    {
                        flag3 = true;
                        s2 = s4;
                    }
                    else if (s3.equals("--demo"))
                    {
                        flag1 = true;
                    }
                    else if (s3.equals("--bonusChest"))
                    {
                        flag2 = true;
                    }
                }
                else
                {
                    flag = false;
                }

                if (flag3)
                {
                    j++;
                }
            }

            DedicatedServer dedicatedserver = new DedicatedServer(new File(s1));

            if (s != null)
            {
                dedicatedserver.setServerOwner(s);
            }

            if (s2 != null)
            {
                dedicatedserver.func_71261_m(s2);
            }

            if (i >= 0)
            {
                dedicatedserver.func_71208_b(i);
            }

            if (flag1)
            {
                dedicatedserver.func_71204_b(true);
            }

            if (flag2)
            {
                dedicatedserver.func_71194_c(true);
            }

            if (flag)
            {
                dedicatedserver.func_79001_aj();
            }

            dedicatedserver.func_71256_s();
            Runtime.getRuntime().addShutdownHook(new ThreadDedicatedServer(dedicatedserver));
        }
        catch (Exception exception)
        {
            logger.log(Level.SEVERE, "Failed to start the minecraft server", exception);
        }
    }

    public void func_71256_s()
    {
        (new ThreadServerApplication(this, "Server thread")).start();
    }

    /**
     * Returns a File object from the specified string.
     */
    public File getFile(String par1Str)
    {
        return new File(func_71238_n(), par1Str);
    }

    /**
     * Logs the message with a level of INFO.
     */
    public void log(String par1Str)
    {
        logger.info(par1Str);
    }

    /**
     * logs the warning same as: logger.warning(String);
     */
    public void logWarning(String par1Str)
    {
        logger.warning(par1Str);
    }

    /**
     * gets the worldServer by the given dimension
     */
    public WorldServer getWorldManager(int par1)
    {
        return par1 != -1 ? par1 != 1 ? worldMngr[0] : worldMngr[2] : worldMngr[1];
    }

    /**
     * Returns the server hostname
     */
    public String getHostname()
    {
        return hostname;
    }

    /**
     * Returns the server port
     */
    public int getPort()
    {
        return serverPort;
    }

    /**
     * Returns the server message of the day
     */
    public String getMotd()
    {
        return motd;
    }

    /**
     * Returns the server version string
     */
    public String getVersion()
    {
        return "1.3.1";
    }

    /**
     * Returns the number of players on the server
     */
    public int playersOnline()
    {
        return serverConfigManager.playersOnline();
    }

    /**
     * Returns the maximum number of players allowed on the server
     */
    public int getMaxPlayers()
    {
        return serverConfigManager.getMaxPlayers();
    }

    /**
     * Returns a list of usernames of all connected players
     */
    public String[] getPlayerNamesAsList()
    {
        return serverConfigManager.getPlayerNamesAsList();
    }

    public String getPlugin()
    {
        return "";
    }

    /**
     * Handle a command received by an RCon instance
     */
    public String handleRConCommand(String par1Str)
    {
        RConConsoleSource.instance.resetLog();
        field_71321_q.func_71556_a(RConConsoleSource.instance, par1Str);
        return RConConsoleSource.instance.getLogContents();
    }

    /**
     * Returns true if debugging is enabled, false otherwise
     */
    public boolean isDebuggingEnabled()
    {
        return false;
    }

    /**
     * Log severe error message
     */
    public void logSevere(String par1Str)
    {
        logger.log(Level.SEVERE, par1Str);
    }

    public void logIn(String par1Str)
    {
        if (isDebuggingEnabled())
        {
            logger.log(Level.INFO, par1Str);
        }
    }

    public String getServerModName()
    {
        return "vanilla";
    }

    public CrashReport func_71230_b(CrashReport par1CrashReport)
    {
        par1CrashReport.addCrashSectionCallable("Is Modded", new CallableIsServerModded(this));
        par1CrashReport.addCrashSectionCallable("Profiler Position", new CallableServerProfiler(this));

        if (serverConfigManager != null)
        {
            par1CrashReport.addCrashSectionCallable("Player Count", new CallablePlayers(this));
        }

        if (worldMngr != null)
        {
            WorldServer aworldserver[] = worldMngr;
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

    public List func_71248_a(ICommandSender par1ICommandSender, String par2Str)
    {
        ArrayList arraylist = new ArrayList();

        if (par2Str.startsWith("/"))
        {
            par2Str = par2Str.substring(1);
            boolean flag = !par2Str.contains(" ");
            List list = field_71321_q.func_71558_b(par1ICommandSender, par2Str);

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
        String as1[] = serverConfigManager.getPlayerNamesAsList();
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

    public void func_70006_a(String par1Str)
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

    public ICommandManager func_71187_D()
    {
        return field_71321_q;
    }

    /**
     * Gets KeyPair instanced in MinecraftServer.
     */
    public KeyPair getKeyPair()
    {
        return field_71292_I;
    }

    /**
     * Gets serverPort.
     */
    public int getServerPort()
    {
        return serverPort;
    }

    public void func_71208_b(int par1)
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

    public boolean func_71264_H()
    {
        return serverOwner != null;
    }

    public String func_71270_I()
    {
        return field_71294_K;
    }

    public void func_71261_m(String par1Str)
    {
        field_71294_K = par1Str;
    }

    public void func_71253_a(KeyPair par1KeyPair)
    {
        field_71292_I = par1KeyPair;
    }

    public void func_71226_c(int par1)
    {
        for (int i = 0; i < worldMngr.length; i++)
        {
            WorldServer worldserver = worldMngr[i];

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

            if (func_71264_H())
            {
                worldserver.difficultySetting = par1;
                worldserver.setAllowedSpawnTypes(worldserver.difficultySetting > 0, true);
            }
            else
            {
                worldserver.difficultySetting = par1;
                worldserver.setAllowedSpawnTypes(func_71193_K(), spawnPeacefulMobs);
            }
        }
    }

    protected boolean func_71193_K()
    {
        return true;
    }

    public boolean func_71242_L()
    {
        return field_71288_M;
    }

    public void func_71204_b(boolean par1)
    {
        field_71288_M = par1;
    }

    public void func_71194_c(boolean par1)
    {
        field_71289_N = par1;
    }

    public ISaveFormat func_71254_M()
    {
        return field_71310_m;
    }

    public void func_71272_O()
    {
        field_71290_O = true;
        func_71254_M().func_75800_d();

        for (int i = 0; i < worldMngr.length; i++)
        {
            WorldServer worldserver = worldMngr[i];

            if (worldserver != null)
            {
                worldserver.flush();
            }
        }

        func_71254_M().func_75802_e(worldMngr[0].getSaveHandler().func_75760_g());
        initiateShutdown();
    }

    public String func_71202_P()
    {
        return field_71297_P;
    }

    public void func_71269_o(String par1Str)
    {
        field_71297_P = par1Str;
    }

    public void func_70000_a(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("whitelist_enabled", Boolean.valueOf(false));
        par1PlayerUsageSnooper.addData("whitelist_count", Integer.valueOf(0));
        par1PlayerUsageSnooper.addData("players_current", Integer.valueOf(playersOnline()));
        par1PlayerUsageSnooper.addData("players_max", Integer.valueOf(getMaxPlayers()));
        par1PlayerUsageSnooper.addData("players_seen", Integer.valueOf(serverConfigManager.func_72373_m().length));
        par1PlayerUsageSnooper.addData("uses_auth", Boolean.valueOf(onlineMode));
        par1PlayerUsageSnooper.addData("gui_state", func_71279_ae() ? "enabled" : "disabled");
        par1PlayerUsageSnooper.addData("avg_tick_ms", Integer.valueOf((int)(MathHelper.func_76127_a(field_71311_j) * 9.9999999999999995E-007D)));
        par1PlayerUsageSnooper.addData("avg_sent_packet_count", Integer.valueOf((int)MathHelper.func_76127_a(field_71300_f)));
        par1PlayerUsageSnooper.addData("avg_sent_packet_size", Integer.valueOf((int)MathHelper.func_76127_a(field_71301_g)));
        par1PlayerUsageSnooper.addData("avg_rec_packet_count", Integer.valueOf((int)MathHelper.func_76127_a(field_71313_h)));
        par1PlayerUsageSnooper.addData("avg_rec_packet_size", Integer.valueOf((int)MathHelper.func_76127_a(field_71314_i)));
        int i = 0;

        for (int j = 0; j < worldMngr.length; j++)
        {
            if (worldMngr[j] != null)
            {
                WorldServer worldserver = worldMngr[j];
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

    public void func_70001_b(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("singleplayer", Boolean.valueOf(func_71264_H()));
        par1PlayerUsageSnooper.addData("server_brand", getServerModName());
        par1PlayerUsageSnooper.addData("gui_supported", java.awt.GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        par1PlayerUsageSnooper.addData("dedicated", Boolean.valueOf(func_71262_S()));
    }

    public boolean func_70002_Q()
    {
        return true;
    }

    public int func_71227_R()
    {
        return 16;
    }

    public abstract boolean func_71262_S();

    public boolean func_71266_T()
    {
        return onlineMode;
    }

    public void func_71229_d(boolean par1)
    {
        onlineMode = par1;
    }

    public boolean func_71268_U()
    {
        return spawnPeacefulMobs;
    }

    public void func_71251_e(boolean par1)
    {
        spawnPeacefulMobs = par1;
    }

    public boolean func_71220_V()
    {
        return field_71323_z;
    }

    public void func_71257_f(boolean par1)
    {
        field_71323_z = par1;
    }

    public boolean func_71219_W()
    {
        return pvpEnabled;
    }

    public void func_71188_g(boolean par1)
    {
        pvpEnabled = par1;
    }

    public boolean func_71231_X()
    {
        return allowFlight;
    }

    public void func_71245_h(boolean par1)
    {
        allowFlight = par1;
    }

    public String func_71273_Y()
    {
        return motd;
    }

    public void func_71205_p(String par1Str)
    {
        motd = par1Str;
    }

    public int func_71207_Z()
    {
        return buildLimit;
    }

    public void func_71191_d(int par1)
    {
        buildLimit = par1;
    }

    public boolean func_71241_aa()
    {
        return serverStopped;
    }

    public ServerConfigurationManager func_71203_ab()
    {
        return serverConfigManager;
    }

    public void func_71210_a(ServerConfigurationManager par1ServerConfigurationManager)
    {
        serverConfigManager = par1ServerConfigurationManager;
    }

    public void func_71235_a(EnumGameType par1EnumGameType)
    {
        for (int i = 0; i < worldMngr.length; i++)
        {
            getServer().worldMngr[i].getWorldInfo().setGameType(par1EnumGameType);
        }
    }

    public abstract NetworkListenThread func_71212_ac();

    public boolean func_71279_ae()
    {
        return false;
    }

    public abstract String func_71206_a(EnumGameType enumgametype, boolean flag);

    public int func_71259_af()
    {
        return deathTime;
    }

    public void func_71223_ag()
    {
        field_71295_T = true;
    }

    public static ServerConfigurationManager func_71196_a(MinecraftServer par0MinecraftServer)
    {
        return par0MinecraftServer.serverConfigManager;
    }
}
