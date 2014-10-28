package net.minecraft.src;

public class EntityAILookAtTradePlayer extends EntityAIWatchClosest
{
    private final EntityVillager theMerchant;

    public EntityAILookAtTradePlayer(EntityVillager par1EntityVillager)
    {
        super(par1EntityVillager, net.minecraft.src.EntityPlayer.class, 8F);
        theMerchant = par1EntityVillager;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (theMerchant.isTrading())
        {
            closestEntity = theMerchant.getCustomer();
            return true;
        }
        else
        {
            return false;
        }
    }
}
