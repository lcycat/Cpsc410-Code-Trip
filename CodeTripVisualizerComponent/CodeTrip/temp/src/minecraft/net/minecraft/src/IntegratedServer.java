// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.logging.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            Session, WorldSettings, IntegratedPlayerList, ModLoader, 
//            IntegratedServerListenThread, WorldServer, ISaveFormat, ISaveHandler, 
//            DemoWorldServer, WorldServerMulti, WorldManager, ServerConfigurationManager, 
//            CryptManager, WorldInfo, GameSettings, CallableType3, 
//            CrashReport, CallableIsModded, ThreadLanServerPing, WorldType, 
//            EnumGameType, NetworkListenThread

public class IntegratedServer extends MinecraftServer
{

    private final Minecraft field_71349_l;
    private final WorldSettings field_71350_m;
    private IntegratedServerListenThread field_71347_n;
    private boolean field_71348_o;
    private boolean field_71346_p;
    private ThreadLanServerPing field_71345_q;

    public IntegratedServer(Minecraft p_i3118_1_, String p_i3118_2_, String p_i3118_3_, WorldSettings p_i3118_4_)
    {
        super(new File(Minecraft.func_71380_b(), "saves"));
        field_71348_o = false;
        func_71224_l(p_i3118_1_.field_71449_j.field_74286_b);
        func_71261_m(p_i3118_2_);
        func_71246_n(p_i3118_3_);
        func_71204_b(p_i3118_1_.func_71355_q());
        func_71194_c(p_i3118_4_.func_77167_c());
        func_71191_d(256);
        func_71210_a(new IntegratedPlayerList(this));
        field_71349_l = p_i3118_1_;
        field_71350_m = p_i3118_4_;
        ModLoader.registerCommands(this);
        try
        {
            field_71347_n = new IntegratedServerListenThread(this);
        }
        catch(IOException ioexception)
        {
            throw new Error();
        }
    }

    protected void func_71247_a(String p_71247_1_, String p_71247_2_, long p_71247_3_, WorldType p_71247_5_)
    {
        func_71237_c(p_71247_1_);
        field_71305_c = new WorldServer[3];
        field_71312_k = new long[field_71305_c.length][100];
        ISaveHandler isavehandler = func_71254_M().func_75804_a(p_71247_1_, true);
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
                    field_71305_c[i] = new WorldServer(this, isavehandler, p_71247_2_, byte0, field_71350_m, field_71304_b);
                }
            } else
            {
                field_71305_c[i] = new WorldServerMulti(this, isavehandler, p_71247_2_, byte0, field_71350_m, field_71305_c[0], field_71304_b);
            }
            field_71305_c[i].func_72954_a(new WorldManager(this, field_71305_c[i]));
            func_71203_ab().func_72364_a(field_71305_c);
        }

        func_71226_c(func_71232_g());
        func_71222_d();
    }

    protected boolean func_71197_b()
        throws IOException
    {
        field_71306_a.info("Starting integrated minecraft server version 1.3.1");
        func_71229_d(false);
        func_71251_e(true);
        func_71257_f(true);
        func_71188_g(true);
        func_71245_h(true);
        field_71306_a.info("Generating keypair");
        func_71253_a(CryptManager.func_75891_b());
        func_71247_a(func_71270_I(), func_71221_J(), field_71350_m.func_77160_d(), field_71350_m.func_77165_h());
        func_71205_p((new StringBuilder()).append(func_71214_G()).append(" - ").append(field_71305_c[0].func_72912_H().func_76065_j()).toString());
        return true;
    }

    public void func_71217_p()
    {
        boolean flag = field_71348_o;
        field_71348_o = field_71347_n.func_71752_f();
        if(!flag && field_71348_o)
        {
            field_71306_a.info("Saving and pausing game...");
            func_71203_ab().func_72389_g();
            func_71267_a(false);
        }
        if(!field_71348_o)
        {
            super.func_71217_p();
        }
    }

    public boolean func_71225_e()
    {
        return false;
    }

    public EnumGameType func_71265_f()
    {
        return field_71350_m.func_77162_e();
    }

    public int func_71232_g()
    {
        return field_71349_l.field_71474_y.field_74318_M;
    }

    public boolean func_71199_h()
    {
        return field_71350_m.func_77158_f();
    }

    protected File func_71238_n()
    {
        return field_71349_l.field_71412_D;
    }

    public boolean func_71262_S()
    {
        return false;
    }

    public IntegratedServerListenThread func_71343_a()
    {
        return field_71347_n;
    }

    protected void func_71228_a(CrashReport p_71228_1_)
    {
        field_71349_l.func_71404_a(p_71228_1_);
    }

    public CrashReport func_71230_b(CrashReport p_71230_1_)
    {
        p_71230_1_.func_71500_a("Type", new CallableType3(this));
        p_71230_1_.func_71500_a("Is Modded", new CallableIsModded(this));
        return super.func_71230_b(p_71230_1_);
    }

    public boolean func_70002_Q()
    {
        return Minecraft.func_71410_x().func_70002_Q();
    }

    public String func_71206_a(EnumGameType p_71206_1_, boolean p_71206_2_)
    {
        try
        {
            String s = field_71347_n.func_71755_c();
            System.out.println((new StringBuilder()).append("Started on ").append(s).toString());
            field_71346_p = true;
            field_71345_q = new ThreadLanServerPing(func_71273_Y(), s);
            field_71345_q.start();
            func_71203_ab().func_72357_a(p_71206_1_);
            func_71203_ab().func_72387_b(p_71206_2_);
            return s;
        }
        catch(IOException ioexception)
        {
            return null;
        }
    }

    public void func_71260_j()
    {
        super.func_71260_j();
        if(field_71345_q != null)
        {
            field_71345_q.interrupt();
            field_71345_q = null;
        }
    }

    public void func_71263_m()
    {
        super.func_71263_m();
        if(field_71345_q != null)
        {
            field_71345_q.interrupt();
            field_71345_q = null;
        }
    }

    public boolean func_71344_c()
    {
        return field_71346_p;
    }

    public void func_71235_a(EnumGameType p_71235_1_)
    {
        func_71203_ab().func_72357_a(p_71235_1_);
    }

    public NetworkListenThread func_71212_ac()
    {
        return func_71343_a();
    }
}
