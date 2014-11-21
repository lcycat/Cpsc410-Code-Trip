package net.minecraft.src;

import java.util.*;

public abstract class CommandBase implements ICommand
{
    private static IAdminCommand theAdmin = null;

    public CommandBase()
    {
    }

    public String getCommandUsage(ICommandSender par1ICommandSender)
    {
        return (new StringBuilder()).append("/").append(getCommandName()).toString();
    }

    public List getCommandAliases()
    {
        return null;
    }

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender)
    {
        return par1ICommandSender.canCommandSenderUseCommand(getCommandName());
    }

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender par1ICommandSender, String par2ArrayOfStr[])
    {
        return null;
    }

    /**
     * Parses an int from the given string.
     */
    public static int parseInt(ICommandSender par0ICommandSender, String par1Str)
    {
        try
        {
            return Integer.parseInt(par1Str);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[]
                    {
                        par1Str
                    });
        }
    }

    /**
     * Parses an int from the given sring with a specified minimum.
     */
    public static int parseIntWithMin(ICommandSender par0ICommandSender, String par1Str, int par2)
    {
        return parseIntBounded(par0ICommandSender, par1Str, par2, 0x7fffffff);
    }

    /**
     * Parses an int from the given string within a specified bound.
     */
    public static int parseIntBounded(ICommandSender par0ICommandSender, String par1Str, int par2, int par3)
    {
        int i = parseInt(par0ICommandSender, par1Str);

        if (i < par2)
        {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[]
                    {
                        Integer.valueOf(i), Integer.valueOf(par2)
                    });
        }

        if (i > par3)
        {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[]
                    {
                        Integer.valueOf(i), Integer.valueOf(par3)
                    });
        }
        else
        {
            return i;
        }
    }

    /**
     * Returns the given ICommandSender as a EntityPlayer or throw an exception.
     */
    public static EntityPlayer getCommandSenderAsPlayer(ICommandSender par0ICommandSender)
    {
        if (par0ICommandSender instanceof EntityPlayer)
        {
            return (EntityPlayer)par0ICommandSender;
        }
        else
        {
            throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
        }
    }

    /**
     * Joins the given string array, starting with the given index, into a space seperated string.
     */
    public static String joinString(String par0ArrayOfStr[], int par1)
    {
        StringBuilder stringbuilder = new StringBuilder();

        for (int i = par1; i < par0ArrayOfStr.length; i++)
        {
            if (i > par1)
            {
                stringbuilder.append(" ");
            }

            stringbuilder.append(par0ArrayOfStr[i]);
        }

        return stringbuilder.toString();
    }

    /**
     * Joins the given string array into a "x, y, and z" seperated string.
     */
    public static String joinNiceString(Object par0ArrayOfObj[])
    {
        StringBuilder stringbuilder = new StringBuilder();

        for (int i = 0; i < par0ArrayOfObj.length; i++)
        {
            String s = par0ArrayOfObj[i].toString();

            if (i > 0)
            {
                if (i == par0ArrayOfObj.length - 1)
                {
                    stringbuilder.append(" and ");
                }
                else
                {
                    stringbuilder.append(", ");
                }
            }

            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    /**
     * Returns true if the given substring is exactly equal to the start of the given string (case insensitive).
     */
    public static boolean doesStringStartWith(String par0Str, String par1Str)
    {
        return par1Str.regionMatches(true, 0, par0Str, 0, par0Str.length());
    }

    /**
     * Returns a List of strings (chosen from the given strings) which the last word in the given string array is a
     * beginning-match for. (Tab completion).
     */
    public static List getListOfStringsMatchingLastWord(String par0ArrayOfStr[], String par1ArrayOfStr[])
    {
        String s = par0ArrayOfStr[par0ArrayOfStr.length - 1];
        ArrayList arraylist = new ArrayList();
        String as[] = par1ArrayOfStr;
        int i = as.length;

        for (int j = 0; j < i; j++)
        {
            String s1 = as[j];

            if (doesStringStartWith(s, s1))
            {
                arraylist.add(s1);
            }
        }

        return arraylist;
    }

    /**
     * Returns a List of strings (chosen from the given string iterable) which the last word in the given string array
     * is a beginning-match for. (Tab completion).
     */
    public static List getListOfStringsFromIterableMatchingLastWord(String par0ArrayOfStr[], Iterable par1Iterable)
    {
        String s = par0ArrayOfStr[par0ArrayOfStr.length - 1];
        ArrayList arraylist = new ArrayList();
        Iterator iterator = par1Iterable.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            String s1 = (String)iterator.next();

            if (doesStringStartWith(s, s1))
            {
                arraylist.add(s1);
            }
        }
        while (true);

        return arraylist;
    }

    public static void func_71522_a(ICommandSender par0ICommandSender, String par1Str, Object par2ArrayOfObj[])
    {
        func_71524_a(par0ICommandSender, 0, par1Str, par2ArrayOfObj);
    }

    public static void func_71524_a(ICommandSender par0ICommandSender, int par1, String par2Str, Object par3ArrayOfObj[])
    {
        if (theAdmin != null)
        {
            theAdmin.notifyAdmins(par0ICommandSender, par1, par2Str, par3ArrayOfObj);
        }
    }

    /**
     * Sets the static IAdminCommander.
     */
    public static void setAdminCommander(IAdminCommand par0IAdminCommand)
    {
        theAdmin = par0IAdminCommand;
    }

    /**
     * Compares the name of this command to the name of the given command.
     */
    public int compareNameTo(ICommand par1ICommand)
    {
        return getCommandName().compareTo(par1ICommand.getCommandName());
    }

    public int compareTo(Object par1Obj)
    {
        return compareNameTo((ICommand)par1Obj);
    }
}
