package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyPair;
import net.minecraft.server.MinecraftServer;

class ThreadLoginVerifier extends Thread
{
    /** The login handler that spawned this thread. */
    final NetLoginHandler loginHandler;

    ThreadLoginVerifier(NetLoginHandler par1NetLoginHandler)
    {
        loginHandler = par1NetLoginHandler;
    }

    public void run()
    {
        try
        {
            String s = (new BigInteger(CryptManager.func_75895_a(NetLoginHandler.getServerId(loginHandler), NetLoginHandler.func_72530_b(loginHandler).getKeyPair().getPublic(), NetLoginHandler.func_72525_c(loginHandler)))).toString(16);
            URL url = new URL((new StringBuilder()).append("http://session.minecraft.net/game/checkserver.jsp?user=").append(URLEncoder.encode(NetLoginHandler.func_72533_d(loginHandler), "UTF-8")).append("&serverId=").append(URLEncoder.encode(s, "UTF-8")).toString());
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
            String s1 = bufferedreader.readLine();
            bufferedreader.close();

            if (!"YES".equals(s1))
            {
                loginHandler.kickUser("Failed to verify username!");
                return;
            }

            NetLoginHandler.func_72531_a(loginHandler, true);
        }
        catch (Exception exception)
        {
            loginHandler.kickUser((new StringBuilder()).append("Failed to verify username! [internal error ").append(exception).append("]").toString());
            exception.printStackTrace();
        }
    }
}
