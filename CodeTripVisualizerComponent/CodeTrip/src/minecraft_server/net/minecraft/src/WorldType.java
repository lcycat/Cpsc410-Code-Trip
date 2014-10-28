package net.minecraft.src;

public class WorldType
{
    public static final WorldType worldTypes[] = new WorldType[16];

    /** Default world type. */
    public static final WorldType DEFAULT = (new WorldType(0, "default", 1)).setVersioned();

    /** Flat world type. */
    public static final WorldType FLAT = new WorldType(1, "flat");

    /** Large Biome world Type. */
    public static final WorldType LARGE_BIOMES = new WorldType(2, "largeBiomes");

    /** Default (1.1) world type. */
    public static final WorldType DEFAULT_1_1 = (new WorldType(8, "default_1_1", 0)).setCanBeCreated(false);
    private final String worldType;

    /** The int version of the ChunkProvider that generated this world. */
    private final int generatorVersion;

    /**
     * Whether this world type can be generated. Normally true; set to false for out-of-date generator versions.
     */
    private boolean canBeCreated;

    /** Whether this WorldType has a version or not. */
    private boolean isWorldTypeVersioned;

    private WorldType(int par1, String par2Str)
    {
        this(par1, par2Str, 0);
    }

    private WorldType(int par1, String par2Str, int par3)
    {
        worldType = par2Str;
        generatorVersion = par3;
        canBeCreated = true;
        worldTypes[par1] = this;
    }

    public String getWorldTypeName()
    {
        return worldType;
    }

    /**
     * Returns generatorVersion.
     */
    public int getGeneratorVersion()
    {
        return generatorVersion;
    }

    public WorldType getWorldTypeForGeneratorVersion(int par1)
    {
        return this != DEFAULT || par1 != 0 ? this : DEFAULT_1_1;
    }

    /**
     * Sets canBeCreated to the provided value, and returns this.
     */
    private WorldType setCanBeCreated(boolean par1)
    {
        canBeCreated = par1;
        return this;
    }

    /**
     * Flags this world type as having an associated version.
     */
    private WorldType setVersioned()
    {
        isWorldTypeVersioned = true;
        return this;
    }

    /**
     * Returns true if this world Type has a version associated with it.
     */
    public boolean isVersioned()
    {
        return isWorldTypeVersioned;
    }

    public static WorldType parseWorldType(String par0Str)
    {
        WorldType aworldtype[] = worldTypes;
        int i = aworldtype.length;

        for (int j = 0; j < i; j++)
        {
            WorldType worldtype = aworldtype[j];

            if (worldtype != null && worldtype.worldType.equalsIgnoreCase(par0Str))
            {
                return worldtype;
            }
        }

        return null;
    }

    public WorldChunkManager getChunkManager(World world)
    {
        return ((WorldChunkManager)(this != FLAT ? new WorldChunkManager(world) : new WorldChunkManagerHell(BiomeGenBase.plains, 0.5F, 0.5F)));
    }

    public IChunkProvider getChunkGenerator(World world)
    {
        return ((IChunkProvider)(this != FLAT ? new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled()) : new ChunkProviderFlat(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled())));
    }

    public int getSeaLevel(World world)
    {
        return this == FLAT ? 4 : 64;
    }
}
