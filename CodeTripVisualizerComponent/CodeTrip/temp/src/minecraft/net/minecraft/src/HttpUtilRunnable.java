// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

// Referenced classes of package net.minecraft.src:
//            IProgressUpdate, IDownloadSuccess

final class HttpUtilRunnable
    implements Runnable
{

    final IProgressUpdate field_76178_a; /* synthetic field */
    final String field_76176_b; /* synthetic field */
    final Map field_76177_c; /* synthetic field */
    final File field_76174_d; /* synthetic field */
    final IDownloadSuccess field_76175_e; /* synthetic field */
    final int field_76173_f; /* synthetic field */

    HttpUtilRunnable(IProgressUpdate p_i3418_1_, String p_i3418_2_, Map p_i3418_3_, File p_i3418_4_, IDownloadSuccess p_i3418_5_, int p_i3418_6_)
    {
        field_76178_a = p_i3418_1_;
        field_76176_b = p_i3418_2_;
        field_76177_c = p_i3418_3_;
        field_76174_d = p_i3418_4_;
        field_76175_e = p_i3418_5_;
        field_76173_f = p_i3418_6_;
        super();
    }

    public void run()
    {
        Object obj = null;
        InputStream inputstream = null;
        DataOutputStream dataoutputstream = null;
        if(field_76178_a != null)
        {
            field_76178_a.func_73721_b("Downloading Texture Pack");
            field_76178_a.func_73719_c("Making Request...");
        }
        try
        {
            byte abyte0[] = new byte[4096];
            URL url = new URL(field_76176_b);
            URLConnection urlconnection = url.openConnection();
            float f = 0.0F;
            float f1 = field_76177_c.entrySet().size();
            Iterator iterator = field_76177_c.entrySet().iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                urlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
                if(field_76178_a != null)
                {
                    field_76178_a.func_73718_a((int)((++f / f1) * 100F));
                }
            } while(true);
            inputstream = urlconnection.getInputStream();
            f1 = urlconnection.getContentLength();
            int i = urlconnection.getContentLength();
            if(field_76178_a != null)
            {
                field_76178_a.func_73719_c(String.format("Downloading file (%.2f MB)...", new Object[] {
                    Float.valueOf(f1 / 1000F / 1000F)
                }));
            }
            if(field_76174_d.exists())
            {
                long l = field_76174_d.length();
                if(l == (long)i)
                {
                    field_76175_e.func_76170_a(field_76174_d);
                    if(field_76178_a != null)
                    {
                        field_76178_a.func_73717_a();
                    }
                    return;
                }
                System.out.println((new StringBuilder()).append("Deleting ").append(field_76174_d).append(" as it does not match what we currently have (").append(i).append(" vs our ").append(l).append(").").toString());
                field_76174_d.delete();
            }
            dataoutputstream = new DataOutputStream(new FileOutputStream(field_76174_d));
            if(field_76173_f > 0 && f1 > (float)field_76173_f)
            {
                if(field_76178_a != null)
                {
                    field_76178_a.func_73717_a();
                }
                throw new IOException((new StringBuilder()).append("Filesize is bigger than maximum allowed (file is ").append(f).append(", limit is ").append(field_76173_f).append(")").toString());
            }
            for(int j = 0; (j = inputstream.read(abyte0)) >= 0;)
            {
                f += j;
                if(field_76178_a != null)
                {
                    field_76178_a.func_73718_a((int)((f / f1) * 100F));
                }
                if(field_76173_f > 0 && f > (float)field_76173_f)
                {
                    if(field_76178_a != null)
                    {
                        field_76178_a.func_73717_a();
                    }
                    throw new IOException((new StringBuilder()).append("Filesize was bigger than maximum allowed (got >= ").append(f).append(", limit was ").append(field_76173_f).append(")").toString());
                }
                dataoutputstream.write(abyte0, 0, j);
            }

            field_76175_e.func_76170_a(field_76174_d);
            if(field_76178_a != null)
            {
                field_76178_a.func_73717_a();
            }
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
        finally
        {
            try
            {
                if(inputstream != null)
                {
                    inputstream.close();
                }
            }
            catch(IOException ioexception) { }
            try
            {
                if(dataoutputstream != null)
                {
                    dataoutputstream.close();
                }
            }
            catch(IOException ioexception1) { }
        }
    }
}
