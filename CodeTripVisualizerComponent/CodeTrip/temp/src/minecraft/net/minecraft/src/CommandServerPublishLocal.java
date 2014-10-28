// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, EnumGameType, ICommandSender

public class CommandServerPublishLocal extends CommandBase
{

    public CommandServerPublishLocal()
    {
    }

    public String func_71517_b()
    {
        return "publish";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        String s = MinecraftServer.func_71276_C().func_71206_a(EnumGameType.SURVIVAL, false);
        if(s != null)
        {
            func_71522_a(p_71515_1_, "commands.publish.started", new Object[] {
                s
            });
        } else
        {
            func_71522_a(p_71515_1_, "commands.publish.failed", new Object[0]);
        }
    }
}
