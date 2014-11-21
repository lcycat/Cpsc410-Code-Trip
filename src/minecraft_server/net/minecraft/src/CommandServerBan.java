package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerBan extends CommandBase
{
    public CommandServerBan()
    {
    }

    public String getCommandName()
    {
        return "ban";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.ban.usage", new Object[0]);
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
        if (par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 0)
        {
            EntityPlayerMP entityplayermp = MinecraftServer.getServer().func_71203_ab().getPlayerEntity(par2ArrayOfStr[0]);
            BanEntry banentry = new BanEntry(par2ArrayOfStr[0]);
            banentry.func_73687_a(par1ICommandSender.getCommandSenderName());

            if (par2ArrayOfStr.length >= 2)
            {
                banentry.func_73689_b(joinString(par2ArrayOfStr, 1));
            }

            MinecraftServer.getServer().func_71203_ab().func_72390_e().func_73706_a(banentry);

            if (entityplayermp != null)
            {
                entityplayermp.playerNetServerHandler.kickPlayer("You are banned from this server.");
            }

            func_71522_a(par1ICommandSender, "commands.ban.success", new Object[]
                    {
                        par2ArrayOfStr[0]
                    });
            return;
        }
        else
        {
            throw new WrongUsageException("commands.ban.usage", new Object[0]);
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
