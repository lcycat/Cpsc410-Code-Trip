package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class CommandServerSaveAll extends CommandBase
{
    public CommandServerSaveAll()
    {
    }

    public String getCommandName()
    {
        return "save-all";
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        MinecraftServer minecraftserver = MinecraftServer.getServer();
        par1ICommandSender.func_70006_a(par1ICommandSender.translateString("commands.save.start", new Object[0]));

        if (minecraftserver.func_71203_ab() != null)
        {
            minecraftserver.func_71203_ab().savePlayerStates();
        }

        try
        {
            for (int i = 0; i < minecraftserver.worldMngr.length; i++)
            {
                if (minecraftserver.worldMngr[i] != null)
                {
                    WorldServer worldserver = minecraftserver.worldMngr[i];
                    boolean flag = worldserver.levelSaving;
                    worldserver.levelSaving = false;
                    worldserver.saveAllChunks(true, null);
                    worldserver.levelSaving = flag;
                }
            }
        }
        catch (MinecraftException minecraftexception)
        {
            func_71522_a(par1ICommandSender, "commands.save.failed", new Object[]
                    {
                        minecraftexception.getMessage()
                    });
            return;
        }

        func_71522_a(par1ICommandSender, "commands.save.success", new Object[0]);
    }
}
