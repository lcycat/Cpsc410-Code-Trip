package net.minecraft.src;

import java.io.*;
import java.util.logging.Logger;

public class SaveHandler implements ISaveHandler, IPlayerFileData
{
    /** Reference to the logger. */
    private static final Logger logger = Logger.getLogger("Minecraft");

    /** The path to the current savegame directory */
    private final File saveDirectory;

    /** The directory in which to save player information */
    private final File playersDirectory;
    private final File mapDataDir;

    /**
     * The time in milliseconds when this field was initialized. Stored in the session lock file.
     */
    private final long initializationTime = System.currentTimeMillis();

    /** The directory name of the world */
    private final String saveDirectoryName;

    public SaveHandler(File par1File, String par2Str, boolean par3)
    {
        saveDirectory = new File(par1File, par2Str);
        saveDirectory.mkdirs();
        playersDirectory = new File(saveDirectory, "players");
        mapDataDir = new File(saveDirectory, "data");
        mapDataDir.mkdirs();
        saveDirectoryName = par2Str;

        if (par3)
        {
            playersDirectory.mkdirs();
        }

        setSessionLock();
    }

    /**
     * Creates a session lock file for this process
     */
    private void setSessionLock()
    {
        try
        {
            File file = new File(saveDirectory, "session.lock");
            DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));

            try
            {
                dataoutputstream.writeLong(initializationTime);
            }
            finally
            {
                dataoutputstream.close();
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            throw new RuntimeException("Failed to check session lock, aborting");
        }
    }

    /**
     * gets the File object corresponding to the base directory of this save (saves/404 for a save called 404 etc)
     */
    protected File getSaveDirectory()
    {
        return saveDirectory;
    }

    /**
     * Checks the session lock to prevent save collisions
     */
    public void checkSessionLock() throws MinecraftException
    {
        try
        {
            File file = new File(saveDirectory, "session.lock");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));

            try
            {
                if (datainputstream.readLong() != initializationTime)
                {
                    throw new MinecraftException("The save is being accessed from another location, aborting");
                }
            }
            finally
            {
                datainputstream.close();
            }
        }
        catch (IOException ioexception)
        {
            throw new MinecraftException("Failed to check session lock, aborting");
        }
    }

    /**
     * Returns the chunk loader with the provided world provider
     */
    public IChunkLoader getChunkLoader(WorldProvider par1WorldProvider)
    {
        throw new RuntimeException("Old Chunk Storage is no longer supported.");
    }

    /**
     * Loads and returns the world info
     */
    public WorldInfo loadWorldInfo()
    {
        File file = new File(saveDirectory, "level.dat");

        if (file.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(new FileInputStream(file));
                NBTTagCompound nbttagcompound2 = nbttagcompound.getCompoundTag("Data");
                return new WorldInfo(nbttagcompound2);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        file = new File(saveDirectory, "level.dat_old");

        if (file.exists())
        {
            try
            {
                NBTTagCompound nbttagcompound1 = CompressedStreamTools.readCompressed(new FileInputStream(file));
                NBTTagCompound nbttagcompound3 = nbttagcompound1.getCompoundTag("Data");
                return new WorldInfo(nbttagcompound3);
            }
            catch (Exception exception1)
            {
                exception1.printStackTrace();
            }
        }

        return null;
    }

    /**
     * Saves the given World Info with the given NBTTagCompound as the Player.
     */
    public void saveWorldInfoWithPlayer(WorldInfo par1WorldInfo, NBTTagCompound par2NBTTagCompound)
    {
        NBTTagCompound nbttagcompound = par1WorldInfo.cloneNBTCompound(par2NBTTagCompound);
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.setTag("Data", nbttagcompound);

        try
        {
            File file = new File(saveDirectory, "level.dat_new");
            File file1 = new File(saveDirectory, "level.dat_old");
            File file2 = new File(saveDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(nbttagcompound1, new FileOutputStream(file));

            if (file1.exists())
            {
                file1.delete();
            }

            file2.renameTo(file1);

            if (file2.exists())
            {
                file2.delete();
            }

            file.renameTo(file2);

            if (file.exists())
            {
                file.delete();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Saves the passed in world info.
     */
    public void saveWorldInfo(WorldInfo par1WorldInfo)
    {
        NBTTagCompound nbttagcompound = par1WorldInfo.getNBTTagCompound();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.setTag("Data", nbttagcompound);

        try
        {
            File file = new File(saveDirectory, "level.dat_new");
            File file1 = new File(saveDirectory, "level.dat_old");
            File file2 = new File(saveDirectory, "level.dat");
            CompressedStreamTools.writeCompressed(nbttagcompound1, new FileOutputStream(file));

            if (file1.exists())
            {
                file1.delete();
            }

            file2.renameTo(file1);

            if (file2.exists())
            {
                file2.delete();
            }

            file.renameTo(file2);

            if (file.exists())
            {
                file.delete();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * Writes the player data to disk from the specified PlayerEntityMP.
     */
    public void writePlayerData(EntityPlayer par1EntityPlayer)
    {
        try
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            par1EntityPlayer.writeToNBT(nbttagcompound);
            File file = new File(playersDirectory, (new StringBuilder()).append(par1EntityPlayer.username).append(".dat.tmp").toString());
            File file1 = new File(playersDirectory, (new StringBuilder()).append(par1EntityPlayer.username).append(".dat").toString());
            CompressedStreamTools.writeCompressed(nbttagcompound, new FileOutputStream(file));

            if (file1.exists())
            {
                file1.delete();
            }

            file.renameTo(file1);
        }
        catch (Exception exception)
        {
            logger.warning((new StringBuilder()).append("Failed to save player data for ").append(par1EntityPlayer.username).toString());
        }
    }

    /**
     * Reads the player data from disk into the specified PlayerEntityMP.
     */
    public void readPlayerData(EntityPlayer par1EntityPlayer)
    {
        NBTTagCompound nbttagcompound = getPlayerData(par1EntityPlayer.username);

        if (nbttagcompound != null)
        {
            par1EntityPlayer.readFromNBT(nbttagcompound);
        }
    }

    /**
     * Gets the player data for the given playername as a NBTTagCompound.
     */
    public NBTTagCompound getPlayerData(String par1Str)
    {
        try
        {
            File file = new File(playersDirectory, (new StringBuilder()).append(par1Str).append(".dat").toString());

            if (file.exists())
            {
                return CompressedStreamTools.readCompressed(new FileInputStream(file));
            }
        }
        catch (Exception exception)
        {
            logger.warning((new StringBuilder()).append("Failed to load player data for ").append(par1Str).toString());
        }

        return null;
    }

    /**
     * returns null if no saveHandler is relevent (eg. SMP)
     */
    public IPlayerFileData getSaveHandler()
    {
        return this;
    }

    /**
     * Gets an array of Usernames there are available player.dat files for.
     */
    public String[] getAvailablePlayerDat()
    {
        String as[] = playersDirectory.list();

        for (int i = 0; i < as.length; i++)
        {
            if (as[i].endsWith(".dat"))
            {
                as[i] = as[i].substring(0, as[i].length() - 4);
            }
        }

        return as;
    }

    /**
     * Called to flush all changes to disk, waiting for them to complete.
     */
    public void flush()
    {
    }

    /**
     * Gets the file location of the given map
     */
    public File getMapFileFromName(String par1Str)
    {
        return new File(mapDataDir, (new StringBuilder()).append(par1Str).append(".dat").toString());
    }

    /**
     * Returns the name of the directory where world information is saved
     */
    public String getSaveDirectoryName()
    {
        return saveDirectoryName;
    }
}
