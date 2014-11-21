package net.minecraft.src;

import java.util.Random;

public class EntityAILookAtVillager extends EntityAIBase
{
    private EntityIronGolem theGolem;
    private EntityVillager theVillager;
    private int lookTime;

    public EntityAILookAtVillager(EntityIronGolem par1EntityIronGolem)
    {
        theGolem = par1EntityIronGolem;
        setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!theGolem.worldObj.isDaytime())
        {
            return false;
        }

        if (theGolem.getRNG().nextInt(8000) != 0)
        {
            return false;
        }
        else
        {
            theVillager = (EntityVillager)theGolem.worldObj.findNearestEntityWithinAABB(net.minecraft.src.EntityVillager.class, theGolem.boundingBox.expand(6D, 2D, 6D), theGolem);
            return theVillager != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return lookTime > 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        lookTime = 400;
        theGolem.setHoldingRose(true);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        theGolem.setHoldingRose(false);
        theVillager = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        theGolem.getLookHelper().setLookPositionWithEntity(theVillager, 30F, 30F);
        lookTime--;
    }
}
