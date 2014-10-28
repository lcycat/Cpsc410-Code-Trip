package net.minecraft.src;

public class BlockEventData
{
    private int coordX;
    private int coordY;
    private int coordZ;
    private int blockID;

    /** Different for each blockID */
    private int eventID;

    /** Different for each blockID, eventID */
    private int eventParameter;

    public BlockEventData(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        coordX = par1;
        coordY = par2;
        coordZ = par3;
        eventID = par5;
        eventParameter = par6;
        blockID = par4;
    }

    /**
     * Get the X coordinate.
     */
    public int getX()
    {
        return coordX;
    }

    /**
     * Get the Y coordinate.
     */
    public int getY()
    {
        return coordY;
    }

    /**
     * Get the Z coordinate.
     */
    public int getZ()
    {
        return coordZ;
    }

    /**
     * Get the Event ID (different for each BlockID)
     */
    public int getEventID()
    {
        return eventID;
    }

    /**
     * Get the Event Parameter (different for each BlockID,EventID)
     */
    public int getEventParameter()
    {
        return eventParameter;
    }

    /**
     * Gets the BlockID for this BlockEventData
     */
    public int getBlockID()
    {
        return blockID;
    }

    public boolean equals(Object par1Obj)
    {
        if (par1Obj instanceof BlockEventData)
        {
            BlockEventData blockeventdata = (BlockEventData)par1Obj;
            return coordX == blockeventdata.coordX && coordY == blockeventdata.coordY && coordZ == blockeventdata.coordZ && eventID == blockeventdata.eventID && eventParameter == blockeventdata.eventParameter && blockID == blockeventdata.blockID;
        }
        else
        {
            return false;
        }
    }
}
