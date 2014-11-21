// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            CrashReport

class CallableOSInfo
    implements Callable
{

    final CrashReport field_71496_a; /* synthetic field */

    CallableOSInfo(CrashReport p_i3245_1_)
    {
        field_71496_a = p_i3245_1_;
        super();
    }

    public String func_71495_a()
    {
        return (new StringBuilder()).append(System.getProperty("os.name")).append(" (").append(System.getProperty("os.arch")).append(") version ").append(System.getProperty("os.version")).toString();
    }

    public Object call()
    {
        return func_71495_a();
    }
}
