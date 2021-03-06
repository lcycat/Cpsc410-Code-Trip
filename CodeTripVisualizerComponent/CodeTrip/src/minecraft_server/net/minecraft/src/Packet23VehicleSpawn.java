package net.minecraft.src;

import java.io.*;

public class Packet23VehicleSpawn extends Packet
{
    /** Entity ID of the object. */
    public int entityId;

    /** The X position of the object. */
    public int xPosition;

    /** The Y position of the object. */
    public int yPosition;

    /** The Z position of the object. */
    public int zPosition;

    /**
     * Not sent if the thrower entity ID is 0. The speed of this fireball along the X axis.
     */
    public int speedX;

    /**
     * Not sent if the thrower entity ID is 0. The speed of this fireball along the Y axis.
     */
    public int speedY;

    /**
     * Not sent if the thrower entity ID is 0. The speed of this fireball along the Z axis.
     */
    public int speedZ;

    /** The type of object. */
    public int type;

    /** 0 if not a fireball. Otherwise, this is the Entity ID of the thrower. */
    public int throwerEntityId;

    public Packet23VehicleSpawn()
    {
    }

    public Packet23VehicleSpawn(Entity par1Entity, int par2)
    {
        this(par1Entity, par2, 0);
    }

    public Packet23VehicleSpawn(Entity par1Entity, int par2, int par3)
    {
        entityId = par1Entity.entityId;
        xPosition = MathHelper.floor_double(par1Entity.posX * 32D);
        yPosition = MathHelper.floor_double(par1Entity.posY * 32D);
        zPosition = MathHelper.floor_double(par1Entity.posZ * 32D);
        type = par2;
        throwerEntityId = par3;

        if (par3 > 0)
        {
            double d = par1Entity.motionX;
            double d1 = par1Entity.motionY;
            double d2 = par1Entity.motionZ;
            double d3 = 3.8999999999999999D;

            if (d < -d3)
            {
                d = -d3;
            }

            if (d1 < -d3)
            {
                d1 = -d3;
            }

            if (d2 < -d3)
            {
                d2 = -d3;
            }

            if (d > d3)
            {
                d = d3;
            }

            if (d1 > d3)
            {
                d1 = d3;
            }

            if (d2 > d3)
            {
                d2 = d3;
            }

            speedX = (int)(d * 8000D);
            speedY = (int)(d1 * 8000D);
            speedZ = (int)(d2 * 8000D);
        }
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        entityId = par1DataInputStream.readInt();
        type = par1DataInputStream.readByte();
        xPosition = par1DataInputStream.readInt();
        yPosition = par1DataInputStream.readInt();
        zPosition = par1DataInputStream.readInt();
        throwerEntityId = par1DataInputStream.readInt();

        if (throwerEntityId > 0)
        {
            speedX = par1DataInputStream.readShort();
            speedY = par1DataInputStream.readShort();
            speedZ = par1DataInputStream.readShort();
        }
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(entityId);
        par1DataOutputStream.writeByte(type);
        par1DataOutputStream.writeInt(xPosition);
        par1DataOutputStream.writeInt(yPosition);
        par1DataOutputStream.writeInt(zPosition);
        par1DataOutputStream.writeInt(throwerEntityId);

        if (throwerEntityId > 0)
        {
            par1DataOutputStream.writeShort(speedX);
            par1DataOutputStream.writeShort(speedY);
            par1DataOutputStream.writeShort(speedZ);
        }
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleVehicleSpawn(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 21 + throwerEntityId <= 0 ? 0 : 6;
    }
}
