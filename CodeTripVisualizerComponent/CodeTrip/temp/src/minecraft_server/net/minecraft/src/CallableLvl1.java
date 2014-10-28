// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package net.minecraft.src:
//            World

class CallableLvl1
    implements Callable
{

    final World field_77485_a; /* synthetic field */

    CallableLvl1(World p_i3728_1_)
    {
        field_77485_a = p_i3728_1_;
        super();
    }

    public String func_77484_a()
    {
        return (new StringBuilder()).append(field_77485_a.field_72996_f.size()).append(" total; ").append(field_77485_a.field_72996_f.toString()).toString();
    }

    public Object call()
    {
        return func_77484_a();
    }
}
