package net.minecraft.src;

import java.util.*;

public class CommandHandler implements ICommandManager
{
    private final Map field_71562_a = new HashMap();
    private final Set field_71561_b = new HashSet();

    public CommandHandler()
    {
    }

    public void func_71556_a(ICommandSender par1ICommandSender, String par2Str)
    {
        if (par2Str.startsWith("/"))
        {
            par2Str = par2Str.substring(1);
        }

        String as[] = par2Str.split(" ");
        String s = as[0];
        as = func_71559_a(as);
        ICommand icommand = (ICommand)field_71562_a.get(s);

        try
        {
            if (icommand == null)
            {
                throw new CommandNotFoundException();
            }

            if (icommand.canCommandSenderUseCommand(par1ICommandSender))
            {
                icommand.processCommand(par1ICommandSender, as);
            }
            else
            {
                par1ICommandSender.func_70006_a("\247cYou do not have permission to use this command.");
            }
        }
        catch (WrongUsageException wrongusageexception)
        {
            par1ICommandSender.func_70006_a((new StringBuilder()).append("\247c").append(par1ICommandSender.translateString("commands.generic.usage", new Object[]
                    {
                        par1ICommandSender.translateString(wrongusageexception.getMessage(), wrongusageexception.func_74844_a())
                    })).toString());
        }
        catch (CommandException commandexception)
        {
            par1ICommandSender.func_70006_a((new StringBuilder()).append("\247c").append(par1ICommandSender.translateString(commandexception.getMessage(), commandexception.func_74844_a())).toString());
        }
        catch (Throwable throwable)
        {
            par1ICommandSender.func_70006_a((new StringBuilder()).append("\247c").append(par1ICommandSender.translateString("commands.generic.exception", new Object[0])).toString());
            throwable.printStackTrace();
        }
    }

    public ICommand func_71560_a(ICommand par1ICommand)
    {
        List list = par1ICommand.getCommandAliases();
        field_71562_a.put(par1ICommand.getCommandName(), par1ICommand);
        field_71561_b.add(par1ICommand);

        if (list != null)
        {
            Iterator iterator = list.iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                String s = (String)iterator.next();
                ICommand icommand = (ICommand)field_71562_a.get(s);

                if (icommand == null || !icommand.getCommandName().equals(s))
                {
                    field_71562_a.put(s, par1ICommand);
                }
            }
            while (true);
        }

        return par1ICommand;
    }

    private static String[] func_71559_a(String par0ArrayOfStr[])
    {
        String as[] = new String[par0ArrayOfStr.length - 1];

        for (int i = 1; i < par0ArrayOfStr.length; i++)
        {
            as[i - 1] = par0ArrayOfStr[i];
        }

        return as;
    }

    public List func_71558_b(ICommandSender par1ICommandSender, String par2Str)
    {
        String as[] = par2Str.split(" ", -1);
        String s = as[0];

        if (as.length == 1)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = field_71562_a.entrySet().iterator();

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }

                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();

                if (CommandBase.doesStringStartWith(s, (String)entry.getKey()) && ((ICommand)entry.getValue()).canCommandSenderUseCommand(par1ICommandSender))
                {
                    arraylist.add(entry.getKey());
                }
            }
            while (true);

            return arraylist;
        }

        if (as.length > 1)
        {
            ICommand icommand = (ICommand)field_71562_a.get(s);

            if (icommand != null)
            {
                return icommand.addTabCompletionOptions(par1ICommandSender, func_71559_a(as));
            }
        }

        return null;
    }

    public List func_71557_a(ICommandSender par1ICommandSender)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = field_71561_b.iterator();

        do
        {
            if (!iterator.hasNext())
            {
                break;
            }

            ICommand icommand = (ICommand)iterator.next();

            if (icommand.canCommandSenderUseCommand(par1ICommandSender))
            {
                arraylist.add(icommand);
            }
        }
        while (true);

        return arraylist;
    }

    public Map func_71555_a()
    {
        return field_71562_a;
    }
}
