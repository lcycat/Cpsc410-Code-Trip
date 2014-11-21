// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.net.InetAddress;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            NetworkListenThread, ServerListenThread, DedicatedServer

public class DedicatedServerListenThread extends NetworkListenThread
{

    private final ServerListenThread field_71763_c;

    public DedicatedServerListenThread(MinecraftServer p_i3383_1_, InetAddress p_i3383_2_, int p_i3383_3_)
        throws IOException
    {
        super(p_i3383_1_);
        field_71763_c = new ServerListenThread(this, p_i3383_2_, p_i3383_3_);
        field_71763_c.start();
    }

    public void func_71744_a()
    {
        super.func_71744_a();
        field_71763_c.func_71768_b();
        field_71763_c.interrupt();
    }

    public void func_71747_b()
    {
        field_71763_c.func_71766_a();
        super.func_71747_b();
    }

    public DedicatedServer func_71762_c()
    {
        return (DedicatedServer)super.func_71746_d();
    }

    public void func_71761_a(InetAddress p_71761_1_)
    {
        field_71763_c.func_71769_a(p_71761_1_);
    }

    public MinecraftServer func_71746_d()
    {
        return func_71762_c();
    }
}
