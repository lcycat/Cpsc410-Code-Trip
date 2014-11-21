// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, EntityPlayer, EnumGameType, 
//            StatCollector, WrongUsageException, WorldSettings, ServerConfigurationManager, 
//            PlayerNotFoundException

public class CommandGameMode extends CommandBase
{

    public CommandGameMode()
    {
    }

    public String func_71517_b()
    {
        return "gamemode";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.gamemode.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length > 0)
        {
            EnumGameType enumgametype = func_71539_b(p_71515_1_, p_71515_2_[0]);
            EntityPlayer entityplayer = p_71515_2_.length < 2 ? func_71521_c(p_71515_1_) : func_71540_a(p_71515_2_[1]);
            entityplayer.func_71033_a(enumgametype);
            String s = StatCollector.func_74838_a((new StringBuilder()).append("gameMode.").append(enumgametype.func_77149_b()).toString());
            if(entityplayer != p_71515_1_)
            {
                func_71524_a(p_71515_1_, 1, "commands.gamemode.success.other", new Object[] {
                    entityplayer.func_70023_ak(), s
                });
            } else
            {
                func_71524_a(p_71515_1_, 1, "commands.gamemode.success.self", new Object[] {
                    s
                });
            }
            return;
        } else
        {
            throw new WrongUsageException("commands.gamemode.usage", new Object[0]);
        }
    }

    protected EnumGameType func_71539_b(ICommandSender p_71539_1_, String p_71539_2_)
    {
        if(p_71539_2_.equalsIgnoreCase(EnumGameType.SURVIVAL.func_77149_b()) || p_71539_2_.equalsIgnoreCase("s"))
        {
            return EnumGameType.SURVIVAL;
        }
        if(p_71539_2_.equalsIgnoreCase(EnumGameType.CREATIVE.func_77149_b()) || p_71539_2_.equalsIgnoreCase("c"))
        {
            return EnumGameType.CREATIVE;
        }
        if(p_71539_2_.equalsIgnoreCase(EnumGameType.ADVENTURE.func_77149_b()) || p_71539_2_.equalsIgnoreCase("a"))
        {
            return EnumGameType.ADVENTURE;
        } else
        {
            return WorldSettings.func_77161_a(func_71532_a(p_71539_1_, p_71539_2_, 0, EnumGameType.values().length - 2));
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, new String[] {
                "survival", "creative", "adventure"
            });
        }
        if(p_71516_2_.length == 2)
        {
            return func_71530_a(p_71516_2_, func_71538_c());
        } else
        {
            return null;
        }
    }

    protected EntityPlayer func_71540_a(String p_71540_1_)
    {
        EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71540_1_);
        if(entityplayermp == null)
        {
            throw new PlayerNotFoundException();
        } else
        {
            return entityplayermp;
        }
    }

    protected String[] func_71538_c()
    {
        return MinecraftServer.func_71276_C().func_71213_z();
    }
}
