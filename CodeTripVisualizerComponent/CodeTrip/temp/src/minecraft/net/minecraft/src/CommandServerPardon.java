// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, ServerConfigurationManager, BanList, 
//            WrongUsageException

public class CommandServerPardon extends CommandBase
{

    public CommandServerPardon()
    {
    }

    public String func_71517_b()
    {
        return "pardon";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.unban.usage", new Object[0]);
    }

    public boolean func_71519_b(ICommandSender p_71519_1_)
    {
        return MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73710_b() && super.func_71519_b(p_71519_1_);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length == 1 && p_71515_2_[0].length() > 0)
        {
            MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73709_b(p_71515_2_[0]);
            func_71522_a(p_71515_1_, "commands.unban.success", new Object[] {
                p_71515_2_[0]
            });
            return;
        } else
        {
            throw new WrongUsageException("commands.unban.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71531_a(p_71516_2_, MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73712_c().keySet());
        } else
        {
            return null;
        }
    }
}
