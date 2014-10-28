package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class Vec3Pool
{
    private final int truncateArrayResetThreshold;
    private final int minimumSize;

    /** items at and above nextFreeSpace are assumed to be available */
    private final List vec3Cache = new ArrayList();
    private int nextFreeSpace;
    private int maximumSizeSinceLastTruncation;
    private int resetCount;

    public Vec3Pool(int par1, int par2)
    {
        nextFreeSpace = 0;
        maximumSizeSinceLastTruncation = 0;
        resetCount = 0;
        truncateArrayResetThreshold = par1;
        minimumSize = par2;
    }

    /**
     * extends the pool if all vecs are currently "out"
     */
    public Vec3 getVecFromPool(double par1, double par3, double par5)
    {
        Vec3 vec3;

        if (nextFreeSpace >= vec3Cache.size())
        {
            vec3 = new Vec3(par1, par3, par5);
            vec3Cache.add(vec3);
        }
        else
        {
            vec3 = (Vec3)vec3Cache.get(nextFreeSpace);
            vec3.setComponents(par1, par3, par5);
        }

        nextFreeSpace++;
        return vec3;
    }

    /**
     * will truncate the array everyN clears to the maximum size observed since the last truncation
     */
    public void clear()
    {
        if (nextFreeSpace > maximumSizeSinceLastTruncation)
        {
            maximumSizeSinceLastTruncation = nextFreeSpace;
        }

        if (resetCount++ == truncateArrayResetThreshold)
        {
            for (int i = Math.max(maximumSizeSinceLastTruncation, vec3Cache.size() - minimumSize); vec3Cache.size() > i; vec3Cache.remove(i)) { }

            maximumSizeSinceLastTruncation = 0;
            resetCount = 0;
        }

        nextFreeSpace = 0;
    }

    public void clearAndFreeCache()
    {
        nextFreeSpace = 0;
        vec3Cache.clear();
    }
}
