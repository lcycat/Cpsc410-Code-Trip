package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerOp extends CommandBase
{
    public CommandServerOp()
    {
    }

    public String getCommandName()
    {
        return "op";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.op.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1 && par2ArrayOfStr[0].length() > 0)
        {
            MinecraftServer.getServer().getConfigurationManager().addNameToWhitelist(par2ArrayOfStr[0]);
            notifyAdmins(par1ICommandSender, "commands.op.success", new Object[]
                    {
                        par2ArrayOfStr[0]
                    });
            return;
        }
        else
        {
            throw new WrongUsageException("commands.op.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1)
        {
            String s = par2ArrayOfStr[par2ArrayOfStr.length - 1];
            ArrayList arraylist = new ArrayList();
            String as[] = MinecraftServer.getServer().getAllUsernames();
            int i = as.length;

            for (int j = 0; j < i; j++)
            {
                String s1 = as[j];

                if (!MinecraftServer.getServer().getConfigurationManager().areCommandsAllowed(s1) && doesStringStartWith(s, s1))
                {
                    arraylist.add(s1);
                }
            }

            return arraylist;
        }
        else
        {
            return null;
        }
    }
}
