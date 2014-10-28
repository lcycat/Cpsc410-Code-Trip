// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            CrashReport

class CallableMinecraftVersion
    implements Callable
{

    final CrashReport field_71494_a; /* synthetic field */

    CallableMinecraftVersion(CrashReport p_i3244_1_)
    {
        field_71494_a = p_i3244_1_;
        super();
    }

    public String func_71493_a()
    {
        return "1.3.1";
    }

    public Object call()
    {
        return func_71493_a();
    }
}
