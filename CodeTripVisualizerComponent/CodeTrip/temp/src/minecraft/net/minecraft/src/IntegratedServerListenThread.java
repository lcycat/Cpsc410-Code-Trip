// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            NetworkListenThread, MemoryConnection, HttpUtil, ServerListenThread, 
//            IntegratedServer, ServerConfigurationManager

public class IntegratedServerListenThread extends NetworkListenThread
{

    private final MemoryConnection field_71760_c = new MemoryConnection(null);
    private MemoryConnection field_71758_d;
    private String field_71759_e;
    private boolean field_71756_f;
    private ServerListenThread field_71757_g;

    public IntegratedServerListenThread(IntegratedServer p_i3121_1_)
        throws IOException
    {
        super(p_i3121_1_);
        field_71756_f = false;
    }

    public void func_71754_a(MemoryConnection p_71754_1_, String p_71754_2_)
    {
        field_71758_d = p_71754_1_;
        field_71759_e = p_71754_2_;
    }

    public String func_71755_c()
        throws IOException
    {
        if(field_71757_g == null)
        {
            int i = -1;
            try
            {
                i = HttpUtil.func_76181_a();
            }
            catch(IOException ioexception) { }
            if(i <= 0)
            {
                i = 25564;
            }
            try
            {
                field_71757_g = new ServerListenThread(this, InetAddress.getLocalHost(), i);
                field_71757_g.start();
            }
            catch(IOException ioexception1)
            {
                throw ioexception1;
            }
        }
        return (new StringBuilder()).append(field_71757_g.func_71767_c().getHostAddress()).append(":").append(field_71757_g.func_71765_d()).toString();
    }

    public void func_71744_a()
    {
        super.func_71744_a();
        if(field_71757_g != null)
        {
            System.out.println("Stopping server connection");
            field_71757_g.func_71768_b();
            field_71757_g.interrupt();
            field_71757_g = null;
        }
    }

    public void func_71747_b()
    {
        if(field_71758_d != null)
        {
            EntityPlayerMP entityplayermp = func_71753_e().func_71203_ab().func_72366_a(field_71759_e);
            if(entityplayermp != null)
            {
                field_71760_c.func_74434_a(field_71758_d);
                field_71756_f = true;
                func_71753_e().func_71203_ab().func_72355_a(field_71760_c, entityplayermp);
            }
            field_71758_d = null;
            field_71759_e = null;
        }
        if(field_71757_g != null)
        {
            field_71757_g.func_71766_a();
        }
        super.func_71747_b();
    }

    public IntegratedServer func_71753_e()
    {
        return (IntegratedServer)super.func_71746_d();
    }

    public boolean func_71752_f()
    {
        return field_71756_f && field_71760_c.func_74432_i().func_74435_g() && field_71760_c.func_74432_i().func_74433_h();
    }

    public MinecraftServer func_71746_d()
    {
        return func_71753_e();
    }
}
