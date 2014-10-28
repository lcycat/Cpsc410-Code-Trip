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

        for (int i = 0; i < minecraftserver.worldMngr.length; i++)
        {
            if (minecraftserver.worldMngr[i] != null)
            {
                WorldServer worldserver = minecraftserver.worldMngr[i];
                worldserver.levelSaving = true;
            }
        }

        func_71522_a(par1ICommandSender, "commands.save.disabled", new Object[0]);
    }
}
