// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*;

// Referenced classes of package net.minecraft.src:
//            LanServerList

public class ThreadLanServerFind extends Thread
{

    private final LanServerList field_77500_a;
    private final InetAddress field_77498_b = InetAddress.getByName("224.0.2.60");
    private final MulticastSocket field_77499_c = new MulticastSocket(4445);

    public ThreadLanServerFind(LanServerList p_i3122_1_)
        throws IOException
    {
        super("LanServerDetector");
        field_77500_a = p_i3122_1_;
        setDaemon(true);
        field_77499_c.setSoTimeout(5000);
        field_77499_c.joinGroup(field_77498_b);
    }

    public void run()
    {
        byte abyte0[] = new byte[1024];
        do
        {
            if(isInterrupted())
            {
                break;
            }
            DatagramPacket datagrampacket = new DatagramPacket(abyte0, abyte0.length);
            try
            {
                field_77499_c.receive(datagrampacket);
            }
            catch(SocketTimeoutException sockettimeoutexception)
            {
                continue;
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
                break;
            }
            String s = new String(datagrampacket.getData(), datagrampacket.getOffset(), datagrampacket.getLength());
            System.out.println((new StringBuilder()).append(datagrampacket.getAddress()).append(": ").append(s).toString());
            field_77500_a.func_77551_a(s, datagrampacket.getAddress());
        } while(true);
        try
        {
            field_77499_c.leaveGroup(field_77498_b);
        }
        catch(IOException ioexception1) { }
        field_77499_c.close();
    }
}
