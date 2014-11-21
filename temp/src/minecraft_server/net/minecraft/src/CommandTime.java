// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, WrongUsageException, WorldServer

public class CommandTime extends CommandBase
{

    public CommandTime()
    {
    }

    public String func_71517_b()
    {
        return "time";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.time.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length > 1)
        {
            if(p_71515_2_[0].equals("set"))
            {
                int i;
                if(p_71515_2_[1].equals("day"))
                {
                    i = 0;
                } else
                if(p_71515_2_[1].equals("night"))
                {
                    i = 12500;
                } else
                {
                    i = func_71528_a(p_71515_1_, p_71515_2_[1], 0);
                }
                func_71552_a(p_71515_1_, i);
                func_71522_a(p_71515_1_, "commands.time.set", new Object[] {
                    Integer.valueOf(i)
                });
                return;
            }
            if(p_71515_2_[0].equals("add"))
            {
                int j = func_71528_a(p_71515_1_, p_71515_2_[1], 0);
                func_71553_b(p_71515_1_, j);
                func_71522_a(p_71515_1_, "commands.time.added", new Object[] {
                    Integer.valueOf(j)
                });
                return;
            }
        }
        throw new WrongUsageException("commands.time.usage", new Object[0]);
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, new String[] {
                "set", "add"
            });
        }
        if(p_71516_2_.length == 2 && p_71516_2_[0].equals("set"))
        {
            return func_71530_a(p_71516_2_, new String[] {
                "day", "night"
            });
        } else
        {
            return null;
        }
    }

    protected void func_71552_a(ICommandSender p_71552_1_, int p_71552_2_)
    {
        for(int i = 0; i < MinecraftServer.func_71276_C().field_71305_c.length; i++)
        {
            MinecraftServer.func_71276_C().field_71305_c[i].func_73048_a(p_71552_2_);
        }

    }

    protected void func_71553_b(ICommandSender p_71553_1_, int p_71553_2_)
    {
        for(int i = 0; i < MinecraftServer.func_71276_C().field_71305_c.length; i++)
        {
            WorldServer worldserver = MinecraftServer.func_71276_C().field_71305_c[i];
            worldserver.func_73048_a(worldserver.func_72820_D() + (long)p_71553_2_);
        }

    }
}
