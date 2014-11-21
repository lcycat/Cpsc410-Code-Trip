// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            NetServerHandler, NetworkManager

public abstract class NetworkListenThread
{

    public static Logger field_71751_a = Logger.getLogger("Minecraft");
    private final MinecraftServer field_71750_c;
    private final List field_71748_d = Collections.synchronizedList(new ArrayList());
    public volatile boolean field_71749_b;

    public NetworkListenThread(MinecraftServer p_i3402_1_)
        throws IOException
    {
        field_71749_b = false;
        field_71750_c = p_i3402_1_;
        field_71749_b = true;
    }

    public void func_71745_a(NetServerHandler p_71745_1_)
    {
        field_71748_d.add(p_71745_1_);
    }

    public void func_71744_a()
    {
        field_71749_b = false;
    }

    public void func_71747_b()
    {
        for(int i = 0; i < field_71748_d.size(); i++)
        {
            NetServerHandler netserverhandler = (NetServerHandler)field_71748_d.get(i);
            try
            {
                netserverhandler.func_72570_d();
            }
            catch(Exception exception)
            {
                field_71751_a.log(Level.WARNING, (new StringBuilder()).append("Failed to handle packet: ").append(exception).toString(), exception);
                netserverhandler.func_72565_c("Internal server error");
            }
            if(netserverhandler.field_72576_c)
            {
                field_71748_d.remove(i--);
            }
            netserverhandler.field_72575_b.func_74427_a();
        }

    }

    public MinecraftServer func_71746_d()
    {
        return field_71750_c;
    }

}
