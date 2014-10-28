// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, WorldServer, WorldInfo, ICommandSender

public class CommandToggleDownfall extends CommandBase
{

    public CommandToggleDownfall()
    {
    }

    public String func_71517_b()
    {
        return "toggledownfall";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        func_71554_c();
        func_71522_a(p_71515_1_, "commands.downfall.success", new Object[0]);
    }

    protected void func_71554_c()
    {
        MinecraftServer.func_71276_C().field_71305_c[0].func_72913_w();
        MinecraftServer.func_71276_C().field_71305_c[0].func_72912_H().func_76069_a(true);
    }
}
