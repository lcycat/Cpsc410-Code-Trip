// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.List;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, ICommandSender, Item, NumberInvalidException, 
//            ItemStack, EntityPlayer, WrongUsageException, ServerConfigurationManager, 
//            PlayerNotFoundException

public class CommandGive extends CommandBase
{

    public CommandGive()
    {
    }

    public String func_71517_b()
    {
        return "give";
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return p_71518_1_.func_70004_a("commands.give.usage", new Object[0]);
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length >= 2)
        {
            EntityPlayer entityplayer = func_71537_a(p_71515_2_[0]);
            int i = func_71528_a(p_71515_1_, p_71515_2_[1], 1);
            int j = 1;
            int k = 0;
            if(Item.field_77698_e[i] == null)
            {
                throw new NumberInvalidException("commands.give.notFound", new Object[] {
                    Integer.valueOf(i)
                });
            }
            if(p_71515_2_.length >= 3)
            {
                j = func_71532_a(p_71515_1_, p_71515_2_[2], 1, 64);
            }
            if(p_71515_2_.length >= 4)
            {
                k = func_71526_a(p_71515_1_, p_71515_2_[3]);
            }
            ItemStack itemstack = new ItemStack(i, j, k);
            entityplayer.func_71021_b(itemstack);
            func_71522_a(p_71515_1_, "commands.give.success", new Object[] {
                Item.field_77698_e[i].func_77653_i(itemstack), Integer.valueOf(i), Integer.valueOf(j), entityplayer.func_70023_ak()
            });
            return;
        } else
        {
            throw new WrongUsageException("commands.give.usage", new Object[0]);
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, func_71536_c());
        } else
        {
            return null;
        }
    }

    protected EntityPlayer func_71537_a(String p_71537_1_)
    {
        EntityPlayerMP entityplayermp = MinecraftServer.func_71276_C().func_71203_ab().func_72361_f(p_71537_1_);
        if(entityplayermp == null)
        {
            throw new PlayerNotFoundException();
        } else
        {
            return entityplayermp;
        }
    }

    protected String[] func_71536_c()
    {
        return MinecraftServer.func_71276_C().func_71213_z();
    }
}
