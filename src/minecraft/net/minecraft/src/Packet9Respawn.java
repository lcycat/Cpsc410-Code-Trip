package net.minecraft.src;

import java.io.*;

public class Packet9Respawn extends Packet
{
    public int respawnDimension;

    /**
     * The difficulty setting. 0 through 3 for peaceful, easy, normal, hard. The client always sends 1.
     */
    public int difficulty;

    /** Defaults to 128 */
    public int worldHeight;
    public EnumGameType gameType;
    public WorldType terrainType;

    public Packet9Respawn()
    {
    }

    public Packet9Respawn(int par1, byte par2, WorldType par3WorldType, int par4, EnumGameType par5EnumGameType)
    {
        respawnDimension = par1;
        difficulty = par2;
        worldHeight = par4;
        gameType = par5EnumGameType;
        terrainType = par3WorldType;
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleRespawn(this);
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        respawnDimension = par1DataInputStream.readInt();
        difficulty = par1DataInputStream.readByte();
        gameType = EnumGameType.getByID(par1DataInputStream.readByte());
        worldHeight = par1DataInputStream.readShort();
        String s = readString(par1DataInputStream, 16);
        terrainType = WorldType.parseWorldType(s);

        if (terrainType == null)
        {
            terrainType = WorldType.DEFAULT;
        }
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(respawnDimension);
        par1DataOutputStream.writeByte(difficulty);
        par1DataOutputStream.writeByte(gameType.getID());
        par1DataOutputStream.writeShort(worldHeight);
        writeString(terrainType.getWorldTypeName(), par1DataOutputStream);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 8 + (terrainType != null ? terrainType.getWorldTypeName().length() : 0);
    }
}
