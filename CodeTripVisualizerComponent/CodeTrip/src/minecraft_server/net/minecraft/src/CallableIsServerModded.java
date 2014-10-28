package net.minecraft.src;

import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class CallableIsServerModded implements Callable
{
    final MinecraftServer field_74274_a;

    public CallableIsServerModded(MinecraftServer par1MinecraftServer)
    {
        field_74274_a = par1MinecraftServer;
    }

    public String func_74273_a()
    {
        String s = field_74274_a.getServerModName();

        if (!s.equals("vanilla"))
        {
            return (new StringBuilder()).append("Definitely; '").append(s).append("'").toString();
        }
        else
        {
            return "Unknown (can't tell)";
        }
    }

    public Object call()
    {
        return func_74273_a();
    }
}
