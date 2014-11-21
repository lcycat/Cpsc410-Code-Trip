// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            CrashReport

class CallableJavaInfo
    implements Callable
{

    final CrashReport field_71490_a; /* synthetic field */

    CallableJavaInfo(CrashReport p_i3246_1_)
    {
        field_71490_a = p_i3246_1_;
        super();
    }

    public String func_71489_a()
    {
        return (new StringBuilder()).append(System.getProperty("java.version")).append(", ").append(System.getProperty("java.vendor")).toString();
    }

    public Object call()
    {
        return func_71489_a();
    }
}
