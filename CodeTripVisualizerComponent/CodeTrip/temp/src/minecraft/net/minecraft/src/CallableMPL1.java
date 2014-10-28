// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Set;
import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            WorldClient

class CallableMPL1
    implements Callable
{

    final WorldClient field_78833_a; /* synthetic field */

    CallableMPL1(WorldClient p_i3098_1_)
    {
        field_78833_a = p_i3098_1_;
        super();
    }

    public String func_78832_a()
    {
        return (new StringBuilder()).append(WorldClient.func_73026_a(field_78833_a).size()).append(" total; ").append(WorldClient.func_73026_a(field_78833_a).toString()).toString();
    }

    public Object call()
    {
        return func_78832_a();
    }
}
