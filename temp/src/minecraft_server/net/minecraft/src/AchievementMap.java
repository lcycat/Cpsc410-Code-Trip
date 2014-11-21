// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AchievementMap
{

    public static AchievementMap field_75964_a = new AchievementMap();
    private Map field_75963_b;

    private AchievementMap()
    {
        field_75963_b = new HashMap();
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.AchievementMap.class).getResourceAsStream("/achievement/map.txt")));
            String s;
            while((s = bufferedreader.readLine()) != null) 
            {
                String as[] = s.split(",");
                int i = Integer.parseInt(as[0]);
                field_75963_b.put(Integer.valueOf(i), as[1]);
            }
            bufferedreader.close();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static String func_75962_a(int p_75962_0_)
    {
        return (String)field_75964_a.field_75963_b.get(Integer.valueOf(p_75962_0_));
    }

}
