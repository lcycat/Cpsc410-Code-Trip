// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

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
import net.minecraft.src.AABBPool;
import net.minecraft.src.Achievement;
import net.minecraft.src.AchievementList;
import net.minecraft.src.AnvilSaveConverter;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CallableClientProfiler;
import net.minecraft.src.CallableGLInfo;
import net.minecraft.src.CallableLWJGLVersion;
import net.minecraft.src.CallableModded;
import net.minecraft.src.CallableTexturePack;
import net.minecraft.src.CallableType2;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.ColorizerWater;
import net.minecraft.src.Container;
import net.minecraft.src.CrashReport;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.EnumOS;
import net.minecraft.src.EnumOSHelper;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GameWindowListener;
import net.minecraft.src.GuiAchievement;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiErrorScreen;
import net.minecraft.src.GuiGameOver;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiMemoryErrorScreen;
import net.minecraft.src.GuiNewChat;
import net.minecraft.src.GuiParticle;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSleepMP;
import net.minecraft.src.IPlayerUsage;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.IntegratedServer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.LoadingScreenRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MemoryConnection;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.MinecraftFakeLauncher;
import net.minecraft.src.MouseHelper;
import net.minecraft.src.MovementInputFromOptions;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.PlayerCapabilities;
import net.minecraft.src.PlayerControllerMP;
import net.minecraft.src.PlayerUsageSnooper;
import net.minecraft.src.Profiler;
import net.minecraft.src.ProfilerResult;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ReportedException;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.ScreenShotHelper;
import net.minecraft.src.ServerData;
import net.minecraft.src.Session;
import net.minecraft.src.SoundManager;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatFileWriter;
import net.minecraft.src.StatList;
import net.minecraft.src.StatStringFormatKeyInv;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureCompassFX;
import net.minecraft.src.TextureFlamesFX;
import net.minecraft.src.TextureLavaFX;
import net.minecraft.src.TextureLavaFlowFX;
import net.minecraft.src.TexturePackBase;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.TexturePortalFX;
import net.minecraft.src.TextureWatchFX;
import net.minecraft.src.TextureWaterFX;
import net.minecraft.src.TextureWaterFlowFX;
import net.minecraft.src.ThreadClientSleep;
import net.minecraft.src.ThreadDownloadResources;
import net.minecraft.src.ThreadShutdown;
import net.minecraft.src.Timer;
import net.minecraft.src.Vec3;
import net.minecraft.src.Vec3Pool;
import net.minecraft.src.WorldClient;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldRenderer;
import net.minecraft.src.WorldSettings;
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

// Referenced classes of package net.minecraft.client:
//            MinecraftApplet, ClientBrandRetriever

