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

public class NetLoginHandler extends NetHandler
{
    private byte field_72536_d[];

    /** The Minecraft logger. */
    public static Logger logger = Logger.getLogger("Minecraft");

    /** The Random object used to generate serverId hex strings. */
    private static Random rand = new Random();
    public TcpConnection field_72538_b;

    /**
     * Returns if the login handler is finished and can be removed. It is set to true on either error or successful
     * login.
     */
    public boolean finishedProcessing;

    /** Reference to the MinecraftServer object. */
    private MinecraftServer mcServer;

    /** While waiting to login, if this field ++'s to 600 it will kick you. */
    private int loginTimer;
    private String field_72543_h;
    private volatile boolean field_72544_i;
    private String field_72541_j;
    private SecretKey field_72542_k;

    public NetLoginHandler(MinecraftServer par1MinecraftServer, Socket par2Socket, String par3Str) throws IOException
    {
        finishedProcessing = false;
        loginTimer = 0;
        field_72543_h = null;
        field_72544_i = false;
        field_72541_j = "";
        field_72542_k = null;
        mcServer = par1MinecraftServer;
        field_72538_b = new TcpConnection(par2Socket, par3Str, this, par1MinecraftServer.getKeyPair().getPrivate());
        field_72538_b.field_74468_e = 0;
    }

    /**
     * Logs the user in if a login packet is found, otherwise keeps processing network packets unless the timeout has
     * occurred.
     */
    public void tryLogin()
    {
        if (field_72544_i)
        {
            func_72529_d();
        }

        if (loginTimer++ == 600)
        {
            kickUser("Took too long to log in");
        }
        else
        {
            field_72538_b.processReadPackets();
        }
    }

    /**
     * Disconnects the user with the given reason.
     */
    public void kickUser(String par1Str)
    {
        try
        {
            logger.info((new StringBuilder()).append("Disconnecting ").append(func_72528_e()).append(": ").append(par1Str).toString());
            field_72538_b.addToSendQueue(new Packet255KickDisconnect(par1Str));
            field_72538_b.serverShutdown();
            finishedProcessing = true;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_72500_a(Packet2ClientProtocol par1Packet2ClientProtocol)
    {
        field_72543_h = par1Packet2ClientProtocol.getUsername();

        if (!field_72543_h.equals(StringUtils.stripControlCodes(field_72543_h)))
        {
            kickUser("Invalid username!");
        }
        else
        {
            PublicKey publickey = mcServer.getKeyPair().getPublic();

            if (par1Packet2ClientProtocol.getProtocolVersion() != 39)
            {
                if (par1Packet2ClientProtocol.getProtocolVersion() > 39)
                {
                    kickUser("Outdated server!");
                }
                else
                {
                    kickUser("Outdated client!");
                }
            }
            else
            {
                field_72541_j = mcServer.func_71266_T() ? Long.toString(rand.nextLong(), 16) : "-";
                field_72536_d = new byte[4];
                rand.nextBytes(field_72536_d);
                field_72538_b.addToSendQueue(new Packet253ServerAuthData(field_72541_j, publickey, field_72536_d));
            }
        }
    }

    public void func_72513_a(Packet252SharedKey par1Packet252SharedKey)
    {
        PrivateKey privatekey = mcServer.getKeyPair().getPrivate();
        field_72542_k = par1Packet252SharedKey.func_73303_a(privatekey);

        if (!Arrays.equals(field_72536_d, par1Packet252SharedKey.func_73302_b(privatekey)))
        {
            kickUser("Invalid client reply");
        }

        field_72538_b.addToSendQueue(new Packet252SharedKey());
    }

    public void func_72458_a(Packet205ClientCommand par1Packet205ClientCommand)
    {
        if (par1Packet205ClientCommand.field_73447_a == 0)
        {
            if (mcServer.func_71266_T())
            {
                (new ThreadLoginVerifier(this)).start();
            }
            else
            {
                field_72544_i = true;
            }
        }
    }

    public void handleLogin(Packet1Login packet1login)
    {
    }

    public void func_72529_d()
    {
        String s = mcServer.func_71203_ab().func_72399_a(field_72538_b.getRemoteAddress(), field_72543_h);

        if (s != null)
        {
            kickUser(s);
        }
        else
        {
            EntityPlayerMP entityplayermp = mcServer.func_71203_ab().func_72366_a(field_72543_h);

            if (entityplayermp != null)
            {
                mcServer.func_71203_ab().func_72355_a(field_72538_b, entityplayermp);
                ModLoaderMp.handleAllLogins(entityplayermp);
            }
        }

        finishedProcessing = true;
    }

    public void handleErrorMessage(String par1Str, Object par2ArrayOfObj[])
    {
        logger.info((new StringBuilder()).append(func_72528_e()).append(" lost connection").toString());
        finishedProcessing = true;
    }

    /**
     * Handle a server ping packet.
     */
    public void handleServerPing(Packet254ServerPing par1Packet254ServerPing)
    {
        try
        {
            String s = (new StringBuilder()).append(mcServer.func_71273_Y()).append("\247").append(mcServer.func_71203_ab().playersOnline()).append("\247").append(mcServer.func_71203_ab().getMaxPlayers()).toString();
            InetAddress inetaddress = null;

            if (field_72538_b.func_74452_g() != null)
            {
                inetaddress = field_72538_b.func_74452_g().getInetAddress();
            }

            field_72538_b.addToSendQueue(new Packet255KickDisconnect(s));
            field_72538_b.serverShutdown();

            if (inetaddress != null && (mcServer.func_71212_ac() instanceof DedicatedServerListenThread))
            {
                ((DedicatedServerListenThread)mcServer.func_71212_ac()).func_71761_a(inetaddress);
            }

            finishedProcessing = true;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void registerPacket(Packet par1Packet)
    {
        kickUser("Protocol error");
    }

    public String func_72528_e()
    {
        return field_72543_h == null ? field_72538_b.getRemoteAddress().toString() : (new StringBuilder()).append(field_72543_h).append(" [").append(field_72538_b.getRemoteAddress().toString()).append("]").toString();
    }

    /**
     * determine if it is a server handler
     */
    public boolean isServerHandler()
    {
        return true;
    }

    /**
     * Returns the server Id randomly generated by this login handler.
     */
    static String getServerId(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.field_72541_j;
    }

    static MinecraftServer func_72530_b(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.mcServer;
    }

    static SecretKey func_72525_c(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.field_72542_k;
    }

    static String func_72533_d(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.field_72543_h;
    }

    static boolean func_72531_a(NetLoginHandler par0NetLoginHandler, boolean par1)
    {
        return par0NetLoginHandler.field_72544_i = par1;
    }
}
