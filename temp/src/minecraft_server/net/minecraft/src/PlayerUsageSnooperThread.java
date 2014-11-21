// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            PlayerUsageSnooper, IPlayerUsage, HttpUtil

class PlayerUsageSnooperThread extends TimerTask
{

    final PlayerUsageSnooper field_76344_a; /* synthetic field */

    PlayerUsageSnooperThread(PlayerUsageSnooper p_i3427_1_)
    {
        field_76344_a = p_i3427_1_;
        super();
    }

    public void run()
    {
        if(!PlayerUsageSnooper.func_76473_a(field_76344_a).func_70002_Q())
        {
            return;
        }
        HashMap hashmap;
        synchronized(PlayerUsageSnooper.func_76474_b(field_76344_a))
        {
            hashmap = new HashMap(PlayerUsageSnooper.func_76469_c(field_76344_a));
        }
        hashmap.put("snooper_count", Integer.valueOf(PlayerUsageSnooper.func_76466_d(field_76344_a)));
        HttpUtil.func_76183_a(PlayerUsageSnooper.func_76475_e(field_76344_a), hashmap, true);
    }
}
