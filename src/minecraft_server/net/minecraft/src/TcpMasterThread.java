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

            if (TcpConnection.func_74457_g(theTcpConnection).isAlive())
            {
                try
                {
                    TcpConnection.func_74457_g(theTcpConnection).stop();
                }
                catch (Throwable throwable) { }
            }

            if (TcpConnection.func_74461_h(theTcpConnection).isAlive())
            {
                try
                {
                    TcpConnection.func_74461_h(theTcpConnection).stop();
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
