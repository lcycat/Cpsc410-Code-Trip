// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, WorldServer, ICommandSender

public class CommandServerSaveOff extends CommandBase
{

    public CommandServerSaveOff()
    {
    }

    public String func_71517_b()
    {
        return "save-off";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        MinecraftServer minecraftserver = MinecraftServer.func_71276_C();
        for(int i = 0; i < minecraftserver.field_71305_c.length; i++)
        {
            if(minecraftserver.field_71305_c[i] != null)
            {
                WorldServer worldserver = minecraftserver.field_71305_c[i];
                worldserver.field_73058_d = true;
            }
        }

        func_71522_a(p_71515_1_, "commands.save.disabled", new Object[0]);
    }
}
