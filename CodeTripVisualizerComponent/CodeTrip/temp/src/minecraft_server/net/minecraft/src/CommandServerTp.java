// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, ServerConfigurationManager, PlayerNotFoundException, 
//            EntityPlayerMP, NetServerHandler, WrongUsageException

public class CommandServerTp extends CommandBase
{

    public CommandServerTp()
    {
    }

    public String func_71517_b()
    {
        return "tp";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.tp.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length >= 1)
        {
            MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
            EntityPlayerMP entityplayermp;
            if(p_71515_2_.length == 2 || p_71515_2_.length == 4)
            {
                entityplayermp = minecraftserver.func_71203_ab().func_72361_f(p_71515_2_[0]);
                if(entityplayermp == null)
                {
                    throw new PlayerNotFoundException();
                }
            } else
            {
                entityplayermp = (EntityPlayerMP)func_71521_c(p_71515_1_);
            }
            if(p_71515_2_.length == 3 || p_71515_2_.length == 4)
            {
                if(entityplayermp.field_70170_p != null)
                {
                    int i = p_71515_2_.length - 3;
                    int j = 0x1c9c380;
                    int k = func_71532_a(p_71515_1_, p_71515_2_[i++], -j, j);
                    int l = func_71532_a(p_71515_1_, p_71515_2_[i++], 0, 256);
                    int i1 = func_71532_a(p_71515_1_, p_71515_2_[i++], -j, j);
                    entityplayermp.func_70634_a((float)k + 0.5F, l, (float)i1 + 0.5F);
                    func_71522_a(p_71515_1_, "commands.tp.coordinates", new Object[] {
                        entityplayermp.func_70023_ak(), Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i1)
                    });
                }
            } else
            if(p_71515_2_.length == 1 || p_71515_2_.length == 2)
            {
                EntityPlayerMP entityplayermp1 = minecraftserver.func_71203_ab().func_72361_f(p_71515_2_[p_71515_2_.length - 1]);
                if(entityplayermp1 == null)
                {
                    throw new PlayerNotFoundException();
                }
                entityplayermp.field_71135_a.func_72569_a(entityplayermp1.field_70165_t, entityplayermp1.field_70163_u, entityplayermp1.field_70161_v, entityplayermp1.field_70177_z, entityplayermp1.field_70125_A);
                func_71522_a(p_71515_1_, "commands.tp.success", new Object[] {
                    entityplayermp.func_70023_ak(), entityplayermp1.func_70023_ak()
                });
            }
            return;
        } else
        {
            throw new WrongUsageException("commands.tp.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1 || p_71516_2_.length == 2)
        {
            return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
        } else
        {
            return null;
        }
    }
}
