// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Profiler

public class CallableClientProfiler
    implements Callable
{

    final Minecraft field_74500_a; /* synthetic field */

    public CallableClientProfiler(Minecraft p_i3017_1_)
    {
        field_74500_a = p_i3017_1_;
        super();
    }

    public String func_74499_a()
    {
        return field_74500_a.field_71424_I.field_76327_a ? field_74500_a.field_71424_I.func_76322_c() : "N/A (disabled)";
    }

    public Object call()
    {
        return func_74499_a();
    }
}
