package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class CommandServerPublishLocal extends CommandBase
{
    public CommandServerPublishLocal()
    {
    }

    public String getCommandName()
    {
        return "publish";
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        String s = MinecraftServer.getServer().shareToLAN(EnumGameType.SURVIVAL, false);

        if (s != null)
        {
            notifyAdmins(par1ICommandSender, "commands.publish.started", new Object[]
                    {
                        s
                    });
        }
        else
        {
            notifyAdmins(par1ICommandSender, "commands.publish.failed", new Object[0]);
        }
    }
}
