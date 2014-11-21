// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package net.minecraft.src:
//            HttpUtilRunnable, IDownloadSuccess, IProgressUpdate

public class HttpUtil
{

    public static String func_76179_a(Map p_76179_0_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = p_76179_0_.entrySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(stringbuilder.length() > 0)
            {
                stringbuilder.append('&');
            }
            try
            {
                stringbuilder.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
            }
            catch(UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
            }
            if(entry.getValue() != null)
            {
                stringbuilder.append('=');
                try
                {
                    stringbuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                }
                catch(UnsupportedEncodingException unsupportedencodingexception1)
                {
                    unsupportedencodingexception1.printStackTrace();
                }
            }
        } while(true);
        return stringbuilder.toString();
    }

    public static String func_76183_a(URL p_76183_0_, Map p_76183_1_, boolean p_76183_2_)
    {
        return func_76180_a(p_76183_0_, func_76179_a(p_76183_1_), p_76183_2_);
    }

    public static String func_76180_a(URL p_76180_0_, String p_76180_1_, boolean p_76180_2_)
    {
        try
        {
            HttpURLConnection httpurlconnection = (HttpURLConnection)p_76180_0_.openConnection();
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpurlconnection.setRequestProperty("Content-Length", (new StringBuilder()).append("").append(p_76180_1_.getBytes().length).toString());
            httpurlconnection.setRequestProperty("Content-Language", "en-US");
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            DataOutputStream dataoutputstream = new DataOutputStream(httpurlconnection.getOutputStream());
            dataoutputstream.writeBytes(p_76180_1_);
            dataoutputstream.flush();
            dataoutputstream.close();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
            StringBuffer stringbuffer = new StringBuffer();
            String s;
            while((s = bufferedreader.readLine()) != null) 
            {
                stringbuffer.append(s);
                stringbuffer.append('\r');
            }
            bufferedreader.close();
            return stringbuffer.toString();
        }
        catch(Exception exception)
        {
            if(!p_76180_2_)
            {
                Logger.getLogger("Minecraft").log(Level.SEVERE, (new StringBuilder()).append("Could not post to ").append(p_76180_0_).toString(), exception);
            }
        }
        return "";
    }

    public static void func_76182_a(File p_76182_0_, String p_76182_1_, IDownloadSuccess p_76182_2_, Map p_76182_3_, int p_76182_4_, IProgressUpdate p_76182_5_)
    {
        Thread thread = new Thread(new HttpUtilRunnable(p_76182_5_, p_76182_1_, p_76182_3_, p_76182_0_, p_76182_2_, p_76182_4_));
        thread.setDaemon(true);
        thread.start();
    }

    public static int func_76181_a()
        throws IOException
    {
        ServerSocket serversocket = null;
        int i = -1;
        try
        {
            serversocket = new ServerSocket(0);
            i = serversocket.getLocalPort();
        }
        finally
        {
            try
            {
                if(serversocket != null)
                {
                    serversocket.close();
                }
            }
            catch(IOException ioexception) { }
        }
        return i;
    }
}
