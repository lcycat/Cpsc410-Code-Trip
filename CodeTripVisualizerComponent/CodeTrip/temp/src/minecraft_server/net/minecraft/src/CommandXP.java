// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, EntityPlayer, WrongUsageException, 
//            ServerConfigurationManager, PlayerNotFoundException

public class CommandXP extends CommandBase
{

    public CommandXP()
    {
    }

    public String func_71517_b()
    {
        return "xp";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.xp.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length > 0)
        {
            int i = func_71532_a(p_71515_1_, p_71515_2_[0], 0, 5000);
            EntityPlayer entityplayer;
            if(p_71515_2_.length > 1)
            {
                entityplayer = func_71543_a(p_71515_2_[1]);
            } else
            {
                entityplayer = func_71521_c(p_71515_1_);
            }
            entityplayer.func_71023_q(i);
            func_71522_a(p_71515_1_, "commands.xp.success", new Object[] {
                Integer.valueOf(i), entityplayer.func_70023_ak()
            });
            return;
        } else
        {
            throw new WrongUsageException("commands.xp.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 2)
        {
            return func_71530_a(p_71516_2_, func_71542_c());
        } else
        {
            return null;
        }
    }

    protected EntityPlayer func_71543_a(String p_71543_1_)
    {
        EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71543_1_);
        if(entityplayermp == null)
        {
            throw new PlayerNotFoundException();
        } else
        {
            return entityplayermp;
        }
    }

    protected String[] func_71542_c()
    {
        return MinecraftServer.func_71276_C().func_71213_z();
    }
}
