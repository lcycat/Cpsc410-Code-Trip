package net.minecraft.src;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyPair;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import net.minecraft.server.MinecraftServer;

public class NetLoginHandler extends NetHandler
{
    private byte field_72536_d[];
    public static Logger field_72540_a = Logger.getLogger("Minecraft");
    private static Random field_72537_e = new Random();
    public TcpConnection myTCPConnection;
    public boolean connectionComplete;
    private MinecraftServer minecraftInstance;
    private int connectionTimer;
    private String clientUsername;
    private volatile boolean field_72544_i;
    private String field_72541_j;
    private SecretKey field_72542_k;

    public NetLoginHandler(MinecraftServer par1MinecraftServer, Socket par2Socket, String par3Str) throws IOException
    {
        connectionComplete = false;
        connectionTimer = 0;
        clientUsername = null;
        field_72544_i = false;
        field_72541_j = "";
        field_72542_k = null;
        minecraftInstance = par1MinecraftServer;
        myTCPConnection = new TcpConnection(par2Socket, par3Str, this, par1MinecraftServer.getKeyPair().getPrivate());
        myTCPConnection.field_74468_e = 0;
    }

    /**
     * Logs the user in if a login packet is found, otherwise keeps processing network packets unless the timeout has
     * occurred.
     */
    public void tryLogin()
    {
        if (field_72544_i)
        {
            initializePlayerConnection();
        }

        if (connectionTimer++ == 600)
        {
            raiseErrorAndDisconnect("Took too long to log in");
        }
        else
        {
            myTCPConnection.processReadPackets();
        }
    }

    public void raiseErrorAndDisconnect(String par1Str)
    {
        try
        {
            field_72540_a.info((new StringBuilder()).append("Disconnecting ").append(getUsernameAndAddress()).append(": ").append(par1Str).toString());
            myTCPConnection.addToSendQueue(new Packet255KickDisconnect(par1Str));
            myTCPConnection.serverShutdown();
            connectionComplete = true;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void handleClientProtocol(Packet2ClientProtocol par1Packet2ClientProtocol)
    {
        clientUsername = par1Packet2ClientProtocol.getUsername();

        if (!clientUsername.equals(StringUtils.stripControlCodes(clientUsername)))
        {
            raiseErrorAndDisconnect("Invalid username!");
            return;
        }

        java.security.PublicKey publickey = minecraftInstance.getKeyPair().getPublic();

        if (par1Packet2ClientProtocol.getProtocolVersion() != 39)
        {
            if (par1Packet2ClientProtocol.getProtocolVersion() > 39)
            {
                raiseErrorAndDisconnect("Outdated server!");
            }
            else
            {
                raiseErrorAndDisconnect("Outdated client!");
            }

            return;
        }
        else
        {
            field_72541_j = minecraftInstance.isServerInOnlineMode() ? Long.toString(field_72537_e.nextLong(), 16) : "-";
            field_72536_d = new byte[4];
            field_72537_e.nextBytes(field_72536_d);
            myTCPConnection.addToSendQueue(new Packet253ServerAuthData(field_72541_j, publickey, field_72536_d));
            return;
        }
    }

    public void handleSharedKey(Packet252SharedKey par1Packet252SharedKey)
    {
        java.security.PrivateKey privatekey = minecraftInstance.getKeyPair().getPrivate();
        field_72542_k = par1Packet252SharedKey.func_73303_a(privatekey);

        if (!Arrays.equals(field_72536_d, par1Packet252SharedKey.func_73302_b(privatekey)))
        {
            raiseErrorAndDisconnect("Invalid client reply");
        }

        myTCPConnection.addToSendQueue(new Packet252SharedKey());
    }

    public void handleClientCommand(Packet205ClientCommand par1Packet205ClientCommand)
    {
        if (par1Packet205ClientCommand.forceRespawn == 0)
        {
            if (minecraftInstance.isServerInOnlineMode())
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

    /**
     * on success the specified username is connected to the minecraftInstance, otherwise they are packet255'd
     */
    public void initializePlayerConnection()
    {
        String s = minecraftInstance.getConfigurationManager().allowUserToConnect(myTCPConnection.getSocketAddress(), clientUsername);

        if (s != null)
        {
            raiseErrorAndDisconnect(s);
        }
        else
        {
            EntityPlayerMP entityplayermp = minecraftInstance.getConfigurationManager().createPlayerForUser(clientUsername);

            if (entityplayermp != null)
            {
                minecraftInstance.getConfigurationManager().initializeConnectionToPlayer(myTCPConnection, entityplayermp);
            }
        }

        connectionComplete = true;
    }

    public void handleErrorMessage(String par1Str, Object par2ArrayOfObj[])
    {
        field_72540_a.info((new StringBuilder()).append(getUsernameAndAddress()).append(" lost connection").toString());
        connectionComplete = true;
    }

    /**
     * Handle a server ping packet.
     */
    public void handleServerPing(Packet254ServerPing par1Packet254ServerPing)
    {
        try
        {
            String s = (new StringBuilder()).append(minecraftInstance.getMOTD()).append("\247").append(minecraftInstance.getConfigurationManager().getPlayerListSize()).append("\247").append(minecraftInstance.getConfigurationManager().getMaxPlayers()).toString();
            java.net.InetAddress inetaddress = null;

            if (myTCPConnection.getSocket() != null)
            {
                inetaddress = myTCPConnection.getSocket().getInetAddress();
            }

            myTCPConnection.addToSendQueue(new Packet255KickDisconnect(s));
            myTCPConnection.serverShutdown();

            if (inetaddress != null && (minecraftInstance.getNetworkThread() instanceof DedicatedServerListenThread))
            {
                ((DedicatedServerListenThread)minecraftInstance.getNetworkThread()).func_71761_a(inetaddress);
            }

            connectionComplete = true;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void registerPacket(Packet par1Packet)
    {
        raiseErrorAndDisconnect("Protocol error");
    }

    public String getUsernameAndAddress()
    {
        if (clientUsername != null)
        {
            return (new StringBuilder()).append(clientUsername).append(" [").append(myTCPConnection.getSocketAddress().toString()).append("]").toString();
        }
        else
        {
            return myTCPConnection.getSocketAddress().toString();
        }
    }

    /**
     * determine if it is a server handler
     */
    public boolean isServerHandler()
    {
        return true;
    }

    static String func_72526_a(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.field_72541_j;
    }

    static MinecraftServer func_72530_b(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.minecraftInstance;
    }

    static SecretKey func_72525_c(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.field_72542_k;
    }

    static String func_72533_d(NetLoginHandler par0NetLoginHandler)
    {
        return par0NetLoginHandler.clientUsername;
    }

    static boolean func_72531_a(NetLoginHandler par0NetLoginHandler, boolean par1)
    {
        return par0NetLoginHandler.field_72544_i = par1;
    }
}
