// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{

    private static final Pattern field_76339_a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");

    public static String func_76337_a(int p_76337_0_)
    {
        int i = p_76337_0_ / 20;
        int j = i / 60;
        i %= 60;
        if(i < 10)
        {
            return (new StringBuilder()).append(j).append(":0").append(i).toString();
        } else
        {
            return (new StringBuilder()).append(j).append(":").append(i).toString();
        }
    }

    public static String func_76338_a(String p_76338_0_)
    {
        return field_76339_a.matcher(p_76338_0_).replaceAll("");
    }

}
