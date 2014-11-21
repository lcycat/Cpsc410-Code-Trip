package net.minecraft.src;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLanServerPing extends Thread
{
    private static Logger field_77530_a = Logger.getLogger("Minecraft");
    private final String motd;
    private final DatagramSocket field_77529_c = new DatagramSocket();
    private boolean isStopping;
    private final String address;

    public ThreadLanServerPing(String par1Str, String par2Str) throws IOException
    {
        super("LanServerPinger");
        isStopping = true;
        motd = par1Str;
        address = par2Str;
        setDaemon(true);
    }

    public void run()
    {
        String s = getPingResponse(motd, address);
        byte abyte0[] = s.getBytes();

        do
        {
            if (isInterrupted() || !isStopping)
            {
                break;
            }

            try
            {
                InetAddress inetaddress = InetAddress.getByName("224.0.2.60");
                DatagramPacket datagrampacket = new DatagramPacket(abyte0, abyte0.length, inetaddress, 4445);
                field_77529_c.send(datagrampacket);
            }
            catch (IOException ioexception)
            {
                field_77530_a.log(Level.WARNING, (new StringBuilder()).append("LanServerPinger: ").append(ioexception.getMessage()).toString());
                break;
            }

            try
            {
                sleep(1500L);
            }
            catch (InterruptedException interruptedexception) { }
        }
        while (true);
    }

    public void interrupt()
    {
        super.interrupt();
        isStopping = false;
    }

    public static String getPingResponse(String par0Str, String par1Str)
    {
        return (new StringBuilder()).append("[MOTD]").append(par0Str).append("[/MOTD][AD]").append(par1Str).append("[/AD]").toString();
    }

    public static String func_77524_a(String par0Str)
    {
        int i = par0Str.indexOf("[MOTD]");

        if (i < 0)
        {
            return "missing no";
        }

        int j = par0Str.indexOf("[/MOTD]", i + "[MOTD]".length());

        if (j < i)
        {
            return "missing no";
        }
        else
        {
            return par0Str.substring(i + "[MOTD]".length(), j);
        }
    }

    public static String func_77523_b(String par0Str)
    {
        int i = par0Str.indexOf("[/MOTD]");

        if (i < 0)
        {
            return null;
        }

        int j = par0Str.indexOf("[/MOTD]", i + "[/MOTD]".length());

        if (j >= 0)
        {
            return null;
        }

        int k = par0Str.indexOf("[AD]", i + "[/MOTD]".length());

        if (k < 0)
        {
            return null;
        }

        int l = par0Str.indexOf("[/AD]", k + "[AD]".length());

        if (l < k)
        {
            return null;
        }
        else
        {
            return par0Str.substring(k + "[AD]".length(), l);
        }
    }
}
