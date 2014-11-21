// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyManager
{

    public static Logger field_73674_a = Logger.getLogger("Minecraft");
    private Properties field_73672_b;
    private File field_73673_c;

    public PropertyManager(File p_i3377_1_)
    {
        field_73672_b = new Properties();
        field_73673_c = p_i3377_1_;
        if(p_i3377_1_.exists())
        {
            FileInputStream fileinputstream = null;
            try
            {
                fileinputstream = new FileInputStream(p_i3377_1_);
                field_73672_b.load(fileinputstream);
            }
            catch(Exception exception)
            {
                field_73674_a.log(Level.WARNING, (new StringBuilder()).append("Failed to load ").append(p_i3377_1_).toString(), exception);
                func_73666_a();
            }
            finally
            {
                if(fileinputstream != null)
                {
                    try
                    {
                        fileinputstream.close();
                    }
                    catch(IOException ioexception) { }
                }
            }
        } else
        {
            field_73674_a.log(Level.WARNING, (new StringBuilder()).append(p_i3377_1_).append(" does not exist").toString());
            func_73666_a();
        }
    }

    public void func_73666_a()
    {
        field_73674_a.log(Level.INFO, "Generating new properties file");
        func_73668_b();
    }

    public void func_73668_b()
    {
        FileOutputStream fileoutputstream = null;
        try
        {
            fileoutputstream = new FileOutputStream(field_73673_c);
            field_73672_b.store(fileoutputstream, "Minecraft server properties");
        }
        catch(Exception exception)
        {
            field_73674_a.log(Level.WARNING, (new StringBuilder()).append("Failed to save ").append(field_73673_c).toString(), exception);
            func_73666_a();
        }
        finally
        {
            if(fileoutputstream != null)
            {
                try
                {
                    fileoutputstream.close();
                }
                catch(IOException ioexception) { }
            }
        }
    }

    public File func_73665_c()
    {
        return field_73673_c;
    }

    public String func_73671_a(String p_73671_1_, String p_73671_2_)
    {
        if(!field_73672_b.containsKey(p_73671_1_))
        {
            field_73672_b.setProperty(p_73671_1_, p_73671_2_);
            func_73668_b();
        }
        return field_73672_b.getProperty(p_73671_1_, p_73671_2_);
    }

    public int func_73669_a(String p_73669_1_, int p_73669_2_)
    {
        try
        {
            return Integer.parseInt(func_73671_a(p_73669_1_, (new StringBuilder()).append("").append(p_73669_2_).toString()));
        }
        catch(Exception exception)
        {
            field_73672_b.setProperty(p_73669_1_, (new StringBuilder()).append("").append(p_73669_2_).toString());
        }
        return p_73669_2_;
    }

    public boolean func_73670_a(String p_73670_1_, boolean p_73670_2_)
    {
        try
        {
            return Boolean.parseBoolean(func_73671_a(p_73670_1_, (new StringBuilder()).append("").append(p_73670_2_).toString()));
        }
        catch(Exception exception)
        {
            field_73672_b.setProperty(p_73670_1_, (new StringBuilder()).append("").append(p_73670_2_).toString());
        }
        return p_73670_2_;
    }

    public void func_73667_a(String p_73667_1_, Object p_73667_2_)
    {
        field_73672_b.setProperty(p_73667_1_, (new StringBuilder()).append("").append(p_73667_2_).toString());
    }

}
