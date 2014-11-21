package net.minecraft.src;

import java.io.File;

public interface ISaveHandler
{
    /**
     * Loads and returns the world info
     */
    public abstract WorldInfo loadWorldInfo();

    /**
     * Checks the session lock to prevent save collisions
     */
    public abstract void checkSessionLock() throws MinecraftException;

    /**
     * initializes and returns the chunk loader for the specified world provider
     */
    public abstract IChunkLoader getChunkLoader(WorldProvider worldprovider);

    /**
     * Saves the given World Info with the given NBTTagCompound as the Player.
     */
    public abstract void saveWorldInfoWithPlayer(WorldInfo worldinfo, NBTTagCompound nbttagcompound);

    /**
     * used to update level.dat from old format to MCRegion format
     */
    public abstract void saveWorldInfo(WorldInfo worldinfo);

    public abstract IPlayerFileData getPlayerNBTManager();

    /**
     * Called to flush all changes to disk, waiting for them to complete.
     */
    public abstract void flush();

    /**
     * Gets the file location of the given map
     */
    public abstract File getMapFileFromName(String s);

    public abstract String func_75760_g();
}
