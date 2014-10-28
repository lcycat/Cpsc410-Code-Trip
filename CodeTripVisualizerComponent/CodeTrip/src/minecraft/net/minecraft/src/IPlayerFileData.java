package net.minecraft.src;

public interface IPlayerFileData
{
    /**
     * Writes the player data to disk from the specified PlayerEntityMP.
     */
    public abstract void writePlayerData(EntityPlayer entityplayer);

    /**
     * Reads the player data from disk into the specified PlayerEntityMP.
     */
    public abstract void readPlayerData(EntityPlayer entityplayer);

    /**
     * Gets an array of Usernames there are available player.dat files for.
     */
    public abstract String[] getAvailablePlayerDat();
}
