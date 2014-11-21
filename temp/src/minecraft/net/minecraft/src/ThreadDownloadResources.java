// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.*;

public class ThreadDownloadResources extends Thread
{

    public File field_74579_a;
    private Minecraft field_74577_b;
    private boolean field_74578_c;

    public ThreadDownloadResources(File p_i3000_1_, Minecraft p_i3000_2_)
    {
        field_74578_c = false;
        field_74577_b = p_i3000_2_;
        setName("Resource download thread");
        setDaemon(true);
        field_74579_a = new File(p_i3000_1_, "resources/");
        if(!field_74579_a.exists() && !field_74579_a.mkdirs())
        {
            throw new RuntimeException((new StringBuilder()).append("The working directory could not be created: ").append(field_74579_a).toString());
        } else
        {
            return;
        }
    }

    public void run()
    {
        try
        {
            URL url = new URL("http://s3.amazonaws.com/MinecraftResources/");
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            Document document = documentbuilder.parse(url.openStream());
            NodeList nodelist = document.getElementsByTagName("Contents");
            for(int i = 0; i < 2; i++)
            {
                for(int j = 0; j < nodelist.getLength(); j++)
                {
                    Node node = nodelist.item(j);
                    if(node.getNodeType() != 1)
                    {
                        continue;
                    }
                    Element element = (Element)node;
                    String s = element.getElementsByTagName("Key").item(0).getChildNodes().item(0).getNodeValue();
                    long l = Long.parseLong(element.getElementsByTagName("Size").item(0).getChildNodes().item(0).getNodeValue());
                    if(l <= 0L)
                    {
                        continue;
                    }
                    func_74575_a(url, s, l, i);
                    if(field_74578_c)
                    {
                        return;
                    }
                }

            }

        }
        catch(Exception exception)
        {
            func_74576_a(field_74579_a, "");
            exception.printStackTrace();
        }
    }

    public void func_74573_a()
    {
        func_74576_a(field_74579_a, "");
    }

    private void func_74576_a(File p_74576_1_, String p_74576_2_)
    {
        File afile[] = p_74576_1_.listFiles();
        File afile1[] = afile;
        int i = afile1.length;
        for(int j = 0; j < i; j++)
        {
            File file = afile1[j];
            if(file.isDirectory())
            {
                func_74576_a(file, (new StringBuilder()).append(p_74576_2_).append(file.getName()).append("/").toString());
                continue;
            }
            try
            {
                field_74577_b.func_71360_a((new StringBuilder()).append(p_74576_2_).append(file.getName()).toString(), file);
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("Failed to add ").append(p_74576_2_).append(file.getName()).toString());
            }
        }

    }

    private void func_74575_a(URL p_74575_1_, String p_74575_2_, long p_74575_3_, int p_74575_5_)
    {
        try
        {
            int i = p_74575_2_.indexOf("/");
            String s = p_74575_2_.substring(0, i);
            if(s.equals("sound") || s.equals("newsound"))
            {
                if(p_74575_5_ != 0)
                {
                    return;
                }
            } else
            if(p_74575_5_ != 1)
            {
                return;
            }
            File file = new File(field_74579_a, p_74575_2_);
            if(!file.exists() || file.length() != p_74575_3_)
            {
                file.getParentFile().mkdirs();
                String s1 = p_74575_2_.replaceAll(" ", "%20");
                func_74572_a(new URL(p_74575_1_, s1), file, p_74575_3_);
                if(field_74578_c)
                {
                    return;
                }
            }
            field_74577_b.func_71360_a(p_74575_2_, file);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void func_74572_a(URL p_74572_1_, File p_74572_2_, long p_74572_3_)
        throws IOException
    {
        byte abyte0[] = new byte[4096];
        DataInputStream datainputstream = new DataInputStream(p_74572_1_.openStream());
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(p_74572_2_));
        for(int i = 0; (i = datainputstream.read(abyte0)) >= 0;)
        {
            dataoutputstream.write(abyte0, 0, i);
            if(field_74578_c)
            {
                return;
            }
        }

        datainputstream.close();
        dataoutputstream.close();
    }

    public void func_74574_b()
    {
        field_74578_c = true;
    }
}
