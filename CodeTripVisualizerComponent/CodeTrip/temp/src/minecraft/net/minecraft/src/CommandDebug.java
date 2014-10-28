// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            CommandBase, Profiler, CommandException, WrongUsageException, 
//            ProfilerResult, ICommandSender

public class CommandDebug extends CommandBase
{

    private long field_71551_a;
    private int field_71550_b;

    public CommandDebug()
    {
        field_71551_a = 0L;
        field_71550_b = 0;
    }

    public String func_71517_b()
    {
        return "debug";
    }

    public void func_71515_b(ICommandSender p_71515_1_, String p_71515_2_[])
    {
        if(p_71515_2_.length == 1)
        {
            if(p_71515_2_[0].equals("start"))
            {
                func_71522_a(p_71515_1_, "commands.debug.start", new Object[0]);
                MinecraftServer.func_71276_C().func_71223_ag();
                field_71551_a = System.currentTimeMillis();
                field_71550_b = MinecraftServer.func_71276_C().func_71259_af();
                return;
            }
            if(p_71515_2_[0].equals("stop"))
            {
                if(!MinecraftServer.func_71276_C().field_71304_b.field_76327_a)
                {
                    throw new CommandException("commands.debug.notStarted", new Object[0]);
                } else
                {
                    long l = System.currentTimeMillis();
                    int i = MinecraftServer.func_71276_C().func_71259_af();
                    long l1 = l - field_71551_a;
                    int j = i - field_71550_b;
                    func_71548_a(l1, j);
                    MinecraftServer.func_71276_C().field_71304_b.field_76327_a = false;
                    func_71522_a(p_71515_1_, "commands.debug.stop", new Object[] {
                        Float.valueOf((float)l1 / 1000F), Integer.valueOf(j)
                    });
                    return;
                }
            }
        }
        throw new WrongUsageException("commands.debug.usage", new Object[0]);
    }

    private void func_71548_a(long p_71548_1_, int p_71548_3_)
    {
        File file = new File(MinecraftServer.func_71276_C().func_71209_f("debug"), (new StringBuilder()).append("profile-results-").append((new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date())).append(".txt").toString());
        file.getParentFile().mkdirs();
        try
        {
            FileWriter filewriter = new FileWriter(file);
            filewriter.write(func_71547_b(p_71548_1_, p_71548_3_));
            filewriter.close();
        }
        catch(Throwable throwable)
        {
            Logger.getLogger("Minecraft").log(Level.SEVERE, (new StringBuilder()).append("Could not save profiler results to ").append(file).toString(), throwable);
        }
    }

    private String func_71547_b(long p_71547_1_, int p_71547_3_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("---- Minecraft Profiler Results ----\n");
        stringbuilder.append("// ");
        stringbuilder.append(func_71549_c());
        stringbuilder.append("\n\n");
        stringbuilder.append("Time span: ").append(p_71547_1_).append(" ms\n");
        stringbuilder.append("Tick span: ").append(p_71547_3_).append(" ticks\n");
        stringbuilder.append("// This is approximately ").append(String.format("%.2f", new Object[] {
            Float.valueOf((float)p_71547_3_ / ((float)p_71547_1_ / 1000F))
        })).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
        stringbuilder.append("--- BEGIN PROFILE DUMP ---\n\n");
        func_71546_a(0, "root", stringbuilder);
        stringbuilder.append("--- END PROFILE DUMP ---\n\n");
        return stringbuilder.toString();
    }

    private void func_71546_a(int p_71546_1_, String p_71546_2_, StringBuilder p_71546_3_)
    {
        List list = MinecraftServer.func_71276_C().field_71304_b.func_76321_b(p_71546_2_);
        if(list == null || list.size() < 3)
        {
            return;
        }
        for(int i = 1; i < list.size(); i++)
        {
            ProfilerResult profilerresult = (ProfilerResult)list.get(i);
            p_71546_3_.append(String.format("[%02d] ", new Object[] {
                Integer.valueOf(p_71546_1_)
            }));
            for(int j = 0; j < p_71546_1_; j++)
            {
                p_71546_3_.append(" ");
            }

            p_71546_3_.append(profilerresult.field_76331_c);
            p_71546_3_.append(" - ");
            p_71546_3_.append(String.format("%.2f", new Object[] {
                Double.valueOf(profilerresult.field_76332_a)
            }));
            p_71546_3_.append("%/");
            p_71546_3_.append(String.format("%.2f", new Object[] {
                Double.valueOf(profilerresult.field_76330_b)
            }));
            p_71546_3_.append("%\n");
            if(profilerresult.field_76331_c.equals("unspecified"))
            {
                continue;
            }
            try
            {
                func_71546_a(p_71546_1_ + 1, (new StringBuilder()).append(p_71546_2_).append(".").append(profilerresult.field_76331_c).toString(), p_71546_3_);
            }
            catch(Exception exception)
            {
                p_71546_3_.append((new StringBuilder()).append("[[ EXCEPTION ").append(exception).append(" ]]").toString());
            }
        }

    }

    private static String func_71549_c()
    {
        String as[] = {
            "Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", 
            "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server."
        };
        try
        {
            return as[(int)(System.nanoTime() % (long)as.length)];
        }
        catch(Throwable throwable)
        {
            return "Witty comment unavailable :(";
        }
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        if(p_71516_2_.length == 1)
        {
            return func_71530_a(p_71516_2_, new String[] {
                "start", "stop"
            });
        } else
        {
            return null;
        }
    }
}
