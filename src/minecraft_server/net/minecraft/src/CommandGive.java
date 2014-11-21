package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandGive extends CommandBase
{
    public CommandGive()
    {
    }

    public String getCommandName()
    {
        return "give";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.give.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length >= 2)
        {
            EntityPlayer entityplayer = func_71537_a(par2ArrayOfStr[0]);
            int i = parseIntWithMin(par1ICommandSender, par2ArrayOfStr[1], 1);
            int j = 1;
            int k = 0;

            if (Item.itemsList[i] == null)
            {
                throw new NumberInvalidException("commands.give.notFound", new Object[]
                        {
                            Integer.valueOf(i)
                        });
            }

            if (par2ArrayOfStr.length >= 3)
            {
                j = parseIntBounded(par1ICommandSender, par2ArrayOfStr[2], 1, 64);
            }

            if (par2ArrayOfStr.length >= 4)
            {
                k = parseInt(par1ICommandSender, par2ArrayOfStr[3]);
            }

            ItemStack itemstack = new ItemStack(i, j, k);
            entityplayer.dropPlayerItem(itemstack);
            func_71522_a(par1ICommandSender, "commands.give.success", new Object[]
                    {
                        Item.itemsList[i].func_77653_i(itemstack), Integer.valueOf(i), Integer.valueOf(j), entityplayer.getEntityName()
                    });
            return;
        }
        else
        {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, func_71536_c());
        }
        else
        {
            return null;
        }
    }

    protected EntityPlayer func_71537_a(String par1Str)
    {
        EntityPlayerMP entityplayermp = MinecraftServer.getServer().func_71203_ab().getPlayerEntity(par1Str);

        if (entityplayermp == null)
        {
            throw new PlayerNotFoundException();
        }
        else
        {
            return entityplayermp;
        }
    }

    protected String[] func_71536_c()
    {
        return MinecraftServer.getServer().getPlayerNamesAsList();
    }
}
