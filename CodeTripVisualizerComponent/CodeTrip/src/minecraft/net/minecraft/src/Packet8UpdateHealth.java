package net.minecraft.src;

import java.io.*;

public class Packet8UpdateHealth extends Packet
{
    /** Variable used for incoming health packets */
    public int healthMP;
    public int food;

    /**
     * Players logging on get a saturation of 5.0. Eating food increases the saturation as well as the food bar.
     */
    public float foodSaturation;

    public Packet8UpdateHealth()
    {
    }

    public Packet8UpdateHealth(int par1, int par2, float par3)
    {
        healthMP = par1;
        food = par2;
        foodSaturation = par3;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        healthMP = par1DataInputStream.readShort();
        food = par1DataInputStream.readShort();
        foodSaturation = par1DataInputStream.readFloat();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeShort(healthMP);
        par1DataOutputStream.writeShort(food);
        par1DataOutputStream.writeFloat(foodSaturation);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleUpdateHealth(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 8;
    }

    /**
     * only false for the abstract Packet class, all real packets return true
     */
    public boolean isRealPacket()
    {
        return true;
    }

    /**
     * eg return packet30entity.entityId == entityId; WARNING : will throw if you compare a packet to a different packet
     * class
     */
    public boolean containsSameEntityIDAs(Packet par1Packet)
    {
        return true;
    }
}
