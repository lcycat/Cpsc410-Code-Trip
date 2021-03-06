package net.minecraft.src;

public class GenLayerAddMushroomIsland extends GenLayer
{
    public GenLayerAddMushroomIsland(long par1, GenLayer par3GenLayer)
    {
        super(par1);
        parent = par3GenLayer;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int i = par1 - 1;
        int j = par2 - 1;
        int k = par3 + 2;
        int l = par4 + 2;
        int ai[] = parent.getInts(i, j, k, l);
        int ai1[] = IntCache.getIntCache(par3 * par4);

        for (int i1 = 0; i1 < par4; i1++)
        {
            for (int j1 = 0; j1 < par3; j1++)
            {
                int k1 = ai[j1 + 0 + (i1 + 0) * k];
                int l1 = ai[j1 + 2 + (i1 + 0) * k];
                int i2 = ai[j1 + 0 + (i1 + 2) * k];
                int j2 = ai[j1 + 2 + (i1 + 2) * k];
                int k2 = ai[j1 + 1 + (i1 + 1) * k];
                initChunkSeed(j1 + par1, i1 + par2);

                if (k2 == 0 && k1 == 0 && l1 == 0 && i2 == 0 && j2 == 0 && nextInt(100) == 0)
                {
                    ai1[j1 + i1 * par3] = BiomeGenBase.mushroomIsland.biomeID;
                }
                else
                {
                    ai1[j1 + i1 * par3] = k2;
                }
            }
        }

        return ai1;
    }
}
