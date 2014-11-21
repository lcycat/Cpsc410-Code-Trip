// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.client;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.io.PrintStream;
import java.net.URL;
import net.minecraft.src.*;

// Referenced classes of package net.minecraft.client:
//            Minecraft

public class MinecraftApplet extends Applet
{

    private Canvas field_71483_a;
    private Minecraft field_71481_b;
    private Thread field_71482_c;

    public MinecraftApplet()
    {
        field_71482_c = null;
    }

    public void init()
    {
        field_71483_a = new CanvasMinecraftApplet(this);
        boolean flag = "true".equalsIgnoreCase(getParameter("fullscreen"));
        field_71481_b = new MinecraftAppletImpl(this, field_71483_a, this, getWidth(), getHeight(), flag);
        field_71481_b.field_71450_k = getDocumentBase().getHost();
        if(getDocumentBase().getPort() <= 0) goto _L2; else goto _L1
_L1:
        new StringBuilder();
        field_71481_b;
        JVM INSTR dup_x1 ;
        field_71450_k;
        append();
        ":";
        append();
        getDocumentBase().getPort();
        append();
        toString();
        field_71450_k;
_L2:
        if(getParameter("username") != null && getParameter("sessionid") != null)
        {
            field_71481_b.field_71449_j = new Session(getParameter("username"), getParameter("sessionid"));
            System.out.println((new StringBuilder()).append("Setting user: ").append(field_71481_b.field_71449_j.field_74286_b).append(", ").append(field_71481_b.field_71449_j.field_74287_c).toString());
        } else
        {
            field_71481_b.field_71449_j = new Session("Player", "");
        }
        field_71481_b.func_71390_a("true".equals(getParameter("demo")));
        if(getParameter("server") != null && getParameter("port") != null)
        {
            field_71481_b.func_71367_a(getParameter("server"), Integer.parseInt(getParameter("port")));
        }
        field_71481_b.field_71448_m = !"true".equals(getParameter("stand-alone"));
        setLayout(new BorderLayout());
        add(field_71483_a, "Center");
        field_71483_a.setFocusable(true);
        validate();
        return;
    }

    public void func_71479_a()
    {
        if(field_71482_c != null)
        {
            return;
        } else
        {
            field_71482_c = new Thread(field_71481_b, "Minecraft main thread");
            field_71482_c.start();
            return;
        }
    }

    public void start()
    {
        if(field_71481_b != null)
        {
            field_71481_b.field_71445_n = false;
        }
    }

    public void stop()
    {
        if(field_71481_b != null)
        {
            field_71481_b.field_71445_n = true;
        }
    }

    public void destroy()
    {
        func_71480_b();
    }

    public void func_71480_b()
    {
        if(field_71482_c == null)
        {
            return;
        }
        field_71481_b.func_71400_g();
        try
        {
            field_71482_c.join(10000L);
        }
        catch(InterruptedException interruptedexception)
        {
            try
            {
                field_71481_b.func_71405_e();
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        field_71482_c = null;
    }
}
