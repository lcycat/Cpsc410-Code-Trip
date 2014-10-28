// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, ServerConfigurationManager, WrongUsageException

public class CommandServerWhitelist extends CommandBase
{

    public CommandServerWhitelist()
    {
    }

    public String func_71517_b()
    {
        return "whitelist";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.whitelist.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length >= 1)
        {
            if(p_71515_2_[0].equals("on"))
            {
                MinecraftServer.func_71276_C().func_71203_ab().func_72371_a(true);
                func_71522_a(p_71515_1_, "commands.whitelist.enabled", new Object[0]);
                return;
            }
            if(p_71515_2_[0].equals("off"))
            {
                MinecraftServer.func_71276_C().func_71203_ab().func_72371_a(false);
                func_71522_a(p_71515_1_, "commands.whitelist.disabled", new Object[0]);
                return;
            }
            if(p_71515_2_[0].equals("list"))
            {
                p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.whitelist.list", new Object[] {
                    Integer.valueOf(MinecraftServer.func_71276_C().func_71203_ab().func_72388_h().size()), Integer.valueOf(MinecraftServer.func_71276_C().func_71203_ab().func_72373_m().length)
                }));
                p_71515_1_.func_70006_a(func_71527_a(MinecraftServer.func_71276_C().func_71203_ab().func_72388_h().toArray(new String[0])));
                return;
            }
            if(p_71515_2_[0].equals("add"))
            {
                if(p_71515_2_.length < 2)
                {
                    throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
                } else
                {
                    MinecraftServer.func_71276_C().func_71203_ab().func_72359_h(p_71515_2_[1]);
                    func_71522_a(p_71515_1_, "commands.whitelist.add.success", new Object[] {
                        p_71515_2_[1]
                    });
                    return;
                }
            }
            if(p_71515_2_[0].equals("remove"))
            {
                if(p_71515_2_.length < 2)
                {
                    throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
                } else
                {
                    MinecraftServer.func_71276_C().func_71203_ab().func_72379_i(p_71515_2_[1]);
                    func_71522_a(p_71515_1_, "commands.whitelist.remove.success", new Object[] {
                        p_71515_2_[1]
                    });
                    return;
                }
            }
            if(p_71515_2_[0].equals("reload"))
            {
                MinecraftServer.func_71276_C().func_71203_ab().func_72362_j();
                func_71522_a(p_71515_1_, "commands.whitelist.reloaded", new Object[0]);
                return;
            }
        }
        throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, new String[] {
                "on", "off", "list", "add", "remove", "reload"
            });
        }
        if(p_71516_2_.length == 2)
        {
            if(p_71516_2_[0].equals("add"))
            {
                String as[] = MinecraftServer.func_71276_C().func_71203_ab().func_72373_m();
                ArrayList arraylist = new ArrayList();
                String s = p_71516_2_[p_71516_2_.length - 1];
                String as1[] = as;
                int i = as1.length;
                for(int j = 0; j < i; j++)
                {
                    String s1 = as1[j];
                    if(func_71523_a(s, s1) && !MinecraftServer.func_71276_C().func_71203_ab().func_72388_h().contains(s1))
                    {
                        arraylist.add(s1);
                    }
                }

                return arraylist;
            }
            if(p_71516_2_[0].equals("remove"))
            {
                return func_71531_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_72388_h());
            }
        }
        return null;
    }
}
