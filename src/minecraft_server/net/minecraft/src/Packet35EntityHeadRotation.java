package net.minecraft.src;

import java.io.*;

public class Packet35EntityHeadRotation extends Packet
{
    public int entityId;
    public byte headRotationYaw;

    public Packet35EntityHeadRotation()
    {
    }

    public Packet35EntityHeadRotation(int par1, byte par2)
    {
        entityId = par1;
        headRotationYaw = par2;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        entityId = par1DataInputStream.readInt();
        headRotationYaw = par1DataInputStream.readByte();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(entityId);
        par1DataOutputStream.writeByte(headRotationYaw);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleEntityHeadRotation(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 5;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet par1Packet)
    {
        Packet35EntityHeadRotation packet35entityheadrotation = (Packet35EntityHeadRotation)par1Packet;
        return packet35entityheadrotation.entityId == entityId;
    }

    public boolean func_73277_a_()
    {
        return true;
    }
}
