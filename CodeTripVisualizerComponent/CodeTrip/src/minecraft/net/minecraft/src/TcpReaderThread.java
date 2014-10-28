package net.minecraft.src;

import java.util.concurrent.atomic.AtomicInteger;

class TcpReaderThread extends Thread
{
    final TcpConnection theTcpConnection;

    TcpReaderThread(TcpConnection par1TcpConnection, String par2Str)
    {
        super(par2Str);
        theTcpConnection = par1TcpConnection;
    }

    public void run()
    {
        TcpConnection.field_74471_a.getAndIncrement();

        try
        {
            while (TcpConnection.isRunning(theTcpConnection) && !TcpConnection.isServerTerminating(theTcpConnection))
            {
                while (TcpConnection.readNetworkPacket(theTcpConnection)) ;

                try
                {
                    sleep(2L);
                }
                catch (InterruptedException interruptedexception) { }
            }
        }
        finally
        {
            TcpConnection.field_74471_a.getAndDecrement();
        }
    }
}
