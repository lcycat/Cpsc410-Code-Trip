// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

public class CallableLWJGLVersion
    implements Callable
{

    final Minecraft field_74421_a; /* synthetic field */

    public CallableLWJGLVersion(Minecraft p_i3002_1_)
    {
        field_74421_a = p_i3002_1_;
        super();
    }

    public String func_74420_a()
    {
        return Sys.getVersion();
    }

    public Object call()
    {
        return func_74420_a();
    }
}
