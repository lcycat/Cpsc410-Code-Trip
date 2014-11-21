// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            ICommand, ICommandSender, NumberInvalidException, EntityPlayer, 
//            PlayerNotFoundException, IAdminCommand

public abstract class CommandBase
    implements ICommand
{

    private static IAdminCommand field_71533_a = null;

    public CommandBase()
    {
    }

    public String func_71518_a(ICommandSender p_71518_1_)
    {
        return (new StringBuilder()).append("/").append(func_71517_b()).toString();
    }

    public List func_71514_a()
    {
        return null;
    }

    public boolean func_71519_b(ICommandSender p_71519_1_)
    {
        return p_71519_1_.func_70003_b(func_71517_b());
    }

    public List func_71516_a(ICommandSender p_71516_1_, String p_71516_2_[])
    {
        return null;
    }

    public static int func_71526_a(ICommandSender p_71526_0_, String p_71526_1_)
    {
        try
        {
            return Integer.parseInt(p_71526_1_);
        }
        catch(NumberFormatException numberformatexception)
        {
            throw new NumberInvalidException("commands.generic.num.invalid", new Object[] {
                p_71526_1_
            });
        }
    }

    public static int func_71528_a(ICommandSender p_71528_0_, String p_71528_1_, int p_71528_2_)
    {
        return func_71532_a(p_71528_0_, p_71528_1_, p_71528_2_, 0x7fffffff);
    }

    public static int func_71532_a(ICommandSender p_71532_0_, String p_71532_1_, int p_71532_2_, int p_71532_3_)
    {
        int i = func_71526_a(p_71532_0_, p_71532_1_);
        if(i < p_71532_2_)
        {
            throw new NumberInvalidException("commands.generic.num.tooSmall", new Object[] {
                Integer.valueOf(i), Integer.valueOf(p_71532_2_)
            });
        }
        if(i > p_71532_3_)
        {
            throw new NumberInvalidException("commands.generic.num.tooBig", new Object[] {
                Integer.valueOf(i), Integer.valueOf(p_71532_3_)
            });
        } else
        {
            return i;
        }
    }

    public static EntityPlayer func_71521_c(ICommandSender p_71521_0_)
    {
        if(p_71521_0_ instanceof EntityPlayer)
        {
            return (EntityPlayer)p_71521_0_;
        } else
        {
            throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
        }
    }

    public static String func_71520_a(String p_71520_0_[], int p_71520_1_)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = p_71520_1_; i < p_71520_0_.length; i++)
        {
            if(i > p_71520_1_)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append(p_71520_0_[i]);
        }

        return stringbuilder.toString();
    }

    public static String func_71527_a(Object p_71527_0_[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < p_71527_0_.length; i++)
        {
            String s = p_71527_0_[i].toString();
            if(i > 0)
            {
                if(i == p_71527_0_.length - 1)
                {
                    stringbuilder.append(" and ");
                } else
                {
                    stringbuilder.append(", ");
                }
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static boolean func_71523_a(String p_71523_0_, String p_71523_1_)
    {
        return p_71523_1_.regionMatches(true, 0, p_71523_0_, 0, p_71523_0_.length());
    }

    public static List func_71530_a(String p_71530_0_[], String p_71530_1_[])
    {
        String s = p_71530_0_[p_71530_0_.length - 1];
        ArrayList arraylist = new ArrayList();
        String as[] = p_71530_1_;
        int i = as.length;
        for(int j = 0; j < i; j++)
        {
            String s1 = as[j];
            if(func_71523_a(s, s1))
            {
                arraylist.add(s1);
            }
        }

        return arraylist;
    }

    public static List func_71531_a(String p_71531_0_[], Iterable p_71531_1_)
    {
        String s = p_71531_0_[p_71531_0_.length - 1];
        ArrayList arraylist = new ArrayList();
        Iterator iterator = p_71531_1_.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if(func_71523_a(s, s1))
            {
                arraylist.add(s1);
            }
        } while(true);
        return arraylist;
    }

    public static void func_71522_a(ICommandSender p_71522_0_, String p_71522_1_, Object p_71522_2_[])
    {
        func_71524_a(p_71522_0_, 0, p_71522_1_, p_71522_2_);
    }

    public static void func_71524_a(ICommandSender p_71524_0_, int p_71524_1_, String p_71524_2_, Object p_71524_3_[])
    {
        if(field_71533_a != null)
        {
            field_71533_a.func_71563_a(p_71524_0_, p_71524_1_, p_71524_2_, p_71524_3_);
        }
    }

    public static void func_71529_a(IAdminCommand p_71529_0_)
    {
        field_71533_a = p_71529_0_;
    }

    public int func_71525_a(ICommand p_71525_1_)
    {
        return func_71517_b().compareTo(p_71525_1_.func_71517_b());
    }

    public int compareTo(Object p_compareTo_1_)
    {
        return func_71525_a((ICommand)p_compareTo_1_);
    }

}
