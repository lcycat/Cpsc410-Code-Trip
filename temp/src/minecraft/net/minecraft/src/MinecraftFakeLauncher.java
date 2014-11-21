// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.applet.Applet;
import java.applet.AppletStub;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MinecraftFakeLauncher extends Applet
    implements AppletStub
{

    final Map field_74534_a; /* synthetic field */

    public MinecraftFakeLauncher(Map p_i3001_1_)
    {
        field_74534_a = p_i3001_1_;
        super();
    }

    public void appletResize(int i, int j)
    {
    }

    public boolean isActive()
    {
        return true;
    }

    public URL getDocumentBase()
    {
        try
        {
            return new URL("http://www.minecraft.net/game/");
        }
        catch(MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
        }
        return null;
    }

    public String getParameter(String p_getParameter_1_)
    {
        if(field_74534_a.containsKey(p_getParameter_1_))
        {
            return (String)field_74534_a.get(p_getParameter_1_);
        } else
        {
            System.err.println((new StringBuilder()).append("Client asked for parameter: ").append(p_getParameter_1_).toString());
            return null;
        }
    }
}
