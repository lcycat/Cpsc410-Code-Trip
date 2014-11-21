// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, ServerConfigurationManager

public class CommandServerList extends CommandBase
{

    public CommandServerList()
    {
    }

    public String func_71517_b()
    {
        return "list";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        p_71515_1_.func_70006_a(p_71515_1_.func_70004_a("commands.players.list", new Object[] {
            Integer.valueOf(MinecraftServer.func_71276_C().func_71233_x()), Integer.valueOf(MinecraftServer.func_71276_C().func_71275_y())
        }));
        p_71515_1_.func_70006_a(MinecraftServer.func_71276_C().func_71203_ab().func_72398_c());
    }
}
