package net.minecraft.src;

import java.io.File;

public class AnvilSaveHandler extends SaveHandler
{
    public AnvilSaveHandler(File par1File, String par2Str, boolean par3)
    {
        super(par1File, par2Str, par3);
    }

    /**
     * initializes and returns the chunk loader for the specified world provider
     */
    public IChunkLoader getChunkLoader(WorldProvider par1WorldProvider)
    {
        File file = getWorldDirectory();

        if (par1WorldProvider instanceof WorldProviderHell)
        {
            File file1 = new File(file, "DIM-1");
            file1.mkdirs();
            return new AnvilChunkLoader(file1);
        }

        if (par1WorldProvider instanceof WorldProviderEnd)
        {
            File file2 = new File(file, "DIM1");
            file2.mkdirs();
            return new AnvilChunkLoader(file2);
        }
        else
        {
            return new AnvilChunkLoader(file);
        }
    }

    /**
     * Saves the given World Info with the given NBTTagCompound as the Player.
     */
    public void saveWorldInfoWithPlayer(WorldInfo par1WorldInfo, NBTTagCompound par2NBTTagCompound)
    {
        par1WorldInfo.setSaveVersion(19133);
        super.saveWorldInfoWithPlayer(par1WorldInfo, par2NBTTagCompound);
    }

    /**
     * Called to flush all changes to disk, waiting for them to complete.
     */
    public void flush()
    {
        try
        {
            ThreadedFileIOBase.threadedIOInstance.waitForFinish();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }

        RegionFileCache.clearRegionFileReferences();
    }
}
