package net.minecraft.src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    private static final Pattern patternControlCode = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");

    /**
     * Returns the time elapsed for the given number of ticks, in "mm:ss" format.
     */
    public static String ticksToElapsedTime(int par0)
    {
        int i = par0 / 20;
        int j = i / 60;
        i %= 60;

        if (i < 10)
        {
            return (new StringBuilder()).append(j).append(":0").append(i).toString();
        }
        else
        {
            return (new StringBuilder()).append(j).append(":").append(i).toString();
        }
    }

    public static String stripControlCodes(String par0Str)
    {
        return patternControlCode.matcher(par0Str).replaceAll("");
    }
}
