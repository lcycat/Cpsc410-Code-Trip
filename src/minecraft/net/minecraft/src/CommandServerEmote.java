package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerEmote extends CommandBase
{
    public CommandServerEmote()
    {
    }

    public String getCommandName()
    {
        return "me";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.me.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length > 0)
        {
            String s = joinString(par2ArrayOfStr, 0);
            MinecraftServer.getServer().getConfigurationManager().sendPacketToAllPlayers(new Packet3Chat((new StringBuilder()).append("* ").append(par1ICommandSender.getCommandSenderName()).append(" ").append(s).toString()));
            return;
        }
        else
        {
            throw new WrongUsageException("commands.me.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        return getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames());
    }
}
