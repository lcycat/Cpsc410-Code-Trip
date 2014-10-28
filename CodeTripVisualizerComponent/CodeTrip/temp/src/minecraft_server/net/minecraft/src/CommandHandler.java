// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ICommandManager, WrongUsageException, CommandException, ICommand, 
//            CommandNotFoundException, ICommandSender, CommandBase

public class CommandHandler
    implements ICommandManager
{

    private final Map field_71562_a = new HashMap();
    private final Set field_71561_b = new HashSet();

    public CommandHandler()
    {
    }

    public void func_71556_a(ICommandSender p_71556_1_, String p_71556_2_)
    {
        if(p_71556_2_.startsWith("/"))
        {
            p_71556_2_ = p_71556_2_.substring(1);
        }
        String as[] = p_71556_2_.split(" ");
        String s = as[0];
        as = func_71559_a(as);
        ICommand icommand = (ICommand)field_71562_a.get(s);
        try
        {
            if(icommand == null)
            {
                throw new CommandNotFoundException();
            }
            if(icommand.func_71519_b(p_71556_1_))
            {
                icommand.func_71515_b(p_71556_1_, as);
            } else
            {
                p_71556_1_.func_70006_a("\247cYou do not have permission to use this command.");
            }
        }
        catch(WrongUsageException wrongusageexception)
        {
            p_71556_1_.func_70006_a((new StringBuilder()).append("\247c").append(p_71556_1_.func_70004_a("commands.generic.usage", new Object[] {
                p_71556_1_.func_70004_a(wrongusageexception.getMessage(), wrongusageexception.func_74844_a())
            })).toString());
        }
        catch(CommandException commandexception)
        {
            p_71556_1_.func_70006_a((new StringBuilder()).append("\247c").append(p_71556_1_.func_70004_a(commandexception.getMessage(), commandexception.func_74844_a())).toString());
        }
        catch(Throwable throwable)
        {
            p_71556_1_.func_70006_a((new StringBuilder()).append("\247c").append(p_71556_1_.func_70004_a("commands.generic.exception", new Object[0])).toString());
            throwable.printStackTrace();
        }
    }

    public ICommand func_71560_a(ICommand p_71560_1_)
    {
        List list = p_71560_1_.func_71514_a();
        field_71562_a.put(p_71560_1_.func_71517_b(), p_71560_1_);
        field_71561_b.add(p_71560_1_);
        if(list != null)
        {
            Iterator iterator = list.iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                ICommand icommand = (ICommand)field_71562_a.get(s);
                if(icommand == null || !icommand.func_71517_b().equals(s))
                {
                    field_71562_a.put(s, p_71560_1_);
                }
            } while(true);
        }
        return p_71560_1_;
    }

    private static String[] func_71559_a(String p_71559_0_[])
    {
        String as[] = new String[p_71559_0_.length - 1];
        for(int i = 1; i < p_71559_0_.length; i++)
        {
            as[i - 1] = p_71559_0_[i];
        }

        return as;
    }

    public List func_71558_b(ICommandSender p_71558_1_, String p_71558_2_)
    {
        String as[] = p_71558_2_.split(" ", -1);
        String s = as[0];
        if(as.length == 1)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = field_71562_a.entrySet().iterator();
            do
            {
                if(!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if(CommandBase.func_71523_a(s, (String)entry.getKey()) && ((ICommand)entry.getValue()).func_71519_b(p_71558_1_))
                {
                    arraylist.add(entry.getKey());
                }
            } while(true);
            return arraylist;
        }
        if(as.length > 1)
        {
            ICommand icommand = (ICommand)field_71562_a.get(s);
            if(icommand != null)
            {
                return icommand.func_71516_a(p_71558_1_, func_71559_a(as));
            }
        }
        return null;
    }

    public List func_71557_a(ICommandSender p_71557_1_)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = field_71561_b.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            ICommand icommand = (ICommand)iterator.next();
            if(icommand.func_71519_b(p_71557_1_))
            {
                arraylist.add(icommand);
            }
        } while(true);
        return arraylist;
    }

    public Map func_71555_a()
    {
        return field_71562_a;
    }
}
