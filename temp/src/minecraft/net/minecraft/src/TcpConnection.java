// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.security.PrivateKey;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;

// Referenced classes of package net.minecraft.src:
//            NetworkManager, TcpReaderThread, TcpWriterThread, Packet, 
//            Packet252SharedKey, NetHandler, TcpMasterThread, TcpMonitorThread, 
//            CryptManager

public class TcpConnection
    implements NetworkManager
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

    public TcpConnection(Socket p_i3287_1_, String p_i3287_2_, NetHandler p_i3287_3_)
        throws IOException
    {
        this(p_i3287_1_, p_i3287_2_, p_i3287_3_, null);
    }

    public TcpConnection(Socket p_i3288_1_, String p_i3288_2_, NetHandler p_i3288_3_, PrivateKey p_i3288_4_)
        throws IOException
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
        field_74463_A = p_i3288_4_;
        field_74479_i = p_i3288_1_;
        field_74476_j = p_i3288_1_.getRemoteSocketAddress();
        field_74485_r = p_i3288_3_;
        try
        {
            p_i3288_1_.setSoTimeout(30000);
            p_i3288_1_.setTrafficClass(24);
        }
        catch(SocketException socketexception)
        {
            System.err.println(socketexception.getMessage());
        }
        field_74477_k = new DataInputStream(p_i3288_1_.getInputStream());
        field_74474_l = new DataOutputStream(new BufferedOutputStream(p_i3288_1_.getOutputStream(), 5120));
        field_74482_u = new TcpReaderThread(this, (new StringBuilder()).append(p_i3288_2_).append(" read thread").toString());
        field_74483_t = new TcpWriterThread(this, (new StringBuilder()).append(p_i3288_2_).append(" write thread").toString());
        field_74482_u.start();
        field_74483_t.start();
    }

    public void func_74431_f()
    {
        func_74427_a();
        field_74483_t = null;
        field_74482_u = null;
    }

    public void func_74425_a(NetHandler p_74425_1_)
    {
        field_74485_r = p_74425_1_;
    }

    public void func_74429_a(Packet p_74429_1_)
    {
        if(field_74484_s)
        {
            return;
        }
        synchronized(field_74478_h)
        {
            field_74489_y += p_74429_1_.func_73284_a() + 1;
            if(p_74429_1_.field_73287_r)
            {
                field_74486_q.add(p_74429_1_);
            } else
            {
                field_74487_p.add(p_74429_1_);
            }
        }
    }

    private boolean func_74459_h()
    {
        boolean flag = false;
        try
        {
            if(field_74468_e == 0 || System.currentTimeMillis() - ((Packet)field_74487_p.get(0)).field_73295_m >= (long)field_74468_e)
            {
                Packet packet = func_74460_a(false);
                if(packet != null)
                {
                    Packet.func_73266_a(packet, field_74474_l);
                    if((packet instanceof Packet252SharedKey) && !field_74466_g)
                    {
                        if(!field_74485_r.func_72489_a())
                        {
                            field_74488_z = ((Packet252SharedKey)packet).func_73304_d();
                        }
                        func_74446_k();
                    }
                    field_74467_d[packet.func_73281_k()] += packet.func_73284_a() + 1;
                    flag = true;
                }
            }
            if(field_74464_B-- <= 0 && (field_74468_e == 0 || System.currentTimeMillis() - ((Packet)field_74486_q.get(0)).field_73295_m >= (long)field_74468_e))
            {
                Packet packet1 = func_74460_a(true);
                if(packet1 != null)
                {
                    Packet.func_73266_a(packet1, field_74474_l);
                    field_74467_d[packet1.func_73281_k()] += packet1.func_73284_a() + 1;
                    field_74464_B = 0;
                    flag = true;
                }
            }
        }
        catch(Exception exception)
        {
            if(!field_74472_n)
            {
                func_74455_a(exception);
            }
            return false;
        }
        return flag;
    }

    private Packet func_74460_a(boolean p_74460_1_)
    {
        Packet packet = null;
        List list = p_74460_1_ ? field_74486_q : field_74487_p;
        synchronized(field_74478_h)
        {
            do
            {
                if(list.isEmpty() || packet != null)
                {
                    break;
                }
                packet = (Packet)list.remove(0);
                field_74489_y -= packet.func_73284_a() + 1;
                if(func_74454_a(packet, p_74460_1_))
                {
                    packet = null;
                }
            } while(true);
        }
        return packet;
    }

    private boolean func_74454_a(Packet p_74454_1_, boolean p_74454_2_)
    {
        if(!p_74454_1_.func_73278_e())
        {
            return false;
        }
        List list = p_74454_2_ ? field_74486_q : field_74487_p;
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Packet packet = (Packet)iterator.next();
            if(packet.func_73281_k() == p_74454_1_.func_73281_k())
            {
                return p_74454_1_.func_73268_a(packet);
            }
        }

        return false;
    }

    public void func_74427_a()
    {
        if(field_74482_u != null)
        {
            field_74482_u.interrupt();
        }
        if(field_74483_t != null)
        {
            field_74483_t.interrupt();
        }
    }

    private boolean func_74447_i()
    {
        boolean flag = false;
        try
        {
            Packet packet = Packet.func_73272_a(field_74477_k, field_74485_r.func_72489_a());
            if(packet != null)
            {
                if((packet instanceof Packet252SharedKey) && !field_74465_f)
                {
                    if(field_74485_r.func_72489_a())
                    {
                        field_74488_z = ((Packet252SharedKey)packet).func_73303_a(field_74463_A);
                    }
                    func_74448_j();
                }
                field_74470_c[packet.func_73281_k()] += packet.func_73284_a() + 1;
                if(!field_74484_s)
                {
                    if(packet.func_73277_a_() && field_74485_r.func_72469_b())
                    {
                        field_74490_x = 0;
                        packet.func_73279_a(field_74485_r);
                    } else
                    {
                        field_74473_o.add(packet);
                    }
                }
                flag = true;
            } else
            {
                func_74424_a("disconnect.endOfStream", new Object[0]);
            }
        }
        catch(Exception exception)
        {
            if(!field_74472_n)
            {
                func_74455_a(exception);
            }
            return false;
        }
        return flag;
    }

    private void func_74455_a(Exception p_74455_1_)
    {
        p_74455_1_.printStackTrace();
        func_74424_a("disconnect.genericReason", new Object[] {
            (new StringBuilder()).append("Internal exception: ").append(p_74455_1_.toString()).toString()
        });
    }

    public void func_74424_a(String p_74424_1_, Object p_74424_2_[])
    {
        if(!field_74475_m)
        {
            return;
        }
        field_74472_n = true;
        field_74481_v = p_74424_1_;
        field_74480_w = p_74424_2_;
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
        catch(Throwable throwable) { }
    }

    public void func_74428_b()
    {
        if(field_74489_y > 0x200000)
        {
            func_74424_a("disconnect.overflow", new Object[0]);
        }
        if(field_74473_o.isEmpty())
        {
            if(field_74490_x++ == 1200)
            {
                func_74424_a("disconnect.timeout", new Object[0]);
            }
        } else
        {
            field_74490_x = 0;
        }
        Packet packet;
        for(int i = 1000; !field_74473_o.isEmpty() && i-- >= 0; packet.func_73279_a(field_74485_r))
        {
            packet = (Packet)field_74473_o.remove(0);
        }

        func_74427_a();
        if(field_74472_n && field_74473_o.isEmpty())
        {
            field_74485_r.func_72515_a(field_74481_v, field_74480_w);
        }
    }

    public SocketAddress func_74430_c()
    {
        return field_74476_j;
    }

    public void func_74423_d()
    {
        if(field_74484_s)
        {
            return;
        } else
        {
            func_74427_a();
            field_74484_s = true;
            field_74482_u.interrupt();
            (new TcpMonitorThread(this)).start();
            return;
        }
    }

    private void func_74448_j()
        throws IOException
    {
        field_74465_f = true;
        field_74477_k = new DataInputStream(CryptManager.func_75888_a(field_74488_z, field_74479_i.getInputStream()));
    }

    private void func_74446_k()
        throws IOException
    {
        field_74474_l.flush();
        field_74466_g = true;
        field_74474_l = new DataOutputStream(new BufferedOutputStream(CryptManager.func_75897_a(field_74488_z, field_74479_i.getOutputStream()), 5120));
    }

    public int func_74426_e()
    {
        return field_74486_q.size();
    }

    public Socket func_74452_g()
    {
        return field_74479_i;
    }

    static boolean func_74462_a(TcpConnection p_74462_0_)
    {
        return p_74462_0_.field_74475_m;
    }

    static boolean func_74449_b(TcpConnection p_74449_0_)
    {
        return p_74449_0_.field_74484_s;
    }

    static boolean func_74450_c(TcpConnection p_74450_0_)
    {
        return p_74450_0_.func_74447_i();
    }

    static boolean func_74451_d(TcpConnection p_74451_0_)
    {
        return p_74451_0_.func_74459_h();
    }

    static DataOutputStream func_74453_e(TcpConnection p_74453_0_)
    {
        return p_74453_0_.field_74474_l;
    }

    static boolean func_74456_f(TcpConnection p_74456_0_)
    {
        return p_74456_0_.field_74472_n;
    }

    static void func_74458_a(TcpConnection p_74458_0_, Exception p_74458_1_)
    {
        p_74458_0_.func_74455_a(p_74458_1_);
    }

    static Thread func_74457_g(TcpConnection p_74457_0_)
    {
        return p_74457_0_.field_74482_u;
    }

    static Thread func_74461_h(TcpConnection p_74461_0_)
    {
        return p_74461_0_.field_74483_t;
    }

}
