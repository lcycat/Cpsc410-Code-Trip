package net.minecraft.src;

public interface ICommandSender
{
    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public abstract String getCommandSenderName();

    public abstract void func_70006_a(String s);

    /**
     * Returns true if the command sender is allowed to use the given command.
     */
    public abstract boolean canCommandSenderUseCommand(String s);

    /**
     * Translates and formats the given string key with the given arguments.
     */
    public abstract String translateString(String s, Object aobj[]);
}
