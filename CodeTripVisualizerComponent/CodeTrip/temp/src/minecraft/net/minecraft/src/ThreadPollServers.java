// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.IOException;
import java.net.*;

// Referenced classes of package net.minecraft.src:
//            ServerData, GuiSlotServer, GuiMultiplayer

class ThreadPollServers extends Thread
{

    final ServerData field_78318_a; /* synthetic field */
    final GuiSlotServer field_78317_b; /* synthetic field */

    ThreadPollServers(GuiSlotServer p_i3040_1_, ServerData p_i3040_2_)
    {
        field_78317_b = p_i3040_1_;
        field_78318_a = p_i3040_2_;
        super();
    }

    public void run()
    {
        try
        {
            field_78318_a.field_78843_d = "\2478Polling..";
            long l = System.nanoTime();
            GuiMultiplayer.func_74013_a(field_78317_b.field_77250_a, field_78318_a);
            long l1 = System.nanoTime();
            field_78318_a.field_78844_e = (l1 - l) / 0xf4240L;
        }
        catch(UnknownHostException unknownhostexception)
        {
            field_78318_a.field_78844_e = -1L;
            field_78318_a.field_78843_d = "\2474Can't resolve hostname";
            synchronized(GuiMultiplayer.func_74011_h())
            {
                GuiMultiplayer.func_74018_k();
            }
            break MISSING_BLOCK_LABEL_345;
        }
        catch(SocketTimeoutException sockettimeoutexception)
        {
            field_78318_a.field_78844_e = -1L;
            field_78318_a.field_78843_d = "\2474Can't reach server";
            synchronized(GuiMultiplayer.func_74011_h())
            {
                GuiMultiplayer.func_74018_k();
            }
            break MISSING_BLOCK_LABEL_345;
        }
        catch(ConnectException connectexception)
        {
            field_78318_a.field_78844_e = -1L;
            field_78318_a.field_78843_d = "\2474Can't reach server";
            synchronized(GuiMultiplayer.func_74011_h())
            {
                GuiMultiplayer.func_74018_k();
            }
            break MISSING_BLOCK_LABEL_345;
        }
        catch(IOException ioexception)
        {
            field_78318_a.field_78844_e = -1L;
            field_78318_a.field_78843_d = "\2474Communication error";
            synchronized(GuiMultiplayer.func_74011_h())
            {
                GuiMultiplayer.func_74018_k();
            }
            break MISSING_BLOCK_LABEL_345;
        }
        catch(Exception exception)
        {
            field_78318_a.field_78844_e = -1L;
            field_78318_a.field_78843_d = (new StringBuilder()).append("ERROR: ").append(exception.getClass()).toString();
            synchronized(GuiMultiplayer.func_74011_h())
            {
                GuiMultiplayer.func_74018_k();
            }
            break MISSING_BLOCK_LABEL_345;
        }
        synchronized(GuiMultiplayer.func_74011_h())
        {
            GuiMultiplayer.func_74018_k();
        }
        break MISSING_BLOCK_LABEL_345;
        Exception exception7;
        exception7;
        synchronized(GuiMultiplayer.func_74011_h())
        {
            GuiMultiplayer.func_74018_k();
        }
        throw exception7;
    }
}
