package net.minecraft.src;

class TcpMasterThread extends Thread
{
    final TcpConnection theTcpConnection;

    TcpMasterThread(TcpConnection par1TcpConnection)
    {
        theTcpConnection = par1TcpConnection;
    }

    public void run()
    {
        try
        {
            Thread.sleep(5000L);

            if (TcpConnection.getReadThread(theTcpConnection).isAlive())
            {
                try
                {
                    TcpConnection.getReadThread(theTcpConnection).stop();
                }
                catch (Throwable throwable) { }
            }

            if (TcpConnection.getWriteThread(theTcpConnection).isAlive())
            {
                try
                {
                    TcpConnection.getWriteThread(theTcpConnection).stop();
                }
                catch (Throwable throwable1) { }
            }
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }
}
