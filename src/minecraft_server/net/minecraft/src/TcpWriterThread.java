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
            while (TcpConnection.func_74462_a(theTcpConnection))
            {
                boolean flag;

                for (flag = false; TcpConnection.func_74451_d(theTcpConnection); flag = true) { }

                try
                {
                    if (flag && TcpConnection.func_74453_e(theTcpConnection) != null)
                    {
                        TcpConnection.func_74453_e(theTcpConnection).flush();
                    }
                }
                catch (IOException ioexception)
                {
                    if (!TcpConnection.func_74456_f(theTcpConnection))
                    {
                        TcpConnection.func_74458_a(theTcpConnection, ioexception);
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
