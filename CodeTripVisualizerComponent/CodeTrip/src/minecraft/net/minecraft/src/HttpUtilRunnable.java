package net.minecraft.src;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

final class HttpUtilRunnable implements Runnable
{
    final IProgressUpdate feedbackHook;
    final String sourceURL;
    final Map field_76177_c;
    final File destinationFile;
    final IDownloadSuccess field_76175_e;
    final int field_76173_f;

    HttpUtilRunnable(IProgressUpdate par1IProgressUpdate, String par2Str, Map par3Map, File par4File, IDownloadSuccess par5IDownloadSuccess, int par6)
    {
        feedbackHook = par1IProgressUpdate;
        sourceURL = par2Str;
        field_76177_c = par3Map;
        destinationFile = par4File;
        field_76175_e = par5IDownloadSuccess;
        field_76173_f = par6;
    }

    public void run()
    {
        Object obj = null;
        InputStream inputstream = null;
        DataOutputStream dataoutputstream = null;

        if (feedbackHook != null)
        {
            feedbackHook.resetProgressAndMessage("Downloading Texture Pack");
            feedbackHook.resetProgresAndWorkingMessage("Making Request...");
        }

        try
        {
            byte abyte0[] = new byte[4096];
            URL url = new URL(sourceURL);
            URLConnection urlconnection = url.openConnection();
            float f = 0.0F;
            float f1 = field_76177_c.entrySet().size();
            Iterator iterator = field_76177_c.entrySet().iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                urlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue());

                if (feedbackHook != null)
                {
                    feedbackHook.setLoadingProgress((int)((++f / f1) * 100F));
                }
            }
            while (true);

            inputstream = urlconnection.getInputStream();
            f1 = urlconnection.getContentLength();
            int i = urlconnection.getContentLength();

            if (feedbackHook != null)
            {
                feedbackHook.resetProgresAndWorkingMessage(String.format("Downloading file (%.2f MB)...", new Object[]
                        {
                            Float.valueOf(f1 / 1000F / 1000F)
                        }));
            }

            if (destinationFile.exists())
            {
                long l = destinationFile.length();

                if (l == (long)i)
                {
                    field_76175_e.onSuccess(destinationFile);

                    if (feedbackHook != null)
                    {
                        feedbackHook.onNoMoreProgress();
                    }

                    return;
                }

                System.out.println((new StringBuilder()).append("Deleting ").append(destinationFile).append(" as it does not match what we currently have (").append(i).append(" vs our ").append(l).append(").").toString());
                destinationFile.delete();
            }

            dataoutputstream = new DataOutputStream(new FileOutputStream(destinationFile));

            if (field_76173_f > 0 && f1 > (float)field_76173_f)
            {
                if (feedbackHook != null)
                {
                    feedbackHook.onNoMoreProgress();
                }

                throw new IOException((new StringBuilder()).append("Filesize is bigger than maximum allowed (file is ").append(f).append(", limit is ").append(field_76173_f).append(")").toString());
            }

            for (int j = 0; (j = inputstream.read(abyte0)) >= 0;)
            {
                f += j;

                if (feedbackHook != null)
                {
                    feedbackHook.setLoadingProgress((int)((f / f1) * 100F));
                }

                if (field_76173_f > 0 && f > (float)field_76173_f)
                {
                    if (feedbackHook != null)
                    {
                        feedbackHook.onNoMoreProgress();
                    }

                    throw new IOException((new StringBuilder()).append("Filesize was bigger than maximum allowed (got >= ").append(f).append(", limit was ").append(field_76173_f).append(")").toString());
                }

                dataoutputstream.write(abyte0, 0, j);
            }

            field_76175_e.onSuccess(destinationFile);

            if (feedbackHook != null)
            {
                feedbackHook.onNoMoreProgress();
            }
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        finally
        {
            try
            {
                if (inputstream != null)
                {
                    inputstream.close();
                }
            }
            catch (IOException ioexception) { }

            try
            {
                if (dataoutputstream != null)
                {
                    dataoutputstream.close();
                }
            }
            catch (IOException ioexception1) { }
        }
    }
}
