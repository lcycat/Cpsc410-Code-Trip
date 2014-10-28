// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class CallableIsServerModded
    implements Callable
{

    final MinecraftServer field_74274_a; /* synthetic field */

    public CallableIsServerModded(MinecraftServer p_i3372_1_)
    {
        field_74274_a = p_i3372_1_;
        super();
    }

    public String func_74273_a()
    {
        String s = field_74274_a.getServerModName();
        if(!s.equals("vanilla"))
        {
            return (new StringBuilder()).append("Definitely; '").append(s).append("'").toString();
        } else
        {
            return "Unknown (can't tell)";
        }
    }

    public Object call()
    {
        return func_74273_a();
    }
}
