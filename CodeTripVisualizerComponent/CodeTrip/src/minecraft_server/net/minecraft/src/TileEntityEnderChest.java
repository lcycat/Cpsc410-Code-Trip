package net.minecraft.src;

import java.util.Random;

public class TileEntityEnderChest extends TileEntity
{
    /** The current angle of the chest lid (between 0 and 1) */
    public float lidAngle;

    /** The angle of the chest lid last tick */
    public float prevLidAngle;

    /** The number of players currently using this ender chest. */
    public int numUsingPlayers;

    /** Server sync counter (once per 20 ticks) */
    private int ticksSinceSync;

    public TileEntityEnderChest()
    {
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        super.updateEntity();

        if ((++ticksSinceSync % 20) * 4 == 0)
        {
            worldObj.addBlockEvent(xCoord, yCoord, zCoord, Block.enderChest.blockID, 1, numUsingPlayers);
        }

        prevLidAngle = lidAngle;
        float f = 0.1F;

        if (numUsingPlayers > 0 && lidAngle == 0.0F)
        {
            double d = (double)xCoord + 0.5D;
            double d1 = (double)zCoord + 0.5D;
            worldObj.playSoundEffect(d, (double)yCoord + 0.5D, d1, "random.chestopen", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }

        if (numUsingPlayers == 0 && lidAngle > 0.0F || numUsingPlayers > 0 && lidAngle < 1.0F)
        {
            float f1 = lidAngle;

            if (numUsingPlayers > 0)
            {
                lidAngle += f;
            }
            else
            {
                lidAngle -= f;
            }

            if (lidAngle > 1.0F)
            {
                lidAngle = 1.0F;
            }

            float f2 = 0.5F;

            if (lidAngle < f2 && f1 >= f2)
            {
                double d2 = (double)xCoord + 0.5D;
                double d3 = (double)zCoord + 0.5D;
                worldObj.playSoundEffect(d2, (double)yCoord + 0.5D, d3, "random.chestclosed", 0.5F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }

            if (lidAngle < 0.0F)
            {
                lidAngle = 0.0F;
            }
        }
    }

    /**
     * Called when a client event is received with the event number and argument, see World.sendClientEvent
     */
    public void receiveClientEvent(int par1, int par2)
    {
        if (par1 == 1)
        {
            numUsingPlayers = par2;
        }
    }

    /**
     * invalidates a tile entity
     */
    public void invalidate()
    {
        updateContainingBlockInfo();
        super.invalidate();
    }

    public void openChest()
    {
        numUsingPlayers++;
        worldObj.addBlockEvent(xCoord, yCoord, zCoord, Block.enderChest.blockID, 1, numUsingPlayers);
    }

    public void closeChest()
    {
        numUsingPlayers--;
        worldObj.addBlockEvent(xCoord, yCoord, zCoord, Block.enderChest.blockID, 1, numUsingPlayers);
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }

        return par1EntityPlayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }
}
