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
        par1ICommandSender.sendChatToPlayer(par1ICommandSender.translateString("commands.save.start", new Object[0]));

        if (minecraftserver.getConfigurationManager() != null)
        {
            minecraftserver.getConfigurationManager().saveAllPlayerData();
        }

        try
        {
            for (int i = 0; i < minecraftserver.dimensionServerList.length; i++)
            {
                if (minecraftserver.dimensionServerList[i] != null)
                {
                    WorldServer worldserver = minecraftserver.dimensionServerList[i];
                    boolean flag = worldserver.canNotSave;
                    worldserver.canNotSave = false;
                    worldserver.saveAllChunks(true, null);
                    worldserver.canNotSave = flag;
                }
            }
        }
        catch (MinecraftException minecraftexception)
        {
            notifyAdmins(par1ICommandSender, "commands.save.failed", new Object[]
                    {
                        minecraftexception.getMessage()
                    });
            return;
        }

        notifyAdmins(par1ICommandSender, "commands.save.success", new Object[0]);
    }
}
