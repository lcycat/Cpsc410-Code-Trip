package net.minecraft.src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import net.minecraft.server.MinecraftServer;

public class IntegratedServerListenThread extends NetworkListenThread
{
    private final MemoryConnection field_71760_c = new MemoryConnection(null);
    private MemoryConnection field_71758_d;
    private String field_71759_e;
    private boolean field_71756_f;
    private ServerListenThread myServerListenThread;

    public IntegratedServerListenThread(IntegratedServer par1IntegratedServer) throws IOException
    {
        super(par1IntegratedServer);
        field_71756_f = false;
    }

    public void func_71754_a(MemoryConnection par1MemoryConnection, String par2Str)
    {
        field_71758_d = par1MemoryConnection;
        field_71759_e = par2Str;
    }

    public String func_71755_c() throws IOException
    {
        if (myServerListenThread == null)
        {
            int i = -1;

            try
            {
                i = HttpUtil.func_76181_a();
            }
            catch (IOException ioexception) { }

            if (i <= 0)
            {
                i = 25564;
            }

            try
            {
                myServerListenThread = new ServerListenThread(this, InetAddress.getLocalHost(), i);
                myServerListenThread.start();
            }
            catch (IOException ioexception1)
            {
                throw ioexception1;
            }
        }

        return (new StringBuilder()).append(myServerListenThread.getInetAddress().getHostAddress()).append(":").append(myServerListenThread.func_71765_d()).toString();
    }

    public void stopListening()
    {
        super.stopListening();

        if (myServerListenThread != null)
        {
            System.out.println("Stopping server connection");
            myServerListenThread.func_71768_b();
            myServerListenThread.interrupt();
            myServerListenThread = null;
        }
    }

    /**
     * processes packets and pending connections
     */
    public void networkTick()
    {
        if (field_71758_d != null)
        {
            EntityPlayerMP entityplayermp = func_71753_e().getConfigurationManager().createPlayerForUser(field_71759_e);

            if (entityplayermp != null)
            {
                field_71760_c.pairWith(field_71758_d);
                field_71756_f = true;
                func_71753_e().getConfigurationManager().initializeConnectionToPlayer(field_71760_c, entityplayermp);
            }

            field_71758_d = null;
            field_71759_e = null;
        }

        if (myServerListenThread != null)
        {
            myServerListenThread.processPendingConnections();
        }

        super.networkTick();
    }

    public IntegratedServer func_71753_e()
    {
        return (IntegratedServer)super.getServer();
    }

    public boolean func_71752_f()
    {
        return field_71756_f && field_71760_c.getPairedConnection().isConnectionActive() && field_71760_c.getPairedConnection().isGamePaused();
    }

    public MinecraftServer getServer()
    {
        return func_71753_e();
    }
}
