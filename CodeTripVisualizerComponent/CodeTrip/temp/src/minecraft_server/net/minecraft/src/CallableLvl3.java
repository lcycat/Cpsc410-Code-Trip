// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            World, IChunkProvider

class CallableLvl3
    implements Callable
{

    final World field_77440_a; /* synthetic field */

    CallableLvl3(World p_i3730_1_)
    {
        field_77440_a = p_i3730_1_;
        super();
    }

    public String func_77439_a()
    {
        return field_77440_a.field_73020_y.func_73148_d();
    }

    public Object call()
    {
        return func_77439_a();
    }
}
