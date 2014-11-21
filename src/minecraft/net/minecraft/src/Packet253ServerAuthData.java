package net.minecraft.src;

import java.io.*;
import java.security.PublicKey;

public class Packet253ServerAuthData extends Packet
{
    private String serverId;
    private PublicKey publicKey;
    private byte verifyToken[];

    public Packet253ServerAuthData()
    {
        verifyToken = new byte[0];
    }

    public Packet253ServerAuthData(String par1Str, PublicKey par2PublicKey, byte par3ArrayOfByte[])
    {
        verifyToken = new byte[0];
        serverId = par1Str;
        publicKey = par2PublicKey;
        verifyToken = par3ArrayOfByte;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        serverId = readString(par1DataInputStream, 20);
        publicKey = CryptManager.func_75896_a(readBytesFromStream(par1DataInputStream));
        verifyToken = readBytesFromStream(par1DataInputStream);
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeString(serverId, par1DataOutputStream);
        writeByteArray(par1DataOutputStream, publicKey.getEncoded());
        writeByteArray(par1DataOutputStream, verifyToken);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handleServerAuthData(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 2 + serverId.length() * 2 + 2 + publicKey.getEncoded().length + 2 + verifyToken.length;
    }

    public String getServerId()
    {
        return serverId;
    }

    public PublicKey getPublicKey()
    {
        return publicKey;
    }

    public byte[] getVerifyToken()
    {
        return verifyToken;
    }
}
