package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class CommandServerBanIp extends CommandBase
{
    public static final Pattern field_71545_a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public CommandServerBanIp()
    {
    }

    public String getCommandName()
    {
        return "ban-ip";
    }

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
        return MinecraftServer.getServer().func_71203_ab().func_72363_f().func_73710_b() && super.canCommandSenderUseCommand(par1ICommandSender);
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.banip.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length >= 1 && par2ArrayOfStr[0].length() > 1)
        {
            Matcher matcher = field_71545_a.matcher(par2ArrayOfStr[0]);
            String s = null;

            if (par2ArrayOfStr.length >= 2)
            {
                s = joinString(par2ArrayOfStr, 1);
            }

            if (matcher.matches())
            {
                func_71544_a(par1ICommandSender, par2ArrayOfStr[0], s);
            }
            else
            {
                EntityPlayerMP entityplayermp = MinecraftServer.getServer().func_71203_ab().getPlayerEntity(par2ArrayOfStr[0]);

                if (entityplayermp == null)
                {
                    throw new PlayerNotFoundException("commands.banip.invalid", new Object[0]);
                }

                func_71544_a(par1ICommandSender, entityplayermp.func_71114_r(), s);
            }

            return;
        }
        else
        {
            throw new WrongUsageException("commands.banip.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getPlayerNamesAsList());
        }
        else
        {
            return null;
        }
    }

    protected void func_71544_a(ICommandSender par1ICommandSender, String par2Str, String par3Str)
    {
        BanEntry banentry = new BanEntry(par2Str);
        banentry.func_73687_a(par1ICommandSender.getCommandSenderName());

        if (par3Str != null)
        {
            banentry.func_73689_b(par3Str);
        }

        MinecraftServer.getServer().func_71203_ab().func_72363_f().func_73706_a(banentry);
        List list = MinecraftServer.getServer().func_71203_ab().func_72382_j(par2Str);
        String as[] = new String[list.size()];
        int i = 0;

        for (Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            entityplayermp.playerNetServerHandler.kickPlayer("You have been IP banned.");
            as[i++] = entityplayermp.getEntityName();
        }

        if (list.isEmpty())
        {
            func_71522_a(par1ICommandSender, "commands.banip.success", new Object[]
                    {
                        par2Str
                    });
        }
        else
        {
            func_71522_a(par1ICommandSender, "commands.banip.success.players", new Object[]
                    {
                        par2Str, joinNiceString(as)
                    });
        }
    }
}
