// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.*;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            NetHandler, TcpConnection, Packet255KickDisconnect, Packet2ClientProtocol, 
//            StringUtils, Packet253ServerAuthData, Packet252SharedKey, Packet205ClientCommand, 
//            ThreadLoginVerifier, ServerConfigurationManager, ModLoaderMp, DedicatedServerListenThread, 
//            Packet254ServerPing, Packet1Login, Packet

public class NetLoginHandler extends NetHandler
{

    private byte field_72536_d[];
    public static Logger field_72540_a = Logger.getLogger("Minecraft");
    private static Random field_72537_e = new Random();
    public TcpConnection field_72538_b;
    public boolean field_72539_c;
    private MinecraftServer field_72534_f;
    private int field_72535_g;
    private String field_72543_h;
    private volatile boolean field_72544_i;
    private String field_72541_j;
    private SecretKey field_72542_k;

    public NetLoginHandler(MinecraftServer p_i3400_1_, Socket p_i3400_2_, String p_i3400_3_)
        throws IOException
    {
        field_72539_c = false;
        field_72535_g = 0;
        field_72543_h = null;
        field_72544_i = false;
        field_72541_j = "";
        field_72542_k = null;
        field_72534_f = p_i3400_1_;
        field_72538_b = new TcpConnection(p_i3400_2_, p_i3400_3_, this, p_i3400_1_.func_71250_E().getPrivate());
        field_72538_b.field_74468_e = 0;
    }

    public void func_72532_c()
    {
        if(field_72544_i)
        {
            func_72529_d();
        }
        if(field_72535_g++ == 600)
        {
            func_72527_a("Took too long to log in");
        } else
        {
            field_72538_b.func_74428_b();
        }
    }

    public void func_72527_a(String p_72527_1_)
    {
        try
        {
            field_72540_a.info((new StringBuilder()).append("Disconnecting ").append(func_72528_e()).append(": ").append(p_72527_1_).toString());
            field_72538_b.func_74429_a(new Packet255KickDisconnect(p_72527_1_));
            field_72538_b.func_74423_d();
            field_72539_c = true;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_72500_a(Packet2ClientProtocol p_72500_1_)
    {
        field_72543_h = p_72500_1_.func_73454_f();
        if(!field_72543_h.equals(StringUtils.func_76338_a(field_72543_h)))
        {
            func_72527_a("Invalid username!");
        } else
        {
            PublicKey publickey = field_72534_f.func_71250_E().getPublic();
            if(p_72500_1_.func_73453_d() != 39)
            {
                if(p_72500_1_.func_73453_d() > 39)
                {
                    func_72527_a("Outdated server!");
                } else
                {
                    func_72527_a("Outdated client!");
                }
            } else
            {
                field_72541_j = field_72534_f.func_71266_T() ? Long.toString(field_72537_e.nextLong(), 16) : "-";
                field_72536_d = new byte[4];
                field_72537_e.nextBytes(field_72536_d);
                field_72538_b.func_74429_a(new Packet253ServerAuthData(field_72541_j, publickey, field_72536_d));
            }
        }
    }

    public void func_72513_a(Packet252SharedKey p_72513_1_)
    {
        PrivateKey privatekey = field_72534_f.func_71250_E().getPrivate();
        field_72542_k = p_72513_1_.func_73303_a(privatekey);
        if(!Arrays.equals(field_72536_d, p_72513_1_.func_73302_b(privatekey)))
        {
            func_72527_a("Invalid client reply");
        }
        field_72538_b.func_74429_a(new Packet252SharedKey());
    }

    public void func_72458_a(Packet205ClientCommand p_72458_1_)
    {
        if(p_72458_1_.field_73447_a == 0)
        {
            if(field_72534_f.func_71266_T())
            {
                (new ThreadLoginVerifier(this)).start();
            } else
            {
                field_72544_i = true;
            }
        }
    }

    public void func_72455_a(Packet1Login packet1login)
    {
    }

    public void func_72529_d()
    {
        String s = field_72534_f.func_71203_ab().func_72399_a(field_72538_b.func_74430_c(), field_72543_h);
        if(s != null)
        {
            func_72527_a(s);
        } else
        {
            EntityPlayerMP entityplayermp = field_72534_f.func_71203_ab().func_72366_a(field_72543_h);
            if(entityplayermp != null)
            {
                field_72534_f.func_71203_ab().func_72355_a(field_72538_b, entityplayermp);
                ModLoaderMp.handleAllLogins(entityplayermp);
            }
        }
        field_72539_c = true;
    }

    public void func_72515_a(String p_72515_1_, Object p_72515_2_[])
    {
        field_72540_a.info((new StringBuilder()).append(func_72528_e()).append(" lost connection").toString());
        field_72539_c = true;
    }

    public void func_72467_a(Packet254ServerPing p_72467_1_)
    {
        try
        {
            String s = (new StringBuilder()).append(field_72534_f.func_71273_Y()).append("\247").append(field_72534_f.func_71203_ab().func_72394_k()).append("\247").append(field_72534_f.func_71203_ab().func_72352_l()).toString();
            InetAddress inetaddress = null;
            if(field_72538_b.func_74452_g() != null)
            {
                inetaddress = field_72538_b.func_74452_g().getInetAddress();
            }
            field_72538_b.func_74429_a(new Packet255KickDisconnect(s));
            field_72538_b.func_74423_d();
            if(inetaddress != null && (field_72534_f.func_71212_ac() instanceof DedicatedServerListenThread))
            {
                ((DedicatedServerListenThread)field_72534_f.func_71212_ac()).func_71761_a(inetaddress);
            }
            field_72539_c = true;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_72509_a(Packet p_72509_1_)
    {
        func_72527_a("Protocol error");
    }

    public String func_72528_e()
    {
        return field_72543_h == null ? field_72538_b.func_74430_c().toString() : (new StringBuilder()).append(field_72543_h).append(" [").append(field_72538_b.func_74430_c().toString()).append("]").toString();
    }

    public boolean func_72489_a()
    {
        return true;
    }

    static String func_72526_a(NetLoginHandler p_72526_0_)
    {
        return p_72526_0_.field_72541_j;
    }

    static MinecraftServer func_72530_b(NetLoginHandler p_72530_0_)
    {
        return p_72530_0_.field_72534_f;
    }

    static SecretKey func_72525_c(NetLoginHandler p_72525_0_)
    {
        return p_72525_0_.field_72542_k;
    }

    static String func_72533_d(NetLoginHandler p_72533_0_)
    {
        return p_72533_0_.field_72543_h;
    }

    static boolean func_72531_a(NetLoginHandler p_72531_0_, boolean p_72531_1_)
    {
        return p_72531_0_.field_72544_i = p_72531_1_;
    }

}
