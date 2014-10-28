package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

final class ServerWindowAdapter extends WindowAdapter
{
    /** The Minecraft instance. */
    final DedicatedServer mc;

    ServerWindowAdapter(DedicatedServer par1DedicatedServer)
    {
        mc = par1DedicatedServer;
    }

    public void windowClosing(WindowEvent par1WindowEvent)
    {
        mc.initiateShutdown();

        while (!mc.func_71241_aa())
        {
            try
            {
                Thread.sleep(100L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }

        System.exit(0);
    }
}
