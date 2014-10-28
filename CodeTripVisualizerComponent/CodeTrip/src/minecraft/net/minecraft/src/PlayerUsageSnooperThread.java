package net.minecraft.src;

import java.util.*;

class PlayerUsageSnooperThread extends TimerTask
{
    /** The PlayerUsageSnooper object. */
    final PlayerUsageSnooper snooper;

    PlayerUsageSnooperThread(PlayerUsageSnooper par1PlayerUsageSnooper)
    {
        snooper = par1PlayerUsageSnooper;
    }

    public void run()
    {
        if (!PlayerUsageSnooper.getStatsCollectorFor(snooper).isSnooperEnabled())
        {
            return;
        }

        HashMap hashmap;

        synchronized (PlayerUsageSnooper.getSyncLockFor(snooper))
        {
            hashmap = new HashMap(PlayerUsageSnooper.getDataMapFor(snooper));
        }

        hashmap.put("snooper_count", Integer.valueOf(PlayerUsageSnooper.getSelfCounterFor(snooper)));
        HttpUtil.sendPost(PlayerUsageSnooper.getServerUrlFor(snooper), hashmap, true);
    }
}
