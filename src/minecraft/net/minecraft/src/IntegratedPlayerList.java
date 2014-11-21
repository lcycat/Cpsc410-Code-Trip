package net.minecraft.src;

import net.minecraft.server.MinecraftServer;

public class IntegratedPlayerList extends ServerConfigurationManager
{
    private NBTTagCompound tagsForLastWrittenPlayer;

    public IntegratedPlayerList(IntegratedServer par1IntegratedServer)
    {
        super(par1IntegratedServer);
        tagsForLastWrittenPlayer = null;
        viewDistance = 10;
    }

    /**
     * also stores the NBTTags if this is an intergratedPlayerList
     */
    protected void writePlayerData(EntityPlayerMP par1EntityPlayerMP)
    {
        if (par1EntityPlayerMP.getCommandSenderName().equals(getIntegratedServer().getServerOwner()))
        {
            tagsForLastWrittenPlayer = new NBTTagCompound();
            par1EntityPlayerMP.writeToNBT(tagsForLastWrittenPlayer);
        }

        super.writePlayerData(par1EntityPlayerMP);
    }

    /**
     * get the associated Integrated Server
     */
    public IntegratedServer getIntegratedServer()
    {
        return (IntegratedServer)super.getServerInstance();
    }

    /**
     * gets the tags created in the last writePlayerData call
     */
    public NBTTagCompound getTagsFromLastWrite()
    {
        return tagsForLastWrittenPlayer;
    }

    public MinecraftServer getServerInstance()
    {
        return getIntegratedServer();
    }
}
