package net.minecraft.src;

import java.util.Random;

public class RandomPositionGenerator
{
    /**
     * used to store a driection when the user passes a point to move towards or away from. WARNING: NEVER THREAD SAFE.
     * MULTIPLE findTowards and findAway calls, will share this var
     */
    private static Vec3 staticVector = Vec3.createVectorHelper(0.0D, 0.0D, 0.0D);

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks
     */
    public static Vec3 findRandomTarget(EntityCreature par0EntityCreature, int par1, int par2)
    {
        return findRandomTargetBlock(par0EntityCreature, par1, par2, null);
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks in the direction of the point par3
     */
    public static Vec3 findRandomTargetBlockTowards(EntityCreature par0EntityCreature, int par1, int par2, Vec3 par3Vec3)
    {
        staticVector.xCoord = par3Vec3.xCoord - par0EntityCreature.posX;
        staticVector.yCoord = par3Vec3.yCoord - par0EntityCreature.posY;
        staticVector.zCoord = par3Vec3.zCoord - par0EntityCreature.posZ;
        return findRandomTargetBlock(par0EntityCreature, par1, par2, staticVector);
    }

    /**
     * finds a random target within par1(x,z) and par2 (y) blocks in the reverse direction of the point par3
     */
    public static Vec3 findRandomTargetBlockAwayFrom(EntityCreature par0EntityCreature, int par1, int par2, Vec3 par3Vec3)
    {
        staticVector.xCoord = par0EntityCreature.posX - par3Vec3.xCoord;
        staticVector.yCoord = par0EntityCreature.posY - par3Vec3.yCoord;
        staticVector.zCoord = par0EntityCreature.posZ - par3Vec3.zCoord;
        return findRandomTargetBlock(par0EntityCreature, par1, par2, staticVector);
    }

    /**
     * searches 10 blocks at random in a within par1(x,z) and par2 (y) distance, ignores those not in the direction of
     * par3Vec3, then points to the tile for which creature.getBlockPathWeight returns the highest number
     */
    private static Vec3 findRandomTargetBlock(EntityCreature par0EntityCreature, int par1, int par2, Vec3 par3Vec3)
    {
        Random random = par0EntityCreature.getRNG();
        boolean flag = false;
        int i = 0;
        int j = 0;
        int k = 0;
        float f = -99999F;
        boolean flag1;

        if (par0EntityCreature.hasHome())
        {
            double d = par0EntityCreature.getHomePosition().getDistanceSquared(MathHelper.floor_double(par0EntityCreature.posX), MathHelper.floor_double(par0EntityCreature.posY), MathHelper.floor_double(par0EntityCreature.posZ)) + 4F;
            double d1 = par0EntityCreature.getMaximumHomeDistance() + (float)par1;
            flag1 = d < d1 * d1;
        }
        else
        {
            flag1 = false;
        }

        for (int l = 0; l < 10; l++)
        {
            int i1 = random.nextInt(2 * par1) - par1;
            int j1 = random.nextInt(2 * par2) - par2;
            int k1 = random.nextInt(2 * par1) - par1;

            if (par3Vec3 != null && (double)i1 * par3Vec3.xCoord + (double)k1 * par3Vec3.zCoord < 0.0D)
            {
                continue;
            }

            i1 += MathHelper.floor_double(par0EntityCreature.posX);
            j1 += MathHelper.floor_double(par0EntityCreature.posY);
            k1 += MathHelper.floor_double(par0EntityCreature.posZ);

            if (flag1 && !par0EntityCreature.isWithinHomeDistance(i1, j1, k1))
            {
                continue;
            }

            float f1 = par0EntityCreature.getBlockPathWeight(i1, j1, k1);

            if (f1 > f)
            {
                f = f1;
                i = i1;
                j = j1;
                k = k1;
                flag = true;
            }
        }

        if (flag)
        {
            return Vec3.getVec3Pool().getVecFromPool(i, j, k);
        }
        else
        {
            return null;
        }
    }
}
