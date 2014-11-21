package net.minecraft.src;

import java.util.List;

public interface ICommand extends Comparable
{
    public abstract String getCommandName();

    public abstract String getCommandUsage(ICommandSender icommandsender);

    public abstract List getCommandAliases();

    public abstract void processCommand(ICommandSender icommandsender, String as[]);

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    public abstract boolean canCommandSenderUseCommand(ICommandSender icommandsender);

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public abstract List addTabCompletionOptions(ICommandSender icommandsender, String as[]);
}
