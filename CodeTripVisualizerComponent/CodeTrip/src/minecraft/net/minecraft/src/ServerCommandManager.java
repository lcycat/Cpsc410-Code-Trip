package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ServerCommandManager extends CommandHandler implements IAdminCommand
{
    public ServerCommandManager()
    {
        registerCommand(new CommandTime());
        registerCommand(new CommandGameMode());
        registerCommand(new CommandDefaultGameMode());
        registerCommand(new CommandKill());
        registerCommand(new CommandToggleDownfall());
        registerCommand(new CommandXP());
        registerCommand(new CommandServerTp());
        registerCommand(new CommandGive());
        registerCommand(new CommandServerEmote());
        registerCommand(new CommandShowSeed());
        registerCommand(new CommandHelp());
        registerCommand(new CommandDebug());

        if (MinecraftServer.getServer().isDedicatedServer())
        {
            registerCommand(new CommandServerOp());
            registerCommand(new CommandServerDeop());
            registerCommand(new CommandServerStop());
            registerCommand(new CommandServerSaveAll());
            registerCommand(new CommandServerSaveOff());
            registerCommand(new CommandServerSaveOn());
            registerCommand(new CommandServerBanIp());
            registerCommand(new CommandServerPardonIp());
            registerCommand(new CommandServerBan());
            registerCommand(new CommandServerBanlist());
            registerCommand(new CommandServerPardon());
            registerCommand(new CommandServerKick());
            registerCommand(new CommandServerList());
            registerCommand(new CommandServerSay());
            registerCommand(new CommandServerWhitelist());
        }
        else
        {
            registerCommand(new CommandServerPublishLocal());
        }

        CommandBase.setAdminCommander(this);
    }

    /**
     * Sends a message to the admins of the server from a given CommandSender with the given resource string and given
     * extra srings. If the int par2 is even or zero, the original sender is also notified.
     */
    public void notifyAdmins(ICommandSender par1ICommandSender, int par2, String par3Str, Object par4ArrayOfObj[])
    {
        Iterator iterator = MinecraftServer.getServer().getConfigurationManager().playerList.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp != par1ICommandSender && MinecraftServer.getServer().getConfigurationManager().areCommandsAllowed(((EntityPlayer)(entityplayermp)).username))
            {
                entityplayermp.sendChatToPlayer((new StringBuilder()).append("\2477\247o[").append(par1ICommandSender.getCommandSenderName()).append(": ").append(entityplayermp.translateString(par3Str, par4ArrayOfObj)).append("]").toString());
            }
        }
        while (true);

        if (par1ICommandSender != MinecraftServer.getServer())
        {
            MinecraftServer.logger.info((new StringBuilder()).append("[").append(par1ICommandSender.getCommandSenderName()).append(": ").append(MinecraftServer.getServer().translateString(par3Str, par4ArrayOfObj)).append("]").toString());
        }

        if ((par2 & 1) != 1)
        {
            par1ICommandSender.sendChatToPlayer(par1ICommandSender.translateString(par3Str, par4ArrayOfObj));
        }
    }
}
