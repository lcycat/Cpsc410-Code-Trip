// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.text.NumberFormat;

// Referenced classes of package net.minecraft.src:
//            IStatType, StatBase

final class StatTypeSimple
    implements IStatType
{

    StatTypeSimple()
    {
    }

    public String func_75843_a(int p_75843_1_)
    {
        return StatBase.func_75965_j().format(p_75843_1_);
    }
}
