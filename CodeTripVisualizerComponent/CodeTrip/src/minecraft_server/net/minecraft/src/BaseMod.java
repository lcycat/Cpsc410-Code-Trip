package net.minecraft.src;

import java.util.Random;
import net.minecraft.server.MinecraftServer;

public abstract class BaseMod
{
    public BaseMod()
    {
    }

    public int addFuel(int i, int j)
    {
        return 0;
    }

    public int dispenseEntity(World world, ItemStack itemstack, Random random, int i, int j, int k, int l, int i1, double d, double d1, double d2)
    {
        return 0;
    }

    public void generateNether(World world, Random random, int i, int j)
    {
    }

    public void generateSurface(World world, Random random, int i, int j)
    {
    }

    public String getName()
    {
        return getClass().getSimpleName();
    }

    public String getPriorities()
    {
        return "";
    }

    public abstract String getVersion();

    public abstract void load();

    public void modsLoaded()
    {
    }

    public void onItemPickup(EntityPlayer entityplayer, ItemStack itemstack)
    {
    }

    public boolean onTickInGame(MinecraftServer minecraftserver)
    {
        return false;
    }

    public void serverChat(NetServerHandler netserverhandler, String s)
    {
    }

    public void serverCustomPayload(NetServerHandler netserverhandler, Packet250CustomPayload packet250custompayload)
    {
    }

    public void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
    {
    }

    public void takenFromFurnace(EntityPlayer entityplayer, ItemStack itemstack)
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append(getName()).append(' ').append(getVersion()).toString();
    }
}
