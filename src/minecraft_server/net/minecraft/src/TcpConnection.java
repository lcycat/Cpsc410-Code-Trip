package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.security.PrivateKey;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;

public class TcpConnection implements NetworkManager
{
    public static AtomicInteger field_74471_a = new AtomicInteger();
    public static AtomicInteger field_74469_b = new AtomicInteger();
    private Object field_74478_h;
    private Socket field_74479_i;
    private final SocketAddress field_74476_j;
    private volatile DataInputStream field_74477_k;
    private volatile DataOutputStream field_74474_l;
    private volatile boolean field_74475_m;
    private volatile boolean field_74472_n;
    private List field_74473_o;
    private List field_74487_p;
    private List field_74486_q;
    private NetHandler field_74485_r;
    private boolean field_74484_s;
    private Thread field_74483_t;
    private Thread field_74482_u;
    private String field_74481_v;
    private Object field_74480_w[];
    private int field_74490_x;
    private int field_74489_y;
    public static int field_74470_c[] = new int[256];
    public static int field_74467_d[] = new int[256];
    public int field_74468_e;
    boolean field_74465_f;
    boolean field_74466_g;
    private SecretKey field_74488_z;
    private PrivateKey field_74463_A;
    private int field_74464_B;

    public TcpConnection(Socket par1Socket, String par2Str, NetHandler par3NetHandler, PrivateKey par4PrivateKey) throws IOException
    {
        field_74478_h = new Object();
        field_74475_m = true;
        field_74472_n = false;
        field_74473_o = Collections.synchronizedList(new ArrayList());
        field_74487_p = Collections.synchronizedList(new ArrayList());
        field_74486_q = Collections.synchronizedList(new ArrayList());
        field_74484_s = false;
        field_74481_v = "";
        field_74490_x = 0;
        field_74489_y = 0;
        field_74468_e = 0;
        field_74465_f = false;
        field_74466_g = false;
        field_74488_z = null;
        field_74463_A = null;
        field_74464_B = 50;
        field_74463_A = par4PrivateKey;
        field_74479_i = par1Socket;
        field_74476_j = par1Socket.getRemoteSocketAddress();
        field_74485_r = par3NetHandler;

        try
        {
            par1Socket.setSoTimeout(30000);
            par1Socket.setTrafficClass(24);
        }
        catch (SocketException socketexception)
        {
            System.err.println(socketexception.getMessage());
        }

        field_74477_k = new DataInputStream(par1Socket.getInputStream());
        field_74474_l = new DataOutputStream(new BufferedOutputStream(par1Socket.getOutputStream(), 5120));
        field_74482_u = new TcpReaderThread(this, (new StringBuilder()).append(par2Str).append(" read thread").toString());
        field_74483_t = new TcpWriterThread(this, (new StringBuilder()).append(par2Str).append(" write thread").toString());
        field_74482_u.start();
        field_74483_t.start();
    }

    /**
     * Sets the NetHandler for this NetworkManager. Server-only.
     */
    public void setNetHandler(NetHandler par1NetHandler)
    {
        field_74485_r = par1NetHandler;
    }

    /**
     * Adds the packet to the correct send queue (chunk data packets go to a separate queue).
     */
    public void addToSendQueue(Packet par1Packet)
    {
        if (field_74484_s)
        {
            return;
        }

        synchronized (field_74478_h)
        {
            field_74489_y += par1Packet.getPacketSize() + 1;

            if (par1Packet.isChunkDataPacket)
            {
                field_74486_q.add(par1Packet);
            }
            else
            {
                field_74487_p.add(par1Packet);
            }
        }
    }

    private boolean func_74459_h()
    {
        boolean flag = false;

        try
        {
            if (field_74468_e == 0 || System.currentTimeMillis() - ((Packet)field_74487_p.get(0)).creationTimeMillis >= (long)field_74468_e)
            {
                Packet packet = func_74460_a(false);

                if (packet != null)
                {
                    Packet.writePacket(packet, field_74474_l);

                    if ((packet instanceof Packet252SharedKey) && !field_74466_g)
                    {
                        if (!field_74485_r.isServerHandler())
                        {
                            field_74488_z = ((Packet252SharedKey)packet).func_73304_d();
                        }

                        func_74446_k();
                    }

                    field_74467_d[packet.getPacketId()] += packet.getPacketSize() + 1;
                    flag = true;
                }
            }

            if (field_74464_B-- <= 0 && (field_74468_e == 0 || System.currentTimeMillis() - ((Packet)field_74486_q.get(0)).creationTimeMillis >= (long)field_74468_e))
            {
                Packet packet1 = func_74460_a(true);

                if (packet1 != null)
                {
                    Packet.writePacket(packet1, field_74474_l);
                    field_74467_d[packet1.getPacketId()] += packet1.getPacketSize() + 1;
                    field_74464_B = 0;
                    flag = true;
                }
            }
        }
        catch (Exception exception)
        {
            if (!field_74472_n)
            {
                func_74455_a(exception);
            }

            return false;
        }

        return flag;
    }

    private Packet func_74460_a(boolean par1)
    {
        Packet packet = null;
        List list = par1 ? field_74486_q : field_74487_p;

        synchronized (field_74478_h)
        {
            do
            {
                if (list.isEmpty() || packet != null)
                {
                    break;
                }

                packet = (Packet)list.remove(0);
                field_74489_y -= packet.getPacketSize() + 1;

                if (func_74454_a(packet, par1))
                {
                    packet = null;
                }
            }
            while (true);
        }

        return packet;
    }

