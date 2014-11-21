// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;

public final class GameWindowListener extends WindowAdapter
{

    public GameWindowListener()
    {
    }

    public void windowClosing(WindowEvent p_windowClosing_1_)
    {
        System.err.println("Someone is closing me!");
        System.exit(1);
    }
}
