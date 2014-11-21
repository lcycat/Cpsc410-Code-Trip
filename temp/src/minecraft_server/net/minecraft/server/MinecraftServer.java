// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

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

public abstract class MinecraftServer
    implements Runnable, IPlayerUsage, ICommandSender
{

    public static Logger field_71306_a = Logger.getLogger("Minecraft");
    private static MinecraftServer field_71309_l = null;
    private final ISaveFormat field_71310_m;
    private final PlayerUsageSnooper field_71307_n = new PlayerUsageSnooper("server", this);
    private final File field_71308_o;
    private final List field_71322_p = new ArrayList();
    private final ICommandManager field_71321_q = new ServerCommandManager();
    public final Profiler field_71304_b = new Profiler();
    private String field_71320_r;
    private int field_71319_s;
    public WorldServer field_71305_c[];
    public ServerConfigurationManager field_71318_t;
    private boolean field_71317_u;
    private boolean field_71316_v;
    private int field_71315_w;
    public String field_71302_d;
    public int field_71303_e;
    private boolean field_71325_x;
    private boolean field_71324_y;
    private boolean field_71323_z;
    private boolean field_71284_A;
    private boolean field_71285_B;
    private String field_71286_C;
    private int field_71280_D;
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
    private String field_71293_J;
    private String field_71294_K;
    private boolean field_71288_M;
    private boolean field_71289_N;
    private boolean field_71290_O;
    private String field_71297_P;
    private boolean field_71296_Q;
    private long field_71299_R;
    private String field_71298_S;
    private boolean field_71295_T;

    public MinecraftServer(File p_i3375_1_)
    {
        field_71319_s = -1;
        field_71317_u = true;
        field_71316_v = false;
        field_71315_w = 0;
        field_71297_P = "";
        field_71296_Q = false;
        field_71309_l = this;
        field_71308_o = p_i3375_1_;
        field_71310_m = new AnvilSaveConverter(p_i3375_1_);
    }

    protected abstract boolean func_71197_b()
        throws IOException;

    protected void func_71237_c(String p_71237_1_)
    {
        if(func_71254_M().func_75801_b(p_71237_1_))
        {
            field_71306_a.info("Converting map!");
            func_71192_d("menu.convertingLevel");
            func_71254_M().func_75805_a(p_71237_1_, new ConvertProgressUpdater(this));
        }
        ModLoader.initialize(this);
        ModLoader.registerCommands(this);
    }

    protected synchronized void func_71192_d(String p_71192_1_)
    {
        field_71298_S = p_71192_1_;
    }

    protected void func_71247_a(String p_71247_1_, String p_71247_2_, long p_71247_3_, WorldType p_71247_5_)
    {
        func_71237_c(p_71247_1_);
        func_71192_d("menu.loadingLevel");
        field_71305_c = new WorldServer[3];
        field_71312_k = new long[field_71305_c.length][100];
        ISaveHandler isavehandler = field_71310_m.func_75804_a(p_71247_1_, true);
        WorldInfo worldinfo = isavehandler.func_75757_d();
        WorldSettings worldsettings;
        if(worldinfo == null)
        {
            worldsettings = new WorldSettings(p_71247_3_, func_71265_f(), func_71225_e(), func_71199_h(), p_71247_5_);
        } else
        {
            worldsettings = new WorldSettings(worldinfo);
        }
        if(field_71289_N)
        {
            worldsettings.func_77159_a();
        }
        for(int i = 0; i < field_71305_c.length; i++)
        {
            byte byte0 = 0;
            if(i == 1)
            {
                byte0 = -1;
            }
            if(i == 2)
            {
                byte0 = 1;
            }
            if(i == 0)
            {
                if(func_71242_L())
                {
                    field_71305_c[i] = new DemoWorldServer(this, isavehandler, p_71247_2_, byte0, field_71304_b);
                } else
                {
                    field_71305_c[i] = new WorldServer(this, isavehandler, p_71247_2_, byte0, worldsettings, field_71304_b);
                }
            } else
            {
                field_71305_c[i] = new WorldServerMulti(this, isavehandler, p_71247_2_, byte0, worldsettings, field_71305_c[0], field_71304_b);
            }
            field_71305_c[i].func_72954_a(new WorldManager(this, field_71305_c[i]));
            if(!func_71264_H())
            {
                field_71305_c[i].func_72912_H().func_76060_a(func_71265_f());
            }
            field_71318_t.func_72364_a(field_71305_c);
        }

        func_71226_c(func_71232_g());
        func_71222_d();
    }

    protected void func_71222_d()
    {
        char c = '\304';
        long l = System.currentTimeMillis();
        func_71192_d("menu.generatingTerrain");
        for(int i = 0; i < 1; i++)
        {
            field_71306_a.info((new StringBuilder()).append("Preparing start region for level ").append(i).toString());
            WorldServer worldserver = field_71305_c[i];
            ChunkCoordinates chunkcoordinates = worldserver.func_72861_E();
            for(int j = -c; j <= c && func_71278_l(); j += 16)
            {
                for(int k = -c; k <= c && func_71278_l(); k += 16)
                {
                    long l1 = System.currentTimeMillis();
                    if(l1 < l)
                    {
                        l = l1;
                    }
                    if(l1 > l + 1000L)
                    {
                        int i1 = (c * 2 + 1) * (c * 2 + 1);
                        int j1 = (j + c) * (c * 2 + 1) + k + 1;
                        func_71216_a_("Preparing spawn area", (j1 * 100) / i1);
                        l = l1;
                    }
                    worldserver.field_73059_b.func_73158_c(chunkcoordinates.field_71574_a + j >> 4, chunkcoordinates.field_71573_c + k >> 4);
                    while(worldserver.func_72968_M() && func_71278_l()) ;
                }

            }

        }

        func_71243_i();
    }

    public abstract boolean func_71225_e();

    public abstract EnumGameType func_71265_f();

    public abstract int func_71232_g();

    public abstract boolean func_71199_h();

    protected void func_71216_a_(String p_71216_1_, int p_71216_2_)
    {
        field_71302_d = p_71216_1_;
        field_71303_e = p_71216_2_;
        field_71306_a.info((new StringBuilder()).append(p_71216_1_).append(": ").append(p_71216_2_).append("%").toString());
    }

    protected void func_71243_i()
    {
        field_71302_d = null;
        field_71303_e = 0;
    }

    protected void func_71267_a(boolean p_71267_1_)
    {
        if(!field_71290_O)
        {
            WorldServer aworldserver[] = field_71305_c;
            int i = aworldserver.length;
            for(int j = 0; j < i; j++)
            {
                WorldServer worldserver = aworldserver[j];
                if(worldserver == null)
                {
                    continue;
                }
                if(!p_71267_1_)
                {
                    field_71306_a.info((new StringBuilder()).append("Saving chunks for level '").append(worldserver.func_72912_H().func_76065_j()).append("'/").append(worldserver.field_73011_w).toString());
                }
                try
                {
                    worldserver.func_73044_a(true, (IProgressUpdate)null);
                }
                catch(MinecraftException minecraftexception)
                {
                    field_71306_a.warning(minecraftexception.getMessage());
                }
            }

        }
    }

    public void func_71260_j()
    {
        if(!field_71290_O)
        {
            field_71306_a.info("Stopping server");
            if(func_71212_ac() != null)
            {
                func_71212_ac().func_71744_a();
            }
            if(field_71318_t != null)
            {
                field_71306_a.info("Saving players");
                field_71318_t.func_72389_g();
                field_71318_t.func_72392_r();
            }
            field_71306_a.info("Saving worlds");
            func_71267_a(false);
            WorldServer aworldserver[] = field_71305_c;
            int i = aworldserver.length;
            for(int j = 0; j < i; j++)
            {
                WorldServer worldserver = aworldserver[j];
                worldserver.func_73041_k();
            }

            if(field_71307_n != null && field_71307_n.func_76468_d())
            {
                field_71307_n.func_76470_e();
            }
        }
    }

    public String func_71211_k()
    {
        return field_71320_r;
    }

    public void func_71189_e(String p_71189_1_)
    {
        field_71320_r = p_71189_1_;
    }

    public boolean func_71278_l()
    {
        return field_71317_u;
    }

    public void func_71263_m()
    {
        field_71317_u = false;
    }

    public void run()
    {
        try
        {
            if(func_71197_b())
            {
                long l = System.currentTimeMillis();
                long l1 = 0L;
                while(field_71317_u) 
                {
                    ModLoader.onTick(this);
                    long l2 = System.currentTimeMillis();
                    long l3 = l2 - l;
                    if(l3 > 2000L && l - field_71299_R >= 15000L)
                    {
                        field_71306_a.warning("Can't keep up! Did the system time change, or is the server overloaded?");
                        l3 = 2000L;
                        field_71299_R = l;
                    }
                    if(l3 < 0L)
                    {
                        field_71306_a.warning("Time ran backwards! Did the system time change?");
                        l3 = 0L;
                    }
                    l1 += l3;
                    l = l2;
                    if(field_71305_c[0].func_73056_e())
                    {
                        func_71217_p();
                        l1 = 0L;
                    } else
                    {
                        while(l1 > 50L) 
                        {
                            l1 -= 50L;
                            func_71217_p();
                        }
                    }
                    Thread.sleep(1L);
                    field_71296_Q = true;
                }
            } else
            {
                func_71228_a((CrashReport)null);
            }
        }
        catch(Throwable throwable1)
        {
            throwable1.printStackTrace();
            field_71306_a.log(Level.SEVERE, (new StringBuilder()).append("Encountered an unexpected exception ").append(throwable1.getClass().getSimpleName()).toString(), throwable1);
            CrashReport crashreport = null;
            if(throwable1 instanceof ReportedException)
            {
                crashreport = func_71230_b(((ReportedException)throwable1).func_71575_a());
            } else
            {
                crashreport = func_71230_b(new CrashReport("Exception in server tick loop", throwable1));
            }
            File file = new File(new File(func_71238_n(), "crash-reports"), (new StringBuilder()).append("crash-").append((new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date())).append("-server.txt").toString());
            if(crashreport.func_71508_a(file))
            {
                field_71306_a.severe((new StringBuilder()).append("This crash report has been saved to: ").append(file.getAbsolutePath()).toString());
            } else
            {
                field_71306_a.severe("We were unable to save this crash report to disk.");
            }
            func_71228_a(crashreport);
            try
            {
                func_71260_j();
                field_71316_v = true;
            }
            catch(Throwable throwable2)
            {
                throwable2.printStackTrace();
            }
            finally
            {
                func_71240_o();
            }
            break MISSING_BLOCK_LABEL_509;
        }
        try
        {
            func_71260_j();
            field_71316_v = true;
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
        finally
        {
            func_71240_o();
        }
        break MISSING_BLOCK_LABEL_509;
        Exception exception2;
        exception2;
        try
        {
            func_71260_j();
            field_71316_v = true;
        }
        catch(Throwable throwable3)
        {
            throwable3.printStackTrace();
        }
        finally
        {
            func_71240_o();
        }
        throw exception2;
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

    protected void func_71217_p()
    {
        long l = System.nanoTime();
        AxisAlignedBB.func_72332_a().func_72298_a();
        Vec3.func_72437_a().func_72343_a();
        field_71315_w++;
        if(field_71295_T)
        {
            field_71295_T = false;
            field_71304_b.field_76327_a = true;
            field_71304_b.func_76317_a();
        }
        field_71304_b.func_76320_a("root");
        func_71190_q();
        if(field_71315_w % 900 == 0)
        {
            field_71304_b.func_76320_a("save");
            field_71318_t.func_72389_g();
            func_71267_a(true);
            field_71304_b.func_76319_b();
        }
        field_71304_b.func_76320_a("tallying");
        field_71311_j[field_71315_w % 100] = System.nanoTime() - l;
        field_71300_f[field_71315_w % 100] = Packet.field_73290_p - field_71281_E;
        field_71281_E = Packet.field_73290_p;
        field_71301_g[field_71315_w % 100] = Packet.field_73289_q - field_71282_F;
        field_71282_F = Packet.field_73289_q;
        field_71313_h[field_71315_w % 100] = Packet.field_73292_n - field_71283_G;
        field_71283_G = Packet.field_73292_n;
        field_71314_i[field_71315_w % 100] = Packet.field_73293_o - field_71291_H;
        field_71291_H = Packet.field_73293_o;
        field_71304_b.func_76319_b();
        field_71304_b.func_76320_a("snooper");
        if(!field_71307_n.func_76468_d() && field_71315_w > 100)
        {
            field_71307_n.func_76463_a();
        }
        if(field_71315_w % 6000 == 0)
        {
            field_71307_n.func_76471_b();
        }
        field_71304_b.func_76319_b();
        field_71304_b.func_76319_b();
    }

    public void func_71190_q()
    {
        field_71304_b.func_76320_a("levels");
        for(int i = 0; i < field_71305_c.length; i++)
        {
            long l = System.nanoTime();
            if(i == 0 || func_71255_r())
            {
                WorldServer worldserver = field_71305_c[i];
                field_71304_b.func_76320_a(worldserver.func_72912_H().func_76065_j());
                if(field_71315_w % 20 == 0)
                {
                    field_71304_b.func_76320_a("timeSync");
                    field_71318_t.func_72396_a(new Packet4UpdateTime(worldserver.func_72820_D()), worldserver.field_73011_w.field_76574_g);
                    field_71304_b.func_76319_b();
                }
                field_71304_b.func_76320_a("tick");
                worldserver.func_72835_b();
                field_71304_b.func_76318_c("lights");
                while(worldserver.func_72968_M()) ;
                field_71304_b.func_76319_b();
                if(!worldserver.field_73010_i.isEmpty())
                {
                    worldserver.func_72939_s();
                }
                field_71304_b.func_76320_a("tracker");
                worldserver.func_73039_n().func_72788_a();
                field_71304_b.func_76319_b();
                field_71304_b.func_76319_b();
            }
            field_71312_k[i][field_71315_w % 100] = System.nanoTime() - l;
        }

        field_71304_b.func_76318_c("connection");
        func_71212_ac().func_71747_b();
        field_71304_b.func_76318_c("players");
        field_71318_t.func_72374_b();
        field_71304_b.func_76318_c("tickables");
        IUpdatePlayerListBox iupdateplayerlistbox;
        for(Iterator iterator = field_71322_p.iterator(); iterator.hasNext(); iupdateplayerlistbox.func_73660_a())
        {
            iupdateplayerlistbox = (IUpdatePlayerListBox)iterator.next();
        }

        field_71304_b.func_76319_b();
    }

    public boolean func_71255_r()
    {
        return true;
    }

    public void func_79000_a(IUpdatePlayerListBox p_79000_1_)
    {
        field_71322_p.add(p_79000_1_);
    }

    public static void main(String p_main_0_[])
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
            for(int j = 0; j < p_main_0_.length; j++)
            {
                String s3 = p_main_0_[j];
                String s4 = j != p_main_0_.length - 1 ? p_main_0_[j + 1] : null;
                boolean flag3 = false;
                if(!s3.equals("nogui") && !s3.equals("--nogui"))
                {
                    if(s3.equals("--port") && s4 != null)
                    {
                        flag3 = true;
                        try
                        {
                            i = Integer.parseInt(s4);
                        }
                        catch(NumberFormatException numberformatexception) { }
                    } else
                    if(s3.equals("--singleplayer") && s4 != null)
                    {
                        flag3 = true;
                        s = s4;
                    } else
                    if(s3.equals("--universe") && s4 != null)
                    {
                        flag3 = true;
                        s1 = s4;
                    } else
                    if(s3.equals("--world") && s4 != null)
                    {
                        flag3 = true;
                        s2 = s4;
                    } else
                    if(s3.equals("--demo"))
                    {
                        flag1 = true;
                    } else
                    if(s3.equals("--bonusChest"))
                    {
                        flag2 = true;
                    }
                } else
                {
                    flag = false;
                }
                if(flag3)
                {
                    j++;
                }
            }

            DedicatedServer dedicatedserver = new DedicatedServer(new File(s1));
            if(s != null)
            {
                dedicatedserver.func_71224_l(s);
            }
            if(s2 != null)
            {
                dedicatedserver.func_71261_m(s2);
            }
            if(i >= 0)
            {
                dedicatedserver.func_71208_b(i);
            }
            if(flag1)
            {
                dedicatedserver.func_71204_b(true);
            }
            if(flag2)
            {
                dedicatedserver.func_71194_c(true);
            }
            if(flag)
            {
                dedicatedserver.func_79001_aj();
            }
            dedicatedserver.func_71256_s();
            Runtime.getRuntime().addShutdownHook(new ThreadDedicatedServer(dedicatedserver));
        }
        catch(Exception exception)
        {
            field_71306_a.log(Level.SEVERE, "Failed to start the minecraft server", exception);
        }
    }

    public void func_71256_s()
    {
        (new ThreadServerApplication(this, "Server thread")).start();
    }

    public File func_71209_f(String p_71209_1_)
    {
        return new File(func_71238_n(), p_71209_1_);
    }

    public void func_71244_g(String p_71244_1_)
    {
        field_71306_a.info(p_71244_1_);
    }

    public void func_71236_h(String p_71236_1_)
    {
        field_71306_a.warning(p_71236_1_);
    }

    public WorldServer func_71218_a(int p_71218_1_)
    {
        return p_71218_1_ != -1 ? p_71218_1_ != 1 ? field_71305_c[0] : field_71305_c[2] : field_71305_c[1];
    }

    public String func_71277_t()
    {
        return field_71320_r;
    }

    public int func_71234_u()
    {
        return field_71319_s;
    }

    public String func_71274_v()
    {
        return field_71286_C;
    }

    public String func_71249_w()
    {
        return "1.3.1";
    }

    public int func_71233_x()
    {
        return field_71318_t.func_72394_k();
    }

    public int func_71275_y()
    {
        return field_71318_t.func_72352_l();
    }

    public String[] func_71213_z()
    {
        return field_71318_t.func_72369_d();
    }

    public String func_71258_A()
    {
        return "";
    }

    public String func_71252_i(String p_71252_1_)
    {
        RConConsoleSource.field_70010_a.func_70007_b();
        field_71321_q.func_71556_a(RConConsoleSource.field_70010_a, p_71252_1_);
        return RConConsoleSource.field_70010_a.func_70008_c();
    }

    public boolean func_71239_B()
    {
        return false;
    }

    public void func_71201_j(String p_71201_1_)
    {
        field_71306_a.log(Level.SEVERE, p_71201_1_);
    }

    public void func_71198_k(String p_71198_1_)
    {
        if(func_71239_B())
        {
            field_71306_a.log(Level.INFO, p_71198_1_);
        }
    }

    public String getServerModName()
    {
        return "vanilla";
    }

    public CrashReport func_71230_b(CrashReport p_71230_1_)
    {
        p_71230_1_.func_71500_a("Is Modded", new CallableIsServerModded(this));
        p_71230_1_.func_71500_a("Profiler Position", new CallableServerProfiler(this));
        if(field_71318_t != null)
        {
            p_71230_1_.func_71500_a("Player Count", new CallablePlayers(this));
        }
        if(field_71305_c != null)
        {
            WorldServer aworldserver[] = field_71305_c;
            int i = aworldserver.length;
            for(int j = 0; j < i; j++)
            {
                WorldServer worldserver = aworldserver[j];
                if(worldserver != null)
                {
                    worldserver.func_72914_a(p_71230_1_);
                }
            }

        }
        return p_71230_1_;
    }

    public List func_71248_a(ICommandSender p_71248_1_, String p_71248_2_)
    {
        ArrayList arraylist = new ArrayList();
        if(p_71248_2_.startsWith("/"))
        {
            p_71248_2_ = p_71248_2_.substring(1);
            boolean flag = !p_71248_2_.contains(" ");
            List list = field_71321_q.func_71558_b(p_71248_1_, p_71248_2_);
            if(list != null)
            {
                for(Iterator iterator = list.iterator(); iterator.hasNext();)
                {
                    String s1 = (String)iterator.next();
                    if(flag)
                    {
                        arraylist.add((new StringBuilder()).append("/").append(s1).toString());
                    } else
                    {
                        arraylist.add(s1);
                    }
                }

            }
            return arraylist;
        }
        String as[] = p_71248_2_.split(" ", -1);
        String s = as[as.length - 1];
        String as1[] = field_71318_t.func_72369_d();
        int i = as1.length;
        for(int j = 0; j < i; j++)
        {
            String s2 = as1[j];
            if(CommandBase.func_71523_a(s, s2))
            {
                arraylist.add(s2);
            }
        }

        return arraylist;
    }

    public static MinecraftServer func_71276_C()
    {
        return field_71309_l;
    }

    public String func_70005_c_()
    {
        return "Server";
    }

    public void func_70006_a(String p_70006_1_)
    {
        field_71306_a.info(StringUtils.func_76338_a(p_70006_1_));
    }

    public boolean func_70003_b(String p_70003_1_)
    {
        return true;
    }

    public String func_70004_a(String p_70004_1_, Object p_70004_2_[])
    {
        return StringTranslate.func_74808_a().func_74803_a(p_70004_1_, p_70004_2_);
    }

    public ICommandManager func_71187_D()
    {
        return field_71321_q;
    }

    public KeyPair func_71250_E()
    {
        return field_71292_I;
    }

    public int func_71215_F()
    {
        return field_71319_s;
    }

    public void func_71208_b(int p_71208_1_)
    {
        field_71319_s = p_71208_1_;
    }

    public String func_71214_G()
    {
        return field_71293_J;
    }

    public void func_71224_l(String p_71224_1_)
    {
        field_71293_J = p_71224_1_;
    }

    public boolean func_71264_H()
    {
        return field_71293_J != null;
    }

    public String func_71270_I()
    {
        return field_71294_K;
    }

    public void func_71261_m(String p_71261_1_)
    {
        field_71294_K = p_71261_1_;
    }

    public void func_71253_a(KeyPair p_71253_1_)
    {
        field_71292_I = p_71253_1_;
    }

    public void func_71226_c(int p_71226_1_)
    {
        for(int i = 0; i < field_71305_c.length; i++)
        {
            WorldServer worldserver = field_71305_c[i];
            if(worldserver == null)
            {
                continue;
            }
            if(worldserver.func_72912_H().func_76093_s())
            {
                worldserver.field_73013_u = 3;
                worldserver.func_72891_a(true, true);
                continue;
            }
            if(func_71264_H())
            {
                worldserver.field_73013_u = p_71226_1_;
                worldserver.func_72891_a(worldserver.field_73013_u > 0, true);
            } else
            {
                worldserver.field_73013_u = p_71226_1_;
                worldserver.func_72891_a(func_71193_K(), field_71324_y);
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

    public void func_71204_b(boolean p_71204_1_)
    {
        field_71288_M = p_71204_1_;
    }

    public void func_71194_c(boolean p_71194_1_)
    {
        field_71289_N = p_71194_1_;
    }

    public ISaveFormat func_71254_M()
    {
        return field_71310_m;
    }

    public void func_71272_O()
    {
        field_71290_O = true;
        func_71254_M().func_75800_d();
        for(int i = 0; i < field_71305_c.length; i++)
        {
            WorldServer worldserver = field_71305_c[i];
            if(worldserver != null)
            {
                worldserver.func_73041_k();
            }
        }

        func_71254_M().func_75802_e(field_71305_c[0].func_72860_G().func_75760_g());
        func_71263_m();
    }

    public String func_71202_P()
    {
        return field_71297_P;
    }

    public void func_71269_o(String p_71269_1_)
    {
        field_71297_P = p_71269_1_;
    }

    public void func_70000_a(PlayerUsageSnooper p_70000_1_)
    {
        p_70000_1_.func_76472_a("whitelist_enabled", Boolean.valueOf(false));
        p_70000_1_.func_76472_a("whitelist_count", Integer.valueOf(0));
        p_70000_1_.func_76472_a("players_current", Integer.valueOf(func_71233_x()));
        p_70000_1_.func_76472_a("players_max", Integer.valueOf(func_71275_y()));
        p_70000_1_.func_76472_a("players_seen", Integer.valueOf(field_71318_t.func_72373_m().length));
        p_70000_1_.func_76472_a("uses_auth", Boolean.valueOf(field_71325_x));
        p_70000_1_.func_76472_a("gui_state", func_71279_ae() ? "enabled" : "disabled");
        p_70000_1_.func_76472_a("avg_tick_ms", Integer.valueOf((int)(MathHelper.func_76127_a(field_71311_j) * 9.9999999999999995E-007D)));
        p_70000_1_.func_76472_a("avg_sent_packet_count", Integer.valueOf((int)MathHelper.func_76127_a(field_71300_f)));
        p_70000_1_.func_76472_a("avg_sent_packet_size", Integer.valueOf((int)MathHelper.func_76127_a(field_71301_g)));
        p_70000_1_.func_76472_a("avg_rec_packet_count", Integer.valueOf((int)MathHelper.func_76127_a(field_71313_h)));
        p_70000_1_.func_76472_a("avg_rec_packet_size", Integer.valueOf((int)MathHelper.func_76127_a(field_71314_i)));
        int i = 0;
        for(int j = 0; j < field_71305_c.length; j++)
        {
            if(field_71305_c[j] != null)
            {
                WorldServer worldserver = field_71305_c[j];
                WorldInfo worldinfo = worldserver.func_72912_H();
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][dimension]").toString(), Integer.valueOf(worldserver.field_73011_w.field_76574_g));
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][mode]").toString(), worldinfo.func_76077_q());
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][difficulty]").toString(), Integer.valueOf(worldserver.field_73013_u));
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][hardcore]").toString(), Boolean.valueOf(worldinfo.func_76093_s()));
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][generator_name]").toString(), worldinfo.func_76067_t().func_77127_a());
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][generator_version]").toString(), Integer.valueOf(worldinfo.func_76067_t().func_77131_c()));
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][height]").toString(), Integer.valueOf(field_71280_D));
                p_70000_1_.func_76472_a((new StringBuilder()).append("world[").append(i).append("][chunks_loaded]").toString(), Integer.valueOf(worldserver.func_72863_F().func_73152_e()));
                i++;
            }
        }

        p_70000_1_.func_76472_a("worlds", Integer.valueOf(i));
    }

    public void func_70001_b(PlayerUsageSnooper p_70001_1_)
    {
        p_70001_1_.func_76472_a("singleplayer", Boolean.valueOf(func_71264_H()));
        p_70001_1_.func_76472_a("server_brand", getServerModName());
        p_70001_1_.func_76472_a("gui_supported", java.awt.GraphicsEnvironment.isHeadless() ? "headless" : "supported");
        p_70001_1_.func_76472_a("dedicated", Boolean.valueOf(func_71262_S()));
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
        return field_71325_x;
    }

    public void func_71229_d(boolean p_71229_1_)
    {
        field_71325_x = p_71229_1_;
    }

    public boolean func_71268_U()
    {
        return field_71324_y;
    }

    public void func_71251_e(boolean p_71251_1_)
    {
        field_71324_y = p_71251_1_;
    }

    public boolean func_71220_V()
    {
        return field_71323_z;
    }

    public void func_71257_f(boolean p_71257_1_)
    {
        field_71323_z = p_71257_1_;
    }

    public boolean func_71219_W()
    {
        return field_71284_A;
    }

    public void func_71188_g(boolean p_71188_1_)
    {
        field_71284_A = p_71188_1_;
    }

    public boolean func_71231_X()
    {
        return field_71285_B;
    }

    public void func_71245_h(boolean p_71245_1_)
    {
        field_71285_B = p_71245_1_;
    }

    public String func_71273_Y()
    {
        return field_71286_C;
    }

    public void func_71205_p(String p_71205_1_)
    {
        field_71286_C = p_71205_1_;
    }

    public int func_71207_Z()
    {
        return field_71280_D;
    }

    public void func_71191_d(int p_71191_1_)
    {
        field_71280_D = p_71191_1_;
    }

    public boolean func_71241_aa()
    {
        return field_71316_v;
    }

    public ServerConfigurationManager func_71203_ab()
    {
        return field_71318_t;
    }

    public void func_71210_a(ServerConfigurationManager p_71210_1_)
    {
        field_71318_t = p_71210_1_;
    }

    public void func_71235_a(EnumGameType p_71235_1_)
    {
        for(int i = 0; i < field_71305_c.length; i++)
        {
            func_71276_C().field_71305_c[i].func_72912_H().func_76060_a(p_71235_1_);
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
        return field_71315_w;
    }

    public void func_71223_ag()
    {
        field_71295_T = true;
    }

    public static ServerConfigurationManager func_71196_a(MinecraftServer p_71196_0_)
    {
        return p_71196_0_.field_71318_t;
    }

}
