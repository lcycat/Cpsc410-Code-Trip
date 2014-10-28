// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Set;
import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            WorldClient

class CallableMPL2
    implements Callable
{

    final WorldClient field_78835_a; /* synthetic field */

    CallableMPL2(WorldClient p_i3097_1_)
    {
        field_78835_a = p_i3097_1_;
        super();
    }

    public String func_78834_a()
    {
        return (new StringBuilder()).append(WorldClient.func_73030_b(field_78835_a).size()).append(" total; ").append(WorldClient.func_73030_b(field_78835_a).toString()).toString();
    }

    public Object call()
    {
        return func_78834_a();
    }
}
