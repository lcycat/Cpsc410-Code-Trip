package net.minecraft.src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.*;

public class MemoryConnection implements NetworkManager
{
    private static final SocketAddress mySocketAddress = new InetSocketAddress("127.0.0.1", 0);
    private final List readPacketCache = Collections.synchronizedList(new ArrayList());
    private MemoryConnection pairedConnection;
    private NetHandler myNetHandler;

    /** set to true by {server,network}Shutdown */
    private boolean shuttingDown;
    private String shutdownReason;
    private Object field_74439_g[];
    private boolean gamePaused;

    public MemoryConnection(NetHandler par1NetHandler) throws IOException
    {
        shuttingDown = false;
        shutdownReason = "";
        gamePaused = false;
        myNetHandler = par1NetHandler;
    }

    public void setNetHandler(NetHandler par1NetHandler)
    {
        myNetHandler = par1NetHandler;
    }

    /**
     * Adds the packet to the correct send queue (chunk data packets go to a separate queue).
     */
    public void addToSendQueue(Packet par1Packet)
    {
        if (shuttingDown)
        {
            return;
        }
        else
        {
            pairedConnection.processOrCachePacket(par1Packet);
            return;
        }
    }

    public void closeConnections()
    {
        pairedConnection = null;
        myNetHandler = null;
    }

    public boolean isConnectionActive()
    {
        return !shuttingDown && pairedConnection != null;
    }

    /**
     * Wakes reader and writer threads
     */
    public void wakeThreads()
    {
    }

    /**
     * Checks timeouts and processes all pending read packets.
     */
    public void processReadPackets()
    {
        int i;
        Packet packet;

        for (i = 2500; i-- >= 0 && !readPacketCache.isEmpty(); packet.processPacket(myNetHandler))
        {
            packet = (Packet)readPacketCache.remove(0);
        }

        if (readPacketCache.size() > i)
        {
            System.out.println((new StringBuilder()).append("Memory connection overburdened; after processing 2500 packets, we still have ").append(readPacketCache.size()).append(" to go!").toString());
        }

        if (shuttingDown && readPacketCache.isEmpty())
        {
            myNetHandler.handleErrorMessage(shutdownReason, field_74439_g);
        }
    }

    /**
     * Return the InetSocketAddress of the remote endpoint
     */
    public SocketAddress getSocketAddress()
    {
        return mySocketAddress;
    }

    /**
     * Shuts down the server. (Only actually used on the server)
     */
    public void serverShutdown()
    {
        shuttingDown = true;
    }

    /**
     * Shuts down the network with the specified reason. Closes all streams and sockets, spawns NetworkMasterThread to
     * stop reading and writing threads.
     */
    public void networkShutdown(String par1Str, Object par2ArrayOfObj[])
    {
        shuttingDown = true;
        shutdownReason = par1Str;
        field_74439_g = par2ArrayOfObj;
    }

    /**
     * returns 0 for memoryConnections
     */
    public int packetSize()
    {
        return 0;
    }

    public void pairWith(MemoryConnection par1MemoryConnection)
    {
        pairedConnection = par1MemoryConnection;
        par1MemoryConnection.pairedConnection = this;
    }

    public boolean isGamePaused()
    {
        return gamePaused;
    }

    public void setGamePaused(boolean par1)
    {
        gamePaused = par1;
    }

    public MemoryConnection getPairedConnection()
    {
        return pairedConnection;
    }

    /**
     * acts immiditally if isWritePacket, otherwise adds it to the readCache to be processed next tick
     */
    public void processOrCachePacket(Packet par1Packet)
    {
        if (par1Packet.isWritePacket() && myNetHandler.canProcessPackets())
        {
            par1Packet.processPacket(myNetHandler);
        }
        else
        {
            readPacketCache.add(par1Packet);
        }
    }
}
