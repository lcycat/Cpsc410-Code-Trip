package net.minecraft.src;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyManager
{
    public static Logger myLogger = Logger.getLogger("Minecraft");
    private Properties properties;
    private File associatedFile;

    public PropertyManager(File par1File)
    {
        properties = new Properties();
        associatedFile = par1File;

        if (par1File.exists())
        {
            FileInputStream fileinputstream = null;

            try
            {
                fileinputstream = new FileInputStream(par1File);
                properties.load(fileinputstream);
            }
            catch (Exception exception)
            {
                myLogger.log(Level.WARNING, (new StringBuilder()).append("Failed to load ").append(par1File).toString(), exception);
                logMessageAndSave();
            }
            finally
            {
                if (fileinputstream != null)
                {
                    try
                    {
                        fileinputstream.close();
                    }
                    catch (IOException ioexception) { }
                }
            }
        }
        else
        {
            myLogger.log(Level.WARNING, (new StringBuilder()).append(par1File).append(" does not exist").toString());
            logMessageAndSave();
        }
    }

    /**
     * logs an info message then calls saveSettingsToFile Yes this appears to be a potential stack overflow - these 2
     * functions call each other repeatdly if an exception occurs.
     */
    public void logMessageAndSave()
    {
        myLogger.log(Level.INFO, "Generating new properties file");
        saveSettingsToFile();
    }

    /**
     * calls logMessageAndSave if an exception occurs
     */
    public void saveSettingsToFile()
    {
        FileOutputStream fileoutputstream = null;

        try
        {
            fileoutputstream = new FileOutputStream(associatedFile);
            properties.store(fileoutputstream, "Minecraft server properties");
        }
        catch (Exception exception)
        {
            myLogger.log(Level.WARNING, (new StringBuilder()).append("Failed to save ").append(associatedFile).toString(), exception);
            logMessageAndSave();
        }
        finally
        {
            if (fileoutputstream != null)
            {
                try
                {
                    fileoutputstream.close();
                }
                catch (IOException ioexception) { }
            }
        }
    }

    public File getFile()
    {
        return associatedFile;
    }

    /**
     * set if it doesn't exist, otherwise get
     */
    public String getOrSetProperty(String par1Str, String par2Str)
    {
        if (!properties.containsKey(par1Str))
        {
            properties.setProperty(par1Str, par2Str);
            saveSettingsToFile();
        }

        return properties.getProperty(par1Str, par2Str);
    }

    /**
     * set if it doesn't exist, otherwise get
     */
    public int getOrSetIntProperty(String par1Str, int par2)
    {
        try
        {
            return Integer.parseInt(getOrSetProperty(par1Str, (new StringBuilder()).append("").append(par2).toString()));
        }
        catch (Exception exception)
        {
            properties.setProperty(par1Str, (new StringBuilder()).append("").append(par2).toString());
        }

        return par2;
    }

    /**
     * set if it doesn't exist, otherwise get
     */
    public boolean getOrSetBoolProperty(String par1Str, boolean par2)
    {
        try
        {
            return Boolean.parseBoolean(getOrSetProperty(par1Str, (new StringBuilder()).append("").append(par2).toString()));
        }
        catch (Exception exception)
        {
            properties.setProperty(par1Str, (new StringBuilder()).append("").append(par2).toString());
        }

        return par2;
    }

    /**
     * returns void, rather than what you input
     */
    public void setArbitraryProperty(String par1Str, Object par2Obj)
    {
        properties.setProperty(par1Str, (new StringBuilder()).append("").append(par2Obj).toString());
    }
}
