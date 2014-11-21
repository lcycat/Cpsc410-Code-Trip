package net.minecraft.src;

import java.io.*;

public class Packet204ClientInfo extends Packet
{
    private String field_73468_a;
    private int field_73466_b;
    private int field_73467_c;
    private boolean field_73464_d;
    private int field_73465_e;

    public Packet204ClientInfo()
    {
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        field_73468_a = readString(par1DataInputStream, 7);
        field_73466_b = par1DataInputStream.readByte();
        byte byte0 = par1DataInputStream.readByte();
        field_73467_c = byte0 & 7;
        field_73464_d = (byte0 & 8) == 8;
        field_73465_e = par1DataInputStream.readByte();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        writeString(field_73468_a, par1DataOutputStream);
        par1DataOutputStream.writeByte(field_73466_b);
        par1DataOutputStream.writeByte(field_73467_c | (field_73464_d ? 1 : 0) << 3);
        par1DataOutputStream.writeByte(field_73465_e);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.func_72504_a(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 0;
    }

    public String func_73459_d()
    {
        return field_73468_a;
    }

    public int func_73461_f()
    {
        return field_73466_b;
    }

    public int func_73463_g()
    {
        return field_73467_c;
    }

    public boolean func_73460_h()
    {
        return field_73464_d;
    }

    public int func_73462_i()
    {
        return field_73465_e;
    }

    public boolean func_73278_e()
    {
        return true;
    }

    public boolean func_73268_a(Packet par1Packet)
    {
        return true;
    }
}
