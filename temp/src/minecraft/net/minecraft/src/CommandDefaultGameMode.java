// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandGameMode, ICommandSender, EnumGameType, StatCollector, 
//            WrongUsageException

public class CommandDefaultGameMode extends CommandGameMode
{

    public CommandDefaultGameMode()
    {
    }

    public String func_71517_b()
    {
        return "defaultgamemode";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.defaultgamemode.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length > 0)
        {
            EnumGameType enumgametype = func_71539_b(p_71515_1_, p_71515_2_[0]);
            func_71541_a(enumgametype);
            String s = StatCollector.func_74838_a((new StringBuilder()).append("gameMode.").append(enumgametype.func_77149_b()).toString());
            func_71522_a(p_71515_1_, "commands.defaultgamemode.success", new Object[] {
                s
            });
            return;
        } else
        {
            throw new WrongUsageException("commands.defaultgamemode.usage", new Object[0]);
        }
    }

    protected void func_71541_a(EnumGameType p_71541_1_)
    {
        MinecraftServer.func_71276_C().func_71235_a(p_71541_1_);
    }
}
