package net.minecraft.src;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class TcpWriterThread extends Thread
{
    final TcpConnection theTcpConnection;

    TcpWriterThread(TcpConnection par1TcpConnection, String par2Str)
    {
        super(par2Str);
        theTcpConnection = par1TcpConnection;
    }

    public void run()
    {
        TcpConnection.field_74469_b.getAndIncrement();

        try
        {
            while (TcpConnection.isRunning(theTcpConnection))
            {
                boolean flag;

                for (flag = false; TcpConnection.sendNetworkPacket(theTcpConnection); flag = true) { }

                try
                {
                    if (flag && TcpConnection.getOutputStream(theTcpConnection) != null)
                    {
                        TcpConnection.getOutputStream(theTcpConnection).flush();
                    }
                }
                catch (IOException ioexception)
                {
                    if (!TcpConnection.isTerminating(theTcpConnection))
                    {
                        TcpConnection.sendError(theTcpConnection, ioexception);
                    }

                    ioexception.printStackTrace();
                }

                try
                {
                    sleep(2L);
                }
                catch (InterruptedException interruptedexception) { }
            }
        }
        finally
        {
            TcpConnection.field_74469_b.getAndDecrement();
        }
    }
}
