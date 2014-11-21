package net.minecraft.src;

import java.util.*;
import net.minecraft.server.MinecraftServer;

public class CommandServerWhitelist extends CommandBase
{
    public CommandServerWhitelist()
    {
    }

    public String getCommandName()
    {
        return "whitelist";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.whitelist.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length >= 1)
        {
            if (par2ArrayOfStr[0].equals("on"))
            {
                MinecraftServer.getServer().func_71203_ab().func_72371_a(true);
                func_71522_a(par1ICommandSender, "commands.whitelist.enabled", new Object[0]);
                return;
            }

            if (par2ArrayOfStr[0].equals("off"))
            {
                MinecraftServer.getServer().func_71203_ab().func_72371_a(false);
                func_71522_a(par1ICommandSender, "commands.whitelist.disabled", new Object[0]);
                return;
            }

            if (par2ArrayOfStr[0].equals("list"))
            {
                par1ICommandSender.func_70006_a(par1ICommandSender.translateString("commands.whitelist.list", new Object[]
                        {
                            Integer.valueOf(MinecraftServer.getServer().func_71203_ab().getWhiteListedIPs().size()), Integer.valueOf(MinecraftServer.getServer().func_71203_ab().func_72373_m().length)
                        }));
                par1ICommandSender.func_70006_a(joinNiceString(MinecraftServer.getServer().func_71203_ab().getWhiteListedIPs().toArray(new String[0])));
                return;
            }

            if (par2ArrayOfStr[0].equals("add"))
            {
                if (par2ArrayOfStr.length < 2)
                {
                    throw new WrongUsageException("commands.whitelist.add.usage", new Object[0]);
                }
                else
                {
                    MinecraftServer.getServer().func_71203_ab().addToWhiteList(par2ArrayOfStr[1]);
                    func_71522_a(par1ICommandSender, "commands.whitelist.add.success", new Object[]
                            {
                                par2ArrayOfStr[1]
                            });
                    return;
                }
            }

            if (par2ArrayOfStr[0].equals("remove"))
            {
                if (par2ArrayOfStr.length < 2)
                {
                    throw new WrongUsageException("commands.whitelist.remove.usage", new Object[0]);
                }
                else
                {
                    MinecraftServer.getServer().func_71203_ab().removeFromWhiteList(par2ArrayOfStr[1]);
                    func_71522_a(par1ICommandSender, "commands.whitelist.remove.success", new Object[]
                            {
                                par2ArrayOfStr[1]
                            });
                    return;
                }
            }

            if (par2ArrayOfStr[0].equals("reload"))
            {
                MinecraftServer.getServer().func_71203_ab().reloadWhiteList();
                func_71522_a(par1ICommandSender, "commands.whitelist.reloaded", new Object[0]);
                return;
            }
        }

        throw new WrongUsageException("commands.whitelist.usage", new Object[0]);
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[]
                    {
                        "on", "off", "list", "add", "remove", "reload"
                    });
        }

        if (par2ArrayOfStr.length == 2)
        {
            if (par2ArrayOfStr[0].equals("add"))
            {
                String as[] = MinecraftServer.getServer().func_71203_ab().func_72373_m();
                ArrayList arraylist = new ArrayList();
                String s = par2ArrayOfStr[par2ArrayOfStr.length - 1];
                String as1[] = as;
                int i = as1.length;

                for (int j = 0; j < i; j++)
                {
                    String s1 = as1[j];

                    if (doesStringStartWith(s, s1) && !MinecraftServer.getServer().func_71203_ab().getWhiteListedIPs().contains(s1))
                    {
                        arraylist.add(s1);
                    }
                }

                return arraylist;
            }

            if (par2ArrayOfStr[0].equals("remove"))
            {
                return getListOfStringsFromIterableMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().func_71203_ab().getWhiteListedIPs());
            }
        }

        return null;
    }
}
