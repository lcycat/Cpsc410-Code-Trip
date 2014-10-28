package net.minecraft.src;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public abstract class NetworkListenThread
{
    /** Reference to the logger. */
    public static Logger logger = Logger.getLogger("Minecraft");

    /** Reference to the MinecraftServer object. */
    private final MinecraftServer mcServer;
    private final List connections = Collections.synchronizedList(new ArrayList());

    /** Whether the network listener object is listening. */
    public volatile boolean isListening;

    public NetworkListenThread(MinecraftServer par1MinecraftServer) throws IOException
    {
        isListening = false;
        mcServer = par1MinecraftServer;
        isListening = true;
    }

    /**
     * adds this connection to the list of currently connected players
     */
    public void addPlayer(NetServerHandler par1NetServerHandler)
    {
        connections.add(par1NetServerHandler);
    }

    public void stopListening()
    {
        isListening = false;
    }

    /**
     * Handles all incoming connections and packets
     */
    public void handleNetworkListenThread()
    {
        for (int i = 0; i < connections.size(); i++)
        {
            NetServerHandler netserverhandler = (NetServerHandler)connections.get(i);

            try
            {
                netserverhandler.handlePackets();
            }
            catch (Exception exception)
            {
                logger.log(Level.WARNING, (new StringBuilder()).append("Failed to handle packet: ").append(exception).toString(), exception);
                netserverhandler.kickPlayer("Internal server error");
            }

            if (netserverhandler.connectionClosed)
            {
                connections.remove(i--);
            }

            netserverhandler.netManager.func_74427_a();
        }
    }

    public MinecraftServer getServer()
    {
        return mcServer;
    }
}
