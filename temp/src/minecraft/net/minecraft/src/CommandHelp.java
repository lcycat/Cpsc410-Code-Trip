// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, NumberInvalidException, ICommand, 
//            WrongUsageException, CommandNotFoundException, ICommandManager

public class CommandHelp extends CommandBase
{

    public CommandHelp()
    {
    }

    public String func_71517_b()
    {
        return "help";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.help.usage", new Object[0]);
    }

    public List func_71514_a()
    {
        return Arrays.asList(new String[] {
            "?"
        });
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        List list = func_71534_d(p_71515_1_);
        byte byte0 = 7;
        int i = list.size() / byte0;
        int j = 0;
        try
        {
            j = p_71515_2_.length != 0 ? func_71532_a(p_71515_1_, p_71515_2_[0], 1, i + 1) - 1 : 0;
        }
        catch(NumberInvalidException numberinvalidexception)
        {
            Map map = func_71535_c();
            ICommand icommand = (ICommand)map.get(p_71515_2_[0]);
            if(icommand != null)
            {
                throw new WrongUsageException(icommand.func_71518_a(p_71515_1_), new Object[0]);
            } else
            {
                throw new CommandNotFoundException();
            }
        }
        int k = Math.min((j + 1) * byte0, list.size());
        p_71515_1_.func_70006_a((new StringBuilder()).append("\2472").append(p_71515_1_.func_70004_a("commands.help.header", new Object[] {
            Integer.valueOf(j + 1), Integer.valueOf(i + 1)
        })).toString());
        for(int l = j * byte0; l < k; l++)
        {
            ICommand icommand1 = (ICommand)list.get(l);
            p_71515_1_.func_70006_a(icommand1.func_71518_a(p_71515_1_));
        }

        if(j == 0)
        {
            p_71515_1_.func_70006_a((new StringBuilder()).append("\247a").append(p_71515_1_.func_70004_a("commands.help.footer", new Object[0])).toString());
        }
    }

    protected List func_71534_d(ICommandSender p_71534_1_)
    {
        List list = MinecraftServer.func_71276_C().func_71187_D().func_71557_a(p_71534_1_);
        Collections.sort(list);
        return list;
    }

    protected Map func_71535_c()
    {
        return MinecraftServer.func_71276_C().func_71187_D().func_71555_a();
    }
}
