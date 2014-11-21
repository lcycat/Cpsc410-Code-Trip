// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandHandler, IAdminCommand, CommandTime, CommandGameMode, 
//            CommandDefaultGameMode, CommandKill, CommandToggleDownfall, CommandXP, 
//            CommandServerTp, CommandGive, CommandServerEmote, CommandShowSeed, 
//            CommandHelp, CommandDebug, CommandServerOp, CommandServerDeop, 
//            CommandServerStop, CommandServerSaveAll, CommandServerSaveOff, CommandServerSaveOn, 
//            CommandServerBanIp, CommandServerPardonIp, CommandServerBan, CommandServerBanlist, 
//            CommandServerPardon, CommandServerKick, CommandServerList, CommandServerSay, 
//            CommandServerWhitelist, CommandServerPublishLocal, CommandBase, ServerConfigurationManager, 
//            EntityPlayerMP, EntityPlayer, ICommandSender

public class ServerCommandManager extends CommandHandler
    implements IAdminCommand
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
        if(MinecraftServer.func_71276_C().func_71262_S())
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
        } else
        {
            func_71560_a(new CommandServerPublishLocal());
        }
        CommandBase.func_71529_a(this);
    }

    public void func_71563_a(ICommandSender p_71563_1_, int p_71563_2_, String p_71563_3_, Object p_71563_4_[])
    {
        Iterator iterator = MinecraftServer.func_71276_C().func_71203_ab().field_72404_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            if(entityplayermp != p_71563_1_ && MinecraftServer.func_71276_C().func_71203_ab().func_72353_e(((EntityPlayer) (entityplayermp)).field_71092_bJ))
            {
                entityplayermp.func_70006_a((new StringBuilder()).append("\2477\247o[").append(p_71563_1_.func_70005_c_()).append(": ").append(entityplayermp.func_70004_a(p_71563_3_, p_71563_4_)).append("]").toString());
            }
        } while(true);
        if(p_71563_1_ != MinecraftServer.func_71276_C())
        {
            MinecraftServer.field_71306_a.info((new StringBuilder()).append("[").append(p_71563_1_.func_70005_c_()).append(": ").append(MinecraftServer.func_71276_C().func_70004_a(p_71563_3_, p_71563_4_)).append("]").toString());
        }
        if((p_71563_2_ & 1) != 1)
        {
            p_71563_1_.func_70006_a(p_71563_1_.func_70004_a(p_71563_3_, p_71563_4_));
        }
    }
}
