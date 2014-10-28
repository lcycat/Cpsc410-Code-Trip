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
            while (TcpConnection.func_74462_a(theTcpConnection) && !TcpConnection.func_74449_b(theTcpConnection))
            {
                while (TcpConnection.func_74450_c(theTcpConnection)) ;

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
