// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, ServerConfigurationManager, BanList, 
//            BanEntry, EntityPlayerMP, NetServerHandler, WrongUsageException

public class CommandServerBan extends CommandBase
{

    public CommandServerBan()
    {
    }

    public String func_71517_b()
    {
        return "ban";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.ban.usage", new Object[0]);
    }

    public boolean func_71519_b(ICommandSender p_71519_1_)
    {
        return MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73710_b() && super.func_71519_b(p_71519_1_);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length >= 1 && p_71515_2_[0].length() > 0)
        {
            EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71515_2_[0]);
            BanEntry banentry = new BanEntry(p_71515_2_[0]);
            banentry.func_73687_a(p_71515_1_.func_70005_c_());
            if(p_71515_2_.length >= 2)
            {
                banentry.func_73689_b(func_71520_a(p_71515_2_, 1));
            }
            MinecraftServer.func_71276_C().func_71203_ab().func_72390_e().func_73706_a(banentry);
            if(entityplayermp != null)
            {
                entityplayermp.field_71135_a.func_72565_c("You are banned from this server.");
            }
            func_71522_a(p_71515_1_, "commands.ban.success", new Object[] {
                p_71515_2_[0]
            });
            return;
        } else
        {
            throw new WrongUsageException("commands.ban.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length >= 1)
        {
            return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
        } else
        {
            return null;
        }
    }
}
