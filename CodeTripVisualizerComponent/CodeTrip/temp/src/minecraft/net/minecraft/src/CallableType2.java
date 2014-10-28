// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class CallableType2
    implements Callable
{

    final Minecraft field_74503_a; /* synthetic field */

    public CallableType2(Minecraft p_i3007_1_)
    {
        field_74503_a = p_i3007_1_;
        super();
    }

    public String func_74502_a()
    {
        return "Client";
    }

    public Object call()
    {
        return func_74502_a();
    }
}
