// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

// Referenced classes of package net.minecraft.src:
//            ThreadDownloadImageData, ImageBuffer

class ThreadDownloadImage extends Thread
{

    final String field_78458_a; /* synthetic field */
    final ImageBuffer field_78456_b; /* synthetic field */
    final ThreadDownloadImageData field_78457_c; /* synthetic field */

    ThreadDownloadImage(ThreadDownloadImageData p_i3193_1_, String p_i3193_2_, ImageBuffer p_i3193_3_)
    {
        field_78457_c = p_i3193_1_;
        field_78458_a = p_i3193_2_;
        field_78456_b = p_i3193_3_;
        super();
    }

    public void run()
    {
        HttpURLConnection httpurlconnection = null;
        try
        {
            URL url = new URL(field_78458_a);
            httpurlconnection = (HttpURLConnection)url.openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(false);
            httpurlconnection.connect();
            if(httpurlconnection.getResponseCode() / 100 == 4)
            {
                return;
            }
            if(field_78456_b == null)
            {
                field_78457_c.field_78462_a = ImageIO.read(httpurlconnection.getInputStream());
            } else
            {
                field_78457_c.field_78462_a = field_78456_b.func_78432_a(ImageIO.read(httpurlconnection.getInputStream()));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            httpurlconnection.disconnect();
        }
    }
}
