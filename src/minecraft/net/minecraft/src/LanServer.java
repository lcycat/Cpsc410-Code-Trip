package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class LanServer
{
    private String field_77492_a;
    private String field_77490_b;

    /** Last time this LanServer was seen. */
    private long timeLastSeen;

    public LanServer(String par1Str, String par2Str)
    {
        field_77492_a = par1Str;
        field_77490_b = par2Str;
        timeLastSeen = Minecraft.getSystemTime();
    }

    public String func_77487_a()
    {
        return field_77492_a;
    }

    public String func_77488_b()
    {
        return field_77490_b;
    }

    /**
     * Updates the time this LanServer was last seen.
     */
    public void updateLastSeen()
    {
        timeLastSeen = Minecraft.getSystemTime();
    }
}