    private boolean func_74454_a(Packet par1Packet, boolean par2)
    {
        if (!par1Packet.func_73278_e())
        {
            return false;
        }

        List list = par2 ? field_74486_q : field_74487_p;

        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Packet packet = (Packet)iterator.next();

            if (packet.getPacketId() == par1Packet.getPacketId())
            {
                return par1Packet.func_73268_a(packet);
            }
        }

        return false;
    }

    public void func_74427_a()
    {
        if (field_74482_u != null)
        {
            field_74482_u.interrupt();
        }

        if (field_74483_t != null)
        {
            field_74483_t.interrupt();
        }
    }

    private boolean func_74447_i()
    {
        boolean flag = false;

        try
        {
            Packet packet = Packet.readPacket(field_74477_k, field_74485_r.isServerHandler());

            if (packet != null)
            {
                if ((packet instanceof Packet252SharedKey) && !field_74465_f)
                {
                    if (field_74485_r.isServerHandler())
                    {
                        field_74488_z = ((Packet252SharedKey)packet).func_73303_a(field_74463_A);
                    }

                    func_74448_j();
                }

                field_74470_c[packet.getPacketId()] += packet.getPacketSize() + 1;

                if (!field_74484_s)
                {
                    if (packet.func_73277_a_() && field_74485_r.func_72469_b())
                    {
                        field_74490_x = 0;
                        packet.processPacket(field_74485_r);
                    }
                    else
                    {
                        field_74473_o.add(packet);
                    }
                }

                flag = true;
            }
            else
            {
                networkShutdown("disconnect.endOfStream", new Object[0]);
            }
        }
        catch (Exception exception)
        {
            if (!field_74472_n)
            {
                func_74455_a(exception);
            }

            return false;
        }

        return flag;
    }

    private void func_74455_a(Exception par1Exception)
    {
        par1Exception.printStackTrace();
        networkShutdown("disconnect.genericReason", new Object[]
                {
                    (new StringBuilder()).append("Internal exception: ").append(par1Exception.toString()).toString()
                });
    }

    /**
     * Shuts down the network with the specified reason. Closes all streams and sockets, spawns NetworkMasterThread to
     * stop reading and writing threads.
     */
    public void networkShutdown(String par1Str, Object par2ArrayOfObj[])
    {
        if (!field_74475_m)
        {
            return;
        }

        field_74472_n = true;
        field_74481_v = par1Str;
        field_74480_w = par2ArrayOfObj;
        field_74475_m = false;
        (new TcpMasterThread(this)).start();

        try
        {
            field_74477_k.close();
            field_74477_k = null;
            field_74474_l.close();
            field_74474_l = null;
            field_74479_i.close();
            field_74479_i = null;
        }
        catch (Throwable throwable) { }
    }

    /**
     * Checks timeouts and processes all pending read packets.
     */
    public void processReadPackets()
    {
        if (field_74489_y > 0x200000)
        {
            networkShutdown("disconnect.overflow", new Object[0]);
        }

        if (field_74473_o.isEmpty())
        {
            if (field_74490_x++ == 1200)
            {
                networkShutdown("disconnect.timeout", new Object[0]);
            }
        }
        else
        {
            field_74490_x = 0;
        }

        Packet packet;

        for (int i = 1000; !field_74473_o.isEmpty() && i-- >= 0; packet.processPacket(field_74485_r))
        {
            packet = (Packet)field_74473_o.remove(0);
        }

        func_74427_a();

        if (field_74472_n && field_74473_o.isEmpty())
        {
            field_74485_r.handleErrorMessage(field_74481_v, field_74480_w);
        }
    }

    /**
     * Returns the socket address of the remote side. Server-only.
     */
    public SocketAddress getRemoteAddress()
    {
        return field_74476_j;
    }

    /**
     * Shuts down the server. (Only actually used on the server)
     */
    public void serverShutdown()
    {
        if (field_74484_s)
        {
            return;
        }
        else
        {
            func_74427_a();
            field_74484_s = true;
            field_74482_u.interrupt();
            (new TcpMonitorThread(this)).start();
            return;
        }
    }

    private void func_74448_j() throws IOException
    {
        field_74465_f = true;
        field_74477_k = new DataInputStream(CryptManager.func_75888_a(field_74488_z, field_74479_i.getInputStream()));
    }

    private void func_74446_k() throws IOException
    {
        field_74474_l.flush();
        field_74466_g = true;
        field_74474_l = new DataOutputStream(new BufferedOutputStream(CryptManager.func_75897_a(field_74488_z, field_74479_i.getOutputStream()), 5120));
    }

    /**
     * Returns the number of chunk data packets waiting to be sent.
     */
    public int getNumChunkDataPackets()
    {
        return field_74486_q.size();
    }

    public Socket func_74452_g()
    {
        return field_74479_i;
    }

    static boolean func_74462_a(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.field_74475_m;
    }

    static boolean func_74449_b(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.field_74484_s;
    }

    static boolean func_74450_c(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.func_74447_i();
    }

    static boolean func_74451_d(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.func_74459_h();
    }

    static DataOutputStream func_74453_e(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.field_74474_l;
    }

    static boolean func_74456_f(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.field_74472_n;
    }

    static void func_74458_a(TcpConnection par0TcpConnection, Exception par1Exception)
    {
        par0TcpConnection.func_74455_a(par1Exception);
    }

    static Thread func_74457_g(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.field_74482_u;
    }

    static Thread func_74461_h(TcpConnection par0TcpConnection)
    {
        return par0TcpConnection.field_74483_t;
    }
}
