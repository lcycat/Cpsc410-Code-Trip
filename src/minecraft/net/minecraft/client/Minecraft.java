package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import net.minecraft.src.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft implements Runnable, IPlayerUsage
{
    public static byte clientExperience[] = new byte[0xa00000];
    private ServerData currentServerData;

    /**
     * Set to 'this' in Minecraft constructor; used by some settings get methods
     */
    private static Minecraft theMinecraft;
    public PlayerControllerMP playerController;
    private boolean fullscreen;
    private boolean hasCrashed;

    /** Instance of CrashReport. */
    private CrashReport crashReporter;
    public int displayWidth;
    public int displayHeight;
    private Timer timer;

    /** Instance of PlayerUsageSnooper. */
    private PlayerUsageSnooper usageSnooper;
    public WorldClient theWorld;
    public RenderGlobal renderGlobal;
    public EntityClientPlayerMP thePlayer;

    /**
     * The Entity from which the renderer determines the render viewpoint. Currently is always the parent Minecraft
     * class's 'thePlayer' instance. Modification of its location, rotation, or other settings at render time will
     * modify the camera likewise, with the caveat of triggering chunk rebuilds as it moves, making it unsuitable for
     * changing the viewpoint mid-render.
     */
    public EntityLiving renderViewEntity;
    public EffectRenderer effectRenderer;
    public Session session;
    public String minecraftUri;
    public Canvas mcCanvas;

    /** a boolean to hide a Quit button from the main menu */
    public boolean hideQuitButton;
    public volatile boolean isGamePaused;

    /** The RenderEngine instance used by Minecraft */
    public RenderEngine renderEngine;

    /** The font renderer used for displaying and measuring text. */
    public FontRenderer fontRenderer;
    public FontRenderer standardGalacticFontRenderer;

    /** The GuiScreen that's being displayed at the moment. */
    public GuiScreen currentScreen;
    public LoadingScreenRenderer loadingScreen;
    public EntityRenderer entityRenderer;

    /** Reference to the download resources thread. */
    private ThreadDownloadResources downloadResourcesThread;

    /** Mouse left click counter */
    private int leftClickCounter;

    /** Display width */
    private int tempDisplayWidth;

    /** Display height */
    private int tempDisplayHeight;

    /** Instance of IntegratedServer. */
    private IntegratedServer theIntegratedServer;

    /** Gui achievement */
    public GuiAchievement guiAchievement;
    public GuiIngame ingameGUI;

    /** Skip render world */
    public boolean skipRenderWorld;

    /** The ray trace hit that the mouse is over. */
    public MovingObjectPosition objectMouseOver;

    /** The game settings that currently hold effect. */
    public GameSettings gameSettings;
    protected MinecraftApplet mcApplet;
    public SoundManager sndManager;

    /** Mouse helper instance. */
    public MouseHelper mouseHelper;

    /** The TexturePackLister used by this instance of Minecraft... */
    public TexturePackList texturePackList;
    public File mcDataDir;
    private ISaveFormat saveLoader;
    private static int field_71470_ab;

    /**
     * When you place a block, it's set to 6, decremented once per tick, when it's 0, you can place another block.
     */
    private int rightClickDelayTimer;
    private boolean field_71468_ad;

    /** Stat file writer */
    public StatFileWriter statFileWriter;
    private String serverName;
    private int serverPort;
    private TextureWaterFX textureWaterFX;
    private TextureLavaFX textureLavaFX;

    /**
     * Makes sure it doesn't keep taking screenshots when both buttons are down.
     */
    boolean isTakingScreenshot;

    /**
     * Does the actual gameplay have focus. If so then mouse and keys will effect the player instead of menus.
     */
    public boolean inGameHasFocus;
    long systemTime;

    /** Join player counter */
    private int joinPlayerCounter;
    private boolean isDemo;
    private NetworkManager myNetworkManager;
    private boolean integratedServerIsRunning;

    /** The profiler instance */
    public final Profiler mcProfiler = new Profiler();

    /** The working dir (OS specific) for minecraft */
    private static File minecraftDir = null;

    /**
     * Set to true to keep the game loop running. Set to false by shutdown() to allow the game loop to exit cleanly.
     */
    public volatile boolean running;

    /** String that shows the debug information */
    public String debug;

    /** Approximate time (in ms) of last update to debug string */
    long debugUpdateTime;

    /** holds the current fps */
    int fpsCounter;
    long prevFrameTime;

    /** Profiler currently displayed in the debug screen pie chart */
    private String debugProfilerName;
    //


    public Minecraft(Canvas par1Canvas, MinecraftApplet par2MinecraftApplet, int par3, int par4, boolean par5)
    {
        fullscreen = false;
        hasCrashed = false;
        timer = new Timer(20F);
        usageSnooper = new PlayerUsageSnooper("client", this);
        session = null;
        hideQuitButton = false;
        isGamePaused = false;
        currentScreen = null;
        leftClickCounter = 0;
        guiAchievement = new GuiAchievement(this);
        skipRenderWorld = false;
        objectMouseOver = null;
        sndManager = new SoundManager();
        rightClickDelayTimer = 0;
        textureWaterFX = new TextureWaterFX();
        textureLavaFX = new TextureLavaFX();
        isTakingScreenshot = false;
        inGameHasFocus = false;
        systemTime = getSystemTime();
        joinPlayerCounter = 0;
        running = true;
        debug = "";
        debugUpdateTime = getSystemTime();
        fpsCounter = 0;
        prevFrameTime = -1L;
        debugProfilerName = "root";
        StatList.func_75919_a();
        tempDisplayHeight = par4;
        fullscreen = par5;
        mcApplet = par2MinecraftApplet;
        Packet3Chat.maxChatLength = 32767;
        startTimerHackThread();
        mcCanvas = par1Canvas;
        displayWidth = par3;
        displayHeight = par4;
        fullscreen = par5;
        theMinecraft = this;
    }

    private void startTimerHackThread()
    {
        ThreadClientSleep threadclientsleep = new ThreadClientSleep(this, "Timer hack thread");
        threadclientsleep.setDaemon(true);
        threadclientsleep.start();
    }

    public void crashed(CrashReport par1CrashReport)
    {
        hasCrashed = true;
        crashReporter = par1CrashReport;
    }

    /**
     * Wrapper around displayCrashReportInternal
     */
    public void displayCrashReport(CrashReport par1CrashReport)
    {
        hasCrashed = true;
        displayCrashReportInternal(par1CrashReport);
    }

    public abstract void displayCrashReportInternal(CrashReport crashreport);

    public void setServer(String par1Str, int par2)
    {
        serverName = par1Str;
        serverPort = par2;
    }

    /**
     * Starts the game: initializes the canvas, the title, the settings, etcetera.
     */
    public void startGame() throws LWJGLException
    {
        if (mcCanvas != null)
        {
            Graphics g = mcCanvas.getGraphics();

            if (g != null)
            {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, displayWidth, displayHeight);
                g.dispose();
            }

            Display.setParent(mcCanvas);
        }
        else if (fullscreen)
        {
            Display.setFullscreen(true);
            displayWidth = Display.getDisplayMode().getWidth();
            displayHeight = Display.getDisplayMode().getHeight();

            if (displayWidth <= 0)
            {
                displayWidth = 1;
            }

            if (displayHeight <= 0)
            {
                displayHeight = 1;
            }
        }
        else
        {
            Display.setDisplayMode(new DisplayMode(displayWidth, displayHeight));
        }

        Display.setTitle("Minecraft Minecraft 1.3.1");
        System.out.println((new StringBuilder()).append("LWJGL Version: ").append(Sys.getVersion()).toString());

        try
        {
            Display.create((new PixelFormat()).withDepthBits(24));
        }
        catch (LWJGLException lwjglexception)
        {
            lwjglexception.printStackTrace();

            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedexception) { }

            Display.create();
        }

        OpenGlHelper.initializeTextures();
        mcDataDir = getMinecraftDir();
        saveLoader = new AnvilSaveConverter(new File(mcDataDir, "saves"));
        gameSettings = new GameSettings(this, mcDataDir);
        texturePackList = new TexturePackList(mcDataDir, this);
        renderEngine = new RenderEngine(texturePackList, gameSettings);
        loadScreen();
        fontRenderer = new FontRenderer(gameSettings, "/font/default.png", renderEngine, false);
        standardGalacticFontRenderer = new FontRenderer(gameSettings, "/font/alternate.png", renderEngine, false);

        if (gameSettings.language != null)
        {
            StringTranslate.getInstance().setLanguage(gameSettings.language);
            fontRenderer.setUnicodeFlag(StringTranslate.getInstance().isUnicode());
            fontRenderer.setBidiFlag(StringTranslate.isBidirectional(gameSettings.language));
        }

        ColorizerWater.setWaterBiomeColorizer(renderEngine.getTextureContents("/misc/watercolor.png"));
        ColorizerGrass.setGrassBiomeColorizer(renderEngine.getTextureContents("/misc/grasscolor.png"));
        ColorizerFoliage.getFoilageBiomeColorizer(renderEngine.getTextureContents("/misc/foliagecolor.png"));
        entityRenderer = new EntityRenderer(this);
        RenderManager.instance.itemRenderer = new ItemRenderer(this);
        statFileWriter = new StatFileWriter(session, mcDataDir);
        AchievementList.openInventory.setStatStringFormatter(new StatStringFormatKeyInv(this));
        loadScreen();
        Mouse.create();
        mouseHelper = new MouseHelper(mcCanvas);
        checkGLError("Pre startup");
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearDepth(1.0D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        GL11.glCullFace(GL11.GL_BACK);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        checkGLError("Startup");
        sndManager.loadSoundSettings(gameSettings);
        renderEngine.registerTextureFX(textureLavaFX);
        renderEngine.registerTextureFX(textureWaterFX);
        renderEngine.registerTextureFX(new TexturePortalFX());
        renderEngine.registerTextureFX(new TextureCompassFX(this));
        renderEngine.registerTextureFX(new TextureWatchFX(this));
        renderEngine.registerTextureFX(new TextureWaterFlowFX());
        renderEngine.registerTextureFX(new TextureLavaFlowFX());
        renderEngine.registerTextureFX(new TextureFlamesFX(0));
        renderEngine.registerTextureFX(new TextureFlamesFX(1));
        renderGlobal = new RenderGlobal(this, renderEngine);
        GL11.glViewport(0, 0, displayWidth, displayHeight);
        effectRenderer = new EffectRenderer(theWorld, renderEngine);

        try
        {
            downloadResourcesThread = new ThreadDownloadResources(mcDataDir, this);
            downloadResourcesThread.start();
        }
        catch (Exception exception) { }

        checkGLError("Post startup");
        ingameGUI = new GuiIngame(this);

        if (serverName != null)
        {
            displayGuiScreen(new GuiConnecting(this, serverName, serverPort));
        }
        else
        {
            displayGuiScreen(new GuiMainMenu());
        }

        loadingScreen = new LoadingScreenRenderer(this);

        if (gameSettings.fullScreen && !fullscreen)
        {
            toggleFullscreen();
        }

    }

    /**
     * Displays a new screen.
     */
    private void loadScreen() throws LWJGLException
    {
        ScaledResolution scaledresolution = new ScaledResolution(gameSettings, displayWidth, displayHeight);
        GL11.glClear(16640);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
        GL11.glViewport(0, 0, displayWidth, displayHeight);
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_FOG);
        Tessellator tessellator = Tessellator.instance;
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, renderEngine.getTexture("/title/mojang.png"));
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0xffffff);
        tessellator.addVertexWithUV(0.0D, displayHeight, 0.0D, 0.0D, 0.0D);
        tessellator.addVertexWithUV(displayWidth, displayHeight, 0.0D, 0.0D, 0.0D);
        tessellator.addVertexWithUV(displayWidth, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.draw();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.setColorOpaque_I(0xffffff);
        char c = 256;
        char c1 = 256;
        scaledTessellator((scaledresolution.getScaledWidth() - c) / 2, (scaledresolution.getScaledHeight() - c1) / 2, 0, 0, c, c1);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
        Display.swapBuffers();
    }

    /**
     * Loads Tessellator with a scaled resolution
     */
    public void scaledTessellator(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(par1 + 0, par2 + par6, 0.0D, (float)(par3 + 0) * f, (float)(par4 + par6) * f1);
        tessellator.addVertexWithUV(par1 + par5, par2 + par6, 0.0D, (float)(par3 + par5) * f, (float)(par4 + par6) * f1);
        tessellator.addVertexWithUV(par1 + par5, par2 + 0, 0.0D, (float)(par3 + par5) * f, (float)(par4 + 0) * f1);
        tessellator.addVertexWithUV(par1 + 0, par2 + 0, 0.0D, (float)(par3 + 0) * f, (float)(par4 + 0) * f1);
        tessellator.draw();
    }

    /**
     * gets the working dir (OS specific) for minecraft
     */
    public static File getMinecraftDir()
    {
        if (minecraftDir == null)
        {
            minecraftDir = getAppDir("minecraft");
        }

        return minecraftDir;
    }

    /**
     * gets the working dir (OS specific) for the specific application (which is always minecraft)
     */
    public static File getAppDir(String par0Str)
    {
        String s = System.getProperty("user.home", ".");
        File file;

        switch (EnumOSHelper.field_74533_a[getOs().ordinal()])
        {
            case 1:
            case 2:
                file = new File(s, (new StringBuilder()).append('.').append(par0Str).append('/').toString());
                break;

            case 3:
                String s1 = System.getenv("APPDATA");

                if (s1 != null)
                {
                    file = new File(s1, (new StringBuilder()).append(".").append(par0Str).append('/').toString());
                }
                else
                {
                    file = new File(s, (new StringBuilder()).append('.').append(par0Str).append('/').toString());
                }

                break;

            case 4:
                file = new File(s, (new StringBuilder()).append("Library/Application Support/").append(par0Str).toString());
                break;

            default:
                file = new File(s, (new StringBuilder()).append(par0Str).append('/').toString());
                break;
        }

        if (!file.exists() && !file.mkdirs())
        {
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(file).toString());
        }
        else
        {
            return file;
        }
    }

    public static EnumOS getOs()
    {
        String s = System.getProperty("os.name").toLowerCase();

        if (s.contains("win"))
        {
            return EnumOS.WINDOWS;
        }

        if (s.contains("mac"))
        {
            return EnumOS.MACOS;
        }

        if (s.contains("solaris"))
        {
            return EnumOS.SOLARIS;
        }

        if (s.contains("sunos"))
        {
            return EnumOS.SOLARIS;
        }

        if (s.contains("linux"))
        {
            return EnumOS.LINUX;
        }

        if (s.contains("unix"))
        {
            return EnumOS.LINUX;
        }
        else
        {
            return EnumOS.UNKNOWN;
        }
    }

    /**
     * Returns the save loader that is currently being used
     */
    public ISaveFormat getSaveLoader()
    {
        return saveLoader;
    }

    /**
     * Sets the argument GuiScreen as the main (topmost visible) screen.
     */
    public void displayGuiScreen(GuiScreen par1GuiScreen)
    {
        if (currentScreen instanceof GuiErrorScreen)
        {
            return;
        }

        if (currentScreen != null)
        {
            currentScreen.onGuiClosed();
        }

        statFileWriter.syncStats();

        if (par1GuiScreen == null && theWorld == null)
        {
            par1GuiScreen = new GuiMainMenu();
        }
        else if (par1GuiScreen == null && thePlayer.getHealth() <= 0)
        {
            par1GuiScreen = new GuiGameOver();
        }

        if (par1GuiScreen instanceof GuiMainMenu)
        {
            gameSettings.showDebugInfo = false;
            ingameGUI.func_73827_b().func_73761_a();
        }

        currentScreen = par1GuiScreen;

        if (par1GuiScreen != null)
        {
            setIngameNotInFocus();
            ScaledResolution scaledresolution = new ScaledResolution(gameSettings, displayWidth, displayHeight);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            par1GuiScreen.setWorldAndResolution(this, i, j);
            skipRenderWorld = false;
        }
        else
        {
            setIngameFocus();
        }
    }

    /**
     * Checks for an OpenGL error. If there is one, prints the error ID and error string.
     */
    private void checkGLError(String par1Str)
    {
        int i = GL11.glGetError();

        if (i != 0)
        {
            String s = GLU.gluErrorString(i);
            System.out.println("########## GL ERROR ##########");
            System.out.println((new StringBuilder()).append("@ ").append(par1Str).toString());
            System.out.println((new StringBuilder()).append(i).append(": ").append(s).toString());
        }
    }

    /**
     * Shuts down the minecraft applet by stopping the resource downloads, and clearing up GL stuff; called when the
     * application (or web page) is exited.
     */
    public void shutdownMinecraftApplet()
    {
        try
        {
            statFileWriter.syncStats();

            try
            {
                if (downloadResourcesThread != null)
                {
                    downloadResourcesThread.closeMinecraft();
                }
            }
            catch (Exception exception) { }

            System.out.println("Stopping!");

            try
            {
                loadWorld(null);
            }
            catch (Throwable throwable) { }

            try
            {
                GLAllocation.deleteTexturesAndDisplayLists();
            }
            catch (Throwable throwable1) { }

            sndManager.closeMinecraft();
            Mouse.destroy();
            Keyboard.destroy();
        }
        finally
        {
            Display.destroy();

            if (!hasCrashed)
            {
                System.exit(0);
            }
        }

        System.gc();
    }

    public void run()
    {
        running = true;

        try
        {
            startGame();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            displayCrashReport(func_71396_d(new CrashReport("Failed to start game", exception)));
            return;
        }

        try
        {
            while (running)
            {
                if (hasCrashed && crashReporter != null)
                {
                    displayCrashReport(crashReporter);
                    return;
                }

                if (field_71468_ad)
                {
                    field_71468_ad = false;
                    renderEngine.refreshTextures();
                }

                try
                {
                    runGameLoop();
                }
                catch (OutOfMemoryError outofmemoryerror)
                {
                    freeMemory();
                    displayGuiScreen(new GuiMemoryErrorScreen());
                    System.gc();
                }
            }
        }
        catch (MinecraftError minecrafterror) { }
        catch (ReportedException reportedexception)
        {
            func_71396_d(reportedexception.func_71575_a());
            freeMemory();
            reportedexception.printStackTrace();
            displayCrashReport(reportedexception.func_71575_a());
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = func_71396_d(new CrashReport("Unexpected error", throwable));
            freeMemory();
            throwable.printStackTrace();
            displayCrashReport(crashreport);
        }
        finally
        {
            shutdownMinecraftApplet();
        }
    }

    /**
     * Called repeatedly from run()
     */
    private void runGameLoop()
    {
        if (mcApplet != null && !mcApplet.isActive())
        {
            running = false;
            return;
        }

        AxisAlignedBB.getAABBPool().cleanPool();
        Vec3.getVec3Pool().clear();
        mcProfiler.startSection("root");

        if (mcCanvas == null && Display.isCloseRequested())
        {
            shutdown();
        }

        if (isGamePaused && theWorld != null)
        {
            float f = timer.renderPartialTicks;
            timer.updateTimer();
            timer.renderPartialTicks = f;
        }
        else
        {
            timer.updateTimer();
        }

        long l = System.nanoTime();
        mcProfiler.startSection("tick");

        for (int i = 0; i < timer.elapsedTicks; i++)
        {
            runTick();
        }

        mcProfiler.endStartSection("preRenderErrors");
        long l1 = System.nanoTime() - l;
        checkGLError("Pre render");
        RenderBlocks.fancyGrass = gameSettings.fancyGraphics;
        mcProfiler.endStartSection("sound");
        sndManager.setListener(thePlayer, timer.renderPartialTicks);
        mcProfiler.endStartSection("updatelights");

        if (theWorld != null)
        {
            theWorld.updatingLighting();
        }

        mcProfiler.endSection();
        mcProfiler.startSection("render");
        mcProfiler.startSection("display");
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        if (!Keyboard.isKeyDown(65))
        {
            Display.update();
        }

        if (thePlayer != null && thePlayer.isEntityInsideOpaqueBlock())
        {
            gameSettings.thirdPersonView = 0;
        }

        mcProfiler.endSection();

        if (!skipRenderWorld)
        {
            mcProfiler.endStartSection("gameRenderer");
            entityRenderer.updateCameraAndRender(timer.renderPartialTicks);
            mcProfiler.endSection();
        }

        GL11.glFlush();
        mcProfiler.endSection();

        if (!Display.isActive() && fullscreen)
        {
            toggleFullscreen();
        }

        if (gameSettings.showDebugInfo && gameSettings.field_74329_Q)
        {
            if (!mcProfiler.profilingEnabled)
            {
                mcProfiler.clearProfiling();
            }

            mcProfiler.profilingEnabled = true;
            displayDebugInfo(l1);
        }
        else
        {
            mcProfiler.profilingEnabled = false;
            prevFrameTime = System.nanoTime();
        }

        guiAchievement.updateAchievementWindow();
        mcProfiler.startSection("root");
        Thread.yield();

        if (Keyboard.isKeyDown(65))
        {
            Display.update();
        }

        screenshotListener();

        if (mcCanvas != null && !fullscreen && (mcCanvas.getWidth() != displayWidth || mcCanvas.getHeight() != displayHeight))
        {
            displayWidth = mcCanvas.getWidth();
            displayHeight = mcCanvas.getHeight();

            if (displayWidth <= 0)
            {
                displayWidth = 1;
            }

            if (displayHeight <= 0)
            {
                displayHeight = 1;
            }

            resize(displayWidth, displayHeight);
        }

        checkGLError("Post render");
        fpsCounter++;
        boolean flag = isGamePaused;
        isGamePaused = isSingleplayer() && currentScreen != null && currentScreen.doesGuiPauseGame() && !theIntegratedServer.func_71344_c();

        if (isIntegratedServerRunning() && thePlayer != null && thePlayer.sendQueue != null && isGamePaused != flag)
        {
            ((MemoryConnection)thePlayer.sendQueue.getNetManager()).setGamePaused(isGamePaused);
        }

        do
        {
            if (getSystemTime() < debugUpdateTime + 1000L)
            {
                break;
            }

            field_71470_ab = fpsCounter;
            debug = (new StringBuilder()).append(field_71470_ab).append(" fps, ").append(WorldRenderer.chunksUpdated).append(" chunk updates").toString();
            WorldRenderer.chunksUpdated = 0;
            debugUpdateTime += 1000L;
            fpsCounter = 0;
            usageSnooper.addMemoryStatsToSnooper();

            if (!usageSnooper.isSnooperRunning())
            {
                usageSnooper.startSnooper();
            }
        }
        while (true);

        mcProfiler.endSection();

        if (gameSettings.limitFramerate > 0)
        {
            EntityRenderer _tmp = entityRenderer;
            Display.sync(EntityRenderer.func_78465_a(gameSettings.limitFramerate));
        }
    }

    public void freeMemory()
    {
        try
        {
            clientExperience = new byte[0];
            renderGlobal.func_72728_f();
        }
        catch (Throwable throwable) { }

        try
        {
            System.gc();
            AxisAlignedBB.getAABBPool().clearPool();
            Vec3.getVec3Pool().clearAndFreeCache();
        }
        catch (Throwable throwable1) { }

        try
        {
            System.gc();
            loadWorld(null);
        }
        catch (Throwable throwable2) { }

        System.gc();
    }

    /**
     * checks if keys are down
     */
    private void screenshotListener()
    {
        if (Keyboard.isKeyDown(60))
        {
            if (!isTakingScreenshot)
            {
                isTakingScreenshot = true;
                ingameGUI.func_73827_b().func_73765_a(ScreenShotHelper.saveScreenshot(minecraftDir, displayWidth, displayHeight));
            }
        }
        else
        {
            isTakingScreenshot = false;
        }
    }

    /**
     * Update debugProfilerName in response to number keys in debug screen
     */
    private void updateDebugProfilerName(int par1)
    {
        java.util.List list;
        ProfilerResult profilerresult;
        list = mcProfiler.getProfilingData(debugProfilerName);

        if (list == null || list.isEmpty())
        {
            return;
        }

        profilerresult = (ProfilerResult)list.remove(0);

        if (!(par1 != 0))
        {
            if (profilerresult.field_76331_c.length() > 0)
            {
                int i = debugProfilerName.lastIndexOf(".");

                if (i >= 0)
                {
                    debugProfilerName = debugProfilerName.substring(0, i);
                }
            }
        }
        else
        {
            if (!(--par1 >= list.size() || ((ProfilerResult)list.get(par1)).field_76331_c.equals("unspecified")))
            {
                if (!(debugProfilerName.length() <= 0))
                {
                    debugProfilerName += ".";
                }

                debugProfilerName += ((ProfilerResult)list.get(par1)).field_76331_c;
            }
        }
    }

    private void displayDebugInfo(long par1)
    {
        if (!mcProfiler.profilingEnabled)
        {
            return;
        }

        java.util.List list = mcProfiler.getProfilingData(debugProfilerName);
        ProfilerResult profilerresult = (ProfilerResult)list.remove(0);
        GL11.glClear(256);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, displayWidth, displayHeight, 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
        GL11.glLineWidth(1.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        Tessellator tessellator = Tessellator.instance;
        int i = 160;
        int j = displayWidth - i - 10;
        int k = displayHeight - i * 2;
        GL11.glEnable(GL11.GL_BLEND);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 200);
        tessellator.addVertex((float)j - (float)i * 1.1F, (float)k - (float)i * 0.6F - 16F, 0.0D);
        tessellator.addVertex((float)j - (float)i * 1.1F, k + i * 2, 0.0D);
        tessellator.addVertex((float)j + (float)i * 1.1F, k + i * 2, 0.0D);
        tessellator.addVertex((float)j + (float)i * 1.1F, (float)k - (float)i * 0.6F - 16F, 0.0D);
        tessellator.draw();
        GL11.glDisable(GL11.GL_BLEND);
        double d = 0.0D;

        for (int l = 0; l < list.size(); l++)
        {
            ProfilerResult profilerresult1 = (ProfilerResult)list.get(l);
            int j1 = MathHelper.floor_double(profilerresult1.field_76332_a / 4D) + 1;
            tessellator.startDrawing(6);
            tessellator.setColorOpaque_I(profilerresult1.func_76329_a());
            tessellator.addVertex(j, k, 0.0D);

            for (int l1 = j1; l1 >= 0; l1--)
            {
                float f = (float)(((d + (profilerresult1.field_76332_a * (double)l1) / (double)j1) * Math.PI * 2D) / 100D);
                float f2 = MathHelper.sin(f) * (float)i;
                float f4 = MathHelper.cos(f) * (float)i * 0.5F;
                tessellator.addVertex((float)j + f2, (float)k - f4, 0.0D);
            }

            tessellator.draw();
            tessellator.startDrawing(5);
            tessellator.setColorOpaque_I((profilerresult1.func_76329_a() & 0xfefefe) >> 1);

            for (int i2 = j1; i2 >= 0; i2--)
            {
                float f1 = (float)(((d + (profilerresult1.field_76332_a * (double)i2) / (double)j1) * Math.PI * 2D) / 100D);
                float f3 = MathHelper.sin(f1) * (float)i;
                float f5 = MathHelper.cos(f1) * (float)i * 0.5F;
                tessellator.addVertex((float)j + f3, (float)k - f5, 0.0D);
                tessellator.addVertex((float)j + f3, ((float)k - f5) + 10F, 0.0D);
            }

            tessellator.draw();
            d += profilerresult1.field_76332_a;
        }

        DecimalFormat decimalformat = new DecimalFormat("##0.00");
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        String s = "";

        if (!profilerresult.field_76331_c.equals("unspecified"))
        {
            s = (new StringBuilder()).append(s).append("[0] ").toString();
        }

        if (profilerresult.field_76331_c.length() == 0)
        {
            s = (new StringBuilder()).append(s).append("ROOT ").toString();
        }
        else
        {
            s = (new StringBuilder()).append(s).append(profilerresult.field_76331_c).append(" ").toString();
        }

        int k1 = 0xffffff;
        fontRenderer.drawStringWithShadow(s, j - i, k - i / 2 - 16, k1);
        fontRenderer.drawStringWithShadow(s = (new StringBuilder()).append(decimalformat.format(profilerresult.field_76330_b)).append("%").toString(), (j + i) - fontRenderer.getStringWidth(s), k - i / 2 - 16, k1);

        for (int i1 = 0; i1 < list.size(); i1++)
        {
            ProfilerResult profilerresult2 = (ProfilerResult)list.get(i1);
            String s1 = "";

            if (profilerresult2.field_76331_c.equals("unspecified"))
            {
                s1 = (new StringBuilder()).append(s1).append("[?] ").toString();
            }
            else
            {
                s1 = (new StringBuilder()).append(s1).append("[").append(i1 + 1).append("] ").toString();
            }

            s1 = (new StringBuilder()).append(s1).append(profilerresult2.field_76331_c).toString();
            fontRenderer.drawStringWithShadow(s1, j - i, k + i / 2 + i1 * 8 + 20, profilerresult2.func_76329_a());
            fontRenderer.drawStringWithShadow(s1 = (new StringBuilder()).append(decimalformat.format(profilerresult2.field_76332_a)).append("%").toString(), (j + i) - 50 - fontRenderer.getStringWidth(s1), k + i / 2 + i1 * 8 + 20, profilerresult2.func_76329_a());
            fontRenderer.drawStringWithShadow(s1 = (new StringBuilder()).append(decimalformat.format(profilerresult2.field_76330_b)).append("%").toString(), (j + i) - fontRenderer.getStringWidth(s1), k + i / 2 + i1 * 8 + 20, profilerresult2.func_76329_a());
        }
    }

    /**
     * Called when the window is closing. Sets 'running' to false which allows the game loop to exit cleanly.
     */
    public void shutdown()
    {
        running = false;
    }

    /**
     * Will set the focus to ingame if the Minecraft window is the active with focus. Also clears any GUI screen
     * currently displayed
     */
    public void setIngameFocus()
    {
        if (!Display.isActive())
        {
            return;
        }

        if (inGameHasFocus)
        {
            return;
        }
        else
        {
            inGameHasFocus = true;
            mouseHelper.grabMouseCursor();
            displayGuiScreen(null);
            leftClickCounter = 10000;
            return;
        }
    }

    /**
     * Resets the player keystate, disables the ingame focus, and ungrabs the mouse cursor.
     */
    public void setIngameNotInFocus()
    {
        if (!inGameHasFocus)
        {
            return;
        }
        else
        {
            KeyBinding.unPressAllKeys();
            inGameHasFocus = false;
            mouseHelper.ungrabMouseCursor();
            return;
        }
    }

    /**
     * Displays the ingame menu
     */
    public void displayInGameMenu()
    {
        if (currentScreen != null)
        {
            return;
        }
        else
        {
            displayGuiScreen(new GuiIngameMenu());
            return;
        }
    }

    private void sendClickBlockToController(int par1, boolean par2)
    {
        if (!par2)
        {
            leftClickCounter = 0;
        }

        if (par1 == 0 && leftClickCounter > 0)
        {
            return;
        }

        if (par2 && objectMouseOver != null && objectMouseOver.typeOfHit == EnumMovingObjectType.TILE && par1 == 0)
        {
            int i = objectMouseOver.blockX;
            int j = objectMouseOver.blockY;
            int k = objectMouseOver.blockZ;
            playerController.onPlayerDamageBlock(i, j, k, objectMouseOver.sideHit);

            if (thePlayer.canPlayerEdit(i, j, k))
            {
                effectRenderer.addBlockHitEffects(i, j, k, objectMouseOver.sideHit);
                thePlayer.swingItem();
            }
        }
        else
        {
            playerController.resetBlockRemoving();
        }
    }

    /**
     * Called whenever the mouse is clicked. Button clicked is 0 for left clicking and 1 for right clicking. Args:
     * buttonClicked
     */
    private void clickMouse(int par1)
    {
        if (par1 == 0 && leftClickCounter > 0)
        {

            return;
        }

        if (par1 == 0)
        {
            thePlayer.swingItem();
        }

        if (par1 == 1)
        {
            rightClickDelayTimer = 4;
        }

        boolean flag = true;
        ItemStack itemstack = thePlayer.inventory.getCurrentItem();

        if (objectMouseOver == null)
        {
            if (par1 == 0 && playerController.isNotCreative())
            {
                leftClickCounter = 10;
            }
        }
        else if (objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY)
        {
            if (par1 == 0)
            	
            {   
                playerController.attackEntity(thePlayer, objectMouseOver.entityHit);
            }

            if (par1 == 1 && playerController.func_78768_b(thePlayer, objectMouseOver.entityHit))
            {
                flag = false;
            }
        }
        else if (objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
        {
            int i = objectMouseOver.blockX;
            int j = objectMouseOver.blockY;
            int k = objectMouseOver.blockZ;
            int l = objectMouseOver.sideHit;

            if (par1 == 0)
            {
                playerController.clickBlock(i, j, k, objectMouseOver.sideHit);
            }
            else
            {
                int i1 = itemstack == null ? 0 : itemstack.stackSize;

                if (playerController.onPlayerRightClick(thePlayer, theWorld, itemstack, i, j, k, l, objectMouseOver.hitVec))
                {
                    flag = false;
                    thePlayer.swingItem();
                }

                if (itemstack == null)
                {
                    return;
                }

                if (itemstack.stackSize == 0)
                {
                    thePlayer.inventory.mainInventory[thePlayer.inventory.currentItem] = null;
                }
                else if (itemstack.stackSize != i1 || playerController.isInCreativeMode())
                {
                    entityRenderer.itemRenderer.func_78444_b();
                }
            }
        }

        if (flag && par1 == 1)
        {
            ItemStack itemstack1 = thePlayer.inventory.getCurrentItem();

            if (itemstack1 != null && playerController.sendUseItem(thePlayer, theWorld, itemstack1))
            {
                entityRenderer.itemRenderer.func_78445_c();
            }
        }
    }

    /**
     * Toggles fullscreen mode.
     */
    public void toggleFullscreen()
    {
        try
        {
            fullscreen = !fullscreen;

            if (fullscreen)
            {
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                displayWidth = Display.getDisplayMode().getWidth();
                displayHeight = Display.getDisplayMode().getHeight();

                if (displayWidth <= 0)
                {
                    displayWidth = 1;
                }

                if (displayHeight <= 0)
                {
                    displayHeight = 1;
                }
            }
            else
            {
                if (mcCanvas != null)
                {
                    displayWidth = mcCanvas.getWidth();
                    displayHeight = mcCanvas.getHeight();
                }
                else
                {
                    displayWidth = tempDisplayWidth;
                    displayHeight = tempDisplayHeight;
                }

                if (displayWidth <= 0)
                {
                    displayWidth = 1;
                }

                if (displayHeight <= 0)
                {
                    displayHeight = 1;
                }
            }

            if (currentScreen != null)
            {
                resize(displayWidth, displayHeight);
            }

            Display.setFullscreen(fullscreen);
            Display.setVSyncEnabled(gameSettings.enableVsync);
            Display.update();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Called to resize the current screen.
     */
    private void resize(int par1, int par2)
    {
        displayWidth = par1 > 0 ? par1 : 1;
        displayHeight = par2 > 0 ? par2 : 1;

        if (currentScreen != null)
        {
            ScaledResolution scaledresolution = new ScaledResolution(gameSettings, par1, par2);
            int i = scaledresolution.getScaledWidth();
            int j = scaledresolution.getScaledHeight();
            currentScreen.setWorldAndResolution(this, i, j);
        }
    }

    /**
     * Runs the current tick.
     */
    public void runTick()
    {
        if (rightClickDelayTimer > 0)
        {
            rightClickDelayTimer--;
        }

        mcProfiler.startSection("stats");
        statFileWriter.func_77449_e();
        mcProfiler.endStartSection("gui");

        if (!isGamePaused)
        {
            ingameGUI.updateTick();
        }

        mcProfiler.endStartSection("pick");
        entityRenderer.getMouseOver(1.0F);
        mcProfiler.endStartSection("gameMode");

        if (!isGamePaused && theWorld != null)
        {
            playerController.updateController();
        }

        GL11.glBindTexture(GL11.GL_TEXTURE_2D, renderEngine.getTexture("/terrain.png"));
        mcProfiler.endStartSection("textures");

        if (!isGamePaused)
        {
            renderEngine.updateDynamicTextures();
        }

        if (currentScreen == null && thePlayer != null)
        {
            if (thePlayer.getHealth() <= 0)
            {
                displayGuiScreen(null);
            }
            else if (thePlayer.isPlayerSleeping() && theWorld != null)
            {
                displayGuiScreen(new GuiSleepMP());
            }
        }
        else if (currentScreen != null && (currentScreen instanceof GuiSleepMP) && !thePlayer.isPlayerSleeping())
        {
            displayGuiScreen(null);
        }

        if (currentScreen != null)
        {
            leftClickCounter = 10000;
        }

        if (currentScreen != null)
        {
            currentScreen.handleInput();

            if (currentScreen != null)
            {
                currentScreen.guiParticles.update();
                currentScreen.updateScreen();
            }
        }

        if (currentScreen == null || currentScreen.allowUserInput)
        {
            mcProfiler.endStartSection("mouse");

            do
            {
                if (!Mouse.next())
                {
                    break;
                }

                KeyBinding.setKeyBindState(Mouse.getEventButton() - 100, Mouse.getEventButtonState());

                if (Mouse.getEventButtonState())
                {
                    KeyBinding.onTick(Mouse.getEventButton() - 100);
                }

                long l = getSystemTime() - systemTime;

                if (l <= 200L)
                {
                    int k = Mouse.getEventDWheel();

                    if (k != 0)
                    {
                        thePlayer.inventory.changeCurrentItem(k);

                        if (gameSettings.noclip)
                        {
                            if (k > 0)
                            {
                                k = 1;
                            }

                            if (k < 0)
                            {
                                k = -1;
                            }

                            gameSettings.noclipRate += (float)k * 0.25F;
                        }
                    }

                    if (currentScreen == null)
                    {
                        if (!inGameHasFocus && Mouse.getEventButtonState())
                        {
                            setIngameFocus();
                        }
                    }
                    else if (currentScreen != null)
                    {
                        currentScreen.handleMouseInput();
                    }
                }
            }
            while (true);

            if (leftClickCounter > 0)
            {
                leftClickCounter--;
            }

            mcProfiler.endStartSection("keyboard");

            do
            {
                if (!Keyboard.next())
                {
                    break;
                }

                KeyBinding.setKeyBindState(Keyboard.getEventKey(), Keyboard.getEventKeyState());

                if (Keyboard.getEventKeyState())
                {
                    KeyBinding.onTick(Keyboard.getEventKey());
                }

                if (Keyboard.getEventKeyState())
                {
                    if (Keyboard.getEventKey() == 87)
                    {
                        toggleFullscreen();
                    }
                    else
                    {
                        if (currentScreen != null)
                        {
                            currentScreen.handleKeyboardInput();
                        }
                        else
                        {
                            if (Keyboard.getEventKey() == 1)
                            {
                                displayInGameMenu();
                            }

                            if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61))
                            {
                                forceReload();
                            }

                            if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61))
                            {
                                renderEngine.refreshTextures();
                            }

                            if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61))
                            {
                                boolean flag = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                                gameSettings.setOptionValue(EnumOptions.RENDER_DISTANCE, flag ? -1 : 1);
                            }

                            if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61))
                            {
                                renderGlobal.loadRenderers();
                            }

                            if (Keyboard.getEventKey() == 59)
                            {
                                gameSettings.hideGUI = !gameSettings.hideGUI;
                            }

                            if (Keyboard.getEventKey() == 61)
                            {
                                gameSettings.showDebugInfo = !gameSettings.showDebugInfo;
                                gameSettings.field_74329_Q = !GuiScreen.isShiftKeyDown();
                            }

                            if (Keyboard.getEventKey() == 63)
                            {
                                gameSettings.thirdPersonView++;

                                if (gameSettings.thirdPersonView > 2)
                                {
                                    gameSettings.thirdPersonView = 0;
                                }
                            }

                            if (Keyboard.getEventKey() == 66)
                            {
                                gameSettings.smoothCamera = !gameSettings.smoothCamera;
                            }
                        }

                        for (int i = 0; i < 9; i++)
                        {
                            if (Keyboard.getEventKey() == 2 + i)
                            {
                                thePlayer.inventory.currentItem = i;
                            }
                        }

                        if (gameSettings.showDebugInfo && gameSettings.field_74329_Q)
                        {
                            if (Keyboard.getEventKey() == 11)
                            {
                                updateDebugProfilerName(0);
                            }

                            int j = 0;

                            while (j < 9)
                            {
                                if (Keyboard.getEventKey() == 2 + j)
                                {
                                    updateDebugProfilerName(j + 1);
                                }

                                j++;
                            }
                        }
                    }
                }
            }
            while (true);

            boolean flag1 = gameSettings.chatVisibility != 2;

            for (; gameSettings.keyBindInventory.isPressed(); displayGuiScreen(new GuiInventory(thePlayer))) { }

            for (; gameSettings.keyBindDrop.isPressed(); thePlayer.dropOneItem()) { }

            for (; gameSettings.keyBindChat.isPressed() && flag1; displayGuiScreen(new GuiChat())) { }

            if (currentScreen == null && gameSettings.field_74323_J.isPressed() && flag1)
            {
                displayGuiScreen(new GuiChat("/"));
            }

            if (thePlayer.isUsingItem())
            {
                if (!gameSettings.keyBindUseItem.pressed)
                {
                    playerController.onStoppedUsingItem(thePlayer);
                }

                while (gameSettings.keyBindAttack.isPressed()) ;

                while (gameSettings.keyBindUseItem.isPressed()) ;

                while (gameSettings.keyBindPickBlock.isPressed()) ;
            }
            else
            {
                for (; gameSettings.keyBindAttack.isPressed(); clickMouse(0)) { }

                for (; gameSettings.keyBindUseItem.isPressed(); clickMouse(1)) { }

                for (; gameSettings.keyBindPickBlock.isPressed(); clickMiddleMouseButton()) { }
            }

            if (gameSettings.keyBindUseItem.pressed && rightClickDelayTimer == 0 && !thePlayer.isUsingItem())
            {
                clickMouse(1);
            }

            sendClickBlockToController(0, currentScreen == null && gameSettings.keyBindAttack.pressed && inGameHasFocus);
        }

        if (theWorld != null)
        {
            if (thePlayer != null)
            {
                joinPlayerCounter++;

                if (joinPlayerCounter == 30)
                {
                    joinPlayerCounter = 0;
                    theWorld.joinEntityInSurroundings(thePlayer);
                }
            }

            mcProfiler.endStartSection("gameRenderer");

            if (!isGamePaused)
            {
                entityRenderer.updateRenderer();
            }

            mcProfiler.endStartSection("levelRenderer");

            if (!isGamePaused)
            {
                renderGlobal.updateClouds();
            }

            mcProfiler.endStartSection("level");

            if (!isGamePaused)
            {
                if (theWorld.lightningFlash > 0)
                {
                    theWorld.lightningFlash--;
                }

                theWorld.updateEntities();
            }

            if (!isGamePaused)
            {
                theWorld.setAllowedSpawnTypes(theWorld.difficultySetting > 0, true);
                theWorld.tick();
            }

            mcProfiler.endStartSection("animateTick");

            if (!isGamePaused && theWorld != null)
            {
                theWorld.func_73029_E(MathHelper.floor_double(thePlayer.posX), MathHelper.floor_double(thePlayer.posY), MathHelper.floor_double(thePlayer.posZ));
            }

            mcProfiler.endStartSection("particles");

            if (!isGamePaused)
            {
                effectRenderer.updateEffects();
            }
        }
        else if (myNetworkManager != null)
        {
            mcProfiler.endStartSection("pendingConnection");
            myNetworkManager.processReadPackets();
        }

        mcProfiler.endSection();
        systemTime = getSystemTime();
    }

    /**
     * Forces a reload of the sound manager and all the resources. Called in game by holding 'F3' and pressing 'S'.
     */
    private void forceReload()
    {
        System.out.println("FORCING RELOAD!");
        sndManager = new SoundManager();
        sndManager.loadSoundSettings(gameSettings);
        downloadResourcesThread.reloadResources();
    }

    /**
     * Arguments: World foldername,  World ingame name, WorldSettings
     */
    public void launchIntegratedServer(String par1Str, String par2Str, WorldSettings par3WorldSettings)
    {
        loadWorld(null);
        System.gc();
        ISaveHandler isavehandler = saveLoader.getSaveLoader(par1Str, false);
        WorldInfo worldinfo = isavehandler.loadWorldInfo();

        if (worldinfo == null && par3WorldSettings != null)
        {
            statFileWriter.readStat(StatList.createWorldStat, 1);
            worldinfo = new WorldInfo(par3WorldSettings, par1Str);
            isavehandler.saveWorldInfo(worldinfo);
        }

        if (par3WorldSettings == null)
        {
            par3WorldSettings = new WorldSettings(worldinfo);
        }

        statFileWriter.readStat(StatList.startGameStat, 1);
        theIntegratedServer = new IntegratedServer(this, par1Str, par2Str, par3WorldSettings);
        theIntegratedServer.startServerThread();
        integratedServerIsRunning = true;
        loadingScreen.displayProgressMessage(StatCollector.translateToLocal("menu.loadingLevel"));

        while (!theIntegratedServer.serverIsInRunLoop())
        {
            String s = theIntegratedServer.getUserMessage();

            if (s != null)
            {
                loadingScreen.resetProgresAndWorkingMessage(StatCollector.translateToLocal(s));
            }
            else
            {
                loadingScreen.resetProgresAndWorkingMessage("");
            }

            try
            {
                Thread.sleep(200L);
            }
            catch (InterruptedException interruptedexception) { }
        }

        displayGuiScreen(null);

        try
        {
            NetClientHandler netclienthandler = new NetClientHandler(this, theIntegratedServer);
            myNetworkManager = netclienthandler.getNetManager();
        }
        catch (IOException ioexception)
        {
            displayCrashReport(func_71396_d(new CrashReport("Connecting to integrated server", ioexception)));
        }
    }

    /**
     * unloads the current world first
     */
    public void loadWorld(WorldClient par1WorldClient)
    {
        loadWorld(par1WorldClient, "");
    }

    /**
     * par2Str is displayed on the loading screen to the user unloads the current world first
     */
    public void loadWorld(WorldClient par1WorldClient, String par2Str)
    {
        statFileWriter.syncStats();

        if (par1WorldClient == null)
        {
            NetClientHandler netclienthandler = getSendQueue();

            if (netclienthandler != null)
            {
                netclienthandler.cleanup();
            }

            if (myNetworkManager != null)
            {
                myNetworkManager.closeConnections();
            }

            if (theIntegratedServer != null)
            {
                theIntegratedServer.setServerStopping();
            }

            theIntegratedServer = null;
        }

        renderViewEntity = null;
        myNetworkManager = null;

        if (loadingScreen != null)
        {
            loadingScreen.resetProgressAndMessage(par2Str);
            loadingScreen.resetProgresAndWorkingMessage("");
        }

        if (par1WorldClient == null && theWorld != null)
        {
            if (texturePackList.func_77295_a())
            {
                texturePackList.func_77304_b();
            }

            setServerData(null);
            integratedServerIsRunning = false;
        }

        sndManager.playStreaming(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        theWorld = par1WorldClient;

        if (par1WorldClient != null)
        {
            if (renderGlobal != null)
            {
                renderGlobal.setWorldAndLoadRenderers(par1WorldClient);
            }

            if (effectRenderer != null)
            {
                effectRenderer.clearEffects(par1WorldClient);
            }

            if (thePlayer == null)
            {
                thePlayer = playerController.func_78754_a(par1WorldClient);
                playerController.flipPlayer(thePlayer);
            }

            thePlayer.preparePlayerToSpawn();
            par1WorldClient.spawnEntityInWorld(thePlayer);
            thePlayer.movementInput = new MovementInputFromOptions(gameSettings);
            playerController.func_78748_a(thePlayer);
            renderViewEntity = thePlayer;
            //load codebase1 and codebase2 to the player
            theMinecraft.thePlayer.inventory.setInventorySlotContents(1, new ItemStack(mod_codeTrip.codebase1,1,0));
        	theMinecraft.thePlayer.inventory.setInventorySlotContents(2, new ItemStack(mod_codeTrip.codebase2,1,0));
        	thePlayer.inventory.setInventorySlotContents(2, new ItemStack(Block.fence,3,0));
        }
        else
        {
            saveLoader.flushCache();
            thePlayer = null;
        }

        System.gc();
        systemTime = 0L;
        
        //for test
        if(thePlayer!=null){
        	theMinecraft.thePlayer.inventory.setInventorySlotContents(1, new ItemStack(mod_codeTrip.codebase1,1,0));
        	theMinecraft.thePlayer.inventory.setInventorySlotContents(2, new ItemStack(mod_codeTrip.codebase2,1,0));
        	thePlayer.inventory.setInventorySlotContents(2, new ItemStack(Block.fence,3,0));
        }
        	
    }

    /**
     * Installs a resource. Currently only sounds are download so this method just adds them to the SoundManager.
     */
    public void installResource(String par1Str, File par2File)
    {
        int i = par1Str.indexOf("/");
        String s = par1Str.substring(0, i);
        par1Str = par1Str.substring(i + 1);

        if (s.equalsIgnoreCase("sound") || s.equalsIgnoreCase("newsound"))
        {
            sndManager.addSound(par1Str, par2File);
        }
        else if (s.equalsIgnoreCase("streaming"))
        {
            sndManager.addStreaming(par1Str, par2File);
        }
        else if (s.equalsIgnoreCase("music") || s.equalsIgnoreCase("newmusic"))
        {
            sndManager.addMusic(par1Str, par2File);
        }
    }

    /**
     * A String of renderGlobal.getDebugInfoRenders
     */
    public String debugInfoRenders()
    {
        return renderGlobal.getDebugInfoRenders();
    }

    /**
     * Gets the information in the F3 menu about how many entities are infront/around you
     */
    public String getEntityDebug()
    {
        return renderGlobal.getDebugInfoEntities();
    }

    /**
     * Gets the name of the world's current chunk provider
     */
    public String getWorldProviderName()
    {
        return theWorld.getProviderName();
    }

    /**
     * A String of how many entities are in the world
     */
    public String debugInfoEntities()
    {
        return (new StringBuilder()).append("P: ").append(effectRenderer.getStatistics()).append(". T: ").append(theWorld.getDebugLoadedEntities()).toString();
    }

    public void setDimensionAndSpawnPlayer(int par1)
    {
        theWorld.setSpawnLocation();
        theWorld.removeAllEntities();
        int i = 0;

        if (thePlayer != null)
        {
            i = thePlayer.entityId;
            theWorld.setEntityDead(thePlayer);
        }

        renderViewEntity = null;
        thePlayer = playerController.func_78754_a(theWorld);
        thePlayer.dimension = par1;
        renderViewEntity = thePlayer;
        thePlayer.preparePlayerToSpawn();
        theWorld.spawnEntityInWorld(thePlayer);
        playerController.flipPlayer(thePlayer);
        thePlayer.movementInput = new MovementInputFromOptions(gameSettings);
        thePlayer.entityId = i;
        playerController.func_78748_a(thePlayer);

        if (currentScreen instanceof GuiGameOver)
        {
            displayGuiScreen(null);
        }
    }

    /**
     * Sets whether this is a demo or not.
     */
    void setDemo(boolean par1)
    {
        isDemo = par1;
    }

    /**
     * Gets whether this is a demo or not.
     */
    public final boolean isDemo()
    {
        return isDemo;
    }

    /**
     * get the client packet send queue
     */
    public NetClientHandler getSendQueue()
    {
        if (thePlayer != null)
        {
            return thePlayer.sendQueue;
        }
        else
        {
            return null;
        }
    }

    public static void main(String par0ArrayOfStr[])
    {
        HashMap hashmap = new HashMap();
        boolean flag = false;
        boolean flag1 = true;
        boolean flag2 = false;
        String s = (new StringBuilder()).append("Player").append(getSystemTime() % 1000L).toString();

        if (par0ArrayOfStr.length > 0)
        {
            s = par0ArrayOfStr[0];
        }

        String s1 = "-";

        if (par0ArrayOfStr.length > 1)
        {
            s1 = par0ArrayOfStr[1];
        }

        for (int i = 2; i < par0ArrayOfStr.length; i++)
        {
            String s2 = par0ArrayOfStr[i];
            String s3 = i != par0ArrayOfStr.length - 1 ? par0ArrayOfStr[i + 1] : null;
            boolean flag3 = false;

            if (s2.equals("-demo") || s2.equals("--demo"))
            {
                flag = true;
            }
            else if (s2.equals("--applet"))
            {
                flag1 = false;
            }

            if (flag3)
            {
                i++;
            }
        }

        hashmap.put("demo", (new StringBuilder()).append("").append(flag).toString());
        hashmap.put("stand-alone", (new StringBuilder()).append("").append(flag1).toString());
        hashmap.put("username", s);
        hashmap.put("fullscreen", (new StringBuilder()).append("").append(flag2).toString());
        hashmap.put("sessionid", s1);
        Frame frame = new Frame();
        frame.setTitle("Minecraft");
        frame.setBackground(Color.BLACK);
        JPanel jpanel = new JPanel();
        frame.setLayout(new BorderLayout());
        jpanel.setPreferredSize(new Dimension(854, 480));
        frame.add(jpanel, "Center");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new GameWindowListener());
        MinecraftFakeLauncher minecraftfakelauncher = new MinecraftFakeLauncher(hashmap);
        MinecraftApplet minecraftapplet = new MinecraftApplet();
        minecraftapplet.setStub(minecraftfakelauncher);
        minecraftfakelauncher.setLayout(new BorderLayout());
        minecraftfakelauncher.add(minecraftapplet, "Center");
        minecraftfakelauncher.validate();
        frame.removeAll();
        frame.setLayout(new BorderLayout());
        frame.add(minecraftfakelauncher, "Center");
        frame.validate();
        minecraftapplet.init();
        minecraftapplet.start();
        Runtime.getRuntime().addShutdownHook(new ThreadShutdown());
    }

    public static boolean isGuiEnabled()
    {
        return theMinecraft == null || !theMinecraft.gameSettings.hideGUI;
    }

    public static boolean isFancyGraphicsEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.fancyGraphics;
    }

    /**
     * Returns if ambient occlusion is enabled
     */
    public static boolean isAmbientOcclusionEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.ambientOcclusion;
    }

    public static boolean isDebugInfoEnabled()
    {
        return theMinecraft != null && theMinecraft.gameSettings.showDebugInfo;
    }

    /**
     * Returns true if the message is a client command and should not be sent to the server. However there are no such
     * commands at this point in time.
     */
    public boolean handleClientCommand(String par1Str)
    {
        return par1Str.startsWith("/") ? false : false;
    }

    /**
     * Called when the middle mouse button gets clicked
     */
    private void clickMiddleMouseButton()
    {
        if (objectMouseOver == null)
        {
            return;
        }

        boolean flag = thePlayer.capabilities.isCreativeMode;
        int j = 0;
        boolean flag1 = false;
        int i;

        if (objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
        {
            int k = objectMouseOver.blockX;
            int i1 = objectMouseOver.blockY;
            int j1 = objectMouseOver.blockZ;
            Block block = Block.blocksList[theWorld.getBlockId(k, i1, j1)];

            if (block == null)
            {
                return;
            }

            i = block.idPicked(theWorld, k, i1, j1);

            if (i == 0)
            {
                return;
            }

            flag1 = Item.itemsList[i].getHasSubtypes();
            int k1 = i < 256 ? i : block.blockID;
            j = Block.blocksList[k1].getDamageValue(theWorld, k, i1, j1);
        }
        else if (objectMouseOver.typeOfHit == EnumMovingObjectType.ENTITY && objectMouseOver.entityHit != null && flag)
        {
            if (objectMouseOver.entityHit instanceof EntityPainting)
            {
                i = Item.painting.shiftedIndex;
            }
            else if (objectMouseOver.entityHit instanceof EntityMinecart)
            {
                EntityMinecart entityminecart = (EntityMinecart)objectMouseOver.entityHit;

                if (entityminecart.minecartType == 2)
                {
                    i = Item.minecartPowered.shiftedIndex;
                }
                else if (entityminecart.minecartType == 1)
                {
                    i = Item.minecartCrate.shiftedIndex;
                }
                else
                {
                    i = Item.minecartEmpty.shiftedIndex;
                }
            }
            else if (objectMouseOver.entityHit instanceof EntityBoat)
            {
                i = Item.boat.shiftedIndex;
            }
            else
            {
                i = Item.monsterPlacer.shiftedIndex;
                j = EntityList.getEntityID(objectMouseOver.entityHit);
                flag1 = true;

                if (j <= 0 || !EntityList.entityEggs.containsKey(Integer.valueOf(j)))
                {
                    return;
                }
            }
        }
        else
        {
            return;
        }

        thePlayer.inventory.setCurrentItem(i, j, flag1, flag);
        

        if (flag)
        {
            int l = (thePlayer.inventorySlots.inventorySlots.size() - 9) + thePlayer.inventory.currentItem;
            playerController.sendSlotPacket(thePlayer.inventory.getStackInSlot(thePlayer.inventory.currentItem), l);
        }
    }

    public CrashReport func_71396_d(CrashReport par1CrashReport)
    {
        par1CrashReport.addCrashSectionCallable("LWJGL", new CallableLWJGLVersion(this));
        par1CrashReport.addCrashSectionCallable("OpenGL", new CallableGLInfo(this));
        par1CrashReport.addCrashSectionCallable("Is Modded", new CallableModded(this));
        par1CrashReport.addCrashSectionCallable("Type", new CallableType2(this));
        par1CrashReport.addCrashSectionCallable("Texture Pack", new CallableTexturePack(this));
        par1CrashReport.addCrashSectionCallable("Profiler Position", new CallableClientProfiler(this));

        if (theWorld != null)
        {
            theWorld.addWorldInfoToCrashReport(par1CrashReport);
        }

        return par1CrashReport;
    }

    /**
     * Return the singleton Minecraft instance for the game
     */
    public static Minecraft getMinecraft()
    {
        return theMinecraft;
    }

    public void func_71395_y()
    {
        field_71468_ad = true;
    }

    public void addServerStatsToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("fps", Integer.valueOf(field_71470_ab));
        par1PlayerUsageSnooper.addData("texpack_name", texturePackList.func_77292_e().func_77538_c());
        par1PlayerUsageSnooper.addData("texpack_resolution", Integer.valueOf(texturePackList.func_77292_e().func_77534_f()));
        par1PlayerUsageSnooper.addData("vsync_enabled", Boolean.valueOf(gameSettings.enableVsync));
        par1PlayerUsageSnooper.addData("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
        par1PlayerUsageSnooper.addData("display_type", fullscreen ? "fullscreen" : "windowed");
    }

    public void addServerTypeToSnooper(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        par1PlayerUsageSnooper.addData("opengl_version", GL11.glGetString(GL11.GL_VERSION));
        par1PlayerUsageSnooper.addData("opengl_vendor", GL11.glGetString(GL11.GL_VENDOR));
        par1PlayerUsageSnooper.addData("client_brand", ClientBrandRetriever.getClientModName());
        par1PlayerUsageSnooper.addData("applet", Boolean.valueOf(hideQuitButton));
        ContextCapabilities contextcapabilities = GLContext.getCapabilities();
        par1PlayerUsageSnooper.addData("gl_caps[ARB_multitexture]", Boolean.valueOf(contextcapabilities.GL_ARB_multitexture));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_multisample]", Boolean.valueOf(contextcapabilities.GL_ARB_multisample));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_cube_map));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_blend]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_blend));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_matrix_palette]", Boolean.valueOf(contextcapabilities.GL_ARB_matrix_palette));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_program]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_program));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_shader));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_fragment_program]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_program));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_fragment_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_shader));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_shader_objects]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_objects));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_framebuffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_pixel_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_uniform_buffer_object));
        par1PlayerUsageSnooper.addData("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_non_power_of_two));
        par1PlayerUsageSnooper.addData("gl_max_texture_size", Integer.valueOf(func_71369_N()));
    }

    private static int func_71369_N()
    {
        for (int i = 16384; i > 0; i >>= 1)
        {
            GL11.glTexImage2D(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_RGBA, i, i, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, (ByteBuffer)null);
            int j = GL11.glGetTexLevelParameteri(GL11.GL_PROXY_TEXTURE_2D, 0, GL11.GL_TEXTURE_WIDTH);

            if (j != 0)
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns whether snooping is enabled or not.
     */
    public boolean isSnooperEnabled()
    {
        return gameSettings.snooperEnabled;
    }

    /**
     * Set the current ServerData instance.
     */
    public void setServerData(ServerData par1ServerData)
    {
        currentServerData = par1ServerData;
    }

    /**
     * Get the current ServerData instance.
     */
    public ServerData getServerData()
    {
        return currentServerData;
    }

    public boolean isIntegratedServerRunning()
    {
        return integratedServerIsRunning;
    }

    /**
     * Returns true if there is only one player playing, and the current server is the integrated one.
     */
    public boolean isSingleplayer()
    {
        return integratedServerIsRunning && theIntegratedServer != null;
    }

    /**
     * Returns the currently running integrated server
     */
    public IntegratedServer getIntegratedServer()
    {
        return theIntegratedServer;
    }

    public static void stopIntegratedServer()
    {
        if (theMinecraft == null)
        {
            return;
        }

        IntegratedServer integratedserver = theMinecraft.getIntegratedServer();

        if (integratedserver != null)
        {
            integratedserver.stopServer();
        }
    }

    /**
     * Returns the PlayerUsageSnooper instance.
     */
    public PlayerUsageSnooper getPlayerUsageSnooper()
    {
        return usageSnooper;
    }

    /**
     * Gets the system time in milliseconds.
     */
    public static long getSystemTime()
    {
        return (Sys.getTime() * 1000L) / Sys.getTimerResolution();
    }

    /**
     * Returns whether we're in full screen or not.
     */
    public boolean isFullScreen()
    {
        return fullscreen;
    }
}
