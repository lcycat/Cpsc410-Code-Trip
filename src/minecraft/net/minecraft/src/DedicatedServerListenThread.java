package net.minecraft.src;

import java.io.IOException;
import java.net.InetAddress;
import net.minecraft.server.MinecraftServer;

public class DedicatedServerListenThread extends NetworkListenThread
{
    private final ServerListenThread field_71763_c;

    public DedicatedServerListenThread(MinecraftServer par1MinecraftServer, InetAddress par2InetAddress, int par3) throws IOException
    {
        super(par1MinecraftServer);
        field_71763_c = new ServerListenThread(this, par2InetAddress, par3);
        field_71763_c.start();
    }

    public void stopListening()
    {
        super.stopListening();
        field_71763_c.func_71768_b();
        field_71763_c.interrupt();
    }

    /**
     * processes packets and pending connections
     */
    public void networkTick()
    {
        field_71763_c.processPendingConnections();
        super.networkTick();
    }

    public DedicatedServer func_71762_c()
    {
        return (DedicatedServer)super.getServer();
    }

    public void func_71761_a(InetAddress par1InetAddress)
    {
        field_71763_c.func_71769_a(par1InetAddress);
    }

    public MinecraftServer getServer()
    {
        return func_71762_c();
    }
}
