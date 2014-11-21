package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandXP extends CommandBase
{
    public CommandXP()
    {
    }

    public String getCommandName()
    {
        return "xp";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.xp.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length > 0)
        {
            int i = parseIntBounded(par1ICommandSender, par2ArrayOfStr[0], 0, 5000);
            EntityPlayer entityplayer;

            if (par2ArrayOfStr.length > 1)
            {
                entityplayer = func_71543_a(par2ArrayOfStr[1]);
            }
            else
            {
                entityplayer = getCommandSenderAsPlayer(par1ICommandSender);
            }

            entityplayer.addExperience(i);
            notifyAdmins(par1ICommandSender, "commands.xp.success", new Object[]
                    {
                        Integer.valueOf(i), entityplayer.getEntityName()
                    });
            return;
        }
        else
        {
            throw new WrongUsageException("commands.xp.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 2)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, func_71542_c());
        }
        else
        {
            return null;
        }
    }

    protected EntityPlayer func_71543_a(String par1Str)
    {
        EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(par1Str);

        if (entityplayermp == null)
        {
            throw new PlayerNotFoundException();
        }
        else
        {
            return entityplayermp;
        }
    }

    protected String[] func_71542_c()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
