// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            NetClientHandler, GuiConnecting, Packet2ClientProtocol, Session, 
//            GuiDisconnected

class ThreadConnectToServer extends Thread
{

    final String field_78821_a; /* synthetic field */
    final int field_78819_b; /* synthetic field */
    final GuiConnecting field_78820_c; /* synthetic field */

    ThreadConnectToServer(GuiConnecting p_i3110_1_, String p_i3110_2_, int p_i3110_3_)
    {
        field_78820_c = p_i3110_1_;
        field_78821_a = p_i3110_2_;
        field_78819_b = p_i3110_3_;
        super();
    }

    public void run()
    {
        try
        {
            GuiConnecting.func_74252_a(field_78820_c, new NetClientHandler(GuiConnecting.func_74256_a(field_78820_c), field_78821_a, field_78819_b));
            if(GuiConnecting.func_74257_b(field_78820_c))
            {
                return;
            }
            GuiConnecting.func_74253_d(field_78820_c).func_72552_c(new Packet2ClientProtocol(39, GuiConnecting.func_74254_c(field_78820_c).field_71449_j.field_74286_b, field_78821_a, field_78819_b));
        }
        catch(UnknownHostException unknownhostexception)
        {
            if(GuiConnecting.func_74257_b(field_78820_c))
            {
                return;
            }
            GuiConnecting.func_74249_e(field_78820_c).func_71373_a(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {
                (new StringBuilder()).append("Unknown host '").append(field_78821_a).append("'").toString()
            }));
        }
        catch(ConnectException connectexception)
        {
            if(GuiConnecting.func_74257_b(field_78820_c))
            {
                return;
            }
            GuiConnecting.func_74250_f(field_78820_c).func_71373_a(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {
                connectexception.getMessage()
            }));
        }
        catch(Exception exception)
        {
            if(GuiConnecting.func_74257_b(field_78820_c))
            {
                return;
            }
            exception.printStackTrace();
            GuiConnecting.func_74251_g(field_78820_c).func_71373_a(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {
                exception.toString()
            }));
        }
    }
}
