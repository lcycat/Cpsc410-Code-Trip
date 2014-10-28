package net.minecraft.src;

import java.io.*;

class DedicatedServerCommandThread extends Thread
{
    final DedicatedServer server;

    DedicatedServerCommandThread(DedicatedServer par1DedicatedServer)
    {
        server = par1DedicatedServer;
    }

    public void run()
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String s;

            for (; !server.isServerStopped() && server.isServerRunning() && (s = bufferedreader.readLine()) != null; server.addPendingCommand(s, server)) { }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }
}
