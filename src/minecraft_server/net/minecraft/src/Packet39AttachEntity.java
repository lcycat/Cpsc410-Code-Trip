package net.minecraft.src;

import java.io.*;

public class Packet39AttachEntity extends Packet
{
    public int entityId;
    public int vehicleEntityId;

    public Packet39AttachEntity()
    {
    }

    public Packet39AttachEntity(Entity par1Entity, Entity par2Entity)
    {
        entityId = par1Entity.entityId;
        vehicleEntityId = par2Entity == null ? -1 : par2Entity.entityId;
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 8;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        entityId = par1DataInputStream.readInt();
        vehicleEntityId = par1DataInputStream.readInt();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(entityId);
        par1DataOutputStream.writeInt(vehicleEntityId);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleAttachEntity(this);
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet par1Packet)
    {
        Packet39AttachEntity packet39attachentity = (Packet39AttachEntity)par1Packet;
        return packet39attachentity.entityId == entityId;
    }
}
