// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            DedicatedServer

class CallableType
    implements Callable
{

    final DedicatedServer field_71743_a; /* synthetic field */

    CallableType(DedicatedServer p_i3381_1_)
    {
        field_71743_a = p_i3381_1_;
        super();
    }

    public String func_71742_a()
    {
        return "Dedicated Server";
    }

    public Object call()
    {
        return func_71742_a();
    }
}
