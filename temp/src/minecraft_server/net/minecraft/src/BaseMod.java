// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.server.MinecraftServer;

// Referenced classes of package net.minecraft.src:
//            World, ItemStack, EntityPlayer, NetServerHandler, 
//            Packet250CustomPayload, IInventory

public abstract class BaseMod
{

    public BaseMod()
    {
    }

    public int addFuel(int i, int j)
    {
        return 0;
    }

    public int dispenseEntity(World world, ItemStack itemstack, Random random, int i, int j, int k, int l, 
            int i1, double d, double d1, double d2)
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
