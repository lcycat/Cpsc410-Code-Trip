// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            Profiler

public class CallableServerProfiler
    implements Callable
{

    final MinecraftServer field_74272_a; /* synthetic field */

    public CallableServerProfiler(MinecraftServer p_i3373_1_)
    {
        field_74272_a = p_i3373_1_;
        super();
    }

    public String func_74271_a()
    {
        return field_74272_a.field_71304_b.field_76327_a ? field_74272_a.field_71304_b.func_76322_c() : "N/A (disabled)";
    }

    public Object call()
    {
        return func_74271_a();
    }
}
