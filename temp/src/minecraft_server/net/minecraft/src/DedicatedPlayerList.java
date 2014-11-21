// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            ServerConfigurationManager, DedicatedServer, BanList

public class DedicatedPlayerList extends ServerConfigurationManager
{

    private File field_72423_e;
    private File field_72422_f;

    public DedicatedPlayerList(DedicatedServer p_i3378_1_)
    {
        super(p_i3378_1_);
        field_72423_e = p_i3378_1_.func_71209_f("ops.txt");
        field_72422_f = p_i3378_1_.func_71209_f("white-list.txt");
        field_72402_d = p_i3378_1_.func_71327_a("view-distance", 10);
        field_72405_c = p_i3378_1_.func_71327_a("max-players", 20);
        func_72371_a(p_i3378_1_.func_71332_a("white-list", false));
        if(!p_i3378_1_.func_71264_H())
        {
            func_72390_e().func_73708_a(true);
            func_72363_f().func_73708_a(true);
        }
        func_72390_e().func_73707_e();
        func_72390_e().func_73711_f();
        func_72363_f().func_73707_e();
        func_72363_f().func_73711_f();
        func_72417_t();
        func_72418_v();
        func_72419_u();
        func_72421_w();
    }

    public void func_72371_a(boolean p_72371_1_)
    {
        super.func_72371_a(p_72371_1_);
        func_72420_s().func_71328_a("white-list", Boolean.valueOf(p_72371_1_));
        func_72420_s().func_71326_a();
    }

    public void func_72386_b(String p_72386_1_)
    {
        super.func_72386_b(p_72386_1_);
        func_72419_u();
    }

    public void func_72360_c(String p_72360_1_)
    {
        super.func_72360_c(p_72360_1_);
        func_72419_u();
    }

    public void func_72379_i(String p_72379_1_)
    {
        super.func_72379_i(p_72379_1_);
        func_72421_w();
    }

    public void func_72359_h(String p_72359_1_)
    {
        super.func_72359_h(p_72359_1_);
        func_72421_w();
    }

    public void func_72362_j()
    {
        func_72418_v();
    }

    private void func_72417_t()
    {
        try
        {
            func_72376_i().clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(field_72423_e));
            for(String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                func_72376_i().add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        }
        catch(Exception exception)
        {
            field_72406_a.warning((new StringBuilder()).append("Failed to load operators list: ").append(exception).toString());
        }
    }

    private void func_72419_u()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_72423_e, false));
            String s;
            for(Iterator iterator = func_72376_i().iterator(); iterator.hasNext(); printwriter.println(s))
            {
                s = (String)iterator.next();
            }

            printwriter.close();
        }
        catch(Exception exception)
        {
            field_72406_a.warning((new StringBuilder()).append("Failed to save operators list: ").append(exception).toString());
        }
    }

    private void func_72418_v()
    {
        try
        {
            func_72388_h().clear();
            BufferedReader bufferedreader = new BufferedReader(new FileReader(field_72422_f));
            for(String s = ""; (s = bufferedreader.readLine()) != null;)
            {
                func_72388_h().add(s.trim().toLowerCase());
            }

            bufferedreader.close();
        }
        catch(Exception exception)
        {
            field_72406_a.warning((new StringBuilder()).append("Failed to load white-list: ").append(exception).toString());
        }
    }

    private void func_72421_w()
    {
        try
        {
            PrintWriter printwriter = new PrintWriter(new FileWriter(field_72422_f, false));
            String s;
            for(Iterator iterator = func_72388_h().iterator(); iterator.hasNext(); printwriter.println(s))
            {
                s = (String)iterator.next();
            }

            printwriter.close();
        }
        catch(Exception exception)
        {
            field_72406_a.warning((new StringBuilder()).append("Failed to save white-list: ").append(exception).toString());
        }
    }

    public boolean func_72370_d(String p_72370_1_)
    {
        p_72370_1_ = p_72370_1_.trim().toLowerCase();
        return !func_72383_n() || func_72353_e(p_72370_1_) || func_72388_h().contains(p_72370_1_);
    }

    public DedicatedServer func_72420_s()
    {
        return (DedicatedServer)super.func_72365_p();
    }

    public MinecraftServer func_72365_p()
    {
        return func_72420_s();
    }
}
