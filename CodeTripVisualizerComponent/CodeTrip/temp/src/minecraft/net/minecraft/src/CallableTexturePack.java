// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            GameSettings

public class CallableTexturePack
    implements Callable
{

    final Minecraft field_79002_a; /* synthetic field */

    public CallableTexturePack(Minecraft p_i3012_1_)
    {
        field_79002_a = p_i3012_1_;
        super();
    }

    public String func_79001_a()
    {
        return field_79002_a.field_71474_y.field_74346_m;
    }

    public Object call()
    {
        return func_79001_a();
    }
}
