package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class CommandServerSaveOn extends CommandBase
{
    public CommandServerSaveOn()
    {
    }

    public String getCommandName()
    {
        return "save-on";
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        MinecraftServer minecraftserver = MinecraftServer.getServer();

        for (int i = 0; i < minecraftserver.dimensionServerList.length; i++)
        {
            if (minecraftserver.dimensionServerList[i] != null)
            {
                WorldServer worldserver = minecraftserver.dimensionServerList[i];
                worldserver.canNotSave = false;
            }
        }

        notifyAdmins(par1ICommandSender, "commands.save.enabled", new Object[0]);
    }
}
