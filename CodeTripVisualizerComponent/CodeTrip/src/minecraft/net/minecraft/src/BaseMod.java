package net.minecraft.src;

import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;

public abstract class BaseMod
{
    public BaseMod()
    {
    }

    public int addFuel(int i, int j)
    {
        return 0;
    }

    public void addRenderer(Map map)
    {
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
    
    public void generateBuildings(World world, Random random, int i, int j,List<Building> Buildings)
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

    public void keyboardEvent(KeyBinding keybinding)
    {
    }

    public abstract void load();

    public void modsLoaded()
    {
    }

    public void onItemPickup(EntityPlayer entityplayer, ItemStack itemstack)
    {
    }

    public boolean onTickInGame(float f, Minecraft minecraft)
    {
        return false;
    }

    public boolean onTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen)
    {
        return false;
    }

    public void clientChat(String s)
    {
    }

    public void serverChat(NetServerHandler netserverhandler, String s)
    {
    }

    public void clientCustomPayload(NetClientHandler netclienthandler, Packet250CustomPayload packet250custompayload)
    {
    }

    public void serverCustomPayload(NetServerHandler netserverhandler, Packet250CustomPayload packet250custompayload)
    {
    }

    public void registerAnimation(Minecraft minecraft)
    {
    }

    public void renderInvBlock(RenderBlocks renderblocks, Block block, int i, int j)
    {
    }

    public boolean renderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
        return false;
    }

    public void clientConnect(NetClientHandler netclienthandler)
    {
    }

    public void clientDisconnect(NetClientHandler netclienthandler)
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

    public GuiContainer getContainerGUI(EntityClientPlayerMP entityclientplayermp, int i, int j, int k, int l)
    {
        return null;
    }
}
