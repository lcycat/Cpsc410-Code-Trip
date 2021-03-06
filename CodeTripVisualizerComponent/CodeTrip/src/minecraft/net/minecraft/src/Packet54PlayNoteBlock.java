package net.minecraft.src;

import java.io.*;

public class Packet54PlayNoteBlock extends Packet
{
    public int xLocation;
    public int yLocation;
    public int zLocation;

    /** 1=Double Bass, 2=Snare Drum, 3=Clicks / Sticks, 4=Bass Drum, 5=Harp */
    public int instrumentType;

    /**
     * The pitch of the note (between 0-24 inclusive where 0 is the lowest and 24 is the highest).
     */
    public int pitch;

    /** The block ID this action is set for. */
    public int blockId;

    public Packet54PlayNoteBlock()
    {
    }

    public Packet54PlayNoteBlock(int par1, int par2, int par3, int par4, int par5, int par6)
    {
        xLocation = par1;
        yLocation = par2;
        zLocation = par3;
        instrumentType = par5;
        pitch = par6;
        blockId = par4;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        xLocation = par1DataInputStream.readInt();
        yLocation = par1DataInputStream.readShort();
        zLocation = par1DataInputStream.readInt();
        instrumentType = par1DataInputStream.read();
        pitch = par1DataInputStream.read();
        blockId = par1DataInputStream.readShort() & 0xfff;
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeInt(xLocation);
        par1DataOutputStream.writeShort(yLocation);
        par1DataOutputStream.writeInt(zLocation);
        par1DataOutputStream.write(instrumentType);
        par1DataOutputStream.write(pitch);
        par1DataOutputStream.writeShort(blockId & 0xfff);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleBlockEvent(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 14;
    }
}
