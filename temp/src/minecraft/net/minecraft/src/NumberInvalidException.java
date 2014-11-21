// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            CommandException

public class NumberInvalidException extends CommandException
{

    public NumberInvalidException()
    {
        this("commands.generic.num.invalid", new Object[0]);
    }

    public NumberInvalidException(String p_i3255_1_, Object p_i3255_2_[])
    {
        super(p_i3255_1_, p_i3255_2_);
    }
}
