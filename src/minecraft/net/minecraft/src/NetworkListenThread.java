package net.minecraft.src;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public abstract class NetworkListenThread
{
    public static Logger field_71751_a = Logger.getLogger("Minecraft");
    private final MinecraftServer field_71750_c;
    private final List connections = Collections.synchronizedList(new ArrayList());
    public volatile boolean field_71749_b;

    public NetworkListenThread(MinecraftServer par1MinecraftServer) throws IOException
    {
        field_71749_b = false;
        field_71750_c = par1MinecraftServer;
        field_71749_b = true;
    }

    public void func_71745_a(NetServerHandler par1NetServerHandler)
    {
        connections.add(par1NetServerHandler);
    }

    public void stopListening()
    {
        field_71749_b = false;
    }

    /**
     * processes packets and pending connections
     */
    public void networkTick()
    {
        for (int i = 0; i < connections.size(); i++)
        {
            NetServerHandler netserverhandler = (NetServerHandler)connections.get(i);

            try
            {
                netserverhandler.networkTick();
            }
            catch (Exception exception)
            {
                field_71751_a.log(Level.WARNING, (new StringBuilder()).append("Failed to handle packet: ").append(exception).toString(), exception);
                netserverhandler.kickPlayerFromServer("Internal server error");
            }

            if (netserverhandler.serverShuttingDown)
            {
                connections.remove(i--);
            }

            netserverhandler.theNetworkManager.wakeThreads();
        }
    }

    public MinecraftServer getServer()
    {
        return field_71750_c;
    }
}
