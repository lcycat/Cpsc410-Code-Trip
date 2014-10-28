// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class ThreadServerApplication extends Thread
{

    final MinecraftServer field_73716_a; /* synthetic field */

    public ThreadServerApplication(MinecraftServer p_i3371_1_, String p_i3371_2_)
    {
        field_73716_a = p_i3371_1_;
        super(p_i3371_2_);
    }

    public void run()
    {
        field_73716_a.run();
    }
}
