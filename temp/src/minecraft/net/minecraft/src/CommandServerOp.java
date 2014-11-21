// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, ServerConfigurationManager, WrongUsageException

public class CommandServerOp extends CommandBase
{

    public CommandServerOp()
    {
    }

    public String func_71517_b()
    {
        return "op";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.op.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0)
        {
            MinecraftServer.func_71276_C().func_71203_ab().func_72386_b(p_71515_2_[0]);
            func_71522_a(p_71515_1_, "commands.op.success", new Object[] {
                p_71515_2_[0]
            });
            return;
        } else
        {
            throw new WrongUsageException("commands.op.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            String s = p_71516_2_[p_71516_2_.length - 1];
            ArrayList arraylist = new ArrayList();
            String as[] = MinecraftServer.func_71276_C().func_71213_z();
            int i = as.length;
            for(int j = 0; j < i; j++)
            {
                String s1 = as[j];
                if(!MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(s1) && func_71523_a(s, s1))
                {
                    arraylist.add(s1);
                }
            }

            return arraylist;
        } else
        {
            return null;
        }
    }
}
