// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            CrashReport

class CallableJavaInfo2
    implements Callable
{

    final CrashReport field_71492_a; /* synthetic field */

    CallableJavaInfo2(CrashReport p_i3247_1_)
    {
        field_71492_a = p_i3247_1_;
        super();
    }

    public String func_71491_a()
    {
        return (new StringBuilder()).append(System.getProperty("java.vm.name")).append(" (").append(System.getProperty("java.vm.info")).append("), ").append(System.getProperty("java.vm.vendor")).toString();
    }

    public Object call()
    {
        return func_71491_a();
    }
}
