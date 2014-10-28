package net.minecraft.src;

import java.io.*;

public class Packet2ClientProtocol extends Packet
{
    private int protocolVersion;
    private String username;
    private String serverHost;
    private int serverPort;

    public Packet2ClientProtocol()
    {
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        protocolVersion = par1DataInputStream.readByte();
        username = readString(par1DataInputStream, 16);
        serverHost = readString(par1DataInputStream, 255);
        serverPort = par1DataInputStream.readInt();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeByte(protocolVersion);
        writeString(username, par1DataOutputStream);
        writeString(serverHost, par1DataOutputStream);
        par1DataOutputStream.writeInt(serverPort);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.func_72500_a(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 3 + 2 * username.length();
    }

    /**
     * Returns the protocol version.
     */
    public int getProtocolVersion()
    {
        return protocolVersion;
    }

    /**
     * Returns the username.
     */
    public String getUsername()
    {
        return username;
    }
}
