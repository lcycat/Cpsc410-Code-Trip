// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.util.*;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            CompressedStreamTools, NBTTagCompound, NBTTagList, ServerData

public class ServerList
{

    private final Minecraft field_78859_a;
    private final List field_78858_b = new ArrayList();

    public ServerList(Minecraft p_i3113_1_)
    {
        field_78859_a = p_i3113_1_;
        func_78853_a();
    }

    public void func_78853_a()
    {
        try
        {
            NBTTagCompound nbttagcompound = CompressedStreamTools.func_74797_a(new File(field_78859_a.field_71412_D, "servers.dat"));
            NBTTagList nbttaglist = nbttagcompound.func_74761_m("servers");
            field_78858_b.clear();
            for(int i = 0; i < nbttaglist.func_74745_c(); i++)
            {
                field_78858_b.add(ServerData.func_78837_a((NBTTagCompound)nbttaglist.func_74743_b(i)));
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void func_78855_b()
    {
        try
        {
            NBTTagList nbttaglist = new NBTTagList();
            ServerData serverdata;
            for(Iterator iterator = field_78858_b.iterator(); iterator.hasNext(); nbttaglist.func_74742_a(serverdata.func_78836_a()))
            {
                serverdata = (ServerData)iterator.next();
            }

            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.func_74782_a("servers", nbttaglist);
            CompressedStreamTools.func_74793_a(nbttagcompound, new File(field_78859_a.field_71412_D, "servers.dat"));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public ServerData func_78850_a(int p_78850_1_)
    {
        return (ServerData)field_78858_b.get(p_78850_1_);
    }

    public void func_78851_b(int p_78851_1_)
    {
        field_78858_b.remove(p_78851_1_);
    }

    public void func_78849_a(ServerData p_78849_1_)
    {
        field_78858_b.add(p_78849_1_);
    }

    public int func_78856_c()
    {
        return field_78858_b.size();
    }

    public void func_78857_a(int p_78857_1_, int p_78857_2_)
    {
        ServerData serverdata = func_78850_a(p_78857_1_);
        field_78858_b.set(p_78857_1_, func_78850_a(p_78857_2_));
        field_78858_b.set(p_78857_2_, serverdata);
    }

    public void func_78854_a(int p_78854_1_, ServerData p_78854_2_)
    {
        field_78858_b.set(p_78854_1_, p_78854_2_);
    }

    public static void func_78852_b(ServerData p_78852_0_)
    {
        ServerList serverlist = new ServerList(Minecraft.func_71410_x());
        serverlist.func_78853_a();
        int i = 0;
        do
        {
            if(i >= serverlist.func_78856_c())
            {
                break;
            }
            ServerData serverdata = serverlist.func_78850_a(i);
            if(serverdata.field_78847_a.equals(p_78852_0_.field_78847_a) && serverdata.field_78845_b.equals(p_78852_0_.field_78845_b))
            {
                serverlist.func_78854_a(i, p_78852_0_);
                break;
            }
            i++;
        } while(true);
        serverlist.func_78855_b();
    }
}
