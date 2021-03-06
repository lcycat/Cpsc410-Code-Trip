package net.minecraft.src;

import java.io.*;

public class Packet202PlayerAbilities extends Packet
{
    /** Disables player damage. */
    private boolean disableDamage;

    /** Indicates whether the player is flying or not. */
    private boolean isFlying;

    /** Whether or not to allow the player to fly when they double jump. */
    private boolean allowFlying;

    /**
     * Used to determine if creative mode is enabled, and therefore if items should be depleted on usage
     */
    private boolean isCreativeMode;
    private float flySpeed;
    private float field_73357_f;

    public Packet202PlayerAbilities()
    {
        disableDamage = false;
        isFlying = false;
        allowFlying = false;
        isCreativeMode = false;
    }

    public Packet202PlayerAbilities(PlayerCapabilities par1PlayerCapabilities)
    {
        disableDamage = false;
        isFlying = false;
        allowFlying = false;
        isCreativeMode = false;
        setDisableDamage(par1PlayerCapabilities.disableDamage);
        setFlying(par1PlayerCapabilities.isFlying);
        setAllowFlying(par1PlayerCapabilities.allowFlying);
        setCreativeMode(par1PlayerCapabilities.isCreativeMode);
        setFlySpeed(par1PlayerCapabilities.getFlySpeed());
        setWalkSpeed(par1PlayerCapabilities.getWalkSpeed());
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        byte byte0 = par1DataInputStream.readByte();
        setDisableDamage((byte0 & 1) > 0);
        setFlying((byte0 & 2) > 0);
        setAllowFlying((byte0 & 4) > 0);
        setCreativeMode((byte0 & 8) > 0);
        setFlySpeed((float)par1DataInputStream.readByte() / 255F);
        setWalkSpeed((float)par1DataInputStream.readByte() / 255F);
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        byte byte0 = 0;

        if (getDisableDamage())
        {
            byte0 |= 1;
        }

        if (getIsFlying())
        {
            byte0 |= 2;
        }

        if (getAllowFlying())
        {
            byte0 |= 4;
        }

        if (isCreativeMode())
        {
            byte0 |= 8;
        }

        par1DataOutputStream.writeByte(byte0);
        par1DataOutputStream.writeByte((int)(flySpeed * 255F));
        par1DataOutputStream.writeByte((int)(field_73357_f * 255F));
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handlePlayerAbilities(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 2;
    }

    public boolean getDisableDamage()
    {
        return disableDamage;
    }

    /**
     * Sets whether damage is disabled or not.
     */
    public void setDisableDamage(boolean par1)
    {
        disableDamage = par1;
    }

    public boolean getIsFlying()
    {
        return isFlying;
    }

    /**
     * Sets whether we're currently flying or not.
     */
    public void setFlying(boolean par1)
    {
        isFlying = par1;
    }

    public boolean getAllowFlying()
    {
        return allowFlying;
    }

    public void setAllowFlying(boolean par1)
    {
        allowFlying = par1;
    }

    public boolean isCreativeMode()
    {
        return isCreativeMode;
    }

    public void setCreativeMode(boolean par1)
    {
        isCreativeMode = par1;
    }

    public float getFlySpeed()
    {
        return flySpeed;
    }

    /**
     * Sets the flying speed.
     */
    public void setFlySpeed(float par1)
    {
        flySpeed = par1;
    }

    /**
     * Sets the walking speed.
     */
    public void setWalkSpeed(float par1)
    {
        field_73357_f = par1;
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
