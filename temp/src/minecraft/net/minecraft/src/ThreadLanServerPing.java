// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLanServerPing extends Thread
{

    private static Logger field_77530_a = Logger.getLogger("Minecraft");
    private final String field_77528_b;
    private final DatagramSocket field_77529_c = new DatagramSocket();
    private boolean field_77526_d;
    private final String field_77527_e;

    public ThreadLanServerPing(String p_i3124_1_, String p_i3124_2_)
        throws IOException
    {
        super("LanServerPinger");
        field_77526_d = true;
        field_77528_b = p_i3124_1_;
        field_77527_e = p_i3124_2_;
        setDaemon(true);
    }

    public void run()
    {
        String s = func_77525_a(field_77528_b, field_77527_e);
        byte abyte0[] = s.getBytes();
        do
        {
            if(isInterrupted() || !field_77526_d)
            {
                break;
            }
            try
            {
                InetAddress inetaddress = InetAddress.getByName("224.0.2.60");
                DatagramPacket datagrampacket = new DatagramPacket(abyte0, abyte0.length, inetaddress, 4445);
                field_77529_c.send(datagrampacket);
            }
            catch(IOException ioexception)
            {
                field_77530_a.log(Level.WARNING, (new StringBuilder()).append("LanServerPinger: ").append(ioexception.getMessage()).toString());
                break;
            }
            try
            {
                sleep(1500L);
            }
            catch(InterruptedException interruptedexception) { }
        } while(true);
    }

    public void interrupt()
    {
        super.interrupt();
        field_77526_d = false;
    }

    public static String func_77525_a(String p_77525_0_, String p_77525_1_)
    {
        return (new StringBuilder()).append("[MOTD]").append(p_77525_0_).append("[/MOTD][AD]").append(p_77525_1_).append("[/AD]").toString();
    }

    public static String func_77524_a(String p_77524_0_)
    {
        int i = p_77524_0_.indexOf("[MOTD]");
        if(i < 0)
        {
            return "missing no";
        }
        int j = p_77524_0_.indexOf("[/MOTD]", i + "[MOTD]".length());
        if(j < i)
        {
            return "missing no";
        } else
        {
            return p_77524_0_.substring(i + "[MOTD]".length(), j);
        }
    }

    public static String func_77523_b(String p_77523_0_)
    {
        int i = p_77523_0_.indexOf("[/MOTD]");
        if(i < 0)
        {
            return null;
        }
        int j = p_77523_0_.indexOf("[/MOTD]", i + "[/MOTD]".length());
        if(j >= 0)
        {
            return null;
        }
        int k = p_77523_0_.indexOf("[AD]", i + "[/MOTD]".length());
        if(k < 0)
        {
            return null;
        }
        int l = p_77523_0_.indexOf("[/AD]", k + "[AD]".length());
        if(l < k)
        {
            return null;
        } else
        {
            return p_77523_0_.substring(k + "[AD]".length(), l);
        }
    }

}
