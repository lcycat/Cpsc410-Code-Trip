package net.minecraft.src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerListenThread extends Thread
{
    private static Logger minecraftLogger = Logger.getLogger("Minecraft");
    private final List pendingConnections = Collections.synchronizedList(new ArrayList());
    private final HashMap field_71776_c = new HashMap();
    private int connectionCounter;
    private final ServerSocket myServerSocket;
    private NetworkListenThread myNetworkListenThread;
    private final InetAddress myServerAddress;
    private final int myPort;

    public ServerListenThread(NetworkListenThread par1NetworkListenThread, InetAddress par2InetAddress, int par3) throws IOException
    {
        super("Listen thread");
        connectionCounter = 0;
        myNetworkListenThread = par1NetworkListenThread;
        myServerAddress = par2InetAddress;
        myPort = par3;
        myServerSocket = new ServerSocket(par3, 0, par2InetAddress);
        myServerSocket.setPerformancePreferences(0, 2, 1);
    }

    public void processPendingConnections()
    {
        synchronized (pendingConnections)
        {
            for (int i = 0; i < pendingConnections.size(); i++)
            {
                NetLoginHandler netloginhandler = (NetLoginHandler)pendingConnections.get(i);

                try
                {
                    netloginhandler.tryLogin();
                }
                catch (Exception exception)
                {
                    netloginhandler.raiseErrorAndDisconnect("Internal server error");
                    minecraftLogger.log(Level.WARNING, (new StringBuilder()).append("Failed to handle packet: ").append(exception).toString(), exception);
                }

                if (netloginhandler.connectionComplete)
                {
                    pendingConnections.remove(i--);
                }

                netloginhandler.myTCPConnection.wakeThreads();
            }
        }
    }

    public void run()
    {
        do
        {
            if (!myNetworkListenThread.field_71749_b)
            {
                break;
            }

            try
            {
                Socket socket = myServerSocket.accept();
                InetAddress inetaddress = socket.getInetAddress();
                long l = System.currentTimeMillis();

                synchronized (field_71776_c)
                {
                    if (field_71776_c.containsKey(inetaddress) && !isLocalHost(inetaddress) && l - ((Long)field_71776_c.get(inetaddress)).longValue() < 4000L)
                    {
                        field_71776_c.put(inetaddress, Long.valueOf(l));
                        socket.close();
                        continue;
                    }

                    field_71776_c.put(inetaddress, Long.valueOf(l));
                }

                NetLoginHandler netloginhandler = new NetLoginHandler(myNetworkListenThread.getServer(), socket, (new StringBuilder()).append("Connection #").append(connectionCounter++).toString());
                addPendingConnection(netloginhandler);
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        while (true);

        System.out.println("Closing listening thread");
    }

    private void addPendingConnection(NetLoginHandler par1NetLoginHandler)
    {
        if (par1NetLoginHandler == null)
        {
            throw new IllegalArgumentException("Got null pendingconnection!");
        }

        synchronized (pendingConnections)
        {
            pendingConnections.add(par1NetLoginHandler);
        }
    }

    private static boolean isLocalHost(InetAddress par0InetAddress)
    {
        return "127.0.0.1".equals(par0InetAddress.getHostAddress());
    }

    public void func_71769_a(InetAddress par1InetAddress)
    {
        if (par1InetAddress != null)
        {
            synchronized (field_71776_c)
            {
                field_71776_c.remove(par1InetAddress);
            }
        }
    }

    public void func_71768_b()
    {
        try
        {
            myServerSocket.close();
        }
        catch (Throwable throwable) { }
    }

    public InetAddress getInetAddress()
    {
        return myServerAddress;
    }

    public int func_71765_d()
    {
        return myPort;
    }
}
