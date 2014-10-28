package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerKick extends CommandBase
{
    public CommandServerKick()
    {
    }

    public String getCommandName()
    {
        return "kick";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.kick.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length > 0 && par2ArrayOfStr[0].length() > 1)
        {
            EntityPlayerMP entityplayermp = MinecraftServer.getServer().func_71203_ab().getPlayerEntity(par2ArrayOfStr[0]);
            String s = "Kicked by an operator.";
            boolean flag = false;

            if (entityplayermp == null)
            {
                throw new PlayerNotFoundException();
            }

            if (par2ArrayOfStr.length >= 2)
            {
                s = joinString(par2ArrayOfStr, 1);
                flag = true;
            }

            entityplayermp.playerNetServerHandler.kickPlayer(s);

            if (flag)
            {
                func_71522_a(par1ICommandSender, "commands.kick.success.reason", new Object[]
                        {
                            entityplayermp.getEntityName(), s
                        });
            }
            else
            {
                func_71522_a(par1ICommandSender, "commands.kick.success", new Object[]
                        {
                            entityplayermp.getEntityName()
                        });
            }

            return;
        }
        else
        {
            throw new WrongUsageException("commands.kick.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length >= 1)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getPlayerNamesAsList());
        }
        else
        {
            return null;
        }
    }
}
