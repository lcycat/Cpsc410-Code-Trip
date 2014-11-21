package net.minecraft.src;

public interface IServer
{
    public abstract int getOrSetIntProperty(String s, int i);

    public abstract String getOrSetProperty(String s, String s1);

    public abstract void setArbitraryProperty(String s, Object obj);

    public abstract void saveSettingsToFile();

    public abstract String getSettingsFilePath();

    public abstract String getHostName();

    /**
     * never used. Can not be called "getServerPort" is already taken
     */
    public abstract int getMyServerPort();

    /**
     * minecraftServer.getMOTD is used in 2 places instead (it is a non-virtual function which returns the same thing)
     */
    public abstract String getServerMOTD();

    public abstract String getMinecraftVersion();

    public abstract int getPlayerListSize();

    public abstract int getMaxPlayers();

    public abstract String[] getAllUsernames();

    public abstract String getFolderName();

    /**
     * rename this when a patch comes out which uses it
     */
    public abstract String returnAnEmptyString();

    public abstract String executeCommand(String s);

    public abstract boolean doLogInfoEvent();

    public abstract void logInfoMessage(String s);

    public abstract void logWarningMessage(String s);

    public abstract void logSevereEvent(String s);

    public abstract void logInfoEvent(String s);
}