public abstract class Minecraft
    implements Runnable, IPlayerUsage
{

    public static byte field_71444_a[] = new byte[0xa00000];
    private ServerData field_71422_O;
    private static Minecraft field_71432_P;
    public PlayerControllerMP field_71442_b;
    private boolean field_71431_Q;
    private boolean field_71434_R;
    private CrashReport field_71433_S;
    public int field_71443_c;
    public int field_71440_d;
    private Timer field_71428_T;
    private PlayerUsageSnooper field_71427_U;
    public WorldClient field_71441_e;
    public RenderGlobal field_71438_f;
    public EntityClientPlayerMP field_71439_g;
    public EntityLiving field_71451_h;
    public EffectRenderer field_71452_i;
    public Session field_71449_j;
    public String field_71450_k;
    public Canvas field_71447_l;
    public boolean field_71448_m;
    public volatile boolean field_71445_n;
    public RenderEngine field_71446_o;
    public FontRenderer field_71466_p;
    public FontRenderer field_71464_q;
    public GuiScreen field_71462_r;
    public LoadingScreenRenderer field_71461_s;
    public EntityRenderer field_71460_t;
    private ThreadDownloadResources field_71430_V;
    private int field_71429_W;
    private int field_71436_X;
    private int field_71435_Y;
    private IntegratedServer field_71437_Z;
    public GuiAchievement field_71458_u;
    public GuiIngame field_71456_v;
    public boolean field_71454_w;
    public MovingObjectPosition field_71476_x;
    public GameSettings field_71474_y;
    protected MinecraftApplet field_71473_z;
    public SoundManager field_71416_A;
    public MouseHelper field_71417_B;
    public TexturePackList field_71418_C;
    public File field_71412_D;
    private ISaveFormat field_71469_aa;
    private static int field_71470_ab;
    private int field_71467_ac;
    private boolean field_71468_ad;
    public StatFileWriter field_71413_E;
    private String field_71475_ae;
    private int field_71477_af;
    private TextureWaterFX field_71471_ag;
    private TextureLavaFX field_71472_ah;
    boolean field_71414_F;
    public boolean field_71415_G;
    long field_71423_H;
    private int field_71457_ai;
    private boolean field_71459_aj;
    private NetworkManager field_71453_ak;
    private boolean field_71455_al;
    public final Profiler field_71424_I = new Profiler();
    private static File field_71463_am = null;
    public volatile boolean field_71425_J;
    public String field_71426_K;
    long field_71419_L;
    int field_71420_M;
    long field_71421_N;
    private String field_71465_an;

    public Minecraft(Canvas p_i3022_1_, MinecraftApplet p_i3022_2_, int p_i3022_3_, int p_i3022_4_, boolean p_i3022_5_)
    {
        field_71431_Q = false;
        field_71434_R = false;
        field_71428_T = new Timer(20F);
        field_71427_U = new PlayerUsageSnooper("client", this);
        field_71449_j = null;
        field_71448_m = false;
        field_71445_n = false;
        field_71462_r = null;
        field_71429_W = 0;
        field_71458_u = new GuiAchievement(this);
        field_71454_w = false;
        field_71476_x = null;
        field_71416_A = new SoundManager();
        field_71467_ac = 0;
        field_71471_ag = new TextureWaterFX();
        field_71472_ah = new TextureLavaFX();
        field_71414_F = false;
        field_71415_G = false;
        field_71423_H = func_71386_F();
        field_71457_ai = 0;
        field_71425_J = true;
        field_71426_K = "";
        field_71419_L = func_71386_F();
        field_71420_M = 0;
        field_71421_N = -1L;
        field_71465_an = "root";
        StatList.func_75919_a();
        field_71435_Y = p_i3022_4_;
        field_71431_Q = p_i3022_5_;
        field_71473_z = p_i3022_2_;
        Packet3Chat.field_73478_a = 32767;
        func_71389_H();
        field_71447_l = p_i3022_1_;
        field_71443_c = p_i3022_3_;
        field_71440_d = p_i3022_4_;
        field_71431_Q = p_i3022_5_;
        field_71432_P = this;
    }

    private void func_71389_H()
    {
        ThreadClientSleep threadclientsleep = new ThreadClientSleep(this, "Timer hack thread");
        threadclientsleep.setDaemon(true);
        threadclientsleep.start();
    }

    public void func_71404_a(CrashReport p_71404_1_)
    {
        field_71434_R = true;
        field_71433_S = p_71404_1_;
    }

    public void func_71377_b(CrashReport p_71377_1_)
    {
        field_71434_R = true;
        func_71406_c(p_71377_1_);
    }

    public abstract void func_71406_c(CrashReport crashreport);

    public void func_71367_a(String p_71367_1_, int p_71367_2_)
    {
        field_71475_ae = p_71367_1_;
        field_71477_af = p_71367_2_;
    }

    public void func_71384_a()
        throws LWJGLException
    {
        if(field_71447_l != null)
        {
            Graphics g = field_71447_l.getGraphics();
            if(g != null)
            {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, field_71443_c, field_71440_d);
                g.dispose();
            }
            Display.setParent(field_71447_l);
        } else
        if(field_71431_Q)
        {
            Display.setFullscreen(true);
            field_71443_c = Display.getDisplayMode().getWidth();
            field_71440_d = Display.getDisplayMode().getHeight();
            if(field_71443_c <= 0)
            {
                field_71443_c = 1;
            }
            if(field_71440_d <= 0)
            {
                field_71440_d = 1;
            }
        } else
        {
            Display.setDisplayMode(new DisplayMode(field_71443_c, field_71440_d));
        }
        Display.setTitle("Minecraft Minecraft 1.3.1");
        System.out.println((new StringBuilder()).append("LWJGL Version: ").append(Sys.getVersion()).toString());
        try
        {
            Display.create((new PixelFormat()).withDepthBits(24));
        }
        catch(LWJGLException lwjglexception)
        {
            lwjglexception.printStackTrace();
            try
            {
                Thread.sleep(1000L);
            }
            catch(InterruptedException interruptedexception) { }
            Display.create();
        }
        OpenGlHelper.func_77474_a();
        field_71412_D = func_71380_b();
        field_71469_aa = new AnvilSaveConverter(new File(field_71412_D, "saves"));
        field_71474_y = new GameSettings(this, field_71412_D);
        field_71418_C = new TexturePackList(field_71412_D, this);
        field_71446_o = new RenderEngine(field_71418_C, field_71474_y);
        func_71357_I();
        field_71466_p = new FontRenderer(field_71474_y, "/font/default.png", field_71446_o, false);
        field_71464_q = new FontRenderer(field_71474_y, "/font/alternate.png", field_71446_o, false);
        if(field_71474_y.field_74363_ab != null)
        {
            StringTranslate.func_74808_a().func_74810_a(field_71474_y.field_74363_ab);
            field_71466_p.func_78264_a(StringTranslate.func_74808_a().func_74804_d());
            field_71466_p.func_78275_b(StringTranslate.func_74802_e(field_71474_y.field_74363_ab));
        }
        ColorizerWater.func_76914_a(field_71446_o.func_78346_a("/misc/watercolor.png"));
        ColorizerGrass.func_77479_a(field_71446_o.func_78346_a("/misc/grasscolor.png"));
        ColorizerFoliage.func_77467_a(field_71446_o.func_78346_a("/misc/foliagecolor.png"));
        field_71460_t = new EntityRenderer(this);
        RenderManager.field_78727_a.field_78721_f = new ItemRenderer(this);
        field_71413_E = new StatFileWriter(field_71449_j, field_71412_D);
        AchievementList.field_76004_f.func_75988_a(new StatStringFormatKeyInv(this));
        func_71357_I();
        Mouse.create();
        field_71417_B = new MouseHelper(field_71447_l);
        func_71361_d("Pre startup");
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glClearDepth(1.0D);
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1F);
        GL11.glCullFace(1029);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        func_71361_d("Startup");
        field_71416_A.func_77373_a(field_71474_y);
        field_71446_o.func_78355_a(field_71472_ah);
        field_71446_o.func_78355_a(field_71471_ag);
        field_71446_o.func_78355_a(new TexturePortalFX());
        field_71446_o.func_78355_a(new TextureCompassFX(this));
        field_71446_o.func_78355_a(new TextureWatchFX(this));
        field_71446_o.func_78355_a(new TextureWaterFlowFX());
        field_71446_o.func_78355_a(new TextureLavaFlowFX());
        field_71446_o.func_78355_a(new TextureFlamesFX(0));
        field_71446_o.func_78355_a(new TextureFlamesFX(1));
        field_71438_f = new RenderGlobal(this, field_71446_o);
        GL11.glViewport(0, 0, field_71443_c, field_71440_d);
        field_71452_i = new EffectRenderer(field_71441_e, field_71446_o);
        try
        {
            field_71430_V = new ThreadDownloadResources(field_71412_D, this);
            field_71430_V.start();
        }
        catch(Exception exception) { }
        func_71361_d("Post startup");
        field_71456_v = new GuiIngame(this);
        if(field_71475_ae != null)
        {
            func_71373_a(new GuiConnecting(this, field_71475_ae, field_71477_af));
        } else
        {
            func_71373_a(new GuiMainMenu());
        }
        field_71461_s = new LoadingScreenRenderer(this);
        if(field_71474_y.field_74353_u && !field_71431_Q)
        {
            func_71352_k();
        }
    }

    private void func_71357_I()
        throws LWJGLException
    {
        ScaledResolution scaledresolution = new ScaledResolution(field_71474_y, field_71443_c, field_71440_d);
        GL11.glClear(16640);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, scaledresolution.func_78327_c(), scaledresolution.func_78324_d(), 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
        GL11.glViewport(0, 0, field_71443_c, field_71440_d);
        GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
        GL11.glDisable(2896);
        GL11.glEnable(3553);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.field_78398_a;
        GL11.glBindTexture(3553, field_71446_o.func_78341_b("/title/mojang.png"));
        tessellator.func_78382_b();
        tessellator.func_78378_d(0xffffff);
        tessellator.func_78374_a(0.0D, field_71440_d, 0.0D, 0.0D, 0.0D);
        tessellator.func_78374_a(field_71443_c, field_71440_d, 0.0D, 0.0D, 0.0D);
        tessellator.func_78374_a(field_71443_c, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        tessellator.func_78381_a();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        tessellator.func_78378_d(0xffffff);
        char c = '\u0100';
        char c1 = '\u0100';
        func_71392_a((scaledresolution.func_78326_a() - c) / 2, (scaledresolution.func_78328_b() - c1) / 2, 0, 0, c, c1);
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1F);
        Display.swapBuffers();
    }

    public void func_71392_a(int p_71392_1_, int p_71392_2_, int p_71392_3_, int p_71392_4_, int p_71392_5_, int p_71392_6_)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.field_78398_a;
        tessellator.func_78382_b();
        tessellator.func_78374_a(p_71392_1_ + 0, p_71392_2_ + p_71392_6_, 0.0D, (float)(p_71392_3_ + 0) * f, (float)(p_71392_4_ + p_71392_6_) * f1);
        tessellator.func_78374_a(p_71392_1_ + p_71392_5_, p_71392_2_ + p_71392_6_, 0.0D, (float)(p_71392_3_ + p_71392_5_) * f, (float)(p_71392_4_ + p_71392_6_) * f1);
        tessellator.func_78374_a(p_71392_1_ + p_71392_5_, p_71392_2_ + 0, 0.0D, (float)(p_71392_3_ + p_71392_5_) * f, (float)(p_71392_4_ + 0) * f1);
        tessellator.func_78374_a(p_71392_1_ + 0, p_71392_2_ + 0, 0.0D, (float)(p_71392_3_ + 0) * f, (float)(p_71392_4_ + 0) * f1);
        tessellator.func_78381_a();
    }

    public static File func_71380_b()
    {
        if(field_71463_am == null)
        {
            field_71463_am = func_71394_a("minecraft");
        }
        return field_71463_am;
    }

    public static File func_71394_a(String p_71394_0_)
    {
        String s = System.getProperty("user.home", ".");
        File file;
        switch(EnumOSHelper.field_74533_a[func_71376_c().ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
            file = new File(s, (new StringBuilder()).append('.').append(p_71394_0_).append('/').toString());
            break;

        case 3: // '\003'
            String s1 = System.getenv("APPDATA");
            if(s1 != null)
            {
                file = new File(s1, (new StringBuilder()).append(".").append(p_71394_0_).append('/').toString());
            } else
            {
                file = new File(s, (new StringBuilder()).append('.').append(p_71394_0_).append('/').toString());
            }
            break;

        case 4: // '\004'
            file = new File(s, (new StringBuilder()).append("Library/Application Support/").append(p_71394_0_).toString());
            break;

        default:
            file = new File(s, (new StringBuilder()).append(p_71394_0_).append('/').toString());
            break;
        }
        if(!file.exists() && !file.mkdirs())
        {
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(file).toString());
        } else
        {
            return file;
        }
    }

    public static EnumOS func_71376_c()
    {
        String s = System.getProperty("os.name").toLowerCase();
        if(s.contains("win"))
        {
            return EnumOS.WINDOWS;
        }
        if(s.contains("mac"))
        {
            return EnumOS.MACOS;
        }
        if(s.contains("solaris"))
        {
            return EnumOS.SOLARIS;
        }
        if(s.contains("sunos"))
        {
            return EnumOS.SOLARIS;
        }
        if(s.contains("linux"))
        {
            return EnumOS.LINUX;
        }
        if(s.contains("unix"))
        {
            return EnumOS.LINUX;
        } else
        {
            return EnumOS.UNKNOWN;
        }
    }

    public ISaveFormat func_71359_d()
    {
        return field_71469_aa;
    }

    public void func_71373_a(GuiScreen p_71373_1_)
    {
        if(field_71462_r instanceof GuiErrorScreen)
        {
            return;
        }
        if(field_71462_r != null)
        {
            field_71462_r.func_73874_b();
        }
        field_71413_E.func_77446_d();
        if(p_71373_1_ == null && field_71441_e == null)
        {
            p_71373_1_ = new GuiMainMenu();
        } else
        if(p_71373_1_ == null && field_71439_g.func_70630_aN() <= 0)
        {
            p_71373_1_ = new GuiGameOver();
        }
        if(p_71373_1_ instanceof GuiMainMenu)
        {
            field_71474_y.field_74330_P = false;
            field_71456_v.func_73827_b().func_73761_a();
        }
        field_71462_r = p_71373_1_;
        if(p_71373_1_ != null)
        {
            func_71364_i();
            ScaledResolution scaledresolution = new ScaledResolution(field_71474_y, field_71443_c, field_71440_d);
            int i = scaledresolution.func_78326_a();
            int j = scaledresolution.func_78328_b();
            p_71373_1_.func_73872_a(this, i, j);
            field_71454_w = false;
        } else
        {
            func_71381_h();
        }
    }

    private void func_71361_d(String p_71361_1_)
    {
        int i = GL11.glGetError();
        if(i != 0)
        {
            String s = GLU.gluErrorString(i);
            System.out.println("########## GL ERROR ##########");
            System.out.println((new StringBuilder()).append("@ ").append(p_71361_1_).toString());
            System.out.println((new StringBuilder()).append(i).append(": ").append(s).toString());
        }
    }

    public void func_71405_e()
    {
        try
        {
            field_71413_E.func_77446_d();
            try
            {
                if(field_71430_V != null)
                {
                    field_71430_V.func_74574_b();
                }
            }
            catch(Exception exception) { }
            System.out.println("Stopping!");
            try
            {
                func_71403_a(null);
            }
            catch(Throwable throwable) { }
            try
            {
                GLAllocation.func_74525_a();
            }
            catch(Throwable throwable1) { }
            field_71416_A.func_77370_b();
            Mouse.destroy();
            Keyboard.destroy();
        }
        finally
        {
            Display.destroy();
            if(!field_71434_R)
            {
                System.exit(0);
            }
        }
        System.gc();
    }

    public void run()
    {
        field_71425_J = true;
        try
        {
            func_71384_a();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            func_71377_b(func_71396_d(new CrashReport("Failed to start game", exception)));
            return;
        }
        try
        {
            while(field_71425_J) 
            {
                if(field_71434_R && field_71433_S != null)
                {
                    func_71377_b(field_71433_S);
                    return;
                }
                if(field_71468_ad)
                {
                    field_71468_ad = false;
                    field_71446_o.func_78352_b();
                }
                try
                {
                    func_71411_J();
                }
                catch(OutOfMemoryError outofmemoryerror)
                {
                    func_71398_f();
                    func_71373_a(new GuiMemoryErrorScreen());
                    System.gc();
                }
            }
        }
        catch(MinecraftError minecrafterror) { }
        catch(ReportedException reportedexception)
        {
            func_71396_d(reportedexception.func_71575_a());
            func_71398_f();
            reportedexception.printStackTrace();
            func_71377_b(reportedexception.func_71575_a());
        }
        catch(Throwable throwable)
        {
            CrashReport crashreport = func_71396_d(new CrashReport("Unexpected error", throwable));
            func_71398_f();
            throwable.printStackTrace();
            func_71377_b(crashreport);
        }
        finally
        {
            func_71405_e();
        }
    }

    private void func_71411_J()
    {
        if(field_71473_z != null && !field_71473_z.isActive())
        {
            field_71425_J = false;
            return;
        }
        AxisAlignedBB.func_72332_a().func_72298_a();
        Vec3.func_72437_a().func_72343_a();
        field_71424_I.func_76320_a("root");
        if(field_71447_l == null && Display.isCloseRequested())
        {
            func_71400_g();
        }
        if(field_71445_n && field_71441_e != null)
        {
            float f = field_71428_T.field_74281_c;
            field_71428_T.func_74275_a();
            field_71428_T.field_74281_c = f;
        } else
        {
            field_71428_T.func_74275_a();
        }
        long l = System.nanoTime();
        field_71424_I.func_76320_a("tick");
        for(int i = 0; i < field_71428_T.field_74280_b; i++)
        {
            func_71407_l();
        }

        field_71424_I.func_76318_c("preRenderErrors");
        long l1 = System.nanoTime() - l;
        func_71361_d("Pre render");
        RenderBlocks.field_78667_b = field_71474_y.field_74347_j;
        field_71424_I.func_76318_c("sound");
        field_71416_A.func_77369_a(field_71439_g, field_71428_T.field_74281_c);
        field_71424_I.func_76318_c("updatelights");
        if(field_71441_e != null)
        {
            field_71441_e.func_72968_M();
        }
        field_71424_I.func_76319_b();
        field_71424_I.func_76320_a("render");
        field_71424_I.func_76320_a("display");
        GL11.glEnable(3553);
        if(!Keyboard.isKeyDown(65))
        {
            Display.update();
        }
        if(field_71439_g != null && field_71439_g.func_70094_T())
        {
            field_71474_y.field_74320_O = 0;
        }
        field_71424_I.func_76319_b();
        if(!field_71454_w)
        {
            field_71424_I.func_76318_c("gameRenderer");
            field_71460_t.func_78480_b(field_71428_T.field_74281_c);
            field_71424_I.func_76319_b();
        }
        GL11.glFlush();
        field_71424_I.func_76319_b();
        if(!Display.isActive() && field_71431_Q)
        {
            func_71352_k();
        }
        if(field_71474_y.field_74330_P && field_71474_y.field_74329_Q)
        {
            if(!field_71424_I.field_76327_a)
            {
                field_71424_I.func_76317_a();
            }
            field_71424_I.field_76327_a = true;
            func_71366_a(l1);
        } else
        {
            field_71424_I.field_76327_a = false;
            field_71421_N = System.nanoTime();
        }
        field_71458_u.func_73847_a();
        field_71424_I.func_76320_a("root");
        Thread.yield();
        if(Keyboard.isKeyDown(65))
        {
            Display.update();
        }
        func_71365_K();
        if(field_71447_l != null && !field_71431_Q && (field_71447_l.getWidth() != field_71443_c || field_71447_l.getHeight() != field_71440_d))
        {
            field_71443_c = field_71447_l.getWidth();
            field_71440_d = field_71447_l.getHeight();
            if(field_71443_c <= 0)
            {
                field_71443_c = 1;
            }
            if(field_71440_d <= 0)
            {
                field_71440_d = 1;
            }
            func_71370_a(field_71443_c, field_71440_d);
        }
        func_71361_d("Post render");
        field_71420_M++;
        boolean flag = field_71445_n;
        field_71445_n = func_71356_B() && field_71462_r != null && field_71462_r.func_73868_f() && !field_71437_Z.func_71344_c();
        if(func_71387_A() && field_71439_g != null && field_71439_g.field_71174_a != null && field_71445_n != flag)
        {
            ((MemoryConnection)field_71439_g.field_71174_a.func_72548_f()).func_74437_a(field_71445_n);
        }
        do
        {
            if(func_71386_F() < field_71419_L + 1000L)
            {
                break;
            }
            field_71470_ab = field_71420_M;
            field_71426_K = (new StringBuilder()).append(field_71470_ab).append(" fps, ").append(WorldRenderer.field_78922_b).append(" chunk updates").toString();
            WorldRenderer.field_78922_b = 0;
            field_71419_L += 1000L;
            field_71420_M = 0;
            field_71427_U.func_76471_b();
            if(!field_71427_U.func_76468_d())
            {
                field_71427_U.func_76463_a();
            }
        } while(true);
        field_71424_I.func_76319_b();
        if(field_71474_y.field_74350_i > 0)
        {
            EntityRenderer _tmp = field_71460_t;
            Display.sync(EntityRenderer.func_78465_a(field_71474_y.field_74350_i));
        }
    }

    public void func_71398_f()
    {
        try
        {
            field_71444_a = new byte[0];
            field_71438_f.func_72728_f();
        }
        catch(Throwable throwable) { }
        try
        {
            System.gc();
            AxisAlignedBB.func_72332_a().func_72300_b();
            Vec3.func_72437_a().func_72344_b();
        }
        catch(Throwable throwable1) { }
        try
        {
            System.gc();
            func_71403_a(null);
        }
        catch(Throwable throwable2) { }
        System.gc();
    }

    private void func_71365_K()
    {
        if(Keyboard.isKeyDown(60))
        {
            if(!field_71414_F)
            {
                field_71414_F = true;
                field_71456_v.func_73827_b().func_73765_a(ScreenShotHelper.func_74291_a(field_71463_am, field_71443_c, field_71440_d));
            }
        } else
        {
            field_71414_F = false;
        }
    }

    private void func_71383_b(int p_71383_1_)
    {
        java.util.List list;
        ProfilerResult profilerresult;
        list = field_71424_I.func_76321_b(field_71465_an);
        if(list == null || list.isEmpty())
        {
            return;
        }
        profilerresult = (ProfilerResult)list.remove(0);
        if(p_71383_1_ != 0) goto _L2; else goto _L1
_L1:
        if(profilerresult.field_76331_c.length() > 0)
        {
            int i = field_71465_an.lastIndexOf(".");
            if(i >= 0)
            {
                field_71465_an = field_71465_an.substring(0, i);
            }
        }
          goto _L3
_L2:
        if(--p_71383_1_ >= list.size() || ((ProfilerResult)list.get(p_71383_1_)).field_76331_c.equals("unspecified")) goto _L3; else goto _L4
_L4:
        if(field_71465_an.length() <= 0) goto _L6; else goto _L5
_L5:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_71465_an;
        append();
        ".";
        append();
        toString();
        field_71465_an;
_L6:
        new StringBuilder();
        this;
        JVM INSTR dup_x1 ;
        field_71465_an;
        append();
        ((ProfilerResult)list.get(p_71383_1_)).field_76331_c;
        append();
        toString();
        field_71465_an;
_L3:
    }

    private void func_71366_a(long p_71366_1_)
    {
        if(!field_71424_I.field_76327_a)
        {
            return;
        }
        java.util.List list = field_71424_I.func_76321_b(field_71465_an);
        ProfilerResult profilerresult = (ProfilerResult)list.remove(0);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glEnable(2903);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0D, field_71443_c, field_71440_d, 0.0D, 1000D, 3000D);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0F, 0.0F, -2000F);
        GL11.glLineWidth(1.0F);
        GL11.glDisable(3553);
        Tessellator tessellator = Tessellator.field_78398_a;
        int i = 160;
        int j = field_71443_c - i - 10;
        int k = field_71440_d - i * 2;
        GL11.glEnable(3042);
        tessellator.func_78382_b();
        tessellator.func_78384_a(0, 200);
        tessellator.func_78377_a((float)j - (float)i * 1.1F, (float)k - (float)i * 0.6F - 16F, 0.0D);
        tessellator.func_78377_a((float)j - (float)i * 1.1F, k + i * 2, 0.0D);
        tessellator.func_78377_a((float)j + (float)i * 1.1F, k + i * 2, 0.0D);
        tessellator.func_78377_a((float)j + (float)i * 1.1F, (float)k - (float)i * 0.6F - 16F, 0.0D);
        tessellator.func_78381_a();
        GL11.glDisable(3042);
        double d = 0.0D;
        for(int l = 0; l < list.size(); l++)
        {
            ProfilerResult profilerresult1 = (ProfilerResult)list.get(l);
            int j1 = MathHelper.func_76128_c(profilerresult1.field_76332_a / 4D) + 1;
            tessellator.func_78371_b(6);
            tessellator.func_78378_d(profilerresult1.func_76329_a());
            tessellator.func_78377_a(j, k, 0.0D);
            for(int l1 = j1; l1 >= 0; l1--)
            {
                float f = (float)(((d + (profilerresult1.field_76332_a * (double)l1) / (double)j1) * 3.1415927410125732D * 2D) / 100D);
                float f2 = MathHelper.func_76126_a(f) * (float)i;
                float f4 = MathHelper.func_76134_b(f) * (float)i * 0.5F;
                tessellator.func_78377_a((float)j + f2, (float)k - f4, 0.0D);
            }

            tessellator.func_78381_a();
            tessellator.func_78371_b(5);
            tessellator.func_78378_d((profilerresult1.func_76329_a() & 0xfefefe) >> 1);
            for(int i2 = j1; i2 >= 0; i2--)
            {
                float f1 = (float)(((d + (profilerresult1.field_76332_a * (double)i2) / (double)j1) * 3.1415927410125732D * 2D) / 100D);
                float f3 = MathHelper.func_76126_a(f1) * (float)i;
                float f5 = MathHelper.func_76134_b(f1) * (float)i * 0.5F;
                tessellator.func_78377_a((float)j + f3, (float)k - f5, 0.0D);
                tessellator.func_78377_a((float)j + f3, ((float)k - f5) + 10F, 0.0D);
            }

            tessellator.func_78381_a();
            d += profilerresult1.field_76332_a;
        }

        DecimalFormat decimalformat = new DecimalFormat("##0.00");
        GL11.glEnable(3553);
        String s = "";
        if(!profilerresult.field_76331_c.equals("unspecified"))
        {
            s = (new StringBuilder()).append(s).append("[0] ").toString();
        }
        if(profilerresult.field_76331_c.length() == 0)
        {
            s = (new StringBuilder()).append(s).append("ROOT ").toString();
        } else
        {
            s = (new StringBuilder()).append(s).append(profilerresult.field_76331_c).append(" ").toString();
        }
        int k1 = 0xffffff;
        field_71466_p.func_78261_a(s, j - i, k - i / 2 - 16, k1);
        field_71466_p.func_78261_a(s = (new StringBuilder()).append(decimalformat.format(profilerresult.field_76330_b)).append("%").toString(), (j + i) - field_71466_p.func_78256_a(s), k - i / 2 - 16, k1);
        for(int i1 = 0; i1 < list.size(); i1++)
        {
            ProfilerResult profilerresult2 = (ProfilerResult)list.get(i1);
            String s1 = "";
            if(profilerresult2.field_76331_c.equals("unspecified"))
            {
                s1 = (new StringBuilder()).append(s1).append("[?] ").toString();
            } else
            {
                s1 = (new StringBuilder()).append(s1).append("[").append(i1 + 1).append("] ").toString();
            }
            s1 = (new StringBuilder()).append(s1).append(profilerresult2.field_76331_c).toString();
            field_71466_p.func_78261_a(s1, j - i, k + i / 2 + i1 * 8 + 20, profilerresult2.func_76329_a());
            field_71466_p.func_78261_a(s1 = (new StringBuilder()).append(decimalformat.format(profilerresult2.field_76332_a)).append("%").toString(), (j + i) - 50 - field_71466_p.func_78256_a(s1), k + i / 2 + i1 * 8 + 20, profilerresult2.func_76329_a());
            field_71466_p.func_78261_a(s1 = (new StringBuilder()).append(decimalformat.format(profilerresult2.field_76330_b)).append("%").toString(), (j + i) - field_71466_p.func_78256_a(s1), k + i / 2 + i1 * 8 + 20, profilerresult2.func_76329_a());
        }

    }

    public void func_71400_g()
    {
        field_71425_J = false;
    }

    public void func_71381_h()
    {
        if(!Display.isActive())
        {
            return;
        }
        if(field_71415_G)
        {
            return;
        } else
        {
            field_71415_G = true;
            field_71417_B.func_74372_a();
            func_71373_a(null);
            field_71429_W = 10000;
            return;
        }
    }

    public void func_71364_i()
    {
        if(!field_71415_G)
        {
            return;
        } else
        {
            KeyBinding.func_74506_a();
            field_71415_G = false;
            field_71417_B.func_74373_b();
            return;
        }
    }

    public void func_71385_j()
    {
        if(field_71462_r != null)
        {
            return;
        } else
        {
            func_71373_a(new GuiIngameMenu());
            return;
        }
    }

    private void func_71399_a(int p_71399_1_, boolean p_71399_2_)
    {
        if(!p_71399_2_)
        {
            field_71429_W = 0;
        }
        if(p_71399_1_ == 0 && field_71429_W > 0)
        {
            return;
        }
        if(p_71399_2_ && field_71476_x != null && field_71476_x.field_72313_a == EnumMovingObjectType.TILE && p_71399_1_ == 0)
        {
            int i = field_71476_x.field_72311_b;
            int j = field_71476_x.field_72312_c;
            int k = field_71476_x.field_72309_d;
            field_71442_b.func_78759_c(i, j, k, field_71476_x.field_72310_e);
            if(field_71439_g.func_71031_e(i, j, k))
            {
                field_71452_i.func_78867_a(i, j, k, field_71476_x.field_72310_e);
                field_71439_g.func_71038_i();
            }
        } else
        {
            field_71442_b.func_78767_c();
        }
    }

    private void func_71402_c(int p_71402_1_)
    {
        if(p_71402_1_ == 0 && field_71429_W > 0)
        {
            return;
        }
        if(p_71402_1_ == 0)
        {
            field_71439_g.func_71038_i();
        }
        if(p_71402_1_ == 1)
        {
            field_71467_ac = 4;
        }
        boolean flag = true;
        ItemStack itemstack = field_71439_g.field_71071_by.func_70448_g();
        if(field_71476_x == null)
        {
            if(p_71402_1_ == 0 && field_71442_b.func_78762_g())
            {
                field_71429_W = 10;
            }
        } else
        if(field_71476_x.field_72313_a == EnumMovingObjectType.ENTITY)
        {
            if(p_71402_1_ == 0)
            {
                field_71442_b.func_78764_a(field_71439_g, field_71476_x.field_72308_g);
            }
            if(p_71402_1_ == 1 && field_71442_b.func_78768_b(field_71439_g, field_71476_x.field_72308_g))
            {
                flag = false;
            }
        } else
        if(field_71476_x.field_72313_a == EnumMovingObjectType.TILE)
        {
            int i = field_71476_x.field_72311_b;
            int j = field_71476_x.field_72312_c;
            int k = field_71476_x.field_72309_d;
            int l = field_71476_x.field_72310_e;
            if(p_71402_1_ == 0)
            {
                field_71442_b.func_78743_b(i, j, k, field_71476_x.field_72310_e);
            } else
            {
                int i1 = itemstack == null ? 0 : itemstack.field_77994_a;
                if(field_71442_b.func_78760_a(field_71439_g, field_71441_e, itemstack, i, j, k, l, field_71476_x.field_72307_f))
                {
                    flag = false;
                    field_71439_g.func_71038_i();
                }
                if(itemstack == null)
                {
                    return;
                }
                if(itemstack.field_77994_a == 0)
                {
                    field_71439_g.field_71071_by.field_70462_a[field_71439_g.field_71071_by.field_70461_c] = null;
                } else
                if(itemstack.field_77994_a != i1 || field_71442_b.func_78758_h())
                {
                    field_71460_t.field_78516_c.func_78444_b();
                }
            }
        }
        if(flag && p_71402_1_ == 1)
        {
            ItemStack itemstack1 = field_71439_g.field_71071_by.func_70448_g();
            if(itemstack1 != null && field_71442_b.func_78769_a(field_71439_g, field_71441_e, itemstack1))
            {
                field_71460_t.field_78516_c.func_78445_c();
            }
        }
    }

    public void func_71352_k()
    {
        try
        {
            field_71431_Q = !field_71431_Q;
            if(field_71431_Q)
            {
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                field_71443_c = Display.getDisplayMode().getWidth();
                field_71440_d = Display.getDisplayMode().getHeight();
                if(field_71443_c <= 0)
                {
                    field_71443_c = 1;
                }
                if(field_71440_d <= 0)
                {
                    field_71440_d = 1;
                }
            } else
            {
                if(field_71447_l != null)
                {
                    field_71443_c = field_71447_l.getWidth();
                    field_71440_d = field_71447_l.getHeight();
                } else
                {
                    field_71443_c = field_71436_X;
                    field_71440_d = field_71435_Y;
                }
                if(field_71443_c <= 0)
                {
                    field_71443_c = 1;
                }
                if(field_71440_d <= 0)
                {
                    field_71440_d = 1;
                }
            }
            if(field_71462_r != null)
            {
                func_71370_a(field_71443_c, field_71440_d);
            }
            Display.setFullscreen(field_71431_Q);
            Display.setVSyncEnabled(field_71474_y.field_74352_v);
            Display.update();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_71370_a(int p_71370_1_, int p_71370_2_)
    {
        field_71443_c = p_71370_1_ > 0 ? p_71370_1_ : 1;
        field_71440_d = p_71370_2_ > 0 ? p_71370_2_ : 1;
        if(field_71462_r != null)
        {
            ScaledResolution scaledresolution = new ScaledResolution(field_71474_y, p_71370_1_, p_71370_2_);
            int i = scaledresolution.func_78326_a();
            int j = scaledresolution.func_78328_b();
            field_71462_r.func_73872_a(this, i, j);
        }
    }

    public void func_71407_l()
    {
        if(field_71467_ac > 0)
        {
            field_71467_ac--;
        }
        field_71424_I.func_76320_a("stats");
        field_71413_E.func_77449_e();
        field_71424_I.func_76318_c("gui");
        if(!field_71445_n)
        {
            field_71456_v.func_73831_a();
        }
        field_71424_I.func_76318_c("pick");
        field_71460_t.func_78473_a(1.0F);
        field_71424_I.func_76318_c("gameMode");
        if(!field_71445_n && field_71441_e != null)
        {
            field_71442_b.func_78765_e();
        }
        GL11.glBindTexture(3553, field_71446_o.func_78341_b("/terrain.png"));
        field_71424_I.func_76318_c("textures");
        if(!field_71445_n)
        {
            field_71446_o.func_78343_a();
        }
        if(field_71462_r == null && field_71439_g != null)
        {
            if(field_71439_g.func_70630_aN() <= 0)
            {
                func_71373_a(null);
            } else
            if(field_71439_g.func_70608_bn() && field_71441_e != null)
            {
                func_71373_a(new GuiSleepMP());
            }
        } else
        if(field_71462_r != null && (field_71462_r instanceof GuiSleepMP) && !field_71439_g.func_70608_bn())
        {
            func_71373_a(null);
        }
        if(field_71462_r != null)
        {
            field_71429_W = 10000;
        }
        if(field_71462_r != null)
        {
            field_71462_r.func_73862_m();
            if(field_71462_r != null)
            {
                field_71462_r.field_73884_l.func_73774_a();
                field_71462_r.func_73876_c();
            }
        }
        if(field_71462_r == null || field_71462_r.field_73885_j)
        {
            field_71424_I.func_76318_c("mouse");
            do
            {
                if(!Mouse.next())
                {
                    break;
                }
                KeyBinding.func_74510_a(Mouse.getEventButton() - 100, Mouse.getEventButtonState());
                if(Mouse.getEventButtonState())
                {
                    KeyBinding.func_74507_a(Mouse.getEventButton() - 100);
                }
                long l = func_71386_F() - field_71423_H;
                if(l <= 200L)
                {
                    int k = Mouse.getEventDWheel();
                    if(k != 0)
                    {
                        field_71439_g.field_71071_by.func_70453_c(k);
                        if(field_71474_y.field_74331_S)
                        {
                            if(k > 0)
                            {
                                k = 1;
                            }
                            if(k < 0)
                            {
                                k = -1;
                            }
                            field_71474_y.field_74328_V += (float)k * 0.25F;
                        }
                    }
                    if(field_71462_r == null)
                    {
                        if(!field_71415_G && Mouse.getEventButtonState())
                        {
                            func_71381_h();
                        }
                    } else
                    if(field_71462_r != null)
                    {
                        field_71462_r.func_73867_d();
                    }
                }
            } while(true);
            if(field_71429_W > 0)
            {
                field_71429_W--;
            }
            field_71424_I.func_76318_c("keyboard");
            do
            {
                if(!Keyboard.next())
                {
                    break;
                }
                KeyBinding.func_74510_a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                if(Keyboard.getEventKeyState())
                {
                    KeyBinding.func_74507_a(Keyboard.getEventKey());
                }
                if(Keyboard.getEventKeyState())
                {
                    if(Keyboard.getEventKey() == 87)
                    {
                        func_71352_k();
                    } else
                    {
                        if(field_71462_r != null)
                        {
                            field_71462_r.func_73860_n();
                        } else
                        {
                            if(Keyboard.getEventKey() == 1)
                            {
                                func_71385_j();
                            }
                            if(Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61))
                            {
                                func_71358_L();
                            }
                            if(Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61))
                            {
                                field_71446_o.func_78352_b();
                            }
                            if(Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61))
                            {
                                boolean flag = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                                field_71474_y.func_74306_a(EnumOptions.RENDER_DISTANCE, flag ? -1 : 1);
                            }
                            if(Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61))
                            {
                                field_71438_f.func_72712_a();
                            }
                            if(Keyboard.getEventKey() == 59)
                            {
                                field_71474_y.field_74319_N = !field_71474_y.field_74319_N;
                            }
                            if(Keyboard.getEventKey() == 61)
                            {
                                field_71474_y.field_74330_P = !field_71474_y.field_74330_P;
                                field_71474_y.field_74329_Q = !GuiScreen.func_73877_p();
                            }
                            if(Keyboard.getEventKey() == 63)
                            {
                                field_71474_y.field_74320_O++;
                                if(field_71474_y.field_74320_O > 2)
                                {
                                    field_71474_y.field_74320_O = 0;
                                }
                            }
                            if(Keyboard.getEventKey() == 66)
                            {
                                field_71474_y.field_74326_T = !field_71474_y.field_74326_T;
                            }
                        }
                        for(int i = 0; i < 9; i++)
                        {
                            if(Keyboard.getEventKey() == 2 + i)
                            {
                                field_71439_g.field_71071_by.field_70461_c = i;
                            }
                        }

                        if(field_71474_y.field_74330_P && field_71474_y.field_74329_Q)
                        {
                            if(Keyboard.getEventKey() == 11)
                            {
                                func_71383_b(0);
                            }
                            int j = 0;
                            while(j < 9) 
                            {
                                if(Keyboard.getEventKey() == 2 + j)
                                {
                                    func_71383_b(j + 1);
                                }
                                j++;
                            }
                        }
                    }
                }
            } while(true);
            boolean flag1 = field_71474_y.field_74343_n != 2;
            for(; field_71474_y.field_74315_B.func_74509_c(); func_71373_a(new GuiInventory(field_71439_g))) { }
            for(; field_71474_y.field_74316_C.func_74509_c(); field_71439_g.func_71040_bB()) { }
            for(; field_71474_y.field_74310_D.func_74509_c() && flag1; func_71373_a(new GuiChat())) { }
            if(field_71462_r == null && field_71474_y.field_74323_J.func_74509_c() && flag1)
            {
                func_71373_a(new GuiChat("/"));
            }
            if(field_71439_g.func_71039_bw())
            {
                if(!field_71474_y.field_74313_G.field_74513_e)
                {
                    field_71442_b.func_78766_c(field_71439_g);
                }
                while(field_71474_y.field_74312_F.func_74509_c()) ;
                while(field_71474_y.field_74313_G.func_74509_c()) ;
                while(field_71474_y.field_74322_I.func_74509_c()) ;
            } else
            {
                for(; field_71474_y.field_74312_F.func_74509_c(); func_71402_c(0)) { }
                for(; field_71474_y.field_74313_G.func_74509_c(); func_71402_c(1)) { }
                for(; field_71474_y.field_74322_I.func_74509_c(); func_71397_M()) { }
            }
            if(field_71474_y.field_74313_G.field_74513_e && field_71467_ac == 0 && !field_71439_g.func_71039_bw())
            {
                func_71402_c(1);
            }
            func_71399_a(0, field_71462_r == null && field_71474_y.field_74312_F.field_74513_e && field_71415_G);
        }
        if(field_71441_e != null)
        {
            if(field_71439_g != null)
            {
                field_71457_ai++;
                if(field_71457_ai == 30)
                {
                    field_71457_ai = 0;
                    field_71441_e.func_72897_h(field_71439_g);
                }
            }
            field_71424_I.func_76318_c("gameRenderer");
            if(!field_71445_n)
            {
                field_71460_t.func_78464_a();
            }
            field_71424_I.func_76318_c("levelRenderer");
            if(!field_71445_n)
            {
                field_71438_f.func_72734_e();
            }
            field_71424_I.func_76318_c("level");
            if(!field_71445_n)
            {
                if(field_71441_e.field_73015_s > 0)
                {
                    field_71441_e.field_73015_s--;
                }
                field_71441_e.func_72939_s();
            }
            if(!field_71445_n)
            {
                field_71441_e.func_72891_a(field_71441_e.field_73013_u > 0, true);
                field_71441_e.func_72835_b();
            }
            field_71424_I.func_76318_c("animateTick");
            if(!field_71445_n && field_71441_e != null)
            {
                field_71441_e.func_73029_E(MathHelper.func_76128_c(field_71439_g.field_70165_t), MathHelper.func_76128_c(field_71439_g.field_70163_u), MathHelper.func_76128_c(field_71439_g.field_70161_v));
            }
            field_71424_I.func_76318_c("particles");
            if(!field_71445_n)
            {
                field_71452_i.func_78868_a();
            }
        } else
        if(field_71453_ak != null)
        {
            field_71424_I.func_76318_c("pendingConnection");
            field_71453_ak.func_74428_b();
        }
        field_71424_I.func_76319_b();
        field_71423_H = func_71386_F();
    }

    private void func_71358_L()
    {
        System.out.println("FORCING RELOAD!");
        field_71416_A = new SoundManager();
        field_71416_A.func_77373_a(field_71474_y);
        field_71430_V.func_74573_a();
    }

    public void func_71371_a(String p_71371_1_, String p_71371_2_, WorldSettings p_71371_3_)
    {
        func_71403_a(null);
        System.gc();
        ISaveHandler isavehandler = field_71469_aa.func_75804_a(p_71371_1_, false);
        WorldInfo worldinfo = isavehandler.func_75757_d();
        if(worldinfo == null && p_71371_3_ != null)
        {
            field_71413_E.func_77450_a(StatList.field_75937_g, 1);
            worldinfo = new WorldInfo(p_71371_3_, p_71371_1_);
            isavehandler.func_75761_a(worldinfo);
        }
        if(p_71371_3_ == null)
        {
            p_71371_3_ = new WorldSettings(worldinfo);
        }
        field_71413_E.func_77450_a(StatList.field_75936_f, 1);
        field_71437_Z = new IntegratedServer(this, p_71371_1_, p_71371_2_, p_71371_3_);
        field_71437_Z.func_71256_s();
        field_71455_al = true;
        field_71461_s.func_73720_a(StatCollector.func_74838_a("menu.loadingLevel"));
        while(!field_71437_Z.func_71200_ad()) 
        {
            String s = field_71437_Z.func_71195_b_();
            if(s != null)
            {
                field_71461_s.func_73719_c(StatCollector.func_74838_a(s));
            } else
            {
                field_71461_s.func_73719_c("");
            }
            try
            {
                Thread.sleep(200L);
            }
            catch(InterruptedException interruptedexception) { }
        }
        func_71373_a(null);
        try
        {
            NetClientHandler netclienthandler = new NetClientHandler(this, field_71437_Z);
            field_71453_ak = netclienthandler.func_72548_f();
        }
        catch(IOException ioexception)
        {
            func_71377_b(func_71396_d(new CrashReport("Connecting to integrated server", ioexception)));
        }
    }

    public void func_71403_a(WorldClient p_71403_1_)
    {
        func_71353_a(p_71403_1_, "");
    }

    public void func_71353_a(WorldClient p_71353_1_, String p_71353_2_)
    {
        field_71413_E.func_77446_d();
        if(p_71353_1_ == null)
        {
            NetClientHandler netclienthandler = func_71391_r();
            if(netclienthandler != null)
            {
                netclienthandler.func_72547_c();
            }
            if(field_71453_ak != null)
            {
                field_71453_ak.func_74431_f();
            }
            if(field_71437_Z != null)
            {
                field_71437_Z.func_71263_m();
            }
            field_71437_Z = null;
        }
        field_71451_h = null;
        field_71453_ak = null;
        if(field_71461_s != null)
        {
            field_71461_s.func_73721_b(p_71353_2_);
            field_71461_s.func_73719_c("");
        }
        if(p_71353_1_ == null && field_71441_e != null)
        {
            if(field_71418_C.func_77295_a())
            {
                field_71418_C.func_77304_b();
            }
            func_71351_a(null);
            field_71455_al = false;
        }
        field_71416_A.func_77368_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        field_71441_e = p_71353_1_;
        if(p_71353_1_ != null)
        {
            if(field_71438_f != null)
            {
                field_71438_f.func_72732_a(p_71353_1_);
            }
            if(field_71452_i != null)
            {
                field_71452_i.func_78870_a(p_71353_1_);
            }
            if(field_71439_g == null)
            {
                field_71439_g = field_71442_b.func_78754_a(p_71353_1_);
                field_71442_b.func_78745_b(field_71439_g);
            }
            field_71439_g.func_70065_x();
            p_71353_1_.func_72838_d(field_71439_g);
            field_71439_g.field_71158_b = new MovementInputFromOptions(field_71474_y);
            field_71442_b.func_78748_a(field_71439_g);
            field_71451_h = field_71439_g;
        } else
        {
            field_71469_aa.func_75800_d();
            field_71439_g = null;
        }
        System.gc();
        field_71423_H = 0L;
    }

    public void func_71360_a(String p_71360_1_, File p_71360_2_)
    {
        int i = p_71360_1_.indexOf("/");
        String s = p_71360_1_.substring(0, i);
        p_71360_1_ = p_71360_1_.substring(i + 1);
        if(s.equalsIgnoreCase("sound") || s.equalsIgnoreCase("newsound"))
        {
            field_71416_A.func_77372_a(p_71360_1_, p_71360_2_);
        } else
        if(s.equalsIgnoreCase("streaming"))
        {
            field_71416_A.func_77374_b(p_71360_1_, p_71360_2_);
        } else
        if(s.equalsIgnoreCase("music") || s.equalsIgnoreCase("newmusic"))
        {
            field_71416_A.func_77365_c(p_71360_1_, p_71360_2_);
        }
    }

    public String func_71393_m()
    {
        return field_71438_f.func_72735_c();
    }

    public String func_71408_n()
    {
        return field_71438_f.func_72723_d();
    }

    public String func_71388_o()
    {
        return field_71441_e.func_72827_u();
    }

    public String func_71374_p()
    {
        return (new StringBuilder()).append("P: ").append(field_71452_i.func_78869_b()).append(". T: ").append(field_71441_e.func_72981_t()).toString();
    }

    public void func_71354_a(int p_71354_1_)
    {
        field_71441_e.func_72974_f();
        field_71441_e.func_73022_a();
        int i = 0;
        if(field_71439_g != null)
        {
            i = field_71439_g.field_70157_k;
            field_71441_e.func_72900_e(field_71439_g);
        }
        field_71451_h = null;
        field_71439_g = field_71442_b.func_78754_a(field_71441_e);
        field_71439_g.field_71093_bK = p_71354_1_;
        field_71451_h = field_71439_g;
        field_71439_g.func_70065_x();
        field_71441_e.func_72838_d(field_71439_g);
        field_71442_b.func_78745_b(field_71439_g);
        field_71439_g.field_71158_b = new MovementInputFromOptions(field_71474_y);
        field_71439_g.field_70157_k = i;
        field_71442_b.func_78748_a(field_71439_g);
        if(field_71462_r instanceof GuiGameOver)
        {
            func_71373_a(null);
        }
    }

    void func_71390_a(boolean p_71390_1_)
    {
        field_71459_aj = p_71390_1_;
    }

    public final boolean func_71355_q()
    {
        return field_71459_aj;
    }

    public NetClientHandler func_71391_r()
    {
        if(field_71439_g != null)
        {
            return field_71439_g.field_71174_a;
        } else
        {
            return null;
        }
    }

    public static void main(String p_main_0_[])
    {
        HashMap hashmap = new HashMap();
        boolean flag = false;
        boolean flag1 = true;
        boolean flag2 = false;
        String s = (new StringBuilder()).append("Player").append(func_71386_F() % 1000L).toString();
        if(p_main_0_.length > 0)
        {
            s = p_main_0_[0];
        }
        String s1 = "-";
        if(p_main_0_.length > 1)
        {
            s1 = p_main_0_[1];
        }
        for(int i = 2; i < p_main_0_.length; i++)
        {
            String s2 = p_main_0_[i];
            String s3 = i != p_main_0_.length - 1 ? p_main_0_[i + 1] : null;
            boolean flag3 = false;
            if(s2.equals("-demo") || s2.equals("--demo"))
            {
                flag = true;
            } else
            if(s2.equals("--applet"))
            {
                flag1 = false;
            }
            if(flag3)
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

    public static boolean func_71382_s()
    {
        return field_71432_P == null || !field_71432_P.field_71474_y.field_74319_N;
    }

    public static boolean func_71375_t()
    {
        return field_71432_P != null && field_71432_P.field_71474_y.field_74347_j;
    }

    public static boolean func_71379_u()
    {
        return field_71432_P != null && field_71432_P.field_71474_y.field_74348_k;
    }

    public static boolean func_71368_v()
    {
        return field_71432_P != null && field_71432_P.field_71474_y.field_74330_P;
    }

    public boolean func_71409_c(String p_71409_1_)
    {
        return p_71409_1_.startsWith("/") ? false : false;
    }

    private void func_71397_M()
    {
        if(field_71476_x == null)
        {
            return;
        }
        boolean flag = field_71439_g.field_71075_bZ.field_75098_d;
        int j = 0;
        boolean flag1 = false;
        int i;
        if(field_71476_x.field_72313_a == EnumMovingObjectType.TILE)
        {
            int k = field_71476_x.field_72311_b;
            int i1 = field_71476_x.field_72312_c;
            int j1 = field_71476_x.field_72309_d;
            Block block = Block.field_71973_m[field_71441_e.func_72798_a(k, i1, j1)];
            if(block == null)
            {
                return;
            }
            i = block.func_71922_a(field_71441_e, k, i1, j1);
            if(i == 0)
            {
                return;
            }
            flag1 = Item.field_77698_e[i].func_77614_k();
            int k1 = i < 256 ? i : block.field_71990_ca;
            j = Block.field_71973_m[k1].func_71873_h(field_71441_e, k, i1, j1);
        } else
        if(field_71476_x.field_72313_a == EnumMovingObjectType.ENTITY && field_71476_x.field_72308_g != null && flag)
        {
            if(field_71476_x.field_72308_g instanceof EntityPainting)
            {
                i = Item.field_77780_as.field_77779_bT;
            } else
            if(field_71476_x.field_72308_g instanceof EntityMinecart)
            {
                EntityMinecart entityminecart = (EntityMinecart)field_71476_x.field_72308_g;
                if(entityminecart.field_70505_a == 2)
                {
                    i = Item.field_77763_aO.field_77779_bT;
                } else
                if(entityminecart.field_70505_a == 1)
                {
                    i = Item.field_77762_aN.field_77779_bT;
                } else
                {
                    i = Item.field_77773_az.field_77779_bT;
                }
            } else
            if(field_71476_x.field_72308_g instanceof EntityBoat)
            {
                i = Item.field_77769_aE.field_77779_bT;
            } else
            {
                i = Item.field_77815_bC.field_77779_bT;
                j = EntityList.func_75619_a(field_71476_x.field_72308_g);
                flag1 = true;
                if(j <= 0 || !EntityList.field_75627_a.containsKey(Integer.valueOf(j)))
                {
                    return;
                }
            }
        } else
        {
            return;
        }
        field_71439_g.field_71071_by.func_70433_a(i, j, flag1, flag);
        if(flag)
        {
            int l = (field_71439_g.field_71069_bz.field_75151_b.size() - 9) + field_71439_g.field_71071_by.field_70461_c;
            field_71442_b.func_78761_a(field_71439_g.field_71071_by.func_70301_a(field_71439_g.field_71071_by.field_70461_c), l);
        }
    }

    public CrashReport func_71396_d(CrashReport p_71396_1_)
    {
        p_71396_1_.func_71500_a("LWJGL", new CallableLWJGLVersion(this));
        p_71396_1_.func_71500_a("OpenGL", new CallableGLInfo(this));
        p_71396_1_.func_71500_a("Is Modded", new CallableModded(this));
        p_71396_1_.func_71500_a("Type", new CallableType2(this));
        p_71396_1_.func_71500_a("Texture Pack", new CallableTexturePack(this));
        p_71396_1_.func_71500_a("Profiler Position", new CallableClientProfiler(this));
        if(field_71441_e != null)
        {
            field_71441_e.func_72914_a(p_71396_1_);
        }
        return p_71396_1_;
    }

    public static Minecraft func_71410_x()
    {
        return field_71432_P;
    }

    public void func_71395_y()
    {
        field_71468_ad = true;
    }

    public void func_70000_a(PlayerUsageSnooper p_70000_1_)
    {
        p_70000_1_.func_76472_a("fps", Integer.valueOf(field_71470_ab));
        p_70000_1_.func_76472_a("texpack_name", field_71418_C.func_77292_e().func_77538_c());
        p_70000_1_.func_76472_a("texpack_resolution", Integer.valueOf(field_71418_C.func_77292_e().func_77534_f()));
        p_70000_1_.func_76472_a("vsync_enabled", Boolean.valueOf(field_71474_y.field_74352_v));
        p_70000_1_.func_76472_a("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
        p_70000_1_.func_76472_a("display_type", field_71431_Q ? "fullscreen" : "windowed");
    }

    public void func_70001_b(PlayerUsageSnooper p_70001_1_)
    {
        p_70001_1_.func_76472_a("opengl_version", GL11.glGetString(7938));
        p_70001_1_.func_76472_a("opengl_vendor", GL11.glGetString(7936));
        p_70001_1_.func_76472_a("client_brand", ClientBrandRetriever.getClientModName());
        p_70001_1_.func_76472_a("applet", Boolean.valueOf(field_71448_m));
        ContextCapabilities contextcapabilities = GLContext.getCapabilities();
        p_70001_1_.func_76472_a("gl_caps[ARB_multitexture]", Boolean.valueOf(contextcapabilities.GL_ARB_multitexture));
        p_70001_1_.func_76472_a("gl_caps[ARB_multisample]", Boolean.valueOf(contextcapabilities.GL_ARB_multisample));
        p_70001_1_.func_76472_a("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_cube_map));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_blend]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_blend));
        p_70001_1_.func_76472_a("gl_caps[ARB_matrix_palette]", Boolean.valueOf(contextcapabilities.GL_ARB_matrix_palette));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_program]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_program));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_shader));
        p_70001_1_.func_76472_a("gl_caps[ARB_fragment_program]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_program));
        p_70001_1_.func_76472_a("gl_caps[ARB_fragment_shader]", Boolean.valueOf(contextcapabilities.GL_ARB_fragment_shader));
        p_70001_1_.func_76472_a("gl_caps[ARB_shader_objects]", Boolean.valueOf(contextcapabilities.GL_ARB_shader_objects));
        p_70001_1_.func_76472_a("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_vertex_buffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_framebuffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_pixel_buffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(contextcapabilities.GL_ARB_uniform_buffer_object));
        p_70001_1_.func_76472_a("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(contextcapabilities.GL_ARB_texture_non_power_of_two));
        p_70001_1_.func_76472_a("gl_max_texture_size", Integer.valueOf(func_71369_N()));
    }

    private static int func_71369_N()
    {
        for(int i = 16384; i > 0; i >>= 1)
        {
            GL11.glTexImage2D(32868, 0, 6408, i, i, 0, 6408, 5121, (ByteBuffer)null);
            int j = GL11.glGetTexLevelParameteri(32868, 0, 4096);
            if(j != 0)
            {
                return i;
            }
        }

        return -1;
    }

    public boolean func_70002_Q()
    {
        return field_71474_y.field_74355_t;
    }

    public void func_71351_a(ServerData p_71351_1_)
    {
        field_71422_O = p_71351_1_;
    }

    public ServerData func_71362_z()
    {
        return field_71422_O;
    }

    public boolean func_71387_A()
    {
        return field_71455_al;
    }

    public boolean func_71356_B()
    {
        return field_71455_al && field_71437_Z != null;
    }

    public IntegratedServer func_71401_C()
    {
        return field_71437_Z;
    }

    public static void func_71363_D()
    {
        if(field_71432_P == null)
        {
            return;
        }
        IntegratedServer integratedserver = field_71432_P.func_71401_C();
        if(integratedserver != null)
        {
            integratedserver.func_71260_j();
        }
    }

    public PlayerUsageSnooper func_71378_E()
    {
        return field_71427_U;
    }

    public static long func_71386_F()
    {
        return (Sys.getTime() * 1000L) / Sys.getTimerResolution();
    }

    public boolean func_71372_G()
    {
        return field_71431_Q;
    }

}
