package net.minecraft.src;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class DedicatedPlayerList extends ServerConfigurationManager
{
    private File field_72423_e;
    private File field_72422_f;

    public DedicatedPlayerList(DedicatedServer par1DedicatedServer)
    {
        super(par1DedicatedServer);
        field_72423_e = par1DedicatedServer.getFile("ops.txt");
        field_72422_f = par1DedicatedServer.getFile("white-list.txt");
        field_72402_d = par1DedicatedServer.getIntProperty("view-distance", 10);
        maxPlayers = par1DedicatedServer.getIntProperty("max-players", 20);
        func_72371_a(par1DedicatedServer.func_71332_a("white-list", false));

        if (!par1DedicatedServer.func_71264_H())
        {
            func_72390_e().func_73708_a(true);
            func_72363_f().func_73708_a(true);
        }

        func_72390_e().func_73707_e();
        func_72390_e().func_73711_f();
        func_72363_f().func_73707_e();
        func_72363_f().func_73711_f();
        func_72417_t();
        func_72418_v();
        func_72419_u();
        saveWhiteList();
    }

    public void func_72371_a(boolean par1)
    {
        super.func_72371_a(par1);
        func_72420_s().setProperty("white-list", Boolean.valueOf(par1));
        func_72420_s().saveProperties();
    }

    /**
     * This adds a username to the ops list, then saves the op list
     */
    public void addOp(String par1Str)
    {
        super.addOp(par1Str);
        func_72419_u();
    }

    /**
     * This removes a username from the ops list, then saves the op list
     */
    public void removeOp(String par1Str)
    {
        super.removeOp(par1Str);
        func_72419_u();
    }

    /**
     * remove the specified player from the whitelist
     */
    public void removeFromWhiteList(String par1Str)
    {
        super.removeFromWhiteList(par1Str);
        saveWhiteList();
    }

    /**
     * add the specified player to the white list
     */
    public void addToWhiteList(String par1Str)
    {
        super.addToWhiteList(par1Str);
        saveWhiteList();
    }

    /**
     * reloads the whitelist
     */
    public void reloadWhiteList()
    {
        func_72418_v();
    }

    private void func_72417_t()
    {
        try
        {
            func_72376_i().clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(field_72423_e));

            for (String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                func_72376_i().add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        }
        catch (Exception exception)
        {
            logger.warning((new StringBuilder()).append("Failed to load operators list: ").append(exception).toString());
        }
    }

    private void func_72419_u()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_72423_e, false));
            String s;

            for (Iterator iterator = func_72376_i().iterator(); iterator.hasNext(); printwriter.println(s))
            {
                s = (String)iterator.next();
            }

            printwriter.close();
        }
        catch (Exception exception)
        {
            logger.warning((new StringBuilder()).append("Failed to save operators list: ").append(exception).toString());
        }
    }

    private void func_72418_v()
    {
        try
        {
            getWhiteListedIPs().clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(field_72422_f));

            for (String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                getWhiteListedIPs().add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        }
        catch (Exception exception)
        {
            logger.warning((new StringBuilder()).append("Failed to load white-list: ").append(exception).toString());
        }
    }

    private void saveWhiteList()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_72422_f, false));
            String s;

            for (Iterator iterator = getWhiteListedIPs().iterator(); iterator.hasNext(); printwriter.println(s))
            {
                s = (String)iterator.next();
            }

            printwriter.close();
        }
        catch (Exception exception)
        {
            logger.warning((new StringBuilder()).append("Failed to save white-list: ").append(exception).toString());
        }
    }

    /**
     * Determine if the player is allowed to connect based on current server settings
     */
    public boolean isAllowedToLogin(String par1Str)
    {
        par1Str = par1Str.trim().toLowerCase();
        return !func_72383_n() || isOp(par1Str) || getWhiteListedIPs().contains(par1Str);
    }

    public DedicatedServer func_72420_s()
    {
        return (DedicatedServer)super.func_72365_p();
    }

    public MinecraftServer func_72365_p()
    {
        return func_72420_s();
    }
}
