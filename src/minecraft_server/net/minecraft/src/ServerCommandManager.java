package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

public class ServerCommandManager extends CommandHandler implements IAdminCommand
{
    public ServerCommandManager()
    {
        func_71560_a(new CommandTime());
        func_71560_a(new CommandGameMode());
        func_71560_a(new CommandDefaultGameMode());
        func_71560_a(new CommandKill());
        func_71560_a(new CommandToggleDownfall());
        func_71560_a(new CommandXP());
        func_71560_a(new CommandServerTp());
        func_71560_a(new CommandGive());
        func_71560_a(new CommandServerEmote());
        func_71560_a(new CommandShowSeed());
        func_71560_a(new CommandHelp());
        func_71560_a(new CommandDebug());

        if (MinecraftServer.getServer().func_71262_S())
        {
            func_71560_a(new CommandServerOp());
            func_71560_a(new CommandServerDeop());
            func_71560_a(new CommandServerStop());
            func_71560_a(new CommandServerSaveAll());
            func_71560_a(new CommandServerSaveOff());
            func_71560_a(new CommandServerSaveOn());
            func_71560_a(new CommandServerBanIp());
            func_71560_a(new CommandServerPardonIp());
            func_71560_a(new CommandServerBan());
            func_71560_a(new CommandServerBanlist());
            func_71560_a(new CommandServerPardon());
            func_71560_a(new CommandServerKick());
            func_71560_a(new CommandServerList());
            func_71560_a(new CommandServerSay());
            func_71560_a(new CommandServerWhitelist());
        }
        else
        {
            func_71560_a(new CommandServerPublishLocal());
        }

        CommandBase.setAdminCommander(this);
    }

    /**
     * Sends a message to the admins of the server from a given CommandSender with the given resource string and given
     * extra srings. If the int par2 is even or zero, the original sender is also notified.
     */
    public void notifyAdmins(ICommandSender par1ICommandSender, int par2, String par3Str, Object par4ArrayOfObj[])
    {
        Iterator iterator = MinecraftServer.getServer().func_71203_ab().playerEntities.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();

            if (entityplayermp != par1ICommandSender && MinecraftServer.getServer().func_71203_ab().isOp(((EntityPlayer)(entityplayermp)).username))
            {
                entityplayermp.func_70006_a((new StringBuilder()).append("\2477\247o[").append(par1ICommandSender.getCommandSenderName()).append(": ").append(entityplayermp.translateString(par3Str, par4ArrayOfObj)).append("]").toString());
            }
        }
        while (true);

        if (par1ICommandSender != MinecraftServer.getServer())
        {
            MinecraftServer.logger.info((new StringBuilder()).append("[").append(par1ICommandSender.getCommandSenderName()).append(": ").append(MinecraftServer.getServer().translateString(par3Str, par4ArrayOfObj)).append("]").toString());
        }

        if ((par2 & 1) != 1)
        {
            par1ICommandSender.func_70006_a(par1ICommandSender.translateString(par3Str, par4ArrayOfObj));
        }
    }
}
