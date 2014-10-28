// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.awt.BorderLayout;
import java.awt.Canvas;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

// Referenced classes of package net.minecraft.src:
//            PanelCrashReport, CrashReport

public class MinecraftAppletImpl extends Minecraft
{

    final MinecraftApplet field_71478_O; /* synthetic field */

    public MinecraftAppletImpl(MinecraftApplet p_i3013_1_, Canvas p_i3013_2_, MinecraftApplet p_i3013_3_, int p_i3013_4_, int p_i3013_5_, boolean p_i3013_6_)
    {
        field_71478_O = p_i3013_1_;
        super(p_i3013_2_, p_i3013_3_, p_i3013_4_, p_i3013_5_, p_i3013_6_);
    }

    public void func_71406_c(CrashReport p_71406_1_)
    {
        field_71478_O.removeAll();
        field_71478_O.setLayout(new BorderLayout());
        field_71478_O.add(new PanelCrashReport(p_71406_1_), "Center");
        field_71478_O.validate();
    }
}
