// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            IntegratedServer

class CallableType3
    implements Callable
{

    final IntegratedServer field_76974_a; /* synthetic field */

    CallableType3(IntegratedServer p_i3120_1_)
    {
        field_76974_a = p_i3120_1_;
        super();
    }

    public String func_76973_a()
    {
        return "Integrated Server";
    }

    public Object call()
    {
        return func_76973_a();
    }
}
