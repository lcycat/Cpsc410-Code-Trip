package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

public class CommandServerTp extends CommandBase
{
    public CommandServerTp()
    {
    }

    public String getCommandName()
    {
        return "tp";
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.translateString("commands.tp.usage", new Object[0]);
    }

    public void processCommand(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length >= 1)
        {
            MinecraftServer minecraftserver = MinecraftServer.getServer();
            EntityPlayerMP entityplayermp;

            if (par2ArrayOfStr.length == 2 || par2ArrayOfStr.length == 4)
            {
                entityplayermp = minecraftserver.getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[0]);

                if (entityplayermp == null)
                {
                    throw new PlayerNotFoundException();
                }
            }
            else
            {
                entityplayermp = (EntityPlayerMP)getCommandSenderAsPlayer(par1ICommandSender);
            }

            if (par2ArrayOfStr.length == 3 || par2ArrayOfStr.length == 4)
            {
                if (entityplayermp.worldObj != null)
                {
                    int i = par2ArrayOfStr.length - 3;
                    int j = 0x1c9c380;
                    int k = parseIntBounded(par1ICommandSender, par2ArrayOfStr[i++], -j, j);
                    int l = parseIntBounded(par1ICommandSender, par2ArrayOfStr[i++], 0, 256);
                    int i1 = parseIntBounded(par1ICommandSender, par2ArrayOfStr[i++], -j, j);
                    entityplayermp.setPositionAndUpdate((float)k + 0.5F, l, (float)i1 + 0.5F);
                    notifyAdmins(par1ICommandSender, "commands.tp.coordinates", new Object[]
                            {
                                entityplayermp.getEntityName(), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i1)
                            });
                }
            }
            else if (par2ArrayOfStr.length == 1 || par2ArrayOfStr.length == 2)
            {
                EntityPlayerMP entityplayermp1 = minecraftserver.getConfigurationManager().getPlayerForUsername(par2ArrayOfStr[par2ArrayOfStr.length - 1]);

                if (entityplayermp1 == null)
                {
                    throw new PlayerNotFoundException();
                }

                entityplayermp.serverForThisPlayer.setPlayerLocation(entityplayermp1.posX, entityplayermp1.posY, entityplayermp1.posZ, entityplayermp1.rotationYaw, entityplayermp1.rotationPitch);
                notifyAdmins(par1ICommandSender, "commands.tp.success", new Object[]
                        {
                            entityplayermp.getEntityName(), entityplayermp1.getEntityName()
                        });
            }

            return;
        }
        else
        {
            throw new WrongUsageException("commands.tp.usage", new Object[0]);
        }
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        if (par2ArrayOfStr.length == 1 || par2ArrayOfStr.length == 2)
        {
            return getListOfStringsMatchingLastWord(par2ArrayOfStr, MinecraftServer.getServer().getAllUsernames());
        }
        else
        {
            return null;
        }
    }
}
