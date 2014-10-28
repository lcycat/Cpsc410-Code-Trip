package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class CommandServerSaveOff extends CommandBase
{
    public CommandServerSaveOff()
    {
    }

    public String getCommandName()
    {
        return "save-off";
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        MinecraftServer minecraftserver = MinecraftServer.getServer();

        for (int i = 0; i < minecraftserver.dimensionServerList.length; i++)
        {
            if (minecraftserver.dimensionServerList[i] != null)
            {
                WorldServer worldserver = minecraftserver.dimensionServerList[i];
                worldserver.canNotSave = true;
            }
        }

        notifyAdmins(par1ICommandSender, "commands.save.disabled", new Object[0]);
    }
}
