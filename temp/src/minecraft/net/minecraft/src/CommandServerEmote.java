// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, Packet3Chat, ServerConfigurationManager, 
//            WrongUsageException

public class CommandServerEmote extends CommandBase
{

    public CommandServerEmote()
    {
    }

    public String func_71517_b()
    {
        return "me";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.me.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length > 0)
        {
            String s = func_71520_a(p_71515_2_, 0);
            MinecraftServer.func_71276_C().func_71203_ab().func_72384_a(new Packet3Chat((new StringBuilder()).append("* ").append(p_71515_1_.func_70005_c_()).append(" ").append(s).toString()));
            return;
        } else
        {
            throw new WrongUsageException("commands.me.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
    }
}
