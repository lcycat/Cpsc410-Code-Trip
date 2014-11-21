// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class CanvasMinecraftApplet extends Canvas
{

    final MinecraftApplet field_74422_a; /* synthetic field */

    public CanvasMinecraftApplet(MinecraftApplet p_i3020_1_)
    {
        field_74422_a = p_i3020_1_;
        super();
    }

    public synchronized void addNotify()
    {
        super.addNotify();
        field_74422_a.func_71479_a();
    }

    public synchronized void removeNotify()
    {
        field_74422_a.func_71480_b();
        super.removeNotify();
    }
}
