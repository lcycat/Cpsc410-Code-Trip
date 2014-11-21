package net.minecraft.src;

public interface IPlayerUsage
{
    public abstract void addServerStatsToSnooper(PlayerUsageSnooper playerusagesnooper);

    public abstract void addServerTypeToSnooper(PlayerUsageSnooper playerusagesnooper);

    /**
     * Returns whether snooping is enabled or not.
     */
    public abstract boolean isSnooperEnabled();
}
