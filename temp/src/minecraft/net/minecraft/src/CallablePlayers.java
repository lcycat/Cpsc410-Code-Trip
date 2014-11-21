// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            ServerConfigurationManager

public class CallablePlayers
    implements Callable
{

    final MinecraftServer field_74270_a; /* synthetic field */

    public CallablePlayers(MinecraftServer p_i3374_1_)
    {
        field_74270_a = p_i3374_1_;
        super();
    }

    public String func_74269_a()
    {
        return (new StringBuilder()).append(MinecraftServer.func_71196_a(field_74270_a).func_72394_k()).append(" / ").append(MinecraftServer.func_71196_a(field_74270_a).func_72352_l()).append("; ").append(MinecraftServer.func_71196_a(field_74270_a).field_72404_b).toString();
    }

    public Object call()
    {
        return func_74269_a();
    }
}
