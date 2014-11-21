package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandTime extends CommandBase
{
    public CommandTime()
    {
    }

    public String getCommandName()
    {
        return "time";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.time.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length > 1)
        {
            if (par2ArrayOfStr[0].equals("set"))
            {
                int i;

                if (par2ArrayOfStr[1].equals("day"))
                {
                    i = 0;
                }
                else if (par2ArrayOfStr[1].equals("night"))
                {
                    i = 12500;
                }
                else
                {
                    i = parseIntWithMin(par1ICommandSender, par2ArrayOfStr[1], 0);
                }

                func_71552_a(par1ICommandSender, i);
                notifyAdmins(par1ICommandSender, "commands.time.set", new Object[]
                        {
                            Integer.valueOf(i)
                        });
                return;
            }

            if (par2ArrayOfStr[0].equals("add"))
            {
                int j = parseIntWithMin(par1ICommandSender, par2ArrayOfStr[1], 0);
                addTime(par1ICommandSender, j);
                notifyAdmins(par1ICommandSender, "commands.time.added", new Object[]
                        {
                            Integer.valueOf(j)
                        });
                return;
            }
        }

        throw new WrongUsageException("commands.time.usage", new Object[0]);
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
                        "set", "add"
                    });
        }

        if (par2ArrayOfStr.length == 2 && par2ArrayOfStr[0].equals("set"))
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[]
                    {
                        "day", "night"
                    });
        }
        else
        {
            return null;
        }
    }

    protected void func_71552_a(ICommandSender par1ICommandSender, int par2)
    {
        for (int i = 0; i < MinecraftServer.getServer().dimensionServerList.length; i++)
        {
            MinecraftServer.getServer().dimensionServerList[i].setTime(par2);
        }
    }

    /**
     * Adds (or removes) time in the server object.
     */
    protected void addTime(ICommandSender par1ICommandSender, int par2)
    {
        for (int i = 0; i < MinecraftServer.getServer().dimensionServerList.length; i++)
        {
            WorldServer worldserver = MinecraftServer.getServer().dimensionServerList[i];
            worldserver.setTime(worldserver.getWorldTime() + (long)par2);
        }
    }
}
