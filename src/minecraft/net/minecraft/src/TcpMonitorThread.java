package net.minecraft.src;

class TcpMonitorThread extends Thread
{
    final TcpConnection theTcpConnection;

    TcpMonitorThread(TcpConnection par1TcpConnection)
    {
        theTcpConnection = par1TcpConnection;
    }

    public void run()
    {
        try
        {
            Thread.sleep(2000L);

            if (TcpConnection.isRunning(theTcpConnection))
            {
                TcpConnection.getWriteThread(theTcpConnection).interrupt();
                theTcpConnection.networkShutdown("disconnect.closed", new Object[0]);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
