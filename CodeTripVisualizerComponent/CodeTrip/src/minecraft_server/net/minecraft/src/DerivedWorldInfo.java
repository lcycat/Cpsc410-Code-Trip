package net.minecraft.src;

public class DerivedWorldInfo extends WorldInfo
{
    private final WorldInfo field_76115_a;

    public DerivedWorldInfo(WorldInfo par1WorldInfo)
    {
        field_76115_a = par1WorldInfo;
    }

    /**
     * Gets the NBTTagCompound for the worldInfo
     */
    public NBTTagCompound getNBTTagCompound()
    {
        return field_76115_a.getNBTTagCompound();
    }

    /**
     * Creates a new NBTTagCompound for the world, with the given NBTTag as the "Player"
     */
    public NBTTagCompound cloneNBTCompound(NBTTagCompound par1NBTTagCompound)
    {
        return field_76115_a.cloneNBTCompound(par1NBTTagCompound);
    }

    /**
     * Returns the seed of current world.
     */
    public long getSeed()
    {
        return field_76115_a.getSeed();
    }

    /**
     * Returns the x spawn position
     */
    public int getSpawnX()
    {
        return field_76115_a.getSpawnX();
    }

    /**
     * Return the Y axis spawning point of the player.
     */
    public int getSpawnY()
    {
        return field_76115_a.getSpawnY();
    }

    /**
     * Returns the z spawn position
     */
    public int getSpawnZ()
    {
        return field_76115_a.getSpawnZ();
    }

    /**
     * Get current world time
     */
    public long getWorldTime()
    {
        return field_76115_a.getWorldTime();
    }

    public NBTTagCompound func_76072_h()
    {
        return field_76115_a.func_76072_h();
    }

    public int getDimension()
    {
        return field_76115_a.getDimension();
    }

    public String func_76065_j()
    {
        return field_76115_a.func_76065_j();
    }

    /**
     * Returns the save version of this world
     */
    public int getSaveVersion()
    {
        return field_76115_a.getSaveVersion();
    }

    /**
     * Returns true if it is thundering, false otherwise.
     */
    public boolean isThundering()
    {
        return field_76115_a.isThundering();
    }

    /**
     * Returns the number of ticks until next thunderbolt.
     */
    public int getThunderTime()
    {
        return field_76115_a.getThunderTime();
    }

    /**
     * Returns true if it is raining, false otherwise.
     */
    public boolean isRaining()
    {
        return field_76115_a.isRaining();
    }

    /**
     * Return the number of ticks until rain.
     */
    public int getRainTime()
    {
        return field_76115_a.getRainTime();
    }

    /**
     * Gets the GameType.
     */
    public EnumGameType getGameType()
    {
        return field_76115_a.getGameType();
    }

    /**
     * Set current world time
     */
    public void setWorldTime(long l)
    {
    }

    /**
     * Sets the spawn zone position. Args: x, y, z
     */
    public void setSpawnPosition(int i, int j, int k)
    {
    }

    public void setWorldName(String s)
    {
    }

    /**
     * Sets the save version of the world
     */
    public void setSaveVersion(int i)
    {
    }

    /**
     * Sets whether it is thundering or not.
     */
    public void setThundering(boolean flag)
    {
    }

    /**
     * Defines the number of ticks until next thunderbolt.
     */
    public void setThunderTime(int i)
    {
    }

    /**
     * Sets whether it is raining or not.
     */
    public void setRaining(boolean flag)
    {
    }

    /**
     * Sets the number of ticks until rain.
     */
    public void setRainTime(int i)
    {
    }

    /**
     * Get whether the map features (e.g. strongholds) generation is enabled or disabled.
     */
    public boolean isMapFeaturesEnabled()
    {
        return field_76115_a.isMapFeaturesEnabled();
    }

    /**
     * Returns true if hardcore mode is enabled, otherwise false
     */
    public boolean isHardcoreModeEnabled()
    {
        return field_76115_a.isHardcoreModeEnabled();
    }

    public WorldType getTerrainType()
    {
        return field_76115_a.getTerrainType();
    }

    public void setTerrainType(WorldType worldtype)
    {
    }

    /**
     * Returns true if commands are allowed on this World.
     */
    public boolean areCommandsAllowed()
    {
        return field_76115_a.areCommandsAllowed();
    }

    /**
     * Returns true if the World is initialized.
     */
    public boolean isInitialized()
    {
        return field_76115_a.isInitialized();
    }

    /**
     * Sets the initialization status of the World.
     */
    public void setServerInitialized(boolean flag)
    {
    }
}
