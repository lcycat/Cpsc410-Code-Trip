// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package org.bouncycastle.util;


public final class Strings
{

    public static String func_74830_a(String p_74830_0_)
    {
        boolean flag = false;
        char ac[] = p_74830_0_.toCharArray();
        for(int i = 0; i != ac.length; i++)
        {
            char c = ac[i];
            if('A' <= c && 'Z' >= c)
            {
                flag = true;
                ac[i] = (char)((c - 65) + 97);
            }
        }

        if(flag)
        {
            return new String(ac);
        } else
        {
            return p_74830_0_;
        }
    }
}
