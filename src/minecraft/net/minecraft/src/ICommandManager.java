package net.minecraft.src;

import java.util.List;
import java.util.Map;

public interface ICommandManager
{
    public abstract void executeCommand(ICommandSender icommandsender, String s);

    /**
     * does a "begins with" string match on each token in par2. Only returns commands that par1 can use.
     */
    public abstract List getPossibleCommands(ICommandSender icommandsender, String s);

    /**
     * returns all commands that the commandSender can use
     */
    public abstract List getPossibleCommands(ICommandSender icommandsender);

    /**
     * returns a map of string to commads. All commands are returned, not just ones which someone has permission to use.
     */
    public abstract Map getCommands();
}
