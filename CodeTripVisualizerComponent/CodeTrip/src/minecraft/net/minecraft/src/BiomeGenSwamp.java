package net.minecraft.src;

import java.util.Random;

public class BiomeGenSwamp extends BiomeGenBase
{
    protected BiomeGenSwamp(int par1)
    {
        super(par1);
        theBiomeDecorator.treesPerChunk = 2;
        theBiomeDecorator.flowersPerChunk = -999;
        theBiomeDecorator.deadBushPerChunk = 1;
        theBiomeDecorator.mushroomsPerChunk = 8;
        theBiomeDecorator.reedsPerChunk = 10;
        theBiomeDecorator.clayPerChunk = 1;
        theBiomeDecorator.waterlilyPerChunk = 4;
        waterColorMultiplier = 0xe0ffae;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return worldGeneratorSwamp;
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        double d = getFloatTemperature();
        double d1 = getFloatRainfall();
        return ((ColorizerGrass.getGrassColor(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        double d = getFloatTemperature();
        double d1 = getFloatRainfall();
        return ((ColorizerFoliage.getFoliageColor(d, d1) & 0xfefefe) + 0x4e0e4e) / 2;
    }
}
