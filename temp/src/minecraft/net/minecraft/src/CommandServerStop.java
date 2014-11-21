// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender

public class CommandServerStop extends CommandBase
{

    public CommandServerStop()
    {
    }

    public String func_71517_b()
    {
        return "stop";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        func_71522_a(p_71515_1_, "commands.stop.start", new Object[0]);
        MinecraftServer.func_71276_C().func_71263_m();
    }
}
