// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            World

class CallableLvl2
    implements Callable
{

    final World field_77405_a; /* synthetic field */

    CallableLvl2(World p_i3729_1_)
    {
        field_77405_a = p_i3729_1_;
        super();
    }

    public String func_77404_a()
    {
        return (new StringBuilder()).append(field_77405_a.field_73010_i.size()).append(" total; ").append(field_77405_a.field_73010_i.toString()).toString();
    }

    public Object call()
    {
        return func_77404_a();
    }
}
