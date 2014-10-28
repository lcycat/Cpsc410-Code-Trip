package net.minecraft.src;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Timer;

public class PlayerUsageSnooper
{
    /** String map for report data */
    private Map dataMap;
    private final String uniqueID = UUID.randomUUID().toString();

    /** URL of the server to send the report to */
    private final URL serverUrl;
    private final IPlayerUsage playerStatsCollector;

    /** set to fire the snooperThread every 15 mins */
    private final Timer threadTrigger = new Timer("Snooper Timer", true);
    private final Object syncLock = new Object();
    private boolean isRunning;

    /** incremented on every getSelfCounterFor */
    private int selfCounter;

    public PlayerUsageSnooper(String par1Str, IPlayerUsage par2IPlayerUsage)
    {
        dataMap = new HashMap();
        isRunning = false;
        selfCounter = 0;

        try
        {
            serverUrl = new URL((new StringBuilder()).append("http://snoop.minecraft.net/").append(par1Str).append("?version=").append(1).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new IllegalArgumentException();
        }

        playerStatsCollector = par2IPlayerUsage;
    }

    /**
     * issuing start multiple times is not an error.
     */
    public void startSnooper()
    {
        if (isRunning)
        {
            return;
        }
        else
        {
            isRunning = true;
            addBaseDataToSnooper();
            threadTrigger.schedule(new PlayerUsageSnooperThread(this), 0L, 0xdbba0L);
            return;
        }
    }

    private void addBaseDataToSnooper()
    {
        addJvmArgsToSnooper();
        addData("snooper_token", uniqueID);
        addData("os_name", System.getProperty("os.name"));
        addData("os_version", System.getProperty("os.version"));
        addData("os_architecture", System.getProperty("os.arch"));
        addData("java_version", System.getProperty("java.version"));
        addData("version", "1.3.1");
        playerStatsCollector.addServerTypeToSnooper(this);
    }

    private void addJvmArgsToSnooper()
    {
        RuntimeMXBean runtimemxbean = ManagementFactory.getRuntimeMXBean();
        List list = runtimemxbean.getInputArguments();
        int i = 0;
        Iterator iterator = list.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            String s = (String)iterator.next();

            if (s.startsWith("-X"))
            {
                addData((new StringBuilder()).append("jvm_arg[").append(i++).append("]").toString(), s);
            }
        }
        while (true);

        addData("jvm_args", Integer.valueOf(i));
    }

    public void addMemoryStatsToSnooper()
    {
        addData("memory_total", Long.valueOf(Runtime.getRuntime().totalMemory()));
        addData("memory_max", Long.valueOf(Runtime.getRuntime().maxMemory()));
        addData("memory_free", Long.valueOf(Runtime.getRuntime().freeMemory()));
        addData("cpu_cores", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        playerStatsCollector.addServerStatsToSnooper(this);
    }

    /**
     * Adds information to the report
     */
    public void addData(String par1Str, Object par2Obj)
    {
        synchronized (syncLock)
        {
            dataMap.put(par1Str, par2Obj);
        }
    }

    public Map getCurrentStats()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();

        synchronized (syncLock)
        {
            addMemoryStatsToSnooper();
            java.util.Map.Entry entry;

            for (Iterator iterator = dataMap.entrySet().iterator(); iterator.hasNext(); linkedhashmap.put(entry.getKey(), entry.getValue().toString()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }
        }

        return linkedhashmap;
    }

    public boolean isSnooperRunning()
    {
        return isRunning;
    }

    public void stopSnooper()
    {
        threadTrigger.cancel();
    }

    static IPlayerUsage getStatsCollectorFor(PlayerUsageSnooper par0PlayerUsageSnooper)
    {
        return par0PlayerUsageSnooper.playerStatsCollector;
    }

    static Object getSyncLockFor(PlayerUsageSnooper par0PlayerUsageSnooper)
    {
        return par0PlayerUsageSnooper.syncLock;
    }

    static Map getDataMapFor(PlayerUsageSnooper par0PlayerUsageSnooper)
    {
        return par0PlayerUsageSnooper.dataMap;
    }

    /**
     * returns a value indicating how many times this function has been run on the snooper
     */
    static int getSelfCounterFor(PlayerUsageSnooper par0PlayerUsageSnooper)
    {
        return par0PlayerUsageSnooper.selfCounter++;
    }

    static URL getServerUrlFor(PlayerUsageSnooper par0PlayerUsageSnooper)
    {
        return par0PlayerUsageSnooper.serverUrl;
    }
}
