// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChatAllowedCharacters
{

    public static final String field_71568_a = func_71564_a();
    public static final char field_71567_b[] = {
        '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', 
        '<', '>', '|', '"', ':'
    };

    public ChatAllowedCharacters()
    {
    }

    private static String func_71564_a()
    {
        String s = "";
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((net.minecraft.src.ChatAllowedCharacters.class).getResourceAsStream("/font.txt"), "UTF-8"));
            String s1 = "";
            do
            {
                String s2;
                if((s2 = bufferedreader.readLine()) == null)
                {
                    break;
                }
                if(!s2.startsWith("#"))
                {
                    s = (new StringBuilder()).append(s).append(s2).toString();
                }
            } while(true);
            bufferedreader.close();
        }
        catch(Exception exception) { }
        return s;
    }

    public static final boolean func_71566_a(char p_71566_0_)
    {
        return p_71566_0_ != '\247' && (field_71568_a.indexOf(p_71566_0_) >= 0 || p_71566_0_ > ' ');
    }

}
