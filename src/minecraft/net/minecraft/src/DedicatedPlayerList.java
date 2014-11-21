package net.minecraft.src;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class DedicatedPlayerList extends ServerConfigurationManager
{
    private File opsList;
    private File whiteList;

    public DedicatedPlayerList(DedicatedServer par1DedicatedServer)
    {
        super(par1DedicatedServer);
        opsList = par1DedicatedServer.getFile("ops.txt");
        whiteList = par1DedicatedServer.getFile("white-list.txt");
        viewDistance = par1DedicatedServer.getOrSetIntProperty("view-distance", 10);
        maxPlayers = par1DedicatedServer.getOrSetIntProperty("max-players", 20);
        setWhiteListEnabled(par1DedicatedServer.getOrSetBoolProperty("white-list", false));

        if (!par1DedicatedServer.isSinglePlayer())
        {
            getBannedPlayers().setListActive(true);
            getBannedIPs().setListActive(true);
        }

        getBannedPlayers().loadBanList();
        getBannedPlayers().saveToFileWithHeader();
        getBannedIPs().loadBanList();
        getBannedIPs().saveToFileWithHeader();
        loadOpsList();
        readWhiteList();
        saveOpsListOrWhitelist();
        saveOpsList();
    }

    public void setWhiteListEnabled(boolean par1)
    {
        super.setWhiteListEnabled(par1);
        getDedicatedServerInstance().setArbitraryProperty("white-list", Boolean.valueOf(par1));
        getDedicatedServerInstance().saveSettingsToFile();
    }

    public void addNameToWhitelist(String par1Str)
    {
        super.addNameToWhitelist(par1Str);
        saveOpsListOrWhitelist();
    }

    public void removeNameFromWhitelist(String par1Str)
    {
        super.removeNameFromWhitelist(par1Str);
        saveOpsListOrWhitelist();
    }

    public void removeFromIPWhitelist(String par1Str)
    {
        super.removeFromIPWhitelist(par1Str);
        saveOpsList();
    }

    public void addToIPWhitelist(String par1Str)
    {
        super.addToIPWhitelist(par1Str);
        saveOpsList();
    }

    /**
     * eithre does nothing, or calls readWhiteList
     */
    public void loadWhiteList()
    {
        readWhiteList();
    }

    private void loadOpsList()
    {
        try
        {
            getNamesWhiteList().clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(opsList));

            for (String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                getNamesWhiteList().add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        }
        catch (Exception exception)
        {
            myLogger.warning((new StringBuilder()).append("Failed to load operators list: ").append(exception).toString());
        }
    }

    private void saveOpsListOrWhitelist()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(opsList, false));
            String s;

            for (Iterator iterator = getNamesWhiteList().iterator(); iterator.hasNext(); printwriter.println(s))
            {
                s = (String)iterator.next();
            }

            printwriter.close();
        }
        catch (Exception exception)
        {
            myLogger.warning((new StringBuilder()).append("Failed to save operators list: ").append(exception).toString());
        }
    }

    private void readWhiteList()
    {
        try
        {
            getIPWhiteList().clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(whiteList));

            for (String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                getIPWhiteList().add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        }
        catch (Exception exception)
        {
            myLogger.warning((new StringBuilder()).append("Failed to load white-list: ").append(exception).toString());
        }
    }

    private void saveOpsList()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(whiteList, false));
            String s;

            for (Iterator iterator = getIPWhiteList().iterator(); iterator.hasNext(); printwriter.println(s))
            {
                s = (String)iterator.next();
            }

            printwriter.close();
        }
        catch (Exception exception)
        {
            myLogger.warning((new StringBuilder()).append("Failed to save white-list: ").append(exception).toString());
        }
    }

    public boolean isWhiteListed(String par1Str)
    {
        par1Str = par1Str.trim().toLowerCase();
        return !isWhiteListEnabled() || areCommandsAllowed(par1Str) || getIPWhiteList().contains(par1Str);
    }

    public DedicatedServer getDedicatedServerInstance()
    {
        return (DedicatedServer)super.getServerInstance();
    }

    public MinecraftServer getServerInstance()
    {
        return getDedicatedServerInstance();
    }
}
