// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ServerConfigurationManager, BanList, ICommandSender, 
//            PlayerNotFoundException, EntityPlayerMP, WrongUsageException, BanEntry, 
//            NetServerHandler

public class CommandServerBanIp extends CommandBase
{

    public static final Pattern field_71545_a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public CommandServerBanIp()
    {
    }

    public String func_71517_b()
    {
        return "ban-ip";
    }

    public boolean func_71519_b(ICommandSender p_71519_1_)
    {
        return MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73710_b() && super.func_71519_b(p_71519_1_);
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.banip.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length >= 1 && p_71515_2_[0].length() > 1)
        {
            Matcher matcher = field_71545_a.matcher(p_71515_2_[0]);
            String s = null;
            if(p_71515_2_.length >= 2)
            {
                s = func_71520_a(p_71515_2_, 1);
            }
            if(matcher.matches())
            {
                func_71544_a(p_71515_1_, p_71515_2_[0], s);
            } else
            {
                EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71515_2_[0]);
                if(entityplayermp == null)
                {
                    throw new PlayerNotFoundException("commands.banip.invalid", new Object[0]);
                }
                func_71544_a(p_71515_1_, entityplayermp.func_71114_r(), s);
            }
            return;
        } else
        {
            throw new WrongUsageException("commands.banip.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, MinecraftServer.func_71276_C().func_71213_z());
        } else
        {
            return null;
        }
    }

    protected void func_71544_a(ICommandSender p_71544_1_, String p_71544_2_, String p_71544_3_)
    {
        BanEntry banentry = new BanEntry(p_71544_2_);
        banentry.func_73687_a(p_71544_1_.func_70005_c_());
        if(p_71544_3_ != null)
        {
            banentry.func_73689_b(p_71544_3_);
        }
        MinecraftServer.func_71276_C().func_71203_ab().func_72363_f().func_73706_a(banentry);
        List list = MinecraftServer.func_71276_C().func_71203_ab().func_72382_j(p_71544_2_);
        String as[] = new String[list.size()];
        int i = 0;
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            EntityPlayerMP entityplayermp = (EntityPlayerMP)iterator.next();
            entityplayermp.field_71135_a.func_72565_c("You have been IP banned.");
            as[i++] = entityplayermp.func_70023_ak();
        }

        if(list.isEmpty())
        {
            func_71522_a(p_71544_1_, "commands.banip.success", new Object[] {
                p_71544_2_
            });
        } else
        {
            func_71522_a(p_71544_1_, "commands.banip.success.players", new Object[] {
                p_71544_2_, func_71527_a(as)
            });
        }
    }

}
