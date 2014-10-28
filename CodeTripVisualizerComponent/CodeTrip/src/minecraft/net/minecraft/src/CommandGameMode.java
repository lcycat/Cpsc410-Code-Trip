package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandGameMode extends CommandBase
{
    public CommandGameMode()
    {
    }

    public String getCommandName()
    {
        return "gamemode";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.gamemode.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length > 0)
        {
            EnumGameType enumgametype = getGameModeFromCommand(par1ICommandSender, par2ArrayOfStr[0]);
            EntityPlayer entityplayer = par2ArrayOfStr.length < 2 ? getCommandSenderAsPlayer(par1ICommandSender) : func_71540_a(par2ArrayOfStr[1]);
            entityplayer.sendGameTypeToPlayer(enumgametype);
            String s = StatCollector.translateToLocal((new StringBuilder()).append("gameMode.").append(enumgametype.getName()).toString());

            if (entityplayer != par1ICommandSender)
            {
                notifyAdmins(par1ICommandSender, 1, "commands.gamemode.success.other", new Object[]
                        {
                            entityplayer.getEntityName(), s
                        });
            }
            else
            {
                notifyAdmins(par1ICommandSender, 1, "commands.gamemode.success.self", new Object[]
                        {
                            s
                        });
            }

            return;
        }
        else
        {
            throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
        }
    }

    /**
     * Gets the Game Mode specified in the command.
     */
    protected EnumGameType getGameModeFromCommand(ICommandSender par1ICommandSender, String par2Str)
    {
        if (par2Str.equalsIgnoreCase(EnumGameType.SURVIVAL.getName()) || par2Str.equalsIgnoreCase("s"))
        {
            return EnumGameType.SURVIVAL;
        }

        if (par2Str.equalsIgnoreCase(EnumGameType.CREATIVE.getName()) || par2Str.equalsIgnoreCase("c"))
        {
            return EnumGameType.CREATIVE;
        }

        if (par2Str.equalsIgnoreCase(EnumGameType.ADVENTURE.getName()) || par2Str.equalsIgnoreCase("a"))
        {
            return EnumGameType.ADVENTURE;
        }
        else
        {
            return WorldSettings.getGameTypeById(parseIntBounded(par1ICommandSender, par2Str, 0, EnumGameType.values().length - 2));
        }
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
                        "survival", "creative", "adventure"
                    });
        }

        if (par2ArrayOfStr.length == 2)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, func_71538_c());
        }
        else
        {
            return null;
        }
    }

    protected EntityPlayer func_71540_a(String par1Str)
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

    protected String[] func_71538_c()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
