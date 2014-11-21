package net.minecraft.src;

import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public class CommandServerPardon extends CommandBase
{
    public CommandServerPardon()
    {
    }

    public String getCommandName()
    {
        return "pardon";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.unban.usage", new Object[0]);
    }

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
        return MinecraftServer.getServer().func_71203_ab().func_72390_e().func_73710_b() && super.canCommandSenderUseCommand(par1ICommandSender);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1 && par2ArrayOfStr[0].length() > 0)
        {
            MinecraftServer.getServer().func_71203_ab().func_72390_e().func_73709_b(par2ArrayOfStr[0]);
            func_71522_a(par1ICommandSender, "commands.unban.success", new Object[]
                    {
                        par2ArrayOfStr[0]
                    });
            return;
        }
        else
        {
            throw new WrongUsageException("commands.unban.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1)
        {
            return getListOfStringsFromIterableMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().func_71203_ab().func_72390_e().func_73712_c().keySet());
        }
        else
        {
            return null;
        }
    }
}
